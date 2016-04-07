package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.io.Serializable;
import java.util.TreeMap;

/**
 * Representa un nodo del arbol <code>DataTree</code>
 */

public class DataTreeNode implements Serializable{
  private Object value;
  private List subItems;
  private SharedFloat[] metrics;
  //private CubeFloat[] accumulableMetrics;
  private Map subNodes;
  private DataTreeNode parent;
  private int dimensionIndex;


  /**
   * Inicializa una instancia de <code>DataTreeNode</code>.
   * @param parent nodo padre del actual
   * @param value valor del nodo
   * @param metricCount cantidad de metricas asociadas al nodo
   * @param dimensionIndex indice del nodo
   */
  public DataTreeNode(DataTreeNode parent, Object value, int metricCount, /*int accumulableMetricCount,*/ int dimensionIndex) {
    this.parent = parent;
    this.value = value;
    this.subItems = new ArrayList();
    this.metrics = new SharedFloat[metricCount];
    //this.accumulableMetrics = new CubeFloat[accumulableMetricCount];
    this.dimensionIndex = dimensionIndex;
    initialize();
  }

  /**
   * Inicializa el array metrics del nodo
   */
  private void initialize() {
    for (int i = 0; i < metrics.length; i++){
      metrics[i] = SharedFloat.newFrom(0);
    }

    /*for (int i = 0; i < accumulableMetrics.length; i++){
      accumulableMetrics[i] = new CubeFloat(0);
    } */

  }

  /**
   * Retorna el indice del nodo.
   * @return
   */
  public int getDimensionIndex() {
    return dimensionIndex;
  }

  /**
   * Asigna un indice al nodo.
   * @param dimensionIndex
   */
  public void setDimensionIndex(int dimensionIndex) {
    this.dimensionIndex = dimensionIndex;
  }

  /**
   * Retorna el valor del nodo.
   * @return
   */
  public Object getValue() {
    return value;
  }

  /**
   * Devuelve una lista con instancias del tipo <code>DataTreeSubItem</code>
   * del nodo actual.
   * @return
   */
  public List getSubItems() {
    return subItems;
  }

  /**
   * Devuelve un array con los valores de las metricas del nodo.
   * @return
   */
  public SharedFloat[] getMetrics() {
    return metrics;
  }

  /*public CubeFloat[] getAccumulableMetrics() {
    return accumulableMetrics;
  } */

  /**
   * Devuelve un diccionario que contiene los subNodos del nodo actual.
   * @return
   */
   //Ver tema de ascending y descending
  public Map getSubNodes() {
    if (subNodes == null) {
      subNodes = new TreeMap();
    }
    return subNodes;
  }

  /**
   * Devuelve un nodo hijo a partir del Key recibido por parametro.
   * Si no existiera tal nodo, se crea uno nuevo, se agrega
   * al diccionario de subNodos y se retorna.
   * @param key
   * @param dimensionIndex
   * @return
   */
  public DataTreeNode getNodeFrom(Object key, int dimensionIndex) {
    DataTreeNode node;
    if (getSubNodes().containsKey(key)) {
      node =  (DataTreeNode) getSubNodes().get(key);
    }
    else {
      node = new DataTreeNode(this, key, metrics.length, /*accumulableMetrics.length,*/ dimensionIndex );
      getSubNodes().put(key, node);
    }
    return node;
  }

  /**
   * Actualiza los valores de las metricas del nodo.
   * Si el nodo tiene subNodos se recalculan los valores de las metricas en base
   * a los actuales mas los ya acumulados, no asi en caso de que el nodo no tenga
   * subnodos.
   * @param index
   * @param value
   */
  public void updateMetricValue(int index, SharedFloat value) {
    metrics[index] = (metrics[index]).add(value);
    // Para una metrica acumulada poner todo!
    // accumIndex --> averiguar el indice de la que acumula esta métrica
    /*CubeFloat newValue = new CubeFloat(((CubeFloat)getParent().getMetrics()[accumIndex]).floatValue());
    newValue.add((Float) value);
    ((CubeFloat)metrics[index]).add(newValue.floatValue());
    */
  }

  /**
   * Devuelve el nodo padre del nodo.
   * @return
   */
  public DataTreeNode getParent() {
    return parent;
  }

  /**
   * Asigna el valor al nodo.
   * @param value
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Asigna una instancia de tipo <code>DataTreeSubItem</code>
   * al nodo.
   * @param subItem
   */
  public void addSubItem(DataTreeSubItem subItem) {
    getSubItems().add(subItem);
  }

  /**
   * Acumula el/los valor/es de la/s metrica/s acumulable/s correspondiente
   * a cada <code>DataTreeSubItem</code>.
   * @param adjAccumulableMetrics
   */
  public void calculateAccumulable(int[] adjAccumulableMetrics) {
    Iterator subNodesIter = getSubNodes().values().iterator();
    while (subNodesIter.hasNext()) {
      DataTreeNode dataTreeNode = (DataTreeNode) subNodesIter.next();
      dataTreeNode.calculateAccumulable(adjAccumulableMetrics);
    }

    SharedFloat[] accValues = new SharedFloat[adjAccumulableMetrics.length];
    Iterator subItemsIter = getSubItems().iterator();
    while (subItemsIter.hasNext()) {
      DataTreeSubItem subItem = (DataTreeSubItem) subItemsIter.next();
      for (int i = 0; i < accValues.length; i++) {
        if (accValues[i] == null) {
          accValues[i] = SharedFloat.newFrom(0);
        }
        accValues[i] = accValues[i].add(subItem.getMetricValues()[adjAccumulableMetrics[i]]);
      }
      subItem.setAccumulableMetricValues(copyOf(accValues));
      subItem.setAdjMetricIndexes(adjAccumulableMetrics);
    }
  }

  /**
   * Retorna una copia de los valores de las metricas que viene
   * en el array recibido por parametro.
   * @param source
   * @return
   */
  private SharedFloat[] copyOf(SharedFloat[] source) {
    SharedFloat[] result = new SharedFloat[source.length];
    for (int i = 0; i < source.length; i++) {
      result[i] = SharedFloat.newFrom(source[i].floatValue());
    }
    return result;
  }

  public DataTreeSubItem getSubItem(Object[] noGroupDimValues) {
    Iterator iterator = getSubItems().iterator();
    while (iterator.hasNext()) {
      DataTreeSubItem dataTreeSubItem = (DataTreeSubItem) iterator.next();
      if(dataTreeSubItem.matches(noGroupDimValues)){
        return dataTreeSubItem;
      }
    }
    DataTreeSubItem subItem = new DataTreeSubItem(noGroupDimValues, getMetrics().length);
    getSubItems().add(subItem);
    return subItem;
  }
}
