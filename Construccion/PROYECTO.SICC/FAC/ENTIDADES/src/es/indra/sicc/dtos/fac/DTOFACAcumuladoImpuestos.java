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
import es.indra.sicc.util.DTOBelcorp;

public class DTOFACAcumuladoImpuestos extends DTOBelcorp  {

	private Long oidIndicadorImpuesto;   
	private Float baseImponibleTotalLocal;
	private Float totalImpuestosLocal;      
	private Float totalImporteLocal;      
	private Long oid;      
	private Float baseImponiblePosicionLocal;      
	private Float totalPreciosPosicionLocal;      
	private Float totalDescuentoCabeceraLocal;      
	private Float baseImponibleDescuentoCabeceraLocal;      
	private Float baseImponiblePrecioContableLocal;      
	private Float baseImponibleFleteLocal;      
	private Float baseImponiblePosicionDocumento;      
	private Float totalPreciosPosicionDocumento;      
	private Float totalDescuentoCabeceraDocumento;      
	private Float baseImponibleDescuentoCabeceraDocumento;      
	private Float baseImponiblePrecioContableDocumento;      
	private Float baseImponibleFleteDocumento;      
	private Float baseImponibleTotalDocumento;      
	private Float totalImpuestosDocumento;      
	private Float totalImporteDocumento;      
	private Long oidCabeceraContable;

	public Float getBaseImponibleDescuentoCabeceraDocumento() {
		return this.baseImponibleDescuentoCabeceraDocumento;
	}

	public void setBaseImponibleDescuentoCabeceraDocumento(Float newBaseImponibleDescuentoCabeceraDocumento) {
		this.baseImponibleDescuentoCabeceraDocumento = newBaseImponibleDescuentoCabeceraDocumento;
	}

	public Float getBaseImponibleDescuentoCabeceraLocal() {
		return this.baseImponibleDescuentoCabeceraLocal;
	}

	public void setBaseImponibleDescuentoCabeceraLocal(Float newBaseImponibleDescuentoCabeceraLocal) {
		this.baseImponibleDescuentoCabeceraLocal = newBaseImponibleDescuentoCabeceraLocal;
	}

	public Float getBaseImponibleFleteDocumento() {
		return this.baseImponibleFleteDocumento;
	}

	public void setBaseImponibleFleteDocumento(Float newBaseImponibleFleteDocumento) {
		this.baseImponibleFleteDocumento = newBaseImponibleFleteDocumento;
	}

	public Float getBaseImponibleFleteLocal() {
		return this.baseImponibleFleteLocal;
	}

	public void setBaseImponibleFleteLocal(Float newBaseImponibleFleteLocal) {
		this.baseImponibleFleteLocal = newBaseImponibleFleteLocal;
	}

	public Float getBaseImponiblePosicionDocumento() {
		return this.baseImponiblePosicionDocumento;
	}

	public void setBaseImponiblePosicionDocumento(Float newBaseImponiblePosicionDocumento) {
		this.baseImponiblePosicionDocumento = newBaseImponiblePosicionDocumento;
	}

	public Float getBaseImponiblePosicionLocal() {
		return this.baseImponiblePosicionLocal;
	}

	public void setBaseImponiblePosicionLocal(Float newBaseImponiblePosicionLocal) {
		this.baseImponiblePosicionLocal = newBaseImponiblePosicionLocal;
	}

	public Float getBaseImponiblePrecioContableDocumento() {
		return this.baseImponiblePrecioContableDocumento;
	}

	public void setBaseImponiblePrecioContableDocumento(Float newBaseImponiblePrecioContableDocumento) {
		this.baseImponiblePrecioContableDocumento = newBaseImponiblePrecioContableDocumento;
	}

	public Float getBaseImponiblePrecioContableLocal() {
		return this.baseImponiblePrecioContableLocal;
	}

	public void setBaseImponiblePrecioContableLocal(Float newBaseImponiblePrecioContableLocal) {
		this.baseImponiblePrecioContableLocal = newBaseImponiblePrecioContableLocal;
	}

	public Float getBaseImponibleTotalDocumento() {
		return this.baseImponibleTotalDocumento;
	}

	public void setBaseImponibleTotalDocumento(Float newBaseImponibleTotalDocumento) {
		this.baseImponibleTotalDocumento = newBaseImponibleTotalDocumento;
	}

	public Float getBaseImponibleTotalLocal() {
		return this.baseImponibleTotalLocal;
	}

	public void setBaseImponibleTotalLocal(Float newBaseImponibleTotalLocal) {
		this.baseImponibleTotalLocal = newBaseImponibleTotalLocal;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long newOid) {
		this.oid = newOid;
	}

	public Long getOidCabeceraContable() {
		return this.oidCabeceraContable;
	}

	public void setOidCabeceraContable(Long newOidCabeceraContable) {
		this.oidCabeceraContable = newOidCabeceraContable;
	}

	public Long getOidIndicadorImpuesto() {
		return this.oidIndicadorImpuesto;
	}

	public void setOidIndicadorImpuesto(Long newOidIndicadorImpuesto) {
		this.oidIndicadorImpuesto = newOidIndicadorImpuesto;
	}

	public Float getTotalDescuentoCabeceraDocumento() {
		return this.totalDescuentoCabeceraDocumento;
	}

	public void setTotalDescuentoCabeceraDocumento(Float newTotalDescuentoCabeceraDocumento) {
		this.totalDescuentoCabeceraDocumento = newTotalDescuentoCabeceraDocumento;
	}

	public Float getTotalDescuentoCabeceraLocal() {
		return this.totalDescuentoCabeceraLocal;
	}

	public void setTotalDescuentoCabeceraLocal(Float newTotalDescuentoCabeceraLocal) {
		this.totalDescuentoCabeceraLocal = newTotalDescuentoCabeceraLocal;
	}

	public Float getTotalImporteDocumento() {
		return this.totalImporteDocumento;
	}

	public void setTotalImporteDocumento(Float newTotalImporteDocumento) {
		this.totalImporteDocumento = newTotalImporteDocumento;
	}

	public Float getTotalImporteLocal() {
		return this.totalImporteLocal;
	}

	public void setTotalImporteLocal(Float newTotalImporteLocal) {
		this.totalImporteLocal = newTotalImporteLocal;
	}

	public Float getTotalImpuestosDocumento() {
		return this.totalImpuestosDocumento;
	}

	public void setTotalImpuestosDocumento(Float newTotalImpuestosDocumento) {
		this.totalImpuestosDocumento = newTotalImpuestosDocumento;
	}

	public Float getTotalImpuestosLocal() {
		return this.totalImpuestosLocal;
	}

	public void setTotalImpuestosLocal(Float newTotalImpuestosLocal) {
		this.totalImpuestosLocal = newTotalImpuestosLocal;
	}

	public Float getTotalPreciosPosicionDocumento() {
		return this.totalPreciosPosicionDocumento;
	}

	public void setTotalPreciosPosicionDocumento(Float newTotalPreciosPosicionDocumento) {
		this.totalPreciosPosicionDocumento = newTotalPreciosPosicionDocumento;
	}

	public Float getTotalPreciosPosicionLocal() {
		return this.totalPreciosPosicionLocal;
	}

	public void setTotalPreciosPosicionLocal(Float newTotalPreciosPosicionLocal) {
		this.totalPreciosPosicionLocal = newTotalPreciosPosicionLocal;
	}
}