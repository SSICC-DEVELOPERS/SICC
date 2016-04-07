package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.lang.Boolean;
import java.lang.String;

public class DTOBuscarMatricesDescuento extends DTOSiccPaginacion {

   private String descripcionMatriz;
   private Boolean matrizActiva;
   
   public DTOBuscarMatricesDescuento() {
   }

   public String getDescripcionMatriz()
   {
      return this.descripcionMatriz;
   }

   public Boolean getMatrizActiva()
   {
      return this.matrizActiva;
   }

   public void setDescripcionMatriz(String descripcionMatriz)
   {
      this.descripcionMatriz = descripcionMatriz;
   }

   public void setMatrizActiva(Boolean matrizActiva)
   {
      this.matrizActiva = matrizActiva;
   }
}