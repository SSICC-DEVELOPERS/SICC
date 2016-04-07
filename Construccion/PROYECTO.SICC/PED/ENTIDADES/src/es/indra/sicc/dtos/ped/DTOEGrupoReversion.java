package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEGrupoReversion extends DTOSiccPaginacion {

	private String grupoReversion;
	
	public DTOEGrupoReversion() {
	}

	public String getGrupoReversion() {
		return grupoReversion;
	}

	public void setGrupoReversion(String newGrupoReversion) {
		grupoReversion = newGrupoReversion;
	}
}