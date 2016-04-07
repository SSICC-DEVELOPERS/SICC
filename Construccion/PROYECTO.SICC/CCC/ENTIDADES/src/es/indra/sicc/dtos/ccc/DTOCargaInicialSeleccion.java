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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCargaInicialSeleccion extends DTOBelcorp {

	private RecordSet tiposCargo;
	private Integer numDiasDeMora;
	private RecordSet canales;
	private RecordSet accesos;
	private RecordSet subaccesos;
	private RecordSet marcas; // BELC300003413
	private Integer numeroLote; // BELC300005103
	private Long proceso; //BELC300005115
	private String subproceso; //BELC300005115
	private RecordSet empresas; 
	private RecordSet periodoDesde;
	

	public RecordSet getAccesos() {
		return this.accesos;
	}

	public void setAccesos(RecordSet newAccesos) {
		this.accesos = newAccesos;
	}

	public RecordSet getCanales() {
		return this.canales;
	}

	public void setCanales(RecordSet newCanales) {
		this.canales = newCanales;
	}

	public Integer getNumDiasDeMora() {
		return numDiasDeMora;
	}

	public RecordSet getSubaccesos() {
		return this.subaccesos;
	}

	public void setSubaccesos(RecordSet newSubaccesos) {
		this.subaccesos = newSubaccesos;
	}

	public RecordSet getTiposCargo() {
		return this.tiposCargo;
	}

	public void setTiposCargo(RecordSet newTiposCargo) {
		this.tiposCargo = newTiposCargo;
	}

	public RecordSet getMarcas() {
		return this.marcas;
	}

	public void setMarcas(RecordSet newMarcas) {
		this.marcas = newMarcas;
	}

	public Integer getNumeroLote() {
		return this.numeroLote;
	}

	public void setNumeroLote(Integer newNumeroLote) {
		this.numeroLote = newNumeroLote;
	}

	public Long getProceso() {
		return this.proceso;
	}

	public void setProceso(Long newProceso) {
		this.proceso = newProceso;
	}

	public String getSubproceso(){
		return this.subproceso;
	}
	
	public void setSubproceso(String newSubproceso){
		this.subproceso = newSubproceso;
	}

	public RecordSet getEmpresas() {
		return empresas;
	}

	public void setEmpresas(RecordSet newEmpresas) {
		empresas = newEmpresas;
	}

	public void setNumDiasDeMora(Integer newNumDiasDeMora) {
		numDiasDeMora = newNumDiasDeMora;
	}

	public RecordSet getPeriodoDesde() {
		return periodoDesde;
	}

	public void setPeriodoDesde(RecordSet newPeriodoDesde) {
		periodoDesde = newPeriodoDesde;
	}
}