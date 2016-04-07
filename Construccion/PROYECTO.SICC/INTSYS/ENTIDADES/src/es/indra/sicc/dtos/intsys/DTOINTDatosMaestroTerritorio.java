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
 */
 
package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTDatosMaestroTerritorio extends DTOBelcorp 
{
  private Long oidTerritorio;
  private String codigoTerritorio;
  private Long oidZona;
  private String codigoZona;

  public DTOINTDatosMaestroTerritorio()
  {
  }

  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }

  public String getCodigoTerritorio()
  {
    return codigoTerritorio;
  }

  public void setCodigoTerritorio(String codigoTerritorio)
  {
    this.codigoTerritorio = codigoTerritorio;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public String getCodigoZona()
  {
    return codigoZona;
  }

  public void setCodigoZona(String codigoZona)
  {
    this.codigoZona = codigoZona;
  }
  
  
}