package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalTipoEstadContaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCalTipoEstadoContactoBean implements SessionBean {
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

    public Hashtable guardarTipoEstadoContacto(CalTipoEstadContaData calTipoEstadConta, 
                                               Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCalTipoEstadoContacto.guardarTipoEstadoContacto(CalTipoEstadContaData calTipoEstadConta, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCalTipoEstadoContacto dao = new DAOCalTipoEstadoContacto();
        UtilidadesLog.info("MONCalTipoEstadoContacto.guardarTipoEstadoContacto(CalTipoEstadContaData calTipoEstadConta, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarTipoEstadoContacto(calTipoEstadConta, localizationLabels, userProperties);
    }

    public Vector query(CalTipoEstadContaData calTipoEstadContaFrom, 
                        CalTipoEstadContaData calTipoEstadContaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCalTipoEstadoCOntacto.query(CalTipoEstadContaData calTipoEstadContaFrom, CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCalTipoEstadoContacto dao = new DAOCalTipoEstadoContacto();
        UtilidadesLog.info("MONCalTipoEstadoCOntacto.query(CalTipoEstadContaData calTipoEstadContaFrom, CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(calTipoEstadContaFrom, calTipoEstadContaTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector calTipoEstadConta) throws MareException {
        UtilidadesLog.info("MONCalTipoEstadoContacto.remove(Vector calEstadConta): Entrada");
        DAOCalTipoEstadoContacto dao = new DAOCalTipoEstadoContacto();
        dao.remove(calTipoEstadConta);
        UtilidadesLog.info("MONCalTipoEstadoContacto.remove(Vector calEstadConta): Entrada"); 
    }

    public void update(CalTipoEstadContaData calTipoEstadConta, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCalTipoEstadoContacto.update(CalTipoEstadContaData calTipoEstadConta, Vector localizationLabels): Entrada");
        DAOCalTipoEstadoContacto dao = new DAOCalTipoEstadoContacto();
        dao.update(calTipoEstadConta, localizationLabels);
        UtilidadesLog.info("MONCalTipoEstadoContacto.update(CalTipoEstadContaData calTipoEstadConta, Vector localizationLabels): Entrada");                 
    }
}
