package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeUnidaNegocData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAEUnidaNegocBean implements SessionBean {
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

    public Vector query(MaeUnidaNegocData maeUnidaNegocFrom, 
                        MaeUnidaNegocData maeUnidaNegocTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        DAOUnidaNegoc daoUnidaNegoc = new DAOUnidaNegoc();
        return daoUnidaNegoc.query(maeUnidaNegocFrom, maeUnidaNegocTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector maeUnidaNegoc) throws MareException {
        DAOUnidaNegoc daoUnidaNegoc = new DAOUnidaNegoc();
        daoUnidaNegoc.remove(maeUnidaNegoc);
    }

    public void update(MaeUnidaNegocData maeUnidaNegoc, 
                       Vector localizationLabels) throws MareException {
        DAOUnidaNegoc daoUnidaNegoc = new DAOUnidaNegoc();
        daoUnidaNegoc.update(maeUnidaNegoc, localizationLabels);               
    }

    public Hashtable guardar(MaeUnidaNegocData maeUnidaNegoc, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        DAOUnidaNegoc daoUnidaNegoc = new DAOUnidaNegoc();
        return daoUnidaNegoc.guardar(maeUnidaNegoc, localizationLabels, userProperties);
    }
}
