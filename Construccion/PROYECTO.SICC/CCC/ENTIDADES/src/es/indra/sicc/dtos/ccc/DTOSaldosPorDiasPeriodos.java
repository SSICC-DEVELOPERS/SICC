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

public class DTOSaldosPorDiasPeriodos extends DTOBelcorp {

	private Long oidCliente;
	private Integer diasDesde;
	private Integer diasHasta;
	private Long oidTipoCliente;
	private Long oidTipoPeriodo;
	private Long oidPeriodo;
	
	public DTOSaldosPorDiasPeriodos() {
	}

	public Integer getDiasDesde() {
		return diasDesde;
	}

	public void setDiasDesde(Integer newDiasDesde) {
		diasDesde = newDiasDesde;
	}

	public Integer getDiasHasta() {
		return diasHasta;
	}

	public void setDiasHasta(Integer newDiasHasta) {
		diasHasta = newDiasHasta;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		oidPeriodo = newOidPeriodo;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public Long getOidTipoPeriodo() {
		return oidTipoPeriodo;
	}

	public void setOidTipoPeriodo(Long newOidTipoPeriodo) {
		oidTipoPeriodo = newOidTipoPeriodo;
	}
}