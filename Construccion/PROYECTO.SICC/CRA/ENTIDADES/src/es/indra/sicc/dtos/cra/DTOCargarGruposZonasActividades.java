/**
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
import es.indra.sicc.util.DTOSalida;
public class DTOCargarGruposZonasActividades  extends  es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC{

  private DTOSalida actividades;
  private DTOSalida gruposZonas;
  public DTOCargarGruposZonasActividades() {
  }

  public DTOSalida getActividades() {
    return actividades;
  }

  public void setActividades(DTOSalida newActividades) {
    actividades = newActividades;
  }

  public DTOSalida getGruposZonas() {
    return gruposZonas;
  }

  public void setGruposZonas(DTOSalida newGruposZonas) {
    gruposZonas = newGruposZonas;
  }
}