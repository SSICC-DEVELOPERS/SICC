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

public class DTOFiltroProductoNoRecogible extends DTOGestionProductosNoRecogibles  {

  private String codigoVenta;
  private String codigoVentaFicticio;
  private String codigoSAP;
  private String descripcion;

  public DTOFiltroProductoNoRecogible() {
  }

  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta) {
    this.codigoVenta = codigoVenta;
  }

  public String getCodigoVentaFicticio() {
    return codigoVentaFicticio;
  }

  public void setCodigoVentaFicticio(String codigoVentaFicticio) {
    this.codigoVentaFicticio = codigoVentaFicticio;
  }

  public String getCodigoSAP() {
    return codigoSAP;
  }

  public void setCodigoSAP(String codigoSAP) {
    this.codigoSAP = codigoSAP;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}