package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Vector;

public class DTOMatrizDescuento extends DTOAuditableSICC {

   private Long oidCabeceraMatriz;
   private Long oidPais;
   private Vector descripcion;
   private Boolean matrizActiva;
   private String observaciones;
   
   public DTOMatrizDescuento() {
   }

public Long getOidCabeceraMatriz()
   {
      return this.oidCabeceraMatriz;
   }

   public Long getOidPais()
   {
      return this.oidPais;
   }


   public Boolean getMatrizActiva()
   {
      return this.matrizActiva;
   }

   public String getObservaciones()
   {
      return this.observaciones;
   }

   public void setOidCabeceraMatriz(Long oidCabeceraMatriz)
   {
      this.oidCabeceraMatriz = oidCabeceraMatriz;
   }

   public void setOidPais(Long oidPais)
   {
      this.oidPais = oidPais;
   }

   public void setMatrizActiva(Boolean matrizActiva)
   {
      this.matrizActiva = matrizActiva;
   }

   public void setObservaciones(String observaciones)
   {
      this.observaciones = observaciones;
   }

    public Vector getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Vector newDescripcion) {
        descripcion = newDescripcion;
    }

}