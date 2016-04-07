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
package es.indra.sicc.dtos.zon;
import java.util.Date;
import es.indra.sicc.util.DTOBelcorp;

public class DTOEjecutarReterritorializacionCab  extends DTOBelcorp {
  private Long oidCanal;
  private Long oidMarca;
  private String tipoPeriodo;
  private Long oidPeriodoInicio;
  private Date fechaActualizacion;
  private String codTipoPeriodo;
  private String codPeriodo;
  private String codPais;
  private String codMarca;
  private String codCanal;

  public DTOEjecutarReterritorializacionCab() {
      super();
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }
  
  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

  public String getTipoPeriodo() {
    return tipoPeriodo;
  }

  public void setTipoPeriodo(String tipoPeriodo) {
    this.tipoPeriodo = tipoPeriodo;
  }

  public Long getOidPeriodoInicio() {
    return oidPeriodoInicio;
  }

  public void setOidPeriodoInicio(Long oidPeriodoInicio) {
    this.oidPeriodoInicio = oidPeriodoInicio;
  }

  public Date getFechaActualizacion() {
    return fechaActualizacion;
  }

  public void setFechaActualizacion(Date fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }

  public String getCodTipoPeriodo() {
    return codTipoPeriodo;
  }

  public void setCodTipoPeriodo(String codTipoPeriodo) {
    this.codTipoPeriodo = codTipoPeriodo;
  }

  public String getCodPeriodo() {
    return codPeriodo;
  }

  public void setCodPeriodo(String codPeriodo) {
    this.codPeriodo = codPeriodo;
  }

  public String getCodPais() {
    return codPais;
  }

  public void setCodPais(String codPais) {
    this.codPais = codPais;
  }

  public String getCodMarca() {
    return codMarca;
  }

  public void setCodMarca(String codMarca) {
    this.codMarca = codMarca;
  }

  public String getCodCanal() {
    return codCanal;
  }

  public void setCodCanal(String codCanal) {
    this.codCanal = codCanal;
  }
}