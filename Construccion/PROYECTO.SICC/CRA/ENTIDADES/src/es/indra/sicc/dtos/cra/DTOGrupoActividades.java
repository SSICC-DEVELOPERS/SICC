/*
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

import java.util.Vector;
import java.sql.Date;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             13/11/2003
 * Observaciones:     Importado desde Version 2 y modificado segun requerimientos
 *                    generales de la Version 3
 * @version           1.0
 * @autor             Gaston Acevedo
 * */


public class DTOGrupoActividades extends DTOAuditableSICC {

	private Long oidActividad;
	private String codigoActividad;
	private String nombreActividad;
	private Boolean tipoActividad;
	private String tipoFacturacion;
	private Long oidActividadReferenciada;
    private Integer fechaMedia;
	private Date fechaFin;
	private Integer dias;
	private Vector actividadesFueraPeriodo;
  private Integer fecha;
  private Date fechaPrevista;
  private Boolean tipoDias;
    
	public DTOGrupoActividades() {
		super();
	}

  public Vector getActividadesFueraPeriodo()
  {
    return actividadesFueraPeriodo;
  }

  public void setActividadesFueraPeriodo(Vector newActividadesFueraPeriodo)
  {
    actividadesFueraPeriodo = newActividadesFueraPeriodo;
  }

  public String getCodigoActividad()
  {
    return codigoActividad;
  }

  public void setCodigoActividad(String newCodigoActividad)
  {
    codigoActividad = newCodigoActividad;
  }

  public Integer getDias()
  {
    return dias;
  }

  public void setDias(Integer newDias)
  {
    dias = newDias;
  }

  public Integer getFecha()
  {
    return fecha;
  }

  public void setFecha(Integer newFecha)
  {
    fecha = newFecha;
  }

  public Date getFechaFin()
  {
    return fechaFin;
  }

  public void setFechaFin(Date newFechaFin)
  {
    fechaFin = newFechaFin;
  }

  public Integer getFechaMedia()
  {
    return fechaMedia;
  }

  public void setFechaMedia(Integer newFechaMedia)
  {
    fechaMedia = newFechaMedia;
  }

  public String getNombreActividad()
  {
    return nombreActividad;
  }

  public void setNombreActividad(String newNombreActividad)
  {
    nombreActividad = newNombreActividad;
  }

  public Long getOidActividad()
  {
    return oidActividad;
  }

  public void setOidActividad(Long newOidActividad)
  {
    oidActividad = newOidActividad;
  }

  public Long getOidActividadReferenciada()
  {
    return oidActividadReferenciada;
  }

  public void setOidActividadReferenciada(Long newOidActividadReferenciada)
  {
    oidActividadReferenciada = newOidActividadReferenciada;
  }

  public Boolean getTipoActividad()
  {
    return tipoActividad;
  }

  public void setTipoActividad(Boolean newTipoActividad)
  {
    tipoActividad = newTipoActividad;
  }

  public Boolean getTipoDias()
  {
    return tipoDias;
  }

  public void setTipoDias(Boolean newTipoDias)
  {
    tipoDias = newTipoDias;
  }

  public String getTipoFacturacion()
  {
    return tipoFacturacion;
  }

  public void setTipoFacturacion(String newTipoFacturacion)
  {
    tipoFacturacion = newTipoFacturacion;
  }

  public Date getFechaPrevista()
  {
    return fechaPrevista;
  }

  public void setFechaPrevista(Date newFechaPrevista)
  {
    fechaPrevista = newFechaPrevista;
  }
}
