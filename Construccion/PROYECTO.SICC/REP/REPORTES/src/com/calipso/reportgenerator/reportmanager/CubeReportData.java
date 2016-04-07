package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportcalculator.Cube;
import com.calipso.reportgenerator.reportcalculator.Pivot;
import com.calipso.reportgenerator.reportcalculator.CubeQuery;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.ReportSpec;

import java.util.Iterator;
import java.util.Set;
import es.indra.mare.common.info.InfoException;

/**
 * Representa los datos para un reporte de tipo Cube
 */
public class CubeReportData extends ReportData {
  private Cube cube;

  /**
   * Inicializa una instancia de <code>CubeReportData</code>
    * @param reportSpec
   */
  public CubeReportData(ReportSpec reportSpec){
    super(reportSpec);
    cube = new Cube();
    cube.setDefinition(reportSpec);
  }

  /**
   * Devuelve el Cube correspondiente al <code>CubeReportData</code>
   * @return
   */
  protected Cube getCube() {
    return cube;
  }

  public Iterator valuesFor(int dimension, int[] previousDimensions, Object[] values) {
    return getCube().valuesFor(dimension, previousDimensions, values);
  }

  /**
   * Retorna el iterador del <code>CubeReportData</code>
   * @return
   */
  public ReportDataIterator iterator() {
    return new CubeReportDataIterator(getCube().iterator());
  }

  public Object[] measuresAtDimensionsValues(int[] dimensions, Object[] values) {
    return getCube().measuresAtDimensionsValues(dimensions, values);
  }

  /**
   * Asigna la <code>CubeQuery</code> a la instancia de <code>Cube</code>
   * @param query
   * @param pivot
   * @throws InfoException
   */
  protected void doSetQuery(ReportQuery query, Pivot pivot) throws InfoException {
    CubeQuery oldQuery = getCube().getQuery();
    CubeQuery newQuery = query.getCubeQuery();
    boolean eqvQuery = newQuery.equivalentQuery(oldQuery);
    getCube().setQuery(newQuery);
    if (!eqvQuery) {
      pivot.fill(getCube());
    }
  }

  /**
   * Devuelve un conjunto de datos del Cube
   * que representan los valores de
   * las dimensiones
   * @return
   */
  public Set[] getDimensionValues() {
    return getCube().getDimensionValues();
  }

  public Object[] getMetricValues(int[] groupingDimensionsIndexArray, Object[] values){
      return getCube().getMetricsValuesAt(groupingDimensionsIndexArray, values);
  }

}
