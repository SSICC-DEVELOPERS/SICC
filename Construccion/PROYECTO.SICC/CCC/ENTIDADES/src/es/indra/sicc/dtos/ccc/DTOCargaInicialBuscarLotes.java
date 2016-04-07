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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOCargaInicialBuscarLotes extends DTOSiccPaginacion {

	private RecordSet tipoCargoAbono;
	private RecordSet canales;
	private RecordSet accesos;
	private RecordSet subaccesos;
	private RecordSet situaciones;

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

	public RecordSet getSituaciones() {
		return this.situaciones;
	}

	public void setSituaciones(RecordSet newSituaciones) {
		this.situaciones = newSituaciones;
	}

	public RecordSet getSubaccesos() {
		return this.subaccesos;
	}

	public void setSubaccesos(RecordSet newSubaccesos) {
		this.subaccesos = newSubaccesos;
	}

	public RecordSet getTipoCargoAbono() {
		return this.tipoCargoAbono;
	}

	public void setTipoCargoAbono(RecordSet newTipoCargoAbono) {
		this.tipoCargoAbono = newTipoCargoAbono;
	}
}