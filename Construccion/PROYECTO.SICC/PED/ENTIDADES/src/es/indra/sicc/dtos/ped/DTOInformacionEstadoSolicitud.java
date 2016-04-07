package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTOInformacionEstadoSolicitud extends DTOAuditableSICC {

    private Long oidEstadoSolicitud;
    private Long oidGrupoProcesos;
    private Date fechaFacturacion;
    private Date fechaPrevistaFacturacion;
    private String estadoCredito;
    private String grupoProcesos;
    private String procesoValidacion;
    private String estadoSolicitud;
    //Incidencia BELC300023759 pzerbino 2/8/2006
    private String descripcionEstado;


  public void setFechaFacturacion(Date fechaFacturacion)
  {
    this.fechaFacturacion = fechaFacturacion;
  }


  public Date getFechaFacturacion()
  {
    return fechaFacturacion;
  }


  public void setFechaPrevistaFacturacion(Date fechaPrevistaFacturacion)
  {
    this.fechaPrevistaFacturacion = fechaPrevistaFacturacion;
  }


  public Date getFechaPrevistaFacturacion()
  {
    return fechaPrevistaFacturacion;
  }


  public void setEstadoCredito(String estadoCredito)
  {
    this.estadoCredito = estadoCredito;
  }


  public String getEstadoCredito()
  {
    return estadoCredito;
  }


  public void setGrupoProcesos(String grupoProcesos)
  {
    this.grupoProcesos = grupoProcesos;
  }


  public String getGrupoProcesos()
  {
    return grupoProcesos;
  }


  public void setProcesoValidacion(String procesoValidacion)
  {
    this.procesoValidacion = procesoValidacion;
  }


  public String getProcesoValidacion()
  {
    return procesoValidacion;
  }


  public void setEstadoSolicitud(String estadoSolicitud)
  {
    this.estadoSolicitud = estadoSolicitud;
  }


  public String getEstadoSolicitud()
  {
    return estadoSolicitud;
  }


  public void setOidEstadoSolicitud(Long oidEstadoSolicitud)
  {
    this.oidEstadoSolicitud = oidEstadoSolicitud;
  }


  public Long getOidEstadoSolicitud()
  {
    return oidEstadoSolicitud;
  }


  public void setOidGrupoProcesos(Long oidGrupoProcesos)
  {
    this.oidGrupoProcesos = oidGrupoProcesos;
  }


  public Long getOidGrupoProcesos()
  {
    return oidGrupoProcesos;
  }
  
  
  public void setDescripcionEstado (String descripEstado){
    this.descripcionEstado = descripEstado;
  }
  
  public String getDescripcionEstado(){
    return descripcionEstado;
  }
  
  
}