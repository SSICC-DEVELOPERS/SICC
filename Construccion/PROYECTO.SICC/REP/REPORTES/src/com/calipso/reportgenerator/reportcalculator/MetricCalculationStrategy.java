package com.calipso.reportgenerator.reportcalculator;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 03/11/2004
 * Time: 14:30:43
 * To change this template use Options | File Templates.
 */
public interface MetricCalculationStrategy {
  public SharedFloat operate(SharedFloat sharedFloat, float measure);
}
