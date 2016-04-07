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
 *
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosCajaDetalle extends DTOBelcorp {


  private Long oidListaPicadoDetalle;
  private Long secuencia;
  private String descripcionProducto;
  private String numeroAnaquel;
  private Long cantidadRequerida;
  private Long cantidadChequeada;
  private Long oidCodigoErrorChequeo;
  private Long oidMapaCDDetalle;
  private Long oidProducto;

    public DTODatosCajaDetalle() {
    }

  public Long getOidListaPicadoDetalle() {
    return oidListaPicadoDetalle;
  }

  public void setOidListaPicadoDetalle(Long oidListaPicadoDetalle) {
    this.oidListaPicadoDetalle = oidListaPicadoDetalle;
  }

  public Long getSecuencia() {
    return secuencia;
  }

  public void setSecuencia(Long secuencia) {
    this.secuencia = secuencia;
  }

  public String getDescripcionProducto() {
    return descripcionProducto;
  }

  public void setDescripcionProducto(String descripcionProducto) {
    this.descripcionProducto = descripcionProducto;
  }

  public String getNumeroAnaquel() {
    return numeroAnaquel;
  }

  public void setNumeroAnaquel(String numeroAnaquel) {
    this.numeroAnaquel = numeroAnaquel;
  }

  public Long getCantidadRequerida() {
    return cantidadRequerida;
  }

  public void setCantidadRequerida(Long cantidadRequerida) {
    this.cantidadRequerida = cantidadRequerida;
  }

  public Long getCantidadChequeada() {
    return cantidadChequeada;
  }

  public void setCantidadChequeada(Long cantidadChequeada) {
    this.cantidadChequeada = cantidadChequeada;
  }

  public Long getOidCodigoErrorChequeo() {
    return oidCodigoErrorChequeo;
  }

  public void setOidCodigoErrorChequeo(Long oidCodigoErrorChequeo) {
    this.oidCodigoErrorChequeo = oidCodigoErrorChequeo;
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