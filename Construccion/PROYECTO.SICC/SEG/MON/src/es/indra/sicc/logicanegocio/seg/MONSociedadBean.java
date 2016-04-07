package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegSocieData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesLog;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONSociedadBean implements SessionBean {
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

    public Hashtable guardar(SegSocieData segSocie, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOSociedad daoSociedad = new DAOSociedad();
    
        return daoSociedad.guardar(segSocie) ;
    }

    public Vector query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties, Integer pageCount, Integer pageSize, Boolean applyStructuralSecurity) throws MareException
    {
        UtilidadesLog.debug("applyStructuralSecurity SegSocieData: " + applyStructuralSecurity);
        
        DAOSociedad daoSociedad = new DAOSociedad();
    
        return daoSociedad.query(segSocieFrom, segSocieTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector SegSocieFrom) throws MareException
    {
        DAOSociedad daoSociedad = new DAOSociedad();
    
        daoSociedad.remove(SegSocieFrom);
    }

    public void update(SegSocieData segSocie, Vector localizationLabels) throws MareException
    {
        DAOSociedad daoSociedad = new DAOSociedad();
    
        daoSociedad.update(segSocie);
    }
}
