package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Autor: wchere
 * Fecha: 06/12/04
 */
 
public class DTOEntradaConsultaDatosCampana extends DTOAuditableSICC  {

   private String idUsuario;

   public DTOEntradaConsultaDatosCampana() {
   }

   public void setIdUsuario( String idUsuario ) {
      this.idUsuario = idUsuario;
   }

   public String getIdUsuario () {
      return this.idUsuario;
   }

}