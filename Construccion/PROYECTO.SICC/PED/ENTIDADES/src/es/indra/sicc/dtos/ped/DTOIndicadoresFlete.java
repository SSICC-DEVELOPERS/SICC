package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOIndicadoresFlete extends DTOAuditableSICC  {
  private Boolean indTipoSolicitud;
  private Boolean indSolicitud;
  private Boolean indTipoCliExencion;
  private Long oidSolicitud;

  public DTOIndicadoresFlete() {
  }

  public Boolean getIndTipoSolicitud() {
    return indTipoSolicitud;
  }

  public void setIndTipoSolicitud(Boolean newIndTipoSolicitud) {
    indTipoSolicitud = newIndTipoSolicitud;
  }

  public Boolean getIndSolicitud() {
    return indSolicitud;
  }

  public void setIndSolicitud(Boolean newIndSolicitud) {
    indSolicitud = newIndSolicitud;
  }

  public Boolean getIndTipoCliExencion() {
    return indTipoCliExencion;
  }

  public void setIndTipoCliExencion(Boolean newIndTipoCliExencion) {
    indTipoCliExencion = newIndTipoCliExencion;
  }

  public Long getOidSolicitud() {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long newOidSolicitud) {
    oidSolicitud = newOidSolicitud;
  }
}