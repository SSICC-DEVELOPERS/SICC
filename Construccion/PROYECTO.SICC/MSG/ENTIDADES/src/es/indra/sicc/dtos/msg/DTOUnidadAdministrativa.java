package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUnidadAdministrativa extends DTOAuditableSICC  {
  private Long oidRegion;
  private Long oidSeccion;
  private Long oidTerritorio;
  private Long oidZona;
  private Long oidMensaje;
  private Long oidUnidadAdministrativa;
  private String nivel;

  public DTOUnidadAdministrativa() {
  }

  public Long getOidRegion() {
    return oidRegion;
  }

  public void setOidRegion(Long newOidRegion) {
    oidRegion = newOidRegion;
  }

  public Long getOidSeccion() {
    return oidSeccion;
  }

  public void setOidSeccion(Long newOidSeccion) {
    oidSeccion = newOidSeccion;
  }

  public Long getOidTerritorio() {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long newOidTerritorio) {
    oidTerritorio = newOidTerritorio;
  }

  public Long getOidZona() {
    return oidZona;
  }

  public void setOidZona(Long newOidZona) {
    oidZona = newOidZona;
  }

  public Long getOidMensaje() {
    return oidMensaje;
  }

  public void setOidMensaje(Long newOidMensaje) {
    oidMensaje = newOidMensaje;
  }

  public Long getOidUnidadAdministrativa() {
    return oidUnidadAdministrativa;
  }

  public void setOidUnidadAdministrativa(Long newOidUnidadAdministrativa) {
    oidUnidadAdministrativa = newOidUnidadAdministrativa;
  }

  public String getNivel() {
    return nivel;
  }

  public void setNivel(String newNivel) {
    nivel = newNivel;
  }
}