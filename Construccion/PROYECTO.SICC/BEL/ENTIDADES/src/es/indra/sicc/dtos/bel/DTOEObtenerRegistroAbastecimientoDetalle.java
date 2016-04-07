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

public class DTOEObtenerRegistroAbastecimientoDetalle extends DTOBelcorp {
   
   private Long oidRegistroAbastecimientoCabecera;
   private Long almacen;
   private Long agrupacionStock;

   public DTOEObtenerRegistroAbastecimientoDetalle() {
      super();
   }

   public Long getOidRegistroAbastecimientoCabecera()
   {
      return oidRegistroAbastecimientoCabecera;
   }

   public void setOidRegistroAbastecimientoCabecera(Long oidRegistroAbastecimientoCabecera)
   {
      this.oidRegistroAbastecimientoCabecera = oidRegistroAbastecimientoCabecera;
   }

   public Long getAlmacen()
   {
      return almacen;
   }

   public void setAlmacen(Long almacen)
   {
      this.almacen = almacen;
   }

   public Long getAgrupacionStock()
   {
      return agrupacionStock;
   }

   public void setAgrupacionStock(Long agrupacionStock)
   {
      this.agrupacionStock = agrupacionStock;
   }
  
}