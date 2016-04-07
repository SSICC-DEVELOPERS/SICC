package es.indra.sicc.cmn.negocio.interfaces.daemon.util;

import org.apache.commons.configuration.Configuration;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;

public abstract class MareConfig {
  private Configuration configuration = null;
  
  protected Configuration getConfiguration() throws MareException {
	  if (configuration == null)
	    configuration = ((MareMGC)MareMii.getService(new MareTopic (MareMii.SERVICE_MGC))).subset(getPrefix());
	  
	  if (configuration == null)
	    throw new MareException ("No se pudo recuperar la configuracion para: " + getPrefix());    
	  return configuration;
  }
  
  protected abstract String getPrefix();
}
