package com.calipso.reportgenerator.common;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Nov 18, 2003
 * Time: 3:49:52 PM
 * To change this template use Options | File Templates.
 */
public class IntegerExt {

  int currentValue;

  public IntegerExt(int currentValue) {
    this.currentValue = currentValue;
  }

  public int getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(int currentValue) {
    this.currentValue = currentValue;
  }

  public void sumValue(int value) {
    currentValue += value;
  }
}
