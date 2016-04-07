package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarJerarData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONJerarquiasBean implements SessionBean {
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


    public Vector query(CarJerarData carJerarFrom, CarJerarData carJerarTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCJerarquias.query(CarJerarData carJerarFrom, CarJerarData carJerarTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOJerarquias dao = new DAOJerarquias();
     UtilidadesLog.info("MONJerarquias.query(CarJerarData carJerarFrom, CarJerarData carJerarTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(carJerarFrom, carJerarTo, userProperties, pageCount, pageSize );
    
    }

    public void update(CarJerarData carJerar, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONJerarquias.update(CarJerarData carJerar, Vector localizationLabels): Entrada");
    
        DAOJerarquias dao = new DAOJerarquias();
        dao.update(carJerar, localizationLabels);
        UtilidadesLog.info("MONJerarquias.update(CarJerarData carJerar, Vector localizationLabels): Salida");
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONJerarquias.guardarJerarquias(Vector carJerarquias): Entrada");
        DAOJerarquias dao = new DAOJerarquias();
        dao.remove(entities);  
    UtilidadesLog.info("MONJerarquias.guardarJerarquias(Vector carJerarquias): Salida");
    }
    

    public Hashtable guardarJerarquias(CarJerarData carJerar, 
                                       Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONJerarquias.guardarJerarquias(CarJerarData carJerar, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOJerarquias dao = new DAOJerarquias();
    
        UtilidadesLog.info("MONJerarquias.guardarJerarquias(CarJerarData carJerar, Vector localizationLabels, HashMap userProperties): Entrada");
        return dao.guardarJerarquias(carJerar, localizationLabels, userProperties);
    
    }
}
