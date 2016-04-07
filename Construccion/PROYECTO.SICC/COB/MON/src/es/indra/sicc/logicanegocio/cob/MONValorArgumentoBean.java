package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobValorArgumData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONValorArgumentoBean implements SessionBean {
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

    public Vector query(CobValorArgumData cobValorArgumFrom, 
                        CobValorArgumData cobValorArgumTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOValorArgumento dao = new DAOValorArgumento();
    
    
        UtilidadesLog.info("MONCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobValorArgumFrom, cobValorArgumTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCobValorArgumen.remove(Vector entities):Entrada");
         DAOValorArgumento dao = new DAOValorArgumento();
         dao.remove(entities);
         UtilidadesLog.info("MONCobValorArgumen.remove(Vector entities):Salida");
    }

    public void update(CobValorArgumData cobValorArgum, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCobValorArgumen.update(CobValorArgumData cobValorArgum, Vector localizationLabels):Entrada");
        DAOValorArgumento dao = new DAOValorArgumento();
        dao.update(cobValorArgum, localizationLabels);
        UtilidadesLog.info("MONCobValorArgumen.update(CobValorArgumData cobValorArgum, Vector localizationLabels):Entrada");
    }

    public Hashtable guardar(CobValorArgumData cobValorArgum, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobValorArgumen.guardar(CobValorArgumData cobValorArgum, Vector localizationLabels, HashMap userProperties):Entrada");
         DAOValorArgumento dao = new DAOValorArgumento();
    
         UtilidadesLog.info("MONCobValorArgumen.guardar(CobValorArgumData cobValorArgum, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(cobValorArgum, localizationLabels, userProperties);
    }

    public Vector query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
                        
        UtilidadesLog.info("MONCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Boolean applyStructuralSecurity):Entrada");
        DAOValorArgumento dao = new DAOValorArgumento();
    
        UtilidadesLog.info("MONCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Boolean applyStructuralSecurity):Salida");
        return dao.query( cobValorArgumFrom, cobValorArgumTo, userProperties, applyStructuralSecurity);
    }
}
