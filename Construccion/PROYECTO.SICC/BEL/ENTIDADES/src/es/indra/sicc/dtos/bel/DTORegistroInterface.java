/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.bel;

import es.indra.sicc.util.DTOBelcorp;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class DTORegistroInterface extends DTOBelcorp {
   
   private String codigoPais;
   private String codigoCanal;
   private String codigoAcceso;
   private String codigoSubacceso;
   private Timestamp fechaRecepcionInteface;
   private String codigoProducto;
   private BigDecimal unidadesConfirmadas;
   private String numeroSolicitudReposicion;

   public DTORegistroInterface() {
      super();
   }

   public String getCodigoPais()
   {
      return codigoPais;
   }

   public void setCodigoPais(String codigoPais)
   {
      this.codigoPais = codigoPais;
   }

   public String getCodigoCanal()
   {
      return codigoCanal;
   }

   public void setCodigoCanal(String codigoCanal)
   {
      this.codigoCanal = codigoCanal;
   }

   public String getCodigoAcceso()
   {
      return codigoAcceso;
   }

   public void setCodigoAcceso(String codigoAcceso)
   {
      this.codigoAcceso = codigoAcceso;
   }

   public String getCodigoSubacceso()
   {
      return codigoSubacceso;
   }

   public void setCodigoSubacceso(String codigoSubacceso)
   {
      this.codigoSubacceso = codigoSubacceso;
   }

   public Timestamp getFechaRecepcionInteface()
   {
      return fechaRecepcionInteface;
   }

   public void setFechaRecepcionInteface(Timestamp fechaRecepcionInteface)
   {
      this.fechaRecepcionInteface = fechaRecepcionInteface;
   }

   public String getCodigoProducto()
   {
      return codigoProducto;
   }

   public void setCodigoProducto(String codigoProducto)
   {
      this.codigoProducto = codigoProducto;
   }

   public BigDecimal getUnidadesConfirmadas()
   {
      return unidadesConfirmadas;
   }

   public void setUnidadesConfirmadas(BigDecimal unidadesConfirmadas)
   {
      this.unidadesConfirmadas = unidadesConfirmadas;
   }

   public String getNumeroSolicitudReposicion()
   {
      return numeroSolicitudReposicion;
   }

   public void setNumeroSolicitudReposicion(String numeroSolicitudReposicion)
   {
      this.numeroSolicitudReposicion = numeroSolicitudReposicion;
   }
}