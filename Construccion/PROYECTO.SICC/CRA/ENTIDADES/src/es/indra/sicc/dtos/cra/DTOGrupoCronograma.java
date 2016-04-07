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
import java.util.ArrayList;
import java.util.Vector;

public class DTOGrupoCronograma extends DTOAuditableSICC  {
  //DTOActividadGrupo[]
  private Vector actividades;
  private Long oid;
  private Long tipoFacturacion;
  private String textoGrupo;
  private Vector borradas;

  public DTOGrupoCronograma() {
  }

  public Vector getActividades() {
    return actividades;
  }

  public void setActividades(Vector newActividades) {
    actividades = newActividades;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Long getTipoFacturacion() {
    return tipoFacturacion;
  }

  public void setTipoFacturacion(Long newTipoFacturacion) {
    tipoFacturacion = newTipoFacturacion;
  }

  public String getTextoGrupo() {
    return textoGrupo;
  }

  public void setTextoGrupo(String newTextoGrupo) {
    textoGrupo = newTextoGrupo;
  }

  public Vector getBorradas() {
    return borradas;
  }

  public void setBorradas(Vector newBorradas) {
    borradas = newBorradas;
  }
}