package com.calipso.reportgenerator.reportcalculator.expression;

import com.calipso.reportgenerator.reportcalculator.SharedString;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: Breto
 * Date: Oct 23, 2003
 * Time: 5:06:40 PM
 * To change this template use Options | File Templates.
 */
public class SharedStringComparator implements Comparator{
  public int compare(Object o1, Object o2) {
    if (o2 instanceof String) {
      return ((SharedString)o1).value().compareToIgnoreCase(((String) o2));
    }
    else {
      return ((SharedString)o1).value().compareToIgnoreCase(((SharedString) o2).value());
    }
  }
}