package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Vector;
public class DTOGrupoSolicitud extends DTOSiccPaginacion {
	private Long oidGrupoSol;
	private String codGrupoSolicitud;
	private Vector tiposSolicitud;
	private Vector attriTraducible;

	public DTOGrupoSolicitud() {
	}

	public Long getOidGrupoSol() {
		return oidGrupoSol;
	}

	public void setOidGrupoSol(Long newOidGrupoSol) {
		oidGrupoSol = newOidGrupoSol;
	}

	public String getCodGrupoSolicitud() {
		return codGrupoSolicitud;
	}

	public void setCodGrupoSolicitud(String newCodGrupoSolicitud) {
		codGrupoSolicitud = newCodGrupoSolicitud;
	}

	public Vector getTiposSolicitud() {
		return tiposSolicitud;
	}

	public void setTiposSolicitud(Vector newTiposSolicitud) {
		tiposSolicitud = newTiposSolicitud;
	}

	public Vector getAttriTraducible() {
		return attriTraducible;
	}

	public void setAttriTraducible(Vector newAttriTraducible) {
		attriTraducible = newAttriTraducible;
	}

	
}