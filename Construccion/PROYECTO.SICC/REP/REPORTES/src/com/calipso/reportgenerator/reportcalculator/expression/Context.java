package com.calipso.reportgenerator.reportcalculator.expression;

import java.util.HashMap;
import java.io.Serializable;

/**
 * Diccionario que sirve de valuación para las expresiones
 * Contiene todos los valores por los que se reemplazarán las VariableExp
 */

public class Context implements Serializable {
  HashMap content;

  /**
   * Crea un nuevo objeto Context
   */
  public Context() {
    content = new HashMap();
  }

  /**
   * Devuelve el valor asociado a una referencia (la referencia es la que se asoció previamente a una VariableEx)
   * @param reference
   * @return
   */
  public Object valueFor(Object reference) {
    return content.get(reference);
  }

  /**
   * Asigna el valor asociado a una referencia
   * @param key
   * @param value
   */
  public void add(Object key, Object value) {
    content.put(key, value);
  }
}
