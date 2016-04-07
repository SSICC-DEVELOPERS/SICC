package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMarcaBean implements SessionBean {
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

    public Hashtable guardar(SegMarcaData segMarca, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOMarca daoMarca = new DAOMarca();
    
        return daoMarca.guardar(segMarca, userProperties) ;
    }

    public void remove(Vector segMarcaFrom) throws MareException
    {
        DAOMarca daoMarca = new DAOMarca();
        
        daoMarca.remove(segMarcaFrom);
    }

    public void update(SegMarcaData segMarca, Vector localizationLabels) throws MareException
    {
        DAOMarca daoMarca = new DAOMarca();
        
        daoMarca.update(segMarca);
    }

    public Vector query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties, Integer pageCount, Integer pageSize, Boolean applyStructuralSecurity) throws MareException
    {
        DAOMarca daoMarca = new DAOMarca();
        
        return daoMarca.query(segMarcaFrom, segMarcaTo, userProperties, pageCount, pageSize, applyStructuralSecurity != null ? applyStructuralSecurity.booleanValue() : true);        
    }
}
