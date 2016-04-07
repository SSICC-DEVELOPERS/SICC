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

public class DTOListaPicado extends DTOBelcorp {
  private Long oidListaPicado;
  private Long oidCentroDistribucion;
  private Long oidLineaArmado;
  private Long oidPeriodo;

  public Long getOidListaPicado()
  {
    return oidListaPicado;
  }

  public void setOidListaPicado(Long oidListaPicado)
  {
    this.oidListaPicado = oidListaPicado;
  }

  public Long getOidCentroDistribucion()
  {
    return oidCentroDistribucion;
  }

  public void setOidCentroDistribucion(Long oidCentroDistribucion)
  {
    this.oidCentroDistribucion = oidCentroDistribucion;
  }

  public Long getOidLineaArmado()
  {
    return oidLineaArmado;
  }

  public void setOidLineaArmado(Long oidLineaArmado)
  {
    this.oidLineaArmado = oidLineaArmado;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

}