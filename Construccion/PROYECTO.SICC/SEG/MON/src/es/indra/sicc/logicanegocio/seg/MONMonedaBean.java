package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMonedData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMonedaBean implements SessionBean {
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

    public Hashtable guardar(SegMonedData segMoned, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOMoneda daoMoneda = new DAOMoneda();
    
        return daoMoneda.guardar(segMoned, localizationLabels, userProperties) ;
    }

    public Vector query(SegMonedData segMonedFrom, SegMonedData segMonedTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOMoneda daoMoneda = new DAOMoneda();
        
        return daoMoneda.query(segMonedFrom, segMonedTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segMonedFrom) throws MareException
    {
        DAOMoneda daoMoneda = new DAOMoneda();
        
        daoMoneda.remove(segMonedFrom);
    }

    public void update(SegMonedData segMoned, Vector localizationLabels) throws MareException
    {
        DAOMoneda daoMoneda = new DAOMoneda();
        
        daoMoneda.update(segMoned, localizationLabels);
    }

    public Vector query(SegMonedData SegMonedFrom, SegMonedData SegMonedTo, HashMap userProperties) throws MareException
    {
        DAOMoneda daoMoneda = new DAOMoneda();
    
        return daoMoneda.query(SegMonedFrom, SegMonedTo, userProperties) ;
    }

    public Vector query(SegMonedData segMonedFrom, SegMonedData segMonedTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
   {
       DAOMoneda daoMoneda = new DAOMoneda();
   
       return daoMoneda.query( segMonedFrom, segMonedTo, userProperties) ;
   }
}
