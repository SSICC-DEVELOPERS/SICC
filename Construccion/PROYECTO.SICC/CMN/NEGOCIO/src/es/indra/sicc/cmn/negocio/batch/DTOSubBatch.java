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

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;


/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class DTOSubBatch extends DTOBatch {
  
  private static final String PARENTID_PROPERTY = "parentID";
  
  public DTOSubBatch(String nombre, String parentID, String user, MareBusinessID IDOnline, IMareDTO DTOOnline) {
  	super(nombre, IDOnline, DTOOnline, user);
  	addProperty(PARENTID_PROPERTY, parentID);
  }
  
  public String getParentID(){
	  return (String)getProperty(PARENTID_PROPERTY);
	}
}
