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

public class DTOMapaZonasDetalle  extends DTOBelcorp  {
  private Long oid;
  private Long oidZona;
  private Long bahiaDesde;
  private Long bahiaHasta;
  private DTOMapaZonasCabecera mapaZonaCabecera;
  private DTOSublineaArmado sublineaArmado;

  public DTOMapaZonasDetalle() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public Long getOidZona() {
    return oidZona;
  }

  public void setOidZona(Long oidZona) {
    this.oidZona = oidZona;
  }

  public Long getBahiaDesde() {
    return bahiaDesde;
  }

  public void setBahiaDesde(Long bahiaDesde) {
    this.bahiaDesde = bahiaDesde;
  }

  public Long getBahiaHasta() {
    return bahiaHasta;
  }

  public void setBahiaHasta(Long bahiaHasta) {
    this.bahiaHasta = bahiaHasta;
  }

  public DTOMapaZonasCabecera getMapaZonaCabecera() {
    return mapaZonaCabecera;
  }

  public void setMapaZonaCabecera(DTOMapaZonasCabecera mapaZonaCabecera) {
    this.mapaZonaCabecera = mapaZonaCabecera;
  }

  public DTOSublineaArmado getSublineaArmado() {
    return sublineaArmado;
  }

  public void setSublineaArmado(DTOSublineaArmado sublineaArmado) {
    this.sublineaArmado = sublineaArmado;
  }
}