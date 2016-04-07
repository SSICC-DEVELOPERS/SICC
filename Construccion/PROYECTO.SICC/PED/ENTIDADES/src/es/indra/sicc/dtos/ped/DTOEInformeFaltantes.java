package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTOEInformeFaltantes extends DTOAuditableSICC  {

  private int operacion;
  private Date fechaInicio;
  private Date fechaFin;
  private Long oidLoteReporteFaltantes;

  public DTOEInformeFaltantes() {
  }

  public int getOperacion() {
    return operacion;
  }

  public void setOperacion(int newOperacion) {
    operacion = newOperacion;
  }

  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date newFechaInicio) {
    fechaInicio = newFechaInicio;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date newFechaFin) {
    fechaFin = newFechaFin;
  }

  public Long getOidLoteReporteFaltantes()
  {
    return oidLoteReporteFaltantes;
  }

  public void setOidLoteReporteFaltantes(Long oidLoteReporteFaltantes)
  {
    this.oidLoteReporteFaltantes = oidLoteReporteFaltantes;
  }

  
}