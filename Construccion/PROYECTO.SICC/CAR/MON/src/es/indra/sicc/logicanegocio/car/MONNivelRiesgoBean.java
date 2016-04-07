package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarNivelRiesgData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONNivelRiesgoBean implements SessionBean {
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

    public Vector query(CarNivelRiesgData carNivelRiesgFrom, 
                        CarNivelRiesgData carNivelRiesgTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCarNivelRiesgo.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAONivelRiesgo dao = new DAONivelRiesgo();
        
        UtilidadesLog.info("MONCarNivelRiesgo.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
    
        return dao.query(carNivelRiesgFrom, carNivelRiesgTo, userProperties, pageCount,pageSize);
    
     }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCarNivelRiesgo.remove(Vector entities): Entrada ");
        DAONivelRiesgo dao = new DAONivelRiesgo();
        dao.remove(entities);
        UtilidadesLog.info("MONCarNivelRiesgo.remove(Vector entities): Salida ");   
    }

    public void update(CarNivelRiesgData carNivelRiesg, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCarNivelRiesgo.update(CarNivelRiesgData carNivelRiesg, Vector localizationLabels):Entrada ");
        DAONivelRiesgo dao = new DAONivelRiesgo();
        dao.update(carNivelRiesg, localizationLabels );
        UtilidadesLog.info("MONCarNivelRiesgo.update(CarNivelRiesgData carNivelRiesg, Vector localizationLabels):Salida ");
    
    }

    public Hashtable guardarNivelRiesgo(CarNivelRiesgData carNivelRiesg, 
                                        Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCarNivelRiesgo.guardarNivelRiesgo(CarNivelRiesgData carNivelRiesg, Vector localizationLabels, HashMap userProperties): Entrada");
        DAONivelRiesgo dao = new DAONivelRiesgo();
        
        UtilidadesLog.info("MONCarNivelRiesgo.guardarNivelRiesgo(CarNivelRiesgData carNivelRiesg, Vector localizationLabels, HashMap userProperties): Entrada");
        return dao.guardarNivelRiesgo(carNivelRiesg, localizationLabels, userProperties);
        
    }
}
