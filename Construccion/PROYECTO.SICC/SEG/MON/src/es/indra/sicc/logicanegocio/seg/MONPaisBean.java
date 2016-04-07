package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.BelFormaPagoTaponData;
import es.indra.belcorp.mso.SegPaisData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONPaisBean implements SessionBean {
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

    public Vector query(BelFormaPagoTaponData belFormaPagoTaponFrom, BelFormaPagoTaponData belFormaPagoTaponTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {
        DAOPais daoPais = new DAOPais();
    
        return daoPais.query( belFormaPagoTaponFrom, belFormaPagoTaponTo, userProperties) ;
    }

    public Hashtable guardar(SegPaisData segPais, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOPais daoPais = new DAOPais();
    
        return daoPais.guardar(segPais, localizationLabels, userProperties) ;
    }

    public void remove(Vector segPaisFrom) throws MareException
    {
        DAOPais daoPais = new DAOPais();
        
        daoPais.remove(segPaisFrom);
    }

    public void update(SegPaisData segPais, Vector localizationLabels) throws MareException
    {
        DAOPais daoPais = new DAOPais();
        
        daoPais.update(segPais, localizationLabels);
    }

    public Vector query(SegPaisData segPaisFrom, SegPaisData segPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize, Boolean applyStructuralSecurity) throws MareException
    { 
        DAOPais daoPais = new DAOPais();
        
        return daoPais.query(segPaisFrom, segPaisTo, userProperties, pageCount, pageSize, applyStructuralSecurity != null ? applyStructuralSecurity.booleanValue() : true);        
    }

    public Vector query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties) throws MareException
   {
       DAOPais daoPais = new DAOPais();
   
       return daoPais.query( segPaisViewFrom, segPaisViewTo,  userProperties) ;
   }

    public Vector query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {
        UtilidadesLog.debug("applyStructuralSecurity SegPaisViewData: " + applyStructuralSecurity);
        
        DAOPais daoPais = new DAOPais();
    
        return daoPais.query(segPaisViewFrom, segPaisViewTo, userProperties, (applyStructuralSecurity!= null?applyStructuralSecurity:Boolean.TRUE));
    }
}
