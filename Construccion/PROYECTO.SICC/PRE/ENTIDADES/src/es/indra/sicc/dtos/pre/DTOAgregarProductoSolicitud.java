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

public class DTOAgregarProductoSolicitud extends DTOAuditableSICC {
  private Long oidTipoPosicion;
  private Long oidSubtipoPosicion;
  private String codigoVenta;
  private Long numeroPosicion;
  private Long unidadesPorAtender;

  public DTOAgregarProductoSolicitud() {
  }

  public Long getOidTipoPosicion() {
    return oidTipoPosicion;
  }

  public void setOidTipoPosicion(Long newOidTipoPosicion) {
    oidTipoPosicion = newOidTipoPosicion;
  }

  public Long getOidSubtipoPosicion() {
    return oidSubtipoPosicion;
  }

  public void setOidSubtipoPosicion(Long newOidSubtipoPosicion) {
    oidSubtipoPosicion = newOidSubtipoPosicion;
  }

  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String newCodigoVenta) {
    codigoVenta = newCodigoVenta;
  }

  public Long getNumeroPosicion() {
    return numeroPosicion;
  }

  public void setNumeroPosicion(Long newNumeroPosicion) {
    numeroPosicion = newNumeroPosicion;
  }

  public Long getUnidadesPorAtender() {
    return unidadesPorAtender;
  }

  public void setUnidadesPorAtender(Long newUnidadesPorAtender) {
    unidadesPorAtender = newUnidadesPorAtender;
  }
  
}