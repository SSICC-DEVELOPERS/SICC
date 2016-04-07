package com.calipso.reportgenerator.reportcalculator;

/**
 * Interface que implemetan tanto el Cube como el DataTree.
 */

public interface PivotClient {

  public void reset();

  public void fillWith(Object[] row);

  public void afterFill();
}
