package es.indra.sicc.dtos.ndg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionDeFiltrado extends DTOAuditableSICC {

  Long oidMarca;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Long pais;
  private String codUsuario;
  private String marca;
  private String canal;
  private String acceso;
  private String periodoDesde;
  private String periodoHasta;
  
  //Para la opcion de interfaces de NDG-1 pzerbino 13/6/2006
  
  private Long numeroLote;
  private String descripcionLote;
  private String observacionesLote;
  

  public DTOInformacionDeFiltrado() {
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca) {
    oidMarca = newOidMarca;
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

  public Long getPais() {
    return pais;
  }

  public void setPais(Long newPais) {
    pais = newPais;
  }

  public String getCodUsuario() {
    return codUsuario;
  }

  public void setCodUsuario(String newCodUsuario) {
    codUsuario = newCodUsuario;
  }

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

  public String getPeriodoDesde() {
    return periodoDesde;
  }

  public void setPeriodoDesde(String newPeriodoDesde) {
    periodoDesde = newPeriodoDesde;
  }

  public String getPeriodoHasta() {
    return periodoHasta;
  }

  public void setPeriodoHasta(String newPeriodoHasta) {
    periodoHasta = newPeriodoHasta;
  }
  
  public Long getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(Long newNumeroLote) {
    numeroLote = newNumeroLote;
  }

  public String getDescripcionLote() {
    return descripcionLote;
  }

  public void setDescripcionLote(String newDescripcionLote) {
    descripcionLote = newDescripcionLote;
  }
  public String getObservacionesLote() {
    return observacionesLote;
  }

  public void setObservacionesLote(String newObservacionesLote) {
    observacionesLote = newObservacionesLote;
  }
  
}