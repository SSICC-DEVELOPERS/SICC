package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegModulData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONModuloBean implements SessionBean {
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

    public Hashtable guardar(SegModulData segModul, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOModulo daoModulo = new DAOModulo();
    
        return daoModulo.guardar(segModul, localizationLabels, userProperties) ;
    }

    public Vector query(SegModulData segModulFrom, SegModulData segModulTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOModulo daoModulo = new DAOModulo();
    
        return daoModulo.query(segModulFrom, segModulTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segModulFrom) throws MareException
    {
        DAOModulo daoModulo = new DAOModulo();
    
        daoModulo.remove(segModulFrom);
    }

    public void update(SegModulData segModul, Vector localizationLabels) throws MareException
    {
        DAOModulo daoModulo = new DAOModulo();
    
        daoModulo.update(segModul, localizationLabels);
    }
}
