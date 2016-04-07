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

import java.util.Date;
import java.util.Collection;
import java.util.ArrayList;

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


public class DTOResultadoActividadesPorGrupoZona extends DTOAuditableSICC {

    private Date fechaInicio;
    private Date fechaFin;
    private Collection zonasGrupos = new ArrayList();
    
    public DTOResultadoActividadesPorGrupoZona() {
      super();
    }

  public Date getFechaFin()
  {
    return fechaFin;
  }

  public void setFechaFin(Date newFechaFin)
  {
    fechaFin = newFechaFin;
  }

  public Date getFechaInicio()
  {
    return fechaInicio;
  }

  public void setFechaInicio(Date newFechaInicio)
  {
    fechaInicio = newFechaInicio;
  }

  public Collection getZonasGrupos()
  {
    return zonasGrupos;
  }

  public void setZonasGrupos(Collection newZonasGrupos)
  {
    zonasGrupos = newZonasGrupos;
  }
}
