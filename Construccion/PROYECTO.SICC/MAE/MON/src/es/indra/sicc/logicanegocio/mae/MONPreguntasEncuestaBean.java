package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEncueNseViewData;
import es.indra.belcorp.mso.MaePreguEncueData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONPreguntasEncuestaBean implements SessionBean {
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

    public Vector query(MaeEncueNseViewData maeEncueNseViewFrom, 
                        MaeEncueNseViewData maeEncueNseViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("DAOPreguntasEncuesta.query(MaeEncueNseViewData maeEncueNseViewFrom, MaeEncueNseViewData maeEncueNseViewTo, HashMap userProperties): Entrada");
        DAOPreguntasEncuesta dao = new DAOPreguntasEncuesta();
        UtilidadesLog.info("DAOPreguntasEncuesta.query(MaeEncueNseViewData maeEncueNseViewFrom, MaeEncueNseViewData maeEncueNseViewTo, HashMap userProperties): Salida");
        return dao.query(maeEncueNseViewFrom, maeEncueNseViewTo, userProperties);
    }

    public Hashtable guardarPreguntasEncuesta(MaePreguEncueData maePreguEncue, 
                                              Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONPrguntasEncuesta.guardarPreguntaEncuesta(MaePreguEncueData maePreguEncue, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOPreguntasEncuesta dao = new DAOPreguntasEncuesta();
        UtilidadesLog.info("MONPrguntasEncuesta.guardarPreguntaEncuesta(MaePreguEncueData maePreguEncue, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarPreguntasEncuesta(maePreguEncue, localizationLabels, userProperties);                                      
        
    }

    public Vector query(MaePreguEncueData maePreguEncueFrom, 
                        MaePreguEncueData maePreguEncueTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONPreguntasEncuesta.query(MaePreguEncueData maePreguEncueFrom, MaePreguEncueData maePreguEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOPreguntasEncuesta dao = new DAOPreguntasEncuesta();
        UtilidadesLog.info("MONPreguntasEncuesta.query(MaePreguEncueData maePreguEncueFrom, MaePreguEncueData maePreguEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maePreguEncueFrom, maePreguEncueTo, userProperties, pageCount, pageSize);
    }

    public void update(MaePreguEncueData maePreguEncue, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONPreguntasEncuesta.update(MaePreguEncueData maePreguEncue, Vector localizationLabels):Entrada");
        DAOPreguntasEncuesta dao = new DAOPreguntasEncuesta();
        dao.update(maePreguEncue, localizationLabels);
        UtilidadesLog.info("MONPreguntasEncuesta.update(MaePreguEncueData maePreguEncue, Vector localizationLabels):Salida");               
    }

    public void remove(Vector maeEncueNse) throws MareException {
        UtilidadesLog.info("MONPreguntaEncesta.remove(Vector maePreguntaEncuesta): Entrada");
        DAOPreguntasEncuesta dao = new DAOPreguntasEncuesta();
        dao.remove(maeEncueNse);
        UtilidadesLog.info("MONPreguntaEncesta.remove(Vector maePreguntaEncuesta): Salida");
    }
}
