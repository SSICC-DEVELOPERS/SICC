package com.calipso.reportgenerator.common;

import java.util.Calendar;

/**
 * Define el comportamiento para poder averiguar el valor del semestre
 */
public class ResolveSemestre extends DateExpressionResolver {
  public ResolveSemestre() {
    super();
  }

  public String doGetValue() {
    return String.valueOf(getSemestre());
  }

  /**
   * Devuelve el semestre de la fecha previamente seteada
   * @return String
   */
  private int getSemestre() {
    return super.getDateFormatter().getCalendar().get(Calendar.MONTH) <= 6 ? 1 : 2;
  }
}
