package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeNivelEstudData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONNivelEstudioBean implements SessionBean {
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

    public Hashtable guardarNivelEstudio(MaeNivelEstudData maeNivelEstud, 
                                         Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONNivelEstudioBean.guardarNivelEstudio(MaeNivelEstudData maeNivelEstud, Vector localizationLabels, HashMap userProperties): Entrada");
        DAONivelEstudio dao = new DAONivelEstudio();
        UtilidadesLog.info("MONNivelEstudioBean.guardarNivelEstudio(MaeNivelEstudData maeNivelEstud, Vector localizationLabels, HashMap userProperties): Entrada");
        return dao.guardarNivelEstudio(maeNivelEstud, localizationLabels, userProperties);
    }

    public Vector query(MaeNivelEstudData maeNivelEstudFrom, 
                        MaeNivelEstudData maeNivelEstudTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("DAONivelEstudio.query(MaeNivelEstudData maeNivelEstudFrom, MaeNivelEstudData maeNivelEstudTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAONivelEstudio dao = new DAONivelEstudio();
        UtilidadesLog.info("DAONivelEstudio.query(MaeNivelEstudData maeNivelEstudFrom, MaeNivelEstudData maeNivelEstudTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeNivelEstudFrom, maeNivelEstudTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeNivelEstudData maeNivelEstud, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("DAONivelEstudio.update(MaeNivelEstudData maeNivelEstud, Vector localizationLabels): Entrada");
        DAONivelEstudio dao = new DAONivelEstudio();
        dao.update(maeNivelEstud, localizationLabels);
        UtilidadesLog.info("DAONivelEstudio.update(MaeNivelEstudData maeNivelEstud, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeNivelEstud) throws MareException {
        UtilidadesLog.info("DAONivelEstudio.remove(Vector maeNivelEstudio): Entrada ");
        DAONivelEstudio dao = new DAONivelEstudio();
        dao.remove(maeNivelEstud);
        UtilidadesLog.info("DAONivelEstudio.remove(Vector maeNivelEstudio): Salida ");
    }
}
