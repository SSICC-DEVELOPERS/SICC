package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresión constante con valor TRUE
 */

public class TrueExp extends ConstantExp implements Serializable {

  /**
   * Crea una expresión con valor TRUE
   */
  public TrueExp() {
    value = new Boolean(true);
  }

  /**
   * Crea una expresión constante aplicándole el operador NOT
   * @return
   */
  public Expression newNot() {
    return new FalseExp();
  }

  /**
   * Devuelve el valor de la expresión (en esta caso siempre true)
   * @return
   */
  public Object value() {
    return new Boolean(true);
  }


  /**
   * Devuelve verdadero porque esta expresión representa al valor TRUE
   * @return
   */
  public boolean isTrue() {
    return true;
  }

  /**
   * Devuelve la expresión que se recibe como parámetro porque TRUE and X = X
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
