package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarCondiEvaluNrData;
import es.indra.belcorp.mso.CarParamEvaluNrData;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MONCondicionEvaluacionNrBean implements SessionBean {
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


    public Vector query(CarCondiEvaluNrData carCondiEvaluNrFrom, 
                        CarCondiEvaluNrData carCondiEvaluNrTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info(" MONCondicionEvaluacionNR.query(CarCondiEvaluNrData carCondiEvaluNrFrom, CarCondiEvaluNrData carCondiEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCondicionEvaluacionNr dao = new DAOCondicionEvaluacionNr();
    
        UtilidadesLog.info(" MONCondicionEvaluacionNR.query(CarCondiEvaluNrData carCondiEvaluNrFrom, CarCondiEvaluNrData carCondiEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(carCondiEvaluNrFrom, carCondiEvaluNrTo, userProperties, pageCount, pageSize);
    
    }

    public void update(CarCondiEvaluNrData carCondiEvaluNr, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCondicionEvaluacionNR.update(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels): Entrada");
        ExtensionCARBean ext = new ExtensionCARBean();     
        MareDTO dto = new MareDTO();
        //Vector datos = new Vector();
        dto.addProperty("id", carCondiEvaluNr.getId());
        dto.addProperty("penrOidParaEvalNr", carCondiEvaluNr.getPenrOidParaEvalNr().getId());
        dto.addProperty("valMini", carCondiEvaluNr.getValMini());
        dto.addProperty("valMaxi", carCondiEvaluNr.getValMaxi());
        dto.addProperty("valEscaMini", carCondiEvaluNr.getValEscaMini());
        ext.validarModSolapamientoCodEvaluacion(dto);
    
        DAOCondicionEvaluacionNr dao = new DAOCondicionEvaluacionNr();
    
        dao.update(carCondiEvaluNr, localizationLabels);
        UtilidadesLog.info("MONCondicionEvaluacionNR.update(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels): Entrada");
   
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCondicionEvaluacionNR.remove(Vector entities): Entrada");
        DAOCondicionEvaluacionNr dao = new DAOCondicionEvaluacionNr();
        dao.remove(entities);
        UtilidadesLog.info("MONCondicionEvaluacionNR.remove(Vector entities): Salida");
    }

    public Hashtable guardarHasMap(CarCondiEvaluNrData carCondiEvaluNr, 
                                   Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info(" MONCondicionEvaluacionNR.guardarHasMap(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels, HashMap userProperties): Entrada");
        ExtensionCARBean ext = new ExtensionCARBean();     
        MareDTO dto = new MareDTO();
        //Vector datos = new Vector();
        dto.addProperty("id", carCondiEvaluNr.getId());
        dto.addProperty("penrOidParaEvalNr", carCondiEvaluNr.getPenrOidParaEvalNr().getId());
        dto.addProperty("valMini", carCondiEvaluNr.getValMini());
        dto.addProperty("valMaxi", carCondiEvaluNr.getValMaxi());
        dto.addProperty("valEscaMini", carCondiEvaluNr.getValEscaMini());
        ext.validarInsertarSolapamientoCodEvaluacion(dto);
        
        
        DAOCondicionEvaluacionNr dao = new DAOCondicionEvaluacionNr();
  
        UtilidadesLog.info(" MONCondicionEvaluacionNR.guardarHasMap(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarHasMap(carCondiEvaluNr, localizationLabels, userProperties);
    
    
    }

    private ExtensionCARHome getExtensionCARHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (ExtensionCARHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/ExtensionCAR" ), ExtensionCARHome.class );
    }

    public Vector query(CarParamEvaluNrData carParamEvaluNrFrom, 
                        CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties) throws MareException
    {   UtilidadesLog.info(" MONCondicionEvaluacionNr.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties): Entrada");
        DAOCondicionEvaluacionNr dao = new DAOCondicionEvaluacionNr();
    
        UtilidadesLog.info(" MONCCondicionEvaluacionNr.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties): Salida");
        return dao.query(carParamEvaluNrFrom, carParamEvaluNrTo,userProperties);
    
   
    }
}
