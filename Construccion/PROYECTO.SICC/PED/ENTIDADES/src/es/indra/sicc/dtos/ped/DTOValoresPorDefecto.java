package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOValoresPorDefecto extends DTOSiccPaginacion {
  private String valorPorDefecto;
  private Boolean indObligatorio;
  private Boolean indModificable;
  private Long oid;
  private Long oidCampo;
  private Long oidTipoSolicitudPais;
  private Long oidValorPorDefecto;
  
  public DTOValoresPorDefecto() {
  }

  public String getValorPorDefecto() {
    return this.valorPorDefecto;
  }

  public void setValorPorDefecto(String newValorPorDefecto) {
    this.valorPorDefecto = newValorPorDefecto;
  }

  public Boolean getIndObligatorio() {
    return this.indObligatorio;
  }

  public void setIndObligatorio(Boolean newIndObligatorio) {
    this.indObligatorio = newIndObligatorio;
  }

  public Boolean getIndModificable() {
    return this.indModificable;
  }

  public void setIndModificable(Boolean newIndModificable) {
    this.indModificable = newIndModificable;
  }

  public Long getOid() {
    return this.oid;
  }

  public void setOid(Long newOid) {
    this.oid = newOid;
  }

  public Long getOidCampo() {
    return this.oidCampo;
  }

  public void setOidCampo(Long newOidCampo) {
    this.oidCampo = newOidCampo;
  }

  public Long getOidTipoSolicitudPais() {
    return this.oidTipoSolicitudPais;
  }

  public void setOidTipoSolicitudPais(Long newOidTipoSolicitudPais) {
    this.oidTipoSolicitudPais = newOidTipoSolicitudPais;
  }

  public Long getOidValorPorDefecto() {
    return oidValorPorDefecto;
  }

  public void setOidValorPorDefecto(Long newOidValorPorDefecto) {
    oidValorPorDefecto = newOidValorPorDefecto;
  }
}