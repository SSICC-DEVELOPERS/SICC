package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCatalData;
import es.indra.belcorp.mso.PreCatalOrdenData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCatalogoOrdenBean implements SessionBean {
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


    public Hashtable guardar(PreCatalOrdenData preCatalOrden, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOCatalogoOrden daoCatalogoOrden = new DAOCatalogoOrden();
    
        return daoCatalogoOrden.guardar(preCatalOrden, userProperties) ;
    }

    public Vector query(PreCatalOrdenData preCatalOrdenFrom, PreCatalOrdenData preCatalOrdenTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOCatalogoOrden daoCatalogoOrden = new DAOCatalogoOrden();
        
        return daoCatalogoOrden.query(preCatalOrdenFrom, preCatalOrdenTo, userProperties, pageCount, pageSize); 
        
    }

    public void remove(Vector preCatalOrdenFrom) throws MareException
    {
        DAOCatalogoOrden daoCatalogoOrden = new DAOCatalogoOrden();
        
        daoCatalogoOrden.remove(preCatalOrdenFrom);
    }

    public void update(PreCatalOrdenData preCatalOrden, Vector localizationLabels) throws MareException
    {
        DAOCatalogoOrden daoCatalogoOrden = new DAOCatalogoOrden();
        
        daoCatalogoOrden.update(preCatalOrden);
    }
}
