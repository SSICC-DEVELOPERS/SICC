package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.FilterDefinition;
import com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa a una definición de filtro y tiene los métodos necesarios para su construcción y evaluación
 * Se utiliza tanto para los pre-filtros como para los post-filtros
 */

public class ReportFilterSpec implements Serializable {
  private String name;
  private String dimensionName;
  private FilterDefinitionFilterTypeType filterType;
  private boolean visual;
  private ReportDataType dataType;

  /**
   * Inicializa los atributos a partir de un FilterDefinition
   * @param definition
   */

  public void fillFrom(FilterDefinition definition) {
    this.name = definition.getName();
    this.dimensionName = definition.getDimensionName();
    this.filterType = definition.getFilterType();
    this.visual = definition.getVisual();
    this.dataType = definition.getDataType();
  }

  /**
   * Devuelve el nombre del filtro
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Asigna el nombre del filtro
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Devuelve el nombre de la dimensión a la que se le desean filtrar los valores
   * @return
   */
  public String getDimensionName() {
    return dimensionName;
  }

  /**
   * Asigna el nombre de la dimensión a la que se le desean filtrar los valores
   * @param dimensionName
   */
  public void setDimensionName(String dimensionName) {
    this.dimensionName = dimensionName;
  }

  /**
   * Devuelve el tipo de dato de el filtro si existe
   * @return
   */
  public ReportDataType getDataType() {
    return dataType;
  }

  /**
   * Setea el tipo de dato del filtro
   * @param dataType
   */
  public void setDataType(ReportDataType dataType) {
    this.dataType = dataType;
  }

  /**
   * Deveulve el tipo de filtro (Rango, mayor que, etc)
   * @return
   */
  public FilterDefinitionFilterTypeType getFilterType() {
    return filterType;
  }

  /**
   * Asigna el tipo de filtro
   * @param filterType
   */
  public void setFilterType(FilterDefinitionFilterTypeType filterType) {
    this.filterType = filterType;
  }

  /**
   * Devuelve verdadero si los valores de los parámetros de este filtro seben ser preguntados al usuario
   * @return
   */
  public boolean getVisual() {
    return visual;
  }

  /**
   * Especifica si los valores de los parámetros de este filtro seben ser preguntados al usuario
   * @param visual
   */
  public void setVisual(boolean visual) {
    this.visual = visual;
  }

  public List getParamNames() {
    List result = new ArrayList();
    switch (getFilterType().getType()) {
      case FilterDefinitionFilterTypeType.BEGINWITH_TYPE:
      case FilterDefinitionFilterTypeType.ENDWITH_TYPE:
      case FilterDefinitionFilterTypeType.EQUALTO_TYPE:
      case FilterDefinitionFilterTypeType.GREATERTHAN_TYPE:
      case FilterDefinitionFilterTypeType.INCLUDES_TYPE:
      case FilterDefinitionFilterTypeType.LESSTHAN_TYPE:
      case FilterDefinitionFilterTypeType.RANKING_TYPE:
        result.add(getName() + "VALUE");
        break;
      case FilterDefinitionFilterTypeType.RANGE_TYPE:
        result.add(getName() + "FROM");
        result.add(getName() + "TO");
        break;
      case FilterDefinitionFilterTypeType.IN_TYPE:
        result.add(getName() + "VALUES");
    }
    return result;
  }

  public boolean includesParam(String paramName) {
    return getParamNames().indexOf(paramName) != -1;
  }
}
