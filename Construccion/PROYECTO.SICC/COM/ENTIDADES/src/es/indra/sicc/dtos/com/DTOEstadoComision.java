package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEstadoComision extends DTOSiccPaginacion {
  private Long oidEstadoComision;

  public DTOEstadoComision() {  }
  
  public Long getOidEstadoComision() {
    return this.oidEstadoComision;
  }
  
  public void setOidEstadoComision(Long newOidEstadoComision) {
    this.oidEstadoComision = newOidEstadoComision;
  }
}