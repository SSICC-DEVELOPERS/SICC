package com.calipso.reportgenerator.reportcalculator.arithmetic;

import com.calipso.reportgenerator.reportcalculator.arithmetic.ArithmeticExpression;
import com.calipso.reportgenerator.reportcalculator.arithmetic.ConstantArithmeticExp;

import java.io.Serializable;


/**
 * Representa un valor de la expresion.
 */

public abstract class ValueArithmeticExp extends ArithmeticExpression implements Serializable{

  /**
   * Crea una variable o una constante dependiendo del String
   * recibido por parametro.
   * @param token
   * @return
   */
  public static ArithmeticExpression newValueExpFrom(String token) {
    if (token.charAt(0) == '#') {
      return new VariableArithmeticExp(token.substring(1, token.length()));
    } else {
      return new ConstantArithmeticExp(Float.valueOf(token).floatValue());
    }
  }
}
