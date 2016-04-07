/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * Autor : Viviana Bongiovanni
 */
 
package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOPremioDetalle  extends DTOBelcorp {
  private Boolean indCentroServGar;
  private Long oidCentroServGar;
  private Integer numMeses;
  private String observaciones;
  private String indTipoEntrega;
  private Long oidCentroServEntrega;
  private Long oidProducto;

  public DTOPremioDetalle() {
  }

  public Boolean getIndCentroServGar() {
    return indCentroServGar;
  }

  public void setIndCentroServGar(Boolean indCentroServGar) {
    this.indCentroServGar = indCentroServGar;
  }

  public Long getOidCentroServGar() {
    return oidCentroServGar;
  }

  public void setOidCentroServGar(Long oidCentroServGar) {
    this.oidCentroServGar = oidCentroServGar;
  }

  public Integer getNumMeses() {
    return numMeses;
  }

  public void setNumMeses(Integer numMeses) {
    this.numMeses = numMeses;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public String getIndTipoEntrega() {
    return indTipoEntrega;
  }

  public void setIndTipoEntrega(String indTipoEntrega) {
    this.indTipoEntrega = indTipoEntrega;
  }

  public Long getOidCentroServEntrega() {
    return oidCentroServEntrega;
  }

  public void setOidCentroServEntrega(Long oidCentroServEntrega) {
    this.oidCentroServEntrega = oidCentroServEntrega;
  }

  public Long getOidProducto() {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto) {
    this.oidProducto = oidProducto;
  }
}