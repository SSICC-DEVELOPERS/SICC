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
 */

package es.indra.sicc.dtos.cra;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;
import es.indra.sicc.cra.util.GrupoZonaActividad;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             12/11/2003
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor             Marcelo Jorge Maidana
 */

public class DTOFechaNueva extends DTOAuditableSICC{

    private Integer diasNuevo;
    private String codigoActividad;
    private Date fechaInicioPeriodo;
    private Integer duracionPeriodo;
    private GrupoZonaActividad grupoZona;
    private Long oidActividad;


  public DTOFechaNueva(){
    super();
  }

  public String getCodigoActividad()
  {
    return codigoActividad;
  }

  public void setCodigoActividad(String newCodigoActividad)
  {
    codigoActividad = newCodigoActividad;
  }

  public Integer getDiasNuevo()
  {
    return diasNuevo;
  }

  public void setDiasNuevo(Integer newDiasNuevo)
  {
    diasNuevo = newDiasNuevo;
  }

  public Integer getDuracionPeriodo()
  {
    return duracionPeriodo;
  }

  public void setDuracionPeriodo(Integer newDuracionPeriodo)
  {
    duracionPeriodo = newDuracionPeriodo;
  }

  public Date getFechaInicioPeriodo()
  {
    return fechaInicioPeriodo;
  }

  public void setFechaInicioPeriodo(Date newFechaInicioPeriodo)
  {
    fechaInicioPeriodo = newFechaInicioPeriodo;
  }

  public GrupoZonaActividad getGrupoZona()
  {
    return grupoZona;
  }

  public void setGrupoZona(GrupoZonaActividad newGrupoZona)
  {
    grupoZona = newGrupoZona;
  }

    public Long getOidActividad()
    {
        return oidActividad;
    }

    public void setOidActividad(Long newOidActividad)
    {
        oidActividad = newOidActividad;
    }

}

