package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOParametrosConsultoras extends DTOBelcorp 
{
  private Long oidParamConsultoras;
  private BigDecimal montoMinimoPedido;
  private Integer unidadesMinimasPedido;
  private Boolean indReingresosPierdenPuntaje;
  private Long oidBaseCalculo;
  private Boolean indRecomendacionEfectiva;
  private Long oidEfectividad;
  private Long oidPeriodoInicialEvaluacion;
  private Integer nroPeriodosEvaluar;
  private Integer nroMinimoPedidos;
  private Integer nroMinimoPedidosRecomendada;
  private Long oidTipoVenta;
  // vbongiov -- 17/03/2008 -- Cambio RI 20080535
  private Boolean indPremioCampEfect;
  // vbongiov -- Cambio 20080580 -- 13/8/2008
  private Boolean indGenerarPuntajeARecomendadas;
  private Long oidConcursoPuntajeRecomendada;

  public Long getOidParamConsultoras()
  {
    return oidParamConsultoras;
  }

  public void setOidParamConsultoras(Long oidParamConsultoras)
  {
    this.oidParamConsultoras = oidParamConsultoras;
  }

  public BigDecimal getMontoMinimoPedido()
  {
    return montoMinimoPedido;
  }

  public void setMontoMinimoPedido(BigDecimal montoMinimoPedido)
  {
    this.montoMinimoPedido = montoMinimoPedido;
  }

  public Integer getUnidadesMinimasPedido()
  {
    return unidadesMinimasPedido;
  }

  public void setUnidadesMinimasPedido(Integer unidadesMinimasPedido)
  {
    this.unidadesMinimasPedido = unidadesMinimasPedido;
  }

  public Boolean getIndReingresosPierdenPuntaje()
  {
    return indReingresosPierdenPuntaje;
  }

  public void setIndReingresosPierdenPuntaje(Boolean indReingresosPierdenPuntaje)
  {
    this.indReingresosPierdenPuntaje = indReingresosPierdenPuntaje;
  }

  public Long getOidBaseCalculo()
  {
    return oidBaseCalculo;
  }

  public void setOidBaseCalculo(Long oidBaseCalculo)
  {
    this.oidBaseCalculo = oidBaseCalculo;
  }

  public Boolean getIndRecomendacionEfectiva()
  {
    return indRecomendacionEfectiva;
  }

  public void setIndRecomendacionEfectiva(Boolean indRecomendacionEfectiva)
  {
    this.indRecomendacionEfectiva = indRecomendacionEfectiva;
  }

  public Long getOidEfectividad()
  {
    return oidEfectividad;
  }

  public void setOidEfectividad(Long oidEfectividad)
  {
    this.oidEfectividad = oidEfectividad;
  }

  public Long getOidPeriodoInicialEvaluacion()
  {
    return oidPeriodoInicialEvaluacion;
  }

  public void setOidPeriodoInicialEvaluacion(Long oidPeriodoInicialEvaluacion)
  {
    this.oidPeriodoInicialEvaluacion = oidPeriodoInicialEvaluacion;
  }

  public Integer getNroPeriodosEvaluar()
  {
    return nroPeriodosEvaluar;
  }

  public void setNroPeriodosEvaluar(Integer nroPeriodosEvaluar)
  {
    this.nroPeriodosEvaluar = nroPeriodosEvaluar;
  }

  public Integer getNroMinimoPedidos()
  {
    return nroMinimoPedidos;
  }

  public void setNroMinimoPedidos(Integer nroMinimoPedidos)
  {
    this.nroMinimoPedidos = nroMinimoPedidos;
  }

  public Integer getNroMinimoPedidosRecomendada()
  {
    return nroMinimoPedidosRecomendada;
  }

  public void setNroMinimoPedidosRecomendada(Integer nroMinimoPedidosRecomendada)
  {
    this.nroMinimoPedidosRecomendada = nroMinimoPedidosRecomendada;
  }

  public Long getOidTipoVenta()
  {
    return oidTipoVenta;
  }

  public void setOidTipoVenta(Long oidTipoVenta)
  {
    this.oidTipoVenta = oidTipoVenta;
  }

  public Boolean getIndPremioCampEfect() {
    return indPremioCampEfect;
  }

  public void setIndPremioCampEfect(Boolean indPremioCampEfect) {
    this.indPremioCampEfect = indPremioCampEfect;
  }
  
    public Boolean getIndGenerarPuntajeARecomendadas()
    {
        return indGenerarPuntajeARecomendadas;
    }
    
    public void setIndGenerarPuntajeARecomendadas(Boolean indGenerarPuntajeARecomendadas)
    {
        this.indGenerarPuntajeARecomendadas = indGenerarPuntajeARecomendadas;
    }
    
    public Long getOidConcursoPuntajeRecomendada()
    {
        return oidConcursoPuntajeRecomendada;
    }
    
    public void setOidConcursoPuntajeRecomendada(Long oidConcursoPuntajeRecomendada)
    {
        this.oidConcursoPuntajeRecomendada = oidConcursoPuntajeRecomendada;
    }
}
