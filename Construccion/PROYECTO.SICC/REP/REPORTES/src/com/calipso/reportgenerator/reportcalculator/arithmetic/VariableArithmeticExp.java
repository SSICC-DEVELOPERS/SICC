package com.calipso.reportgenerator.reportcalculator.arithmetic;

import com.calipso.reportgenerator.reportcalculator.arithmetic.ValueArithmeticExp;

import java.util.Map;
import java.util.Collection;
import java.io.Serializable;

/**
 * Representa una variable de la expresion a resolver.
 */

public class VariableArithmeticExp extends ValueArithmeticExp implements Serializable{
  private String name;

  /**
   * Crea una instancia de <code>VariableArithmeticExp</code>.
   * @param name
   */
  public VariableArithmeticExp(String name) {
    this.name = name;
  }

  /**
   * Retorna un valor float a partir de un nombre.
   * @param context
   * @return
   */
  public float value(Map context) {
    return ((Float) context.get(name)).floatValue();
  }

  /**
   * Metodo toString de la clase.
   * @return
   */
  public String toString() {
    return "#" + name;
  }

  /**
   * Agrega un nombre a la coleccion.
   * @param variables
   */
  public void getVariables(Collection variables) {
    variables.add(name);
  }
}
