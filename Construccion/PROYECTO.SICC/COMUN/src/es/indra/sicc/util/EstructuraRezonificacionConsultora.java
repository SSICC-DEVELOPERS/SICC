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


/**
 * Sistema:           Belcorp
 * Modulo:            ZON
 * Subm�dulo:         Zonificaci�n
 * Componente:        DTO's
 * Fecha:             07/04/2003
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes SICC-DMCO-ZON-001-240
 *                    (Subido al portal el 01/04/2003)
 * @version           1.0
 * @autor             Ver�nica Iturrioz
 */
public class EstructuraRezonificacionConsultora extends DTOBelcorp {
   private String zonaOrigen;
   private String zonaDestino;
   private String consultora;

   public EstructuraRezonificacionConsultora() {
      super();
   }

   public String getZonaOrigen() {
      return zonaOrigen;
   }

   public void setZonaOrigen(String newZonaOrigen) {
      zonaOrigen = newZonaOrigen;
   }

   public String getZonaDestino() {
      return zonaDestino;
   }

   public void setZonaDestino(String newZonaDestino) {
      zonaDestino = newZonaDestino;
   }

   public String getConsultora() {
      return consultora;
   }

   public void setConsultora(String newConsultora) {
      consultora = newConsultora;
   }
}
