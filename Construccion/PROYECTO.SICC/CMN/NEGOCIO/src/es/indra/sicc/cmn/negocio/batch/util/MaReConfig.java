/*
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.cmn.negocio.batch.util;

import org.apache.commons.configuration.Configuration;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;

/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class MaReConfig {
  private Configuration configuration = null;
  
  protected Configuration getConfiguration() throws MareException {
	  if (configuration == null)
	    configuration = ((MareMGC)MareMii.getService(new MareTopic (MareMii.SERVICE_MGC))).subset(getPrefix());
	  
	  if (configuration == null)
	    throw new MareException ("No se pudo recuperar la configuracion para " + getPrefix());    
	  return configuration;
  }
  
    protected abstract String getPrefix();
}
