package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeCriteBusquData;
import es.indra.belcorp.mso.PedAtribEspecData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCriterioBusquedaBean implements SessionBean {
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

    public Vector query(PedAtribEspecData pedAtribEspecFrom, 
                        PedAtribEspecData pedAtribEspecTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCriterioBusquedaBean.query(PedAtribEspecData pedAtribEspecFrom, PedAtribEspecData pedAtribEspecTo, HashMap userProperties): Entrada");
        DAOCriterioBusqueda dao = new DAOCriterioBusqueda();
        UtilidadesLog.info("MONCriterioBusquedaBean.query(PedAtribEspecData pedAtribEspecFrom, PedAtribEspecData pedAtribEspecTo, HashMap userProperties): Salida");
        return dao.query(pedAtribEspecFrom, pedAtribEspecTo, userProperties);
    }

    public Hashtable guardarCriterioBusqueda(MaeCriteBusquData maeCriteBusqu, 
                                             Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCriterioBusquedaBean.guardarCriterioBusqueda(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels, HashMap userProperties): Entrada ");
        DAOCriterioBusqueda dao = new DAOCriterioBusqueda();
        UtilidadesLog.info("MONCriterioBusquedaBean.guardarCriterioBusqueda(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels, HashMap userProperties): Salida ");
        return dao.guardarCriterioBusqueda(maeCriteBusqu, localizationLabels, userProperties);
    }

    public Vector query(MaeCriteBusquData maeCriteBusquFrom, 
                        MaeCriteBusquData maeCriteBusquTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCriterioBusquedaBean.query(MaeCriteBusquData maeCriteBusquFrom, MaeCriteBusquData maeCriteBusquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCriterioBusqueda dao = new DAOCriterioBusqueda();
        UtilidadesLog.info("MONCriterioBusquedaBean.query(MaeCriteBusquData maeCriteBusquFrom, MaeCriteBusquData maeCriteBusquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeCriteBusquFrom, maeCriteBusquTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeCriteBusquData maeCriteBusqu, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCriterioBusquedaBean.update(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels): Entrada");
        DAOCriterioBusqueda dao = new DAOCriterioBusqueda();
        dao.update(maeCriteBusqu, localizationLabels);
        UtilidadesLog.info("MONCriterioBusquedaBean.update(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeCriteBusqu) throws MareException {
        UtilidadesLog.info("MONCriterioBusquedaBean.remove(Vector meaCriteBusqu): Entrada");
        DAOCriterioBusqueda dao = new DAOCriterioBusqueda();
        dao.remove(maeCriteBusqu);
        UtilidadesLog.info("MONCriterioBusquedaBean.remove(Vector meaCriteBusqu): Salida");
    }
}
