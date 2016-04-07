package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalTipoGestiClienData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCalTipoGestionClienteBean implements SessionBean {
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

    public Hashtable guardarTipoGestionCliente(CalTipoGestiClienData calTipoGestiClien, 
                                               Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCalTipoGestionClienteBean.guardarTipoGestionCliente(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCalTipoGestionCliente dao = new DAOCalTipoGestionCliente();
        UtilidadesLog.info("MONCalTipoGestionClienteBean.guardarTipoGestionCliente(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarTipoGestionCliente(calTipoGestiClien, localizationLabels, userProperties);
    }

    public Vector query(CalTipoGestiClienData calTipoGestiClienFrom, 
                        CalTipoGestiClienData calTipoGestiClienTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCalTipoGestionClinteBean.query(CalTipoGestiClienData calTipoGestiClienFrom, CalTipoGestiClienData calTipoGestiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCalTipoGestionCliente dao = new DAOCalTipoGestionCliente();
        UtilidadesLog.info("MONCalTipoGestionClinteBean.query(CalTipoGestiClienData calTipoGestiClienFrom, CalTipoGestiClienData calTipoGestiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(calTipoGestiClienFrom, calTipoGestiClienTo, userProperties, pageCount, pageSize);
    }

    public void update(CalTipoGestiClienData calTipoGestiClien, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCalTipoGestionClienteBean.update(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels): Entrada");
        DAOCalTipoGestionCliente dao = new DAOCalTipoGestionCliente();
        dao.update(calTipoGestiClien, localizationLabels);
        UtilidadesLog.info("MONCalTipoGestionClienteBean.update(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels): Salida");               
    }

    public void remove(Vector calTipoGestiClien) throws MareException {
        UtilidadesLog.info("MONCalTipoGestionClienteBean.remove(Vector calTipoGestionCliente): Entrada");
        DAOCalTipoGestionCliente dao = new DAOCalTipoGestionCliente();
        dao.remove(calTipoGestiClien);
        UtilidadesLog.info("MONCalTipoGestionClienteBean.remove(Vector calTipoGestionCliente): Salida");
    }
}
