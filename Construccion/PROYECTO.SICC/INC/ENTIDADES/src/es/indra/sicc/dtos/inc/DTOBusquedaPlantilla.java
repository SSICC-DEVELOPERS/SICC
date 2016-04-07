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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBusquedaPlantilla extends DTOSiccPaginacion
{
  public DTOBusquedaPlantilla()
  {
  }

  private Long numeroPlantilla;
  private String nombrePlantilla;
  private Long oidPais;
  private Long oidPaisPlantilla;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidAcceso;
  private Integer indBloqueado;
  
  public Long getOidPaisPlantilla() {
    return this.oidPaisPlantilla;    
  }
  
  public void setOidPaisPlantilla(Long newOidPaisPlantilla) {
    this.oidPaisPlantilla = newOidPaisPlantilla;
  }

  public String getNombrePlantilla()
  {
    return nombrePlantilla;
  }

  public void setNombrePlantilla(String nombrePlantilla)
  {
    this.nombrePlantilla = nombrePlantilla;
  }

  public Long getNumeroPlantilla()
  {
    return numeroPlantilla;
  }

  public void setNumeroPlantilla(Long numeroPlantilla)
  {
    this.numeroPlantilla = numeroPlantilla;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidPais()
  {
    return oidPais;
  }

  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }

  public Integer getIndBloqueado()
  {
    return indBloqueado;
  }

  public void setIndBloqueado(Integer indBloqueado)
  {
    this.indBloqueado = indBloqueado;
  }
 
}