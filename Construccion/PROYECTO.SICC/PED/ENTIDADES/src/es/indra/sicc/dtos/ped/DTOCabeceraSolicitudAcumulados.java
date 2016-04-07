package es.indra.sicc.dtos.ped;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOCabeceraSolicitudAcumulados extends DTOBelcorp  {
  private Long oidZona;
  private Date fechaProceso;
  private Long oidTipoSolicitusPais;
  private Long oidSubacceso;
  private Long valGP1;
  private Long oid;

  public DTOCabeceraSolicitudAcumulados() {
 }

  public Long getOidZona() {
    return oidZona;
  }

  public void setOidZona(Long oidZona) {
    this.oidZona = oidZona;
  }

  public Date getFechaProceso() {
    return fechaProceso;
  }

  public void setFechaProceso(Date fechaProceso) {
    this.fechaProceso = fechaProceso;
  }

  public Long getOidTipoSolicitusPais() {
    return oidTipoSolicitusPais;
  }

  public void setOidTipoSolicitusPais(Long oidTipoSolicitusPais) {
    this.oidTipoSolicitusPais = oidTipoSolicitusPais;
  }

  public Long getOidSubacceso() {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso) {
    this.oidSubacceso = oidSubacceso;
  }

  public Long getValGP1() {
    return valGP1;
  }

  public void setValGP1(Long valGP1) {
    this.valGP1 = valGP1;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }
}