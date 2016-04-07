/*
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.cra;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Collection;
import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Subm�dulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/11/2003
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor             Emilio Noziglia
 */

public class DTOGruposZonas extends DTOAuditableSICC {

  private Vector oidGrupoZona;
  private Vector codGrupoZona;
  private Vector tipoFacturacion;
  private Vector fechaInicio;
  private Vector fechaPrevista;
  private Vector fechaMedia;
  private Vector fechaFin;

	public DTOGruposZonas() {
		super();
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

  public Vector getOidGrupoZona()
  {
    return oidGrupoZona;
  }

  public void setOidGrupoZona(Vector newOidGrupoZona)
  {
    oidGrupoZona = newOidGrupoZona;
  }

  public Vector getTipoFacturacion()
  {
    return tipoFacturacion;
  }

  public void setTipoFacturacion(Vector newTipoFacturacion)
  {
    tipoFacturacion = newTipoFacturacion;
  }

  public Vector getCodGrupoZona()
  {
    return codGrupoZona;
  }

  public void setCodGrupoZona(Vector newCodGrupoZona)
  {
    codGrupoZona = newCodGrupoZona;
  }
}
