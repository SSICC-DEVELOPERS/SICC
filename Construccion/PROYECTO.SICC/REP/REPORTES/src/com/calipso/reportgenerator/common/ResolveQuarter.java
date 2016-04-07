package com.calipso.reportgenerator.common;

import java.util.Calendar;

/**
 * Define el comportamiento para poder averiguar el valor del cuatrimestre
 */
public class ResolveQuarter extends DateExpressionResolver {
  public ResolveQuarter() {
    super();
  }

  /**
   * Devuelve el cuatrimestre de la fecha previamente seteada
   * @return String
   */
  public String doGetValue() {
    int mes = Integer.parseInt(getMonth());
    int quarter = (mes / 4) + 1;
    return String.valueOf(quarter);
  }

  /**
   * Devuelve el mes actual
   * @return String
   */
  private String getMonth() {
    return String.valueOf(getDateFormatter().getCalendar().get(Calendar.MONTH) + 1);
  }
}
