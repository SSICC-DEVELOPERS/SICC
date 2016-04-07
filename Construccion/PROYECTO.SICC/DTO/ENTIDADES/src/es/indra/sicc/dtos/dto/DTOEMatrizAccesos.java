package es.indra.sicc.dtos.dto;

import es.indra.sicc.util.DTOOIDs;

public class DTOEMatrizAccesos extends DTOCabeceraMatrizDTO {

   private DTOOIDs accesos;
   
   public DTOEMatrizAccesos() {
   }

   public DTOOIDs getAccesos()
   {
      return this.accesos;
   }

   public void setAccesos(DTOOIDs accesos)
   {
      this.accesos = accesos;
   }
}