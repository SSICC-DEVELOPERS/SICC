package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOParametrosGerentes extends DTOBelcorp 
{
  private Long oidParamGerentes;
  private Boolean indRecomendacionEfectiva;
  private Integer numeroPeriodosEvaluar;
  private Integer numeroMinimoPedidos;
  private Integer numeroMinimoPedidosRecomendada;
  private Long oidFormaCalculo;
  private Long oidPeriodoInicialEvaluacion;
  private Long oidTipoVenta;
  private Long oidBaseCalculo;

  public DTOParametrosGerentes()
  {
  }

  public Long getOidParamGerentes()
  {
    return oidParamGerentes;
  }

  public void setOidParamGerentes(Long oidParamGerentes)
  {
    this.oidParamGerentes = oidParamGerentes;
  }

  public Boolean getIndRecomendacionEfectiva()
  {
    return indRecomendacionEfectiva;
  }

  public void setIndRecomendacionEfectiva(Boolean indRecomendacionEfectiva)
  {
    this.indRecomendacionEfectiva = indRecomendacionEfectiva;
  }

  public Integer getNumeroPeriodosEvaluar()
  {
    return numeroPeriodosEvaluar;
  }

  public void setNumeroPeriodosEvaluar(Integer numeroPeriodosEvaluar)
  {
    this.numeroPeriodosEvaluar = numeroPeriodosEvaluar;
  }

  public Integer getNumeroMinimoPedidos()
  {
    return numeroMinimoPedidos;
  }

  public void setNumeroMinimoPedidos(Integer numeroMinimoPedidos)
  {
    this.numeroMinimoPedidos = numeroMinimoPedidos;
  }

  public Integer getNumeroMinimoPedidosRecomendada()
  {
    return numeroMinimoPedidosRecomendada;
  }

  public void setNumeroMinimoPedidosRecomendada(Integer numeroMinimoPedidosRecomendada)
  {
    this.numeroMinimoPedidosRecomendada = numeroMinimoPedidosRecomendada;
  }

  public Long getOidFormaCalculo()
  {
    return oidFormaCalculo;
  }

  public void setOidFormaCalculo(Long oidFormaCalculo)
  {
    this.oidFormaCalculo = oidFormaCalculo;
  }

  public Long getOidPeriodoInicialEvaluacion()
  {
    return oidPeriodoInicialEvaluacion;
  }

  public void setOidPeriodoInicialEvaluacion(Long oidPeriodoInicialEvaluacion)
  {
    this.oidPeriodoInicialEvaluacion = oidPeriodoInicialEvaluacion;
  }

  public Long getOidTipoVenta()
  {
    return oidTipoVenta;
  }

  public void setOidTipoVenta(Long oidTipoVenta)
  {
    this.oidTipoVenta = oidTipoVenta;
  }

  public Long getOidBaseCalculo()
  {
    return oidBaseCalculo;
  }

  public void setOidBaseCalculo(Long oidBaseCalculo)
  {
    this.oidBaseCalculo = oidBaseCalculo;
  }
}