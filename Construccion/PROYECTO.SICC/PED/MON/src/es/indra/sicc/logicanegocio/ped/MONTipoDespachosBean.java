package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedTipoDespaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoDespachosBean implements SessionBean {
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

    public Hashtable guardarTipoDespacho(PedTipoDespaData pedTipoDespa, 
                                         Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONTipoDespachoBean.guardarTipoDespacho(PedTipoDespaData pedTipoDespa, Vector localizationLabels, HashMap userProperties): Entrada");
            DAOTipoDespacho dao = new DAOTipoDespacho();
            UtilidadesLog.info("MONTipoDespachoBean.guardarTipoDespacho(PedTipoDespaData pedTipoDespa, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarTipoDespacho( pedTipoDespa, localizationLabels, userProperties);
    }

    public Vector query(PedTipoDespaData pedTipoDespaFrom, 
                        PedTipoDespaData pedTipoDespaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONTipoDespachoBean.query(PedTipoDespaData pedTipoDespaFrom, PedTipoDespaData pedTipoDespaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada ");
            DAOTipoDespacho dao = new DAOTipoDespacho();
            UtilidadesLog.info("MONTipoDespachoBean.query(PedTipoDespaData pedTipoDespaFrom, PedTipoDespaData pedTipoDespaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida ");
            return dao.query(pedTipoDespaFrom, pedTipoDespaTo, userProperties, pageCount, pageSize);
    }

    public void update(PedTipoDespaData pedTipoDespa, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONTipoDespachoBean.update(PedTipoDespaData pedTipoDespa, Vector localizationLabels): Entrada ");
            DAOTipoDespacho dao = new DAOTipoDespacho();
            dao.update(pedTipoDespa, localizationLabels);
            UtilidadesLog.info("MONTipoDespachoBean.update(PedTipoDespaData pedTipoDespa, Vector localizationLabels): Salida ");           
    }

    public void remove(Vector entities) throws MareException {
            UtilidadesLog.info("MONTipoDespachoBean.remove(Vector pedTipoDespaFrom): Entrada");
            DAOTipoDespacho dao = new DAOTipoDespacho();
            dao.remove(entities);
            UtilidadesLog.info("MONTipoDespachoBean.remove(Vector pedTipoDespaFrom): Entrada");
    }
}
