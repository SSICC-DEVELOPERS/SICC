package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
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
 * vbongiov -- 26/07/2006 -- inc DBLG500000906
 */
public class DTOBusquedaZonaTerritorioUA  extends DTOSiccPaginacion {
  private Long oidCliente;
  private Long oidPais;
  private Long oidMarca;
  private Long oidCanal;

  public DTOBusquedaZonaTerritorioUA() {
  }

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public Long getOidPais() {
    return oidPais;
  }

  public void setOidPais(Long oidPais) {
    this.oidPais = oidPais;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }
}