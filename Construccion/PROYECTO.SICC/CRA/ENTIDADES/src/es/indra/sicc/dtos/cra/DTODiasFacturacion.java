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
import java.sql.Date;

public class DTODiasFacturacion extends DTOAuditableSICC  {
  private Long oid;
  private Date fechaFinal;
  private Integer ndm;
  private Integer ndff;

  public DTODiasFacturacion() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Date getFechaFinal() {
    return fechaFinal;
  }

  public void setFechaFinal(Date newFechaFinal) {
    fechaFinal = newFechaFinal;
  }

  public Integer getNdm() {
    return ndm;
  }

  public void setNdm(Integer newNdm) {
    ndm = newNdm;
  }

  public Integer getNdff() {
    return ndff;
  }

  public void setNdff(Integer newNdff) {
    ndff = newNdff;
  }
}