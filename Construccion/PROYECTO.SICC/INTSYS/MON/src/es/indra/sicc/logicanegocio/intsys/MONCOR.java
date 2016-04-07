package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.intsys.DTOCORRecepcionar;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public interface MONCOR extends EJBObject 
{
    DTOSalidaBatch recepcionarSeguimientoPedidosBatch(DTOCORRecepcionar dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarSeguimientoPedidos(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recibirConfirmacionRepartoBatch(DTOCORRecepcionar dtoe) throws MareException, RemoteException;

    DTOSalidaBatch recibirConfirmacionReparto(DTOBatch dtoe) throws RemoteException, MareException;

    //DTOSalidaBatch recepcionarSeguimientoPedidos(DTOBatch dtoe) throws RemoteException, MareException;
}