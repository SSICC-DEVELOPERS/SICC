package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalMotivContaData;
import es.indra.belcorp.mso.CalMotivTipoClienData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCalMotivContaTipoClienteBean implements SessionBean {
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

    public Vector query(CalMotivContaData calMotivContaFrom, 
                        CalMotivContaData calMotivContaTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCalMotivContaTipoCliente.query(CalMotivContaData calMotivContaFrom, CalMotivContaData calMotivContaTo, HashMap userProperties): Entrada");
        DAOCalMotivContaTipoCliente dao = new DAOCalMotivContaTipoCliente();
        UtilidadesLog.info("MONCalMotivContaTipoCliente.query(CalMotivContaData calMotivContaFrom, CalMotivContaData calMotivContaTo, HashMap userProperties): Salida");
        return dao.query(calMotivContaFrom, calMotivContaTo, userProperties);
    }

    public Hashtable guardarMotivContaTipoCliente(CalMotivTipoClienData calMotivTipoClien, 
                                                  Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCalMotivContaContaTipoCLiente.guardarMotivContaTipoCliente(CalMotivTipoClienData calMotivTipoClien, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCalMotivContaTipoCliente dao = new DAOCalMotivContaTipoCliente();
        UtilidadesLog.info("MONCalMotivContaContaTipoCLiente.guardarMotivContaTipoCliente(CalMotivTipoClienData calMotivTipoClien, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarMotivContaTipoClient(calMotivTipoClien, localizationLabels, userProperties);
    }

    public Vector query(CalMotivTipoClienData calMotivTipoClienFrom, 
                        CalMotivTipoClienData calMotivTipoClienTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCalMotivContaTipoCliente.query(CalMotivTipoClienData calMotivTipoClienFrom, CalMotivTipoClienData calMotivTipoClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada"); 
        DAOCalMotivContaTipoCliente dao = new DAOCalMotivContaTipoCliente();
        UtilidadesLog.info("MONCalMotivContaTipoCliente.query(CalMotivTipoClienData calMotivTipoClienFrom, CalMotivTipoClienData calMotivTipoClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida"); 
        return dao.query(calMotivTipoClienFrom, calMotivTipoClienTo, userProperties, pageCount,  pageSize);
    }

    public void remove(Vector calMotivTipoClien) throws MareException {
        UtilidadesLog.info("MONCalMotivContaTipoCliente.remove(Vector calMotivCliente): Entrada");
        DAOCalMotivContaTipoCliente dao = new DAOCalMotivContaTipoCliente();
        dao.remove(calMotivTipoClien);
        UtilidadesLog.info("MONCalMotivContaTipoCliente.remove(Vector calMotivCliente): Salida");
    }
}
