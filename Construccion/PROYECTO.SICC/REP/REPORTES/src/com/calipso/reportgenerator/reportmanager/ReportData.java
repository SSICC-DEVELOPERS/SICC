package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportcalculator.Pivot;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.ReportSpec;
import java.util.Iterator;
import java.util.Set;
import java.io.Serializable;
import es.indra.mare.common.info.InfoException;

/**
 * Representa los datos de un reporte.
 */

public abstract class ReportData implements Serializable {

  private ReportQuery reportQuery;
  private ReportSpec reportSpec;

  /**
   * Constructor de la clase.
   * @param reportSpec
   */
  public ReportData(ReportSpec reportSpec){
    this.reportSpec = reportSpec;
  }

  public abstract Iterator valuesFor(int dimension, int[] previousDimensions, Object[] values);

  public abstract ReportDataIterator iterator();

  public ReportQuery getQuery() {
    return reportQuery;
  }

  public void setQuery(ReportQuery query, Pivot pivot) throws InfoException {
    reportQuery = query;
    doSetQuery(query, pivot);
  }

  protected abstract void doSetQuery(ReportQuery query, Pivot pivot) throws InfoException;

  public ReportSpec getDefinition() {
    return reportSpec;
  }

  public abstract Object[] measuresAtDimensionsValues(int[] dimensions, Object[] values);

  public Set[] getDimensionValues() {
    return new Set[0];
  }

  public abstract Object[] getMetricValues(int[] groupingDimensionsIndexArray, Object[] values);

}
