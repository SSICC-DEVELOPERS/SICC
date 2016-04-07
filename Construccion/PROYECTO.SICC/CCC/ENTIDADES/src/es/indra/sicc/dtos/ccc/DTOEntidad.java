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

import java.math.BigDecimal;

public class DTOEntidad extends DTOBelcorp {
	private Long oid;
	private String codigoCliente;
	private Integer entidad;
	private BigDecimal importeDtoRecargo;
	private Long oidTipoCliente;
	private Long oidSubacceso;
	private Long oidCliente;
	private Long oidSolicitud;
	public DTOEntidad() {
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public Integer getEntidad() {
		return entidad;
	}

	public void setEntidad(Integer newEntidad) {
		entidad = newEntidad;
	}

	public BigDecimal getImporteDtoRecargo() {
		return importeDtoRecargo;
	}

	public void setImporteDtoRecargo(BigDecimal newImporteDtoRecargo) {
		importeDtoRecargo = newImporteDtoRecargo;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public Long getOidSolicitud() {
		return oidSolicitud;
	}

	public void setOidSolicitud(Long newOidSolicitud) {
		oidSolicitud = newOidSolicitud;
	}
}