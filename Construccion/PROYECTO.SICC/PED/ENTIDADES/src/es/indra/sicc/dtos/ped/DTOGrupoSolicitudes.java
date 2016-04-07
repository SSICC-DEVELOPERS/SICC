package es.indra.sicc.dtos.ped;

import es.indra.sicc.dtos.ped.DTOClasificacionSolicitud;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOGrupoSolicitudes extends DTOAuditableSICC {

//	private DTOClasificacionSolicitud[] ListaGrupos;
  private Vector ListaGrupos;

	public DTOGrupoSolicitudes() {
	}

	public Vector getListaGrupos() {
		return ListaGrupos;
	}

	public void setListaGrupos(Vector newListaGrupos) {
		ListaGrupos = newListaGrupos;
	}
}