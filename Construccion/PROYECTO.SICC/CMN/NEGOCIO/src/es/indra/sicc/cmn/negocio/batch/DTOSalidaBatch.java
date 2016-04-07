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

package es.indra.sicc.cmn.negocio.batch;

import es.indra.mare.common.dto.MareDTO;


/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class DTOSalidaBatch extends MareDTO {
  
  private static final String COD_RES_PROPERTY   = "codRes";
  private static final String STR_RES_PROPERTY   = "strRes";
  private static final String PROCESSID_PROPERTY = "processID";
    
  public DTOSalidaBatch(String processID) {
  	super();
  	addProperty(PROCESSID_PROPERTY, processID);
  }
  
  public DTOSalidaBatch(int codigo, String mensaje) {
  	super();
  	addProperty(COD_RES_PROPERTY, new Integer(codigo));
  	addProperty(STR_RES_PROPERTY, mensaje);
  }
  
  public int getCodigo(){
	  return getInt(COD_RES_PROPERTY);
	}
  
  public String getMensaje() {
  	return getString(STR_RES_PROPERTY);
  }
  
  public String getProcessID() {
	  return getString(PROCESSID_PROPERTY);
	}
}
