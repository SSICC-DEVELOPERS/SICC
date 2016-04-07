package com.calipso.reportgenerator.reportcalculator;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 03/11/2004
 * Time: 14:32:10
 * To change this template use Options | File Templates.
 */
public class SumStrategy implements MetricCalculationStrategy, Serializable {

  public SharedFloat operate(SharedFloat sharedFloat, float measure) {
    if(Float.isNaN(sharedFloat.floatValue())){
      return SharedFloat.newFrom(measure);
    }
    return sharedFloat.add(measure);
  }
}
