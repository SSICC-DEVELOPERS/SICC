package com.calipso.reportgenerator.reportcalculator;

import java.util.Iterator;
import java.io.Serializable;

/**
 * Representa los datos de un reporte de tipo estatico
 * en una estructura de arbol.
 */

public class DataTree implements Serializable, PivotClient {
  private DataTreeDefinition defintion;
  private StaticQuery query;
  private DataTreeNode root;

  /**
   * Obtiene la definicion asignada al <code>DataTree</code>
   * @return
   */
  public DataTreeDefinition getDefintion() {
    return defintion;
  }

  /**
   * Asigna una definicion al <code>DataTree</code>
   * @param definition
   */
  public void setDefinition(DataTreeDefinition definition) {
    this.defintion = definition;
  }

  public Iterator valuesFor(int dimension, int[] previousDimensions, Object[] values) {
    return null;
  }

  /**
   * Devuelve el iterador del <code>DataTree</code>
   * @return
   */
  public DataTreeIterator iterator() {
    return DataTreeIterator.on(this);
  }

  public Object[] measuresAtDimensionsValues(int[] dimensions, Object[] values) {
    return new Object[0];
  }

  /**
   * Asigna la <code>StaticQuery</code> al <code>DataTree</code>
   * @param staticQuery
   */
  public void setQuery(StaticQuery staticQuery) {
    this.query = staticQuery;
  }

  /**
   * * Reinicializa el <code>DataTree</code>. Como efecto se pierden todos los datos actuales.
   */
  public void reset() {
    root = null;
  }

  /**
   * Devuelve la raiz del <code>DataTree</code>.
   * @return
   */
  public DataTreeNode getRoot() {
    if (root == null) {
      root = new DataTreeNode(null, "Root", query.getMetrics().length, -1);
    }
    return root;
  }

  /**
   * Crea una rama del arbol a partir del array que recibe por parametro.
   * Por cada dimension que agrupa se crea u obtiene un ya creado
   * <code>DataTreeNode</code>, excepto para la ultima dimension.
   * A cada instancia de <code>DataTreeNode</code> de cada dimension que agrupa,
   * se le actualizan las metricas, es decir, se recalcula el total de estas
   * sumando las actuales mas las acumuladas, excepto para la ultima dimension,
   * en tal caso se crea una instancia de <code>DataTreeSubItem</code>, que representan
   * las hojas del arbol.
   * @param row
   */
  public void fillWith(Object[] row) {
    int[] groupDims = query.getGroupDimensions();
    int[] noGroupDims = query.getNoGroupDimensions();

    if(query.matches(row)) {
      DataTreeNode currentNode = getRoot();
      SharedFloat[] metricValues = new SharedFloat[query.getMetrics().length];
      fillMetricValues(metricValues, row);
      updateMetricValues(currentNode, metricValues);

      for ( int i = 0; i < groupDims.length; i++) {
        int index = groupDims[i];
        currentNode = currentNode.getNodeFrom(row[index], index );
        updateMetricValues(currentNode, metricValues);
      }

      Object[] noGroupDimValues = new Object[noGroupDims.length];
      for (int i = 0; i < noGroupDims.length; i++) {
        int index = noGroupDims[i];
        noGroupDimValues[i] = row[index];
      }
      DataTreeSubItem subItem = currentNode.getSubItem(noGroupDimValues);
      subItem.updateMetricValues(metricValues);
    }
  }

  /**
   * Llena un array con los valores de las metricas correspondientes
   * en el objeto Object[] row que recibe por parametro.
   * @param metricValues
   * @param row
   */
  private void fillMetricValues(SharedFloat[] metricValues, Object[] row) {
    int[] metrics = query.getMetrics();
    for (int i = 0; i < metrics.length; i++){
      int index = metrics[i];
      metricValues[i] = SharedFloat.newFrom(((Float) row[index]).floatValue());
    }
  }

  /**
   * Asigna para el nodo correspondiente los valores de las metricas
   * del array recibido por parametro.
   * @param node
   * @param metricValues
   */
  private void updateMetricValues(DataTreeNode node, SharedFloat[] metricValues) {
    for (int i = 0; i < metricValues.length; i++) {
      node.updateMetricValue(i, metricValues[i]);
    }
  }


  /**
   * Devuelve la <code>StaticQuery</code> asignada al <code>DataTree</code>
   * @return
   */
  public StaticQuery getQuery() {
    return query;
  }
  /**
   * Sirve para pasar el indice de la metrica en el DataSource al
   * indice de la metrica en el array de metricValues del
   * subItem.
   */
  public void afterFill() {
    int[] metrics = query.getMetrics();
    int[] accMetrics = query.getAccumulableMetrics();
    int[] adjAccMetrics = new int[accMetrics.length];
    for (int i = 0; i < accMetrics.length; i++) {
      int metricIndex = -1;
      for (int j = 0; j < metrics.length; j++) {
        if (accMetrics[i] == metrics[j]){
          metricIndex = j;
          break;
        }
      }
      adjAccMetrics[i] = metricIndex;
    }
    if (getDefintion().getAccumulable()){
      getRoot().calculateAccumulable(adjAccMetrics);
    }
  }
}
