package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.EnumerationCubeFilter;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.StaticQuery;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.CubeQuery;
import com.calipso.reportgenerator.reportcalculator.ExpressionCubeFilter;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType;
import com.calipso.reportgenerator.reportdefinitions.ExcludeValue;
import com.calipso.reportgenerator.reportdefinitions.DimensionProperty;
import com.calipso.reportgenerator.reportdefinitions.MetricProperty;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.DimensionProperties;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.common.DateEx;

import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;
import java.text.MessageFormat;
import java.io.Serializable;

import es.indra.mare.common.info.InfoException;

/** Esta clase contiene la información necesaria para ejecutar una consulta a sobre los datos, especificando las,
 *  agrupaciones, filtros, campos visibles, ordenamiento, etc.
 */
public class ReportQuery implements Serializable {
  private ReportSpec reportSpec;
  private List dimensions;
  private List metrics;
  private List accumulableMetrics;
  private Map paramValues;
  private List filterDefinitions;
  private Map dimensionFilterValues;
  private boolean visibleTotals;
  private EnumerationCubeFilter rankingFilter;

  /** Inicializa una nueva Consulta, asignandole a las dimensiones y a las métrcias las propiedades por defecto que se
   * obtienen de la definición de reporte
   * @param reportSpec Contiene la información necesaria para ubicar los datos de las dimensiones y las métricas dentro
   * de las rows del DataSource.
   * @throws es.indra.mare.common.info.InfoException
   */
  public ReportQuery(ReportSpec reportSpec) throws InfoException {
    this(reportSpec, true);
  }

  /**
   * Inicializa una nueva Consulta permitiendo especificar si se desea que a las dimensiones y las métricas se les asignen
   * las propiedades por defecto que se obtienen de la definición del reporte.
   * @param reportSpec Contiene la información necesaria para ubicar los datos de las dimensiones y las métricas dentro
   * de las rows del DataSource.
   * @param defaultInitialize true = valores de propiedades por defecto segun definición de reporte. false = ninguna métrica
   * visible, ninguna dimension agrupa (Location = PAGE).
   */
  public ReportQuery(ReportSpec reportSpec, boolean defaultInitialize) throws InfoException {
    this.reportSpec = reportSpec;
    initialize(defaultInitialize);
  }

  /**
   * Inicializa la query y le aplica los valores del Report view indicado
   * @param reportSpec Contiene la información necesaria para ubicar los datos de las dimensiones y las métricas dentro
   * de las rows del DataSource.
   * @param reportView Continen los valores especificos para la vista solicitada
   */
  public ReportQuery(ReportSpec reportSpec, ReportView reportView) throws InfoException {
    this(reportSpec, true);
    overrideQuery(reportView);
  }

  /**
   * Sobreescribe los valores particulares de el report view
   * @param reportView
   */
  private void overrideQuery(ReportView reportView) throws InfoException {
    if (reportView != null) {
      overrideDimensionValues(reportView);
      overrideMetricsValues(reportView);
      overrideFiltersValues(reportView);
      generalOverride(reportView);
    }
  }

  private void overrideFiltersValues(ReportView reportView) throws InfoException{
    DimensionProperties pr = reportView.getDimensionProperties();
    DimensionProperty [] properties = pr.getDimensionProperty();
    for(int i = 0 ; i < properties.length ; i++) {
      Set set = new TreeSet();
      DimensionProperty property = properties [i];
      ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(property.getDimensionName());
      int dimensionIndex = dimensionSpec.getIndex();
      //int dimensionIndex = reportSpec.getDimensionFromName(property.getDimensionName()).getIndex();
      ExcludeValue [] values = property.getExcludeValue();
      for(int j = 0 ; j < values.length ; j++) {
        ExcludeValue value = values [j];
        switch(dimensionSpec.getDataType().getType()){
          case ReportDataType.STRING_TYPE:
            set.add(value.getValue());
            break;
          case ReportDataType.DATETIME_TYPE:
          case ReportDataType.DATE_TYPE:
            try {
              set.add(SharedDate.newFrom(new DateEx(value.getValue())));
            }catch (InfoException e) {
              throw new MultipleStringInfoException(new String[] {LanguageTraslator.traslate("262"),value.getValue()},e);
            }
            break;
          case ReportDataType.FLOAT_TYPE:
            set.add(SharedFloat.newFrom(new Float(value.getValue())));
            break;
          case ReportDataType.INTEGER_TYPE:
            set.add(SharedInteger.newFrom(new Integer(value.getValue())));
            break;
          case ReportDataType.BOOLEAN_TYPE:
            set.add(Boolean.valueOf(value.getValue()));
            break;
        }
      }
      getDimensionFilterValues().put(new Integer(dimensionIndex), set);
    }
  }

  /**
   * Sobreescrie los parámetros generales de la query
   * @param reportView
   */
  private void generalOverride(ReportView reportView) {
    this.visibleTotals = reportView.getVisibleTotals();
  }

  /**
   * Sobrescribe los valores la las metricas del reportview
   * @param reportView
   * @throws es.indra.mare.common.info.InfoException
   */
  private void overrideMetricsValues(ReportView reportView) throws InfoException {
    if (reportView.getMetricProperties() != null) {
      int count = reportView.getMetricProperties().getMetricPropertyCount();
      MetricProperty metricProperty;
      for (int i = 0; i < count; i++) {
        metricProperty = reportView.getMetricProperties().getMetricProperty()[i];
        setMetricProperties(metricProperty.getMetricName(), metricProperty.getVisible(), i);
      }
    }
  }

  /**
   * Asigna los valores
   * @param reportView
   * @throws es.indra.mare.common.info.InfoException
   */
  private void overrideDimensionValues(ReportView reportView) throws InfoException {
    int count = reportView.getDimensionProperties().getDimensionPropertyCount();
    DimensionProperty dimensionProperty;
    for (int i = 0; i < count; i++) {
      dimensionProperty = reportView.getDimensionProperties().getDimensionProperty()[i];
      setDimensionProperties(dimensionProperty.getDimensionName(), getLocationTypeFormView(dimensionProperty.getLocation()), getOrderTypeFormView(dimensionProperty.getOrder()), dimensionProperty.getUbication());
    }
  }

  /**
   * Convierte los location de los properties del view al los del dimension definition
   * @param locationType
   * @return
   */
  private DimensionDefinitionLocationType getLocationTypeFormView(DimensionPropertyLocationType locationType) {
    return DimensionDefinitionLocationType.valueOf(locationType.toString());
  }

  /**
   * Convierte los order de los properties del view al los del dimension definition
   * @param orderType
   * @return
   */
  private DimensionDefinitionOrderType getOrderTypeFormView(DimensionPropertyOrderType orderType) {
    return DimensionDefinitionOrderType.valueOf(orderType.toString());
  }

  /**
   * Ejecuta la inicialización
   * @param defaultInitialize
   */
  private void initialize(boolean defaultInitialize) {
    this.dimensions = new ArrayList();
    this.metrics = new ArrayList();
    this.accumulableMetrics = new ArrayList();
    this.visibleTotals = getReportSpec().isVisibleTotals();
    DimensionDefinitionLocationType location;
    Collection dimensions;

    if ((getReportSpec().getReportType().getType() == ReportDefinitionReportTypeType.CUBE_TYPE) || (getReportSpec().getReportType().getType() == ReportDefinitionReportTypeType.CHARTCUBE_TYPE)) {
      if (defaultInitialize) {
        location = DimensionDefinitionLocationType.ROW;
        dimensions = getReportSpec().getDimensionsByLocation(location);
        addDimensionsByLocation(dimensions, location);
        location = DimensionDefinitionLocationType.COLUMN;
        dimensions = getReportSpec().getDimensionsByLocation(location);
        addDimensionsByLocation(dimensions, location);
        location = DimensionDefinitionLocationType.PAGE;
        dimensions = getReportSpec().getDimensionsByLocation(location);
        addDimensionsByLocation(dimensions, location);
      }
      else {
        dimensions = getReportSpec().getDimensionSpecs().values();
        addDimensionsByLocation(dimensions, DimensionDefinitionLocationType.PAGE);
      }
    }
    else {
      dimensions = getReportSpec().getDimensionsByGrouping(true);
      addDimensionsByGrouping(dimensions, true);
      dimensions = getReportSpec().getDimensionsByGrouping(false);
      addDimensionsByGrouping(dimensions, false);
    }


    Collection metrics = getReportSpec().getMetricsByIndex();
    for (Iterator iterator = metrics.iterator(); iterator.hasNext();) {
      ReportMetricSpec metricSpec = (ReportMetricSpec) iterator.next();
      int index = metricSpec.getReportSourceIndex();
      boolean visible;
      if (defaultInitialize) {
        visible = metricSpec.getVisible();
      }
      else {
        visible = false;
      }
      getMetrics().add(new QueryMetric(metricSpec.getName(), index, visible, getMetrics().size(), metricSpec.getAccumulable()));
    }

    Collection accmetrics = getReportSpec().getAccumulableMetricsByIndex();
    for (Iterator iterator = accmetrics.iterator(); iterator.hasNext();) {
      ReportMetricSpec metricSpec = (ReportMetricSpec) iterator.next();
      int index = metricSpec.getReportSourceIndex();
      boolean visible;
      if (defaultInitialize) {
        visible = metricSpec.getVisible();
      }
      else {
        visible = false;
      }
      getAccumulableMetrics().add(new QueryMetric(metricSpec.getName(), index, visible, getMetrics().size(), metricSpec.getAccumulable()));
    }
  }

  /**
   * Inicializa los QueryDimension que representan a los ReportDimensionSpec que se reciben como parámetro, segun la
   * ubicación de agrupación (para reportes tipo cubo)
   * @param dimensions
   * @param location
   */

  private void addDimensionsByLocation(Collection dimensions, DimensionDefinitionLocationType location) {
    Iterator iter = dimensions.iterator();
    int locationOrder = 0;
    while (iter.hasNext()) {
      ReportDimensionSpec dimensionSpec = (ReportDimensionSpec) iter.next();
      if (dimensionSpec.getInReportDefinition()) {
        getDimensions().add(new QueryDimension(dimensionSpec.getName(), dimensionSpec.getReportSourceIndex(), location, dimensionSpec.getOrder(), locationOrder, false, dimensionSpec.getRankMetricName()));
        locationOrder++;
      }
    }
  }

  /**
   * Inicializa los QueryDimension que representan a los ReportDimensionSpec que se reciben como parámetro, segun la
   * rol de agrupación (para reportes estáticos)
   * @param dimensions
   * @param groups
   */
  private void addDimensionsByGrouping(Collection dimensions, boolean groups) {
    Iterator iter = dimensions.iterator();
    int locationOrder = 0;
    while (iter.hasNext()) {
      ReportDimensionSpec dimensionSpec = (ReportDimensionSpec) iter.next();
      if (dimensionSpec.getInReportDefinition()) {
        getDimensions().add(new QueryDimension(dimensionSpec.getName(), dimensionSpec.getReportSourceIndex(), DimensionDefinitionLocationType.PAGE, dimensionSpec.getOrder(), locationOrder, groups, dimensionSpec.getRankMetricName()));
        locationOrder++;
      }
    }
  }

  /**
   * Devuelve la query traducida a la forma que utiliza el módulo de cálculo de cubos.
   * @return
   * @throws es.indra.mare.common.info.InfoException
   */
  public CubeQuery getCubeQuery() throws InfoException {
    try {
      CubeQuery query = new CubeQuery();
      int[] rows = getCubeRowFields();
      int[] cols = getCubeColumnFields();
      int[] pages = getCubePageFields();
      int[] metrics = getCubeMetricFields();
      boolean[] ascending = getDimensionOrder();
      int[] dimensioRank = getDimensionRank();
      query.setRows(rows);
      query.setColumns(cols);
      query.setPages(pages);
      query.setMetrics(metrics);
      query.setAscending(ascending);
      query.setDimensionRank(dimensioRank);
      query.setFilter(getCubeFilter(getParamValues()));
      query.setRankingFilter(getEnumerationFilter());
      query.setEnumFilter(getEnumFilter());
      return query;
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("82"), e);
    }
  }


  /** Devuelve una lista que contiene las métricas visibles
   * @return
   */
  public List getVisibleMetrics() {
    List list = new ArrayList();
    for (Iterator iterator = metrics.iterator(); iterator.hasNext();) {
      QueryMetric queryMetric = (QueryMetric) iterator.next();
      if (queryMetric.getVisible()) {
        list.add(queryMetric);
      }
    }
    return list;
  }

  /** Devuelve una lista que contiene las métricas acumulables visibles
   * @return
   */
  public List getVisibleAccumulableMetrics() {
    List list = new ArrayList();
    for (Iterator iterator = accumulableMetrics.iterator(); iterator.hasNext();) {
      QueryMetric queryMetric = (QueryMetric) iterator.next();
      if (queryMetric.getVisible()) {
        list.add(queryMetric);
      }
    }
    return list;
  }


  /** Devuelve un array de enteros que representan a los indices de la row donde se encuentran los valores de las métricas
   * @return
   */
  private int[] getCubeMetricFields() {
    List list = getMetrics();
    int[] array = new int[list.size()];
    int index = 0;
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      QueryMetric queryMetric = (QueryMetric) iterator.next();
      array[index] = queryMetric.getIndex();
      index++;
    }
    return array;
  }

  /** Devuelve un array de enteros que representan a los indices de la row donde se encuentran los valores de las métricas
   * acumulables
   * @return
   */

  private int[] getStaticAccumulableMetricFields() {
    List list = getAccumulableMetrics();
    int[] array = new int[list.size()];
    int index = 0;
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      QueryMetric queryMetric = (QueryMetric) iterator.next();
      array[index] = queryMetric.getIndex();
      index++;
    }
    return array;
  }

  /** Devuelve un array de enteros que representan a los indices de la row donde se encuentran los valores de las métricas
   * visibles
   * @return
   */

  public int[] getCubeVisibleMetricFields() {
    List list = getVisibleMetrics();
    int[] array = new int[list.size()];
    int index = 0;
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      QueryMetric queryMetric = (QueryMetric) iterator.next();
      array[index] = queryMetric.getIndex();
      index++;
    }
    return array;
  }


  /** Devuelve un array de boolean que contiene el tipo de ordenamiento para cada dimension
   * true = Ascendente
   * false = Descendente
   *
   * @return
   */
  private boolean[] getDimensionOrder() {
    int size = getReportSpec().getDimensionSpecs().size();
    boolean[] orders = new boolean[size];
    for (int i = 0; i < getDimensions().size(); i++) {
      QueryDimension queryDimension = (QueryDimension) getDimensions().get(i);
      orders[queryDimension.getIndex()] = queryDimension.getOrder().getType() == (DimensionDefinitionOrderType.A.getType());
    }
    return orders;
  }


  /**
   * Devuelve un array que contiene los indices de las métricas que se utilizaran para ranking (ordenamiento por valor
   * de métrica) para cada dimensión. Si no se utiliza ranking el valor es -1, ordenando por valor de dimensión.
   */
  private int[] getDimensionRank() {
    int size = getReportSpec().getDimensionSpecs().size();
    int[] dimensionRank = new int[size];
    for (int i = 0; i < getDimensions().size(); i++) {
      QueryDimension queryDimension = (QueryDimension) getDimensions().get(i);
      ReportMetricSpec metricSpec = null;
      if(queryDimension.getRankMetricName() != null){
        metricSpec = getReportSpec().getMetricFromName(queryDimension.getRankMetricName());
      }
      int metricIndex;
      if (metricSpec == null) {
        metricIndex = -1;
      }
      else {
        metricIndex = metricSpec.getReportSourceIndex();
      }
      dimensionRank[queryDimension.getIndex()] = metricIndex;
    }
    return dimensionRank;
  }

  /** Devuelve un array de enteros que representan a los indices de la row donde se encuentran los valores de las dimensiones
   * segun las lista de dimensiones que recibe como parámetro
   *  Se utliza para resolver <code>getCubeRowFields()</code> y <code>getCubeColumnFields()</code>
   * @param dimensions
   * @return
   */
  private int[] getDimensionIndexArray(List dimensions) {
    int size = dimensions.size();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      QueryDimension queryDimension = (QueryDimension) dimensions.get(i);
      array[i] = queryDimension.getIndex();
    }
    return array;
  }

  /** Devuleve los indices de las dimensions que agrupan por fila
   *
   * @return
   */
  private int[] getCubeRowFields() {
    return getDimensionIndexArray(getRowDimensions());
  }


  /** Devuelve los indices de las dimensiones que agrupan por columna
   *
   * @return
   */
  private int[] getCubeColumnFields() {
    return getDimensionIndexArray(getColumnDimensions());
  }

  /** Devuelve los indices de las dimensiones que agrupan por página
   *
   * @return
   */

  private int[] getCubePageFields() {
    return getDimensionIndexArray(getPageDimensions());
  }

  /**
   * Lista que contiene todas las dimensiones involucradas en la query
   * @return
   */

  public List getDimensions() {
    return dimensions;
  }

  /** Devuelve una lista con todas las dimensiones que agrupan según el parámetro <code>location</code>.
   *
   * @param location ubicación de las dimensiones que se desea obtener.
   * @return
   */
  public List getDimensionsByLocation(DimensionDefinitionLocationType location) {

    List list = new ArrayList();

    for (Iterator iterator = getDimensions().iterator(); iterator.hasNext();) {
      QueryDimension queryDimension = (QueryDimension) iterator.next();
      if (queryDimension.getLocation().getType() == location.getType()) {
        (list).add(queryDimension);
      }
    }
    Collections.sort(list, new Comparator() {
      public int compare(Object o1, Object o2) {
        QueryDimension dim1 = (QueryDimension) o1;
        QueryDimension dim2 = (QueryDimension) o2;
        return dim1.getLocationOrder() - dim2.getLocationOrder();
      }
    });
    return list;
  }

  /**
   * Lista que contiene todas las dimensiones que agrupan por fila
   * @return
   */
  public List getRowDimensions() {
    return getDimensionsByLocation(DimensionDefinitionLocationType.ROW);
  }

  /**
   * Lista que contiene todas las dimensiones que agrupan por columna
   * @return
   */
  public List getColumnDimensions() {
    return getDimensionsByLocation(DimensionDefinitionLocationType.COLUMN);
  }

  /**
   * Lista que contiene todas las dimensiones que estan disponibles para agrupar
   * @return
   */
  public List getPageDimensions() {
    return getDimensionsByLocation(DimensionDefinitionLocationType.PAGE);
  }

  /**
   * Lista que contiene todos las métricas que el usuario puede activar (ver)
   * @return
   */
  public List getMetrics() {
    return metrics;
  }

  /**
   * Lista que contiene todos las métricas acumulables que el usuario puede activar (ver)
   * @return
   */
  public List getAccumulableMetrics() {
    return accumulableMetrics;
  }


  /**
   * Devuelve la estructura <code>ReportSpec</code> que sirve para obtener los indices de las dimensiones y las métricas en
   * la matriz que se llenó a partir de <code>DataSource</code>
   * @return
   */

  public ReportSpec getReportSpec() {
    return reportSpec;
  }

  /**
   * Hace que todas las dimensiones no intervengan en la agrupación (ni por ROW ni por COLUMN)
   * Inicializa los criterios de ordenamiento de los valores de dimensión en A (ascendente)
   * Asigna -1 al orden relativo de las dimensiones
   * Este método se utiliza para configurar una nueva query a partir de una query existente, la query
   * que se obtiene por defecto está inicializada con los valores prefijados en el ReportSourceDefinition
   */
  public void clearQuery() {
    for (int i = 0; i < getDimensions().size(); i++) {
      QueryDimension queryDimension = (QueryDimension) getDimensions().get(i);
      queryDimension.setProperties(DimensionDefinitionLocationType.PAGE, DimensionDefinitionOrderType.A, 1);
    }
    for (int i = 0; i < getMetrics().size(); i++) {
      QueryMetric queryMetric = (QueryMetric) getMetrics().get(i);
      queryMetric.setVisible(false);
    }
    paramValues = null;
    dimensionFilterValues = null;
  }

  /**
   * Especifica la ubicación de agrupación de una dimensión
   * @param name
   * @param location
   * @throws es.indra.mare.common.info.InfoException
   */

  public void setDimensionLocation(String name, DimensionDefinitionLocationType location) throws InfoException {
    QueryDimension queryDimension = getQueryDimensionFromName(name);
    queryDimension.setLocation(location);
  }

  /**
   * Especifica el criterio de ordenamiento de los valores de una dimensión
   * @param name
   * @param order
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setDimensionOrder(String name, DimensionDefinitionOrderType order) throws InfoException {
    QueryDimension queryDimension = getQueryDimensionFromName(name);
    queryDimension.setOrder(order);
  }


  /**
   * Especifica el posición de la dimensión relativa a la localización
   * El valor de <code>order</code> solo sirve para ordenar (comparar), no es obligatorio especificar números correlativos
   * @param name
   * @param order
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setDimensionLocationOrder(String name, int order) throws InfoException {
    QueryDimension queryDimension = getQueryDimensionFromName(name);
    queryDimension.setLocationOrder(order);

  }

  /**
   * Especifica el posición de la dimensión relativa a la localización, si el parámetro updateOrders es True, se reacomodan
   * los ordenes desde la dimensión especificada en adelante
   * El valor de <code>order</code> solo sirve para ordenar (comparar), no es obligatorio especificar números correlativos
   * @param name
   * @param order
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setDimensionLocationOrder(String name, int order, boolean updateOrders) throws InfoException {
    setDimensionLocationOrder(name, order);
    if (updateOrders) {
      locationOrderUpdated(name, order);
    }
  }

  /**
   * Reacomoda el orden de las dimensiones cuando cambia el orden
   * @param name
   * @param locationOrder
   */
  private void locationOrderUpdated(String name, int locationOrder) throws InfoException {
    QueryDimension dimension = getQueryDimensionFromName(name);
    List list = getDimensionsByLocation(dimension.getLocation());
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      QueryDimension queryDimension = (QueryDimension) iterator.next();
      if (name != queryDimension.getName() && queryDimension.getLocationOrder() >= locationOrder) {
        queryDimension.setLocationOrder(queryDimension.getLocationOrder() + 1);
      }
    }
  }

  /**
   * Especifica todas las propiedades de la dimension que afectan la query
   *
   * @param name
   * @param location ubicación de agrupación (pueder ser null, en ese caso conserva el valor anterior)
   * @param order criterio de ordenamiento (pueder ser null, en ese caso conserva el valor anterior)
   * @param locationOrder posición relativa a la localización (para conservar la posición anterior se debe pasar valor -1)
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setDimensionProperties(String name, DimensionDefinitionLocationType location, DimensionDefinitionOrderType order, int locationOrder) throws InfoException {
    QueryDimension queryDimension = getQueryDimensionFromName(name);
    queryDimension.setProperties(location, order, locationOrder);
    if (locationOrder >= 0) {
      //    locationOrderUpdated(name, locationOrder);
    }
  }

  /**
   * Especifica el nombre de la métrica por la que se desea ejecutar el ranking
   * @param name
   * @param rankMetricName
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setDimensionRankMetricName(String name, String rankMetricName) throws InfoException {
    QueryDimension queryDimension = getQueryDimensionFromName(name);
    queryDimension.setRankMetricName(rankMetricName);
  }

  /**
   * Especifica si se desea que los valores de la métrica estén visibles en el resultado de la query
   * @param name
   * @param visible
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setMetricVisible(String name, boolean visible) throws InfoException {
    QueryMetric queryMetric = getQueryMetricFromName(name);
    queryMetric.setVisible(visible);
  }

  /**
   * Especifica en que posición relativa a las métricas se ubica la métrica del nombre especificado.
   * El valor de <code>order</code> solo sirve para ordenar (comparar), no es obligatorio especificar números correlativos
   * @param name
   * @param order
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setMetricOrder(String name, int order) throws InfoException {
    QueryMetric queryMetric = getQueryMetricFromName(name);
    queryMetric.setMetricOrder(order);
    if (order <= 0) {
      metricOrderUpdated(name, order);
    }
  }


  /**
   * Reacomoda las métricas cuando cambia el orden
   * @param name
   * @param order
   */

  private void metricOrderUpdated(String name, int order) {
    for (Iterator iterator = metrics.iterator(); iterator.hasNext();) {
      QueryMetric queryMetric = (QueryMetric) iterator.next();
      if (name != queryMetric.getName() && queryMetric.getMetricOrder() >= order) {
        queryMetric.setMetricOrder(queryMetric.getMetricOrder() + 1);
      }
    }
  }

  /**
   * Especifica todas las propiedades de la métrica que afectan a la query
   * @param name
   * @param visible para mostrar u ocultar los valores de la métrica
   * @param order posición relativa a las métricas (si se quiere conservar el valor anterior parar el valor -1)
   * @throws es.indra.mare.common.info.InfoException
   */
  public void setMetricProperties(String name, boolean visible, int order) throws InfoException {
    QueryMetric queryMetric = getQueryMetricFromName(name);
    queryMetric.setMetricProperties(visible, order);
    if (order <= 0) {
      metricOrderUpdated(name, order);
    }
  }

  /**
   * Devuelve una métrica(<code>QueryMetric</code>) a partir de su nombre
   * @param name
   * @return
   * @throws es.indra.mare.common.info.InfoException
   */
  public QueryMetric getQueryMetricFromName(String name) throws InfoException {
    for (int i = 0; i < getMetrics().size(); i++) {
      QueryMetric queryMetric = (QueryMetric) getMetrics().get(i);
      if (queryMetric.getName().equalsIgnoreCase(name)) {
        return queryMetric;
      }
    }
    throw new InfoException(MessageFormat.format(LanguageTraslator.traslate("83"), new Object[]{name}));
  }

  /**
   * Devuelve una dimensión (<code>QueryDimension</code>) a partir de su nombre
   * @param name
   * @return
   * @throws es.indra.mare.common.info.InfoException
   */
  public QueryDimension getQueryDimensionFromName(String name) throws InfoException {
    for (int i = 0; i < getDimensions().size(); i++) {
      QueryDimension queryDimension = (QueryDimension) getDimensions().get(i);
      if (queryDimension.getName().equalsIgnoreCase(name)) {
        return queryDimension;
      }
    }
    throw new InfoException(MessageFormat.format(LanguageTraslator.traslate("84"), new Object[]{name}));
  }


  /**
   * Se utiliza para verificar si las propiedades asignadas a las dimensiones y a las métricas determinan una query válida
   * @return
   */
  public boolean isValid() {
    return getVisibleMetrics().size() > 0;
  }

  /** Devuelve los valores de parámetros especificados en la query, este método solo debería ser llamado desde la clase
   * <Code>Report</Code> para la ejecución de la query, para especificar u obtener los valores de los parámetros de la
   * query se deben utilizar los métodos <Code>getParamValue</Code> y <Code>setParamValue</Code>
   * @return
   */
  public Map getParamValues() {
    if (paramValues == null) {
      paramValues = initializeParamValues();
    }
    return paramValues;
  }

  private Map initializeParamValues() {
    return ReportFilterBuilder.mergeParamValues(null, getReportSpec().getParamValues(false));
  }

  /** Devuelve el valor un parámetro
   * @param key identificador del parámetro (nombre del filtro + nombre del parámetro)
   * @return valor del parámetro
   */

  public Object getParamValue(String key) {
    return getParamValues().get(key);
  }

  /** Devuelve el valor un parámetro
   *
   * @param filterName
   * @param parameterName
   * @return
   */
  public Object getParamValue(String filterName, String parameterName) {
    return getParamValue(filterName, parameterName);
  }

  /** Especifica el valor de un parámetro
   *
   * @param key identificador del parámetro
   * @param value valor del parámetro
   */
  public void setParamValue(String key, Object value) {
    getParamValues().put(key, value);
  }


  /** Especifica el valor de un parámetro
   *
   * @param filterName
   * @param parameterName
   * @param value
   */
  public void setParamValue(String filterName, String parameterName, Object value) {
    getParamValues().put(filterName + parameterName, value);
  }

  /**
   * Especifica los valores de varios parámetros contenidos en <code>paramValues</code> que es un <code>Map</code>
   * donde cada clave es el identificador de un parámetro y cada objeto asociado es el valor de un parámetro
   * @param paramValues
   */
  public void setParamValues(Map paramValues) {
    Iterator keys = paramValues.keySet().iterator();
    while (keys.hasNext()) {
      String key = (String) keys.next();
      setParamValue(key, paramValues.get(key));
    }
  }

  /**
   * devuelve un array que contiene
   * @return
   */
  public int[] getGroupingDimensionsIndexArray() {
    int[] groupingDimensions;
    int[] rows = getCubeRowFields();
    int[] cols = getCubeColumnFields();

    int rowsLenght;
    int columnsLenght;
    int dimensionsLenght;
    int index;

    rowsLenght = rows.length;
    columnsLenght = cols.length;
    dimensionsLenght = rowsLenght + columnsLenght;
    groupingDimensions = new int[dimensionsLenght];
    for (index = 0; index < rowsLenght; ++index) {
      groupingDimensions[index] = rows[index];
    }
    for (index = 0; index < columnsLenght; ++index) {
      groupingDimensions[index + rowsLenght] = cols[index];
    }
    return groupingDimensions;
  }


  /**
   * Construye un filtro de valores enumerados a excluir
   * @return
   */
  public EnumerationCubeFilter getEnumFilter() {
    EnumerationCubeFilter filter = EnumerationCubeFilter.excluding();
    Iterator iterator = getDimensionFilterValues().entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      filter.addTo((Set) entry.getValue(), ((Integer) entry.getKey()).intValue());
    }
    return filter;
  }

  /**
   * Construye un filtro (post-filtro) a partir de las definiciones de filtro de la definición de reporte y los valores
   * de los parámetros enviados por el usuario
   * @param params
   * @return
   */
  protected ExpressionCubeFilter getCubeFilter(Map params) throws InfoException {
    try {
      ReportFilterBuilder filterBuilder = new ReportFilterBuilder(getFilterDefinitions(), params, ReportFilterBuilder.VARMODE_INDEX);
      return filterBuilder.getCubeFilter(getReportSpec(), null);
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("85"), e);
    }
  }

  /**
   * Devuelve las definiciones de filtros de la definición del Reporte
   * @return
   * @throws es.indra.mare.common.info.InfoException
   */
  protected List getFilterDefinitions() throws InfoException {
    if (filterDefinitions == null) {
      filterDefinitions = new ArrayList();
      Collection filterSpecs = getReportSpec().getFilterSpecs();
      ReportFilter maxRowsFilter = getMaxRowsFilter();
      if (maxRowsFilter != null) {
        filterDefinitions.add(maxRowsFilter);
      }
      for (Iterator iterator = filterSpecs.iterator(); iterator.hasNext();) {
        ReportFilterSpec reportFilterSpec = (ReportFilterSpec) iterator.next();
        ReportFilter reportFilter = new ReportFilter(reportFilterSpec);
        filterDefinitions.add(reportFilter);
      }
    }
    return filterDefinitions;
  }

  /**
   * Devuelve el filtro para recuperar la información de la matriz por lotes de una cantidad fija
   * @return
   */
  private ReportFilter getMaxRowsFilter() {
    ReportFilter maxRowsFilter = null;
    ReportFilterSpec maxRowsFilterSpec = getReportSpec().getMaxRowsFilterSpec();
    if (maxRowsFilterSpec != null) {
      maxRowsFilter = new ReportFilter(maxRowsFilterSpec);
    }
    return maxRowsFilter;
  }


  /**
   * Deveulve los valores de una dimension excluidos para el filtro enumerado
   * @return
   */
  protected Map getDimensionFilterValues() {
    if (dimensionFilterValues == null) {
      dimensionFilterValues = new HashMap();
    }
    return dimensionFilterValues;
  }

  /**
   * Devuelve la query traducida a la forma que utiliza el módulo de cálculo de reportes estáticos.
   * @return
   * @throws es.indra.mare.common.info.InfoException
   */
  public StaticQuery getStaticQuery() throws InfoException {
    try {
      StaticQuery query = new StaticQuery();
      int[] group = getStaticGroupingDimensions();
      int[] noGroup = getStaticNonGroupingDimensions();
      int[] metrics = getCubeMetricFields();
      int[] accumulableMetrics = getStaticAccumulableMetricFields();
      boolean[] ascending = getDimensionOrder();
      query.setFilter(getCubeFilter(getParamValues()));
      query.setGroupDimensions(group);
      query.setNoGroupDimensions(noGroup);
      query.setMetrics(metrics);
      query.setAccumulableMetrics(accumulableMetrics);
      query.setAscending(ascending);
      query.setRankingFilter(getEnumerationFilter());

//      query.setFilter(getCubeFilter(getParamValues()));
      return query;
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("86"), e);
    }
  }

  /**
   * Devuelve los indices de las dimensiones que No agrupan
   * @return
   */
  private int[] getStaticNonGroupingDimensions() {
    return getDimensionIndexArray(getDimensionsByGrouping(false));
  }

  /**
   * Devuelve los indices de las dimensiones que agrupan
   */


  private int[] getStaticGroupingDimensions() {
    return getDimensionIndexArray(getDimensionsByGrouping(true));
  }

  /**
   * Deveulve una lista con las dimensiones segun su rol en la agrupación
   * @param groups
   * @return
   */

  private List getDimensionsByGrouping(boolean groups) {

    List list = new ArrayList();
    for (Iterator iterator = getDimensions().iterator(); iterator.hasNext();) {
      QueryDimension queryDimension = (QueryDimension) iterator.next();
      if (queryDimension.getGroups() == groups) {
        (list).add(queryDimension);
      }
    }
    Collections.sort(list, new Comparator() {
      public int compare(Object o1, Object o2) {
        QueryDimension dim1 = (QueryDimension) o1;
        QueryDimension dim2 = (QueryDimension) o2;
        return dim1.getLocationOrder() - dim2.getLocationOrder();
      }
    });
    return list;
  }


  /**
   * Devuelve la lista de valores de dimension excluidos para el filtro enumerado
   * @param dimension
   * @return
   */
  private Set getDimensionFilterValuesFor(int dimension) {
    Integer key = new Integer(dimension);
    Set values = (Set) getDimensionFilterValues().get(key);
    if (values == null) {
      values = new TreeSet();
      getDimensionFilterValues().put(key, values);
    }
    return values;

  }

  /**
   * Agrega un nuevo valor de dimension excluido
   * @param dimension
   * @param value
   */
  public void excludeValue(int dimension, Object value) {
    Set values = getDimensionFilterValuesFor(dimension);
    values.add(value);
  }

  /**
   * Elimina un valor de dimension excluido
   * @param dimension
   * @param value
   */

  public void includeValue(int dimension, Object value) {
    Set values = getDimensionFilterValuesFor(dimension);
    values.remove(value);
  }

  /**
   * Asocia una lista de valores excluidos a una dimensión
   * @param dimension
   * @param excludedValues
   */
  public void setExcludedValues(int dimension, Collection excludedValues) {
    getDimensionFilterValues().put(new Integer(dimension), excludedValues);
  }

  /**
   * Deveuelve la lista de valores excluidos de una dimensión
   * @param dimension
   * @return
   */
  public Set getExcludedValues(int dimension) {
    return (Set) getDimensionFilterValues().get(new Integer(dimension));
  }

  public boolean isVisibleTotals() {
    return visibleTotals;
  }

  public void setVisibleTotals(boolean visibleTotals) {
    this.visibleTotals = visibleTotals;
  }

  /**
   * Setea las metricas como visibles
   * @param otherMetrics
   */
  private void setMetricsVisible(Collection otherMetrics) {
    for (Iterator iterator = otherMetrics.iterator(); iterator.hasNext();) {
      QueryMetric queryMetric = (QueryMetric) iterator.next();
      queryMetric.setVisible(true);
    }
  }

  /**
   * Agrega las dimensiones a las QueryDimensions
   * @param otherDimensions
   */
  private void addDimensions(Collection otherDimensions) {
    getDimensions().addAll(otherDimensions);
  }

  /**
   * Setea como unica metrica visible la especificada
   * @param rankMetricName
   */
  public void setUniqueMetricVisible(String rankMetricName) {
    if(rankMetricName!=null && !rankMetricName.equalsIgnoreCase("")){
      List metrics = getMetrics();
      Iterator iter = metrics.iterator();
      while(iter.hasNext()){
        QueryMetric metric = (QueryMetric)iter.next();
        //Solo es visible si su nombre es el especificado
        if(metric.getName().equalsIgnoreCase(rankMetricName)){
          metric.setVisible(true);
        }else{
          metric.setVisible(false);
        }
      }
    }
  }

  /**
   * Agrega los filtros especificados al report spec.
   * @param filters
   */
  public void addFilters(Collection filters) {
    Iterator iter = filters.iterator();
    while(iter.hasNext()){
      getReportSpec().getFilterSpecs().add(iter.next());
    }
  }

  /**
   * Quita los filtros especificados del report spec
   * @param filters
   */
  public void removeFilters(Collection filters) {
    Iterator iter = filters.iterator();
    while(iter.hasNext()){
      getReportSpec().getFilterSpecs().remove(iter.next());
    }
  }

  public EnumerationCubeFilter getEnumerationFilter() {
    if(rankingFilter==null){
      rankingFilter = EnumerationCubeFilter.including();
    }
    return rankingFilter;
  }

  /**
   * Setea la dimension como unica visible para la query
   * @param dimension
   */
  public void setUniqueDimension(ReportDimensionSpec dimension) {
    List dimensions = getDimensions();
    String name = dimension.getName();
    Iterator iterator = dimensions.iterator();
    while(iterator.hasNext()){
      QueryDimension dim = (QueryDimension)iterator.next();
      if(dim.getName().equalsIgnoreCase(name)){
        dim.setLocation(DimensionDefinitionLocationType.ROW);
        dim.setGroups(true);
      }else{
        dim.setLocation(DimensionDefinitionLocationType.HIDDEN);
        dim.setGroups(false);
      }
    }
  }

}
