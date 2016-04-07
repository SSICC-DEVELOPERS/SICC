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
import es.indra.sicc.util.DTOSalida;

public class DTOCargarActividadesGruposZonasDuracionPeriodo  extends  es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC{
  private DTOSalida actividades;
  private DTOSalida gruposZonas;
  private Integer duracion;
  
  public DTOCargarActividadesGruposZonasDuracionPeriodo() {
  }
  public DTOSalida getActividades() {
      return this.actividades;
  }

  public void setActividades(DTOSalida newActividades) {
      this.actividades = newActividades;
  }

  public Integer getDuracion() {
      return this.duracion;
  }

  public void setPaises(Integer newDuracion) {
      this.duracion = newDuracion;
  }

  public DTOSalida getGruposZonas() {
      return this.gruposZonas;
  }

  public void setGruposZonas(DTOSalida newGruposZonas) {
      this.gruposZonas = newGruposZonas;
  }

}