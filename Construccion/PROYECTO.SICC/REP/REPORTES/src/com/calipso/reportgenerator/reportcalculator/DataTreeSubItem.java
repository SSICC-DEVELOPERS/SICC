package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportcalculator.SharedFloat;

import java.io.Serializable;

/**
 * Representa una hoja del arbol <code>DataTree</code>
 */

public class DataTreeSubItem implements Serializable{
  Object[] nonGroupingDimensionValues;
  SharedFloat[] metricValues;
  private SharedFloat[] accumulableMetricValues;
  private int[] adjMetricIndexes;

  /**
   * Inicializa una instancia de <code>DataTreeSubItem</code>
   * @param nonGroupingDimensionValues
   * @param metricValues
   */
  public DataTreeSubItem(Object[] nonGroupingDimensionValues, int metricCount){//, SharedFloat[] metricValues/*, CubeFloat[] accumulableMetricValues*/) {
    this.nonGroupingDimensionValues = nonGroupingDimensionValues;
    this.metricValues = new SharedFloat[metricCount];
    //this.accumulableMetricValues = accumulableMetricValues;
    initialize();
  }

  private void initialize() {
    for (int i = 0; i < metricValues.length; i++) {
      metricValues[i] = SharedFloat.newFrom(0);
    }
  }

  /**
   * Devuelve los valores de las dimensiones que no agrupan.
   * @return
   */
  public Object[] getNonGroupingDimensionValues() {
    return nonGroupingDimensionValues;
  }

  /**
   * Devuelve un array con los valores de las metricas.
   * @return
   */
  public SharedFloat[] getMetricValues() {
    return metricValues;
  }

  /**
   * Asigna un array que contiene las metricas acumulables.
   * @param accumulableMetricValues
   */
  public void setAccumulableMetricValues(SharedFloat[] accumulableMetricValues) {
    this.accumulableMetricValues = accumulableMetricValues;
  }

  public void setAdjMetricIndexes(int[] adjMetricIndexes){
    this.adjMetricIndexes = adjMetricIndexes;
  }

  /**
   * Devuelve un array que contiene los valores
   * de las metricas acumulables.
   * @return
   */
  public SharedFloat[] getAccumulableMetricValues() {
    if (accumulableMetricValues == null) {
      return new SharedFloat[0];
    }
    return accumulableMetricValues;
  }

  public int getMetricIndex(int index) {
    if (adjMetricIndexes != null && adjMetricIndexes.length > index ){
      return adjMetricIndexes[index];
    }
    else {
      return index;
    }

  }

  public boolean matches(Object[] noGroupDimValues) {
    for(int i=0; i<noGroupDimValues.length && i<nonGroupingDimensionValues.length; i++){
      if(!nonGroupingDimensionValues[i].equals(noGroupDimValues[i])){
        return false;
      }
    }
    return true;
  }

  public void updateMetricValues(SharedFloat[] newMetricValues) {
    for (int i = 0; i < metricValues.length; i++) {
      metricValues[i] = metricValues[i].add(newMetricValues[i]);
    }
  }

}
