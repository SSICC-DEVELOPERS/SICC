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

public class DTOBuscarMovCCConfirmar extends DTOBelcorp {

	private Integer numeroIdentCuota;
	private Long oidCliente;

	public DTOBuscarMovCCConfirmar() {
		super();
	}

	public Integer getNumeroIdentCuota() {
		return this.numeroIdentCuota;
	}

	public void setNumeroIdentCuota(Integer newNumeroIdentCuota) {
		this.numeroIdentCuota = newNumeroIdentCuota;
	}

	public Long getOidCliente() {
		return this.oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		this.oidCliente = newOidCliente;
	}
}