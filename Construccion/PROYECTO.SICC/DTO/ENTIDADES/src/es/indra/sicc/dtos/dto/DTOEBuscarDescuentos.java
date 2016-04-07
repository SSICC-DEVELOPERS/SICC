package es.indra.sicc.dtos.dto;

import es.indra.sicc.dtos.dto.DTOEDescuento;

public class DTOEBuscarDescuentos extends DTOEDescuento {

   private Long oidPais;
   private String descripcion;
   private Long oidMarca;
   private Long oidCanal;
   private Long oidPeriodoDesde;
   private Long oidPeriodoHasta;
   private Boolean activo;
   
   public DTOEBuscarDescuentos() {
   }

   public Long getOidPais()
   {
      return this.oidPais;
   }

   public Long getOidPeriodoDesde()
   {
      return this.oidPeriodoDesde;
   }

   public Long getOidPeriodoHasta()
   {
      return this.oidPeriodoHasta;
   }

   public Long getOidMarca()
   {
      return this.oidMarca;
   }

   public Long getOidCanal()
   {
      return this.oidCanal;
   }

   public String getDescripcion()
   {
      return this.descripcion;
   }

    public Boolean getActivo()
   {
      return this.activo;
   }

   public void setOidPais  (Long oidPais)
   {
      this.oidPais = oidPais;
   }

   public void setOidMarca  (Long oidMarca)
   {
      this.oidMarca = oidMarca;
   }

   public void setOidCanal  (Long oidCanal)
   {
      this.oidCanal = oidCanal;
   }

   public void setOidPeriodoDesde  (Long oidPeriodoDesde)
   {
      this.oidPeriodoDesde = oidPeriodoDesde;
   }

   public void setOidPeriodoHasta  (Long oidPeriodoHasta)
   {
      this.oidPeriodoHasta = oidPeriodoHasta;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }

   public void setActivo (Boolean activo)
   {
      this.activo = activo;
   }

}