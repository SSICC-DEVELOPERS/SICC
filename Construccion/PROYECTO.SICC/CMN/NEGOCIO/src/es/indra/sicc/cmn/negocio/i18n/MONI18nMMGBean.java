package es.indra.sicc.cmn.negocio.i18n;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONI18nMMGBean implements SessionBean {
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

    public Vector query(GenDetaSiccData genDetaSiccFrom, GenDetaSiccData genDetaSiccTo, HashMap userProperties) throws MareException
    {
        DAOI18nMMG daoI18nMMG = new DAOI18nMMG();
    
        return daoI18nMMG.query(genDetaSiccFrom, genDetaSiccTo, userProperties);
    }
}
