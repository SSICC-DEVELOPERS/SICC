package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
public class DTOAgregarSolicitudesCriterio extends DTOAuditableSICC {

	private String grupoReversion;
	private Long oidTipoSolicitudPais;
	private Long oidSubacceso;
	private String numeroSolicitud;
	
	public DTOAgregarSolicitudesCriterio() {
	}

	public String getGrupoReversion() {
		return grupoReversion;
	}

	public void setGrupoReversion(String newGrupoReversion) {
		grupoReversion = newGrupoReversion;
	}

	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(String newNumeroSolicitud) {
		numeroSolicitud = newNumeroSolicitud;
	}

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}

	public Long getOidTipoSolicitudPais() {
		return oidTipoSolicitudPais;
	}

	public void setOidTipoSolicitudPais(Long newOidTipoSolicitudPais) {
		oidTipoSolicitudPais = newOidTipoSolicitudPais;
	}
}