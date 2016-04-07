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

import java.math.BigDecimal;

import java.util.Date;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarCuotasDtoRecargo extends DTOSiccPaginacion {
	private Long oidEmpresa;
	private Long oidCanal;
	private Long oidAcceso;
	private Long oidSubacceso;
	private Date fechaDocDesde;
	private Date fechaDocHasta;
	private Date fechaVtoDesde;
	private Date fechaVtoHasta;
	private String codigoClienteDesde;
	private String codigoClienteHasta;
	private Long oidSubproceso;
	private Integer diasCadencia;
	private Integer diasCorte;
	private Long[] marcasEntrada;
	private String codigoSubproceso;
	private Long oidClienteDesde;
	private Long oidClienteHasta;
	private BigDecimal tipoInteres;
	private BigDecimal importeFijo;
	private DTOEntidad[] seleccionados;
	private Integer numero;
	private String anio;
	private String mes;
	private Date fechaDoc;
	private String refExterna;
	private String observaciones;
	private String codigoCliente;
	private Long oidCliente;
	public DTOBuscarCuotasDtoRecargo() {
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String newAnio) {
		anio = newAnio;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public String getCodigoClienteDesde() {
		return codigoClienteDesde;
	}

	public void setCodigoClienteDesde(String newCodigoClienteDesde) {
		codigoClienteDesde = newCodigoClienteDesde;
	}

	public String getCodigoClienteHasta() {
		return codigoClienteHasta;
	}

	public void setCodigoClienteHasta(String newCodigoClienteHasta) {
		codigoClienteHasta = newCodigoClienteHasta;
	}

	public String getCodigoSubproceso() {
		return codigoSubproceso;
	}

	public void setCodigoSubproceso(String newCodigoSubproceso) {
		codigoSubproceso = newCodigoSubproceso;
	}

	public Integer getDiasCadencia() {
		return diasCadencia;
	}

	public void setDiasCadencia(Integer newDiasCadencia) {
		diasCadencia = newDiasCadencia;
	}

	public Integer getDiasCorte() {
		return diasCorte;
	}

	public void setDiasCorte(Integer newDiasCorte) {
		diasCorte = newDiasCorte;
	}

	public Date getFechaDoc() {
		return fechaDoc;
	}

	public void setFechaDoc(Date newFechaDoc) {
		fechaDoc = newFechaDoc;
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

	public Date getFechaVtoDesde() {
		return fechaVtoDesde;
	}

	public void setFechaVtoDesde(Date newFechaVtoDesde) {
		fechaVtoDesde = newFechaVtoDesde;
	}

	public Date getFechaVtoHasta() {
		return fechaVtoHasta;
	}

	public void setFechaVtoHasta(Date newFechaVtoHasta) {
		fechaVtoHasta = newFechaVtoHasta;
	}

	public BigDecimal getImporteFijo() {
		return importeFijo;
	}

	public void setImporteFijo(BigDecimal newImporteFijo) {
		importeFijo = newImporteFijo;
	}

	public Long[] getMarcasEntrada() {
		return marcasEntrada;
	}

	public void setMarcasEntrada(Long[] newMarcasEntrada) {
		marcasEntrada = newMarcasEntrada;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String newMes) {
		mes = newMes;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer newNumero) {
		numero = newNumero;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		observaciones = newObservaciones;
	}

	public Long getOidAcceso() {
		return oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		oidAcceso = newOidAcceso;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidClienteDesde() {
		return oidClienteDesde;
	}

	public void setOidClienteDesde(Long newOidClienteDesde) {
		oidClienteDesde = newOidClienteDesde;
	}

	public Long getOidClienteHasta() {
		return oidClienteHasta;
	}

	public void setOidClienteHasta(Long newOidClienteHasta) {
		oidClienteHasta = newOidClienteHasta;
	}

	public Long getOidEmpresa() {
		return oidEmpresa;
	}

	public void setOidEmpresa(Long newOidEmpresa) {
		oidEmpresa = newOidEmpresa;
	}

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}

	public Long getOidSubproceso() {
		return oidSubproceso;
	}

	public void setOidSubproceso(Long newOidSubproceso) {
		oidSubproceso = newOidSubproceso;
	}

	public String getRefExterna() {
		return refExterna;
	}

	public void setRefExterna(String newRefExterna) {
		refExterna = newRefExterna;
	}

	public DTOEntidad[] getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(DTOEntidad[] newSeleccionados) {
		seleccionados = newSeleccionados;
	}

	public BigDecimal getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(BigDecimal newTipoInteres) {
		tipoInteres = newTipoInteres;
	}
}