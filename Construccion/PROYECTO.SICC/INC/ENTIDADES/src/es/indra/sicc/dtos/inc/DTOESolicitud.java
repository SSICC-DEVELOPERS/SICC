/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 * 
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOESolicitud extends DTOBelcorp
{
  private Long oidSolicitud;

  public DTOESolicitud()
  {
  }

  public Long getOidSolicitud()
  {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long oidSolicitud)
  {
    this.oidSolicitud = oidSolicitud;
  }
}