package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegPerioCorpoData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONPeriodoCorporativoBean implements SessionBean {
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

    public Hashtable guardar(SegPerioCorpoData segPerioCorpo, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOPeriodoCorporativo daoPeriodoCorporativo = new DAOPeriodoCorporativo();
    
        return daoPeriodoCorporativo.guardar(segPerioCorpo, localizationLabels, userProperties) ;
    }

    public Vector query(SegPerioCorpoData segPerioCorpoFrom, SegPerioCorpoData segPerioCorpoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOPeriodoCorporativo daoPeriodoCorporativo = new DAOPeriodoCorporativo();
        
        return daoPeriodoCorporativo.query(segPerioCorpoFrom, segPerioCorpoTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segPerioCorpoFrom) throws MareException
    {
        DAOPeriodoCorporativo daoPeriodoCorporativo = new DAOPeriodoCorporativo();
        
        daoPeriodoCorporativo.remove(segPerioCorpoFrom);
    }

    public void update(SegPerioCorpoData segPerioCorpo, Vector localizationLabels) throws MareException
    {
        DAOPeriodoCorporativo daoPeriodoCorporativo = new DAOPeriodoCorporativo();
        
        daoPeriodoCorporativo.update(segPerioCorpo, localizationLabels);
    }
}
