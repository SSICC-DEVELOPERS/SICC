package com.calipso.reportgenerator.reportcalculator.expression;

import java.util.Comparator;
import java.util.Date;

/**
 * Compara dos fechas
 */
public class DateComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    Date o1Date = (Date)o1;
    Date o2Date = (Date)o2;
    if ((o1Date).before(o2Date)){
      return -1;
    }else if (o1Date.getTime()== o2Date.getTime()){
      return 0;
    }else{
      return 1;
    }
  }

}
