package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedImpueGenerData;
import es.indra.belcorp.mso.PedTasaImpueData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONImpuestosGeneralesBean implements SessionBean {
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

    public Vector query(PedTasaImpueData pedTasaImpueFrom, 
                        PedTasaImpueData pedTasaImpueTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONImpuestosGenerales.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties): Entrada"); 
        DAOImpuestosGenerales dao = new DAOImpuestosGenerales();
        UtilidadesLog.info("MONImpuestosGenerales.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties): Salida"); 
        return dao.query(pedTasaImpueFrom, pedTasaImpueTo, userProperties);
    }

    public Hashtable guardarImpuestosGenerales(PedImpueGenerData pedImpueGener, 
                                               Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONImpuestosGenerales.guardarImpuestosGenerales(PedImpueGenerData pedImpueGener, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOImpuestosGenerales dao = new DAOImpuestosGenerales();
        UtilidadesLog.info("MONImpuestosGenerales.guardarImpuestosGenerales(PedImpueGenerData pedImpueGener, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarImpuestosGenerales(pedImpueGener, localizationLabels, userProperties);
    }

    public Vector query(PedImpueGenerData pedImpueGenerFrom, 
                        PedImpueGenerData pedImpueGenerTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONImpuestosGenerales.query(PedImpueGenerData pedImpueGenerFrom, PedImpueGenerData pedImpueGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOImpuestosGenerales dao = new DAOImpuestosGenerales();
        UtilidadesLog.info("MONImpuestosGenerales.query(PedImpueGenerData pedImpueGenerFrom, PedImpueGenerData pedImpueGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(pedImpueGenerFrom, pedImpueGenerTo, userProperties, pageCount, pageSize);
    }

    public void update(PedImpueGenerData pedImpueGener, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONImpuestosGenerales.update(PedImpueGenerData pedImpueGener, Vector localizationLabels): Entrada");
        DAOImpuestosGenerales dao = new DAOImpuestosGenerales();
        dao.update(pedImpueGener,localizationLabels);
        UtilidadesLog.info("MONImpuestosGenerales.update(PedImpueGenerData pedImpueGener, Vector localizationLabels): Salida");               
    }

    public void remove(Vector entities) throws MareException {
        UtilidadesLog.info("MONImpuestosGenerales.remove(Vector pedImpueGenerFrom): Entrada ");
        DAOImpuestosGenerales dao = new DAOImpuestosGenerales();
        dao.remove(entities);
        UtilidadesLog.info("MONImpuestosGenerales.remove(Vector pedImpueGenerFrom): Salida ");
    }
}
