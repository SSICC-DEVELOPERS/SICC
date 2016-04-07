/*
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.cmn.negocio.batch.engine;

import java.io.IOException;
import es.indra.mare.common.mln.businessdefinition.BusinessDefinition;
import es.indra.sicc.util.UtilidadesLog;

import org.apache.commons.configuration.ConfigurationException;

public class BatchBusinessDefinitionFactory {
	public BusinessDefinition create(String url) throws IOException, ConfigurationException {
    UtilidadesLog.debug("(SCS), voy a un BatchBusinessDefinition, con: " + url);
		return new BatchBusinessDefinition(url);		
  }
}
