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
import java.math.BigDecimal;
import java.util.Vector;

public class DTOTipoCajaEmbalaje extends DTOSiccPaginacion  {
  private Long oid;
  private String tipoCaja;
  private String descripcion;
  private BigDecimal capacidad;
  private BigDecimal capacidadMinima;
  private Boolean indicadorCubicaje;
  private BigDecimal porcentajeSeguridad;
  private BigDecimal nivelAplicacion;
  private Long numeroEtiquetas;
  private BigDecimal alto;
  private BigDecimal largo;
  private BigDecimal ancho;
  private Long oidUnidadMedidaExterior;
  private Long oidUnidadMedidaCapacidad;
  private BigDecimal volumenSobrante;  
  private Vector vectorConTraducciones;
  private String descripcionLinea;

  public DTOTipoCajaEmbalaje() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public String getTipoCaja() {
    return tipoCaja;
  }

  public void setTipoCaja(String tipoCaja) {
    this.tipoCaja = tipoCaja;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public BigDecimal getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(BigDecimal capacidad) {
    this.capacidad = capacidad;
  }

  public BigDecimal getCapacidadMinima() {
    return capacidadMinima;
  }

  public void setCapacidadMinima(BigDecimal capacidadMinima) {
    this.capacidadMinima = capacidadMinima;
  }

  public Boolean getIndicadorCubicaje() {
    return indicadorCubicaje;
  }

  public void setIndicadorCubicaje(Boolean indicadorCubicaje) {
    this.indicadorCubicaje = indicadorCubicaje;
  }

  public BigDecimal getPorcentajeSeguridad() {
    return porcentajeSeguridad;
  }

  public void setPorcentajeSeguridad(BigDecimal porcentajeSeguridad) {
    this.porcentajeSeguridad = porcentajeSeguridad;
  }

  public BigDecimal getNivelAplicacion() {
    return nivelAplicacion;
  }

  public void setNivelAplicacion(BigDecimal nivelAplicacion) {
    this.nivelAplicacion = nivelAplicacion;
  }

  public Long getNumeroEtiquetas() {
    return numeroEtiquetas;
  }

  public void setNumeroEtiquetas(Long numeroEtiquetas) {
    this.numeroEtiquetas = numeroEtiquetas;
  }

  public BigDecimal getAlto() {
    return alto;
  }

  public void setAlto(BigDecimal alto) {
    this.alto = alto;
  }

  public BigDecimal getLargo() {
    return largo;
  }

  public void setLargo(BigDecimal largo) {
    this.largo = largo;
  }

  public BigDecimal getAncho() {
    return ancho;
  }

  public void setAncho(BigDecimal ancho) {
    this.ancho = ancho;
  }

  public Long getOidUnidadMedidaExterior() {
    return oidUnidadMedidaExterior;
  }

  public void setOidUnidadMedidaExterior(Long oidUnidadMedidaExterior) {
    this.oidUnidadMedidaExterior = oidUnidadMedidaExterior;
  }

  public Long getOidUnidadMedidaCapacidad() {
    return oidUnidadMedidaCapacidad;
  }

  public void setOidUnidadMedidaCapacidad(Long oidUnidadMedidaCapacidad) {
    this.oidUnidadMedidaCapacidad = oidUnidadMedidaCapacidad;
  }

  public BigDecimal getVolumenSobrante() {
    return volumenSobrante;
  }

  public void setVolumenSobrante(BigDecimal volumenSobrante) {
    this.volumenSobrante = volumenSobrante;
  }
  
  public Vector getVectorConTraducciones() {
    return vectorConTraducciones;
  }

  public void setVectorConTraducciones(Vector newVectorConTraducciones) {
    vectorConTraducciones = newVectorConTraducciones;
  }

  public String getDescripcionLinea() {
    return descripcionLinea;
  }

  public void setDescripcionLinea(String descripcionLinea) {
    this.descripcionLinea = descripcionLinea;
  }
  
}