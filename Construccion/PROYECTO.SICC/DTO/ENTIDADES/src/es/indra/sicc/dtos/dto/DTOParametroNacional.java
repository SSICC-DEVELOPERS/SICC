package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOParametroNacional extends DTOAuditableSICC {

   private Long oid;
   private String valor;
   private Boolean valorPorDefecto;
   
   public DTOParametroNacional() {
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

   public String getValor()
   {
      return this.valor;
   }

   public void setOid(Long oid)
   {
      this.oid = oid;
   }

   public void setValor(String valor)
   {
      this.valor = valor;
   }
}