package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarParamEvaluNrData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONParametrosEvaluacionNrBean implements SessionBean {
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

    public Vector query(CarParamEvaluNrData carParamEvaluNrFrom, 
                        CarParamEvaluNrData carParamEvaluNrTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
                        
    {   UtilidadesLog.info("MONCarParamEvaluNr.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada");
    
        DAOParametrosEvaluacionNr dao = new  DAOParametrosEvaluacionNr();
        
        UtilidadesLog.info("MONCarParamEvaluNr.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Salida");
        return dao.query(carParamEvaluNrFrom, carParamEvaluNrTo, userProperties, pageCount, pageSize);
    
    
    }

    public void remove(Vector entities) throws MareException
       
    {   UtilidadesLog.info("MONCarParamEvaluNr.remove(Vector entities): Entrada");
        DAOParametrosEvaluacionNr dao = new DAOParametrosEvaluacionNr();
        dao.remove(entities);
        
        UtilidadesLog.info("MONCarParamEvaluNr.remove(Vector entities): Salida");
    }

    public void update(CarParamEvaluNrData carParamEvaluNr, 
                       Vector localizationLabels) throws MareException 
    {
            UtilidadesLog.info("MONCarParamEvaluNr.update(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels): Entrada");
            DAOParametrosEvaluacionNr dao = new DAOParametrosEvaluacionNr();
            dao.update(carParamEvaluNr, localizationLabels);
            UtilidadesLog.info("MONCarParamEvaluNr.update(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels): Salida");
    }
    
    

    public Hashtable guardarParamEvalu(CarParamEvaluNrData carParamEvaluNr, 
                                       Vector localizationLabels, HashMap userProperties) throws MareException 
                                       
    {   UtilidadesLog.info("MONCarParamEvaluNr.guardarParamEvalu(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels, HashMap userProperties: Entrada");
        DAOParametrosEvaluacionNr dao = new DAOParametrosEvaluacionNr();
        
        UtilidadesLog.info("MONCarParamEvaluNr.guardarParamEvalu(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels, HashMap userProperties: Entrada");
        return dao.guardarParamEvalu(carParamEvaluNr, localizationLabels, userProperties);
    }
}
