package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClaseTarjeData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONClaseTarjetaBean implements SessionBean {
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

    public Hashtable guardarClaseTarjeta(MaeClaseTarjeData maeClaseTarje, 
                                         Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONClaseTarjetaBean(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOClaseTarjeta dao = new DAOClaseTarjeta();
        UtilidadesLog.info("MONClaseTarjetaBean(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarClaseTarjeta(maeClaseTarje, localizationLabels,userProperties );
    }

    public Vector query(MaeClaseTarjeData maeClaseTarjeFrom, 
                        MaeClaseTarjeData maeClaseTarjeTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONClaseTarjetaBean.query(MaeClaseTarjeData maeClaseTarjeFrom, MaeClaseTarjeData maeClaseTarjeTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOClaseTarjeta dao = new DAOClaseTarjeta();
        UtilidadesLog.info("MONClaseTarjetaBean.query(MaeClaseTarjeData maeClaseTarjeFrom, MaeClaseTarjeData maeClaseTarjeTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeClaseTarjeFrom, maeClaseTarjeTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeClaseTarjeData maeClaseTarje, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONClaseTarjeta.update(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels): Entrada");
        DAOClaseTarjeta dao = new DAOClaseTarjeta();
        dao.update(maeClaseTarje, localizationLabels);
        UtilidadesLog.info("MONClaseTarjeta.update(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels): Salida");              
    }

    public void remove(Vector maeClaseTarje) throws MareException {
        UtilidadesLog.info("MONClaseTarjetaBean.remove(Vector maeCLaseTarjeta): Entrada ");
        DAOClaseTarjeta dao = new DAOClaseTarjeta();
        dao.remove(maeClaseTarje);
        UtilidadesLog.info("MONClaseTarjetaBean.remove(Vector maeCLaseTarjeta): Salida ");
    }
}
