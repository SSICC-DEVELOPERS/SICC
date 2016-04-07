package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
public class DTOTiposSolicitudenGrupo extends DTOSiccPaginacion {
	private Long oidGrupoSolicitud;
	private Boolean tiposSolLibres;

	public DTOTiposSolicitudenGrupo() {
	}

	public Long getOidGrupoSolicitud() {
		return oidGrupoSolicitud;
	}

	public void setOidGrupoSolicitud(Long newOidGrupoSolicitud) {
		oidGrupoSolicitud = newOidGrupoSolicitud;
	}

	public Boolean getTiposSolLibres() {
		return tiposSolLibres;
	}

	public void setTiposSolLibres(Boolean newTiposSolLibres) {
		tiposSolLibres = newTiposSolLibres;
	}
}