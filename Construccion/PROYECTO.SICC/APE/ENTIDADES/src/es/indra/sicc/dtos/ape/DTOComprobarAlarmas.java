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

public class DTOComprobarAlarmas extends DTOBelcorp  {
  private Long oidCentroDistribucion;
  private String descripcionCD;
  private Long oidLineaArmado;
  private String descripcionLinea;  
  private Long oidMapaCD;
  private String descripcionMapaCD;
  // vbongiov -- 25/06/2007 -- BELC400000527
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodo;

  public DTOComprobarAlarmas() {  }
  
  public Long getOidMapaCD() {
    return this.oidMapaCD;
  }
  
  public void setOidMapaCD(Long oidMapaCD) {
      this.oidMapaCD = oidMapaCD;
  }
  
  public String getDescripcionMapaCD() {
      return this.descripcionMapaCD;
  }
  
  public void setDescripcionMapaCD(String descripcionMapaCD) {
      this.descripcionMapaCD = descripcionMapaCD;
  }

  public Long getOidCentroDistribucion() {
    return oidCentroDistribucion;
  }

  public void setOidCentroDistribucion(Long oidCentroDistribucion) {
    this.oidCentroDistribucion = oidCentroDistribucion;
  }

  public String getDescripcionCD() {
    return descripcionCD;
  }

  public void setDescripcionCD(String descripcionCD) {
    this.descripcionCD = descripcionCD;
  }

  public Long getOidLineaArmado() {
    return oidLineaArmado;
  }

  public void setOidLineaArmado(Long oidLineaArmado) {
    this.oidLineaArmado = oidLineaArmado;
  }

  public String getDescripcionLinea() {
    return descripcionLinea;
  }

  public void setDescripcionLinea(String descripcionLinea) {
    this.descripcionLinea = descripcionLinea;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }
}