/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

 
package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCambiosVentas extends DTOAuditableSICC
{
  private Long oidPais;
  private Long oidSubacceso;
  private Long numeroSolicitud;
  private Boolean simulacion;
  private Long oidSolicitud;
  private String userName;
  
  public DTOCambiosVentas()
  {
  }

  public Long getOidPais()
  {
    return oidPais;
  }

  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public Long getNumeroSolicitud()
  {
    return numeroSolicitud;
  }

  public void setNumeroSolicitud(Long numeroSolicitud)
  {
    this.numeroSolicitud = numeroSolicitud;
  }

  public Boolean getSimulacion()
  {
    return simulacion;
  }

  public void setSimulacion(Boolean simulacion)
  {
    this.simulacion = simulacion;
  }

  public Long getOidSolicitud()
  {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long oidSolicitud)
  {
    this.oidSolicitud = oidSolicitud;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
}