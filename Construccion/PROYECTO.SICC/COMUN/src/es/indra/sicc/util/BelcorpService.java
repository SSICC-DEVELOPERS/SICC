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

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.mare.common.mii.services.jdbcservice.DBService;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.rep.service.CalipsoService;

import org.apache.commons.logging.Log;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:        MII
 * Fecha:             12/03/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-MAE-005-210
 *                    MAE Paquete Configuración  Maestro de Materiales
 *                    (Subido al portal el 06/03/2003)
 * Descripcion:       Clase implementada de acuerdo al patrón de diseño
 *                    Singleton con el objetivo de acceder a los servicios
 *                    proporcionados por Mare.
 * @version           1.1
 * @autor             Pablo Iorio
 */
public final class BelcorpService {
   final static String NOMBRE_SERVICIO_EJBLOCATOR = "EJBLocator";
   final static String NOMBRE_SERVICIO_DBSERVICE = "JDBCService";
   final static String NOMBRE_SERVICIO_LOGGINGSERVICE = "LoggingService";
   final static String NOMBRE_SERVICIO_APPLOGGINGSERVICE = "APPLoggingService";
   final static String NOMBRE_SERVICIO_CALIPSOSERVICE = "CalipsoService";
   final static MareCredentials mareCredentials = null;
   private static BelcorpService instance = null;
   public EJBLocator ejbLocator = null;
   public CalipsoService calipsoService = null;
   public DBService dbService = null;
   public Log log = null;
   //public Logger appLog = null;

   private BelcorpService() throws MareMiiServiceNotFoundException {
      try {
         ejbLocator = (EJBLocator) MareMii.getService(new MareTopic(
                  NOMBRE_SERVICIO_EJBLOCATOR, mareCredentials));

         dbService = (DBService) MareMii.getService(new MareTopic(
                  NOMBRE_SERVICIO_DBSERVICE, mareCredentials));

         log = ((LoggingService) MareMii.getService(new MareTopic(
                  NOMBRE_SERVICIO_LOGGINGSERVICE, mareCredentials))).getMareLog();
         /*appLog = ((APPLoggingService) MareMii.getService(new MareTopic(
                  NOMBRE_SERVICIO_APPLOGGINGSERVICE, mareCredentials))).getMareLog();*/
         //appLog = LogAPP.getInstance().obtenerLog();
         
         calipsoService = (CalipsoService) MareMii.getService(new MareTopic(
                  NOMBRE_SERVICIO_CALIPSOSERVICE, mareCredentials));
      } catch (MareMiiServiceNotFoundException miie) {
         UtilidadesLog.error(miie);
         throw miie;
      }
   }

    public static BelcorpService getInstance()throws MareMiiServiceNotFoundException {
        if (instance == null) {
            instance = new BelcorpService();
        }        
        return instance;
    }
}
