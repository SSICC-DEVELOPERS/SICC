package es.indra.sicc.dtos.inc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarConcursoCliente extends DTOSiccPaginacion {
  private Long oidCliente;
  private String codigoCliente;

  public DTOBuscarConcursoCliente() { }
  
  public void setOidCliente(Long newOidCliente) {
    this.oidCliente = newOidCliente;
  }
  
  public Long getOidCliente() {
    return this.oidCliente;
  }
  
  public void setCodigoCliente(String newCodigoCliente) {
    this.codigoCliente = newCodigoCliente;
  }
  
  public String getCodigoCliente() {
    return this.codigoCliente;
  }
}