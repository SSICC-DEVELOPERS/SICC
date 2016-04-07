/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCargaMedioPago extends DTOAuditableSICC
{
  private Long oid;
  private String descripcion;
  private Long oidTipoMedioPago;

  public DTOCargaMedioPago()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public Long getOidTipoMedioPago()
  {
    return oidTipoMedioPago;
  }

  public void setOidTipoMedioPago(Long oidTipoMedioPago)
  {
    this.oidTipoMedioPago = oidTipoMedioPago;
  }
}