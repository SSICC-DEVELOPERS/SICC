package es.indra.sicc.dtos.ped;
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOAgregarSolicitudesGrupo extends DTOAuditableSICC {

	private String grupoReversion;
	private ArrayList listaSolicitudes;
	public DTOAgregarSolicitudesGrupo() {
	}

	public String getGrupoReversion() {
		return grupoReversion;
	}

	public void setGrupoReversion(String newGrupoReversion) {
		grupoReversion = newGrupoReversion;
	}

	public ArrayList getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(ArrayList newListaSolicitudes) {
		listaSolicitudes = newListaSolicitudes;
	}
}