package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

public class DTOParametroAcceso extends DTOAuditableSICC {

   private Long oid;
   private Boolean valorPorDefecto;
   private Long oidCanal;
   private Long oidAcceso;
   private String codigoAcceso;
   private String descripcion;
   
   public DTOParametroAcceso() {
   }

 public Long getOid()
   {
      return this.oid;
   }

   public Boolean getValorPorDefecto()
   {
      return this.valorPorDefecto;
   }

   public Long getOidCanal()
   {
      return this.oidCanal;
   }

   public Long getOidAcceso()
   {
      return this.oidAcceso;
   }

   public String getCodigoAcceso()
   {
      return this.codigoAcceso;
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

   public void  setOidCanal(Long oidCanal)
   {
      this.oidCanal = oidCanal;
   }

   public void  setOidAcceso(Long oidAcceso)
   {
      this.oidAcceso = oidAcceso;
   }

   public void  setCodigoAcceso(String codigoAcceso)
   {
      this.codigoAcceso = codigoAcceso;
   }

   public void  setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }
}