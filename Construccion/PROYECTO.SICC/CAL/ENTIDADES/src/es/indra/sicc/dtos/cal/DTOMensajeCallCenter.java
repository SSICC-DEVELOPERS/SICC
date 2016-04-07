package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajeCallCenter extends DTOAuditableSICC {
  private Long oid;
  private String textoMensaje;

  public DTOMensajeCallCenter() {  }

  public Long getOid() {
    return this.oid;
  }

  public void setOid(Long newOid) {
    this.oid = newOid;
  }

  public String getTextoMensaje() {
    return this.textoMensaje;
  }

  public void setTextoMensaje(String newTextoMensaje) {
    this.textoMensaje = newTextoMensaje;
  }
}