package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

public class DTOParametroTipoCliente extends DTOAuditableSICC {

   private Long oid;
   private Boolean valorPorDefecto;
   private Long oidTipoCliente;
   private String descripcion;
   
   public DTOParametroTipoCliente() {
   }

   public Long getOid()
   {
      return this.oid;
   }

   public void setOid(Long oid)
   {
      this.oid = oid;
   }

   public Boolean getValorPorDefecto()
   {
      return this.valorPorDefecto;
   }

   public void setValorPorDefecto(Boolean valorPorDefecto)
   {
      this.valorPorDefecto = valorPorDefecto;
   }

   public Long getOidTipoCliente()
   {
      return this.oidTipoCliente;
   }

   public void setOidTipoCliente(Long oidTipoCliente)
   {
      this.oidTipoCliente = oidTipoCliente;
   }

   public String getDescripcion()
   {
      return this.descripcion;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }
}