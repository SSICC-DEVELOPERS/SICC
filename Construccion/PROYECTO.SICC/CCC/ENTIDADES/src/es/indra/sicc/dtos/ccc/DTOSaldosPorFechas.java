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

import java.util.Date;

import es.indra.sicc.util.DTOBelcorp;

public class DTOSaldosPorFechas extends DTOBelcorp {
	
	private Long oidCliente;
	private Date fechaDocDesde;
	private Date fechaDocHasta;
	
	public DTOSaldosPorFechas() {
	}

	public Date getFechaDocDesde() {
		return fechaDocDesde;
	}

	public void setFechaDocDesde(Date newFechaDocDesde) {
		fechaDocDesde = newFechaDocDesde;
	}

	public Date getFechaDocHasta() {
		return fechaDocHasta;
	}

	public void setFechaDocHasta(Date newFechaDocHasta) {
		fechaDocHasta = newFechaDocHasta;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

}