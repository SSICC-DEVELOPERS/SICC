package es.indra.sicc.dtos.ccc;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOFiltroCC extends DTOAuditableSICC  {
  
  private Long oidCliente;
  private Long oidNumeroCargo;
  
  
  public DTOFiltroCC(){
  }
 
  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public Long getOidNumeroCargo() {
    return oidNumeroCargo;
  }

  public void setOidNumeroCargo(Long oidNumeroCargo) {
    this.oidNumeroCargo = oidNumeroCargo;
  }
}