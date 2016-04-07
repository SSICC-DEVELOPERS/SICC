package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobArgumData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONArgumentosBean implements SessionBean {
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

    public Vector query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONArgumentos.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOArgumentos dao = new DAOArgumentos();
        
    
        UtilidadesLog.info("MONArgumentos.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobArgumFrom, cobArgumTo, userProperties, pageCount, pageSize);   
    
    }

    public void update(CobArgumData cobArgum, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONArgumentos.update(CobArgumData cobArgum, Vector localizationLabels):Entrada");
        DAOArgumentos dao = new DAOArgumentos();
        dao.update(cobArgum, localizationLabels);
        UtilidadesLog.info("MONArgumentos.update(CobArgumData cobArgum, Vector localizationLabels):Salida");
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONArgumentos.remove(Vector entities):Entrada");
    
        DAOArgumentos dao = new DAOArgumentos();
        dao.remove(entities);
       
        UtilidadesLog.info("MONArgumentos.remove(Vector entities):Salida");
    }

    public Hashtable guardarArgumentos(CobArgumData cobArgum, 
                                       Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobArgumentos.guardarArgumentos(CobArgumData cobArgum, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOArgumentos dao = new DAOArgumentos();
        
        UtilidadesLog.info("MONCobArgumentos.guardarArgumentos(CobArgumData cobArgum, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardarArgumentos(cobArgum, localizationLabels, userProperties);
    
    }
}
