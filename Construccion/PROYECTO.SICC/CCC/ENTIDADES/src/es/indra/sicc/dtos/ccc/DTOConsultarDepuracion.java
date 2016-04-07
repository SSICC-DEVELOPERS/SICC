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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.util.Date;

import java.math.BigDecimal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOConsultarDepuracion extends DTOSiccPaginacion {

	private Long oidCabecera;
	private Integer numero;
	private String anio;
	private String mes;
	private Date fechaImputacion;
	private String situacion;
	private String empresa;
	private String canal;
	private String acceso;
	private String subAcceso;
	private Integer numeroRegistrosDelNumero;
	private BigDecimal importeRegistrosDelNumero;
	private String referencia; 
	private String clienteDesde;
	private String clienteHasta;
	private Date fechaDocumentoDesde;  
	private Date fechaDocumentoHasta;
	private Date fechaVencimientoDesde;
	private Date fechaVencimientoHasta;   
	private String periodoDesde;
	private String periodoHasta;   
	private String observaciones;
	private RecordSet lineasDetalle;

	public String getAcceso() {
		return this.acceso;
	}

	public void setAcceso(String newAcceso) {
		this.acceso = newAcceso;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String newAnio) {
		this.anio = newAnio;
	}

	public String getCanal() {
		return this.canal;
	}

	public void setCanal(String newCanal) {
		this.canal = newCanal;
	}

	public String getClienteDesde() {
		return this.clienteDesde;
	}

	public void setClienteDesde(String newClienteDesde) {
		this.clienteDesde = newClienteDesde;
	}

	public String getClienteHasta() {
		return this.clienteHasta;
	}

	public void setClienteHasta(String newClienteHasta) {
		this.clienteHasta = newClienteHasta;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String newEmpresa) {
		this.empresa = newEmpresa;
	}

	public Date getFechaDocumentoDesde() {
		return this.fechaDocumentoDesde;
	}

	public void setFechaDocumentoDesde(Date newFechaDocumentoDesde) {
		this.fechaDocumentoDesde = newFechaDocumentoDesde;
	}

	public Date getFechaDocumentoHasta() {
		return this.fechaDocumentoHasta;
	}

	public void setFechaDocumentoHasta(Date newFechaDocumentoHasta) {
		this.fechaDocumentoHasta = newFechaDocumentoHasta;
	}

	public Date getFechaImputacion() {
		return this.fechaImputacion;
	}

	public void setFechaImputacion(Date newFechaImputacion) {
		this.fechaImputacion = newFechaImputacion;
	}

	public Date getFechaVencimientoDesde() {
		return this.fechaVencimientoDesde;
	}

	public void setFechaVencimientoDesde(Date newFechaVencimientoDesde) {
		this.fechaVencimientoDesde = newFechaVencimientoDesde;
	}

	public Date getFechaVencimientoHasta() {
		return this.fechaVencimientoHasta;
	}

	public void setFechaVencimientoHasta(Date newFechaVencimientoHasta) {
		this.fechaVencimientoHasta = newFechaVencimientoHasta;
	}

	public BigDecimal getImporteRegistrosDelNumero() {
		return this.importeRegistrosDelNumero;
	}

	public void setImporteRegistrosDelNumero(BigDecimal newImporteRegistrosDelNumero) {
		this.importeRegistrosDelNumero = newImporteRegistrosDelNumero;
	}

	public RecordSet getLineasDetalle() {
		return this.lineasDetalle;
	}

	public void setLineasDetalle(RecordSet newLineasDetalle) {
		this.lineasDetalle = newLineasDetalle;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String newMes) {
		this.mes = newMes;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer newNumero) {
		this.numero = newNumero;
	}

	public Integer getNumeroRegistrosDelNumero() {
		return this.numeroRegistrosDelNumero;
	}

	public void setNumeroRegistrosDelNumero(Integer newNumeroRegistrosDelNumero) {
		this.numeroRegistrosDelNumero = newNumeroRegistrosDelNumero;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
	}

	public Long getOidCabecera() {
		return this.oidCabecera;
	}

	public void setOidCabecera(Long newOidCabecera) {
		this.oidCabecera = newOidCabecera;
	}

	public String getPeriodoDesde() {
		return this.periodoDesde;
	}

	public void setPeriodoDesde(String newPeriodoDesde) {
		this.periodoDesde = newPeriodoDesde;
	}

	public String getPeriodoHasta() {
		return this.periodoHasta;
	}

	public void setPeriodoHasta(String newPeriodoHasta) {
		this.periodoHasta = newPeriodoHasta;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String newReferencia) {
		this.referencia = newReferencia;
	}

	public String getSituacion() {
		return this.situacion;
	}

	public void setSituacion(String newSituacion) {
		this.situacion = newSituacion;
	}

	public String getSubAcceso() {
		return this.subAcceso;
	}

	public void setSubAcceso(String newSubAcceso) {
		this.subAcceso = newSubAcceso;
	}
}