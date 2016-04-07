package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresión binaria que resuelve si los valores resultantes de la evaluación de dos sub expresiones
 * son iguales
 */

public class EqualTo extends BinaryExp implements Serializable {

  /**
   * Crea una expresión asignando las sub expresiones
   * @param expression
   * @param expression1
   */

  public EqualTo(Expression expression, Expression expression1) {
    super(expression, expression1);
  }

  /**
   * Resuelve la representación en texto
   * @return
   */

  protected String basicAsString() {
    return getLeft().basicAsString() + " = " + getRight().basicAsString();
  }

  /**
   * Resolución del pattern visitor
   * @param visitor
   * @return
   */

  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processEqualTo(this);
  }
}
