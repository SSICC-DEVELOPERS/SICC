package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;
import java.sql.Date;

public class DTOHistoricoMensajeLote extends DTOSiccPaginacion {

  private Long oid;
  private Date fechaEntrega;
  private String observaciones;
  private Date fechaEmision;
  private BigDecimal importe;
  private Long etapaDeuda;
  private Long oidBuzonMensaje;
  private Long periodo;
  private Long sociedad;
  private Long usuarioCobranza;
  private Long codLote;
  

  public DTOHistoricoMensajeLote() {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Date getFechaEntrega()
  {
    return fechaEntrega;
  }

  public void setFechaEntrega(Date fechaEntrega)
  {
    this.fechaEntrega = fechaEntrega;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public Date getFechaEmision()
  {
    return fechaEmision;
  }

  public void setFechaEmision(Date fechaEmision)
  {
    this.fechaEmision = fechaEmision;
  }

  public BigDecimal getImporte()
  {
    return importe;
  }

  public void setImporte(BigDecimal importe)
  {
    this.importe = importe;
  }

  public Long getEtapaDeuda()
  {
    return etapaDeuda;
  }

  public void setEtapaDeuda(Long etapaDeuda)
  {
    this.etapaDeuda = etapaDeuda;
  }

  public Long getOidBuzonMensaje()
  {
    return oidBuzonMensaje;
  }

  public void setOidBuzonMensaje(Long oidBuzonMensaje)
  {
    this.oidBuzonMensaje = oidBuzonMensaje;
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Long getSociedad()
  {
    return sociedad;
  }

  public void setSociedad(Long sociedad)
  {
    this.sociedad = sociedad;
  }

  public Long getUsuarioCobranza()
  {
    return usuarioCobranza;
  }

  public void setUsuarioCobranza(Long usuarioCobranza)
  {
    this.usuarioCobranza = usuarioCobranza;
  }

  public Long getCodLote()
  {
    return codLote;
  }

  public void setCodLote(Long codLote)
  {
    this.codLote = codLote;
  }

 
  
}