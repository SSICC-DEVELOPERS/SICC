package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgParamMensaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONParametrosMensajeBean implements SessionBean {
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

    public Vector query(MsgParamMensaData msgParamMensaFrom, 
                        MsgParamMensaData msgParamMensaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
                        
    {   UtilidadesLog.info("MONParamMensa.query(MsgParamMensaData msgParamMensaFrom, MsgParamMensaData msgParamMensaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
        DAOParametrosMensaje dao = new DAOParametrosMensaje();
    
        UtilidadesLog.info("MONParamMensa.query(MsgParamMensaData msgParamMensaFrom, MsgParamMensaData msgParamMensaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
        return dao.query(msgParamMensaFrom, msgParamMensaTo, userProperties, pageCount, pageSize);
    }
    
    

    public void update(MsgParamMensaData msgParamMensa, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONMsgParametrosMensaje.update(MsgParamMensaData msgParamMensa, Vector localizationLabels):Entrada ");
        DAOParametrosMensaje dao = new DAOParametrosMensaje();
    
        dao.update(msgParamMensa, localizationLabels);
    
    UtilidadesLog.info("MONParametrosMensaje.update(MsgParamMensaData msgParamMensa, Vector localizationLabels):Entrada ");
    
    
    }
}
