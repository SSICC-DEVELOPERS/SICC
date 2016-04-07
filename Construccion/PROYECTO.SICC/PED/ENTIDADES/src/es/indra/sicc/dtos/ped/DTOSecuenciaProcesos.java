package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOSecuenciaProcesos extends DTOSiccPaginacion  {
  private Long oid;
  private Long oidTipoSolicitudPais;
  private Long oidGrupoProcesos;
  private Long oidProceso;
  private Integer secuencia;
  private Boolean indEjecucion;


  public DTOSecuenciaProcesos() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Long getOidTipoSolicitudPais() {
    return oidTipoSolicitudPais;
  }

  public void setOidTipoSolicitudPais(Long newOidTipoSolicitudPais) {
    oidTipoSolicitudPais = newOidTipoSolicitudPais;
  }

  public Long getOidGrupoProcesos() {
    return oidGrupoProcesos;
  }

  public void setOidGrupoProcesos(Long newOidGrupoProcesos) {
    oidGrupoProcesos = newOidGrupoProcesos;
  }

  public Long getOidProceso() {
    return oidProceso;
  }

  public void setOidProceso(Long newOidProceso) {
    oidProceso = newOidProceso;
  }

  public Integer getSecuencia() {
    return secuencia;
  }

  public void setSecuencia(Integer newSecuencia) {
    secuencia = newSecuencia;
  }

  public Boolean getIndEjecucion() {
    return indEjecucion;
  }

  public void setIndEjecucion(Boolean newIndEjecucion) {
    indEjecucion = newIndEjecucion;
  }
}