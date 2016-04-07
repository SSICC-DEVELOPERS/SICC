package com.calipso.reportgenerator.reportcalculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.io.Serializable;

/**
 * Administra las distintias instancias de Float
 */

public class SharedFloat implements Serializable, Comparable, CubeValue {

  private Float value;
  static final private HashMap floats = new HashMap(5003, 0.80f);

  public SharedFloat(Float value) {
    this.value = value;
    floats.put(value, this);
  }

  public static SharedFloat newFrom(Float aFloat) {
    Object o = floats.get(aFloat);
    if(o == null) {
      return new SharedFloat(aFloat);
    } else {
      return (SharedFloat) o;
    }
  }

  public static SharedFloat newFrom(float theFloat) {
    Float aFloat = new Float(theFloat);
    return newFrom(aFloat);
  }

  public float floatValue() {
    return value.floatValue();
  }

  public String toString() {
    return value.toString();
  }

  public int compareTo(Object o) {
    if(o instanceof Float){
      return value.compareTo((Float)o);
    }else if(o instanceof SharedFloat){
      return value.compareTo(((SharedFloat)o).value);
    }else{
      return -1;
    }
  }

  public Object getValue() {
    return value;
  }

  public SharedFloat add(float aValue) {
    return SharedFloat.newFrom(floatValue() + aValue);
  }

  public SharedFloat add(Float aValue) {
    return SharedFloat.newFrom(floatValue() + aValue.floatValue());
  }

  public SharedFloat add(SharedFloat aValue) {
    return SharedFloat.newFrom(floatValue() + aValue.floatValue());
  }

  /**
   * Retorna un nuevo shared float que surge de la division del valor almacenado por el valor pasado por parametro.
   * @param aFloat
   * @return
   */
  public SharedFloat div(SharedFloat aFloat) {
      return SharedFloat.newFrom(this.value.floatValue() / aFloat.value.floatValue());
  }
  
  public String format(String decimalPattern,String decimalSeparator,String groupingSeparator)
  {
    if (groupingSeparator.equals(""))
    {
      if (decimalSeparator.equals("."))
      {
        groupingSeparator = ",";
      }else
      {
        groupingSeparator = ".";
      }
    }
    DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    dfs.setDecimalSeparator(decimalSeparator.charAt(0));
    dfs.setGroupingSeparator(groupingSeparator.charAt(0));
    return new DecimalFormat(decimalPattern,dfs).format(getValue());
  }

  public String toTime(String format){
    int h = value.intValue();
    String horas = (new Integer(h)).toString();
    Float m = new Float((value.floatValue() - h)*60);
    int min = m.intValue();
    String minutos = (new Integer(min)).toString();
    int seg = (new Float((m.floatValue() - min)*60)).intValue();
    String segundos = (new Integer(seg)).toString();
    return horas + ":" + minutos + ":" + segundos;
  }

}
