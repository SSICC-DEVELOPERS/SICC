package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobGrupoUsuarCobraData;
import es.indra.belcorp.mso.CobUsuarGrupoUsuarData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONUsuaGrupoUsuaBean implements SessionBean {
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

    public Vector query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, 
                        CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobUsuaGrupoUsua.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties):Entrada");
        DAOUsuaGrupoUsua dao = new DAOUsuaGrupoUsua();
    
        UtilidadesLog.info("MONCobUsuaGrupoUsua.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties):Salida");
        
    
        return dao.query(cobGrupoUsuarCobraFrom, cobGrupoUsuarCobraTo, userProperties);
    }

    public Vector query(CobUsuarGrupoUsuarData cobUsuarGrupoUsuarFrom, 
                        CobUsuarGrupoUsuarData cobUsuarGrupoUsuarTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCobUsuaGrupoUsua.query(CobUsuarGrupoUsuarData cobUsuarGrupoUsuarFrom, CobUsuarGrupoUsuarData cobUsuarGrupoUsuarTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOUsuaGrupoUsua dao = new DAOUsuaGrupoUsua();
    
        UtilidadesLog.info("MONCobUsuaGrupoUsua.query(CobUsuarGrupoUsuarData cobUsuarGrupoUsuarFrom, CobUsuarGrupoUsuarData cobUsuarGrupoUsuarTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobUsuarGrupoUsuarFrom, cobUsuarGrupoUsuarTo,userProperties, pageCount, pageSize);
    }

    public Hashtable guardar(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobUsuaGrupoUsua.guardar(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOUsuaGrupoUsua dao = new DAOUsuaGrupoUsua();
    
        UtilidadesLog.info("MONCobUsuaGrupoUsua.guardar(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(cobUsuarGrupoUsuar, localizationLabels, userProperties );
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCobUsuaGrupoUsua.remove(Vector entities):Entrada");
        DAOUsuaGrupoUsua dao = new DAOUsuaGrupoUsua();
        dao.remove(entities);
        UtilidadesLog.info("MONCobUsuaGrupoUsua.remove(Vector entities):Entrada");
    }

    public void update(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCobUsuaGrupoUsua.update(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels):Entrada");
        DAOUsuaGrupoUsua dao = new DAOUsuaGrupoUsua();
        dao.update(cobUsuarGrupoUsuar, localizationLabels);
        UtilidadesLog.info("MONCobUsuaGrupoUsua.update(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels):Salida");
    }
}
