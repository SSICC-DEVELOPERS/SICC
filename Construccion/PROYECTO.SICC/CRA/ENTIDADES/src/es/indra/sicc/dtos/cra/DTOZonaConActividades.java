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

public class DTOZonaConActividades extends DTOAuditableSICC {

    private Long oidZona;
    private String codGrupoZona;
    private Vector acts = new Vector();
    
    public DTOZonaConActividades() {
      super();
    }

  public Vector getActs()
  {
    return acts;
  }

  public void setActs(Vector newActs)
  {
    acts = newActs;
  }

  public String getCodGrupoZona()
  {
    return codGrupoZona;
  }

  public void setCodGrupoZona(String newCodGrupoZona)
  {
    codGrupoZona = newCodGrupoZona;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long newOidZona)
  {
    oidZona = newOidZona;
  }
}
