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

public class DTODespachoPremios extends DTOBelcorp 
{

  private Long oidDespachoPremios;
  private Boolean indComunicacionProcesoAutomatico;
  private String mensajeDespachoAutomatico;
  private Boolean indComunicacionProcesoManual;
  private String mensajeDespachoManual;

  public DTODespachoPremios()
  {
  }

  public Long getOidDespachoPremios()
  {
    return oidDespachoPremios;
  }

  public void setOidDespachoPremios(Long oidDespachoPremios)
  {
    this.oidDespachoPremios = oidDespachoPremios;
  }

  public Boolean getIndComunicacionProcesoAutomatico()
  {
    return indComunicacionProcesoAutomatico;
  }

  public void setIndComunicacionProcesoAutomatico(Boolean indComunicacionProcesoAutomatico)
  {
    this.indComunicacionProcesoAutomatico = indComunicacionProcesoAutomatico;
  }

  public String getMensajeDespachoAutomatico()
  {
    return mensajeDespachoAutomatico;
  }

  public void setMensajeDespachoAutomatico(String mensajeDespachoAutomatico)
  {
    this.mensajeDespachoAutomatico = mensajeDespachoAutomatico;
  }

  public Boolean getIndComunicacionProcesoManual()
  {
    return indComunicacionProcesoManual;
  }

  public void setIndComunicacionProcesoManual(Boolean indComunicacionProcesoManual)
  {
    this.indComunicacionProcesoManual = indComunicacionProcesoManual;
  }

  public String getMensajeDespachoManual()
  {
    return mensajeDespachoManual;
  }

  public void setMensajeDespachoManual(String mensajeDespachoManual)
  {
    this.mensajeDespachoManual = mensajeDespachoManual;
  }

}