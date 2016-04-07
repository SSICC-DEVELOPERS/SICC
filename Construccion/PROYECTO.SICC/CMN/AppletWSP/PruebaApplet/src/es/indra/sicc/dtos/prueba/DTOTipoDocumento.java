package es.indra.sicc.dtos.prueba;
import java.io.Serializable;

public class DTOTipoDocumento extends DTOAbstractoApplet implements Serializable {
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