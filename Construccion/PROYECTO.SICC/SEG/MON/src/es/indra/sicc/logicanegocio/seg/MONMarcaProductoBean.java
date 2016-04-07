package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaProduData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMarcaProductoBean implements SessionBean {
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

    public Hashtable guardar(SegMarcaProduData segMarcaProdu, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOMarcaProducto daoMarcaProducto = new DAOMarcaProducto();
    
        return daoMarcaProducto.guardar(segMarcaProdu, userProperties) ;
    }

    public Vector query(SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOMarcaProducto daoMarcaProducto = new DAOMarcaProducto();
    
        return daoMarcaProducto.query(segMarcaProduFrom, segMarcaProduTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segMarcaProduFrom) throws MareException
    {
        DAOMarcaProducto daoMarcaProducto = new DAOMarcaProducto();
        
        daoMarcaProducto.remove(segMarcaProduFrom);
    }

    public void update(SegMarcaProduData segMarcaProdu, Vector localizationLabels) throws MareException
    {
        DAOMarcaProducto daoMarcaProducto = new DAOMarcaProducto();
        
        daoMarcaProducto.update(segMarcaProdu);
    }

    public Vector query(SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties) throws MareException
   {
       DAOMarcaProducto daoMarcaProducto = new DAOMarcaProducto();
   
       return daoMarcaProducto.query( segMarcaProduFrom, segMarcaProduTo,  userProperties);
   }
}
