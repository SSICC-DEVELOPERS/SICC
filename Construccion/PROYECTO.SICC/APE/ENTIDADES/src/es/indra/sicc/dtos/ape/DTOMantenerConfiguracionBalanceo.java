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
 */

package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

public class DTOMantenerConfiguracionBalanceo extends DTOSiccPaginacion {
  private Long oidCentroDistribucion;
  private Long oidFuncionDistribucion;
  private Long oidLineaArmado;
  private Long[] oidsEliminar;
  private BigDecimal porcentajeVariacionEstimado;
  
  // dmorello, 27/09/2007: Por error reportado via mail desde Pruebas
  private String casoUso;

  public Long getOidCentroDistribucion()
  {
    return oidCentroDistribucion;
  }

  public void setOidCentroDistribucion(Long oidCentroDistribucion)
  {
    this.oidCentroDistribucion = oidCentroDistribucion;
  }

  public Long getOidFuncionDistribucion()
  {
    return oidFuncionDistribucion;
  }

  public void setOidFuncionDistribucion(Long oidFuncionDistribucion)
  {
    this.oidFuncionDistribucion = oidFuncionDistribucion;
  }

  public Long getOidLineaArmado()
  {
    return oidLineaArmado;
  }

  public void setOidLineaArmado(Long oidLineaArmado)
  {
    this.oidLineaArmado = oidLineaArmado;
  }

  public Long[] getOidsEliminar()
  {
    return oidsEliminar;
  }

  public void setOidsEliminar(Long[] oidsEliminar)
  {
    this.oidsEliminar = oidsEliminar;
  }

  public BigDecimal getPorcentajeVariacionEstimado()
  {
    return porcentajeVariacionEstimado;
  }

  public void setPorcentajeVariacionEstimado(BigDecimal porcentajeVariacionEstimado)
  {
    this.porcentajeVariacionEstimado = porcentajeVariacionEstimado;
  }

  public String getCasoUso()
  {
    return casoUso;
  }

  public void setCasoUso(String casoUso)
  {
    this.casoUso = casoUso;
  }
}