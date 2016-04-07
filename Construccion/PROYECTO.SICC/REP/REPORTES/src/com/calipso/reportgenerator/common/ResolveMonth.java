package com.calipso.reportgenerator.common;

import java.util.Calendar;

/**
 * Define el comportamiento para poder averiguar el valor del Mes
 */
public class ResolveMonth extends DateExpressionResolver {

  public ResolveMonth() {
    super();
  }

  /**
   * Devuelve el mes de la fecha previamente seteada
   * @return String
   */
  public String doGetValue() {
    return String.valueOf(getDateFormatter().getCalendar().get(Calendar.MONTH) + 1);
  }
}
