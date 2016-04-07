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
import java.math.BigDecimal;
import java.util.ArrayList;

public class DTOPreasignarProducto  extends DTOBelcorp  {
  private Long oidCD;
  private Long oidLinea;
  private Long oidMapaCD;
  private Long oidMapaZona;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodoOrigen;
  private String versionOrigen;
  private String codFuentePeriodoOrigen;
  private Long oidPeriodoDestino;
  private Long oidAsignacionProductoAnaquelCabecera;
  private String codProcedenciaNoElimina;
  private BigDecimal porcentajeVariacionEstimado;
  private ArrayList lstProdAnaqPerioActual;
  // vbongiov -- 4/05/2007 -- Inc 400 -- Peticion de cambio 12
  public String versionDestino;
  // vbongiov -- 7/08/2007 -- Inc BELC400000619
  private Long oidAsignacionProductoAnaquelCabDestino;

  public DTOPreasignarProducto() {
  }

  public Long getOidCD() {
    return oidCD;
  }

  public void setOidCD(Long oidCD) {
    this.oidCD = oidCD;
  }

  public Long getOidLinea() {
    return oidLinea;
  }

  public void setOidLinea(Long oidLinea) {
    this.oidLinea = oidLinea;
  }

  public Long getOidMapaCD() {
    return oidMapaCD;
  }

  public void setOidMapaCD(Long oidMapaCD) {
    this.oidMapaCD = oidMapaCD;
  }

  public Long getOidMapaZona() {
    return oidMapaZona;
  }

  public void setOidMapaZona(Long oidMapaZona) {
    this.oidMapaZona = oidMapaZona;
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

  public Long getOidPeriodoOrigen() {
    return oidPeriodoOrigen;
  }

  public void setOidPeriodoOrigen(Long oidPeriodo) {
    this.oidPeriodoOrigen = oidPeriodo;
  }

  public String getVersionOrigen() {
    return versionOrigen;
  }

  public void setVersionOrigen(String version) {
    this.versionOrigen = version;
  }

  public String getCodFuentePeriodoOrigen() {
    return codFuentePeriodoOrigen;
  }

  public void setCodFuentePeriodoOrigen(String codFuentePeriodoActual) {
    this.codFuentePeriodoOrigen = codFuentePeriodoActual;
  }

  public Long getOidPeriodoDestino() {
    return oidPeriodoDestino;
  }

  public void setOidPeriodoDestino(Long oidPeriodoActual) {
    this.oidPeriodoDestino = oidPeriodoActual;
  }





  public Long getOidAsignacionProductoAnaquelCabecera() {
    return oidAsignacionProductoAnaquelCabecera;
  }

  public void setOidAsignacionProductoAnaquelCabecera(Long oidAsignacionProductoAnaquelCabecera) {
    this.oidAsignacionProductoAnaquelCabecera = oidAsignacionProductoAnaquelCabecera;
  }

  public String getCodProcedenciaNoElimina() {
    return codProcedenciaNoElimina;
  }

  public void setCodProcedenciaNoElimina(String codProcedenciaNoElimina) {
    this.codProcedenciaNoElimina = codProcedenciaNoElimina;
  }

  public BigDecimal getPorcentajeVariacionEstimado() {
    return porcentajeVariacionEstimado;
  }

  public void setPorcentajeVariacionEstimado(BigDecimal porcentajeVariacionEstimado) {
    this.porcentajeVariacionEstimado = porcentajeVariacionEstimado;
  }

  public ArrayList getLstProdAnaqPerioActual() {
    return lstProdAnaqPerioActual;
  }

  public void setLstProdAnaqPerioActual(ArrayList lstProdAnaqPerioActual) {
    this.lstProdAnaqPerioActual = lstProdAnaqPerioActual;
  }

  public String getVersionDestino() {
    return versionDestino;
  }

  public void setVersionDestino(String versionDestino) {
    this.versionDestino = versionDestino;
  }

  public Long getOidAsignacionProductoAnaquelCabDestino() {
    return oidAsignacionProductoAnaquelCabDestino;
  }

  public void setOidAsignacionProductoAnaquelCabDestino(Long oidAsignacionProductoAnaquelCabDestino) {
    this.oidAsignacionProductoAnaquelCabDestino = oidAsignacionProductoAnaquelCabDestino;
  }
}