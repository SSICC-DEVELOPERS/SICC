package es.indra.sicc.dtos.ped;

import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOListaSolicitudes extends DTOAuditableSICC {

//   private DTOSolicitudValidacion[] lista;
  private Vector lista;
  

	public DTOListaSolicitudes() {
	}

	public Vector getLista() {
		return lista;
	}

	public void setLista(Vector newLista) {
		lista = newLista;
	}
    
}