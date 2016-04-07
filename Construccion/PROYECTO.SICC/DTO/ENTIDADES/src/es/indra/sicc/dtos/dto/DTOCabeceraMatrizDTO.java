package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Long;

public class DTOCabeceraMatrizDTO extends DTOAuditableSICC {

   private Long oidCabeceraMatrizDTO;
   private Long oidCanal;
   private String codigo;
   private String descripcion;
   
   public DTOCabeceraMatrizDTO() {
   }

   public Long getOidCabeceraMatrizDTO()
   {
      return this.oidCabeceraMatrizDTO;
   }

   public void setOidCabeceraMatrizDTO(Long oidCabeceraMatrizDTO)
   {
      this.oidCabeceraMatrizDTO = oidCabeceraMatrizDTO;
   }

   public Long getOidCanal()
   {
      return this.oidCanal;
   }

   public void setOidCanal(Long oidCanal)
   {
      this.oidCanal = oidCanal;
   }

   public String getCodigo()
   {
      return this.codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public String getDescripcion()
   {
      return this.descripcion;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }
}