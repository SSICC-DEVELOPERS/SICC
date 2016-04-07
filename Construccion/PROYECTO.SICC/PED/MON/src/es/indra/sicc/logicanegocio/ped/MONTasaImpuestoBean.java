package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedTasaImpueData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTasaImpuestoBean implements SessionBean {
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

    public Hashtable guardarTasaImpuesto(PedTasaImpueData pedTasaImpue, 
                                         Vector localizationLabels, HashMap userProperties) throws MareException {
           UtilidadesLog.info("MONTasaImpuestosBean.guardarTasaImpuestos(PedTasaImpueData pedTasaImpue, Vector localizationLabels, HashMap userProperties): Entrada");
           DAOTasaImpuesto dao = new DAOTasaImpuesto();
           UtilidadesLog.info("MONTasaImpuestosBean.guardarTasaImpuestos(PedTasaImpueData pedTasaImpue, Vector localizationLabels, HashMap userProperties): Salida");
           return dao.guardarTasaImpuesto(pedTasaImpue, localizationLabels,userProperties);
    }

    public Vector query(PedTasaImpueData pedTasaImpueFrom, 
                        PedTasaImpueData pedTasaImpueTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
           UtilidadesLog.info("MONTasaImpuestosBean.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
           DAOTasaImpuesto dao = new DAOTasaImpuesto();
           UtilidadesLog.info("MONTasaImpuestosBean.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return dao.query(pedTasaImpueFrom, pedTasaImpueTo, userProperties, pageCount, pageSize);
    }

    public void update(PedTasaImpueData pedTasaImpue, 
                       Vector localizationLabels) throws MareException {
           UtilidadesLog.info("MONTasaImpuestosBean.update(PedTasaImpueData pedTasaImpue, Vector localizationLabels): Entrada");
           DAOTasaImpuesto dao = new DAOTasaImpuesto();
           dao.update(pedTasaImpue, localizationLabels);
           UtilidadesLog.info("MONTasaImpuestosBean.update(PedTasaImpueData pedTasaImpue, Vector localizationLabels): Salida");            
    }

    public void remove(Vector entities) throws MareException {
          UtilidadesLog.info("MONTasaImpuestosBean.remove(Vector pedTasaFrom): Entrada ");
          DAOTasaImpuesto dao = new DAOTasaImpuesto();
          dao.remove(entities);
          UtilidadesLog.info("MONTasaImpuestosBean.remove(Vector pedTasaFrom): Salida ");
    }
}
