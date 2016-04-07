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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOAgrupacionEspecifica extends DTOSiccPaginacion  {
  private Long oidMarca;
  private Long oidCanal;
  private Long oidRegion;
  private Long oidZona;
  private Long oidSeccion;
  private Long oidCentroDistribucion;
  private Long agrupacionEspecifica;
  private Long numeroLinea;
  private Long oidConfiguracionListaAFPCabecera;
  //vbongiov -- BELC400000562 -- 11/07/2007 
  private String descAgrupacionEspecifica;

  public DTOAgrupacionEspecifica() {
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

  public Long getOidRegion() {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion) {
    this.oidRegion = oidRegion;
  }

  public Long getOidZona() {
    return oidZona;
  }

  public void setOidZona(Long oidZona) {
    this.oidZona = oidZona;
  }

  public Long getOidSeccion() {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion) {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidCentroDistribucion() {
    return oidCentroDistribucion;
  }

  public void setOidCentroDistribucion(Long oidCentroDistribucion) {
    this.oidCentroDistribucion = oidCentroDistribucion;
  }

  public Long getAgrupacionEspecifica() {
    return agrupacionEspecifica;
  }

  public void setAgrupacionEspecifica(Long agrupacionEspecifica) {
    this.agrupacionEspecifica = agrupacionEspecifica;
  }

  public Long getNumeroLinea() {
    return numeroLinea;
  }

  public void setNumeroLinea(Long numeroLinea) {
    this.numeroLinea = numeroLinea;
  }

  public Long getOidConfiguracionListaAFPCabecera() {
    return oidConfiguracionListaAFPCabecera;
  }

  public void setOidConfiguracionListaAFPCabecera(Long oidConfiguracionListaAFPCabecera) {
    this.oidConfiguracionListaAFPCabecera = oidConfiguracionListaAFPCabecera;
  }

  public String getDescAgrupacionEspecifica() {
    return descAgrupacionEspecifica;
  }

  public void setDescAgrupacionEspecifica(String descAgrupacionEspecifica) {
    this.descAgrupacionEspecifica = descAgrupacionEspecifica;
  }
}