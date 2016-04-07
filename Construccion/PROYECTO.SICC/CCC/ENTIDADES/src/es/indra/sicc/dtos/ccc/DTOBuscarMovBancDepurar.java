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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarMovBancDepurar extends DTOSiccPaginacion {

	private Long oidBanco;
	private Long oidCuentaCorriente;
	private Date fechaMovDesde;
	private Date fechaMovHasta;

	public DTOBuscarMovBancDepurar() {
		super();
	}

	public Date getFechaMovDesde() {
		return this.fechaMovDesde;
	}

	public void setFechaMovDesde(Date newFechaMovDesde) {
		this.fechaMovDesde = newFechaMovDesde;
	}

	public Date getFechaMovHasta() {
		return this.fechaMovHasta;
	}

	public void setFechaMovHasta(Date newFechaMovHasta) {
		this.fechaMovHasta = newFechaMovHasta;
	}

	public Long getOidBanco() {
		return this.oidBanco;
	}

	public void setOidBanco(Long newOidBanco) {
		this.oidBanco = newOidBanco;
	}

	public Long getOidCuentaCorriente() {
		return this.oidCuentaCorriente;
	}

	public void setOidCuentaCorriente(Long newOidCuentaCorriente) {
		this.oidCuentaCorriente = newOidCuentaCorriente;
	}
	
}