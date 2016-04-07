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

public class DTOFACProducto extends DTOBelcorp {

	String descripcionSAP;   
	String indicadorDentroFueraCaja; //se modifica de Boolean a String: Incidencia BELC300008487   
	Long marca;   
	Long negocio;   
	Long unidadNegocio;   
	String grupoProductos;

	public DTOFACProducto() {
		super();
	}

	public String getDescripcionSAP() {
		return descripcionSAP;
	}

	public void setDescripcionSAP(String newDescripcionSAP) {
		descripcionSAP = newDescripcionSAP;
	}

	public String getGrupoProductos() {
		return grupoProductos;
	}

	public void setGrupoProductos(String newGrupoProductos) {
		grupoProductos = newGrupoProductos;
	}

	public String getIndicadorDentroFueraCaja() {
		return indicadorDentroFueraCaja;
	}

	public void setIndicadorDentroFueraCaja(String newIndicadorDentroFueraCaja) {
		indicadorDentroFueraCaja = newIndicadorDentroFueraCaja;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Long getNegocio() {
		return negocio;
	}

	public void setNegocio(Long newNegocio) {
		negocio = newNegocio;
	}

	public Long getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(Long newUnidadNegocio) {
		unidadNegocio = newUnidadNegocio;
	}
}