package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivRechaDesblData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRECMotivDesbRechaBean implements SessionBean {
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

    public Hashtable guardarMotivDesblRecha(RecMotivRechaDesblData recMotivRechaDesbl, 
                                            Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECMotivDesbRechaBean.guardarMotivDesblRecha(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels, HashMap userProperties): Entrada");
            DAORECMotivDesbRecha dao = new DAORECMotivDesbRecha();
            UtilidadesLog.info("MONRECMotivDesbRechaBean.guardarMotivDesblRecha(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarMotivDesbRecha(recMotivRechaDesbl, localizationLabels, userProperties);
    }

    public Vector query(RecMotivRechaDesblData recMotivRechaDesblFrom, 
                        RecMotivRechaDesblData recMotivRechaDesblTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException{
            UtilidadesLog.info("MONRECMotivDesbRechaBean.query(RecMotivRechaDesblData recMotivRechaDesblFrom, RecMotivRechaDesblData recMotivRechaDesblTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAORECMotivDesbRecha dao = new DAORECMotivDesbRecha();
            UtilidadesLog.info("MONRECMotivDesbRechaBean.query(RecMotivRechaDesblData recMotivRechaDesblFrom, RecMotivRechaDesblData recMotivRechaDesblTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(recMotivRechaDesblFrom, recMotivRechaDesblTo, userProperties, pageCount, pageSize);
    }

    public void update(RecMotivRechaDesblData recMotivRechaDesbl, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONRECMotivDesbRechaBean.update(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels): Entrada");
            DAORECMotivDesbRecha dao = new DAORECMotivDesbRecha();
            dao.update(recMotivRechaDesbl, localizationLabels);
            UtilidadesLog.info("MONRECMotivDesbRechaBean.update(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels): Salida");            
    }

    public void remove(Vector entities) throws MareException {
            UtilidadesLog.info("MONRECMotivDesbRechaBean.reomve(Vector recMotivDesb): Entrada");
            DAORECMotivDesbRecha dao = new DAORECMotivDesbRecha();
            dao.remove(entities);
            UtilidadesLog.info("MONRECMotivDesbRechaBean.reomve(Vector recMotivDesb): Salida");
    }
}
