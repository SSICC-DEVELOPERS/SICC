package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * 
 * @author jquiroga
 */
 
public class DTOEstado extends DTOAuditableSICC {
  private Long oidEstadoComision;
  
  public DTOEstado() { }

  public void setOidEstadoComision(Long oidEstadoComision)
  {
    this.oidEstadoComision = oidEstadoComision;
  }

  public Long getOidEstadoComision()
  {
    return oidEstadoComision;
  }    
}