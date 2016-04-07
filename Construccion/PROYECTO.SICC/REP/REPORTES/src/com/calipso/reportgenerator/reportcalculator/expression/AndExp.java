package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresión binaria con operador AND
 */

public class AndExp extends BinaryExp implements Serializable {
  public AndExp(Expression expression, Expression expression1) {
    super(expression, expression1);
  }

  /**
   * Resuelva las particularidades de la representación en texto con el operador AND
   * @return
   */
  protected String asStringUnderAnd() {
    return basicAsString();
  }

  /**
   * Resuelve la representación en texto
   * @return
   */
  protected String basicAsString() {
    return getLeft().asStringUnderAnd() + " AND " + getRight().asStringUnderAnd();
  }

  /**
   * Resolución del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processAnd(this);
  }
}
