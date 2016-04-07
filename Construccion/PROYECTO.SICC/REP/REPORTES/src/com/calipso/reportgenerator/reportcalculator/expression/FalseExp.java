package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresi�n constante con valor FALSE
 */

public class FalseExp extends ConstantExp implements Serializable {

  /**
   * Crea una expresion con valor FALSE
   */
  public FalseExp() {
    value = new Boolean(false);
  }

  /**
   * Crea una expresi�n constante aplicandole el operador NOT
   * @return
   */
  public Expression newNot() {
    return new TrueExp();
  }

  /**
   * Devuelve el valor de la expresi�n (en esta caso siempre false)
   * @return
   */
  public Object value() {
    return new Boolean(false);
  }

  /**
   * Deveulve verdadero porque esta expresi�n representa al valor FALSE
   * @return
   */
  public boolean isFalse() {
    return true;
  }

  /**
   * Se devuelve a si misma porque FALSE AND X = FALSE
   * @param expression
   * @return
   */
  protected Expression basicAnd(Expression expression) {
    return this;
  }

  /**
   * Devuelve la expresi�n que se recibe como par�metro porque FALSE or X = X
   * @param expression
   * @return
   */
  protected Expression basicOr(Expression expression) {
    return expression;
  }

}
