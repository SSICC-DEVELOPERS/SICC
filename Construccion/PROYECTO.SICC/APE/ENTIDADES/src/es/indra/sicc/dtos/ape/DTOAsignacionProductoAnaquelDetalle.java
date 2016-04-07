/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOAsignacionProductoAnaquelDetalle  extends DTOBelcorp  {
  private Long oid;
  private String procedencia;
  private Long unidades;
  private String siguienteAsignacion;
  private Boolean asignacionPTL;
  private Long oidAsignacionProductoCabecera;
  private Long oidMapaCDDetalle;
  private Long oidProducto;

  public DTOAsignacionProductoAnaquelDetalle() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public String getProcedencia() {
    return procedencia;
  }

  public void setProcedencia(String procedencia) {
    this.procedencia = procedencia;
  }

  public Long getUnidades() {
    return unidades;
  }

  public void setUnidades(Long unidades) {
    this.unidades = unidades;
  }

  public String getSiguienteAsignacion() {
    return siguienteAsignacion;
  }

  public void setSiguienteAsignacion(String siguienteAsignacion) {
    this.siguienteAsignacion = siguienteAsignacion;
  }

  public Boolean getAsignacionPTL() {
    return asignacionPTL;
  }

  public void setAsignacionPTL(Boolean asignacionPTL) {
    this.asignacionPTL = asignacionPTL;
  }

  public Long getOidAsignacionProductoCabecera() {
    return oidAsignacionProductoCabecera;
  }

  public void setOidAsignacionProductoCabecera(Long oidAsignacionProductoCabecera) {
    this.oidAsignacionProductoCabecera = oidAsignacionProductoCabecera;
  }

  public Long getOidMapaCDDetalle() {
    return oidMapaCDDetalle;
  }

  public void setOidMapaCDDetalle(Long oidMapaCDDetalle) {
    this.oidMapaCDDetalle = oidMapaCDDetalle;
  }

  public Long getOidProducto() {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto) {
    this.oidProducto = oidProducto;
  }
}