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

public class DTONuevaVersion extends DTOBelcorp 
{
  private Long oidVersion;
  private Long oidConcurso;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Long oidRequisitoPremiacion;
  private Boolean indPagoTiempo;
  private Integer diasGracia;
  private Long oidPeriodoDesdeReq;
  private Long oidPeriodoHastaReq;
  private Long oidPeriodoPuestaMarcha;
    private String codPeriodoHasta;

  public DTONuevaVersion()
  {
  }

  public Long getOidVersion()
  {
    return oidVersion;
  }

  public void setOidVersion(Long oidVersion)
  {
    this.oidVersion = oidVersion;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
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

  public Long getOidRequisitoPremiacion()
  {
    return oidRequisitoPremiacion;
  }

  public void setOidRequisitoPremiacion(Long oidRequisitoPremiacion)
  {
    this.oidRequisitoPremiacion = oidRequisitoPremiacion;
  }

  public Boolean getIndPagoTiempo()
  {
    return indPagoTiempo;
  }

  public void setIndPagoTiempo(Boolean indPagoTiempo)
  {
    this.indPagoTiempo = indPagoTiempo;
  }

  public Integer getDiasGracia()
  {
    return diasGracia;
  }

  public void setDiasGracia(Integer diasGracia)
  {
    this.diasGracia = diasGracia;
  }

  public Long getOidPeriodoDesdeReq()
  {
    return oidPeriodoDesdeReq;
  }

  public void setOidPeriodoDesdeReq(Long oidPeriodoDesdeReq)
  {
    this.oidPeriodoDesdeReq = oidPeriodoDesdeReq;
  }

  public Long getOidPeriodoHastaReq()
  {
    return oidPeriodoHastaReq;
  }

  public void setOidPeriodoHastaReq(Long oidPeriodoHastaReq)
  {
    this.oidPeriodoHastaReq = oidPeriodoHastaReq;
  }

  public Long getOidPeriodoPuestaMarcha()
  {
    return oidPeriodoPuestaMarcha;
  }

  public void setOidPeriodoPuestaMarcha(Long oidPeriodoPuestaMarcha)
  {
    this.oidPeriodoPuestaMarcha = oidPeriodoPuestaMarcha;
  }

 /* ssantana, 10/05/2006, Versionado */
 public String getCodPeriodoHasta()
 {
    return codPeriodoHasta;
 }

 public void setCodPeriodoHasta(String codPeriodoHasta)
 {
    this.codPeriodoHasta = codPeriodoHasta;
 }
}