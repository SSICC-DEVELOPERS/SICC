package com.calipso.reportgenerator.common;

/**
 * Toma una expresión y dice cuál se debe utilizar en la dimensión como base
 * */

public class DateExpressionParser {

  public String expression;

  /**
   * Crea un objeto DateExpressionParser
   */
  public DateExpressionParser() {
  }

  /**Inicializa una expresion a utilizar
   * @param expression
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }


  /**
   * Retorna el string fieldName(nombre de la dimension)
   * @return
   */
  public String getFieldName() {
    return expression.substring(expression.indexOf("(") + 1, expression.lastIndexOf(")"));
  }

  /**
   * Devuelve el tipo de función seleccionada
   DAY
   WEEK
   YEAR
   QUARTER
   FORTNIGTH
   MONTH
   SEMESTRE
   * @return
   */
  public String getDateFunction() {
    String str;
    str = expression.substring(0, expression.indexOf("("));
    return str;
  }
}
