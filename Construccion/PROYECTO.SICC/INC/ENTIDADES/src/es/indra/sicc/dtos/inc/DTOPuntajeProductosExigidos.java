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
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

public class DTOPuntajeProductosExigidos extends DTOBelcorp
{
  private BigDecimal montoPedidos;
  private Long unidadesPedido;
  private Long puntosPedido;

  public DTOPuntajeProductosExigidos()
  {
  }

  public BigDecimal getMontoPedidos()
  {
    return montoPedidos;
  }

  public void setMontoPedidos(BigDecimal montoPedidos)
  {
    this.montoPedidos = montoPedidos;
  }

  public Long getUnidadesPedido()
  {
    return unidadesPedido;
  }

  public void setUnidadesPedido(Long unidadesPedido)
  {
    this.unidadesPedido = unidadesPedido;
  }

  public Long getPuntosPedido()
  {
    return puntosPedido;
  }

  public void setPuntosPedido(Long puntosPedido)
  {
    this.puntosPedido = puntosPedido;
  }
}