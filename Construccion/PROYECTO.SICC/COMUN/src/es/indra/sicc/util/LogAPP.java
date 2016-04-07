package es.indra.sicc.util;

import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.logging.Log;

public class LogAPP {
    private static Log loggingService = null;

    static {
        try {
            Configuration conf = MareMii.getServiceConfiguration("APPLoggingService");
            String logName = conf.getString("logName");
            loggingService = (((LoggingService)MareMii.getService(new MareTopic("APPLoggingService"))).getMareLog(logName));
            conf=null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO SE PUDO CREAR EL LOGAPP POR ERROR EN LA CONFIGURACION");
            //throw new RuntimeException("NO se pudo inicializar el log APP");
        }
    }


    public void shutdown() {
        loggingService = null;
    }

    public static void info(Object log) {
        try {
            if (loggingService.isInfoEnabled()) {
                loggingService.warn(log);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void info(Object log, Throwable th) {
        try {
            if (loggingService.isInfoEnabled()) {
                loggingService.warn(log, th);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void debug(Object log) {
        try {
            if (loggingService.isDebugEnabled()) {
                loggingService.warn(log);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void debug(Object log, Throwable th) {
        try {
            if (loggingService.isDebugEnabled()) {
                loggingService.warn(log, th);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void error(Object log) {
        try {
            if (loggingService.isErrorEnabled()) {
                loggingService.warn(log);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void error(Object log, Throwable th) {
        try {
            if (loggingService.isErrorEnabled()) {
                loggingService.warn(log, th);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void fatal(Object log) {
        try {
            if (loggingService.isFatalEnabled()) {
                loggingService.warn(log);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void fatal(Object log, Throwable th) {
        try {

            if (loggingService.isFatalEnabled()) {
                loggingService.warn(log, th);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void warn(Object log) {
        try {
            if (loggingService.isWarnEnabled()) {
                loggingService.warn(log);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }

    public static void warn(Object log, Throwable th) {
        try {
            if (loggingService.isWarnEnabled()) {
                loggingService.warn(log, th);
            }
        } catch (Exception e) {
            if (loggingService.isErrorEnabled()) {
                loggingService.error("Mensaje demasiado largo para loguear", e);
            }
        }
    }
}
