package com.calipso.reportgenerator.reportcalculator.expression;


import com.calipso.reportgenerator.reportcalculator.SharedDate;
import java.util.Comparator;

/**
 * Comparador para shared date
 */
public class SharedDateComparator implements Comparator{
  public int compare(Object o1, Object o2) {
    if (o2 instanceof SharedDate) {
      return ((SharedDate)o1).compareTo(o2);
    }
    else {
      return ((SharedDate)o1).compareTo(o2);
    }
  }

}
