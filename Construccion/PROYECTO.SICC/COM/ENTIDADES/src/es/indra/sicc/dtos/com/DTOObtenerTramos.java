package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOObtenerTramos extends DTOAuditableSICC  {
   private Long oidPeriodo;
   private Long oidComision;
  public DTOObtenerTramos() {
  }

  public Long getOidComision() {
    return oidComision;
  }

  public void setOidComision(Long oidComision) {
    this.oidComision = oidComision;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }
}