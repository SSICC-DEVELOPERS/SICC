/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.rec;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DTOEliminaLineaOperacion extends DTOBelcorp {

   // DTO creado por incidencia BELC300014385
   
   private ArrayList oidLineas; //BELC300015140
   private BigDecimal totalEnvia;
   private BigDecimal totalDevuelve;

   public DTOEliminaLineaOperacion() {
   }

   public ArrayList getOidLineas() {
      return oidLineas;
   }

   public void setOidLineas(ArrayList oidLineas) {
      this.oidLineas = oidLineas;
   }

   public BigDecimal getTotalEnvia() {
      return totalEnvia;
   }

   public void setTotalEnvia(BigDecimal totalEnvia) {
      this.totalEnvia = totalEnvia;
   }

   public BigDecimal getTotalDevuelve() {
      return totalDevuelve;
   }

   public void setTotalDevuelve(BigDecimal totalDevuelve) {
      this.totalDevuelve = totalDevuelve;
   }
}