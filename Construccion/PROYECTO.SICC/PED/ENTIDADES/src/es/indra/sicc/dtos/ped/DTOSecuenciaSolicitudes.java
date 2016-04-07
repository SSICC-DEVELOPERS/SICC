package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSecuenciaSolicitudes extends DTOAuditableSICC  {
  private Long oidZona;
  private Long oidTipoSolicitud;
  private Long secuencia;

  public DTOSecuenciaSolicitudes() {
  }

  public Long getOidZona() {
    return oidZona;
  }

  public void setOidZona(Long newOidZona) {
    oidZona = newOidZona;
  }

  public Long getOidTipoSolicitud() {
    return oidTipoSolicitud;
  }

  public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
    oidTipoSolicitud = newOidTipoSolicitud;
  }

  public Long getSecuencia() {
    return secuencia;
  }

  public void setSecuencia(Long newSecuencia) {
    secuencia = newSecuencia;
  }
}