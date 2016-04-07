package es.indra.sicc.logicanegocio.edu;

import es.indra.belcorp.mso.EduFrecuCursoData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONFrecuenciaCursoBean implements SessionBean {
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

    public Vector query(EduFrecuCursoData eduFrecuCursoFrom, 
                        EduFrecuCursoData eduFrecuCursoTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MonFrecuenciaCurso.query(EduFrecuCursoData eduFrecuCursoFrom, EduFrecuCursoData eduFrecuCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada"); 
        DAOFrecuenciaCurso dao = new DAOFrecuenciaCurso();
        UtilidadesLog.info("MonFrecuenciaCurso.query(EduFrecuCursoData eduFrecuCursoFrom, EduFrecuCursoData eduFrecuCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida"); 
        return dao.query(eduFrecuCursoFrom, eduFrecuCursoTo, userProperties, pageCount, pageSize );
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MonFrecuenciaCurso.remove(Vector entities):Entrada");
        DAOFrecuenciaCurso dao = new DAOFrecuenciaCurso();
        dao.remove(entities);
    
        UtilidadesLog.info("MonFrecuenciaCurso.remove(Vector entities):Salida");
    }

    public void update(EduFrecuCursoData eduFrecuCurso, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MonFrecuenciaCurso.update(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels):Entrada");
        DAOFrecuenciaCurso dao = new DAOFrecuenciaCurso();
        dao.update(eduFrecuCurso, localizationLabels);
        UtilidadesLog.info("MonFrecuenciaCurso.update(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels):Salida");
    }

    public Hashtable guardar(EduFrecuCursoData eduFrecuCurso, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MonFrecuenciaCurso.guardar(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOFrecuenciaCurso dao = new DAOFrecuenciaCurso();
    
        UtilidadesLog.info("MonFrecuenciaCurso.guardar(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(eduFrecuCurso, localizationLabels, userProperties);
    }
}
