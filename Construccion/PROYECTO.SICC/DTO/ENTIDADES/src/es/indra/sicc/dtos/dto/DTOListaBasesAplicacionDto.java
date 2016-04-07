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
 
package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOListaBasesAplicacionDto extends DTOAuditableSICC {

    private DTOSBaseAplicacion[] basesAplicacion;

    public DTOListaBasesAplicacionDto()
    {
    }
    
   public DTOSBaseAplicacion[] getBasesAplicacion() {
       return basesAplicacion;
   }

   public void setBasesAplicacion(DTOSBaseAplicacion[] basesAplicacion) {
       this.basesAplicacion = basesAplicacion;
   }       
    
}