/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

//DTOFACEstadoSolicitud añadido por incidencia  BELC300008725
public class DTOFACEstadoSolicitud extends DTOBelcorp {

	private Long oid;
	private String estado;
	
	
	public DTOFACEstadoSolicitud() {
		super();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String newEstado) {
		estado = newEstado;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}
}