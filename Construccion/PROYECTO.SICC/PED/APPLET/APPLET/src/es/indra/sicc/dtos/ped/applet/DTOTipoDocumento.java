package es.indra.sicc.dtos.ped.applet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTipoDocumento extends DTOAuditableSICC {
  private Long oid;
  private String desc;
  private Long oidDocLegal;
  private String desDocLegal;

  public DTOTipoDocumento() {
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

  public Long getOidDocLegal() {
    return oidDocLegal;
  }

  public void setOidDocLegal(Long newOidDocLegal) {
    oidDocLegal = newOidDocLegal;
  }

  public String getDesDocLegal() {
    return desDocLegal;
  }

  public void setDesDocLegal(String newDesDocLegal) {
    desDocLegal = newDesDocLegal;
  }
}