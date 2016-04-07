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

public class DTOBuscarMovBancConsultar extends DTOSiccPaginacion {

	private Long oidBanco;
	private Long oidCuentaCorriente;
	private Date fechaMovimiento;
	private Boolean movActualizado;
	private Long tipoTransaccion;
	private String codigoCliente;	
	private Boolean saldoInicial;

	public DTOBuscarMovBancConsultar() {
		super();
	}

	public String getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		this.codigoCliente = newCodigoCliente;
	}

	public Date getFechaMovimiento() {
		return this.fechaMovimiento;
	}

	public void setFechaMovimiento(Date newFechaMovimiento) {
		this.fechaMovimiento = newFechaMovimiento;
	}

	public Boolean getMovActualizado() {
		return this.movActualizado;
	}

	public void setMovActualizado(Boolean newMovActualizado) {
		this.movActualizado = newMovActualizado;
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

	public Boolean getSaldoInicial() {
		return this.saldoInicial;
	}

	public void setSaldoInicial(Boolean newSaldoInicial) {
		this.saldoInicial = newSaldoInicial;
	}

	public Long getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(Long newTipoTransaccion) {
		this.tipoTransaccion = newTipoTransaccion;
	}
}