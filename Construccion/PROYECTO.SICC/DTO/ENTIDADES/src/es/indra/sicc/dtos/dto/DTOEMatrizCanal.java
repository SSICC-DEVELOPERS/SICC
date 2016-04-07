package es.indra.sicc.dtos.dto;

import java.lang.Long;

public class DTOEMatrizCanal extends DTOCabeceraMatrizDTO  {

   private Long canal;
   
   public DTOEMatrizCanal() {
   }

   public Long getCanal()
   {
      return this.canal;
   }

   public void setCanal(Long canal)
   {
      this.canal = canal;
   }
}