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

package es.indra.sicc.dtos.app;

import es.indra.sicc.util.DTOBelcorp;

public class DTOClienteChequeo extends DTOBelcorp  {

	private Long oidClienteReceptorFactura;
	private Long oidMarca;
	private Long oidCanal;
	private Long oidPeriodo;
	private Long oidSubgerencia;
	private Long oidRegion;
	private Long oidZona;
	private Long oidSeccion;
	
	public DTOClienteChequeo() {
		super();
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidClienteReceptorFactura() {
		return oidClienteReceptorFactura;
	}

	public void setOidClienteReceptorFactura(Long newOidClienteReceptorFactura) {
		oidClienteReceptorFactura = newOidClienteReceptorFactura;
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		oidPeriodo = newOidPeriodo;
	}

	public Long getOidRegion() {
		return oidRegion;
	}

	public void setOidRegion(Long newOidRegion) {
		oidRegion = newOidRegion;
	}

	public Long getOidSeccion() {
		return oidSeccion;
	}

	public void setOidSeccion(Long newOidSeccion) {
		oidSeccion = newOidSeccion;
	}

	public Long getOidSubgerencia() {
		return oidSubgerencia;
	}

	public void setOidSubgerencia(Long newOidSubgerencia) {
		oidSubgerencia = newOidSubgerencia;
	}

	public Long getOidZona() {
		return oidZona;
	}

	public void setOidZona(Long newOidZona) {
		oidZona = newOidZona;
	}
}