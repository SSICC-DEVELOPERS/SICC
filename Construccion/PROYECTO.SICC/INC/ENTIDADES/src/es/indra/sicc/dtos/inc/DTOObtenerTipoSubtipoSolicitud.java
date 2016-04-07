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

public class DTOObtenerTipoSubtipoSolicitud extends DTOBelcorp {
  private Long oidOperacion;
  private Long oidCanal;
  private Long oidDirigidoA;
  private Long oidMarca;
  private Long oidConcurso;
  private Long oidCliente;
  private Long oidPeriodo;

  public DTOObtenerTipoSubtipoSolicitud() {
  }

  public Long getOidOperacion() {
    return oidOperacion;
  }

  public void setOidOperacion(Long oidOperacion) {
    this.oidOperacion = oidOperacion;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }

  public Long getOidDirigidoA() {
    return oidDirigidoA;
  }

  public void setOidDirigidoA(Long oidDirigidoA) {
    this.oidDirigidoA = oidDirigidoA;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

  public Long getOidConcurso() {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso) {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }
}