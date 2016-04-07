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


/**
 * Sistema:         Belcorp
 * Modulo:          COMUN
 * Submódulo:       Utils
 * Componente:      DTO's
 * Fecha:           11/2/2004
 * Observaciones:
 *
 * @version         1.0
 * @autor           Rodrigo Falcó
 */
public class DTOBoolean extends DTOAuditableSICC {
   private boolean valor;

   public DTOBoolean() {
   }

   public boolean getValor() {
      return valor;
   }

   public void setValor(boolean newValor) {
      valor = newValor;
   }
}
