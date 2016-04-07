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
 
package es.indra.sicc.dtos.edu;

import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

public class DTORegalo extends DTOBelcorp {

	private Integer codRegalo;
	private DTOI18nSICC[] attriTraducible;
	private Long oid;
	private DTORegaloProducto[] productos;

	public DTOI18nSICC[] getAttriTraducible() {
		return attriTraducible;
	}

	public void setAttriTraducible(DTOI18nSICC[] newAttriTraducible) {
		attriTraducible = newAttriTraducible;
	}

	public Integer getCodRegalo() {
		return codRegalo;
	}

	public void setCodRegalo(Integer newCodRegalo) {
		codRegalo = newCodRegalo;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public DTORegaloProducto[] getProductos() {
		return productos;
	}

	public void setProductos(DTORegaloProducto[] newProductos) {
		productos = newProductos;
	}

}