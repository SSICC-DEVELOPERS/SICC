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
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Vector;

public class DTOAlmacen  extends DTOSiccPaginacion {
  private String codAlmacen;
  private String descripcion;
  private Boolean infSAP;
  private Long oidCentroDistribucion;
  private Vector descAlmacen;
  private Long oid;

  public DTOAlmacen() {
  }

  public String getCodAlmacen() {
    return codAlmacen;
  }

  public void setCodAlmacen(String codAlmacen) {
    this.codAlmacen = codAlmacen;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Boolean getInfSAP() {
    return infSAP;
  }

  public void setInfSAP(Boolean infSAP) {
    this.infSAP = infSAP;
  }

  public Long getOidCentroDistribucion() {
    return oidCentroDistribucion;
  }

  public void setOidCentroDistribucion(Long oidCentroDistribucion) {
    this.oidCentroDistribucion = oidCentroDistribucion;
  }

  public Vector getDescAlmacen() {
    return descAlmacen;
  }

  public void setDescAlmacen(Vector descAlmacen) {
    this.descAlmacen = descAlmacen;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }
}