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
package es.indra.sicc.cra.util;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulingActividades {

   private static Scheduler uniqueInstance = null;
   private static int numero = 0;
   private static boolean started = false;

    private SchedulingActividades() throws MareException {
      UtilidadesLog.info("SchedulingActividades.SchedulingActividades():Entrada");
      try{
        //SchedulerSICC.getInstance();
        String urlmare = System.getProperty("MareConfigurationRoot") + "/services/quartz.properties";
        SchedulerFactory factory = new StdSchedulerFactory(urlmare);
        uniqueInstance = factory.getScheduler();
        if (!started){
            uniqueInstance.start();
            started = true;
        }
        UtilidadesLog.info("Instacia de Scheduler " + new java.util.Date());
      }catch(Exception e){
        UtilidadesLog.error(e);
        throw new MareException(e.getMessage());
      }
      UtilidadesLog.info("SchedulingActividades.SchedulingActividades():Salida");
    }
    
  public static Scheduler getScheduler(){
    UtilidadesLog.info("SchedulingActividades.getScheduler():Entrada");
    if(uniqueInstance==null){
      try {
        init();
      } catch (Exception ex) {
        UtilidadesLog.error(ex);
        
      }          
    }
    UtilidadesLog.info("SchedulingActividades.getScheduler():Salida");
    return uniqueInstance;
  }    
  
    private static void init()throws Exception{
        new SchedulingActividades();
  }
  
  public static void shutdownScheduler(){
    UtilidadesLog.info("SchedulingActividades.shutdownScheduler():Entrada");
      try {        
          uniqueInstance.shutdown();
      } catch (Exception ex) {
        UtilidadesLog.error(ex);
        
      }          
      started = false;
      UtilidadesLog.info("SchedulingActividades.shutdownScheduler():Salida");
  }
 

}  
