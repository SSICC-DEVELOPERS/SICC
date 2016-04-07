package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;


/**
 * Representa una expresión binaria con operador OR
 */
public class OrExp extends BinaryExp implements Serializable {
  public OrExp(Expression expression, Expression expression1) {
    super(expression, expression1);
  }

  /**
   * Resuelva las particularidades de la representación en texto con el operador OR
   * @return
   */

  protected String asStringUnderOr() {
    return basicAsString();
  }

  /**
   * Resuelve la representación en texto
   * @return
   */

  protected String basicAsString() {
    return getLeft().asStringUnderOr() + " OR " + getRight().asStringUnderOr();
  }

  /**
   * Resolución del pattern visitor
   * @param visitor
   * @return
   */

  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processOr(this);
  }
}
