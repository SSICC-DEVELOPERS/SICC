package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedClaseSolicData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONClaseSolicitudBean implements SessionBean {
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

    public Hashtable guardarClaseSolicitud(PedClaseSolicData pedClaseSolic, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONClaseSolicitudBean(PedClaseSolicData pedClaseSolic, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOClaseSolicitud dao = new DAOClaseSolicitud();
        UtilidadesLog.info("MONClaseSolicitudBean(PedClaseSolicData pedClaseSolic, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarClaseSoliciud(pedClaseSolic, localizationLabels, userProperties);
    }

    public Vector query(PedClaseSolicData pedClaseSolicFrom, 
                        PedClaseSolicData pedClaseSolicTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONClaseSolicitudBean(PedClaseSolicData pedClaseSolicFrom, PedClaseSolicData pedClaseSolicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOClaseSolicitud dao = new DAOClaseSolicitud();
        UtilidadesLog.info("MONClaseSolicitudBean(PedClaseSolicData pedClaseSolicFrom, PedClaseSolicData pedClaseSolicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        return dao.query(pedClaseSolicFrom, pedClaseSolicTo, userProperties, pageCount, pageSize);
    }

    public void update(PedClaseSolicData pedClaseSolic, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONClaseSolicitudBean.update(PedClaseSolicData pedClaseSolic, Vector localizationLabels): Entrada");
        DAOClaseSolicitud dao = new DAOClaseSolicitud();
        dao.update(pedClaseSolic, localizationLabels);
        UtilidadesLog.info("MONClaseSolicitudBean.update(PedClaseSolicData pedClaseSolic, Vector localizationLabels): Salida");                
    }

    public void remove(Vector entities) throws MareException {
        UtilidadesLog.info("MONClaseSolicitudBean.remove(Vector pedClaseSolic): Entrada");
        DAOClaseSolicitud dao = new DAOClaseSolicitud();
        dao.remove(entities);
        UtilidadesLog.info("MONClaseSolicitudBean.remove(Vector pedClaseSolic): Salida");
    }
}
