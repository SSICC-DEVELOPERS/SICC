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

public class DTOIndicadoresImpuestos extends DTOBelcorp {

	private String indicadorImpuestos;   
	private String descripcion;   
	private Float tasaImpuesto;
	private Long oidTasaImpuesto; //incidencia BELC300008034
	private Long oidTipoSolicitud; // añadido por SICC-DMCO-FAC-201-364-N005-2
	
	public DTOIndicadoresImpuestos() {
				super();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}

	public String getIndicadorImpuestos() {
		return indicadorImpuestos;
	}

	public void setIndicadorImpuestos(String newIndicadorImpuestos) {
		indicadorImpuestos = newIndicadorImpuestos;
	}

	public Float getTasaImpuesto() {
		return tasaImpuesto;
	}

	public void setTasaImpuesto(Float newTasaImpuesto) {
		tasaImpuesto = newTasaImpuesto;
	}

	public Long getOidTasaImpuesto() {
		return oidTasaImpuesto;
	}

	public void setOidTasaImpuesto(Long newOidTasaImpuesto) {
		oidTasaImpuesto = newOidTasaImpuesto;
	}

	public Long getOidTipoSolicitud() {
		return oidTipoSolicitud;
	}

	public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
		oidTipoSolicitud = newOidTipoSolicitud;
	}
}