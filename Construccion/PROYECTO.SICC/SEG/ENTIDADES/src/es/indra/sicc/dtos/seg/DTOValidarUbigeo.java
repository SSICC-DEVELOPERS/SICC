package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOValidarUbigeo extends DTOAuditableSICC {
  private Boolean ubigeoValido;

  public DTOValidarUbigeo() {
  }

  public Boolean isUbigeoValido() {
    return ubigeoValido;
  }

  public void setUbigeoValido(Boolean newUbigeoValido) {
    ubigeoValido = newUbigeoValido;
  }

  public Boolean getUbigeoValido() {
    return ubigeoValido;
  }
  
}