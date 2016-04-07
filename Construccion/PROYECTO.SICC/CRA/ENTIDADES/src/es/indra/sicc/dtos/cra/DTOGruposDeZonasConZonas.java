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

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/11/2003
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor             Marcelo Pastorino
 */

public class DTOGruposDeZonasConZonas extends DTOAuditableSICC {

    private Vector oidGrupoZona;
    private Vector oidPaisGrupo;
    private Vector oidMarca;
    private Vector oidCanal;
    private Vector codGrupoZona;
    private Vector nombreGrupoZona;
    private Vector tipoFacturacion;
    private Vector fechaInicio;
    private Vector fechaPrevista;
    private Vector fechaMedia;
    private Vector fechaFin;
    private Vector indEstado;
    private Vector zonasGrupos;

	public DTOGruposDeZonasConZonas() {
		super();
	}

  public Vector getCodGrupoZona()
  {
    return codGrupoZona;
  }

  public void setCodGrupoZona(Vector newCodGrupoZona)
  {
    codGrupoZona = newCodGrupoZona;
  }

  public Vector getFechaFin()
  {
    return fechaFin;
  }

  public void setFechaFin(Vector newFechaFin)
  {
    fechaFin = newFechaFin;
  }

  public Vector getFechaInicio()
  {
    return fechaInicio;
  }

  public void setFechaInicio(Vector newFechaInicio)
  {
    fechaInicio = newFechaInicio;
  }

  public Vector getFechaMedia()
  {
    return fechaMedia;
  }

  public void setFechaMedia(Vector newFechaMedia)
  {
    fechaMedia = newFechaMedia;
  }

  public Vector getFechaPrevista()
  {
    return fechaPrevista;
  }

  public void setFechaPrevista(Vector newFechaPrevista)
  {
    fechaPrevista = newFechaPrevista;
  }

  public Vector getIndEstado()
  {
    return indEstado;
  }

  public void setIndEstado(Vector newIndEstado)
  {
    indEstado = newIndEstado;
  }

  public Vector getNombreGrupoZona()
  {
    return nombreGrupoZona;
  }

  public void setNombreGrupoZona(Vector newNombreGrupoZona)
  {
    nombreGrupoZona = newNombreGrupoZona;
  }

  public Vector getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Vector newOidCanal)
  {
    oidCanal = newOidCanal;
  }

  public Vector getOidGrupoZona()
  {
    return oidGrupoZona;
  }

  public void setOidGrupoZona(Vector newOidGrupoZona)
  {
    oidGrupoZona = newOidGrupoZona;
  }

  public Vector getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Vector newOidMarca)
  {
    oidMarca = newOidMarca;
  }

  public Vector getOidPaisGrupo()
  {
    return oidPaisGrupo;
  }

  public void setOidPaisGrupo(Vector newOidPaisGrupo)
  {
    oidPaisGrupo = newOidPaisGrupo;
  }

  public Vector getZonasGrupos()
  {
    return zonasGrupos;
  }

  public void setZonasGrupos(Vector newZonasGrupos)
  {
    zonasGrupos = newZonasGrupos;
  }

  public Vector getTipoFacturacion()
  {
    return tipoFacturacion;
  }

  public void setTipoFacturacion(Vector newTipoFacturacion)
  {
    tipoFacturacion = newTipoFacturacion;
  }
}

