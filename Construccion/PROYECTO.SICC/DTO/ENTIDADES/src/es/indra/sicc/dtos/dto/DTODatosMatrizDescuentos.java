package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Vector;

public class DTODatosMatrizDescuentos extends DTOAuditableSICC {

   private Long oidCabeceraMatriz;
   private Long oidPais;
   private Vector descripcion;
   private Boolean matrizActiva;
   private String observaciones;
   private ArrayList listaParametros;
   
   public DTODatosMatrizDescuentos() {
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

   public ArrayList getListaParametros()
   {
      return this.listaParametros;
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

   public void setListaParametros(ArrayList listaParametros)
   {
      this.listaParametros = listaParametros;
   }

    public Vector getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Vector newDescripcion) {
        descripcion = newDescripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }
}
