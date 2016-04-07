package com.calipso.reportgenerator.reportcalculator.expression;

import java.util.Comparator;

/**
 * User: pgore
 * Date: May 30, 2003
 * Time: 11:53:03 AM
 */
public class StringComparator implements Comparator{
  public int compare(Object o1, Object o2) {
    return ((String)o1).compareToIgnoreCase((String) o2);
  }

}
