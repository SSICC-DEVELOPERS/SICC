package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresi�n constante con valor TRUE
 */

public class TrueExp extends ConstantExp implements Serializable {

  /**
   * Crea una expresi�n con valor TRUE
   */
  public TrueExp() {
    value = new Boolean(true);
  }

  /**
   * Crea una expresi�n constante aplic�ndole el operador NOT
   * @return
   */
  public Expression newNot() {
    return new FalseExp();
  }

  /**
   * Devuelve el valor de la expresi�n (en esta caso siempre true)
   * @return
   */
  public Object value() {
    return new Boolean(true);
  }


  /**
   * Devuelve verdadero porque esta expresi�n representa al valor TRUE
   * @return
   */
  public boolean isTrue() {
    return true;
  }

  /**
   * Devuelve la expresi�n que se recibe como par�metro porque TRUE and X = X
   * @param expression
   * @return
   */
  protected Expression basicAnd(Expression expression) {
    return expression;
  }

  /**
   * Se devuelve a si misma porque TRUE or X = TRUE
   * @param expression
   * @return
   */
  protected Expression basicOr(Expression expression) {
    return this;
  }
}
