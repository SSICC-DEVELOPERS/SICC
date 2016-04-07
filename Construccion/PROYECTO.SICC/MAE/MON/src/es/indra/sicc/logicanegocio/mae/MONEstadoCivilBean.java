package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEstadCivilData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONEstadoCivilBean implements SessionBean {
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

    public Hashtable guardarEstadoCivil(MaeEstadCivilData maeEstadCivil, 
                                        Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONEstadoCivilBean.guardarEsadiCivil(MaeEstadCivilData maeEstadCivil, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOEstadoCivil dao = new DAOEstadoCivil();   
        UtilidadesLog.info("MONEstadoCivilBean.guardarEsadiCivil(MaeEstadCivilData maeEstadCivil, Vector localizationLabels, HashMap userProperties): Salir");
        return dao.guardarEstadoCivil(maeEstadCivil, localizationLabels, userProperties);
    }

    public Vector query(MaeEstadCivilData maeEstadCivilFrom, 
                        MaeEstadCivilData maeEstadCivilTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONEstadoCivilBean.query(MaeEstadCivilData maeEstadCivilFrom, MaeEstadCivilData maeEstadCivilTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOEstadoCivil dao = new DAOEstadoCivil();
        UtilidadesLog.info("MONEstadoCivilBean.query(MaeEstadCivilData maeEstadCivilFrom, MaeEstadCivilData maeEstadCivilTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeEstadCivilFrom, maeEstadCivilTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeEstadCivilData maeEstadCivil, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONEstadoCivilBean.update(MaeEstadCivilData maeEstadCivil, Vector localizationLabels): Entrada");
        DAOEstadoCivil dao = new DAOEstadoCivil();
        dao.update(maeEstadCivil, localizationLabels);
        UtilidadesLog.info("MONEstadoCivilBean.update(MaeEstadCivilData maeEstadCivil, Vector localizationLabels): Salida");               
    }

    public void remove(Vector maeEstadCivil) throws MareException {
        UtilidadesLog.info("MONEstadoCivil.remove(Vector maeEstadoCivil): Entrada");
        DAOEstadoCivil dao = new DAOEstadoCivil();
        dao.remove(maeEstadCivil);
        UtilidadesLog.info("MONEstadoCivil.remove(Vector maeEstadoCivil): Salida"); 
    }
}
