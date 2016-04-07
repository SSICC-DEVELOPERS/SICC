/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * Autor: Damasia Maneiro
 * Fecha: 10/06/2005
 */
 
package es.indra.sicc.dtos.inc;

import java.math.BigDecimal;

public class DTOResultadoConcursoVariablesVenta 
{
  private Long oidConcurso;
  private BigDecimal totalVentaNetaEstadisticable;
  private Long totalUnidadesVendidas;
  private BigDecimal precioPromedioUnitario;
  private Integer numeroPedidos;
  private BigDecimal promedioVentaPedidos;
  private Double promedioUnidadesPedidos;
  private Double porcentajeActividad;
  private Double promedioOrdenesPedidos;

  public DTOResultadoConcursoVariablesVenta()
  {
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public BigDecimal getTotalVentaNetaEstadisticable()
  {
    return totalVentaNetaEstadisticable;
  }

  public void setTotalVentaNetaEstadisticable(BigDecimal totalVentaNetaEstadisticable)
  {
    this.totalVentaNetaEstadisticable = totalVentaNetaEstadisticable;
  }

  public Long getTotalUnidadesVendidas()
  {
    return totalUnidadesVendidas;
  }

  public void setTotalUnidadesVendidas(Long totalUnidadesVendidas)
  {
    this.totalUnidadesVendidas = totalUnidadesVendidas;
  }

  public BigDecimal getPrecioPromedioUnitario()
  {
    return precioPromedioUnitario;
  }

  public void setPrecioPromedioUnitario(BigDecimal precioPromedioUnitario)
  {
    this.precioPromedioUnitario = precioPromedioUnitario;
  }

  public Integer getNumeroPedidos()
  {
    return numeroPedidos;
  }

  public void setNumeroPedidos(Integer numeroPedidos)
  {
    this.numeroPedidos = numeroPedidos;
  }

  public BigDecimal getPromedioVentaPedidos()
  {
    return promedioVentaPedidos;
  }

  public void setPromedioVentaPedidos(BigDecimal promedioVentaPedidos)
  {
    this.promedioVentaPedidos = promedioVentaPedidos;
  }

  public Double getPromedioUnidadesPedidos()
  {
    return promedioUnidadesPedidos;
  }

  public void setPromedioUnidadesPedidos(Double promedioUnidadesPedidos)
  {
    this.promedioUnidadesPedidos = promedioUnidadesPedidos;
  }

  public Double getPorcentajeActividad()
  {
    return porcentajeActividad;
  }

  public void setPorcentajeActividad(Double porcentajeActividad)
  {
    this.porcentajeActividad = porcentajeActividad;
  }

  public Double getPromedioOrdenesPedidos()
  {
    return promedioOrdenesPedidos;
  }

  public void setPromedioOrdenesPedidos(Double promedioOrdenesPedidos)
  {
    this.promedioOrdenesPedidos = promedioOrdenesPedidos;
  }
}