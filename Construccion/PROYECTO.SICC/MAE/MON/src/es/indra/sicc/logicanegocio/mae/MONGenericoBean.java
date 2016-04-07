package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeGenerData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONGenericoBean implements SessionBean {
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

    public Vector query(MaeGenerData maeGenerFrom, MaeGenerData maeGenerTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONGenericoBean.query(MaeGenerData maeGenerFrom, MaeGenerData maeGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOGenerico dao = new DAOGenerico();
        UtilidadesLog.info("MONGenericoBean.query(MaeGenerData maeGenerFrom, MaeGenerData maeGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeGenerFrom, maeGenerTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeGenerData maeGener, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONGenericoBean.update(MaeGenerData maeGener, Vector localizationLabels): Entrada");
        DAOGenerico dao = new DAOGenerico();
        dao.update(maeGener, localizationLabels);
        UtilidadesLog.info("MONGenericoBean.update(MaeGenerData maeGener, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeGener) throws MareException {
        UtilidadesLog.info("MONGenericoBean.remove(Vector maeGenerico): Entrada");
        DAOGenerico dao = new DAOGenerico();
        dao.remove(maeGener);
        UtilidadesLog.info("MONGenericoBean.remove(Vector maeGenerico): Salida");
    }
}
