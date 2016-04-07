package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeSuperGenerData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONSuperGenericoBean implements SessionBean {
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

    public Vector query(MaeSuperGenerData maeSuperGenerFrom, 
                        MaeSuperGenerData maeSuperGenerTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONSuperGenerico.query(MaeSuperGenerData maeSuperGenerFrom, MaeSuperGenerData maeSuperGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOSuperGenerico dao = new DAOSuperGenerico();
        UtilidadesLog.info("MONSuperGenerico.query(MaeSuperGenerData maeSuperGenerFrom, MaeSuperGenerData maeSuperGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeSuperGenerFrom, maeSuperGenerTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector maeSuperGener) throws MareException {
        UtilidadesLog.info("MONSuperGenerico.remove(Vector maeSuperGener): Entrada");
        DAOSuperGenerico dao = new DAOSuperGenerico();
        dao.remove(maeSuperGener);
        UtilidadesLog.info("MONSuperGenerico.remove(Vector maeSuperGener): Salida");
    }
}
