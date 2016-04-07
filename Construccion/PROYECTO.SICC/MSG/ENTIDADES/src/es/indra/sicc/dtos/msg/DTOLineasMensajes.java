package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOLineasMensajes extends DTOAuditableSICC {
  public DTOLineasMensajes() {
  }

  private String[] lineasMensajes;

  public String[] getLineasMensajes() {
    return lineasMensajes;
  }

  public void setLineasMensajes(String[] newLineasMensajes) {
    lineasMensajes = newLineasMensajes;
  }
}