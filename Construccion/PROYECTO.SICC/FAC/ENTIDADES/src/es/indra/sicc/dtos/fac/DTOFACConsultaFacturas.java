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

import java.util.Date;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOFACConsultaFacturas extends DTOSiccPaginacion { //Para poder ser utilizado en el metodo consultarFacturas 

	private Long rangoDesdeDocumentoInterno;
	private Long rangoHastaDocumentoInterno;
	private String serieDocumentoLegal;
	private Long rangoDesdeDocumentoLegal;
	private Long rangoHastaDocumentoLegal;
	private Long canal;
	private Long acceso;
	private Long subacceso;
	private Long numeroConsolidadoDesde;
	private Long numeroConsolidadoHasta;
	private Date fechaFacturacionDesde;
	private Date fechaFacturacionHasta;
	private Date fechaProcesoDesde;
	private Date fechaProcesoHasta;
	private Long pais;
	private String codigoCliente;
	private Long tipoDocumentoContable;
	private Long ejercicio;

	public DTOFACConsultaFacturas() {
	}

	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public Long getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Long newEjercicio) {
		ejercicio = newEjercicio;
	}

	public Date getFechaFacturacionDesde() {
		return fechaFacturacionDesde;
	}

	public void setFechaFacturacionDesde(Date newFechaFacturacionDesde) {
		fechaFacturacionDesde = newFechaFacturacionDesde;
	}

	public Date getFechaFacturacionHasta() {
		return fechaFacturacionHasta;
	}

	public void setFechaFacturacionHasta(Date newFechaFacturacionHasta) {
		fechaFacturacionHasta = newFechaFacturacionHasta;
	}

	public Date getFechaProcesoDesde() {
		return fechaProcesoDesde;
	}

	public void setFechaProcesoDesde(Date newFechaProcesoDesde) {
		fechaProcesoDesde = newFechaProcesoDesde;
	}

	public Date getFechaProcesoHasta() {
		return fechaProcesoHasta;
	}

	public void setFechaProcesoHasta(Date newFechaProcesoHasta) {
		fechaProcesoHasta = newFechaProcesoHasta;
	}

	public Long getNumeroConsolidadoDesde() {
		return numeroConsolidadoDesde;
	}

	public void setNumeroConsolidadoDesde(Long newNumeroConsolidadoDesde) {
		numeroConsolidadoDesde = newNumeroConsolidadoDesde;
	}

	public Long getNumeroConsolidadoHasta() {
		return numeroConsolidadoHasta;
	}

	public void setNumeroConsolidadoHasta(Long newNumeroConsolidadoHasta) {
		numeroConsolidadoHasta = newNumeroConsolidadoHasta;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	}

	public Long getRangoDesdeDocumentoInterno() {
		return rangoDesdeDocumentoInterno;
	}

	public void setRangoDesdeDocumentoInterno(Long newRangoDesdeDocumentoInterno) {
		rangoDesdeDocumentoInterno = newRangoDesdeDocumentoInterno;
	}

	public Long getRangoDesdeDocumentoLegal() {
		return rangoDesdeDocumentoLegal;
	}

	public void setRangoDesdeDocumentoLegal(Long newRangoDesdeDocumentoLegal) {
		rangoDesdeDocumentoLegal = newRangoDesdeDocumentoLegal;
	}

	public Long getRangoHastaDocumentoInterno() {
		return rangoHastaDocumentoInterno;
	}

	public void setRangoHastaDocumentoInterno(Long newRangoHastaDocumentoInterno) {
		rangoHastaDocumentoInterno = newRangoHastaDocumentoInterno;
	}

	public Long getRangoHastaDocumentoLegal() {
		return rangoHastaDocumentoLegal;
	}

	public void setRangoHastaDocumentoLegal(Long newRangoHastaDocumentoLegal) {
		rangoHastaDocumentoLegal = newRangoHastaDocumentoLegal;
	}

	public String getSerieDocumentoLegal() {
		return serieDocumentoLegal;
	}

	public void setSerieDocumentoLegal(String newSerieDocumentoLegal) {
		serieDocumentoLegal = newSerieDocumentoLegal;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Long getTipoDocumentoContable() {
		return tipoDocumentoContable;
	}

	public void setTipoDocumentoContable(Long newTipoDocumentoContable) {
		tipoDocumentoContable = newTipoDocumentoContable;
	}
}