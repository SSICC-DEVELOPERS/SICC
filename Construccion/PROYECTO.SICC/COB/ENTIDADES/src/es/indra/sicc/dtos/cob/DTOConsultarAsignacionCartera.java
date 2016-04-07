package es.indra.sicc.dtos.cob;
//import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

public class DTOConsultarAsignacionCartera extends DTOSiccPaginacion
{
  Long oidEtapa;
  Long oidPeriodo;
  Long oidMarca;
  Long oidCanal;
  Date fechaAsignacion;

  public DTOConsultarAsignacionCartera()
  {
  }

  public Long getOidEtapa()
  {
    return oidEtapa;
  }

  public void setOidEtapa(Long oidEtapa)
  {
    this.oidEtapa = oidEtapa;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Date getFechaAsignacion()
  {
    return fechaAsignacion;
  }

  public void setFechaAsignacion(Date fechaAsignacion)
  {
    this.fechaAsignacion = fechaAsignacion;
  }
}