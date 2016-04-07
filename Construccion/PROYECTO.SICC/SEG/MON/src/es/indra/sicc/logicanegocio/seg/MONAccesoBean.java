package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegAccesData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONAccesoBean implements SessionBean {
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

    public Hashtable guardar(SegAccesData segAcces, Vector localizationLabels, HashMap userProperties) throws MareException
   {
       DAOAcceso daoAcceso = new DAOAcceso();
       
       return daoAcceso.guardar(segAcces, localizationLabels, userProperties) ;
   }

   public void remove(Vector segAccesFrom) throws MareException
   {
       DAOAcceso daoAcceso = new DAOAcceso();
       
       daoAcceso.remove(segAccesFrom);
   }
   
   public Vector query(SegAccesData segAccesFrom, SegAccesData SegAccesTo, HashMap userProperties, Integer pageCount, Integer pageSize, Boolean applyStructuralSecurity) throws MareException
   {
       DAOAcceso daoAcceso = new DAOAcceso();
       
       return daoAcceso.query(segAccesFrom, SegAccesTo, userProperties, pageCount, pageSize, (applyStructuralSecurity!= null?applyStructuralSecurity:Boolean.TRUE));
   }

   public void update(SegAccesData segAcces, Vector localizationLabels) throws MareException
   {
       DAOAcceso daoAcceso = new DAOAcceso();
       
       daoAcceso.update(segAcces, localizationLabels);
   }
}
