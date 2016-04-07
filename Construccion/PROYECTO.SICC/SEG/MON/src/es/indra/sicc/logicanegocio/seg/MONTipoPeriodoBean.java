package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegTipoPerioData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoPeriodoBean implements SessionBean {
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

    public Hashtable guardar(SegTipoPerioData segTipoPerio, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOTipoPeriodo daoTipoPeriodo = new DAOTipoPeriodo();
    
        return daoTipoPeriodo.guardar(segTipoPerio, localizationLabels, userProperties) ;
    }

    public Vector query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOTipoPeriodo daoTipoPeriodo = new DAOTipoPeriodo();
    
        return daoTipoPeriodo.query(segTipoPerioFrom, segTipoPerioTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segTipoPerioFrom) throws MareException
    {
        DAOTipoPeriodo daoTipoPeriodo = new DAOTipoPeriodo();
    
        daoTipoPeriodo.remove(segTipoPerioFrom);
    }

    public void update(SegTipoPerioData segTipoPerio, Vector localizationLabels) throws MareException
    {
        DAOTipoPeriodo daoTipoPeriodo = new DAOTipoPeriodo();
    
        daoTipoPeriodo.update(segTipoPerio, localizationLabels);
    }

    public Vector query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties) throws MareException
    {
        DAOTipoPeriodo daoTipoPeriodo = new DAOTipoPeriodo();
    
        return daoTipoPeriodo.query( segTipoPerioFrom, segTipoPerioTo,  userProperties) ;
    }

    public Vector query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {
        DAOTipoPeriodo daoTipoPeriodo = new DAOTipoPeriodo();
        
        return daoTipoPeriodo.query(segTipoPerioFrom, segTipoPerioTo, userProperties, (applyStructuralSecurity!= null?applyStructuralSecurity:Boolean.TRUE));
        
    }
}
