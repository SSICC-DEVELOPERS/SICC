package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCondiPromoData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCondicionPromocionBean implements SessionBean {
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

    public Vector query(PreCondiPromoData preCondiPromoFrom, PreCondiPromoData preCondiPromoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOCondicionPromocion daoCondicionPromocion = new DAOCondicionPromocion();
        
        return daoCondicionPromocion.query(preCondiPromoFrom, preCondiPromoTo, userProperties, pageCount, pageSize); 
    }
}
