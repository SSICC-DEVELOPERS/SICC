package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;

public class DTOParametroClasificacion extends DTOAuditableSICC {

   private Long oid;
   private Boolean valorPorDefecto;
   private Long oidClasificacion;
   private Long oidTipoClasificacion;
   private String descripcionClasificacion;
   
   public DTOParametroClasificacion() {
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

   public Long getOidClasificacion()
   {
      return this.oidClasificacion;
   }

   public void setOidClasificacion(Long oidClasificacion)
   {
      this.oidClasificacion = oidClasificacion;
   }

    public Long getOidTipoClasificacion() {
        return oidTipoClasificacion;
    }

    public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
        oidTipoClasificacion = newOidTipoClasificacion;
    }

    public String getDescripcionClasificacion() {
        return descripcionClasificacion;
    }

    public void setDescripcionClasificacion(String newDescripcionClasificacion) {
        descripcionClasificacion = newDescripcionClasificacion;
    }
}