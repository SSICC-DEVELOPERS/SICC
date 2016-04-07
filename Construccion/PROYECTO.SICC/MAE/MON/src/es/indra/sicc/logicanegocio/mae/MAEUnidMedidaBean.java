package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeUnidaMedidData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAEUnidMedidaBean implements SessionBean {
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

    public Vector query(MaeUnidaMedidData maeUnidaMedidFrom, 
                        MaeUnidaMedidData maeUnidaMedidTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        DAOUnidMedida daoUnidMedida = new DAOUnidMedida();
        return daoUnidMedida.query(maeUnidaMedidFrom, maeUnidaMedidTo, userProperties, pageCount, pageSize);
    }

    public Hashtable guardar(MaeUnidaMedidData maeUnidaMedid, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        DAOUnidMedida daoUnidMedida = new DAOUnidMedida();
        return daoUnidMedida.guardar(maeUnidaMedid, localizationLabels, userProperties);
    }

    public void remove(Vector entities) throws MareException {
        DAOUnidMedida daoUnidMedida = new DAOUnidMedida();
        daoUnidMedida.remove(entities);
    }

    public void update(MaeUnidaMedidData maeUnidaMedid, 
                       Vector localizationLabels) throws MareException {
        DAOUnidMedida daoUnidMedida = new DAOUnidMedida();
        daoUnidMedida.update(maeUnidaMedid, localizationLabels);               
    }
}
