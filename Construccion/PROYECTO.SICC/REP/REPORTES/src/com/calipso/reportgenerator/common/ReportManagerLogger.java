package com.calipso.reportgenerator.common;

import org.apache.commons.logging.Log;

/**
 * Mantiene el log del report manager
 */
public class ReportManagerLogger {
  private static Log log;

  public static Log getLog() {
    return log;
  }

  public static void setLog(Log log) {
    ReportManagerLogger.log = log;
  }

  public static boolean isLogEnabled(){
    return (log != null);
  }

  public static void trace(Object o) {
    if (isLogEnabled()){
      log.trace(o);
    }
  }

  public static void trace(Object o, Throwable throwable) {
    if (isLogEnabled()){
      log.trace(o,throwable);
    }
  }

  public static void debug(Object o) {
    if (isLogEnabled()){
      log.debug(o);
    }
  }

  public static void debug(Object o, Throwable throwable) {
    if (isLogEnabled()){
      log.debug(o,throwable);
    }
  }

  public static void info(Object o) {
    if (isLogEnabled()){
      log.info(o);
    }
  }

  public static void info(Object o, Throwable throwable) {
    if (isLogEnabled()){
      log.info(o,throwable);
    }
  }

  public static void warn(Object o) {
    if (isLogEnabled()){
      log.warn(o);
    }
  }

  public static void warn(Object o, Throwable throwable) {
    if (isLogEnabled()){
      log.warn(o,throwable);
    }
  }

  public static void error(Object o) {
    if (isLogEnabled()){
      log.error(o);
    }
  }

  public static void error(Object o, Throwable throwable) {
    if (isLogEnabled()){
      log.error(o,throwable);
    }
  }

  public static void fatal(Object o) {
    if (isLogEnabled()){
      log.fatal(o);
    }
  }

  public static void fatal(Object o, Throwable throwable) {
    if (isLogEnabled()){
      log.fatal(o,throwable);
    }
  }
}
