package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOParametroBoolean extends DTOAuditableSICC {

   private Long oid;
   private Boolean valor;
   private Boolean valorPorDefecto;
   
   public DTOParametroBoolean() {
   }

   public Boolean getValorPorDefecto()
   {
      return this.valorPorDefecto;
   }

   public void setValorPorDefecto(Boolean valorPorDefecto)
   {
      this.valorPorDefecto = valorPorDefecto;
   }
   
 public Long getOid()
   {
      return this.oid;
   }

   public Boolean getValor()
   {
      return this.valor;
   }

   public void setOid(Long oid)
   {
      this.oid = oid;
   }

   public void setValor(Boolean valor)
   {
      this.valor = valor;
   }
}