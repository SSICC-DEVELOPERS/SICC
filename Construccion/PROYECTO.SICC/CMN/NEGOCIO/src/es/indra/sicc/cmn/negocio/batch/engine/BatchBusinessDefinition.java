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

package es.indra.sicc.cmn.negocio.batch.engine;

import java.io.IOException;

import org.apache.commons.configuration.PropertiesConfiguration;

import es.indra.mare.common.mln.businessdefinition.BusinessDefinition;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.util.UtilidadesLog;

import org.apache.commons.configuration.ConfigurationException;

/**
 * Represents a workflow with only one task
 */
public class BatchBusinessDefinition extends BusinessDefinition {
	private String queue;
	private String queueFactory;

  private static final String QUEUE_PROP = "queue";
  private static final String QUEUE_FACTORY_PROP = "queueFactory";

	/**
	 * Constructor.
	 * @param task String
	 */
	public BatchBusinessDefinition(String url) throws IOException, ConfigurationException {

                UtilidadesLog.debug("(SCS) voy a obtener las PropertiesConfiguration");
                UtilidadesLog.debug("valor, path: " + System.getProperty("MareConfigurationRoot") + "//" + url);
		PropertiesConfiguration conf = new PropertiesConfiguration(System.getProperty("MareConfigurationRoot") + "//" + url);
                UtilidadesLog.debug("(SCS) PropertiesConfiguration: " + conf);
		
		queue = conf.getString(QUEUE_PROP);
                UtilidadesLog.debug("(SCS) queue: " + queue);
    
		queueFactory = conf.getString(QUEUE_FACTORY_PROP);
                UtilidadesLog.debug("(SCS) queueFactory: " + queueFactory);
		
		BatchUtil.getLog().debug ("[BATCH] BatchBusinessDefinition config: queue="+queue+" queueFactory="+queueFactory);
	}
	
	public String getQueue() { return queue; }
	public String getQueueFactory() {	return queueFactory; }
} 