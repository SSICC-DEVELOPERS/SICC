package com.calipso.reportgenerator.reportcalculator.expression;

//import com.calipso.reportgenerator.reportcalculator.CubeFloat;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;

import java.util.Comparator;

/**
 * User: pgore
 * Date: May 30, 2003
 * Time: 11:55:27 AM
 */
public class FloatComparator implements Comparator {
  public int compare(Object o1, Object o2) {
/*    if (o2 instanceof CubeFloat){
      return ((Float)o1).compareTo(new Float(((CubeFloat)o2).floatValue()));
    } */

    if(o2 instanceof String) {
      SharedFloat sharedFloat = SharedFloat.newFrom(Float.valueOf(o2.toString()));
      return ((SharedFloat)o1).compareTo(sharedFloat);
    } else {
      return ((SharedFloat)o1).compareTo(o2);
    }
  }
}
