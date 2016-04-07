package com.calipso.reportgenerator.common;

import java.util.Calendar;

/**
 * Define el comportamiento para poder averiguar el valor de la semana
 */
public class ResolveWeek extends DateExpressionResolver {
  public ResolveWeek() {
    super();
  }

  /**
   * Devuelve la semana de la fecha previamente seteada
   * @return String
   */
  public String doGetValue() {
    return String.valueOf(getDateFormatter().getCalendar().get(Calendar.WEEK_OF_MONTH));
  }
}
