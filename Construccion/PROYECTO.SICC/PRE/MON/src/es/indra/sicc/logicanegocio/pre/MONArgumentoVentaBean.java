package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreArgumVentaData;
import es.indra.belcorp.mso.PreTipoEstraData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONArgumentoVentaBean implements SessionBean {
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

    public Vector query(PreTipoEstraData preTipoEstraFrom, PreTipoEstraData preTipoEstraTo, HashMap userProperties) throws MareException
    {
        DAOArgumentoVenta daoArgumentoVenta = new DAOArgumentoVenta();
    
        return daoArgumentoVenta.query(preTipoEstraFrom, preTipoEstraTo,  userProperties) ;
    }

    public Vector query(PreArgumVentaData preArgumVentaFrom, PreArgumVentaData preArgumVentaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOArgumentoVenta daoArgumentoVenta = new DAOArgumentoVenta();
        
        return daoArgumentoVenta.query(preArgumVentaFrom, preArgumVentaTo, userProperties, pageCount, pageSize); 
    }
}
