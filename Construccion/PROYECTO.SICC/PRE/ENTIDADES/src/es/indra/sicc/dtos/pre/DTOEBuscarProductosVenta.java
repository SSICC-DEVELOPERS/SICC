/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 */
package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

public class DTOEBuscarProductosVenta extends DTOSiccPaginacion {
   private java.lang.Long oidCabeceraMF;
   private java.lang.String codigoVenta;
   private java.lang.String descripcionProducto;
   private java.lang.Long oidPeriodo;
   private java.lang.Long tipoProductoEstrategia;

  public DTOEBuscarProductosVenta()
  {
  }


  public void setOidCabeceraMF(java.lang.Long OidCabeceraMF) {

     this.oidCabeceraMF = OidCabeceraMF;

  }

  public java.lang.Long getOidCabeceraMF() {

     return this.oidCabeceraMF;

  }

  public void setCodigoVenta(java.lang.String CodigoVenta) {

     this.codigoVenta = CodigoVenta;

  }

  public java.lang.String getCodigoVenta() {

     return this.codigoVenta;

  }

  public void setDescripcionProducto(java.lang.String DescripcionProducto) {

     this.descripcionProducto = DescripcionProducto;

  }

  public java.lang.String getDescripcionProducto() {

     return this.descripcionProducto;

  }

  public void setOidPeriodo(java.lang.Long OidPeriodo) {

     this.oidPeriodo = OidPeriodo;

  }

  public java.lang.Long getOidPeriodo() {

     return this.oidPeriodo;

  }

  public void setTipoProductoEstrategia(java.lang.Long TipoProductoEstrategia) {

     this.tipoProductoEstrategia = TipoProductoEstrategia;

  }

  public java.lang.Long getTipoProductoEstrategia() {

     return this.tipoProductoEstrategia;

  }

}