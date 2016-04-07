package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOAmbitRC extends DTOAuditableSICC  {
 private Long oidConcurso;
 private String oids;


  public void setOidConcurso(Long oidConcurso) {
    this.oidConcurso = oidConcurso;
  }


  public Long getOidConcurso() {
    return oidConcurso;
  }


  public void setOids(String oids) {
    this.oids = oids;
  }


  public String getOids() {
    return oids;
  }
}