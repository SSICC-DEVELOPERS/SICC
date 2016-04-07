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

public class DTOVersion extends DTOBelcorp {
  private Long oid;
  private Long oidConcursoOrigen;
  private Integer versionNueva;
  private String numeroConcurso;
  private Long oidConcurso;
  private Long oidEstado;
  private Long oidPeriodoInicioVigor;
  private Boolean indAutoriza;
  private Integer indBorrado;

  public DTOVersion() { }
  
  public Integer getIndBorrado()  {
    return this.indBorrado;
  }
  
  public void setIndBorrado(Integer indBorrado) {
    this.indBorrado = indBorrado;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidConcursoOrigen()
  {
    return oidConcursoOrigen;
  }

  public void setOidConcursoOrigen(Long oidConcursoOrigen)
  {
    this.oidConcursoOrigen = oidConcursoOrigen;
  }

  public Integer getVersionNueva()
  {
    return versionNueva;
  }

  public void setVersionNueva(Integer versionNueva)
  {
    this.versionNueva = versionNueva;
  }

  public String getNumeroConcurso()
  {
    return numeroConcurso;
  }

  public void setNumeroConcurso(String numeroConcurso)
  {
    this.numeroConcurso = numeroConcurso;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidEstado()
  {
    return oidEstado;
  }

  public void setOidEstado(Long oidEstado)
  {
    this.oidEstado = oidEstado;
  }

  public Long getOidPeriodoInicioVigor()
  {
    return oidPeriodoInicioVigor;
  }

  public void setOidPeriodoInicioVigor(Long oidPeriodoInicioVigor)
  {
    this.oidPeriodoInicioVigor = oidPeriodoInicioVigor;
  }

    /* Agregado por ssantana, 10/05/2006, Versionado */
    public Boolean getIndAutoriza()
    {
        return indAutoriza;
    }

    public void setIndAutoriza(Boolean indAutoriza)
    {
        this.indAutoriza = indAutoriza;
    }
    /* Fin agregado por ssantana, 10/05/2006, Versionado */    
}