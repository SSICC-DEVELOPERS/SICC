package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPermitirModificar extends DTOAuditableSICC {
  private Long oidComision;
  private Long oidEstado;

  public DTOPermitirModificar() {  }
  
  public Long getOidComision()  {
    return this.oidComision;
  }
  
  public void setOidComision(Long newOidComision)  {
    this.oidComision = newOidComision;
  }
  
  public Long getOidEstado() {
    return this.oidEstado;
  }
  
  public void setOidEstado(Long newOidEstado) {
    this.oidEstado = newOidEstado;
  }
}