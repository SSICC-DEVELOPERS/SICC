/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.msg;

import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.msg.DTOMensajesFacturacion;
import es.indra.sicc.dtos.msg.DTOLineasMensajes;
import es.indra.mare.common.exception.MareException;

public interface IMSG  {

  public DTOBuzonMensajes insertaDatosMensaje (DTOBuzonMensajes dto) throws MareException;

	public void eliminaDatosMensaje (DTOBuzonMensajes dto) throws MareException;
  
  public void eliminaMensajesFaltantesAnunciados (DTOBuzonMensajes dto) throws MareException;
	
}