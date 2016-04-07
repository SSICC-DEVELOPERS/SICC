package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOGenerarFicheroRangoCampanya extends DTOAuditableSICC {
  private String marca;
  private String canal;
  private String acceso;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  /**
   * Autor: Cortaberria
   * Fecha: 11/04/2005
   * Se modifico Integer por Long a numLote
   */
  private Long numLote;
  private String descripcion;
  private String observaciones;

  public String getMarca() {
    return marca;
  }

  public void setMarca(String newMarca) {
    marca = newMarca;
  }

  public String getCanal() {
    return canal;
  }

  public void setCanal(String newCanal) {
    canal = newCanal;
  }

  public String getAcceso() {
    return acceso;
  }

  public void setAcceso(String newAcceso) {
    acceso = newAcceso;
  }

  public Long getOidPeriodoDesde() {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long newOidPeriodoDesde) {
    oidPeriodoDesde = newOidPeriodoDesde;
  }

  public Long getOidPeriodoHasta() {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long newOidPeriodoHasta) {
    oidPeriodoHasta = newOidPeriodoHasta;
  }

  public Long getNumLote() {
    return numLote;
  }

  public void setNumLote(Long newNumLote) {
    numLote = newNumLote;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion) {
    descripcion = newDescripcion;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String newObservaciones) {
    observaciones = newObservaciones;
  }
  
}