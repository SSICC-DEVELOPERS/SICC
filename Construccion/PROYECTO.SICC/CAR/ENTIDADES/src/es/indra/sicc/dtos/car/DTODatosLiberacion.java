package es.indra.sicc.dtos.car;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODatosLiberacion extends DTOAuditableSICC {
	private Long oidCodigoAprobacion;
	private String observacion;
	private String usuario;
	private Long oidSolicitudBloqueada;
	private Long oidEjecutivo;

	public DTODatosLiberacion() {
	}

	public Long getOidCodigoAprobacion() {
		return oidCodigoAprobacion;
	}

	public void setOidCodigoAprobacion(Long newOidCodigoAprobacion) {
		oidCodigoAprobacion = newOidCodigoAprobacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String newObservacion) {
		observacion = newObservacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String newUsuario) {
		usuario = newUsuario;
	}

	public Long getOidSolicitudBloqueada() {
		return oidSolicitudBloqueada;
	}

	public void setOidSolicitudBloqueada(Long newOidSolicitudBloqueada) {
		oidSolicitudBloqueada = newOidSolicitudBloqueada;
	}

	public Long getOidEjecutivo() {
		return oidEjecutivo;
	}

	public void setOidEjecutivo(Long newOidEjecutivo) {
		oidEjecutivo = newOidEjecutivo;
	}
}