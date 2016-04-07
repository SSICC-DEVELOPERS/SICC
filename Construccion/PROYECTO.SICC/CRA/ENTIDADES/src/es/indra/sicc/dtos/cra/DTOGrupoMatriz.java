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
import java.util.Vector;

public class DTOGrupoMatriz extends DTOAuditableSICC  {
  private Long grupoZona;
  private Vector actividades; 
  private String textoGrupo;
  private Long actividad;
  private Vector borradas;

  public DTOGrupoMatriz() {
    this.setBorradas(new Vector());
  }

  public Long getGrupoZona() {
    return grupoZona;
  }

  public void setGrupoZona(Long newGrupoZona) {
    grupoZona = newGrupoZona;
  }

  public Vector getActividades() {
    return actividades;
  }

  public void setActividades(Vector newActividades) {
    actividades = newActividades;
  }

  public String getTextoGrupo() {
    return textoGrupo;
  }

  public void setTextoGrupo(String newTextoGrupo) {
    textoGrupo = newTextoGrupo;
  }

  public Long getActividad() {
    return actividad;
  }

  public void setActividad(Long newActividad) {
    actividad = newActividad;
  }

    public Vector getBorradas() {
        return borradas;
    }

    public void setBorradas(Vector newBorradas) {
        borradas = newBorradas;
    }
}