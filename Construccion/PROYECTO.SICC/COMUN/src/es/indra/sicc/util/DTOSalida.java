/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.util;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.io.Serializable;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:        DTO
 * Fecha:             12/03/2003
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes SICC-DMCO-MAE-005-210
 *                    MAE Paquete Configuraci�n  Maestro de Clientes
 *                    (Subido al portal el 06/03/2003)
 * Descripcion:       DTO que encapsula informaci�n de salida
 * @version           1.0
 * @autor             Ver�nica Iturrioz
 */
public class DTOSalida extends DTOBelcorp {
   private RecordSet resultado;

   public DTOSalida() {
      super();
   }

   public DTOSalida(RecordSet resultado) {
      super();
      this.resultado = resultado;
   }

   public void setResultado(RecordSet resultado) {
      this.resultado = resultado;
   }

   public RecordSet getResultado() {
      return this.resultado;
   }
}
