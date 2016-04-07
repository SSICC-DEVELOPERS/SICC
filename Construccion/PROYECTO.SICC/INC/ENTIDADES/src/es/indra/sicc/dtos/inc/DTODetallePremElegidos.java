package es.indra.sicc.dtos.inc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODetallePremElegidos extends DTOSiccPaginacion {
  private Integer numeroPremio;
  private Long oidNivelPremiacion;

  public DTODetallePremElegidos()  {  }
  
  public void setNumeroPremio(Integer newNumeroPremio) {
    this.numeroPremio = newNumeroPremio;
  }
  
  public Integer getNumeroPremio() {
    return this.numeroPremio;
  }
  
  public void setOidNivelPremiacion(Long newOidNivelPremiacion)  {
    this.oidNivelPremiacion = newOidNivelPremiacion;
  }
  
  public Long getOidNivelPremiacion() {
    return this.oidNivelPremiacion;
  }  
}