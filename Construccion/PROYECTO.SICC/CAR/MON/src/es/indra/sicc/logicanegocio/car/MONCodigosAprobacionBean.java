package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarCodigAprobData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCodigosAprobacionBean implements SessionBean {
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

    public Vector query(CarCodigAprobData carCodigAprobFrom, 
                        CarCodigAprobData carCodigAprobTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCodigosAprobacion.query(CarCodigAprobData carCodigAprobFrom, CarCodigAprobData carCodigAprobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
        
        DAOCodigosAprobacion dao = new DAOCodigosAprobacion();
        
    UtilidadesLog.info("MONCodigosAprobacion.query(CarCodigAprobData carCodigAprobFrom, CarCodigAprobData carCodigAprobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida ");
        return dao.query(carCodigAprobFrom, carCodigAprobTo, userProperties, pageCount, pageSize);
    
    }

    public void update(CarCodigAprobData carCodigAprob, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCodigosAprobacion.update(CarCodigAprobData carCodigAprob, Vector localizationLabels):Entrada ");
        DAOCodigosAprobacion dao = new DAOCodigosAprobacion();
        dao.update(carCodigAprob,localizationLabels);
        UtilidadesLog.info("MONCodigosAprobacion.update(CarCodigAprobData carCodigAprob, Vector localizationLabels):Entrada ");
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCarCodigoAprobacion.remove(Vector carCodigAprob):Entrada ");
        DAOCodigosAprobacion dao = new DAOCodigosAprobacion();
        dao.remove(entities);
    
        UtilidadesLog.info("MONCarCodigoAprobacion.update(Vector carCodigAprob):Salida ");
    
    }

    public Hashtable guardarCarCoAp(CarCodigAprobData carCodigAprob, 
                                    Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCarCodigoAprobacion.guardarCarCoAp(CarCodigAprobData carCodigAprob, Vector localizationLabels, HashMap userProperties):Entrada ");
    DAOCodigosAprobacion dao = new DAOCodigosAprobacion();
    
    UtilidadesLog.info("MONCarCodigoAprobacion.guardarCarCoAp(CarCodigAprobData carCodigAprob, Vector localizationLabels, HashMap userProperties):Entrada ");
        return dao.guardarCarCoAp(carCodigAprob, localizationLabels, userProperties);
        
    }
}
