package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODescuentoOrden extends DTOAuditableSICC {

   private Long numeroCorrelativoDTO;
   private Long oidDescuento;
   private Boolean indicadorCulminacion;
   
   public DTODescuentoOrden() {
   }

   public Long getOidDescuento()
   {
      return this.oidDescuento;
   }

   public void setOidDescuento  (Long oidDescuento)
   {
      this.oidDescuento = oidDescuento;
   }

   public Long getNumeroCorrelativoDTO()
   {
      return this.numeroCorrelativoDTO;
   }

   public void setNumeroCorrelativoDTO(Long numeroCorrelativoDTO)
   {
      this.numeroCorrelativoDTO = numeroCorrelativoDTO;
   }

   public Boolean getIndicadorCulminacion()
   {
      return this.indicadorCulminacion;
   }

   public void setIndicadorCulminacion(Boolean indicadorCulminacion)
   {
      this.indicadorCulminacion = indicadorCulminacion;
   }

}