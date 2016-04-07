package com.calipso.reportgenerator.reportcalculator;

import com.calipso.common.DateEx;

import java.util.HashMap;
import java.io.Serializable;

/**
 * Administra las distintas instancias de DateEx
 */
public class SharedDate implements Serializable, Comparable, CubeValue {
   static final private HashMap dates = new HashMap(5003, 0.80f);
   private DateEx date;


  public SharedDate(DateEx value) {
    this.date = value;
    dates.put(new Long(value.getDate().getTime()),this);
  }

  private SharedDate(){
    
  }

  static public SharedDate newFrom(DateEx aValue) {
    Object dateEx;
    if(aValue!=null && aValue.getDate()!=null){
      dateEx = dates.get(new Long(aValue.getDate().getTime()));
      if (dateEx == null) {
        return new SharedDate(aValue);
      }
      else {
        return (SharedDate) dateEx;
      }
    }else{
      return new SharedDate();
    }
  }

  public boolean equals(Object o) {
    final DateEx dateEx;
    if (this == o) return true;
    if ((date != null ) && (o == null)) return false;
    if (o instanceof DateEx) {
      dateEx = (DateEx) o;
    }
    else {
      dateEx = ((SharedDate) o).getDateEx();
    }
    if (date == null) return false;
    if (!date.equals(dateEx)) return false;
    return true;
  }

  public String toString(){
    if(date==null){
      return "";
    }
    return date.toString();
  }

  public DateEx getDateEx() {
    return date;
  }

  public int compareTo(Object o) {
    if(date==null){
      return -1;
    }
    return date.compareTo(o);
  }

  public Object getValue() {
    return date;
  }

  /*public String toNumberFormat() {
    return date.toNumberFormat();
  }*/
}
