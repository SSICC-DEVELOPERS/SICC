package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresi�n que devuelve el valor contrario a la subexpresi�n que contiene
 *
 */

public class NotExp extends Expression implements Serializable {

  /**
   * Crea una expresi�n con el operador NOT a partir de otra expresi�n
   * @param expression
   */
  public NotExp(Expression expression) {
    initialize();
    arguments[0] = expression;
  }

  /**
   * Inicializa el array de argumentos de tama�o 1 porque solo almacenar� la expresi�n a la que se le desea
   * invertir el valor de resultado
   */
  protected void initialize() {
    arguments = new Expression[1];
  }

  /**
   * Resuelve al representaci�n en texto
   * @return
   */

  protected String basicAsString() {
    return "NOT " + internalExp().asStringUnderNot();
  }

  /**
   * Devuelve la expresi�n a la que se le aplica el operador NOT
   * @return
   */

  public Expression internalExp() {
    return arguments[0];
  }

  /**
   * Resoluci�n del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processNot(this);
  }
}
