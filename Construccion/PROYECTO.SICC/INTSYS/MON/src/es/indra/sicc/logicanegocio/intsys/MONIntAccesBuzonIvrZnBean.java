package es.indra.sicc.logicanegocio.intsys;

import es.indra.belcorp.mso.IntAccesBuzonIvrznData;
import es.indra.belcorp.mso.ZonZonaView2Data;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONIntAccesBuzonIvrZnBean implements SessionBean {
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

    public Vector query(ZonZonaView2Data zonZonaView2From, 
                        ZonZonaView2Data zonZonaView2To, HashMap userProperties) throws MareException {
                        
        UtilidadesLog.info("MONIntAccesBuzonIvrZn.query(onZonaView2Data zonZonaView2From, \n" + 
        "                        ZonZonaView2Data zonZonaView2To, HashMap userProperties):Entrada");
        
        DAOINTAccesBuzonIvrZn dao = new DAOINTAccesBuzonIvrZn();
          
                        
        UtilidadesLog.info("MONIntAccesBuzonIvrZn.query(onZonaView2Data zonZonaView2From, \n" + 
        "                        ZonZonaView2Data zonZonaView2To, HashMap userProperties):Salida");
        return dao.query(zonZonaView2From, zonZonaView2To, userProperties);
    }

    public Vector query(IntAccesBuzonIvrznData intAccesBuzonIvrznFrom, 
                        IntAccesBuzonIvrznData intAccesBuzonIvrznTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
                        
        UtilidadesLog.info("MONIntAccesBuzonIvrZn.query(IntAccesBuzonIvrznData intAccesBuzonIvrznFrom, \n" + 
        "                        IntAccesBuzonIvrznData intAccesBuzonIvrznTo, \n" + 
        "                        HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        
        DAOINTAccesBuzonIvrZn dao = new DAOINTAccesBuzonIvrZn();
        
                        
        UtilidadesLog.info("MONIntAccesBuzonIvrZn.query(IntAccesBuzonIvrznData intAccesBuzonIvrznFrom, \n" + 
        "                        IntAccesBuzonIvrznData intAccesBuzonIvrznTo, \n" + 
        "                        HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(intAccesBuzonIvrznFrom, intAccesBuzonIvrznTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector entities) throws MareException 
    {UtilidadesLog.info("MONIntAccesBuzonIvrZn.remove(Vector entities):Entrada");
        DAOINTAccesBuzonIvrZn dao = new DAOINTAccesBuzonIvrZn();
        dao.remove(entities);
     UtilidadesLog.info("MONIntAccesBuzonIvrZn.remove(Vector entities):Salida");
    
    }

    public void update(IntAccesBuzonIvrznData intAccesBuzonIvrzn, 
                       Vector localizationLabels) throws MareException 
    {UtilidadesLog.info("MONIntAccesBuzonIvrZn.update(IntAccesBuzonIvrznData intAccesBuzonIvrzn, \n" + 
    "                       Vector localizationLabels):Entrada");
        DAOINTAccesBuzonIvrZn dao = new DAOINTAccesBuzonIvrZn();
        dao.update(intAccesBuzonIvrzn, localizationLabels);
        UtilidadesLog.info("MONIntAccesBuzonIvrZn.update(IntAccesBuzonIvrznData intAccesBuzonIvrzn, \n" + 
            "                       Vector localizationLabels):Salida");
    }

    public Hashtable guardar(IntAccesBuzonIvrznData intAccesBuzonIvrzn, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
      UtilidadesLog.info("MONIntAccesBuzonIvrZn.guardar(IntAccesBuzonIvrznData intAccesBuzonIvrzn,Vector localizationLabels, HashMap userProperties):Entrada");
      DAOINTAccesBuzonIvrZn dao = new DAOINTAccesBuzonIvrZn();
      
      UtilidadesLog.info("MONIntAccesBuzonIvrZn.guardar(IntAccesBuzonIvrznData intAccesBuzonIvrzn,Vector localizationLabels, HashMap userProperties):Salida");
                      
      return dao.guardar(intAccesBuzonIvrzn,localizationLabels, userProperties);
    }

    public Vector query(ZonZonaView2Data zonZonaView2From, 
                        ZonZonaView2Data zonZonaView2To, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {UtilidadesLog.info("MONIntAccesBuzonIvrZn.query(ZonZonaView2Data zonZonaView2, ZonZonaView2Data zonZonaView2To,HashMap userProperties, Boolean applyStructuralSecurity):Entrada");
        DAOINTAccesBuzonIvrZn dao = new DAOINTAccesBuzonIvrZn();
    
    UtilidadesLog.info("MONIntAccesBuzonIvrZn.query(ZonZonaView2Data zonZonaView2, ZonZonaView2Data zonZonaView2To,HashMap userProperties, Boolean applyStructuralSecurity):Salida");
    return dao.query(zonZonaView2From, zonZonaView2To, userProperties, applyStructuralSecurity);
    }
}
