package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeMagniData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAEMagniBean implements SessionBean {
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

    public Vector query(MaeMagniData maeMagniFrom, MaeMagniData maeMagniTo, HashMap userProperties) throws MareException{
        DAOMagni daoMagni = new DAOMagni();
        return daoMagni.query(maeMagniFrom, maeMagniTo, userProperties);
    }
}
