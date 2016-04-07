package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalAtribEstadContaData;
import es.indra.belcorp.mso.CalTipoEstadContaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCalAtributoEstadoContactosBean implements SessionBean {
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

    public Hashtable guardarAtributoEstadoContactos(CalAtribEstadContaData calAtribEstadConta, 
                                                    Vector localizationLabels, HashMap userProperties) throws MareException {
     UtilidadesLog.info("MONCalAtributoEstadoContactosBean.guardarAtributoEstadoContactos(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels, HashMap userProperties): Entrada");
     DAOCalAtrubutoEstadoContacotos dao = new DAOCalAtrubutoEstadoContacotos(); 
     UtilidadesLog.info("MONCalAtributoEstadoContactosBean.guardarAtributoEstadoContactos(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels, HashMap userProperties): Salida");
     return dao.guardarAtributosEstadoContactos(calAtribEstadConta, localizationLabels, userProperties);   
    }

    public Vector query(CalAtribEstadContaData calAtribEstadContaFrom, 
                        CalAtribEstadContaData calAtribEstadContaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
      UtilidadesLog.info("MONCalAtributoEstadoContactosBean.query(CalAtribEstadContaData calAtribEstadContaFrom, \n" + 
      "                        CalAtribEstadContaData calAtribEstadContaTo, \n" + 
      "                        HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCalAtrubutoEstadoContacotos dao = new DAOCalAtrubutoEstadoContacotos(); 
        UtilidadesLog.info("MONCalAtributoEstadoContactosBean.query(CalAtribEstadContaData calAtribEstadContaFrom, \n" + 
        "                        CalAtribEstadContaData calAtribEstadContaTo, \n" + 
        "                        HashMap userProperties, Integer pageCount, Integer pageSize): Salida");      
      return dao.query(calAtribEstadContaFrom, calAtribEstadContaTo, userProperties, pageCount, pageSize); 
    }

    public Vector query(CalTipoEstadContaData calTipoEstadContaFrom, 
                        CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCalAtributoEstadoContactosBean.query(CalTipoEstadContaData calTipoEstadContaFrom, CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties): Entrada");
        DAOCalAtrubutoEstadoContacotos dao = new DAOCalAtrubutoEstadoContacotos(); 
        UtilidadesLog.info("MONCalAtributoEstadoContactosBean.query(CalTipoEstadContaData calTipoEstadContaFrom, CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties): Salida");
        return dao.query(calTipoEstadContaFrom, calTipoEstadContaTo, userProperties);
    }

    public void update(CalAtribEstadContaData calAtribEstadConta, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCalAtributoEstadoContacotosBean.update(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels): Entrada");                  
        DAOCalAtrubutoEstadoContacotos dao = new DAOCalAtrubutoEstadoContacotos(); 
        dao.update(calAtribEstadConta, localizationLabels);
        UtilidadesLog.info("MONCalAtributoEstadoContacotosBean.update(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels): Salida");               
    }

    public void remove(Vector calAtribEstadConta) throws MareException {
        UtilidadesLog.info("DAOCalAtributoEstadoContactosBean.remove(Vector calAtribEstadoContactos): Entrada");
        DAOCalAtrubutoEstadoContacotos dao = new DAOCalAtrubutoEstadoContacotos(); 
        dao.remove(calAtribEstadConta);
        UtilidadesLog.info("DAOCalAtributoEstadoContactosBean.remove(Vector calAtribEstadoContactos): Salida");
    }
}
