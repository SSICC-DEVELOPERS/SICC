package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresión binaria que determina si el valor resultante de evaluar una expresión el mayor o igual
 * que el valor resultante de evaluar el valor de la otra
 */


public class GreaterOrEqualTo extends BinaryExp implements Serializable {

  /**
   * Crea una expresión asignando las sub expresiones
   * @param expression
   * @param expression1
   */

  public GreaterOrEqualTo(Expression expression, Expression expression1) {
    super(expression, expression1);
  }

  /**
   * Resuelve la representación en texto
   * @return
   */

  protected String basicAsString() {
    return getLeft().basicAsString() + " >= " + getRight().basicAsString();
  }

  /**
   * Resolución del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processGreaterOrEqualTo(this);
  }
}
