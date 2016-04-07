package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;

public class DTOEDescuentosOrdenacion extends DTOAuditableSICC {
	private ArrayList lista = null;

	public DTOEDescuentosOrdenacion() {
	}

	public ArrayList getLista() {
		return lista;
	}

	public void setLista(ArrayList newLista) {
		lista = newLista;
	}
}