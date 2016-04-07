/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.com;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.Date;

public class DTOCuotaCalculoReporte  extends DTOBelcorp {
  private Long oidCliente;
  private Long oidCuota;
  private BigDecimal importePagado;
  private BigDecimal importeCuota;
  private String ejerCuota;
  private Integer codTerri;
  private Date fechaValor;
  private Date fechaDocu;

  public DTOCuotaCalculoReporte() {
  }

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public Long getOidCuota() {
    return oidCuota;
  }

  public void setOidCuota(Long oidCuota) {
    this.oidCuota = oidCuota;
  }

  public BigDecimal getImportePagado() {
    return importePagado;
  }

  public void setImportePagado(BigDecimal importePagado) {
    this.importePagado = importePagado;
  }

  public BigDecimal getImporteCuota() {
    return importeCuota;
  }

  public void setImporteCuota(BigDecimal importeCuota) {
    this.importeCuota = importeCuota;
  }

  public String getEjerCuota() {
    return ejerCuota;
  }

  public void setEjerCuota(String ejerCuota) {
    this.ejerCuota = ejerCuota;
  }

  public Integer getCodTerri() {
    return codTerri;
  }

  public void setCodTerri(Integer codTerri) {
    this.codTerri = codTerri;
  }

  public Date getFechaValor() {
    return fechaValor;
  }

  public void setFechaValor(Date fechaValor) {
    this.fechaValor = fechaValor;
  }

  public Date getFechaDocu() {
    return fechaDocu;
  }

  public void setFechaDocu(Date fechaDocu) {
    this.fechaDocu = fechaDocu;
  }
}