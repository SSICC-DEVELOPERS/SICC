package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOConsultarFechasCronograma extends DTOSiccPaginacion {
  private Long oidPeriodo;
  private Long oidZona;

  public DTOConsultarFechasCronograma() {  }
  
  public void setOidPeriodo(Long newOidPeriodo)  {
    this.oidPeriodo = newOidPeriodo;
  }
  
  public void setOidZona(Long newOidZona)   {
    this.oidZona = newOidZona;
  }
  
  public Long getOidPeriodo() {
    return this.oidPeriodo;
  }
  
  public Long getOidZona() {
    return this.oidZona;
  }
  
  
}