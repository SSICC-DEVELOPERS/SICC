package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEstadGrupoUsuarData;
import es.indra.belcorp.mso.CobGrupoUsuarCobraData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONGrupoUsuariosCobranzaBean implements SessionBean {
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

    public Vector query(CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom, 
                        CobEstadGrupoUsuarData cobEstadGrupoUsuarTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONGrupoUsuariosCobranza.query(CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom, CobEstadGrupoUsuarData cobEstadGrupoUsuarTo, HashMap userProperties):Entrada");
        DAOGrupoUsuariosCobranza dao = new DAOGrupoUsuariosCobranza();
    
        UtilidadesLog.info("MONGrupoUsuariosCobranza.query(CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom, CobEstadGrupoUsuarData cobEstadGrupoUsuarTo, HashMap userProperties):Salida");
        return dao.query(cobEstadGrupoUsuarFrom, cobEstadGrupoUsuarTo, userProperties);
  
    }

    public Vector query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, 
                        CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {   UtilidadesLog.info("MONGrupoUsuariosCobranza.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOGrupoUsuariosCobranza dao = new DAOGrupoUsuariosCobranza();
        UtilidadesLog.info("MONGrupoUsuariosCobranza.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        return dao.query(cobGrupoUsuarCobraFrom, cobGrupoUsuarCobraTo, userProperties, pageCount, pageSize);
 
    }

    public void update(CobGrupoUsuarCobraData cobGrupoUsuarCobra, 
                       Vector localizationLabels) throws MareException
    {   UtilidadesLog.info("MONGrupoUsuariosCobranza.update(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels):Entrada");
        DAOGrupoUsuariosCobranza dao = new DAOGrupoUsuariosCobranza();
        dao.update(cobGrupoUsuarCobra, localizationLabels);
       UtilidadesLog.info("MONGrupoUsuariosCobranza.update(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels):Salida");
    }
    

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONGrupoUsuariosCobranza.remove(Vector entities):Entrada");
        DAOGrupoUsuariosCobranza dao = new DAOGrupoUsuariosCobranza();
        dao.remove(entities);
        UtilidadesLog.info("MONGrupoUsuariosCobranza.remove(Vector entities):Salida");   
    }

    public Hashtable guardar(CobGrupoUsuarCobraData cobGrupoUsuarCobra, 
                             Vector localizationLabels, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONGrupoUsuariosCobranza.guardar(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOGrupoUsuariosCobranza dao = new DAOGrupoUsuariosCobranza();
        UtilidadesLog.info("MONGrupoUsuariosCobranza.guardar(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels, HashMap userProperties):Entrada");
        return dao.guardar(cobGrupoUsuarCobra, localizationLabels, userProperties);
   
    }
}
