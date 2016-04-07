package com.calipso.reportgenerator.common;

import java.io.Serializable;

/**
 * Esta clase contiene toda la información referente a una métrica necesaria para ejecutar una consulta (<code>ReportQuery</code>)
 */
public class QueryMetric implements Serializable {

  private String name;
  private int index;
  private boolean visible;
  private int metricOrder;
  private boolean accumulable;

  /**
   * Inicializa un objeto QueryMetric
   * @param name nombre del la métrica
   * @param index indice del campo en el registro de la matriz
   * @param visible especifica si la métrica será visible cuando se muestre el resultado de la consulta
   * @param metricOrder número que se utiliza para ordenar las métricas en caso de haber mas de una
   */
  public QueryMetric(String name, int index, boolean visible, int metricOrder, boolean accumulable) {
    this.name = name;
    this.index = index;
    this.visible = visible;
    this.metricOrder = metricOrder;
    this.accumulable = accumulable;
  }

  /**
   * Devuelve el name
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Devuelve el index
   * @return
   */
  public int getIndex() {
    return index;
  }

  /**
   * Devuelve el valor de visible
   * @return
   */
  public boolean getVisible() {
    return visible;
  }

  /**
   * Asigna la propiedad visible
   * @param visible
   */
  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  /**
   * Devuelve el metric order
   * @return
   */
  public int getMetricOrder() {
    return metricOrder;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Asigna el metric order
   * @param metricOrder
   */
  public void setMetricOrder(int metricOrder) {
    this.metricOrder = metricOrder;
  }

  /**
   * Asigna las propiedades
   * @param visible
   * @param order
   */
  public void setMetricProperties(boolean visible, int order) {
    this.visible = visible;
    if (order >= 0) {
      this.metricOrder = order;
    }
  }

  public boolean isAccumulable() {
    return accumulable;
  }

  public void setAccumulable(boolean accumulable) {
    this.accumulable = accumulable;
  }
}
