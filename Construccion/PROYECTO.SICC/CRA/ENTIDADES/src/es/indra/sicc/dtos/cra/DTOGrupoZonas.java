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

public class DTOGrupoZonas extends DTOAuditableSICC  {
  private String nombre;
  private Boolean status;
  private String tipoFacturacion;
  private Long oid;
  private Integer codigo;
  private Long oidPais;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidMarca;
  private Long oidRegion;

  public DTOGrupoZonas() {
    super();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String newNombre) {
    nombre = newNombre;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean newStatus) {
    status = newStatus;
  }

  public String getTipoFacturacion() {
    return tipoFacturacion;
  }

  public void setTipoFacturacion(String newTipoFacturacion) {
    tipoFacturacion = newTipoFacturacion;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer newCodigo) {
    codigo = newCodigo;
  }

  public Long getOidPais() {
    return oidPais;
  }

  public void setOidPais(Long newOidPais) {
    oidPais = newOidPais;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long newOidCanal) {
    oidCanal = newOidCanal;
  }

  public Long getOidAcceso() {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso) {
    oidAcceso = newOidAcceso;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca) {
    oidMarca = newOidMarca;
  }

  public Long getOidRegion() {
    return oidRegion;
  }

  public void setOidRegion(Long newOidRegion) {
    oidRegion = newOidRegion;
  }
}