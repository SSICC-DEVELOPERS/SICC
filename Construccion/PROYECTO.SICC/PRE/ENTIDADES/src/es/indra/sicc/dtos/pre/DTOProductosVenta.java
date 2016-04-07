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
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;
import es.indra.sicc.dtos.pre.DTOProductoVenta;

public class DTOProductosVenta extends DTOAuditableSICC {
   private java.util.ArrayList listaProductos = null;
   private es.indra.sicc.dtos.pre.DTOProductoVenta productoPrincipal = null;

  public void setListaProductos(java.util.ArrayList ListaProductos) {

     this.listaProductos = ListaProductos;

  }

  public java.util.ArrayList getListaProductos() {

     return this.listaProductos;

  }

  public void setProductoPrincipal(es.indra.sicc.dtos.pre.DTOProductoVenta ProductoPrincipal) {

     this.productoPrincipal = ProductoPrincipal;

  }

  public es.indra.sicc.dtos.pre.DTOProductoVenta getProductoPrincipal() {

     return this.productoPrincipal;

  }

}