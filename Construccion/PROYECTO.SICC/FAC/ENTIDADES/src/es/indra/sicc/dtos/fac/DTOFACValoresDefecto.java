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

public class DTOFACValoresDefecto extends DTOBelcorp{

	private Long oidValorDefectoTipoSolicitud;     
	private String valorPorDefecto;     
	private Long oidTipoSolicitudPais;     
	private Long oidAtributoEspecial;     
	private Boolean indicadorObligatorio;     
	private Boolean indicadorModificable;

	public DTOFACValoresDefecto() {
				super();
	}

	public Boolean getIndicadorModificable() {
		return indicadorModificable;
	}

	public void setIndicadorModificable(Boolean newIndicadorModificable) {
		indicadorModificable = newIndicadorModificable;
	}

	public Boolean getIndicadorObligatorio() {
		return indicadorObligatorio;
	}

	public void setIndicadorObligatorio(Boolean newIndicadorObligatorio) {
		indicadorObligatorio = newIndicadorObligatorio;
	}

	public Long getOidAtributoEspecial() {
		return oidAtributoEspecial;
	}

	public void setOidAtributoEspecial(Long newOidAtributoEspecial) {
		oidAtributoEspecial = newOidAtributoEspecial;
	}

	public Long getOidTipoSolicitudPais() {
		return oidTipoSolicitudPais;
	}

	public void setOidTipoSolicitudPais(Long newOidTipoSolicitudPais) {
		oidTipoSolicitudPais = newOidTipoSolicitudPais;
	}

	public Long getOidValorDefectoTipoSolicitud() {
		return oidValorDefectoTipoSolicitud;
	}

	public void setOidValorDefectoTipoSolicitud(Long newOidValorDefectoTipoSolicitud) {
		oidValorDefectoTipoSolicitud = newOidValorDefectoTipoSolicitud;
	}

	public String getValorPorDefecto() {
		return valorPorDefecto;
	}

	public void setValorPorDefecto(String newValorPorDefecto) {
		valorPorDefecto = newValorPorDefecto;
	}
}