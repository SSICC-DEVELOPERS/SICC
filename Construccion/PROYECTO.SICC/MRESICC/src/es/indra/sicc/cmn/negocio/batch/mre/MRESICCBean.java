package es.indra.sicc.cmn.negocio.batch.mre;

import es.indra.mare.common.mre.ExternalMessage;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocal;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.batch.util.ConfigFactory;
import es.indra.sicc.util.UtilidadesLog;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class MRESICCBean
    implements MessageDrivenBean, MessageListener
{

    private MessageDrivenContext ctx;
    private static UtilidadesLog logAux = new UtilidadesLog();

    public MRESICCBean()
    {
    }

    public void setMessageDrivenContext(MessageDrivenContext context)
    {
        ctx = context;
    }

    public void ejbCreate()
        throws CreateException, EJBException
    {
    }

    public void ejbRemove()
        throws EJBException
    {
    }

    private void onError(Throwable e)
    {
        e.printStackTrace();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        UtilidadesLog.error("[BATCH] Error al procesar mensaje: " + sw.toString());
    }

    public void onMessage(Message msg)
    {
        //doliva -- cambio Optimizacion Logs -- 24/03/2010
        if(logAux.isInfoEnabled()) { 
            UtilidadesLog.info("[BATCH] MRESICC.onMessage(" + msg + ")");
        }
        DTOBatch dto = null;
        MONBatchEJBLocal monBatch = null;
        try
        {
            monBatch = BatchUtil.getMonBatch();
            ExternalMessage message = (ExternalMessage)((ObjectMessage)msg).getObject();
            //doliva -- cambio Optimizacion Logs -- 24/03/2010
            if(logAux.isInfoEnabled()) { 
                UtilidadesLog.info("[BATCH] Comienza la ejecucion de: " + message.getBusinessId().getBusinessID());
            }
            dto = (DTOBatch)message.getDto();
            monBatch.setEstadoEjecucionBatch(dto.getProcessID(), ConfigFactory.getBatchConfig().getServer(), Thread.currentThread().getName());
            DTOSalidaBatch dtoSalida = (DTOSalidaBatch)BatchUtil.executeMLN(dto, message.getBusinessId());
            monBatch.setEstadoFinBatch(dto.getProcessID(), false, new Integer(dtoSalida.getCodigo()), dtoSalida.getMensaje());
            //doliva -- cambio Optimizacion Logs -- 24/03/2010
            if(logAux.isInfoEnabled()) { 
                UtilidadesLog.info("[BATCH] Resultado: " + dtoSalida);
            }
        }
        catch(Exception e)
        {
            try
            {
                UtilidadesLog.error("[BATCH] El proceso de negocio " + dto.getProcessID() + " ha terminado con error.");
                UtilidadesLog.error("Excepcion: ", e);
                monBatch.setEstadoFinBatch(dto.getProcessID(), true, new Integer(1), "Terminado con error: " + e);
            }
            catch(Exception ex)
            {
                onError(ex);
            }
        }
    }
}
