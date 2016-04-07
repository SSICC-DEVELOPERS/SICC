package es.indra.sicc.dtos.dto;

import es.indra.sicc.util.DTOOIDs;

public class DTOEMatrizTiposCliente extends DTOCabeceraMatrizDTO  {

   private DTOOIDs tiposCliente;
   
   public DTOEMatrizTiposCliente() {
   }

   public DTOOIDs getTiposCliente()
   {
      return this.tiposCliente;
   }

   public void setTiposCliente(DTOOIDs tiposCliente)
   {
      this.tiposCliente = tiposCliente;
   }
}