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
 * Autor : Damasia Maneiro
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOClienteEgreso extends DTOBelcorp
{
  private Long oidCliente;
  private Double puntajeTotal;
  private Long oidConcurso;
  
  // BELC300023732 - gPineda - 12/11/2006
  private Double puntajeExigidoTotal;
  

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Double getPuntajeTotal()
  {
    return puntajeTotal;
  }

  public void setPuntajeTotal(Double puntajeTotal)
  {
    this.puntajeTotal = puntajeTotal;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }


  public void setPuntajeExigidoTotal(Double puntajeExigidoTotal)
  {
    this.puntajeExigidoTotal = puntajeExigidoTotal;
  }


  public Double getPuntajeExigidoTotal()
  {
    return puntajeExigidoTotal;
  }

}