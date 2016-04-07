package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

public class DTOParametroSubacceso extends DTOAuditableSICC {

   private Long oid;
   private Boolean valorPorDefecto;
   private Long oidCanal;
   private Long oidAcceso;
   private Long oidSubacceso;
   private String codigoSubacceso;
   private String descripcionSubacceso;
   
   public DTOParametroSubacceso() {
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

   public Long getOidSubacceso()
   {
      return this.oidSubacceso;
   }

   public String getCodigoSubacceso()
   {
      return this.codigoSubacceso;
   }

   public String getDescripcionSubacceso()
   {
      return this.descripcionSubacceso;
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

   public void  setOidSubacceso(Long oidSubacceso)
   {
      this.oidSubacceso = oidSubacceso;
   }

   public void  setCodigoSubacceso(String codigoSubacceso)
   {
      this.codigoSubacceso = codigoSubacceso;
   }

   public void  setDescripcionSubacceso(String descripcionSubacceso)
   {
      this.descripcionSubacceso = descripcionSubacceso;
   }
}