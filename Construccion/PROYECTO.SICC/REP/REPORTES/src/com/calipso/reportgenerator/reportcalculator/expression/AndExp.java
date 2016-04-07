package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresi�n binaria con operador AND
 */

public class AndExp extends BinaryExp implements Serializable {
  public AndExp(Expression expression, Expression expression1) {
    super(expression, expression1);
  }

  /**
   * Resuelva las particularidades de la representaci�n en texto con el operador AND
   * @return
   */
  protected String asStringUnderAnd() {
    return basicAsString();
  }

  /**
   * Resuelve la representaci�n en texto
   * @return
   */
  protected String basicAsString() {
    return getLeft().asStringUnderAnd() + " AND " + getRight().asStringUnderAnd();
  }

  /**
   * Resoluci�n del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processAnd(this);
  }
}
