package es.indra.sicc.dtos.dto;

import es.indra.sicc.util.DTOOIDs;

public class DTOEMatrizSubtiposCliente extends DTOCabeceraMatrizDTO {

   private DTOOIDs subtiposCliente;
   
   public DTOEMatrizSubtiposCliente() {
   }

   public DTOOIDs getSubtiposCliente()
   {
      return this.subtiposCliente;
   }

   public void setSubtiposCliente(DTOOIDs subtiposCliente)
   {
      this.subtiposCliente = subtiposCliente;
   }
}