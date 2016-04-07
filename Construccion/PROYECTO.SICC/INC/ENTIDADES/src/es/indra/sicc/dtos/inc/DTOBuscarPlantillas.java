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

public class DTOBuscarPlantillas extends DTOSiccPaginacion
{
  private Integer nroPlantilla;
  private String nombrePlantilla;

  public DTOBuscarPlantillas()
  {
  }

  public Integer getNroPlantilla()
  {
    return nroPlantilla;
  }

  public void setNroPlantilla(Integer nroPlantilla)
  {
    this.nroPlantilla = nroPlantilla;
  }

  public String getNombrePlantilla()
  {
    return nombrePlantilla;
  }

  public void setNombrePlantilla(String nombrePlantilla)
  {
    this.nombrePlantilla = nombrePlantilla;
  }
}