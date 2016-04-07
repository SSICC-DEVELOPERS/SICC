package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresión que devuelve el valor contrario a la subexpresión que contiene
 *
 */

public class NotExp extends Expression implements Serializable {

  /**
   * Crea una expresión con el operador NOT a partir de otra expresión
   * @param expression
   */
  public NotExp(Expression expression) {
    initialize();
    arguments[0] = expression;
  }

  /**
   * Inicializa el array de argumentos de tamaño 1 porque solo almacenará la expresión a la que se le desea
   * invertir el valor de resultado
   */
  protected void initialize() {
    arguments = new Expression[1];
  }

  /**
   * Resuelve al representación en texto
   * @return
   */

  protected String basicAsString() {
    return "NOT " + internalExp().asStringUnderNot();
  }

  /**
   * Devuelve la expresión a la que se le aplica el operador NOT
   * @return
   */

  public Expression internalExp() {
    return arguments[0];
  }

  /**
   * Resolución del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processNot(this);
  }
}
