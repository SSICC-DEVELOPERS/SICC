package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedTipoPosicData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoPosicionBean implements SessionBean {
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

    public Hashtable guardarTipoPosicion(PedTipoPosicData pedTipoPosic, 
                                         Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONTipoPosicion.guardarTipoPosicion(PedTipoPosicData pedTipoPosic, Vector localizationLabels, HashMap userProperties): Entrada");
            DAOTipoPosicion dao = new DAOTipoPosicion();
            UtilidadesLog.info("MONTipoPosicion.guardarTipoPosicion(PedTipoPosicData pedTipoPosic, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarTipoPosicion(pedTipoPosic, localizationLabels, userProperties);
    }

    public Vector query(PedTipoPosicData pedTipoPosicFrom, 
                        PedTipoPosicData pedTipoPosicTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONTipoPosicion.query(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAOTipoPosicion dao = new DAOTipoPosicion();
            UtilidadesLog.info("MONTipoPosicion.query(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(pedTipoPosicFrom, pedTipoPosicTo, userProperties, pageCount, pageSize);
    }

    public void update(PedTipoPosicData pedTipoPosic, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONTipoPosicion.update(PedTipoPosicData pedTipoPosic, Vector localizationLabels): Entrada");
            DAOTipoPosicion dao = new DAOTipoPosicion();
            dao.update(pedTipoPosic, localizationLabels);
            UtilidadesLog.info("MONTipoPosicion.update(PedTipoPosicData pedTipoPosic, Vector localizationLabels): Salida");            
    }

    public void remove(Vector entities) throws MareException {
             UtilidadesLog.info("MONTipoPosicion.remove(Vector pedTipoPosic): Entrada");
             DAOTipoPosicion dao = new DAOTipoPosicion();
             dao.remove(entities);
             UtilidadesLog.info("MONTipoPosicion.remove(Vector pedTipoPosic): Salida");
    }
}
