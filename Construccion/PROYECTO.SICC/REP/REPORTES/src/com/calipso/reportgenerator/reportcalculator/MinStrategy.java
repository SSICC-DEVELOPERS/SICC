package com.calipso.reportgenerator.reportcalculator;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 03/11/2004
 * Time: 14:41:12
 * To change this template use Options | File Templates.
 */
public class MinStrategy implements MetricCalculationStrategy, Serializable {
/*  private boolean firstValue;

  public MinStrategy(){
    firstValue = true;
  }*/

  public SharedFloat operate(SharedFloat sharedFloat, float measure) {
    /*if(firstValue){
      firstValue = false;
      return SharedFloat.newFrom(measure);
    }*/
    if(Float.isNaN(sharedFloat.floatValue())){
      return SharedFloat.newFrom(measure);
    }
    if(sharedFloat.compareTo(new Float(measure)) <= 0){
      return sharedFloat;
    }else{
      return SharedFloat.newFrom(measure);
    }
  }
}
