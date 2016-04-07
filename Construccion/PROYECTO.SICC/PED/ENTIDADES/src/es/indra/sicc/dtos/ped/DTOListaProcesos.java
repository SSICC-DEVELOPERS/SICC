package es.indra.sicc.dtos.ped;

import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOListaProcesos extends DTOAuditableSICC {

	private ArrayList ListaProcesos;
	public DTOListaProcesos() {
	}

	public ArrayList getListaProcesos() {
		return ListaProcesos;
	}

	public void setListaProcesos(ArrayList newListaProcesos) {
		ListaProcesos = newListaProcesos;
	}
}