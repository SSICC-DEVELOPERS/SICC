package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportcalculator.CubeIterator;

import java.util.Collection;

/**
 * Rerre el cube report data
 */
public class CubeReportDataIterator extends ReportDataIterator {
  private CubeIterator cubeIterator;
  public CubeReportDataIterator(CubeIterator cubeIterator) {
    this.cubeIterator = cubeIterator;
  }

  protected CubeIterator getCubeIterator() {
    return cubeIterator;
  }

  public void advance() {
    getCubeIterator().advance();
  }

  public boolean hasNext() {
    return getCubeIterator().hasNext();
  }

  public Object[] current() {
    return getCubeIterator().current();
  }

  public Collection currentTotals() {
    return getCubeIterator().currentTotals();
  }
}
