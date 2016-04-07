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

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOBloquearCliente extends DTOBelcorp {
	private Long oidCliente;
	private String observacionesBloqueo;
	private String motivoBloqueo;

	public DTOBloquearCliente() {
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public String getObservacionesBloqueo() {
		return observacionesBloqueo;
	}

	public void setObservacionesBloqueo(String newObservacionesBloqueo) {
		observacionesBloqueo = newObservacionesBloqueo;
	}

	public String getMotivoBloqueo() {
		return motivoBloqueo;
	}

	public void setMotivoBloqueo(String newMotivoBloqueo) {
		motivoBloqueo = newMotivoBloqueo;
	}
}