package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivBloquData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRECMotivoBloqueoReclamoBean implements SessionBean {
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

    public Hashtable guardarMotivoBloqueoReclamo(RecMotivBloquData recMotivBloqu, 
                                                 Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECMotivoBloqueReclamoBean.guardarMOtivoBloqueReclamo(RecMotivBloquData recMotivBloqu, Vector localizationLabels, HashMap userProperties): Entrada");
            DAORecMotivoBloqueoReclamo dao = new DAORecMotivoBloqueoReclamo();
            UtilidadesLog.info("MONRECMotivoBloqueReclamoBean.guardarMOtivoBloqueReclamo(RecMotivBloquData recMotivBloqu, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarMotivoBloqueo(recMotivBloqu, localizationLabels, userProperties);
    }

    public Vector query(RecMotivBloquData recMotivBloquFrom, 
                        RecMotivBloquData recMotivBloquTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONRecMotivoBloqueoBean.query(RecMotivBloquData recMotivBloquFrom, RecMotivBloquData recMotivBloquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAORecMotivoBloqueoReclamo dao = new DAORecMotivoBloqueoReclamo();
            UtilidadesLog.info("MONRecMotivoBloqueoBean.query(RecMotivBloquData recMotivBloquFrom, RecMotivBloquData recMotivBloquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(recMotivBloquFrom, recMotivBloquTo, userProperties, pageCount, pageSize);
    }

    public void update(RecMotivBloquData recMotivBloqu, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONRecMotivoBloqueoBean.update(RecMotivBloquData recMotivBloqu, Vector localizationLabels): Entrada");
            DAORecMotivoBloqueoReclamo dao = new DAORecMotivoBloqueoReclamo();
            dao.update(recMotivBloqu, localizationLabels);
            UtilidadesLog.info("MONRecMotivoBloqueoBean.update(RecMotivBloquData recMotivBloqu, Vector localizationLabels): Salida");           
    }

    public void remove(Vector entities) throws MareException {
            UtilidadesLog.info("MONRecMotivoBloqueoReclamoBean.remove(Vector recMotivoBloqueo): Entrada");
            DAORecMotivoBloqueoReclamo dao = new DAORecMotivoBloqueoReclamo();
            dao.remove(entities);
            UtilidadesLog.info("MONRecMotivoBloqueoReclamoBean.remove(Vector recMotivoBloqueo): Salida");
    }
}
