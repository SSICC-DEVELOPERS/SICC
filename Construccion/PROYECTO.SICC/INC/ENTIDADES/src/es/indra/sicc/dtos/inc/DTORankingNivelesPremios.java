package es.indra.sicc.dtos.inc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTORankingNivelesPremios extends DTOSiccPaginacion  {
 private Long oidConcurso;
 private Integer version;


  public void setOidConcurso(Long oidConcurso) {
    this.oidConcurso = oidConcurso;
  }


  public Long getOidConcurso() {
    return oidConcurso;
  }


  public void setVersion(Integer version) {
    this.version = version;
  }


  public Integer getVersion() {
    return version;
  }
}