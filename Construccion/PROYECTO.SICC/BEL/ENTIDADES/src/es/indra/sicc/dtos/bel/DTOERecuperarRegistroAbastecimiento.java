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

public class DTOERecuperarRegistroAbastecimiento extends DTOSiccPaginacion {
   
   private Long subacceso;
   private Long estado;
   private Boolean indicadorSAP;
   
   public DTOERecuperarRegistroAbastecimiento() {
      super();
   }

   public Long getSubacceso()
   {
      return subacceso;
   }

   public void setSubacceso(Long subacceso)
   {
      this.subacceso = subacceso;
   }

   public Long getEstado()
   {
      return estado;
   }

   public void setEstado(Long estado)
   {
      this.estado = estado;
   }

   public Boolean getIndicadorSAP()
   {
      return indicadorSAP;
   }

   public void setIndicadorSAP(Boolean indicadorSAP)
   {
      this.indicadorSAP = indicadorSAP;
   }
}