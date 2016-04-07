package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEDescuento extends DTOSiccPaginacion {

   private Long oidDescuento;
   
   public DTOEDescuento() {
   }

   public Long getOidDescuento()
   {
      return this.oidDescuento;
   }

   public void setOidDescuento(Long oidDescuento)
   {
      this.oidDescuento = oidDescuento;
   }
}