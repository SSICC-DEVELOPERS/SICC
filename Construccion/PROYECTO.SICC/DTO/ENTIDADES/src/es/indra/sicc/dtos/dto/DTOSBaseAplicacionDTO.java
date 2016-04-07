package es.indra.sicc.dtos.dto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.dto.DTOSBaseCalculoDTO;

public class DTOSBaseAplicacionDTO extends DTOSBaseCalculoDTO {

   private Integer numeroUnidadesObligatorias;
   private RecordSet escalones;
   
   public DTOSBaseAplicacionDTO() {
   }

   public Integer getNumeroUnidadesObligatorias()
   {
      return this.numeroUnidadesObligatorias;
   }

   public void setNumeroUnidadesObligatorias(Integer numeroUnidadesObligatorias)
   {
      this.numeroUnidadesObligatorias = numeroUnidadesObligatorias;
   }

   public RecordSet getEscalones()
   {
      return this.escalones;
   }

   public void setEscalones(RecordSet escalones)
   {
      this.escalones = escalones;
   }
}