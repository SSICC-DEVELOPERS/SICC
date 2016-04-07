package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORedirigirDetalle extends DTOAuditableSICC {
  private Long oidCabecera;
  private Long[] listaOidDetalle;
  private Long oidCabeceraNuevo;  

  public DTORedirigirDetalle() {  }

  public Long getOidCabecera() {
    return this.oidCabecera;
  }
  
  public void setOidCabecera(Long newOidCabecera) {
    this.oidCabecera = newOidCabecera;
  }
  
  public Long[] getListaOidDetalle() {
    return this.listaOidDetalle;
  }
  
  public void setListaOidDetalle(Long[] newListaOidDetalle) {
    this.listaOidDetalle = newListaOidDetalle;
  }
  
  public Long getOidCabeceraNuevo() {
    return this.oidCabeceraNuevo;
  }
  
  public void setOidCabeceraNuevo(Long newOidCabeceraNuevo) {
    this.oidCabeceraNuevo = newOidCabeceraNuevo;
  }
  
}