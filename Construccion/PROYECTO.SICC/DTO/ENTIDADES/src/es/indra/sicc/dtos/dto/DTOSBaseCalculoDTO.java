package es.indra.sicc.dtos.dto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSBaseCalculoDTO extends DTOAuditableSICC {

   private RecordSet marcas;
   private RecordSet unidadesNegocio;
   private RecordSet negocios;
   private RecordSet supergenericos;
   private RecordSet genericos;
   private RecordSet productos;
   
   public DTOSBaseCalculoDTO() {
   }

   public RecordSet getMarcas()
   {
      return this.marcas;
   }

   public RecordSet getUnidadesNegocio()
   {
      return this.unidadesNegocio;
   }

   public RecordSet getNegocios()
   {
      return this.negocios;
   }

   public RecordSet getSupergenericos()
   {
      return this.supergenericos;
   }

   public RecordSet getGenericos()
   {
      return this.supergenericos;
   }

   public RecordSet getProductos()
   {
      return this.productos;
   }

   public void setMarcas (RecordSet marcas)
   {
      this.marcas = marcas;
   }

   public void setUnidadesNegocio (RecordSet unidadesNegocio)
   {
      this.unidadesNegocio = unidadesNegocio;
   }

   public void setNegocios (RecordSet negocios)
   {
      this.negocios = negocios;
   }

   public void setSupergenericos (RecordSet supergenericos)
   {
      this.supergenericos = supergenericos;
   }

   public void setProductos (RecordSet productos)
   {
      this.productos = productos;
   }

   public void setGenericos(RecordSet genericos)
   {
      this.genericos = genericos;
   }
}