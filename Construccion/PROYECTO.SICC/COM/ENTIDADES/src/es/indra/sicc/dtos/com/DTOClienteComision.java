/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.com;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOClienteComision extends DTOBelcorp
{
  private Long oid;
  private String codigoEmpleado;
  private BigDecimal topeMaximo;
  private BigDecimal topeMinimo;
  
  public DTOClienteComision()
  {
  }

  public String getCodigoEmpleado()
  {
    return codigoEmpleado;
  }

  public void setCodigoEmpleado(String codigoEmpleado)
  {
    this.codigoEmpleado = codigoEmpleado;
  }

  public BigDecimal getTopeMaximo()
  {
    return topeMaximo;
  }

  public void setTopeMaximo(BigDecimal topeMaximo)
  {
    this.topeMaximo = topeMaximo;
  }

  public BigDecimal getTopeMinimo()
  {
    return topeMinimo;
  }

  public void setTopeMinimo(BigDecimal topeMinimo)
  {
    this.topeMinimo = topeMinimo;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }
}