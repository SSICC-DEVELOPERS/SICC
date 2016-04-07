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

public class DTOGerenteConcurso 
{
  private Long oidGerente;
  private Long oidConcurso;

  public DTOGerenteConcurso()
  {
  }

  public Long getOidGerente()
  {
    return oidGerente;
  }

  public void setOidGerente(Long oidGerente)
  {
    this.oidGerente = oidGerente;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }
}