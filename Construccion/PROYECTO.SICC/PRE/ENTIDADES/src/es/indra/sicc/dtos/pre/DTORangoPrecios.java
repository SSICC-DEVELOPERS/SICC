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
 */
package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTORangoPrecios extends DTOAuditableSICC  {
  private Long oidDetaOferPrec;
  private Long rangoDesde;
  private Long rangoHasta;
  private BigDecimal precioPosicionamiento;
  private BigDecimal precioCatalogo;
  private Long oidDetaOfer;
  private Integer numeroOrdenRango;
  private String tipoOperacion;

  public DTORangoPrecios() {
  }

  public Long getOidDetaOferPrec() {
    return oidDetaOferPrec;
  }

  public void setOidDetaOferPrec(Long oidDetaOferPrec) {
    this.oidDetaOferPrec = oidDetaOferPrec;
  }

  public Long getRangoDesde() {
    return rangoDesde;
  }

  public void setRangoDesde(Long rangoDesde) {
    this.rangoDesde = rangoDesde;
  }

  public Long getRangoHasta() {
    return rangoHasta;
  }

  public void setRangoHasta(Long rangoHasta) {
    this.rangoHasta = rangoHasta;
  }

  public BigDecimal getPrecioPosicionamiento() {
    return precioPosicionamiento;
  }

  public void setPrecioPosicionamiento(BigDecimal precioPosicionamiento) {
    this.precioPosicionamiento = precioPosicionamiento;
  }

  public BigDecimal getPrecioCatalogo() {
    return precioCatalogo;
  }

  public void setPrecioCatalogo(BigDecimal precioCatalogo) {
    this.precioCatalogo = precioCatalogo;
  }

  public Long getOidDetaOfer() {
    return oidDetaOfer;
  }

  public void setOidDetaOfer(Long oidDetaOfer) {
    this.oidDetaOfer = oidDetaOfer;
  }

  public Integer getNumeroOrdenRango() {
    return numeroOrdenRango;
  }

  public void setNumeroOrdenRango(Integer numeroOrdenRango) {
    this.numeroOrdenRango = numeroOrdenRango;
  }

  public String getTipoOperacion() {
    return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion) {
    this.tipoOperacion = tipoOperacion;
  }
}