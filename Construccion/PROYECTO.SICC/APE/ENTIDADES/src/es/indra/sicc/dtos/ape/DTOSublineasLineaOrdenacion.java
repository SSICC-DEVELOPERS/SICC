/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 * 
 * vbongiov -- 3/09/2007
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOSublineasLineaOrdenacion  extends DTOSiccPaginacion  {
  private Long oidOrdenAnaquelCab;
  private Long oidLinea;

  public DTOSublineasLineaOrdenacion() {
  }

  public Long getOidOrdenAnaquelCab() {
    return oidOrdenAnaquelCab;
  }

  public void setOidOrdenAnaquelCab(Long oidOrdenAnaquelCab) {
    this.oidOrdenAnaquelCab = oidOrdenAnaquelCab;
  }

  public Long getOidLinea() {
    return oidLinea;
  }

  public void setOidLinea(Long oidLinea) {
    this.oidLinea = oidLinea;
  }
}