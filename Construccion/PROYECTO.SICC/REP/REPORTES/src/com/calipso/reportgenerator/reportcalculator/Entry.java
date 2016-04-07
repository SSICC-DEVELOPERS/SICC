package com.calipso.reportgenerator.reportcalculator;

import java.util.Map;

/**
 * Asociación Clave-Valor
 */
public class Entry implements Map.Entry, Comparable {
  Object key;
  Object value;

  public Entry(Object key, Object value) {
    this.key = key;
    this.value = value;
  }

  public Object getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }

  public Object setValue(Object value) {
    if (value == null)
      throw new NullPointerException();

    Object oldValue = this.value;
    this.value = value;
    return oldValue;
  }

  public String toString() {
    return key.toString() + "=" + value.toString();
  }

  public int compareTo(Object o) {
    return key.toString().compareTo(o.toString());
  }
}
