package es.indra.sicc.dtos.ped.applet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODatosCombo extends DTOAuditableSICC {
  private Long oid;
  private String desc;

  public DTODatosCombo() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String newDesc) {
    desc = newDesc;
  }
}