package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportcalculator.DataTreeIterator;

import java.util.Collection;

/**
 * Iterador para los reportes estáticos
 */
public class StaticReportDataIterator extends ReportDataIterator {
  private DataTreeIterator staticDataIterator;

  public StaticReportDataIterator(DataTreeIterator staticDataIterator) {
    this.staticDataIterator = staticDataIterator;
  }

  public DataTreeIterator getStaticDataIterator() {
    return staticDataIterator;
  }

  public void advance() {
    getStaticDataIterator().advance();
  }

  public boolean hasNext() {
    return getStaticDataIterator().hasNext();
  }

  public Object[] current() {
    return getStaticDataIterator().current();
  }

  public Collection currentTotals() {
    return getStaticDataIterator().currentTotals();
  }


}
