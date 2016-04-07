/**
 * Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOCargarOID  extends DTOSiccPaginacion{
   public DTOCargarOID() {
      super();
   }
   private Long oid; 

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }
}