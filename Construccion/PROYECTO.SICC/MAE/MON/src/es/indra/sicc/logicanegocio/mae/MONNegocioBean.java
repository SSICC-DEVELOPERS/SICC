package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeNegocData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONNegocioBean implements SessionBean {
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

    public Vector query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONNegocioBean.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAONegocio dao = new DAONegocio();
        UtilidadesLog.info("MONNegocioBean.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeNegocFrom, maeNegocTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeNegocData maeNegoc, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONNegocioBean.update(MaeNegocData maeNegoc, Vector localizationLabels): Entrada");
        DAONegocio dao = new DAONegocio();
        dao.update(maeNegoc, localizationLabels);
        UtilidadesLog.info("MONNegocioBean.update(MaeNegocData maeNegoc, Vector localizationLabels): Salida");                  
    }

    public void remove(Vector maeNegoc) throws MareException {
        UtilidadesLog.info("MONNegocioBean.remove(Vector maeNegocio): Entrada");
        DAONegocio dao = new DAONegocio();
        dao.remove(maeNegoc);
        UtilidadesLog.info("MONNegocioBean.remove(Vector maeNegocio): Salida");
        
    }
}
