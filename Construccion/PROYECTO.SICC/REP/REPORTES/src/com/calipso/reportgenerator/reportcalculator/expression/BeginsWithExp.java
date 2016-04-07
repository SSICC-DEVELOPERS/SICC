package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Expresi�n binaria que se utiliza para saber si el valor de una expresi�n comienza
 * con el valor de otra
 */

public class BeginsWithExp extends BinaryExp implements Serializable {

  /**
   * Crea una expresi�n asignando las sub expresiones
   * @param expression
   * @param expression1
   */
  public BeginsWithExp(Expression expression, Expression expression1) {
    super(expression, expression1);
  }

  /**
   * Resuelve la representaci�n en texto
   * @return
   */
  protected String basicAsString() {
    return getLeft().basicAsString() + " LIKE " + getRight().basicAsString() + "%";
  }

  /**
   * Resoluci�n del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processBeginsWith(this);
  }
}
