package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivDevolData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRECMotivoDevolucionReclamoBean implements SessionBean {
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

    public Hashtable guardarMotivoDevolucion(RecMotivDevolData recMotivDevol, 
                                             Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECMotivoDevolocionReclamo.guardarMotivoDevolucion(RecMotivDevolData recMotivDevol, Vector localizationLabels, HashMap userProperties): Entrada");
            DAORECMotivoDevolucionReclamo dao = new DAORECMotivoDevolucionReclamo();
            UtilidadesLog.info("MONRECMotivoDevolocionReclamo.guardarMotivoDevolucion(RecMotivDevolData recMotivDevol, Vector localizationLabels, HashMap userProperties): Salida");   
            return dao.gardarMotivoDevolucionReclamo(recMotivDevol, localizationLabels, userProperties);
    }

    public Vector query(RecMotivDevolData recMotivDevolFrom, 
                        RecMotivDevolData recMotivDevolTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONRECMotivoDevolucionReclamo.query(RecMotivDevolData recMotivDevolFrom, RecMotivDevolData recMotivDevolTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAORECMotivoDevolucionReclamo dao = new DAORECMotivoDevolucionReclamo();
            UtilidadesLog.info("MONRECMotivoDevolucionReclamo.query(RecMotivDevolData recMotivDevolFrom, RecMotivDevolData recMotivDevolTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(recMotivDevolFrom, recMotivDevolTo, userProperties, pageCount, pageSize);
    }

    public void update(RecMotivDevolData recMotivDevol, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONRECMotivoDevolucionReclamo.update(RecMotivDevolData recMotivDevol, Vector localizationLabels): Entrada");
            DAORECMotivoDevolucionReclamo dao = new DAORECMotivoDevolucionReclamo();
            dao.update(recMotivDevol, localizationLabels);
            UtilidadesLog.info("MONRECMotivoDevolucionReclamo.update(RecMotivDevolData recMotivDevol, Vector localizationLabels): Salida");           
    }

    public void remove(Vector entities) throws MareException {
           UtilidadesLog.info("MONRECMotivoDevolucionReclamo.remove(Vector recMotivoDevolucion): Entrada");
           DAORECMotivoDevolucionReclamo dao = new DAORECMotivoDevolucionReclamo();
           dao.remove(entities);
           UtilidadesLog.info("MONRECMotivoDevolucionReclamo.remove(Vector recMotivoDevolucion): Salida");
    }
}
