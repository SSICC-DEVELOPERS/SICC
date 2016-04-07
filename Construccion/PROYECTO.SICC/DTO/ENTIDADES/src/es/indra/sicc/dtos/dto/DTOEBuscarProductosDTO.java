package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarProductosDTO extends DTOSiccPaginacion {

   private Long oidMarca;
   private Long oidUnidadNegocio;
   private Long oidNegocio;
   private Long oidGenerico;
   private Long oidSuperGenerico;
   private String codigoProducto;
   private String descripcionProducto;
   
   public DTOEBuscarProductosDTO() {
   }

   public Long getOidMarca()
   {
      return this.oidMarca;
   }

   public Long getOidUnidadNegocio()
   {
      return this.oidUnidadNegocio;
   }

   public Long getOidNegocio()
   {
      return this.oidNegocio;
   }

   public Long getOidSuperGenerico()
   {
      return this.oidSuperGenerico;
   }

   public Long getOidGenerico()
   {
      return this.oidGenerico;
   }

   public String getCodigoProducto()
   {
      return this.codigoProducto;
   }

   public String getDescripcionProducto()
   {
      return this.descripcionProducto;
   }

   public void setOidMarca(Long oidMarca)
   {
      this.oidMarca = oidMarca;
   }

   public void setOidUnidadNegocio(Long oidUnidadNegocio)
   {
      this.oidUnidadNegocio = oidUnidadNegocio;
   }

   public void setOidGenerico(Long oidGenerico)
   {
      this.oidGenerico = oidGenerico;
   }

   public void setOidNegocio(Long oidNegocio)
   {
      this.oidNegocio = oidNegocio;
   }

   public void setOidSuperGenerico(Long oidSuperGenerico)
   {
      this.oidSuperGenerico = oidSuperGenerico;
   }

   public void setCodigoProducto(String codigoProducto)
   {
      this.codigoProducto = codigoProducto;
   }

   public void setDescripcionProducto(String descripcionProducto)
   {
      this.descripcionProducto = descripcionProducto;
   }
}