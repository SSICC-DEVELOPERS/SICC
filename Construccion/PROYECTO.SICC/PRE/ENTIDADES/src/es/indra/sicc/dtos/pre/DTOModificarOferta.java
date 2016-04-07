/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOECargarCriteriosDefinirOferta;


public class DTOModificarOferta extends DTOAuditableSICC 
{
  private DTOOferta dtoOferta= null;
  private DTOSCargarCriteriosDefinirOferta dtoCargarCriterios = null;

  public DTOModificarOferta()
  {
  }

	public DTOOferta getDtoOferta() {
		return dtoOferta;
	}

	public void setDtoOferta(DTOOferta newDtoOferta) {
		dtoOferta = newDtoOferta;
	}

	public DTOSCargarCriteriosDefinirOferta getDtoCargarCriterios() {
		return dtoCargarCriterios;
	}

	public void setDtoCargarCriterios(DTOSCargarCriteriosDefinirOferta newDtoCargarCriterios) {
		dtoCargarCriterios = newDtoCargarCriterios;
	}
  
}