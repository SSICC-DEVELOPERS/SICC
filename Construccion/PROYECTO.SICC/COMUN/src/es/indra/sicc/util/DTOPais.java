/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.util;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOBelcorp;

import java.io.Serializable;

import java.util.HashMap;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:        DTO
 * Fecha:             07/05/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-PRE-001-211
 * Descripcion:       DTO que encapsula información de Pais
 * @version           1.0
 * @autor             Verónica Iturrioz
 */
public class DTOPais extends DTOAuditableSICC {
   private Long pais;
   private Byte longitudCodigoClientePais;
   private HashMap descripcionesPais;

   public DTOPais() {
      super();
   }

   public DTOPais(Long pais) {
      super();
      this.pais = pais;
   }

   public Long getPais() {
      return pais;
   }

   public void setPais(Long newPais) {
      pais = newPais;
   }

   public Byte getLongitudCodigoClientePais() {
      return longitudCodigoClientePais;
   }

   public void setLongitudCodigoClientePais(Byte newLongitudCodigoClientePais) {
      longitudCodigoClientePais = newLongitudCodigoClientePais;
   }

   public HashMap getDescripcionesPais() {
      return descripcionesPais;
   }

   public void setDescripcionesPais(HashMap newDescripcionesPais) {
      descripcionesPais = newDescripcionesPais;
   }
}
