package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedSubtiPosicData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONSubtipoPosicionBean implements SessionBean {
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

    public Hashtable guardarSubtipoPosicion(PedSubtiPosicData pedSubtiPosic, 
                                            Vector localizationLabels, HashMap userProperties) throws MareException {
           UtilidadesLog.info("MONSubtipoPosicion.guardarSubtipoPosicion(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels, HashMap userProperties): Entrada");
           DAOSubtipoPosicion dao = new DAOSubtipoPosicion();
           UtilidadesLog.info("MONSubtipoPosicion.guardarSubtipoPosicion(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels, HashMap userProperties): Salida");
           return dao.guardarSubtipoPosicion(pedSubtiPosic, localizationLabels, userProperties);
    }

    public Vector query(PedSubtiPosicData pedSubtiPosicFrom, 
                        PedSubtiPosicData pedSubtiPosicTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
           UtilidadesLog.info("MONSubtipoPosicion.query(PedSubtiPosicData pedSubtiPosicFrom, PedSubtiPosicData pedSubtiPosicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
           DAOSubtipoPosicion dao = new DAOSubtipoPosicion();
           UtilidadesLog.info("MONSubtipoPosicion.query(PedSubtiPosicData pedSubtiPosicFrom, PedSubtiPosicData pedSubtiPosicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return dao.query(pedSubtiPosicFrom, pedSubtiPosicTo, userProperties, pageCount, pageSize);
    }

    public void update(PedSubtiPosicData pedSubtiPosic, 
                       Vector localizationLabels) throws MareException {
           UtilidadesLog.info("MONSubtipoPosicion.update(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels): Entrada");
           DAOSubtipoPosicion dao = new DAOSubtipoPosicion();
           dao.update(pedSubtiPosic, localizationLabels);
           UtilidadesLog.info("MONSubtipoPosicion.update(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels): Salida");               
    }

    public void remove(Vector entities) throws MareException {
           UtilidadesLog.info("MONSubtipoPosicion.remove(Vector pedSubtiPosic): Entrada");
           DAOSubtipoPosicion dao = new DAOSubtipoPosicion();
           dao.remove(entities);
           UtilidadesLog.info("MONSubtipoPosicion.remove(Vector pedSubtiPosic): Salida"); 
    }
}
