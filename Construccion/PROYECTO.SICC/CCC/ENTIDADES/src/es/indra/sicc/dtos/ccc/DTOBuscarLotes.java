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

public class DTOBuscarLotes extends DTOSiccPaginacion {

	private String anho;
	private String mes;
	private String numero;
	private Date fechaImputacion;
	private Long situacion;
	private Long oidTipoCargoAbono;
	private Long oidCanal;
	private Long oidAcceso;
	private Long oidSubacceso;
	private Boolean eliminar;


	public String getAnho() {
		return this.anho;
	}

	public void setAnho(String newAnho) {
		this.anho = newAnho;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String newMes) {
		this.mes = newMes;
	}

	public Long getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Long newSituacion) {
		this.situacion = newSituacion;
	}

	public Date getFechaImputacion() {
		return fechaImputacion;
	}

	public void setFechaImputacion(Date newFechaImputacion) {
		fechaImputacion = newFechaImputacion;
	}

	public Boolean getEliminar(){
		return eliminar;		
	}
	
	public void setEliminar(Boolean newEliminar){
		this.eliminar=newEliminar;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String newNumero) {
		numero = newNumero;
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

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}

	public Long getOidTipoCargoAbono() {
		return oidTipoCargoAbono;
	}

	public void setOidTipoCargoAbono(Long newOidTipoCargoAbono) {
		oidTipoCargoAbono = newOidTipoCargoAbono;
	}
}