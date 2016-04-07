package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaePreguEncueData;
import es.indra.belcorp.mso.MaeRespuEncueData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRespuestaEncuestaBean implements SessionBean {
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

    public Vector query(MaePreguEncueData maePreguEncueFrom, 
                        MaePreguEncueData maePreguEncueTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONRespuestaEncuestaBean.query(MaePreguEncueData maePreguEncueFrom, MaePreguEncueData maePreguEncueTo, HashMap userProperties): Entrada");
        DAORespuestaEncuesta dao = new DAORespuestaEncuesta();
        UtilidadesLog.info("MONRespuestaEncuestaBean.query(MaePreguEncueData maePreguEncueFrom, MaePreguEncueData maePreguEncueTo, HashMap userProperties): Entrada");
        return dao.query(maePreguEncueFrom, maePreguEncueTo, userProperties);
    }

    public Hashtable guardarRespuestaEncuesta(MaeRespuEncueData maeRespuEncue, 
                                              Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONRespeustaEncuestaBean.guardarRespuestaEncuesta(MaeRespuEncueData maeRespuEncue, Vector localizationLabels, HashMap userProperties):  Entrada");
        DAORespuestaEncuesta dao = new DAORespuestaEncuesta();
        UtilidadesLog.info("MONRespeustaEncuestaBean.guardarRespuestaEncuesta(MaeRespuEncueData maeRespuEncue, Vector localizationLabels, HashMap userProperties):  Entrada");
        return dao.guaradaRespuestaEncuesta(maeRespuEncue, localizationLabels, userProperties );
    }

    public Vector query(MaeRespuEncueData maeRespuEncueFrom, 
                        MaeRespuEncueData maeRespuEncueTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONRespuestaEncuesta.query(MaeRespuEncueData maeRespuEncueFrom, MaeRespuEncueData maeRespuEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAORespuestaEncuesta dao = new DAORespuestaEncuesta();
        UtilidadesLog.info("MONRespuestaEncuesta.query(MaeRespuEncueData maeRespuEncueFrom, MaeRespuEncueData maeRespuEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(maeRespuEncueFrom, maeRespuEncueTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeRespuEncueData maeRespuEncue, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONRespuestaEncuesta.update(MaeRespuEncueData maeRespuEncue, Vector localizationLabels): Entrada");
        DAORespuestaEncuesta dao = new DAORespuestaEncuesta();
        dao.update(maeRespuEncue, localizationLabels);
        UtilidadesLog.info("MONRespuestaEncuesta.update(MaeRespuEncueData maeRespuEncue, Vector localizationLabels): Entrada");               
    }

    public void remove(Vector maeRespuEncue) throws MareException {
        UtilidadesLog.info("MONRespuestaEncuesta.remove(Vector maeRespuestaEncuesta): Entrada");
        DAORespuestaEncuesta dao = new DAORespuestaEncuesta();
        dao.remove(maeRespuEncue);
        UtilidadesLog.info("MONRespuestaEncuesta.remove(Vector maeRespuestaEncuesta): Salida");
    }
}
