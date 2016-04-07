package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOPrecioPosiciones extends DTOAuditableSICC{

  private Vector precioPosiciones;  //DTOPrecioPosicion[]
  
	public DTOPrecioPosiciones() {
	}

	public Vector getPrecioPosiciones() {
		return precioPosiciones;
	}

	public void setPrecioPosiciones(Vector newPrecioPosiciones) {
		precioPosiciones = newPrecioPosiciones;
	}











}