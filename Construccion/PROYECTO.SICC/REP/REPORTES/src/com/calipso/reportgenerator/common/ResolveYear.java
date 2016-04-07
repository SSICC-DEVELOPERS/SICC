package com.calipso.reportgenerator.common;

import java.util.Calendar;

/**
 * Define el comportamiento para poder averiguar el valor de la año
 */
public class ResolveYear extends DateExpressionResolver {
  public ResolveYear() {
    super();
  }

  /**
   * Devuelve el año de la fecha previamente seteada
   * @return String
   */
  public String doGetValue() {
    return String.valueOf(getDateFormatter().getCalendar().get(Calendar.YEAR));
  }
}
