package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOEstados extends DTOAuditableSICC {
  private ArrayList estados;

  public DTOEstados() { }
  
  public ArrayList getEstados() {
    return this.estados;
  }
  
  public void setEstados(ArrayList newEstados) {
    this.estados = newEstados;
  }
}