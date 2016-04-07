package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgMedioEnvioData;
import es.indra.belcorp.mso.MsgMedioEnvioPaisData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMedioEnvioBean implements SessionBean {
    private SessionContext _context;

    public void ejbCreate() {
    }

    public void setSessionContext(SessionContext context) throws EJBException {
        _context = context;
    }

    public void ejbRemove() throws EJBException {
    }

    public void ejbActivate() throws EJBException {
    }

    public void ejbPassivate() throws EJBException {
    }

    public Vector query(MsgMedioEnvioPaisData msgMedioEnvioPaisFrom, 
                        MsgMedioEnvioPaisData msgMedioEnvioPaisTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
                        
    {   UtilidadesLog.info(" MONMedioEnvio.queryMsgMedioEnvioPaisData msgMedioEnvioPaisFrom, MsgMedioEnvioPaisData msgMedioEnvioPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
       DAOMedioEnvio dao = new DAOMedioEnvio(); 
        
        UtilidadesLog.info(" MONMedioEnvio.queryMsgMedioEnvioPaisData msgMedioEnvioPaisFrom, MsgMedioEnvioPaisData msgMedioEnvioPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");   
        
        return dao.query(msgMedioEnvioPaisFrom, msgMedioEnvioPaisTo, userProperties, pageCount, pageSize);
    
    
    }

    public Vector query(MsgMedioEnvioData msgMedioEnvioFrom, 
                        MsgMedioEnvioData msgMedioEnvioTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info(" MONMedioEnvio.query(MsgMedioEnvioData msgMedioEnvioFrom, MsgMedioEnvioData msgMedioEnvioTo, HashMap userProperties): Entrada");
        DAOMedioEnvio dao = new DAOMedioEnvio();
       
        UtilidadesLog.info(" MONMedioEnvio.query(MsgMedioEnvioData msgMedioEnvioFrom, MsgMedioEnvioData msgMedioEnvioTo, HashMap userProperties): Salida");
        return dao.query(msgMedioEnvioFrom, msgMedioEnvioTo, userProperties );
    
    }

    public void update(MsgMedioEnvioPaisData msgMedioEnvioPais, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info(" MONMedioEnvio.updateMsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels):Entrada");
        DAOMedioEnvio dao = new DAOMedioEnvio(); 
        dao.update(msgMedioEnvioPais, localizationLabels);
        UtilidadesLog.info(" MONMedioEnvio.updateMsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels):Salida");
    }
    

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info(" MONMedioEnvio.updateMsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels):Entrada");
        DAOMedioEnvio dao = new DAOMedioEnvio(); 
        dao.remove(entities);
        UtilidadesLog.info(" MONMedioEnvio.updateMsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels):Salida");
    }

    public Hashtable guardarMedioEnvio(MsgMedioEnvioPaisData msgMedioEnvioPais, 
                                       Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info(" MONMedioEnvio.guardarMedioEnvio(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOMedioEnvio dao = new DAOMedioEnvio();
     
        UtilidadesLog.info(" MONMedioEnvio.guardarMedioEnvio(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarMedioEnvio(msgMedioEnvioPais, localizationLabels, userProperties );
    
    }
}
