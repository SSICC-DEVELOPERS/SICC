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
import java.util.ArrayList;

public class DTOGestionProductosNoRecogibles extends DTOSiccPaginacion  {
  private ArrayList productosNoRecogibles;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodo;

  public DTOGestionProductosNoRecogibles() {
  }

  public ArrayList getProductosNoRecogibles() {
    return productosNoRecogibles;
  }

  public void setProductosNoRecogibles(ArrayList productosNoRecogibles) {
    this.productosNoRecogibles = productosNoRecogibles;
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

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }
}