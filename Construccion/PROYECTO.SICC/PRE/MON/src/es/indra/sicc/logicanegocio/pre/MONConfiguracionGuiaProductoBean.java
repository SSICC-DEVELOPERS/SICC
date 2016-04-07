package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreConfiGpData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONConfiguracionGuiaProductoBean implements SessionBean {
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

    public Hashtable guardar(PreConfiGpData preConfiGp, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOConfiguracionGuiaProducto daoConfiguracionGuiaProducto = new DAOConfiguracionGuiaProducto();
    
        return daoConfiguracionGuiaProducto.guardar(preConfiGp, userProperties) ;
    }

    public void remove(Vector preConfiGpFrom) throws MareException
    {
        DAOConfiguracionGuiaProducto daoConfiguracionGuiaProducto = new DAOConfiguracionGuiaProducto();
        
        daoConfiguracionGuiaProducto.remove(preConfiGpFrom);
    }

    public Vector query(PreConfiGpData preConfiGpFrom, PreConfiGpData preConfiGpTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOConfiguracionGuiaProducto daoConfiguracionGuiaProducto = new DAOConfiguracionGuiaProducto();
        
        return daoConfiguracionGuiaProducto.query(preConfiGpFrom, preConfiGpTo, userProperties, pageCount, pageSize);        
    }

    public void update(PreConfiGpData preConfiGp, Vector localizationLabels) throws MareException
    {
        DAOConfiguracionGuiaProducto daoConfiguracionGuiaProducto = new DAOConfiguracionGuiaProducto();
        
        daoConfiguracionGuiaProducto.update(preConfiGp);
    }
}
