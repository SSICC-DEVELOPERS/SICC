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
package es.indra.sicc.logicanegocio.ape;

public class ZonasSublinea  {
  private Long oidSublinea;
  private Integer bahiaDesde;
  private Integer bahiaHasta;

  public ZonasSublinea() {
  }

  public Long getOidSublinea() {
    return oidSublinea;
  }

  public void setOidSublinea(Long oidSublinea) {
    this.oidSublinea = oidSublinea;
  }

  public Integer getBahiaDesde() {
    return bahiaDesde;
  }

  public void setBahiaDesde(Integer bahiaDesde) {
    this.bahiaDesde = bahiaDesde;
  }

  public Integer getBahiaHasta() {
    return bahiaHasta;
  }

  public void setBahiaHasta(Integer bahiaHasta) {
    this.bahiaHasta = bahiaHasta;
  }
}