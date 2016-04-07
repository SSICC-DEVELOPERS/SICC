package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOREPCredito extends DTOAuditableSICC 
{
  private String responsableCredito;
  private Long lineaCreditoActual;
  private Long lineaCreditoDisponible;
  private String periodoLineaCredito;
  private Long pedidoPromedioUltimaEvaluacion;
  private Long porcLineaCreditoActualConsumida;
  private String nivelRiesgo;
  private String periodoUltimaEvaluacion;
  private Integer nroPeriodosPedidoUltEval;

  public DTOREPCredito()
  {
  }

  public String getResponsableCredito()
  {
    return responsableCredito;
  }

  public void setResponsableCredito(String responsableCredito)
  {
    this.responsableCredito = responsableCredito;
  }

  public Long getLineaCreditoActual()
  {
    return lineaCreditoActual;
  }

  public void setLineaCreditoActual(Long lineaCreditoActual)
  {
    this.lineaCreditoActual = lineaCreditoActual;
  }

  public Long getLineaCreditoDisponible()
  {
    return lineaCreditoDisponible;
  }

  public void setLineaCreditoDisponible(Long lineaCreditoDisponible)
  {
    this.lineaCreditoDisponible = lineaCreditoDisponible;
  }

  public String getPeriodoLineaCredito()
  {
    return periodoLineaCredito;
  }

  public void setPeriodoLineaCredito(String periodoLineaCredito)
  {
    this.periodoLineaCredito = periodoLineaCredito;
  }

  public Long getPedidoPromedioUltimaEvaluacion()
  {
    return pedidoPromedioUltimaEvaluacion;
  }

  public void setPedidoPromedioUltimaEvaluacion(Long pedidoPromedioUltimaEvaluacion)
  {
    this.pedidoPromedioUltimaEvaluacion = pedidoPromedioUltimaEvaluacion;
  }

  public Long getPorcLineaCreditoActualConsumida()
  {
    return porcLineaCreditoActualConsumida;
  }

  public void setPorcLineaCreditoActualConsumida(Long porcLineaCreditoActualConsumida)
  {
    this.porcLineaCreditoActualConsumida = porcLineaCreditoActualConsumida;
  }

  public String getNivelRiesgo()
  {
    return nivelRiesgo;
  }

  public void setNivelRiesgo(String nivelRiesgo)
  {
    this.nivelRiesgo = nivelRiesgo;
  }

  public String getPeriodoUltimaEvaluacion()
  {
    return periodoUltimaEvaluacion;
  }

  public void setPeriodoUltimaEvaluacion(String periodoUltimaEvaluacion)
  {
    this.periodoUltimaEvaluacion = periodoUltimaEvaluacion;
  }

  public Integer getNroPeriodosPedidoUltEval()
  {
    return nroPeriodosPedidoUltEval;
  }

  public void setNroPeriodosPedidoUltEval(Integer nroPeriodosPedidoUltEval)
  {
    this.nroPeriodosPedidoUltEval = nroPeriodosPedidoUltEval;
  }
}