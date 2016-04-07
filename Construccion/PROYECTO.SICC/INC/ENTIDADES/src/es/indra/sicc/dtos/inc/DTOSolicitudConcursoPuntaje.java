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

import java.sql.Date;

public class DTOSolicitudConcursoPuntaje extends DTOBelcorp
{
  private Long oid;
  private Integer numeroPuntos;
  private Integer puntajeBonificacion;
  private Integer puntajeFaltantesNoAnunciados;
  private Date fechaDocumento;
  private Boolean anulada;
  private Long oidConcurso;
  private Long oidSolicitud;
  private Long oidPeriodo;
  private Long oidConsultora;

  public DTOSolicitudConcursoPuntaje()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Integer getNumeroPuntos()
  {
    return numeroPuntos;
  }

  public void setNumeroPuntos(Integer numeroPuntos)
  {
    this.numeroPuntos = numeroPuntos;
  }

  public Integer getPuntajeBonificacion()
  {
    return puntajeBonificacion;
  }

  public void setPuntajeBonificacion(Integer puntajeBonificacion)
  {
    this.puntajeBonificacion = puntajeBonificacion;
  }

  public Integer getPuntajeFaltantesNoAnunciados()
  {
    return puntajeFaltantesNoAnunciados;
  }

  public void setPuntajeFaltantesNoAnunciados(Integer puntajeFaltantesNoAnunciados)
  {
    this.puntajeFaltantesNoAnunciados = puntajeFaltantesNoAnunciados;
  }

  public Date getFechaDocumento()
  {
    return fechaDocumento;
  }

  public void setFechaDocumento(Date fechaDocumento)
  {
    this.fechaDocumento = fechaDocumento;
  }

  public Boolean getAnulada()
  {
    return anulada;
  }

  public void setAnulada(Boolean anulada)
  {
    this.anulada = anulada;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidSolicitud()
  {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long oidSolicitud)
  {
    this.oidSolicitud = oidSolicitud;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidConsultora()
  {
    return oidConsultora;
  }

  public void setOidConsultora(Long oidConsultora)
  {
    this.oidConsultora = oidConsultora;
  }
}