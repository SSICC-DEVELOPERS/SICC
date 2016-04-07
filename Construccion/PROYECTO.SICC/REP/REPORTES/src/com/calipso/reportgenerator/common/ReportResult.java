package com.calipso.reportgenerator.common;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

import es.indra.mare.common.info.InfoException;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.ReportSpec;

/**
 * La ejecución de una consulta (<code>ReportQuery</code>) sobre un reporte da como resultado un <code>ReportResult</code>, contiene los datos
 * calculados y los valores de entrada que se utilizaron para obtenerlos. Provee mecanismos para recorrer y explorar
 * la información y también puede generar una salida Xml con la información obtenida.
 */

public abstract class ReportResult implements Serializable {

  private ReportQuery reportQuery;
  private ReportSpec reportSpec;

  /**
   * Constructor que inicializa el objeto
   * @param reportSpec
   * @param reportQuery
   */
  public ReportResult(ReportSpec reportSpec, ReportQuery reportQuery) {
    this.reportSpec = reportSpec;
    this.reportQuery = reportQuery;
  }

  /**
   * Devuelve la información acerca de la estructura del reporte
   * @return
   */
  public ReportSpec getReportSpec() {
    return reportSpec;
  }

  /**
   * Devuelve los valores de parámetros
   * @return
   */
  public Map getParamValues() {
    return getReportQuery().getParamValues();
  }

  /**
   * Devuelve el report query
   * @return
   */
  public ReportQuery getReportQuery() {
    return reportQuery;
  }

  public Set getDimensionUnCheckedValues(String name) throws InfoException {
    try {
      QueryDimension dimension = getReportQuery().getQueryDimensionFromName(name);
      int index = dimension.getIndex();
      return getReportQuery().getExcludedValues(index);
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("148"), e);
    }
  }

  public ReportDimensionSpec getDimensionFromName(String name) {
    return getReportSpec().getDimensionFromName(name);
  }

  public ReportMetricSpec getMetricFromName(String name) {
    return getReportSpec().getMetricFromName(name);
  }

  public abstract ReportTableModel getReportTableModel();

  public abstract void resetReportTableModel();

  public abstract Collection getValuesCollection(boolean ascending);
}
