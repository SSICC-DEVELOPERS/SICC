package com.calipso.reportgenerator.reportcalculator.arithmetic;

import java.util.Map;
import java.io.Serializable;

/**
 * Representa una constante de la expression.
 */

public class ConstantArithmeticExp extends ValueArithmeticExp implements Serializable{
  private float value;

  /**
   * Inicializa una instancia de <code>ConstantArithmeticExp</code>
   * @param value
   */
  public ConstantArithmeticExp(float value) {
    this.value = value;
  }

  /**
   * Retorna el valor.
   * @param context
   * @return
   */
  public float value(Map context) {
    return value;
  }

  /**
   * Metodo toString de la clase
   * @return
   */
  public String toString() {
    return String.valueOf(value);
  }
}
