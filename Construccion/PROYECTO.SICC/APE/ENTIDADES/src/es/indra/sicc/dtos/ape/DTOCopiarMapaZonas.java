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

public class DTOCopiarMapaZonas   extends DTOBelcorp  {
  private DTOMapaZonasCabecera mapaZonasCabecera;
  private DTOMapaZonasDetalle mapaZonasDetalle;

  public DTOCopiarMapaZonas() {
  }

  public DTOMapaZonasCabecera getMapaZonasCabecera() {
    return mapaZonasCabecera;
  }

  public void setMapaZonasCabecera(DTOMapaZonasCabecera mapaZonasCabecera) {
    this.mapaZonasCabecera = mapaZonasCabecera;
  }

  public DTOMapaZonasDetalle getMapaZonasDetalle() {
    return mapaZonasDetalle;
  }

  public void setMapaZonasDetalle(DTOMapaZonasDetalle mapaZonasDetalle) {
    this.mapaZonasDetalle = mapaZonasDetalle;
  }
}