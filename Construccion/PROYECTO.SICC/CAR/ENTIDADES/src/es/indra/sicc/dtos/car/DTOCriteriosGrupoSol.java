package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
public class DTOCriteriosGrupoSol extends DTOSiccPaginacion {
	private String codGrupoSolicitud;
	private Long tiposSolicitud;
	private String descripcion;

	public DTOCriteriosGrupoSol() {
	}

	public String getCodGrupoSolicitud() {
		return codGrupoSolicitud;
	}

	public void setCodGrupoSolicitud(String newCodGrupoSolicitud) {
		codGrupoSolicitud = newCodGrupoSolicitud;
	}

	public Long getTiposSolicitud() {
		return tiposSolicitud;
	}

	public void setTiposSolicitud(Long newTiposSolicitud) {
		tiposSolicitud = newTiposSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}
}