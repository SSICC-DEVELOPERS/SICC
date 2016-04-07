package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarIndicNivelJerarData;
import es.indra.belcorp.mso.CarNivelRedonData;
import es.indra.belcorp.mso.CarParamGenerCarteData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONParamGeneraCarteraBean implements SessionBean {
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

    public Vector query(CarIndicNivelJerarData carIndicNivelJerarFrom, 
                        CarIndicNivelJerarData carIndicNivelJerarTo, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONCarParamGenerCarte.query(arIndicNivelJerarData carIndicNivelJerarFrom, CarIndicNivelJerarData carIndicNivelJerarTo, HashMap userProperties): Entrada");
         DAOParamGeneraCartera dao = new DAOParamGeneraCartera();
         
         UtilidadesLog.info("MONCarParamGenerCarte.query(arIndicNivelJerarData carIndicNivelJerarFrom, CarIndicNivelJerarData carIndicNivelJerarTo, HashMap userProperties): Salida");
        return dao.query(carIndicNivelJerarFrom, carIndicNivelJerarTo, userProperties);
       
    }

    public Vector query(CarNivelRedonData carNivelRedonFrom, 
                        CarNivelRedonData carNivelRedonTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCarParamGenerCarte.query(CarNivelRedonData carNivelRedonFrom, CarNivelRedonData carNivelRedonTo, HashMap userProperties): Entrada");
         DAOParamGeneraCartera dao = new DAOParamGeneraCartera();
         UtilidadesLog.info("MONCarParamGenerCarte.query(CarNivelRedonData carNivelRedonFrom, CarNivelRedonData carNivelRedonTo, HashMap userProperties): Salida");
        return dao.query(carNivelRedonFrom, carNivelRedonTo, userProperties );
    }

    public Vector query(CarParamGenerCarteData carParamGenerCarteFrom, 
                        CarParamGenerCarteData carParamGenerCarteTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCarParamGenerCarte.query(CarParamGenerCarteData carParamGenerCarteFrom, CarParamGenerCarteData carParamGenerCarteTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
         DAOParamGeneraCartera dao = new DAOParamGeneraCartera();
         
         UtilidadesLog.info("MONCarParamGenerCarte.query(CarParamGenerCarteData carParamGenerCarteFrom, CarParamGenerCarteData carParamGenerCarteTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(carParamGenerCarteFrom, carParamGenerCarteTo, userProperties, pageCount, pageSize);   
   
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCarParamGenerCarter. remove(Vector entities): Entrada");
        DAOParamGeneraCartera dao = new DAOParamGeneraCartera();
        dao.remove(entities);
        
        UtilidadesLog.info("MONCarparamGenerCarter.remove(Vector entities): Salida");
    }

    public void update(CarParamGenerCarteData carParamGenerCarte, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCarParamGenerCarter.update(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels): Entrada");
        DAOParamGeneraCartera dao = new DAOParamGeneraCartera();
        
        dao.update(carParamGenerCarte, localizationLabels);
        UtilidadesLog.info("MONCarParamGenerCarter.update(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels): Entrada");
    }

    public Hashtable guardar(CarParamGenerCarteData carParamGenerCarte, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCarParamGenerCarter.guardar(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels, HashMap userProperties):ENTRADA");   
    
        DAOParamGeneraCartera dao = new DAOParamGeneraCartera();
    
        UtilidadesLog.info("MONCarParamGenerCarter.guardar(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(carParamGenerCarte, localizationLabels, userProperties);
   
    }
}
