package com.calipso.reportgenerator.common;


import java.util.Calendar;

/**
 * Define el comportamiento para poder averiguar el valor de la  quincena
 */
public class ResolveFortnight extends DateExpressionResolver {
  public ResolveFortnight() {
    super();
  }

  /**
   * * Devuelve la quincena de la fecha previamente seteada
   * @return String
   */
  public String doGetValue() {
    int value = getDateFormatter().getCalendar().get(Calendar.DATE) <= 15 ? 1 : 2;
    return String.valueOf(value);
  }
}
