package es.indra.sicc.dtos.prueba;
import java.io.Serializable;

public class DTODatosCombo extends DTOAbstractoApplet implements Serializable{
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