/*
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

import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.helper.ServicesHelper;
import es.indra.mare.common.mii.services.localization.LocalizationService;

import org.apache.avalon.excalibur.i18n.Resources;

import org.apache.commons.logging.Log;

import java.util.Locale;
import java.util.MissingResourceException;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:        ErrorManager
 * Fecha:             29/05/2003
 * Descripcion:       Internacionalizaci&oacute;n de mensajes de error.
 *
 * @version           1.0
 * @autor             Diego Javier Grigna
 */
public class ErrorManager {
   //    public static Log log = null;

   /*    static {

           try {
             log = ServicesHelper.getLogService();
           } catch( MareMiiServiceNotFoundException e) {
             System.err.println(
               "ErrorManager: No se pudo inicializar el servicio de log: " +
               e.getMessage());
             e.UtilidadesLog.error(System.err);
           }

       }*/
   public ErrorManager() {
   }

   public static String getErrorMessage(int code, String language,
      String country) {
      try {
         LocalizationService localizationService = (LocalizationService) MareMii.getService(new MareTopic(
                  "LocalizationService", null));
         Resources resources = localizationService.createResource(new Locale(
                  language, country));

         try {
            return resources.getString(Integer.toString(code));
         } catch (MissingResourceException e) {
            /*          log.error( "No se puede obtener el recurso, Exception: " +
                                 e.getMessage() +
                                 ", codigo=" + code +
                                 ", lenguaje=" + language +
                                 ", pais=" + country, e);*/
         }
      } catch (MareMiiServiceNotFoundException e) {
         /*          log.error( "Error al inicializar el servicio i18n: " +
                              e.getMessage() +
                              ", codigo=" + code +
                              ", lenguaje=" + language +
                              ", pais=" + country, e);*/
      }

      return null;
   }

   public static void main(String[] args) {
      String msgErr = getErrorMessage(Integer.parseInt(args[0]), args[1],
            args[2]);

      UtilidadesLog.debug("Error: " + msgErr);
   }
}
