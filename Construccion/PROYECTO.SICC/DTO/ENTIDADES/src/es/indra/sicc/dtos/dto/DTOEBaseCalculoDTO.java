package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOOIDs;

public class DTOEBaseCalculoDTO extends DTOAuditableSICC {

   private Long oidDescuento;
   private DTOOIDs marcas;
   private DTOOIDs unidadesNegocio;
   private DTOOIDs supergenericos;
   private DTOOIDs genericos;
    private Long oidBase;
    private DTOOIDs negocio;
    private DTOOIDs productos;
   
   public DTOEBaseCalculoDTO() {
   }

   public Long getOidDescuento()
   {
      return this.oidDescuento;
   }

   public DTOOIDs getUnidadesNegocio()
   {
      return this.unidadesNegocio;
   }

   public DTOOIDs getSupergenericos()
   {
      return this.supergenericos;
   }

   public DTOOIDs getGenericos()
   {
      return this.genericos;
   }

   public DTOOIDs getMarcas()
   {
      return this.marcas;
   }

   public void setOidDescuento(Long oidDescuento)
   {
      this.oidDescuento = oidDescuento;
   }

   public void setMarcas (DTOOIDs marcas)
   {
      this.marcas = marcas;
   }

   public void setUnidadesNegocio (DTOOIDs unidadesNegocio)
   {
      this.unidadesNegocio = unidadesNegocio;
   }

   public void setSupergenericos (DTOOIDs supergenericos)
   {
      this.supergenericos = supergenericos;
   }

   public void setGenericos (DTOOIDs genericos)
   {
      this.genericos = genericos;
   }

    public Long getOidBase() {
        return oidBase;
    }

    public void setOidBase(Long newOidBase) {
        oidBase = newOidBase;
    }

    public DTOOIDs getNegocio() {
        return negocio;
    }

    public void setNegocio(DTOOIDs newNegocio) {
        negocio = newNegocio;
    }

    public DTOOIDs getProductos() {
        return productos;
    }

    public void setProductos(DTOOIDs newProductos) {
        productos = newProductos;
    }
}