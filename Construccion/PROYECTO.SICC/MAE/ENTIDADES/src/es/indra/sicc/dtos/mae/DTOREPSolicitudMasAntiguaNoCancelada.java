package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;
import java.math.BigDecimal;

public class DTOREPSolicitudMasAntiguaNoCancelada extends DTOAuditableSICC 
{
  private String tipoSolicitud;
  private Integer numeroSolicitud;
  private String sociedad;
  private Date fechaFacturacion;
  private Date fechaVencimiento;
  private String condicionPago;
  private BigDecimal montoPedido;
  private BigDecimal montoSaldo;

  public DTOREPSolicitudMasAntiguaNoCancelada()
  {
  }

  public String getTipoSolicitud()
  {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(String tipoSolicitud)
  {
    this.tipoSolicitud = tipoSolicitud;
  }

  public Integer getNumeroSolicitud()
  {
    return numeroSolicitud;
  }

  public void setNumeroSolicitud(Integer numeroSolicitud)
  {
    this.numeroSolicitud = numeroSolicitud;
  }

  public String getSociedad()
  {
    return sociedad;
  }

  public void setSociedad(String sociedad)
  {
    this.sociedad = sociedad;
  }

  public Date getFechaFacturacion()
  {
    return fechaFacturacion;
  }

  public void setFechaFacturacion(Date fechaFacturacion)
  {
    this.fechaFacturacion = fechaFacturacion;
  }

  public Date getFechaVencimiento()
  {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(Date fechaVencimiento)
  {
    this.fechaVencimiento = fechaVencimiento;
  }

  public String getCondicionPago()
  {
    return condicionPago;
  }

  public void setCondicionPago(String condicionPago)
  {
    this.condicionPago = condicionPago;
  }

  public BigDecimal getMontoPedido()
  {
    return montoPedido;
  }

  public void setMontoPedido(BigDecimal montoPedido)
  {
    this.montoPedido = montoPedido;
  }

  public BigDecimal getMontoSaldo()
  {
    return montoSaldo;
  }

  public void setMontoSaldo(BigDecimal montoSaldo)
  {
    this.montoSaldo = montoSaldo;
  }
}