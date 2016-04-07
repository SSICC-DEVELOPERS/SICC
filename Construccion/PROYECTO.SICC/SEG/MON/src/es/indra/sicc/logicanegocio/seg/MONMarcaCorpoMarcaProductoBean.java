package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaCorpoMarcaProduData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMarcaCorpoMarcaProductoBean implements SessionBean {
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

    public Hashtable guardar(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOMarcaCorpoMarcaProducto daoMarcaCorpoMarcaProducto = new DAOMarcaCorpoMarcaProducto();
    
        return daoMarcaCorpoMarcaProducto.guardar(segMarcaCorpoMarcaProdu, userProperties) ;
    }

    public Vector query(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom, SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOMarcaCorpoMarcaProducto daoMarcaCorpoMarcaProducto = new DAOMarcaCorpoMarcaProducto();
        
        return daoMarcaCorpoMarcaProducto.query(segMarcaCorpoMarcaProduFrom, segMarcaCorpoMarcaProduTo, userProperties, pageCount, pageSize);        
    }

    public void remove(Vector segMarcaCorpoMarcaProduFrom) throws MareException
    {
        DAOMarcaCorpoMarcaProducto daoMarcaCorpoMarcaProducto = new DAOMarcaCorpoMarcaProducto();
        
        daoMarcaCorpoMarcaProducto.remove(segMarcaCorpoMarcaProduFrom);
    }

    public void update(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu, Vector localizationLabels) throws MareException
    {
        DAOMarcaCorpoMarcaProducto daoMarcaCorpoMarcaProducto = new DAOMarcaCorpoMarcaProducto();
        
        daoMarcaCorpoMarcaProducto.update(segMarcaCorpoMarcaProdu);
    }
}
