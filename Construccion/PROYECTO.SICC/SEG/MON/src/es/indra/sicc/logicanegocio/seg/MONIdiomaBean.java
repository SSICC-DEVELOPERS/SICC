package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegIdiomData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONIdiomaBean implements SessionBean {
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

    public Hashtable guardar(SegIdiomData segIdiom, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOIdioma daoIdioma = new DAOIdioma();
    
        return daoIdioma.guardar(segIdiom, localizationLabels, userProperties) ;
    }

    public Vector query(SegIdiomData segIdiomFrom, SegIdiomData segIdiomTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOIdioma daoIdioma = new DAOIdioma();
        
        return daoIdioma.query(segIdiomFrom, segIdiomTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segIdiomFrom) throws MareException
    {
        DAOIdioma daoIdioma = new DAOIdioma();
        
        daoIdioma.remove(segIdiomFrom);
    }

    public void update(SegIdiomData segIdiom, Vector localizationLabels) throws MareException
    {
        DAOIdioma daoIdioma = new DAOIdioma();
        
        daoIdioma.update(segIdiom, localizationLabels);
    }
}
