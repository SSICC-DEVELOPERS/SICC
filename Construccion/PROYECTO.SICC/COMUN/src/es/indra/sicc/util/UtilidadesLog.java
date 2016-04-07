package es.indra.sicc.util;

import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;

import org.apache.commons.logging.Log;

public class UtilidadesLog {
    /*
    * Obtengo un Login Service
    */
    private static Log loggingService;

    static {
        try {
            if (loggingService == null) {
                loggingService = (((LoggingService)MareMii.getService(new MareTopic(MareMii.SERVICE_LOGGING))).getMareLog());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo obtener el objeto Log");
        }
    }

    public static void info(Object log) {
        try {
            //if (loggingService.isInfoEnabled()) {
                loggingService.info(log);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void info(Object log, Throwable th) {
        try {
            //if (loggingService.isInfoEnabled()) {
                loggingService.info(log, th);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void debug(Object log) {
        //loggingService.debug(log);
        try {
            //if (loggingService.isDebugEnabled()) {
                loggingService.debug(log);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void debug(Object log, Throwable th) {
        //loggingService.debug(log,th);
        try {
            //if (loggingService.isDebugEnabled()) {
                loggingService.debug(log, th);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void error(Object log) {
        //loggingService.error(log);
        try {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error(log);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void error(Object log, Throwable th) {
        //loggingService.error(log,th);
        try {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error(log, th);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void fatal(Object log) {
        try {
            //if (loggingService.isFatalEnabled()) {
                loggingService.fatal(log);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void fatal(Object log, Throwable th) {
        try {
            //if (loggingService.isFatalEnabled()) {
                loggingService.fatal(log, th);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void warn(Object log) {
        try {
            //if (loggingService.isWarnEnabled()) {
                loggingService.warn(log);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    public static void warn(Object log, Throwable th) {
        try {
            //if (loggingService.isWarnEnabled()) {
                loggingService.warn(log, th);
            //}
        } catch (Exception e) {
            //if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            //}
        }
    }

    /*
    * Se fija que modo de logueo se esta utilizando y utiliza ese para dejar
    * el log
    */

    public static void log(Object log) {
        if (loggingService.isInfoEnabled()) {
            info(log);
        } else if (loggingService.isDebugEnabled()) {
            debug(log);
        } /*else if (loggingService.isErrorEnabled()) {
         error(log);
      } else if (loggingService.isFatalEnabled()) {
         fatal(log);
      } else if (loggingService.isWarnEnabled()) {
         warn(log);
      }*/
    }

    /*
    * Se fija que modo de logueo se esta utilizando y utiliza ese para dejar
    * el log
    */

    public static void log(Object log, Throwable th) {
        if (loggingService.isInfoEnabled()) {
            info(log, th);
        } else if (loggingService.isDebugEnabled()) {
            debug(log, th);
        } /* else if (loggingService.isErrorEnabled()) {
         error(log, th);
      } else if (loggingService.isFatalEnabled()) {
         fatal(log, th);
      } else if (loggingService.isWarnEnabled()) {
         warn(log, th);
      }*/
    }
    
    public Boolean isDebugEnabled(){
        return loggingService.isDebugEnabled();
    }
    
    public Boolean isInfoEnabled(){
        return loggingService.isInfoEnabled();
    }
    
    public Boolean isErrorEnabled(){
        return loggingService.isErrorEnabled();
    }
    
    
    public Boolean isFatalEnabled(){
        return loggingService.isFatalEnabled();
    }
    
    public Boolean isWarnEnabled(){
        return loggingService.isWarnEnabled();
    }
    
    
    
}
