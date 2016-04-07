package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

public class DTOParametroSubtipoCliente extends DTOAuditableSICC {

   private Long oid;
   private Boolean valorPorDefecto;
   private Long oidSubtipoCliente;
   private Long oidTipoCliente;
   private String descripcion;
   
   public DTOParametroSubtipoCliente() {
   }

      public Long getOid()
   {
      return this.oid;
   }

   public Boolean getValorPorDefecto()
   {
      return this.valorPorDefecto;
   }

   public Long getOidSubtipoCliente()
   {
      return this.oidSubtipoCliente;
   }

   public String getDescripcion()
   {
      return this.descripcion;
   }

   public void setOid(Long oid)
   {
      this.oid = oid;
   }

   public void  setValorPorDefecto(Boolean valorPorDefecto)
   {
      this.valorPorDefecto = valorPorDefecto;
   }

   public void  setOidSubtipoCliente(Long oidSubtipoCliente)
   {
      this.oidSubtipoCliente = oidSubtipoCliente;
   }

   public void  setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }

    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long newOidTipoCliente) {
        oidTipoCliente = newOidTipoCliente;
    }
}