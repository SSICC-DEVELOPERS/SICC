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

public class DTOProductoDescuento extends DTOBelcorp
{
  private Long oidProducto;
  private Long oidUnidadNegocio;
  private Long oidNegocio;
  private Long oidSuperGenerico;
  private Long oidGenerico;
  private Long oidMarcaProducto;

  public DTOProductoDescuento()
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

  public Long getOidUnidadNegocio()
  {
    return oidUnidadNegocio;
  }

  public void setOidUnidadNegocio(Long oidUnidadNegocio)
  {
    this.oidUnidadNegocio = oidUnidadNegocio;
  }

  public Long getOidNegocio()
  {
    return oidNegocio;
  }

  public void setOidNegocio(Long oidNegocio)
  {
    this.oidNegocio = oidNegocio;
  }

  public Long getOidSuperGenerico()
  {
    return oidSuperGenerico;
  }

  public void setOidSuperGenerico(Long oidSuperGenerico)
  {
    this.oidSuperGenerico = oidSuperGenerico;
  }

  public Long getOidGenerico()
  {
    return oidGenerico;
  }

  public void setOidGenerico(Long oidGenerico)
  {
    this.oidGenerico = oidGenerico;
  }

  public Long getOidMarcaProducto()
  {
    return oidMarcaProducto;
  }

  public void setOidMarcaProducto(Long oidMarcaProducto)
  {
    this.oidMarcaProducto = oidMarcaProducto;
  }
}