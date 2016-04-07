package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportcalculator.ExpressionCubeFilter;
import com.calipso.reportgenerator.common.ReportFieldSpec;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 *  Esta clase en la encargada de obtener los datos necesarios para ejecutar un reporte
 */

public abstract class ReportDataSource {

  private ReportDataSourceSpec dataSourceSpec;
  private ReportSpec reportSpec;
  private Vector columnNames;
  private ExpressionCubeFilter filter;
  private ReportGeneratorConfiguration reportGeneratorConfiguration;

  /**
   * Retorna la configuración del report manager
   * @return
   */
  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }

  /**
   * Asigna la configuración del report manager
   * @param reportGeneratorConfiguration
   */
  public void setGeneratorConfiguration(ReportGeneratorConfiguration reportGeneratorConfiguration) {
    this.reportGeneratorConfiguration = reportGeneratorConfiguration;
  }

  /**
   * Constructor por defecto
   */
  public ReportDataSource() {

  }

  /**
   * Constructor que inicializa el objeto
   * @param reportSpec
   * @param reportDataSourceSpec
   */
  public ReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec reportDataSourceSpec) {
    this.dataSourceSpec= reportDataSourceSpec;
    this.reportSpec = reportSpec;
    initialize();
  }

  /**
   * Inicializa el objeto
   */
  protected void initialize() {
  }

  /**
   * Devuelve la Definición del Origen de un Reporte
   * @return devuelve la Definición del Origen de un Reporte
   */
  public ReportSpec getReportSpec() {
    return reportSpec;
  }

  /**
   * Devuelve el <code>ReportSourceDef</code>
   * @return
   */
  public ReportDataSourceSpec getReportDataSourceSpec() {
    return dataSourceSpec;
  }


  /**
   * Método abstracto que devuelve la Definición del Origen de un Reporte
   * @return devuelve un objeto de tipo IRDataSource
   */
  public abstract IRDataSource getDataSource() throws InfoException;

  /**
   * Obtiene y devuelve un datasource
   * @see DataSource
   * @return
   * @throws InfoException
   */
  public IRDataSource newDataSource() throws InfoException {
    try {
      return new RDataSource(getColumnNames());

    } catch (InfoException e) {
      throw new InfoException(LanguageTraslator.traslate("79"), e);
    }
  }

  /**
   * Devuelve la lista de nombres de columnas
   * @return
   */
  protected Vector getColumnNames() {
    if (columnNames == null) {
      columnNames = new Vector();
      initializeColumnNames(columnNames);
    }
    return columnNames;
  }

  private void parseColumnNamesFrom(Collection names, Collection fieldSpecs){
    Iterator iterator = fieldSpecs.iterator();
    while (iterator.hasNext()) {
      ReportFieldSpec fieldSpec = (ReportFieldSpec) iterator.next();
      if (!fieldSpec.getCalculated()){
         names.add(fieldSpec.getName());
      }
    }
  }
  /**
   * Agrega a la lista de columnas los nombres recorriendo las listas de dimensiones y métricas de la definición del reporte
   * @param names
   */
  private void initializeColumnNames(Collection names) {
    Collection dimensions = getReportSpec().getDimensionsByIndex();
    Collection metrics = getReportSpec().getMetricsByIndex();
    parseColumnNamesFrom(names, dimensions);
    parseColumnNamesFrom(names, metrics);
  }

  /**
   * Devuelve el filtro(Filter)
   * @return
   */
  public ExpressionCubeFilter getFilter() {
    return filter;
  }

  /**
   * Asigan el filter(Filtro)
   * @param filter
   */
  public void setFilter(ExpressionCubeFilter filter) {
    this.filter = filter;
  }

  /**
   * Método abstracto para definir el tipo de filtro
   */
  public abstract int getFilterVarMode();

}
