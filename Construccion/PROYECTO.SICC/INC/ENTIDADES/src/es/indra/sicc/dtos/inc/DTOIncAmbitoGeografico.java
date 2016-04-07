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

public class DTOIncAmbitoGeografico extends DTOBelcorp
{
  private Long oidSubgerencia;
  private Long oidRegion;
  private Long oidZona;
  private Long oidSeccion;
  private Long oidTerritorio;

  private Long oidAmbitoGeografico;
  private String desSubgerencia;
  private String desRegion;
  private String desZona;
  private String desSeccion;
  private String desTerritorio;


  public DTOIncAmbitoGeografico()
  {
  }

  public Long getOidSubgerencia()
  {
    return oidSubgerencia;
  }

  public void setOidSubgerencia(Long oidSubgerencia)
  {
    this.oidSubgerencia = oidSubgerencia;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }
  
  public Long getOidAmbitoGeografico(){
    return oidAmbitoGeografico;
  }

  public void setOidAmbitoGeografico(Long oidAmbitoGeografico){
    this.oidAmbitoGeografico = oidAmbitoGeografico;
  }

  public String getDesSubgerencia(){
    return this.desSubgerencia;
  }
  
  public void setDesSubgerencia(String desSubgerencia){
    this.desSubgerencia = desSubgerencia;
  }
  
  public String getDesRegion(){
    return desRegion;
  }
  
  public void setDesRegion(String desRegion){
    this.desRegion = desRegion;
  }

  public String getDesZona(){
    return this.desZona;
  }
  
  public void setDesZona(String desZona){
    this.desZona = desZona;
  }
  
  public String getDesSeccion(){
    return this.desSeccion;
  }
  
  public void setDesSeccion(String desSeccion){
    this.desSeccion = desSeccion;
  }

  public String getDesTerritorio(){
    return this.desTerritorio;
  }

  public void setDesTerritorio(String desTerritorio){
    this.desTerritorio = desTerritorio;
  }
  
}