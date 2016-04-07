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

public class DTOTipoProducto extends DTOBelcorp 
{
  private Long oid;
  private Integer indGrupoProducto;
  private Long oidPlantilla;

  public DTOTipoProducto()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Integer getIndGrupoProducto()
  {
    return indGrupoProducto;
  }

  public void setIndGrupoProducto(Integer indGrupoProducto)
  {
    this.indGrupoProducto = indGrupoProducto;
  }

  public Long getOidPlantilla()
  {
    return oidPlantilla;
  }

  public void setOidPlantilla(Long oidPlantilla)
  {
    this.oidPlantilla = oidPlantilla;
  }
}