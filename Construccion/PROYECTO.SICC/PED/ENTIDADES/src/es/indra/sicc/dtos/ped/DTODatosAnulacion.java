package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODatosAnulacion extends DTOAuditableSICC  {
  private Long oidSolicitud;
  private Boolean indAnulacion;
  private Long oidSolicitudReferencia;
  private Long oidConcurso;
  private Long numeroPremio;
  private Long oidTipoPrograma;

  public DTODatosAnulacion() {
  }

  public Long getOidSolicitud() {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long newOidSolicitud) {
    oidSolicitud = newOidSolicitud;
  }

  public Boolean getIndAnulacion() {
    return indAnulacion;
  }

  public void setIndAnulacion(Boolean newIndAnulacion) {
    indAnulacion = newIndAnulacion;
  }

  public Long getOidSolicitudReferencia() {
    return oidSolicitudReferencia;
  }

  public void setOidSolicitudReferencia(Long newOidSolicitudReferencia) {
    oidSolicitudReferencia = newOidSolicitudReferencia;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getNumeroPremio()
  {
    return numeroPremio;
  }

  public void setNumeroPremio(Long numeroPremio)
  {
    this.numeroPremio = numeroPremio;
  }

  public Long getOidTipoPrograma()
  {
    return oidTipoPrograma;
  }

  public void setOidTipoPrograma(Long oidTipoPrograma)
  {
    this.oidTipoPrograma = oidTipoPrograma;
  }
}