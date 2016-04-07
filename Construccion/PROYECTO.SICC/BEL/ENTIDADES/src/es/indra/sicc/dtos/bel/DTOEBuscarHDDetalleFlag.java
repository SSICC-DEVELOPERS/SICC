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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarHDDetalleFlag extends DTOSiccPaginacion {

      
   private Long oidRegistroAbastecimientoCabecera;
   private Long oidTipoActuacion;

   public DTOEBuscarHDDetalleFlag() {
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

   public Long getOidTipoActuacion()
   {
      return oidTipoActuacion;
   }

   public void setOidTipoActuacion(Long oidTipoActuacion)
   {
      this.oidTipoActuacion = oidTipoActuacion;
   }
}