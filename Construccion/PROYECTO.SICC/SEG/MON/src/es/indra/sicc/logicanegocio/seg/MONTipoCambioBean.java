package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegTipoCambiData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoCambioBean implements SessionBean {
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
   
    public Hashtable guardar(SegTipoCambiData segTipoCambi, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOTipoCambio daoTipoCambio = new DAOTipoCambio();
        
        return daoTipoCambio.guardar(segTipoCambi) ;
    }

    public Vector query(SegTipoCambiData segTipoCambiFrom, SegTipoCambiData segTipoCambiTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOTipoCambio daoTipoCambio = new DAOTipoCambio();
        
        return daoTipoCambio.query(segTipoCambiFrom, segTipoCambiTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segTipoCambiFrom) throws MareException
    {
        DAOTipoCambio daoTipoCambio = new DAOTipoCambio();
        
        daoTipoCambio.remove(segTipoCambiFrom);
    }

    public void update(SegTipoCambiData segTipoCambi, Vector localizationLabels) throws MareException
    {
        DAOTipoCambio daoTipoCambio = new DAOTipoCambio();
        
        daoTipoCambio.update(segTipoCambi);
    }
}
