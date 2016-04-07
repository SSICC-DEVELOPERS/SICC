package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresi�n binaria que resuelve si los valores resultantes de la evaluaci�n de dos sub expresiones
 * son iguales
 */

public class EqualTo extends BinaryExp implements Serializable {

  /**
   * Crea una expresi�n asignando las sub expresiones
   * @param expression
   * @param expression1
   */

  public EqualTo(Expression expression, Expression expression1) {
    super(expression, expression1);
  }

  /**
   * Resuelve la representaci�n en texto
   * @return
   */

  protected String basicAsString() {
    return getLeft().basicAsString() + " = " + getRight().basicAsString();
  }

  /**
   * Resoluci�n del pattern visitor
   * @param visitor
   * @return
   */

  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processEqualTo(this);
  }
}
