package com.calipso.reportgenerator.common;

import java.util.Calendar;

/**
 *  Define el comportamiento para poder averiguar el valor del d�a
 */
public class ResolveDay extends DateExpressionResolver {
  public ResolveDay() {
    super();
  }

  /**
   * Devuelve el d�a de la fecha previamente seteada
   * @return String
   */
  public String doGetValue() {
    return String.valueOf(getDateFormatter().getCalendar().get(Calendar.DATE));
  }
}
