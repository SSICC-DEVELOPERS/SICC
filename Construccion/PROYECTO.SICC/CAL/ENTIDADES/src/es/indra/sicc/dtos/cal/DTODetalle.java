package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODetalle extends DTOAuditableSICC {
    private Long oidDetalle;
    private Long oidCabecera;
    private Long secuenciaActividad;
    private String descripcionActividad;
    private Long oidCliente;
    private Long oidContacto;
    private Long oidGestion;
    private String observaciones;
  
  public DTODetalle() { }

  public Long getOidDetalle() {
    return this.oidDetalle;
  }
  
  public void setOidDetalle(Long newOidDetalle) {
    this.oidDetalle = newOidDetalle;    
  }
  
  public Long getOidCabecera() {
    return this.oidCabecera;
  }
  
  public void setOidCabecera(Long newOidCabecera) {
    this.oidCabecera = newOidCabecera;
  }
  
  public Long getSecuenciaActividad() {
    return this.secuenciaActividad;
  }
  
  public void setSecuenciaActividad(Long newSecuenciaActividad) {
    this.secuenciaActividad = newSecuenciaActividad;
  }
  
  public String getDescripcionActividad() {
    return this.descripcionActividad;
  }
  
  public void setDescripcionActividad(String newDescripcionActividad) {
    this.descripcionActividad = newDescripcionActividad;
  }
  
  public Long getOidCliente() {
    return this.oidCliente;
  }
  
  public void setOidCliente(Long newOidCliente) {
    this.oidCliente = newOidCliente;
  }
  
  public Long getOidContacto() {
    return this.oidContacto;
  }
  
  public void setOidContacto(Long newOidContacto) {
    this.oidContacto = newOidContacto;
  }
  
  public Long getOidGestion() {
    return this.oidGestion;
  }
  
  public void setOidGestion(Long newOidGestion) {
    this.oidGestion = newOidGestion;
  }
  
  public String getObservaciones() {
    return this.observaciones;
  }
  
  public void setObservaciones(String newObservaciones){
    this.observaciones = newObservaciones;
  }
}