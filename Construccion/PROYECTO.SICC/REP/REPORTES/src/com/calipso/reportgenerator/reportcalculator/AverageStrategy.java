package com.calipso.reportgenerator.reportcalculator;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 08/11/2004
 * Time: 14:22:23
 * To change this template use Options | File Templates.
 */
public class AverageStrategy implements MetricCalculationStrategy, Serializable {
  private SumStrategy decoratedStrategy;

  public AverageStrategy(){
    this.decoratedStrategy = new SumStrategy();
  }

  public SharedFloat operate(SharedFloat sharedFloat, float measure) {
    return decoratedStrategy.operate(sharedFloat, measure);
  }

}
