package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.MaeNegocData;
import es.indra.belcorp.mso.PedImpueNegocData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONImpuestosNegocioBean implements SessionBean {
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

    public Vector query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONImpuestosNegocioBean.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties): Entrada");
        DAOImpuestosNegocio dao = new DAOImpuestosNegocio();
        UtilidadesLog.info("MONImpuestosNegocioBean.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties): Salida");
        return dao.query(maeNegocFrom, maeNegocTo, userProperties);
    }

    public Hashtable guardarImpuestosNegocio(PedImpueNegocData pedImpueNegoc, 
                                             Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONImpuestosNegocioBean.guardarImpuestosNegocio(PedImpueNegocData pedImpueNegoc, Vector localizationLabels, HashMap userProperties): Entrada ");
        DAOImpuestosNegocio dao = new DAOImpuestosNegocio();
        UtilidadesLog.info("MONImpuestosNegocioBean.guardarImpuestosNegocio(PedImpueNegocData pedImpueNegoc, Vector localizationLabels, HashMap userProperties): Salida ");
        return dao.guardarImpuestosNegocio(pedImpueNegoc, localizationLabels, userProperties);
    }

    public Vector query(PedImpueNegocData pedImpueNegocFrom, 
                        PedImpueNegocData pedImpueNegocTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONImpuestosNegocioBean.query(PedImpueNegocData pedImpueNegocFrom, PedImpueNegocData pedImpueNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOImpuestosNegocio dao = new DAOImpuestosNegocio();
        UtilidadesLog.info("MONImpuestosNegocioBean.query(PedImpueNegocData pedImpueNegocFrom, PedImpueNegocData pedImpueNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(pedImpueNegocFrom, pedImpueNegocTo, userProperties, pageCount, pageSize);
    }

    public void update(PedImpueNegocData pedImpueNegoc, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONImpuestosNegocio.update(PedImpueNegocData pedImpueNegoc, Vector localizationLabels): Entrada");
        DAOImpuestosNegocio dao = new DAOImpuestosNegocio();
        dao.update(pedImpueNegoc, localizationLabels);
        UtilidadesLog.info("MONImpuestosNegocio.update(PedImpueNegocData pedImpueNegoc, Vector localizationLabels): Salida");               
    }

    public void remove(Vector entities) throws MareException {
        UtilidadesLog.info("MONImpuestosNegocio.remove(Vector pedImpueNegoc): Entrada ");
        DAOImpuestosNegocio dao = new DAOImpuestosNegocio();
        dao.remove(entities);
        UtilidadesLog.info("MONImpuestosNegocio.remove(Vector pedImpueNegoc): Salida ");
    }
}
