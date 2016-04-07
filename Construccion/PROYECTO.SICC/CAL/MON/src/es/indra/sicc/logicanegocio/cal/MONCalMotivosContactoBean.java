package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalMotivContaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCalMotivosContactoBean implements SessionBean {
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

    public Hashtable guardarMotivosContacto(CalMotivContaData calMotivConta, 
                                            Vector localizationLabels, HashMap userProperties) throws MareException {
       UtilidadesLog.info("MONCalMotivosContacto.guardarCalMotivosContacto(CalMotivContaData calMotivConta, Vector localizationLabels, HashMap userProperties): Entrada");
       DAOCalMotivosContacto dao = new DAOCalMotivosContacto();
       UtilidadesLog.info("MONCalMotivosContacto.guardarCalMotivosContacto(CalMotivContaData calMotivConta, Vector localizationLabels, HashMap userProperties): Salida");
       return dao.guardarMotivosContaco(calMotivConta, localizationLabels, userProperties);
    }

    public Vector query(CalMotivContaData calMotivContaFrom, 
                        CalMotivContaData calMotivContaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
       UtilidadesLog.info("MONCalMotivosContacto.query(CalMotivContaData calMotivContaFrom, CalMotivContaData calMotivContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
       DAOCalMotivosContacto dao = new DAOCalMotivosContacto();
       UtilidadesLog.info("MONCalMotivosContacto.query(CalMotivContaData calMotivContaFrom, CalMotivContaData calMotivContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
       return dao.query(calMotivContaFrom, calMotivContaTo, userProperties, pageCount, pageSize);
    }

    public void update(CalMotivContaData calMotivConta, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCalMotivosContacto.upadte(CalMotivContaData calMotivConta, Vector localizationLabels): Entrada");
        DAOCalMotivosContacto dao = new DAOCalMotivosContacto();
        dao.update(calMotivConta, localizationLabels);
        UtilidadesLog.info("MONCalMotivosContacto.upadte(CalMotivContaData calMotivConta, Vector localizationLabels): Salida");               
    }

    public void remove(Vector calMotivConta) throws MareException {
    
        UtilidadesLog.info("MONCalMotivosContactos.remove(Vector calMotivoContactos): Entrada");
        DAOCalMotivosContacto dao = new DAOCalMotivosContacto();
        dao.remove(calMotivConta);
        UtilidadesLog.info("MONCalMotivosContactos.remove(Vector calMotivoContactos): Salida");  
    
    }
}
