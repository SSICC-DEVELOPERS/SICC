package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarNivelRiesgData;
import es.indra.belcorp.mso.CarParamCalcuLcData;
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

public class MONParametrosCalculoLcBean implements SessionBean {
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

    public Vector query(CarNivelRiesgData carNivelRiesgFrom, 
                        CarNivelRiesgData carNivelRiesgTo, HashMap userProperties) throws MareException 
    {    UtilidadesLog.info("MONCarParamCalcuLc.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties): Entrada");
        DAOParametrosCalculoLc dao = new DAOParametrosCalculoLc();
    
        UtilidadesLog.info("MONCarParamCalcuLc.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties): Salida");
        return dao.query(carNivelRiesgFrom,carNivelRiesgTo, userProperties );
    
    }

    public void update1(CarParamCalcuLcData carParamCalcuLc, 
                        Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCarParamCalcuLC.update1(CarParamCalcuLcData carParamCalcuLc, Vector localizationLabels):Entrada");
        ExtensionCARBean ext = new ExtensionCARBean();     
        MareDTO dto = new MareDTO();
        
        dto.addProperty("id", carParamCalcuLc.getId());
        dto.addProperty("niriOidNiveRies", carParamCalcuLc.getNiriOidNiveRies().getId());
        dto.addProperty("valTope", carParamCalcuLc.getValTope());
        ext.validarModParamCalculoLC(dto);
        
        DAOParametrosCalculoLc dao = new DAOParametrosCalculoLc();
        dao.update(carParamCalcuLc, localizationLabels);
    
    UtilidadesLog.info("MONCarParamCalcuLC.update1(CarParamCalcuLcData carParamCalcuLc, Vector localizationLabels):Salida");
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONParamCalcuLC.remove(Vector entities):Entrada");
        DAOParametrosCalculoLc dao = new DAOParametrosCalculoLc();
        dao.remove(entities);
        UtilidadesLog.info("MONParamCalcuLC.remove(Vector entities):Salida");
    
    }

    public Hashtable guardarParam(CarParamCalcuLcData carParamCalcuLc, 
                                  Vector localizationLabels, HashMap userProperties) throws MareException 
    {   ExtensionCARBean ext = new ExtensionCARBean();     
        MareDTO dto = new MareDTO();
        //Vector datos = new Vector();
        dto.addProperty("id", carParamCalcuLc.getId());
        dto.addProperty("niriOidNiveRies", carParamCalcuLc.getNiriOidNiveRies().getId());
        dto.addProperty("valTope", carParamCalcuLc.getValTope());
        
        ext.validarInsertarParamCalculoLC(dto);
      
        DAOParametrosCalculoLc dao = new DAOParametrosCalculoLc();
        UtilidadesLog.info("MONCarParamCalcuLC.guardarParam(Vector entities):Salida");
        return dao.guardarParam(carParamCalcuLc, localizationLabels, userProperties);
  
    }

    public Vector query(CarParamCalcuLcData carParamCalcuLcFrom, 
                        CarParamCalcuLcData carParamCalcuLcTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
                        
    {   UtilidadesLog.info("MONParamCalcuLc.query(CarParamCalcuLcData carParamCalcuLcFrom, CarParamCalcuLcData carParamCalcuLcTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOParametrosCalculoLc dao = new DAOParametrosCalculoLc();
        UtilidadesLog.info("MONParamCalcuLc.query(CarParamCalcuLcData carParamCalcuLcFrom, CarParamCalcuLcData carParamCalcuLcTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(carParamCalcuLcFrom, carParamCalcuLcTo, userProperties, pageCount, pageSize);
          
    }

    private ExtensionCARHome getExtensionCARHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (ExtensionCARHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/ExtensionCAR" ), ExtensionCARHome.class );
    }
}
