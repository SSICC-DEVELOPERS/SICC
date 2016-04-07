package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarParamNrData;
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

public class MONParametrosNrBean implements SessionBean {
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

    public Vector query(CarParamNrData carParamNrFrom, 
                        CarParamNrData carParamNrTo, HashMap userProperties, 
                        Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCarParametrosNrBean.query(CarParamNrData carParamNrFrom, CarParamNrData carParamNrTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
    
        DAOParametrosNr dao = new DAOParametrosNr();   
    
        UtilidadesLog.info("MONCarParametrosNrBean.query(CarParamNrData carParamNrFrom, CarParamNrData carParamNrTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(carParamNrFrom, carParamNrTo, userProperties, pageCount, pageSize);
      
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCarParametrosNR.remove(Vector entities):Entrada");
        DAOParametrosNr dao = new DAOParametrosNr();
        dao.remove(entities);
        UtilidadesLog.info("MONCarParametrosNR.remove(Vector entities):Salida");
    }

    public void update(CarParamNrData carParamNr, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCarParametrosNR.update(CarParamNrData carParamNr, Vector localizationLabels):Entrada" );
    
        ExtensionCARBean ext = new ExtensionCARBean();     
        MareDTO dto = new MareDTO();
        //Vector datos = new Vector();
        dto.addProperty("id", carParamNr.getId());
        dto.addProperty("valMini", carParamNr.getValMini());
        dto.addProperty("valMaxi", carParamNr.getValMaxi());
        ext.validarModSolapamientoParamNR(dto);
        
        DAOParametrosNr dao = new DAOParametrosNr();
        dao.update(carParamNr, localizationLabels);
    }

    public Hashtable guardarParamNr(CarParamNrData carParamNr, 
                                    Vector localizationLabels, HashMap userProperties) throws MareException 
    {    UtilidadesLog.info("MONCarParametrosNrBean.guardarParamNr(CarParamNrData carParamNr, Vector localizationLabels, HashMap userProperties):Entrada");
        ExtensionCARBean ext = new ExtensionCARBean();     
        MareDTO dto = new MareDTO();
        dto.addProperty("id", carParamNr.getId());
        dto.addProperty("valMini", carParamNr.getValMini());
        dto.addProperty("valMaxi", carParamNr.getValMaxi());
        
        ext.validarInsertarSolapamientoParamNR(dto);
        
        DAOParametrosNr dao = new DAOParametrosNr();
    
        UtilidadesLog.info("MONCarParametrosNrBean.guardarParamNr(CarParamNrData carParamNr, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardarParamNr(carParamNr, localizationLabels, userProperties);
    
   
    }

    private ExtensionCARHome getExtensionCARHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (ExtensionCARHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/ExtensionCAR" ), ExtensionCARHome.class );
    }
}
