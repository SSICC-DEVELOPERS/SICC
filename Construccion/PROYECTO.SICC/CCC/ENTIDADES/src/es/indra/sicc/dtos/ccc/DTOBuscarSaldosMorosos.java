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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOBuscarSaldosMorosos extends DTOSiccPaginacion {

	private Long acceso;
	private Long canal;
	private Long subacceso;
	private String clienteDesde;
	private String clienteHasta;
	private Date fechaDocumentoDesde;
	private Date fechaDocumentoHasta;
	private String periodoDesde;
	private String periodoHasta;
	private Double importeDesde;
	private Double importeHasta;
	private String observaciones;
	// BELC300003406 
	private Date fechaVencimientoDesde;
	private Date fechaVencimientoHasta;

	private Long empresa;
	private Long proceso;
	private String subproceso;

	// Incidencia BELC300009046
	private Long oidClienteDesde;
	private Long oidClienteHasta;
	private Long oidPeriodoDesde;
	private Long oidPeriodoHasta;
	
	public DTOBuscarSaldosMorosos() {
	}

	public Long getAcceso() {
		return this.acceso;
	}

	public void setAcceso(Long newAcceso) {
		this.acceso = newAcceso;
	}

	public Long getCanal() {
		return this.canal;
	}

	public void setCanal(Long newCanal) {
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



	public Double getImporteDesde() {
		return this.importeDesde;
	}

	public void setImporteDesde(Double newImporteDesde) {
		this.importeDesde = newImporteDesde;
	}

	public Double getImporteHasta() {
		return this.importeHasta;
	}

	public void setImporteHasta(Double newImporteHasta) {
		this.importeHasta = newImporteHasta;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
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



	public Long getSubacceso() {
		return this.subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		this.subacceso = newSubacceso;
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



	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		empresa = newEmpresa;
	}

	public Long getProceso() {
		return proceso;
	}

	public void setProceso(Long newProceso) {
		proceso = newProceso;
	}

	public String getSubproceso() {
		return subproceso;
	}

	public void setSubproceso(String newSubproceso) {
		subproceso = newSubproceso;
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

	public Long getOidPeriodoDesde() {
		return oidPeriodoDesde;
	}

	public void setOidPeriodoDesde(Long newOidPeriodoDesde) {
		oidPeriodoDesde = newOidPeriodoDesde;
	}

	public Long getOidPeriodoHasta() {
		return oidPeriodoHasta;
	}

	public void setOidPeriodoHasta(Long newOidPeriodoHasta) {
		oidPeriodoHasta = newOidPeriodoHasta;
	}
}