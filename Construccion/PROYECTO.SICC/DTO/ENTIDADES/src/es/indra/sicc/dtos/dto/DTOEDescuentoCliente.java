package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOEDescuentoCliente extends DTOAuditableSICC {

   private Long oidDescuento;
   private String codigoCliente;
   private Double importeDescuento;
    private Double porcentajeDescuento;
   
   public DTOEDescuentoCliente() {
   }

   public Long getOidDescuento()
   {
      return this.oidDescuento;
   }

   public String getCodigoCliente()
   {
      return this.codigoCliente;
   }

   public Double getImporteDescuento()
   {
      return this.importeDescuento;
   }

   public Double getPorcentajeDescuento()
   {
      return this.porcentajeDescuento;
   }

   public void setOidDescuento(Long oidDescuento)
   {
      this.oidDescuento = oidDescuento;
   }

   public void setCodigoCliente(String codigoCliente)
   {
      this.codigoCliente = codigoCliente;
   }

   public void setImporteDescuento(Double importeDescuento)
   {
      this.importeDescuento = importeDescuento;
   }

   public void setPorcentajeDescuento(Double porcentajeDescuento)
   {
      this.porcentajeDescuento = porcentajeDescuento;
   }
}