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
package es.indra.sicc.dtos.rec;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOProductoNoRecogible extends DTOSiccPaginacion  {

  private Long oid;
  private Long oidDetalleOferta;
  private Long oidArticuloLote;
  private String tipoOperacion;//Para manejar el estado Alta, Baja o Modificacion.
  
  //Nota: el oidPais esta en la herencia, junto con el idioma en el caso que se use como criterio de busqueda.

  public DTOProductoNoRecogible() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }







  public Long getOidDetalleOferta() {
    return oidDetalleOferta;
  }

  public void setOidDetalleOferta(Long oidDetalleOferta) {
    this.oidDetalleOferta = oidDetalleOferta;
  }

  public Long getOidArticuloLote() {
    return oidArticuloLote;
  }

  public void setOidArticuloLote(Long oidArticuloLote) {
    this.oidArticuloLote = oidArticuloLote;
  }

  public String getTipoOperacion() {
    return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion) {
    this.tipoOperacion = tipoOperacion;
  }
}