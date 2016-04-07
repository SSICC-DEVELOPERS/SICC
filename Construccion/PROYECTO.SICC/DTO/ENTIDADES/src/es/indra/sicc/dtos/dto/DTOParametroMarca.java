package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

public class DTOParametroMarca extends DTOAuditableSICC {

   private Long oid;
   private Boolean valorPorDefecto;
   private Long oidMarca;
   private String codigo;
   private String descripcion;
   
   public DTOParametroMarca() {
   }

   public Long getOid()
   {
      return this.oid;
   }

   public Boolean getValorPorDefecto()
   {
      return this.valorPorDefecto;
   }

   public Long getOidMarca()
   {
      return this.oidMarca;
   }

   public String getCodigo()
   {
      return this.codigo;
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

   public void  setOidMarca(Long oidMarca)
   {
      this.oidMarca = oidMarca;
   }

   public void  setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public void  setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }
}