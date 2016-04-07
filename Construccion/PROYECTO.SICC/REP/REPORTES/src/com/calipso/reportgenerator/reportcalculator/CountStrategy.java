package com.calipso.reportgenerator.reportcalculator;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 03/11/2004
 * Time: 14:34:03
 * To change this template use Options | File Templates.
 */
public class CountStrategy implements MetricCalculationStrategy, Serializable {

  public SharedFloat operate(SharedFloat sharedFloat, float measure) {
    if(Float.isNaN(sharedFloat.floatValue())){
      return SharedFloat.newFrom(1);
    }
    return sharedFloat.add(1);
  }
}
