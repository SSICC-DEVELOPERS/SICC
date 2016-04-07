package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegCanalData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCanalBean implements SessionBean {
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

    public Hashtable guardar(SegCanalData segCanal, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOCanal daoCanal = new DAOCanal();
    
        return daoCanal.guardar(segCanal, localizationLabels, userProperties) ;
    }

    public void remove(Vector segCanalFrom) throws MareException
    {
        DAOCanal daoCanal = new DAOCanal();
        
        daoCanal.remove(segCanalFrom);
    }

    public void update(SegCanalData segCanal, Vector localizationLabels) throws MareException
    {
        DAOCanal daoCanal = new DAOCanal();
        
        daoCanal.update(segCanal, localizationLabels);
    }

    public Vector query(SegCanalData segCanalFrom, SegCanalData segCanalTo, HashMap userProperties, Integer pageCount, Integer pageSize, Boolean applyStructuralSecurity) throws MareException
    {
        DAOCanal daoCanal = new DAOCanal();
        
        return daoCanal.query(segCanalFrom, segCanalTo, userProperties, pageCount, pageSize, (applyStructuralSecurity!= null?applyStructuralSecurity:Boolean.TRUE));
    }

    public Vector query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {
        DAOCanal daoCanal = new DAOCanal();
        
        return daoCanal.query(segCanalViewFrom, segCanalViewTo, userProperties, (applyStructuralSecurity!= null?applyStructuralSecurity:Boolean.TRUE));
    }
}
