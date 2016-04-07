package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.DataTree;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.DataTreeSubItem;
import com.calipso.reportgenerator.reportcalculator.StaticQuery;
import com.calipso.reportgenerator.reportcalculator.DataTreeNode;
import com.calipso.reportgenerator.common.ReportTableModel;
import es.indra.mare.common.info.InfoException;

import java.util.Vector;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Dec 16, 2003
 * Time: 3:03:05 PM
 * To change this template use Options | File Templates.
 */

public class StaticReportTableModel extends ReportTableModel {

  private StaticReportResult reportResult;

  public StaticReportTableModel(StaticReportResult reportResult) {
    super();
    this.reportResult = reportResult;
    try {
      initialize();
    } catch (InfoException e) {
      e.printStackTrace();
    }
  }

  public StaticReportTableModel(ReportSpec reportSpec, ReportQuery query){
    super();
    initialize(reportSpec, query);
  }

  public StaticReportTableModel(ReportSpec reportSpec) throws InfoException{
    super();
    ReportQuery query = new ReportQuery(reportSpec);
    initialize(reportSpec, query);
  }

  private void initialize(ReportSpec reportSpec, ReportQuery query){
    Object [] groupingDimensions;
    Object [] nonGroupingDimensions;
    groupingDimensions = reportSpec.getVisibleDimensionsByGrouping(true);
    nonGroupingDimensions = reportSpec.getVisibleDimensionsByGrouping(false);
    Object [] totalMetrics = reportSpec.getMetrics();
    setGroupingDimCount(groupingDimensions.length);
    setNonGroupingDimCount(nonGroupingDimensions.length);
    setCommonMetricsCount(query.getVisibleMetrics().size());
    setAccMetricsCount(query.getVisibleAccumulableMetrics().size());
    setTableColumnNames(getSpecTableModelColumns(groupingDimensions, nonGroupingDimensions, totalMetrics));
//    setTableData(getTableModelData());
    newNonDataTableModel();
  }

  protected Vector getSpecTableModelColumns(Object[] groupingDimensions, Object[] nonGroupingDimensions, Object[] metricsArray) {
    Vector columnNames = new Vector();
    for (int i = 0; i < groupingDimensions.length; i++) {
      ReportDimensionSpec qd = (ReportDimensionSpec) groupingDimensions[i];
      columnNames.add(qd.getName());
    }
    for (int i = 0; i < nonGroupingDimensions.length; i++) {
      ReportDimensionSpec qd = (ReportDimensionSpec) nonGroupingDimensions[i];
      columnNames.add(qd.getName());
    }
    for (int i = 0; i < metricsArray.length; i++) {
      ReportMetricSpec qm = (ReportMetricSpec) metricsArray[i];
      columnNames.add(qm.getName());
    }
    return columnNames;
  }

  private void initialize() throws InfoException {
    Object [] groupingDimensions = getGroupingDimensions();
    Object [] nonGroupingDimensions = getNonGroupingDimensions();
    Object [] totalMetrics = getTotalMetrics();
    setGroupingDimCount(groupingDimensions.length);
    setNonGroupingDimCount(nonGroupingDimensions.length);
    setCommonMetricsCount(reportResult.getReportQuery().getVisibleMetrics().size());
    setAccMetricsCount(reportResult.getReportQuery().getVisibleAccumulableMetrics().size());
    setTableColumnNames(getTableModelColumns(groupingDimensions, nonGroupingDimensions, totalMetrics));
    setTableData(getTableModelData());
    newDefaultTableModel();
  }

  /**
   * Obtiene los valores de las Dimensiones que agrupan, es decir, las Row Dimensiones
   * a partir de un reporte tipo Static.
   * @return array que contiene objetos de tipo QueryDimension
   * @throws es.indra.mare.common.info.InfoException
   */
  private Object[] getGroupingDimensions() throws InfoException {
    StaticQuery staticQuery = reportResult.getDataTree().getQuery();
    int[] dimensionIndexes = staticQuery.getGroupDimensions();
    return getQueryDimensionsArray(dimensionIndexes, reportResult);
  }

  /**
   * Obtiene los valores de las Dimensiones que no agrupan, es decir, las Row Dimensiones
   * a partir de un reporte tipo Static.
   * @return array que contiene objetos de tipo QueryDimension
   * @throws es.indra.mare.common.info.InfoException
   */
  private Object[] getNonGroupingDimensions() throws InfoException {
    StaticQuery staticQuery = reportResult.getDataTree().getQuery();
    int[] dimensionIndexes = staticQuery.getNoGroupDimensions();
    return getQueryDimensionsArray(dimensionIndexes, reportResult);
  }

  /**
   * Inicializa un array con objetos de tipo QueryDimension.
   * @param indexes array que contiene los valores de las dimensiones
   * @param reportResult necesario para obtener los valores de las dimensions
   * @return array que contiene objetos de tipo QueryDimension
   * @throws es.indra.mare.common.info.InfoException
   */
  private Object[] getQueryDimensionsArray(int[] indexes, ReportResult reportResult) throws InfoException {
    ReportQuery query = reportResult.getReportQuery();
    Object[] result = new Object[indexes.length];
    for (int i = 0; i < indexes.length; i++) {
      String name = reportResult.getReportSpec().getDimensionFromIndex(indexes[i]).getName();
      QueryDimension dimension = query.getQueryDimensionFromName(name);
      result[i] = dimension;
    }
    return result;
  }

  private Object[] getTotalMetrics() {
    Object [] metricsNames = reportResult.getReportQuery().getVisibleMetrics().toArray();
    Object [] accuMetricsNames = reportResult.getReportQuery().getAccumulableMetrics().toArray();
    Object [] allMetrics = new Object[metricsNames.length + accuMetricsNames.length];
    int i = 0;
    for( ; i < metricsNames.length ; i++) {
      allMetrics[i] = metricsNames[i];
    }
    for(int j = 0 ; j < accuMetricsNames.length ; j++, i++) {
      QueryMetric queryMetric = (QueryMetric) accuMetricsNames[j];
      queryMetric.setName(queryMetric.getName() + "_ACCUM");//LanguageTraslator.traslate("314")
      allMetrics[i] = queryMetric;
    }
    return allMetrics;
  }

  /**
   * Devuelve un vector que contiene los datos para el model de la tabla
   * para un reporte de tipo estatico
   * @return datos para el model de la tabla
   */
  private Vector getTableModelData() {
    DataTree dataTree = reportResult.getDataTree();
    Vector vec = getDataVector(dataTree);
    if (vec.size()==0){
      //vec.add(getNullVector());
      setEmptyReport(new Boolean(true));
    }
    return vec;
  }


   private Vector getNullVector()
   {
      int index = this.reportResult.getReportQuery().getDimensions().size()+this.reportResult.getReportQuery().getMetrics().size();
      Vector row = new Vector(index);   
      for (int i = 0; i<this.reportResult.getReportQuery().getDimensions().size();i++){
        row.add("");
      }
      for (int i = 0; i<this.reportResult.getReportQuery().getMetrics().size();i++){
        row.add(new Float(0));
      }
      return row;
   }
   
  /**
   * Se ejecuta en caso de que el tipo de Reporte sea Static. Devuelve un vector
   * que contiene los datos de la tabla necesarios para generar el modelo
   * @param dataTree arbol de datos
   * @return datos de la tabla
   */
  private Vector getDataVector(DataTree dataTree) {
    Vector dataVector = new Vector();
    Vector previousValues = new Vector();
    fillFromNode(dataVector, dataTree.getRoot(), previousValues);
    return dataVector;
  }

  /**
   * Itera el arbol de datos y llena un vector que contiene los datos
   * en formato plano para generar el modelo de la table
   * @param dataVector datos necesarios para generar la tabla
   * @param node nodo del arbol de datos
   * @param previousValues
   */
  private void fillFromNode(Vector dataVector, DataTreeNode node, Vector previousValues) {
    if (node.getSubNodes().size() == 0) {
      Iterator iterator = node.getSubItems().iterator();
      while (iterator.hasNext()) {
        DataTreeSubItem subItem = (DataTreeSubItem) iterator.next();
        dataVector.add(getItemVector(previousValues, subItem));
      }
    }
    else {
      Iterator iterator = node.getSubNodes().values().iterator();
      while (iterator.hasNext()) {
        DataTreeNode subNode = (DataTreeNode) iterator.next();
        previousValues.add(ReportMap.setValueToSimpleType(subNode.getValue()));
        fillFromNode(dataVector, subNode, previousValues);
        previousValues.remove(previousValues.size() - 1);
      }
    }
  }

  /**
   * Devuelve un vector que contiene los datos de una fila.
   * @param previousValues
   * @param subItem
   * @return
   */
  private Vector getItemVector(Vector previousValues, DataTreeSubItem subItem) {
    Vector itemVector = new Vector(previousValues);
    Object[] ngValues = subItem.getNonGroupingDimensionValues();
    for (int i = 0; i < ngValues.length; i++) {
      Object ngValue = ReportMap.setValueToSimpleType(ngValues[i]);
      itemVector.add(ngValue);
    }

    SharedFloat[] metricValues = subItem.getMetricValues();
    for (int i = 0; i < metricValues.length; i++) {
      SharedFloat metricValue = metricValues[i];
      itemVector.add(new Float(metricValue.floatValue()));
    }


    SharedFloat[] accMetricValues = subItem.getAccumulableMetricValues();
    for (int i = 0; i < accMetricValues.length; i++) {
      SharedFloat accMetricValue = accMetricValues[i];
      itemVector.add(new Float(accMetricValue.floatValue()));
    }

    return itemVector;
  }
}
