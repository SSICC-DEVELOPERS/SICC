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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class DTOBusquedaFaltantes extends DTOSiccPaginacion 
{

  private Integer situacionRegistro;
  private Long oidConcurso;
  private String codigosProductos;
  private String regiones;
  private String zonas;

  public DTOBusquedaFaltantes()
  {
  }

  public Integer getSituacionRegistro()
  {
    return situacionRegistro;
  }

  public void setSituacionRegistro(Integer situacionRegistro)
  {
    this.situacionRegistro = situacionRegistro;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public String getCodigosProductos()
  {
    return codigosProductos;
  }

/**
  * Modificado: 23/05/2005
  * Autor: Carlos Leal
  *  
  */
  public void setCodigosProductos(String codigosProductos)
  {
    this.codigosProductos = codigosProductos;    
  }

  public String getRegiones(){
    return regiones;
  }
/**
  * Modificado: 23/05/2005
  * Autor: Carlos Leal
  *  
  */
  public void setRegiones(String regiones)
  {
    this.regiones = regiones;
    
  }

  public String getZonas()
  {
    return zonas;
  }

/**
  * Modificado: 23/05/2005
  * Autor: Carlos Leal
  *  
  */
  public void setZonas(String zonas)
  {
    this.zonas =zonas;    
  }
}