package es.indra.sicc.logicanegocio.edu;

import es.indra.belcorp.mso.EduTipoCursoData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoCursoBean implements SessionBean {
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

    public Vector query(EduTipoCursoData eduTipoCursoFrom, 
                        EduTipoCursoData eduTipoCursoTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONTipoCurso.query(EduTipoCursoData eduTipoCursoFrom, EduTipoCursoData eduTipoCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada"); 
        DAOTipoCurso dao = new DAOTipoCurso();
        UtilidadesLog.info("MONTipoCurso.query(EduTipoCursoData eduTipoCursoFrom, EduTipoCursoData eduTipoCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida"); 
        return dao.query(eduTipoCursoFrom, eduTipoCursoTo,userProperties, pageCount, pageSize);
    
   
    }

    public void remove(Vector entities) throws MareException 
    
    {   UtilidadesLog.info("MONTipoCurso.remove(Vector entities):Entrada");
        DAOTipoCurso dao = new DAOTipoCurso();
        dao.remove(entities);
        UtilidadesLog.info("MONTipoCurso.remove(Vector entities):Salida");
    
    }

    public void update(EduTipoCursoData eduTipoCurso, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONTipoCurso.update(EduTipoCursoData eduTipoCurso, Vector localizationLabels):Entrada");
        DAOTipoCurso dao = new DAOTipoCurso();
        dao.update(eduTipoCurso, localizationLabels);
        UtilidadesLog.info("MONTipoCurso.update(EduTipoCursoData eduTipoCurso, Vector localizationLabels):Salida");
        
    }

    public Hashtable guardar(EduTipoCursoData eduTipoCurso, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONTipoCurso.guardar(EduTipoCursoData eduTipoCurso, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOTipoCurso dao = new DAOTipoCurso();
    
        UtilidadesLog.info("MONTipoCurso.guardar(EduTipoCursoData eduTipoCurso, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(eduTipoCurso, localizationLabels, userProperties );
        
    }
}
