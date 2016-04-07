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
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOObtencionPuntos extends DTOBelcorp
{
  private BigDecimal factorConversion;
  private Integer puntosAsignar;
  private Integer indComunicacion;
  private String mensaje;
  private Integer indPuntajeAcumulativo;
  private Integer indActividad;
  private Integer indConstancia;
  private Long oidObtencionPuntos;
  
    // sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
    private Integer numPeriodosSinPedido;

  public DTOObtencionPuntos()
  {
  }

  public BigDecimal getFactorConversion()
  {
    return factorConversion;
  }

  public void setFactorConversion(BigDecimal factorConversion)
  {
    this.factorConversion = factorConversion;
  }

  public Integer getPuntosAsignar()
  {
    return puntosAsignar;
  }

  public void setPuntosAsignar(Integer puntosAsignar)
  {
    this.puntosAsignar = puntosAsignar;
  }

  public Integer getIndComunicacion()
  {
    return indComunicacion;
  }

  public void setIndComunicacion(Integer indComunicacion)
  {
    this.indComunicacion = indComunicacion;
  }

  public String getMensaje()
  {
    return mensaje;
  }

  public void setMensaje(String mensaje)
  {
    this.mensaje = mensaje;
  }

  public Integer getIndPuntajeAcumulativo()
  {
    return indPuntajeAcumulativo;
  }

  public void setIndPuntajeAcumulativo(Integer indPuntajeAcumulativo)
  {
    this.indPuntajeAcumulativo = indPuntajeAcumulativo;
  }

  public Integer getIndActividad()
  {
    return indActividad;
  }

  public void setIndActividad(Integer indActividad)
  {
    this.indActividad = indActividad;
  }

  public Integer getIndConstancia()
  {
    return indConstancia;
  }

  public void setIndConstancia(Integer indConstancia)
  {
    this.indConstancia = indConstancia;
  }

  public Long getOidObtencionPuntos()
  {
    return oidObtencionPuntos;
  }

  public void setOidObtencionPuntos(Long oidObtencionPuntos)
  {
    this.oidObtencionPuntos = oidObtencionPuntos;
  }

    public void setNumPeriodosSinPedido(Integer numPeriodosSinPedido) {
        this.numPeriodosSinPedido = numPeriodosSinPedido;
    }

    public Integer getNumPeriodosSinPedido() {
        return numPeriodosSinPedido;
    }
}
