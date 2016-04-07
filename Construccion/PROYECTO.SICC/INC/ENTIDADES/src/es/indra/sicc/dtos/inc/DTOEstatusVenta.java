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

public class DTOEstatusVenta extends DTOBelcorp
{
  private Long oidEstatusVentaMae;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;

  private Long oidEstatus;
  private String desEstatus;
  private String desPeriodoDesde;
  private String desPeriodoHasta;

  public DTOEstatusVenta()
  {
  }

  public Long getOidEstatusVentaMae()
  {
    return oidEstatusVentaMae;
  }

  public void setOidEstatusVentaMae(Long oidEstatusVentaMae)
  {
    this.oidEstatusVentaMae = oidEstatusVentaMae;
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
  
  public Long getOidEstatus(){
    return oidEstatus;
  }
  
  public void setOidEstatus(Long oidEstatus){
    this.oidEstatus = oidEstatus;
  }
  
  public String getDesEstatus(){
    return this.desEstatus;
  }
  
  public void setDesEstatus(String desEstatus){
    this.desEstatus = desEstatus;
  }
  
  public String getDesPeriodoDesde(){
    return this.desPeriodoDesde;
  }
  
  public void setDesPeriodoDesde(String desPeriodoDesde){
    this.desPeriodoDesde = desPeriodoDesde;
  }
  
  public String getDesPeriodoHasta(){
    return this.desPeriodoHasta;
  }
  
  public void setDesPeriodoHasta(String desPeriodoHasta){
    this.desPeriodoHasta = desPeriodoHasta;
  }
  
}