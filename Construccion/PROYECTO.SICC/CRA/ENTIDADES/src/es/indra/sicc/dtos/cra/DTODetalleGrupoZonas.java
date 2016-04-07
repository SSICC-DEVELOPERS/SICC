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
 */
package es.indra.sicc.dtos.cra;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODetalleGrupoZonas extends DTOAuditableSICC  {
  private Long oid;
  private Long oidZona;

  public DTODetalleGrupoZonas() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Long getOidZona() {
    return oidZona;
  }

  public void setOidZona(Long newOidZona) {
    oidZona = newOidZona;
  }
}