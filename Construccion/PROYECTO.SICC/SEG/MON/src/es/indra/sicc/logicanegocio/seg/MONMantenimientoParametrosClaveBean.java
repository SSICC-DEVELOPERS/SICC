package es.indra.sicc.logicanegocio.seg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareXMLMGC;
import es.indra.mare.common.mgu.manager.FactoryManager;
import es.indra.mare.common.mii.MareMii;
import es.indra.sicc.dtos.seg.ParametrosClaveDTO;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.NoSuchElementException;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLPropertiesConfiguration;


import org.apache.commons.configuration.ConfigurationException;


public class MONMantenimientoParametrosClaveBean implements SessionBean 
{

	//private final String RUTA_MGU_PROPERTIES = "/mgu/mgu.properties";
	 private final String RUTA_MGU_PROPERTIES = "/MareConfiguration.xml";
  private SessionContext ctx;
  

  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
    this.ctx = ctx;
  }

  public ParametrosClaveDTO consulta() throws MareException{
        UtilidadesLog.info("MONMantenimientoParametrosClave.consulta():Entrada");
        Integer diasCambio = null;
        Integer numeroRepeticiones = null;
        Integer longitudMinima = null;
        Integer numeroMaximoIntentos = null;

        MareXMLMGC mguProperties = new MareXMLMGC(System.getProperty("MareConfigurationRoot") + RUTA_MGU_PROPERTIES);

        try {
            if(mguProperties.getString("services.MGUService.userManager.expireTime") != null)
                diasCambio = mguProperties.getInt("services.MGUService.userManager.expireTime");
        } catch(NoSuchElementException nsee) {
                nsee.printStackTrace();
                diasCambio = null;
        }

        try {
            if(mguProperties.getString("services.MGUService.userManager.passwordHistorySize") != null)
                numeroRepeticiones = mguProperties.getInt("services.MGUService.userManager.passwordHistorySize");
        } catch(NoSuchElementException nsee) {
            nsee.printStackTrace();
            numeroRepeticiones = null;
        }

        try {
            if(mguProperties.getString("services.MGUService.userManager.passwordMinSize") != null)
                longitudMinima = mguProperties.getInt("services.MGUService.userManager.passwordMinSize");
        } catch(NoSuchElementException nsee) {
            nsee.printStackTrace();
            longitudMinima = null;
        }

        try {
            if(mguProperties.getString("services.MGUService.userManager.maxRetries") != null)
                numeroMaximoIntentos = mguProperties.getInt("services.MGUService.userManager.maxRetries");
        } catch(NoSuchElementException nsee) {
            nsee.printStackTrace();
            numeroMaximoIntentos = null;
        }
        
        UtilidadesLog.info("MONMantenimientoParametrosClave.consulta():Salida");
        return new ParametrosClaveDTO(diasCambio, numeroRepeticiones, longitudMinima, numeroMaximoIntentos);
  }

  public void modifica(ParametrosClaveDTO dtoe) throws MareException{
        UtilidadesLog.info("MONMantenimientoParametrosClave.modifica(ParametrosClaveDTO):Entrada");

        if((dtoe.getDiasCambio() == null) || (dtoe.getLongitudMinina() == null) || (dtoe.getNumeroRepeticiones() == null) || (dtoe.getNumeroRepeticiones() == null) )
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO));

        MareXMLMGC mguProperties = new MareXMLMGC(System.getProperty("MareConfigurationRoot") + RUTA_MGU_PROPERTIES);

        if (mguProperties.getString("services.MGUService.userManager.expireTime") == null)	
            mguProperties.addProperty("services.MGUService.userManager.expireTime", dtoe.getDiasCambio().toString());
         else 
            mguProperties.setProperty("services.MGUService.userManager.expireTime", dtoe.getDiasCambio().toString());

        if (mguProperties.getString("services.MGUService.userManager.passwordHistorySize") == null)  
            mguProperties.addProperty("services.MGUService.userManager.passwordHistorySize", dtoe.getNumeroRepeticiones().toString());
         else 
            mguProperties.setProperty("services.MGUService.userManager.passwordHistorySize", dtoe.getNumeroRepeticiones().toString());

        if (mguProperties.getString("services.MGUService.userManager.passwordMinSize") == null)  
            mguProperties.addProperty("services.MGUService.userManager.passwordMinSize", dtoe.getLongitudMinina().toString());
         else 
            mguProperties.setProperty("services.MGUService.userManager.passwordMinSize", dtoe.getLongitudMinina().toString());

        if (mguProperties.getString("services.MGUService.userManager.maxRetries") == null)  
            mguProperties.addProperty("services.MGUService.userManager.maxRetries", dtoe.getNumeroMaximoIntentos().toString());
         else 
            mguProperties.setProperty("services.MGUService.userManager.maxRetries", dtoe.getNumeroMaximoIntentos().toString());

        mguProperties.save();
        MareMii.restart();
        UtilidadesLog.info("MONMantenimientoParametrosClave.modifica(ParametrosClaveDTO):Salida");
        return;
  
  }

    
}