package com.calipso.reportgenerator.reportcalculator;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;

/**
 * Administra las instancias de Integer
 */

public class SharedInteger implements Serializable, Comparable, CubeValue {

  private Integer value;
  static final private HashMap integers = new HashMap(5003, 0.80f);

  public SharedInteger(Integer value) {
    this.value = value;
    integers.put(value, this);
  }

  public static SharedInteger newFrom(Integer integer) {
    Object o = integers.get(integer);
    if(o == null) {
      return new SharedInteger(integer);
    } else {
      return (SharedInteger) o;
    }
  }

  public String toString() {
    return value.toString();
  }

  public int intValue() {
    return value.intValue();
  }

  public int compareTo(Object o) {
    return value.compareTo(((SharedInteger)o).value);
  }

  public Object getValue() {
    return value;
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

}
