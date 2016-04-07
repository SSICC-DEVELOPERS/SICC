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
import java.util.Date;

public class DTODetalleCargosAbonos extends DTOBelcorp {

	private Double importe;
	private Double importeMoneda;
	private String glosaContable;
	private String observaciones;
	private Long medioPago;
	private Long moneda;
	private Long movimientoBancario;
	private Long cabecera;
	private Integer numLinea;
	private Integer numHistoriaGenera;
	private Long movimiento;
	private Long consultora;
	private String referenciaNumeroDocumento;
	private Date fechaMovimiento;
	private Long oid;
	private Long subproceso;
	private Long cuotaAnterior;
	private Long cuotaNueva;
	private Long tipoAbono;
	private Long cuentaCorriente;
	private String codigoUsuario;
	private Long empresa;

	public DTODetalleCargosAbonos() {
	}

	public Long getCabecera() {
		return this.cabecera;
	}

	public void setCabecera(Long newCabecera) {
		this.cabecera = newCabecera;
	}

	public Long getConsultora() {
		return this.consultora;
	}

	public void setConsultora(Long newConsultora) {
		this.consultora = newConsultora;
	}

	public Long getCuentaCorriente() {
		return this.cuentaCorriente;
	}

	public void setCuentaCorriente(Long newCuentaCorriente) {
		this.cuentaCorriente = newCuentaCorriente;
	}

	public Long getCuotaAnterior() {
		return this.cuotaAnterior;
	}

	public void setCuotaAnterior(Long newCuotaAnterior) {
		this.cuotaAnterior = newCuotaAnterior;
	}

	public Long getCuotaNueva() {
		return this.cuotaNueva;
	}

	public void setCuotaNueva(Long newCuotaNueva) {
		this.cuotaNueva = newCuotaNueva;
	}

	public Date getFechaMovimiento() {
		return this.fechaMovimiento;
	}

	public void setFechaMovimiento(Date newFechaMovimiento) {
		this.fechaMovimiento = newFechaMovimiento;
	}

	public String getGlosaContable() {
		return this.glosaContable;
	}

	public void setGlosaContable(String newGlosaContable) {
		this.glosaContable = newGlosaContable;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double newImporte) {
		this.importe = newImporte;
	}

	public Double getImporteMoneda() {
		return this.importeMoneda;
	}

	public void setImporteMoneda(Double newImporteMoneda) {
		this.importeMoneda = newImporteMoneda;
	}

	public Long getMedioPago() {
		return this.medioPago;
	}

	public void setMedioPago(Long newMedioPago) {
		this.medioPago = newMedioPago;
	}

	public Long getMoneda() {
		return this.moneda;
	}

	public void setMoneda(Long newMoneda) {
		this.moneda = newMoneda;
	}

	public Long getMovimiento() {
		return this.movimiento;
	}

	public void setMovimiento(Long newMovimiento) {
		this.movimiento = newMovimiento;
	}

	public Long getMovimientoBancario() {
		return this.movimientoBancario;
	}

	public void setMovimientoBancario(Long newMovimientoBancario) {
		this.movimientoBancario = newMovimientoBancario;
	}

	public Integer getNumHistoriaGenera() {
		return this.numHistoriaGenera;
	}

	public void setNumHistoriaGenera(Integer newNumHistoriaGenera) {
		this.numHistoriaGenera = newNumHistoriaGenera;
	}

	public Integer getNumLinea() {
		return this.numLinea;
	}

	public void setNumLinea(Integer newNumLinea) {
		this.numLinea = newNumLinea;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long newOid) {
		this.oid = newOid;
	}

	public String getReferenciaNumeroDocumento() {
		return this.referenciaNumeroDocumento;
	}

	public void setReferenciaNumeroDocumento(String newReferenciaNumeroDocumento) {
		this.referenciaNumeroDocumento = newReferenciaNumeroDocumento;
	}

	public Long getSubproceso() {
		return this.subproceso;
	}

	public void setSubproceso(Long newSubproceso) {
		this.subproceso = newSubproceso;
	}

	public Long getTipoAbono() {
		return this.tipoAbono;
	}

	public void setTipoAbono(Long newTipoAbono) {
		this.tipoAbono = newTipoAbono;
	}

	public String getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(String newCodigoUsuario) {
		this.codigoUsuario = newCodigoUsuario;
	}

	public Long getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		this.empresa = newEmpresa;
	}
}