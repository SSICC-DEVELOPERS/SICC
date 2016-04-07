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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Vector;

public class DTOMapaZonasCabecera extends DTOSiccPaginacion  {

  private Long oid;
  private Long codigoMapaZonas;
  private Vector descripcionMapaZonas;
  private Boolean valorDefecto;
  private DTOMapaCentroDistribucionCabecera mapaCentroDistribucionCabecerea;
  
  public DTOMapaZonasCabecera() {
  }


  public void setOid(Long oid) {
    this.oid = oid;
  }


  public Long getOid() {
    return oid;
  }


  public void setCodigoMapaZonas(Long codigoMapaZonas) {
    this.codigoMapaZonas = codigoMapaZonas;
  }


  public Long getCodigoMapaZonas() {
    return codigoMapaZonas;
  }


  public void setDescripcionMapaZonas(Vector descripcionMapaZonas) {
    this.descripcionMapaZonas = descripcionMapaZonas;
  }


  public Vector getDescripcionMapaZonas() {
    return descripcionMapaZonas;
  }


  public void setValorDefecto(Boolean valorDefecto) {
    this.valorDefecto = valorDefecto;
  }


  public Boolean getValorDefecto() {
    return valorDefecto;
  }


  public void setMapaCentroDistribucionCabecerea(DTOMapaCentroDistribucionCabecera mapaCentroDistribucionCabecerea) {
    this.mapaCentroDistribucionCabecerea = mapaCentroDistribucionCabecerea;
  }


  public DTOMapaCentroDistribucionCabecera getMapaCentroDistribucionCabecerea() {
    return mapaCentroDistribucionCabecerea;
  }
}