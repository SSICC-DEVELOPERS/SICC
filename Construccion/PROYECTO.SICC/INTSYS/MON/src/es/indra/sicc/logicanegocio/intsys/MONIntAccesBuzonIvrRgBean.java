package es.indra.sicc.logicanegocio.intsys;

import es.indra.belcorp.mso.IntAccesBuzonIvrrgData;
import es.indra.belcorp.mso.ZonRegioView2Data;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONIntAccesBuzonIvrRgBean implements SessionBean {
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

    public Vector query(ZonRegioView2Data zonRegioView2From, 
                        ZonRegioView2Data zonRegioView2To, HashMap userProperties) throws MareException 
    {UtilidadesLog.info("MONIntAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, \n" + 
    "                        ZonRegioView2Data zonRegioView2To, HashMap userProperties):Entrada");
        DAOINTAccesBuzonIvrRg dao  = new DAOINTAccesBuzonIvrRg();
    
    
    UtilidadesLog.info("MONIntAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, \n" + 
            "                        ZonRegioView2Data zonRegioView2To, HashMap userProperties):Salida");
            
    return dao.query(zonRegioView2From, zonRegioView2To, userProperties);
    }

    public Vector query(IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom, 
                        IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {UtilidadesLog.info("MONIntAccesBuzonIvrRg.query(IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom, \n" + 
    "                        IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo, \n" + 
    "                        HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOINTAccesBuzonIvrRg dao  = new DAOINTAccesBuzonIvrRg();
    
        UtilidadesLog.info("MONIntAccesBuzonIvrRg.query(IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom, \n" + 
            "                        IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo, \n" + 
            "                        HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
    
    return dao.query(intAccesBuzonIvrrgFrom,intAccesBuzonIvrrgTo, userProperties, pageCount, pageSize);
    }

    public Vector query(ZonRegioView2Data zonRegioView2From, 
                        ZonRegioView2Data zonRegioView2To, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
                        
    UtilidadesLog.info("MONIntAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, ZonRegioView2Data zonRegioView2To, HashMap userProperties, Boolean applyStructuralSecurity):Entrada");
        DAOINTAccesBuzonIvrRg dao  = new DAOINTAccesBuzonIvrRg();
    UtilidadesLog.info("MONIntAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, ZonRegioView2Data zonRegioView2To, HashMap userProperties, Boolean applyStructuralSecurity):Salida");
    return dao.query(zonRegioView2From, zonRegioView2To, userProperties, applyStructuralSecurity);
    }

    public void update(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, 
                       Vector localizationLabels) throws MareException {
    UtilidadesLog.info("MONIntAccesBuzonIvrRg.update(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, Vector localizationLabels):Entrada");
        DAOINTAccesBuzonIvrRg dao  = new DAOINTAccesBuzonIvrRg();
        dao.update(intAccesBuzonIvrrg, localizationLabels);
        UtilidadesLog.info("MONIntAccesBuzonIvrRg.update(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, Vector localizationLabels):Salida");
    }

    public void remove(Vector entities) throws MareException {
        UtilidadesLog.info("MONIntAccesBuzonIvrRg.remove(Vector entities):Entrada");
        DAOINTAccesBuzonIvrRg dao  = new DAOINTAccesBuzonIvrRg();
        dao.remove(entities);
        UtilidadesLog.info("MONIntAccesBuzonIvrRg.remove(Vector entities):Salida");
    }

    public Hashtable guardar(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, 
                             Vector localizationLabels, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONIntAccesBuzonIvrRg.guardar(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOINTAccesBuzonIvrRg dao  = new DAOINTAccesBuzonIvrRg();
        UtilidadesLog.info("MONIntAccesBuzonIvrRg.guardar(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, Vector localizationLabels, HashMap userProperties):Salida");
                        
        return dao.guardar(intAccesBuzonIvrrg, localizationLabels, userProperties);
    }
}
