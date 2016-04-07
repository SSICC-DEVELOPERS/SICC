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

public class DTOFACCalculosImpuestos  extends DTOBelcorp{

	private Float baseImponiblePosicionLocal;   
	private Float totalPreciosPosicionLocal;
	private Float totalDescuentoCabeceraLocal;   
	private Float baseImponibleDescuentoCabeceraLocal;   
	private Float baseImponiblePrecioContableLocal;
	private Float baseImponibleFleteLocal;
	private Float totalBaseImponibleLocal;
	private Float totalImpuestosLocal;
	private Float totalImporteLocal;   
	private Float baseImponiblePosicionDocumento;   
	private Float totalPreciosPosicionDocumento;   
	private Float totalDescuentoCabeceraDocumento;   
	private Float baseImponibleDescuentoCabeceraDocumento;   
	private Float baseImponiblePrecioContableDocumento;   
	private Float baseImponibleFleteDocumento;   
	private Float totalBaseImponibleDocumento;   
	private Float totalImpuestosDocumento;
	private Float totalImporteDocumento;
	
	public DTOFACCalculosImpuestos() {
				super();
	}

	public Float getBaseImponibleDescuentoCabeceraDocumento() {
		return baseImponibleDescuentoCabeceraDocumento;
	}

	public void setBaseImponibleDescuentoCabeceraDocumento(Float newBaseImponibleDescuentoCabeceraDocumento) {
		baseImponibleDescuentoCabeceraDocumento = newBaseImponibleDescuentoCabeceraDocumento;
	}

	public Float getBaseImponibleDescuentoCabeceraLocal() {
		return baseImponibleDescuentoCabeceraLocal;
	}

	public void setBaseImponibleDescuentoCabeceraLocal(Float newBaseImponibleDescuentoCabeceraLocal) {
		baseImponibleDescuentoCabeceraLocal = newBaseImponibleDescuentoCabeceraLocal;
	}

	public Float getBaseImponibleFleteDocumento() {
		return baseImponibleFleteDocumento;
	}

	public void setBaseImponibleFleteDocumento(Float newBaseImponibleFleteDocumento) {
		baseImponibleFleteDocumento = newBaseImponibleFleteDocumento;
	}

	public Float getBaseImponibleFleteLocal() {
		return baseImponibleFleteLocal;
	}

	public void setBaseImponibleFleteLocal(Float newBaseImponibleFleteLocal) {
		baseImponibleFleteLocal = newBaseImponibleFleteLocal;
	}

	public Float getBaseImponiblePosicionDocumento() {
		return baseImponiblePosicionDocumento;
	}

	public void setBaseImponiblePosicionDocumento(Float newBaseImponiblePosicionDocumento) {
		baseImponiblePosicionDocumento = newBaseImponiblePosicionDocumento;
	}

	public Float getBaseImponiblePosicionLocal() {
		return baseImponiblePosicionLocal;
	}

	public void setBaseImponiblePosicionLocal(Float newBaseImponiblePosicionLocal) {
		baseImponiblePosicionLocal = newBaseImponiblePosicionLocal;
	}

	public Float getBaseImponiblePrecioContableDocumento() {
		return baseImponiblePrecioContableDocumento;
	}

	public void setBaseImponiblePrecioContableDocumento(Float newBaseImponiblePrecioContableDocumento) {
		baseImponiblePrecioContableDocumento = newBaseImponiblePrecioContableDocumento;
	}

	public Float getBaseImponiblePrecioContableLocal() {
		return baseImponiblePrecioContableLocal;
	}

	public void setBaseImponiblePrecioContableLocal(Float newBaseImponiblePrecioContableLocal) {
		baseImponiblePrecioContableLocal = newBaseImponiblePrecioContableLocal;
	}

	public Float getTotalBaseImponibleDocumento() {
		return totalBaseImponibleDocumento;
	}

	public void setTotalBaseImponibleDocumento(Float newTotalBaseImponibleDocumento) {
		totalBaseImponibleDocumento = newTotalBaseImponibleDocumento;
	}

	public Float getTotalBaseImponibleLocal() {
		return totalBaseImponibleLocal;
	}

	public void setTotalBaseImponibleLocal(Float newTotalBaseImponibleLocal) {
		totalBaseImponibleLocal = newTotalBaseImponibleLocal;
	}

	public Float getTotalDescuentoCabeceraDocumento() {
		return totalDescuentoCabeceraDocumento;
	}

	public void setTotalDescuentoCabeceraDocumento(Float newTotalDescuentoCabeceraDocumento) {
		totalDescuentoCabeceraDocumento = newTotalDescuentoCabeceraDocumento;
	}

	public Float getTotalDescuentoCabeceraLocal() {
		return totalDescuentoCabeceraLocal;
	}

	public void setTotalDescuentoCabeceraLocal(Float newTotalDescuentoCabeceraLocal) {
		totalDescuentoCabeceraLocal = newTotalDescuentoCabeceraLocal;
	}

	public Float getTotalImporteDocumento() {
		return totalImporteDocumento;
	}

	public void setTotalImporteDocumento(Float newTotalImporteDocumento) {
		totalImporteDocumento = newTotalImporteDocumento;
	}

	public Float getTotalImporteLocal() {
		return totalImporteLocal;
	}

	public void setTotalImporteLocal(Float newTotalImporteLocal) {
		totalImporteLocal = newTotalImporteLocal;
	}

	public Float getTotalImpuestosDocumento() {
		return totalImpuestosDocumento;
	}

	public void setTotalImpuestosDocumento(Float newTotalImpuestosDocumento) {
		totalImpuestosDocumento = newTotalImpuestosDocumento;
	}

	public Float getTotalImpuestosLocal() {
		return totalImpuestosLocal;
	}

	public void setTotalImpuestosLocal(Float newTotalImpuestosLocal) {
		totalImpuestosLocal = newTotalImpuestosLocal;
	}

	public Float getTotalPreciosPosicionDocumento() {
		return totalPreciosPosicionDocumento;
	}

	public void setTotalPreciosPosicionDocumento(Float newTotalPreciosPosicionDocumento) {
		totalPreciosPosicionDocumento = newTotalPreciosPosicionDocumento;
	}

	public Float getTotalPreciosPosicionLocal() {
		return totalPreciosPosicionLocal;
	}

	public void setTotalPreciosPosicionLocal(Float newTotalPreciosPosicionLocal) {
		totalPreciosPosicionLocal = newTotalPreciosPosicionLocal;
	}
}