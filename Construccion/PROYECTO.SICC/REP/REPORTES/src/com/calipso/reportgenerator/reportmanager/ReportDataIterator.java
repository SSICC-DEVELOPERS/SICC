package com.calipso.reportgenerator.reportmanager;

import java.util.Collection;

/**
 * Interface genérica para iterar ReportData
 */
public abstract class ReportDataIterator {
  public abstract void advance();
  public abstract boolean hasNext();
  public abstract Object[] current();
  public abstract Collection currentTotals();
}
