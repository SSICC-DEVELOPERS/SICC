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

public class DTOProductoSustitutivo extends DTOBelcorp 
{
  private Long oidProducto;
  private String codSap;
  private String codigoVentaFicticio;
  private Long cantidad;

  public DTOProductoSustitutivo()
  {
  }

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public String getCodSap()
  {
    return codSap;
  }

  public void setCodSap(String codSap)
  {
    this.codSap = codSap;
  }

  public String getCodigoVentaFicticio()
  {
    return codigoVentaFicticio;
  }

  public void setCodigoVentaFicticio(String codigoVentaFicticio)
  {
    this.codigoVentaFicticio = codigoVentaFicticio;
  }

  public Long getCantidad()
  {
    return cantidad;
  }

  public void setCantidad(Long cantidad)
  {
    this.cantidad = cantidad;
  }
  
  
}