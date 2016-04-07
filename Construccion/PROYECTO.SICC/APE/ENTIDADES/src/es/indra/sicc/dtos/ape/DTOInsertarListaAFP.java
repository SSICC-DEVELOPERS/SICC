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

import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOBelcorp;

public class DTOInsertarListaAFP extends DTOBelcorp  {
  private Long oidCabeceraListaAFP;
  private DTOColeccion coleccion;

  public DTOInsertarListaAFP() {
  }

  public Long getOidCabeceraListaAFP() {
    return oidCabeceraListaAFP;
  }

  public void setOidCabeceraListaAFP(Long oidCabeceraListaAFP) {
    this.oidCabeceraListaAFP = oidCabeceraListaAFP;
  }

  public DTOColeccion getColeccion() {
    return coleccion;
  }

  public void setColeccion(DTOColeccion coleccion) {
    this.coleccion = coleccion;
  }
}