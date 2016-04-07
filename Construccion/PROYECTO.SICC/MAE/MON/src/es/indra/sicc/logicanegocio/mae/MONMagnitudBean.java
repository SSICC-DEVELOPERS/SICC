package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeMagniData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMagnitudBean implements SessionBean {
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

    public Hashtable guardarMagnitud(MaeMagniData maeMagni, 
                                     Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONMagnitud.guardarMagnitud(MaeMagniData maeMagni, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOMagnitud dao = new DAOMagnitud();
        UtilidadesLog.info("MONMagnitud.guardarMagnitud(MaeMagniData maeMagni, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarMagnitud(maeMagni, localizationLabels, userProperties);
    }

    public Vector query(MaeMagniData maeMagniFrom, MaeMagniData maeMagniTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException{ 
        UtilidadesLog.info("MONMagnitud.query(MaeMagniData maeMagniFrom, MaeMagniData maeMagniTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOMagnitud dao = new DAOMagnitud();
        UtilidadesLog.info("MONMagnitud.query(MaeMagniData maeMagniFrom, MaeMagniData maeMagniTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeMagniFrom, maeMagniTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeMagniData maeMagni, 
                       Vector localizationLabels) throws MareException {
        
        UtilidadesLog.info("MONMagnitudBean.update(MaeMagniData maeMagni, Vector localizationLabels): Entrada");
        DAOMagnitud dao = new DAOMagnitud();
        dao.update(maeMagni, localizationLabels);
        UtilidadesLog.info("MONMagnitudBean.update(MaeMagniData maeMagni, Vector localizationLabels): Salida");                 
    }

    public void remove(Vector maeMagni) throws MareException {
        UtilidadesLog.info("MONMagnitud.remove(Vector maeMagni): Entrada");
        DAOMagnitud dao = new DAOMagnitud();
        dao.remove(maeMagni);
        UtilidadesLog.info("MONMagnitud.remove(Vector maeMagni): Salida");
    }
}
