package com.calipso.reportgenerator.reportmanager;

import es.indra.mare.common.info.InfoException;
import java.util.Iterator;
import com.calipso.reportgenerator.reportcalculator.Pivot;
import com.calipso.reportgenerator.reportcalculator.DataTree;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.ReportSpec;

/**
 * Representa los datos de un reporte de tipo estatico
 */

public class StaticReportData extends ReportData {
  private DataTree dataTree;

  public Object[] getMetricValues(int[] ints, Object[] objects){
    return null;
  }
  /**
   * Inicializa una instancia de <code>StaticReportData</code>
   * @param reportSpec
   */
  public StaticReportData(ReportSpec reportSpec){
    super(reportSpec);
    dataTree = new DataTree();
    dataTree.setDefinition(reportSpec);
  }


  public Iterator valuesFor(int dimension, int[] previousDimensions, Object[] values) {
    return getDataTree().valuesFor(dimension, previousDimensions, values);
  }

  /**
   * Retorna el iterador del <code>StaticReportData</code>
   * @return
   */
  public ReportDataIterator iterator() {
    return new StaticReportDataIterator(getDataTree().iterator());
  }

  public Object[] measuresAtDimensionsValues(int[] dimensions, Object[] values) {
    return getDataTree().measuresAtDimensionsValues(dimensions, values);
  }

  /**
   * Asigna la <code>StaticQuery</code> a la instancia de <code>DataTree</code>
   * @param query
   * @param pivot
   * @throws InfoException
   */
  protected void doSetQuery(ReportQuery query, Pivot pivot) throws InfoException {
    getDataTree().setQuery(query.getStaticQuery());
    pivot.fill(getDataTree());
  }

  /**
   * Devuelve el <code>DataTree</code> correspondiente al <code>StaticReportData</code>
   * @return
   */
  public DataTree getDataTree() {
    return dataTree;
  }
}
