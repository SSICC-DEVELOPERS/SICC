package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoTransData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCccTipoTransaccionBean implements SessionBean {
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

    public Hashtable guardarTipoTransaccion(CccTipoTransData cccTipoTrans, 
                                            Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCccTipoTransaccionBean.guardarTipoTransaccion(CccTipoTransData cccTipoTrans, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCccTipoTransaccion dao = new DAOCccTipoTransaccion();
        UtilidadesLog.info("MONCccTipoTransaccionBean.guardarTipoTransaccion(CccTipoTransData cccTipoTrans, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarTipoTransaccion(cccTipoTrans, localizationLabels, userProperties);
    }

    public Vector query(CccTipoTransData cccTipoTransFrom, 
                        CccTipoTransData cccTipoTransTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCccTipoTransaccionBean.query(CccTipoTransData cccTipoTransFrom, CccTipoTransData cccTipoTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCccTipoTransaccion dao = new DAOCccTipoTransaccion();    
        UtilidadesLog.info("MONCccTipoTransaccionBean.query(CccTipoTransData cccTipoTransFrom, CccTipoTransData cccTipoTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cccTipoTransFrom, cccTipoTransTo, userProperties, pageCount, pageSize);
    }

    public void update(CccTipoTransData cccTipoTrans, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCccTipoTransaccion.update(CccTipoTransData cccTipoTrans, Vector localizationLabels): Entrada");
        DAOCccTipoTransaccion dao = new DAOCccTipoTransaccion();    
        dao.update(cccTipoTrans, localizationLabels);
        UtilidadesLog.info("MONCccTipoTransaccion.update(CccTipoTransData cccTipoTrans, Vector localizationLabels): Salida");               
    }

    public void remove(Vector cccTipoTrans) throws MareException {
        UtilidadesLog.info("MONCccTipoTransaccion.remove(Vector cccTipoTransaccion): Entrada ");
        DAOCccTipoTransaccion dao = new DAOCccTipoTransaccion();    
        dao.remove(cccTipoTrans);
        UtilidadesLog.info("MONCccTipoTransaccion.remove(Vector cccTipoTransaccion): Salida ");
    }
}
