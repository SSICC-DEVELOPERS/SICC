package com.calipso.reportgenerator.reportcalculator.expression;

import com.calipso.reportgenerator.reportcalculator.SharedInteger;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Jan 5, 2004
 * Time: 4:28:32 PM
 * To change this template use Options | File Templates.
 */

public class SharedIntegerComparator implements Comparator {

  public int compare(Object o1, Object o2) {
    if(o2 instanceof String) {
      SharedInteger integer = SharedInteger.newFrom(Integer.valueOf(o2.toString()));
      return ((SharedInteger)o1).compareTo(integer);
    } else {
      return ((SharedInteger)o1).compareTo(o2);
    }
  }

}
