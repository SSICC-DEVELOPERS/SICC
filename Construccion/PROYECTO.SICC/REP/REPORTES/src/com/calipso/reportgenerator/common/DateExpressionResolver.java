package com.calipso.reportgenerator.common;

import es.indra.mare.common.info.InfoException;

import java.util.Date;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.text.DateFormat;
import com.calipso.common.DateEx;

/**
 * Esta clase se encarga de resolver las expresiones que generan las columnas calculadas de fechas
 */
public abstract class DateExpressionResolver {


  public static String DAY = "DAY";
  public static String WEEK = "WEEK";
  public static String YEAR = "YEAR";
  public static String QUARTER = "QUARTER";
  public static String FORTNIGTH = "FORTNIGTH";
  public static String MONTH = "MONTH";
  public static String SEMESTRE = "SEMESTRE";
  private static Map resolvers;

  private DateFormat dateFormatter;
  private String datePattern;
  private Calendar cal;

  private static String defaultDatePattern = "dd/MM/yyyy";

  /**
   * Retorna un HashMap que contiene los mecanismos para resolver cada una de las funciones
   * @return Map
   */
  private static Map getResolvers() {
    if (resolvers == null) {
      resolvers = new HashMap();
      resolvers.put(DAY, new ResolveDay());
      resolvers.put(WEEK, new ResolveWeek());
      resolvers.put(SEMESTRE, new ResolveSemestre());
      resolvers.put(YEAR, new ResolveYear());
      resolvers.put(MONTH, new ResolveMonth());
      resolvers.put(FORTNIGTH, new ResolveFortnight());
      resolvers.put(QUARTER, new ResolveQuarter());
    }
    return resolvers;
  }

  /**
   * Crea e inicializa un <code>DateExpressionResolver</code>
   */
  public DateExpressionResolver() {
    datePattern = defaultDatePattern;
  }

  /**
   * Retorna un objeto Calendar
   * @return Calendar
   */
  public Calendar getCal() {
    return cal;
  }

  /**
   * Asigna la fecha a partir de una dateString y un datePattern
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setDate(String dateString, String datePattern) throws InfoException {
    /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    String dateFormat = "yyyyMMdd";
    int length= (dateString).length();
    if ( length == 8 ){
      dateFormat = "yyyyMMdd";
    }else if ( length == 15 ){
      dateFormat = "yyyyMMddHHmmssSSS";
    }
    simpleDateFormat.applyPattern(dateFormat);
    Date date = null;*/
    Date date = (new DateEx(dateString, datePattern)).getDate();
    //try {
    Calendar calHoy = Calendar.getInstance();
    calHoy.setTime(new Date());
    cal = (Calendar) calHoy.clone();
    //date = simpleDateFormat.parse(dateString);
    dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
    dateFormatter.setCalendar(cal);
    cal.setTime(date);
    /*} catch (ParseException e) {
      throw new InfoException(LanguageTraslator.traslate("77"), e);
    }*/
  }

  /**
   * Retorna el objeto DateFormat correspondiente
   * @return DateFormat
   */
  public DateFormat getDateFormatter() {
    return dateFormatter;
  }

  /**
   * Retorna un String que representa el formato de la Fecha
   * @return String
   */
  public String getDatePattern() {
    return datePattern;
  }

  /**
   * Asigna un String que representa el formato de la Fecha al atributo datePattern
   */
  public void setDatePattern(String datePattern) {
    this.datePattern = datePattern;
  }


  /**
   * Devuelve el valor dependiendo de  su clave
   DAY
   WEEK
   YEAR
   QUARTER
   FORTNIGTH
   MONTH
   SEMESTRE
   */

  public String getValue(String dateValue) throws InfoException {
    setDate(dateValue, getDatePattern());
    return doGetValue();
  };
  /**
   * Método abstracto que se sobrescribe para cada tipo
   * @return
   */
  protected abstract String doGetValue();

  /**
   * Obtiene el valor de la función dateFunction , utilizando el datePatern por default dd/MM/yyyy
   * @throws es.indra.mare.common.info.InfoException
   */
  public static String Resolve(String dateFunction, String dateValue) throws InfoException {
    DateExpressionResolver resolver = (DateExpressionResolver) getResolvers().get(dateFunction);
    return resolver.getValue(dateValue);
  }

  /**
   * Obtiene el valor de la función dateFunction , utilizando el datePatern nuevo
   * @throws es.indra.mare.common.info.InfoException
   */
  public static String Resolve(String dateFunction, String dateValue, String datePattern) throws InfoException {
    DateExpressionResolver resolver = (DateExpressionResolver) getResolvers().get(dateFunction);
    resolver.setDatePattern(datePattern);
    return resolver.getValue(dateValue);
  }

  /**
   * Obtiene el valor de la función dateFunction , utilizando el datePatern nuevo
   * @throws es.indra.mare.common.info.InfoException
   */
  public static String Resolve(String dateFunction, Date date) throws InfoException {
    DateExpressionResolver resolver = (DateExpressionResolver) getResolvers().get(dateFunction);
    resolver.dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
    resolver.cal = Calendar.getInstance();
    resolver.dateFormatter.setCalendar(resolver.cal);
    resolver.cal.setTime(date);
    return resolver.doGetValue();
  }

}
