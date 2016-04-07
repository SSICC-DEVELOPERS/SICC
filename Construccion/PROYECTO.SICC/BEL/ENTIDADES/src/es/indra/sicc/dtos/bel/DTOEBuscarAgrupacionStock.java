/**
 * Copyright 2002 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarAgrupacionStock extends DTOSiccPaginacion  {
	private String codigoAgrupacionStock;
	private String descripcion;

	public String getCodigoAgrupacionStock() {
		return this.codigoAgrupacionStock;
	}

	public void setCodigoAgrupacionStock(String newCodigoAgrupacionStock) {
		this.codigoAgrupacionStock = newCodigoAgrupacionStock;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		this.descripcion = newDescripcion;
	}

}