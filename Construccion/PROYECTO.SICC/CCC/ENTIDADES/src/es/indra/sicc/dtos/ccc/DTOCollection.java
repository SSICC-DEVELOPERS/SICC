package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOCollection  extends DTOAuditableSICC {
  private ArrayList lista;

  public DTOCollection () {}

  public ArrayList getLista() {
    return lista;
  }

  public void setLista(ArrayList newLista) {
    lista = newLista;
  }  
  
}