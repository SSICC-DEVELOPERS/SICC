package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;


public class DTOInformeFaltantes extends DTOAuditableSICC  {
  private Long loteReporteFaltantes;
  private Date fechaEjecucion;
  private Date fechaAprobacion;
  private String usuarioAprobacion;
  private Long oid;
  private DTOCabeceraReporte[] cabecera;
  private Date fechaIni;
  private Date fechaFin;
//Incidencia 6445: Se agrego atributo periodo
  private Long periodo;
  
  public DTOInformeFaltantes() {
  }

  public Long getLoteReporteFaltantes() {
    return loteReporteFaltantes;
  }

  public void setLoteReporteFaltantes(Long newLoteReporteFaltantes) {
    loteReporteFaltantes = newLoteReporteFaltantes;
  }

  public Date getFechaEjecucion() {
    return fechaEjecucion;
  }

  public void setFechaEjecucion(Date newFechaEjecucion) {
    fechaEjecucion = newFechaEjecucion;
  }

  public Date getFechaAprobacion() {
    return fechaAprobacion;
  }

  public void setFechaAprobacion(Date newFechaAprobacion) {
    fechaAprobacion = newFechaAprobacion;
  }

  public String getUsuarioAprobacion() {
    return usuarioAprobacion;
  }

  public void setUsuarioAprobacion(String newUsuarioAprobacion) {
    usuarioAprobacion = newUsuarioAprobacion;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public DTOCabeceraReporte[] getCabecera() {
    return cabecera;
  }

  public void setCabecera(DTOCabeceraReporte[] newCabecera) {
    cabecera = newCabecera;
  }

  public Date getFechaIni() {
    return fechaIni;
  }

  public void setFechaIni(Date newFechaIni) {
    fechaIni = newFechaIni;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date newFechaFin) {
    fechaFin = newFechaFin;
  }

  public Long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo) {
    periodo = newPeriodo;
  }

}