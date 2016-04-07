package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType;
import com.calipso.reportgenerator.reportcalculator.ExpressionCubeFilter;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.Matrix;
import com.calipso.reportgenerator.common.ReportFilterSpec;
import com.calipso.reportgenerator.common.VersionProperties;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportFilter;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.common.ReportMetricSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportManagerLogger;
import com.calipso.reportgenerator.common.ReportFilterBuilder;
import com.calipso.reportgenerator.reportcalculator.CollectionMatrix;
import com.calipso.reportgenerator.services.DataSourceDefinitionConnectionString;
import com.calipso.common.DateEx;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;

/**
 * Esta clase se crea a partir de un ReportSourceDefinition y es la
 * responsable de aplicar los filtros necesarios a partir de un
 * ReportDataSource, también tiene la responsabilidad de componer la
 * query, cargar el Pivot y ejecutar el cálculo.
 */

public class ReportSource implements Serializable{

  private Matrix matrix;
  private List filterDefinitions;
  private Date lastExecution;
  private Map paramValues;
  private ReportGeneratorConfiguration reportGeneratorConfiguration;
  private ReportSpec reportSpec;


  /**
   * Inicializa una instancia a partir de su definición (ReportSpec)

   * @param reportSpec
   * @param reportGeneratorConfiguration
   * @param init
   * @throws InfoException
   */

  private ReportSource(ReportSpec reportSpec, ReportGeneratorConfiguration reportGeneratorConfiguration, boolean init) throws InfoException {
    if ((reportSpec == null) || (reportGeneratorConfiguration == null)) {
      throw new InfoException(LanguageTraslator.traslate("42"));
    }
    else {
      this.reportSpec = reportSpec;
      this.reportGeneratorConfiguration = reportGeneratorConfiguration;
      this.lastExecution = null;
      this.paramValues = null;
      if (init){
        initializeContents();
      }
    }
  }

  /**
   * Inicializa una instancia a partir de un ReportSpec
   * @param reportSpec
   * @param reportGeneratorConfiguration
   * @throws InfoException
   */

  public ReportSource(ReportSpec reportSpec, ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    this(reportSpec, reportGeneratorConfiguration, true);
  }


  /**
   * Inicializa una instancia a partir de un ReportSpec, y la matriz con la
   * información, en caso que haya sido pre-procesada.
   * @param reportSpec
   * @param matrix
   * @param reportGeneratorConfiguration
   * @throws InfoException
   */
  public ReportSource(ReportSpec reportSpec, Matrix matrix, ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    this(reportSpec, reportGeneratorConfiguration, false);
    if (matrix == null) {
      throw new InfoException(LanguageTraslator.traslate("43"));
    }
    else {
      this.matrix = matrix;
      initializeContents();
    }
  }

  /**
   * Inicializa una instancia a partir de un ReportSpec, y los valores de los pre-filtros, este constructor
   * solo debe utilizarse para reportes no cacheados
   * @param reportSpec
   * @param paramValues
   * @param reportGeneratorConfiguration
   * @throws InfoException
   */
  public ReportSource(ReportSpec reportSpec, Map paramValues, ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    this(reportSpec, reportGeneratorConfiguration, false);
    this.paramValues = paramValues;
    initializeContents();
  }

  /**
   * Inicializa una instancia a partir de un ReposrSourceDefinition, y la matriz con la
   * información, en caso que haya sido pre-procesada y la fecha de última ejecución.
   * Este constructor se utiliza para reportes incrementales.
   * @param reportSpec
   * @param matrix
   * @param lastExecution
   * @param reportGeneratorConfiguration
   * @throws InfoException
   */
  public ReportSource(ReportSpec reportSpec, Matrix matrix, Date lastExecution, ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    this(reportSpec, reportGeneratorConfiguration, false);
    this.matrix = matrix;
    this.lastExecution = lastExecution;
    initializeContents();
  }


  /**
   * Inicializa los contenidos
   * En los cubos no cacheados, ejecuta todos los DataSources
   * En el caso de los cacheados, ejecutalos DataSources solo cuando el reporte no fue pre-procesado o cuando ya no está
   * vigente.
   * En el caso de los incrementales, siempre ejecuta los DataSource con un filtro compuesto a partir del valor de
   * <code>lastExecution</code>
   * @throws InfoException Si se produce un error al llenar la matriz
   */
  private void initializeContents() throws InfoException {
    /*if (matrix == null) {
      DataSourceMatrix dataSourceMatrix = new DataSourceMatrix();
      fillFromSources(dataSourceMatrix);
      matrix = dataSourceMatrix;
    }
    else {
      fillFromSources(((CollectionMatrix)matrix).getRows());
    } */
    if (matrix == null) {
      matrix = new CollectionMatrix();
    }
    fillFromSources(((CollectionMatrix)matrix).getRows());
  }

  /**
   * Devuelve la Definición de Origen de Reporte
   * @return
   */
/*  public ReportSourceDefinition getReportSourceDefinition() {
    //return reportSourceDef;
  }*/


  /**
   * Devuelve la matriz de datos resultante de la ejecución de los DataSources. Es una matriz de dos dimensiones que se
   * utilizará para obtener los distintos reportes.
   * @return
   */
  public Matrix getMatrix() {
    return matrix;
  }

  /**
   * Sirve para inicializar la matriz con valores pre-procesados
   * @param matrix
   */

  public void setMatrix(Matrix matrix) {
    this.matrix = matrix;
  }

  /**
   * Devuelve un objeto capaz de resolver un origen de datos, en este método se devuelve el objeto apropiado según el
   * tipo de origen de datos (XML, OQL, etc).
   * @param dataSourceSpec
   * @return
   * @throws InfoException
   */
  private ReportDataSource newReportDataSourceFrom(ReportDataSourceSpec dataSourceSpec) throws InfoException {
    try {
      ReportDataSource reportDataSource;
      switch (dataSourceSpec.getSourceType().getType()) {
        case DataSourceDefinitionSourceTypeType.XML_TYPE:
          ReportManagerLogger.debug(LanguageTraslator.traslate("204"));
          reportDataSource = new XmlReportDataSource(getReportSpec(), dataSourceSpec, getReportGeneratorConfiguration());
          break;
        case DataSourceDefinitionSourceTypeType.BDLQL_TYPE:
          ReportManagerLogger.debug(LanguageTraslator.traslate("207"));
          reportDataSource = new BDLQLReportDataSource(getReportSpec(), dataSourceSpec, getReportGeneratorConfiguration());
          break;
        case DataSourceDefinitionSourceTypeType.SQL_TYPE:
          ReportManagerLogger.debug(LanguageTraslator.traslate("202"));
          reportDataSource = new SQLReportDataSource(getReportSpec(), dataSourceSpec, getReportGeneratorConfiguration(), new DataSourceDefinitionConnectionString(dataSourceSpec.getExternalConnectionValues()));
          break;
        case DataSourceDefinitionSourceTypeType.EXT_TYPE:
          ReportManagerLogger.debug(LanguageTraslator.traslate("205"));
          reportDataSource = new ExternalReportDataSource(getReportSpec(), dataSourceSpec, getReportGeneratorConfiguration());
          break;
        case DataSourceDefinitionSourceTypeType.OQL_TYPE:
          ReportManagerLogger.debug(LanguageTraslator.traslate("203"));
          reportDataSource = new OQLReportDataSource(getReportSpec(), dataSourceSpec, getReportGeneratorConfiguration());
          break;
/*        case DataSourceDefinitionSourceTypeType.CALC_TYPE:
          ReportManagerLogger.debug(LanguageTraslator.traslate("203"));
          reportDataSource = new OOCalcReportDataSource(getReportSpec(), dataSourceSpec, getReportGeneratorConfiguration());
          break;*/
        case DataSourceDefinitionSourceTypeType.EXCEL_TYPE:
          ReportManagerLogger.debug(LanguageTraslator.traslate("317"));
          reportDataSource = new ExcelReportDataSource(getReportSpec(), dataSourceSpec);
          break;
        default:
          reportDataSource = null;
      }
      if (reportDataSource != null) {
        reportDataSource.setFilter(getCubeFilter(reportDataSource.getFilterVarMode(), dataSourceSpec));
      }
      return reportDataSource;
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("44"), e);
    }
  }


  /**
   * Ejecuta todos los orígenes de datos para llenar la lista de registros (<code>rows</code>)de la Matriz.
   * @param rows
   * @throws InfoException
   */
  private void fillFromSources(List rows) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("201"));
    boolean incremental = !getReportSpec().getIncrementalDimension().equals("");
    boolean cached = getReportSpec().getCached();
    boolean empty = rows.size() == 0;
    if (incremental || !cached || empty) {
      Iterator iterator = getReportSpec().getDataSourceSpecs().iterator();
      while (iterator.hasNext()) {
        if (isFull(rows.size())) return;
        ReportDataSourceSpec dataSourceSpec = (ReportDataSourceSpec) iterator.next();
        ReportDataSource reportDataSource = newReportDataSourceFrom(dataSourceSpec);
        fillRows(reportDataSource, rows, dataSourceSpec);
      }
    }
  }

  /**
   * Ejecuta un origen de datos y agrega las filas que da como resultado a la lista de filas de la Matriz.
   * @param reportDataSource
   * @param rows
   * @throws InfoException
   */
    private void fillRows(ReportDataSource reportDataSource, List rows, ReportDataSourceSpec dataSourceSpec) throws InfoException {
    int rowSize = getDimensionsCount() + getMetricsCount();
    IRDataSource dataSource = reportDataSource.getDataSource();
    try {
      if (dataSource != null) {
        for (int i = 0; i < dataSource.getRowCount(); i++) {
          if (isFull(rows.size())) return;
          Object[] row = new Object[rowSize];
          fillRow(row, dataSource, i, dataSourceSpec);
          rows.add(row);
        }
      }
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("45"), e);
    }
  }

  /**
   * Determina si se ha alcanzado el número máximo de registros
   * @param rowCount
   * @return
   */

  private boolean isFull(int rowCount) {
    if (rowCount>VersionProperties.getMaxNumberRecords()){
      return true;
    } else{
      return getMaxRowCount() > 0 ? getMaxRowCount() <= rowCount : false;
    }
  }

  /**
   * Devuelve el número máximo de líneas a procesar, un valor menor o igual a 0 determina que un origen de reporte no
   * tiene límite de registros.
   * @return
   */
  private int getMaxRowCount() {
    return getReportSpec().getSourceMaxRowCount();
  }


  /**
   * Devuelve una Dimensión a partir de su nombre
   * @param name
   * @return
   */
  public ReportDimensionSpec getDimensionfromName(String name) {
    return getReportSpec().getDimensionFromName(name);
  }


  /**
   * Devuelve una métrica a partir de su nombre
   * @param name
   * @return
   */
  public ReportMetricSpec getMetricFromName(String name) {
    return getReportSpec().getMetricFromName(name);
  }

  /**
   * Llena un registro de la <code>Matrix</code> a partir de un registro del <code>DataSource</code>
   * @param row registro de la <code>Matrix</code> a llenar
   * @param dataSource objeto que contiene los registros obtenidos de un origen de datos (<code>ReportDataSource</code>)
   * @param index índice del registro del <code>DataSource</code> con el que se llenará el registro de la <code>Matrix</code>
   * @param dataSourceSpec DataSourceSpec de donde se obtienen los datos
   * @throws InfoException
   */
  private void fillRow(Object[] row, IRDataSource dataSource, int index, ReportDataSourceSpec dataSourceSpec) throws InfoException {
    try {
      List dimensions = getReportSpec().getDimensionsByIndex();
      Iterator dimensionsIter = dimensions.iterator();
      while (dimensionsIter.hasNext()) {
        ReportDimensionSpec dimensionSpec = (ReportDimensionSpec) dimensionsIter.next();
        row[dimensionSpec.getReportSourceIndex()] = dimensionSpec.getValue(getParamValues(), dataSource, index, dataSourceSpec);
      }

      List metrics = getReportSpec().getMetricsByIndex();
      Iterator metricsIter = metrics.iterator();
      while (metricsIter.hasNext()) {
        ReportMetricSpec metricSpec = (ReportMetricSpec) metricsIter.next();
        row[metricSpec.getReportSourceIndex()] = metricSpec.getValue(getParamValues(), dataSource, index);
      }
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("46"), e);
    }
  }

  /**
   * Devuelve la cantidad de Dimensiones
   * @return
   */

  private int getDimensionsCount() {
    return getReportSpec().getDimensionSpecs().size();
  }


  /**
   * Devuelve la cantidad de Métricas
   * @return
   */
  private int getMetricsCount() {
    return getReportSpec().getMetricSpecs().size();
  }

  /**
   * Crea los pre-filtros a partir de las <code>FilterDefinitions</code> del <code>ReportSourceDefinition</code>
   * @param reportDataSourceSpec
   * @return
   */
  protected List getFilterDefinitions(ReportDataSourceSpec reportDataSourceSpec) {
    if (filterDefinitions == null) {
      filterDefinitions = new ArrayList();

      ReportFilter incFilter = getIncrementalFilter(reportDataSourceSpec);
      if (incFilter != null) {
        filterDefinitions.add(incFilter);
      }
      ReportFilter maxRowsFilter = getMaxRowsFilter();
      if (maxRowsFilter != null) {
        filterDefinitions.add(maxRowsFilter);
      }
      Collection filterSpecs = getReportSpec().getPreFilterSpecs();
      for (Iterator iterator = filterSpecs.iterator(); iterator.hasNext();) {
        ReportFilterSpec reportFilterSpec = (ReportFilterSpec) iterator.next();
        ReportFilter reportFilter = new ReportFilter(reportFilterSpec);
        filterDefinitions.add(reportFilter);
      }
    }
    return filterDefinitions;
  }

  public ReportSpec getReportSpec() {
    return reportSpec;
  }

  /**
   * Crea un filtro del tipo "mayor que" tomando como parámetro la fecha de última ejecución y aplicado sobre
   * la dimension <code>incrementalDimension</code>, este filtro es el que resuelve el cálculo incremental de reportes
   * @return
   */
  private ReportFilter getIncrementalFilter(ReportDataSourceSpec reportDataSourceSpec) {
    ReportFilter incFilter = null;
    ReportFilterSpec incFilterSpec = getReportSpec().getIncrementalFilterSpec(getLastExecution());
    if (incFilterSpec != null){
      incFilter = new ReportFilter(incFilterSpec);
      getParamValues().put("INCREMENTALVALUE", SharedDate.newFrom(new DateEx(getLastExecution())));//getDateString(getLastExecution(), reportDataSourceSpec));
    }
    return incFilter;
  }

  private ReportFilter getMaxRowsFilter() {
    ReportFilter maxRowsFilter = null;
    ReportFilterSpec maxRowsFilterSpec = getReportSpec().getSourceMaxRowsFilterSpec();
    if (maxRowsFilterSpec != null){
      maxRowsFilter = new ReportFilter(maxRowsFilterSpec );
    }
    return maxRowsFilter;
  }

  /**
   * Devuelve los valores de los parámetros de pre-filtros
   * @return
   */
  private Map getParamValues() {
    if (paramValues == null) {
      paramValues = new HashMap();
    }
    return paramValues;
  }


  /**
   * Se utiliza para obtener el valor de la fecha para le filtro incremental
   * @param date
   * @return
   */
  private String getDateString(Date date, ReportDataSourceSpec reportDataSourceSpec) {
    int dataType = getReportSpec().getDimensionFromName(getReportSpec().getIncrementalDimension()).getDataType().getType();
    DateFormat dateFormat = new SimpleDateFormat(reportDataSourceSpec.getPattern(dataType));
    return dateFormat.format(date);
  }

  /* Formato de la fecha,
   * Nota: este método está resuelto de manera provisoria, esta información será leída de archivos de configuración
   *
   * @return

  public String getDatePattern() {
    return getReportSpec().getDatePattern();
  }*/


  /**
   * Utiliza la información de los FilterDefinitions para construir un filtro que pueden utilizar los ReportDataSource
   * @param mode
   * @return
   */
  protected ExpressionCubeFilter getCubeFilter(int mode, ReportDataSourceSpec dataSourceSpec) throws InfoException{
    ExpressionCubeFilter cubeFilter;
    Map currentParamValues = new HashMap();
    List filterDefs = getFilterDefinitions(dataSourceSpec);
    currentParamValues = ReportFilterBuilder.mergeParamValues(currentParamValues, getReportSpec().getParamValues(true));
    currentParamValues = ReportFilterBuilder.mergeParamValues(currentParamValues, getParamValues());
    ReportFilterBuilder filterBuilder = new ReportFilterBuilder(filterDefs, currentParamValues, mode);
    cubeFilter = filterBuilder.getCubeFilter(getReportSpec(), dataSourceSpec);
    return cubeFilter;
  }


  /**
   * Devuelve la fecha de la última ejecución del reporte.
   * @return
   */
  public Date getLastExecution() {
    return lastExecution;
  }

  /**
   * Especifica la fecha del al última ejecución del reporte.
   * @param lastExecution
   */

  public void setLastExecution(Date lastExecution) {
    this.lastExecution = lastExecution;
  }

  /**
   * Devuelve la configuración del report generator
   * @return
   */
  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }
}
