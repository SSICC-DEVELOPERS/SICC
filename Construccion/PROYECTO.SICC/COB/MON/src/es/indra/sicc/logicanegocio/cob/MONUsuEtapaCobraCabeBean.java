package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobUsuarCobraViewData;
import es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONUsuEtapaCobraCabeBean implements SessionBean {
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

    public Vector query(CobUsuarCobraViewData cobUsuarCobraViewFrom, 
                        CobUsuarCobraViewData cobUsuarCobraViewTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobUsuEtapaCobraCabe.query(CobUsuarCobraViewData cobUsuarCobraViewFrom, CobUsuarCobraViewData cobUsuarCobraViewTo, HashMap userProperties):Entrada");
        DAOUsuEtapaCobraCabe dao = new DAOUsuEtapaCobraCabe();
    
        UtilidadesLog.info("MONCobUsuEtapaCobraCabe.query(CobUsuarCobraViewData cobUsuarCobraViewFrom, CobUsuarCobraViewData cobUsuarCobraViewTo, HashMap userProperties):Entrada");
        return dao.query(cobUsuarCobraViewFrom, cobUsuarCobraViewTo, userProperties);
    }

    public Vector query(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom, 
                        CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCobUsuEtapaCobraCabe.query(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom, CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOUsuEtapaCobraCabe dao = new DAOUsuEtapaCobraCabe();
        UtilidadesLog.info("MONCobUsuEtapaCobraCabe.query(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom, CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobUsuarEtapaCobraCabecFrom, cobUsuarEtapaCobraCabecTo, userProperties, pageCount, pageSize);
    
    }

    public void update(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCobUsuEtapaCobraCabe.update(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels):Entrada");
        DAOUsuEtapaCobraCabe dao = new DAOUsuEtapaCobraCabe();
        dao.update(cobUsuarEtapaCobraCabec, localizationLabels );
        UtilidadesLog.info("MONCobUsuEtapaCobraCabe.update(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels):Salida");
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCobUsuEtapaCobraCabe.remove(Vector entities):Entrada");
        DAOUsuEtapaCobraCabe dao = new DAOUsuEtapaCobraCabe();
        dao.remove(entities);
        
        UtilidadesLog.info("MONCobUsuEtapaCobraCabe.remove(Vector entities):Salida");
    }

    public Hashtable guardar(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobUsuEtapaCobraCabe.guardar(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOUsuEtapaCobraCabe dao = new DAOUsuEtapaCobraCabe();
        UtilidadesLog.info("MONCobUsuEtapaCobraCabe.guardar(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(cobUsuarEtapaCobraCabec,localizationLabels, userProperties );
  
    }
}
