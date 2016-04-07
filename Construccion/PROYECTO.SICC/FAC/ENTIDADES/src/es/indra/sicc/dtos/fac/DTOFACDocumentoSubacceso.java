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

public class DTOFACDocumentoSubacceso extends DTOBelcorp {

	private Long oid;   
	private Long oidSociedad;   
	private Long oidSubacceso;   
	private Long oidTipoDocumento;   
	private Integer ultimoNumeroDocumentoLegal;   
	private Integer limiteNumeroDocumentoLegal;   
	private Integer ultimoEjercicioDocumentoInterno;   
	private String serieDocumentoLegal;   
	private Integer ultimoNumeroDocumentoInterno; 

	public DTOFACDocumentoSubacceso() {
		super();
	}

	public Integer getLimiteNumeroDocumentoLegal() {
		return limiteNumeroDocumentoLegal;
	}

	public void setLimiteNumeroDocumentoLegal(Integer newLimiteNumeroDocumentoLegal) {
		limiteNumeroDocumentoLegal = newLimiteNumeroDocumentoLegal;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getOidSociedad() {
		return oidSociedad;
	}

	public void setOidSociedad(Long newOidSociedad) {
		oidSociedad = newOidSociedad;
	}

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}

	public Long getOidTipoDocumento() {
		return oidTipoDocumento;
	}

	public void setOidTipoDocumento(Long newOidTipoDocumento) {
		oidTipoDocumento = newOidTipoDocumento;
	}

	public String getSerieDocumentoLegal() {
		return serieDocumentoLegal;
	}

	public void setSerieDocumentoLegal(String newSerieDocumentoLegal) {
		serieDocumentoLegal = newSerieDocumentoLegal;
	}

	public Integer getUltimoEjercicioDocumentoInterno() {
		return ultimoEjercicioDocumentoInterno;
	}

	public void setUltimoEjercicioDocumentoInterno(Integer newUltimoEjercicioDocumentoInterno) {
		ultimoEjercicioDocumentoInterno = newUltimoEjercicioDocumentoInterno;
	}

	public Integer getUltimoNumeroDocumentoInterno() {
		return ultimoNumeroDocumentoInterno;
	}

	public void setUltimoNumeroDocumentoInterno(Integer newUltimoNumeroDocumentoInterno) {
		ultimoNumeroDocumentoInterno = newUltimoNumeroDocumentoInterno;
	}

	public Integer getUltimoNumeroDocumentoLegal() {
		return ultimoNumeroDocumentoLegal;
	}

	public void setUltimoNumeroDocumentoLegal(Integer newUltimoNumeroDocumentoLegal) {
		ultimoNumeroDocumentoLegal = newUltimoNumeroDocumentoLegal;
	}
}