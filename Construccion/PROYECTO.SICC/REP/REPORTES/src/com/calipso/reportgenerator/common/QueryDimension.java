package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType;

import java.io.Serializable;


/**
 * Esta clase contiene toda la información referente a una dimensión necesaria para ejecutar una consulta (<code>ReportQuery</code>)
 */

public class QueryDimension implements Serializable {

  private String name;
  private int index;
  private DimensionDefinitionLocationType location;
  private int locationOrder;
  private DimensionDefinitionOrderType order;
  private boolean groups;
  private String rankMetricName;


  /**
   * Inicializa un objeto QueryDimension
   * @param name nombre del la dimensión
   * @param index indice del campo en el registro de la matriz
   * @param location ubicación el la que agrupa (<code>LocationType.ROW, LocationType.COLUMN, LocationType.PAGE</code>)
   * @param order tipo de ordenamiento de los valores de la dimensión (ascendente/descendente)
   * @param locationOrder número utilizado para ordener las dimensiones en cada una de las ubicaciones de agrupción (location)
   */
  public QueryDimension(String name, int index, DimensionDefinitionLocationType location, DimensionDefinitionOrderType order, int locationOrder, boolean groups, String rankMetricName) {
    this.name = name;
    this.index = index;
    this.location = location;
    this.order = order;
    this.rankMetricName = rankMetricName;
    this.locationOrder = locationOrder;
    this.groups = groups;
  }

  /**
   * Retorna el nombre
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Retorna el índice
   * @return
   */
  public int getIndex() {
    return index;
  }

  /**
   * Retorna el location type
   * @return
   */
  public DimensionDefinitionLocationType getLocation() {
    return location;
  }

  /**
   * Retorna el Order
   * @return
   */
  public DimensionDefinitionOrderType getOrder() {
    if (order == null){
      return DimensionDefinitionOrderType.A;
    }
    return order;
  }

  /**
   * Asigna el location type
   * @param location
   */
  public void setLocation(DimensionDefinitionLocationType location) {
    this.location = location;
  }

  /**
   * Asigna el Order
   * @param order
   */
  public void setOrder(DimensionDefinitionOrderType order) {
    this.order = order;
  }

  /**
   * Devuelve el location Order
   * @return
   */
  public int getLocationOrder() {
    return locationOrder;
  }

  /**
   * Asigna el location order
   * @param locationOrder
   */
  public void setLocationOrder(int locationOrder) {
    this.locationOrder = locationOrder;
  }

  /**
   * Asigna las propiedades
   * @param location
   * @param order
   * @param locationOrder
   */
  public void setProperties(DimensionDefinitionLocationType location, DimensionDefinitionOrderType order, int locationOrder) {
    if (location != null) {
      this.location = location;
    }
    if (order != null) {
      this.order = order;
    }
    if (locationOrder >= 0) {
      this.locationOrder = locationOrder;
    }
  }

  public boolean getGroups() {
    return groups;
  }

  public void setGroups(boolean groups) {
    this.groups = groups;
  }

  public String getRankMetricName() {
    return rankMetricName;
  }

  public void setRankMetricName(String rankMetricName) {
    this.rankMetricName = rankMetricName;
  }

}
