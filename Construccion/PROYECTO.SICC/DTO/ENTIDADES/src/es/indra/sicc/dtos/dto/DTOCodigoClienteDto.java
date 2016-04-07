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

package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOCodigoClienteDto extends DTOAuditableSICC {

    private String codigo;
    private Long oid;

    public DTOCodigoClienteDto()
    {
    }
    
   public String getCodigo()
   {
      return this.codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }  
 
 
   public Long getOid()
   {
      return this.oid;
   }

   public void setOid(Long oid)
   {
      this.oid = oid;
   }  
   
}