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

public class DTOFleteFAC extends DTOBelcorp {

	private Boolean exentoFlete;
	private Float baseFleteLocal; 
	private Float importeFleteLocal;
	private Float recargoFleteLocal;
	private Float otrosRecargosLocal;
	private Float totalFleteLocal;
	private Float importeFleteTotalLocal;
	private Float baseFleteDocumento;
	private Float importeFleteDocumento;
	private Float recargoFleteDocumento;
	private Float otrosRecargosDocumento;
	private Float totalFleteDocumento;
	private Float importeFleteTotalDocumento;

	public Float getBaseFleteDocumento() {
		return baseFleteDocumento;
	}

	public void setBaseFleteDocumento(Float newBaseFleteDocumento) {
		baseFleteDocumento = newBaseFleteDocumento;
	}

	public Float getBaseFleteLocal() {
		return baseFleteLocal;
	}

	public void setBaseFleteLocal(Float newBaseFleteLocal) {
		baseFleteLocal = newBaseFleteLocal;
	}

	public Boolean getExentoFlete() {
		return exentoFlete;
	}

	public void setExentoFlete(Boolean newExentoFlete) {
		exentoFlete = newExentoFlete;
	}

	public Float getImporteFleteDocumento() {
		return importeFleteDocumento;
	}

	public void setImporteFleteDocumento(Float newImporteFleteDocumento) {
		importeFleteDocumento = newImporteFleteDocumento;
	}

	public Float getImporteFleteLocal() {
		return importeFleteLocal;
	}

	public void setImporteFleteLocal(Float newImporteFleteLocal) {
		importeFleteLocal = newImporteFleteLocal;
	}

	public Float getImporteFleteTotalDocumento() {
		return importeFleteTotalDocumento;
	}

	public void setImporteFleteTotalDocumento(Float newImporteFleteTotalDocumento) {
		importeFleteTotalDocumento = newImporteFleteTotalDocumento;
	}

	public Float getImporteFleteTotalLocal() {
		return importeFleteTotalLocal;
	}

	public void setImporteFleteTotalLocal(Float newImporteFleteTotalLocal) {
		importeFleteTotalLocal = newImporteFleteTotalLocal;
	}

	public Float getOtrosRecargosDocumento() {
		return otrosRecargosDocumento;
	}

	public void setOtrosRecargosDocumento(Float newOtrosRecargosDocumento) {
		otrosRecargosDocumento = newOtrosRecargosDocumento;
	}

	public Float getOtrosRecargosLocal() {
		return otrosRecargosLocal;
	}

	public void setOtrosRecargosLocal(Float newOtrosRecargosLocal) {
		otrosRecargosLocal = newOtrosRecargosLocal;
	}

	public Float getRecargoFleteDocumento() {
		return recargoFleteDocumento;
	}

	public void setRecargoFleteDocumento(Float newRecargoFleteDocumento) {
		recargoFleteDocumento = newRecargoFleteDocumento;
	}

	public Float getRecargoFleteLocal() {
		return recargoFleteLocal;
	}

	public void setRecargoFleteLocal(Float newRecargoFleteLocal) {
		recargoFleteLocal = newRecargoFleteLocal;
	}

	public Float getTotalFleteDocumento() {
		return totalFleteDocumento;
	}

	public void setTotalFleteDocumento(Float newTotalFleteDocumento) {
		totalFleteDocumento = newTotalFleteDocumento;
	}

	public Float getTotalFleteLocal() {
		return totalFleteLocal;
	}

	public void setTotalFleteLocal(Float newTotalFleteLocal) {
		totalFleteLocal = newTotalFleteLocal;
	}
}