package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOMultinivel extends DTOBelcorp {
  private Long oid;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Integer periodosParaCalculo;
  private Integer periodosSobreCalculo;
  private Integer numeroMinimoRecomendadas;
  private BigDecimal montoMinimoRed;
  private Integer pedidosMinimosRed;
  private Integer unidadesMinimasRed;
  private BigDecimal montoMinimoMadre;  
  private Integer pedidosMinimosMadre;
  private Integer unidadesMinimasMadre;
  private Integer pedidosMinimosHijas;
  private BigDecimal montoMinimoPedidoPorHijas;
  private Integer unidadesMinimasHijas;
  private Long oidCalculoPremio;
  private BigDecimal porcentajeSobreVenta;
  private BigDecimal porcentajeSobreCobranza;
  private Boolean actividad;
  private BigDecimal montoMinimoPedidoHijas;
  private Integer unidadesMinimasPedidoHijas;
  private Boolean pagoTiempo;
  private Long oidPeriodoATiempoDesde;
  private Long oidPeriodoATiempoHasta;
  private Integer diasGracia;

  public DTOMultinivel()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidPeriodoDesde()
  {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long oidPeriodoDesde)
  {
    this.oidPeriodoDesde = oidPeriodoDesde;
  }

  public Long getOidPeriodoHasta()
  {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long oidPeriodoHasta)
  {
    this.oidPeriodoHasta = oidPeriodoHasta;
  }

  public Integer getPeriodosParaCalculo()
  {
    return periodosParaCalculo;
  }

  public void setPeriodosParaCalculo(Integer periodosParaCalculo)
  {
    this.periodosParaCalculo = periodosParaCalculo;
  }

  public Integer getPeriodosSobreCalculo()
  {
    return periodosSobreCalculo;
  }

  public void setPeriodosSobreCalculo(Integer periodosSobreCalculo)
  {
    this.periodosSobreCalculo = periodosSobreCalculo;
  }

  public Integer getNumeroMinimoRecomendadas()
  {
    return numeroMinimoRecomendadas;
  }

  public void setNumeroMinimoRecomendadas(Integer numeroMinimoRecomendadas)
  {
    this.numeroMinimoRecomendadas = numeroMinimoRecomendadas;
  }

  public BigDecimal getMontoMinimoRed()
  {
    return montoMinimoRed;
  }

  public void setMontoMinimoRed(BigDecimal montoMinimoRed)
  {
    this.montoMinimoRed = montoMinimoRed;
  }

  public Integer getPedidosMinimosRed()
  {
    return pedidosMinimosRed;
  }

  public void setPedidosMinimosRed(Integer pedidosMinimosRed)
  {
    this.pedidosMinimosRed = pedidosMinimosRed;
  }

  public Integer getUnidadesMinimasRed()
  {
    return unidadesMinimasRed;
  }

  public void setUnidadesMinimasRed(Integer unidadesMinimasRed)
  {
    this.unidadesMinimasRed = unidadesMinimasRed;
  }

  public BigDecimal getMontoMinimoMadre()
  {
    return montoMinimoMadre;
  }

  public void setMontoMinimoMadre(BigDecimal montoMinimoMadre)
  {
    this.montoMinimoMadre = montoMinimoMadre;
  }

  public Integer getPedidosMinimosMadre()
  {
    return pedidosMinimosMadre;
  }

  public void setPedidosMinimosMadre(Integer pedidosMinimosMadre)
  {
    this.pedidosMinimosMadre = pedidosMinimosMadre;
  }

  public Integer getUnidadesMinimasMadre()
  {
    return unidadesMinimasMadre;
  }

  public void setUnidadesMinimasMadre(Integer unidadesMinimasMadre)
  {
    this.unidadesMinimasMadre = unidadesMinimasMadre;
  }

  public Integer getPedidosMinimosHijas()
  {
    return pedidosMinimosHijas;
  }

  public void setPedidosMinimosHijas(Integer pedidosMinimosHijas)
  {
    this.pedidosMinimosHijas = pedidosMinimosHijas;
  }

  public BigDecimal getMontoMinimoPedidoPorHijas()
  {
    return montoMinimoPedidoPorHijas;
  }

  public void setMontoMinimoPedidoPorHijas(BigDecimal montoMinimoPedidoPorHijas)
  {
    this.montoMinimoPedidoPorHijas = montoMinimoPedidoPorHijas;
  }

  public Integer getUnidadesMinimasHijas()
  {
    return unidadesMinimasHijas;
  }

  public void setUnidadesMinimasHijas(Integer unidadesMinimasHijas)
  {
    this.unidadesMinimasHijas = unidadesMinimasHijas;
  }

  public Long getOidCalculoPremio()
  {
    return oidCalculoPremio;
  }

  public void setOidCalculoPremio(Long oidCalculoPremio)
  {
    this.oidCalculoPremio = oidCalculoPremio;
  }

  public BigDecimal getPorcentajeSobreVenta()
  {
    return porcentajeSobreVenta;
  }

  public void setPorcentajeSobreVenta(BigDecimal porcentajeSobreVenta)
  {
    this.porcentajeSobreVenta = porcentajeSobreVenta;
  }

  public BigDecimal getPorcentajeSobreCobranza()
  {
    return porcentajeSobreCobranza;
  }

  public void setPorcentajeSobreCobranza(BigDecimal porcentajeSobreCobranza)
  {
    this.porcentajeSobreCobranza = porcentajeSobreCobranza;
  }

  public Boolean getActividad()
  {
    return actividad;
  }

  public void setActividad(Boolean actividad)
  {
    this.actividad = actividad;
  }

  public BigDecimal getMontoMinimoPedidoHijas()
  {
    return montoMinimoPedidoHijas;
  }

  public void setMontoMinimoPedidoHijas(BigDecimal montoMinimoPedidoHijas)
  {
    this.montoMinimoPedidoHijas = montoMinimoPedidoHijas;
  }

  public Integer getUnidadesMinimasPedidoHijas()
  {
    return unidadesMinimasPedidoHijas;
  }

  public void setUnidadesMinimasPedidoHijas(Integer unidadesMinimasPedidoHijas)
  {
    this.unidadesMinimasPedidoHijas = unidadesMinimasPedidoHijas;
  }

  public Boolean getPagoTiempo()
  {
    return pagoTiempo;
  }

  public void setPagoTiempo(Boolean pagoTiempo)
  {
    this.pagoTiempo = pagoTiempo;
  }

  public Long getOidPeriodoATiempoDesde()
  {
    return oidPeriodoATiempoDesde;
  }

  public void setOidPeriodoATiempoDesde(Long oidPeriodoATiempoDesde)
  {
    this.oidPeriodoATiempoDesde = oidPeriodoATiempoDesde;
  }

  public Long getOidPeriodoATiempoHasta()
  {
    return oidPeriodoATiempoHasta;
  }

  public void setOidPeriodoATiempoHasta(Long oidPeriodoATiempoHasta)
  {
    this.oidPeriodoATiempoHasta = oidPeriodoATiempoHasta;
  }

  public Integer getDiasGracia()
  {
    return diasGracia;
  }

  public void setDiasGracia(Integer diasGracia)
  {
    this.diasGracia = diasGracia;
  }
}