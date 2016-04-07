/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.dtos.ape;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;

public class DTOMapaZonasDetalleSubLineas  extends DTOBelcorp  {
  private RecordSet mapaZonasDetalle;
  private RecordSet subLineas;

  public DTOMapaZonasDetalleSubLineas() {
  }

  public RecordSet getMapaZonasDetalle() {
    return mapaZonasDetalle;
  }

  public void setMapaZonasDetalle(RecordSet mapaZonasDetalle) {
    this.mapaZonasDetalle = mapaZonasDetalle;
  }

  public RecordSet getSubLineas() {
    return subLineas;
  }

  public void setSubLineas(RecordSet subLineas) {
    this.subLineas = subLineas;
  }
}