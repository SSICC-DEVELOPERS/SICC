package es.indra.sicc.logicanegocio.app;

import es.indra.belcorp.mso.AppRutasTransData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONAppRutasTransporteBean implements SessionBean {
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

    public Hashtable guardarRutasTransporte(AppRutasTransData appRutasTrans, 
                                            Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONAppRutasTransporte.guardarRutasTransporte(AppRutasTransData appRutasTrans, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOAppRutasTransporte dao = new DAOAppRutasTransporte();
        UtilidadesLog.info("DAOAppRutasTransporte.guardarRutasTransporte(AppRutasTransData appRutasTrans, Vector localizationLabels, HashMap userProperties): Salida");   
        return dao.guaradarRutasTransporte(appRutasTrans, localizationLabels, userProperties);
    }

    public Vector query(AppRutasTransData appRutasTransFrom, 
                        AppRutasTransData appRutasTransTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONAppRutasTransporte.query(AppRutasTransData appRutasTransFrom, AppRutasTransData appRutasTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOAppRutasTransporte dao = new DAOAppRutasTransporte();
        UtilidadesLog.info("MONAppRutasTransporte.query(AppRutasTransData appRutasTransFrom, AppRutasTransData appRutasTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(appRutasTransFrom, appRutasTransTo, userProperties, pageCount, pageSize );
    }

    public void update(AppRutasTransData appRutasTrans, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONAppRutasTransporte.update(AppRutasTransData appRutasTrans, Vector localizationLabels): Entrada");
        DAOAppRutasTransporte dao = new DAOAppRutasTransporte();
        dao.update(appRutasTrans, localizationLabels);
        UtilidadesLog.info("MONAppRutasTransporte.update(AppRutasTransData appRutasTrans, Vector localizationLabels): Saalida");               
    }

    public void remove(Vector appRutasTrans) throws MareException {
        UtilidadesLog.info("MONAppRutasTransporte.remove(Vector appRutasTransporte): Entrada");
        DAOAppRutasTransporte dao = new DAOAppRutasTransporte();
        dao.remove(appRutasTrans);
        UtilidadesLog.info("MONAppRutasTransporte.remove(Vector appRutasTransporte): Salida");
    }
}
