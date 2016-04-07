package com.calipso.reportgenerator.reportcalculator;

import java.util.Arrays;
import java.io.Serializable;

/**
 * Representa la query para un reporte de tipo estatico.
 */

public class StaticQuery implements Serializable{
  private int[] groupDimensions;
  private int[] noGroupDimensions;
  private int[] metrics;
  private int[] accumulableMetrics;
  private int[] dimensions;
  private boolean[] ascending;
  private ExpressionCubeFilter filter;
  private EnumerationCubeFilter rankingFilter;

  public void setRankingFilter(EnumerationCubeFilter rankingFilter) {
    this.rankingFilter = rankingFilter;
  }

  /**
   * Inicializa una nueva Query
   */
  public StaticQuery() {
    initialize();
  }

  /**
   * Inicializa las estructuras que contendrán la información acerca de las dimensiones y métricas involucradas
   */
  private void initialize() {
    setGroupDimensions(new int[0]);
    setNoGroupDimensions(new int[0]);
    setMetrics(new int[0]);
  }

  /**
   * Devuelve un array que contiene los indices de las dimensiones que agrupan
   * @return
   */
  public int[] getGroupDimensions() {
    return groupDimensions;
  }

  /**
   * Asigna un array que contiene los indices de las dimensiones que agrupan
   * @param groupDimensions
   */
  public void setGroupDimensions(int[] groupDimensions) {
    this.groupDimensions = groupDimensions;
  }

  /**
   * Devuelve un array que contiene los indices de las dimensiones que no agrupan
   * @return
   */
  public int[] getNoGroupDimensions() {
    return noGroupDimensions;
  }

  /**
   * Asigna un array que contiene los indices de las dimensiones que no agrupan
   * @param noGroupDimensions
   */
  public void setNoGroupDimensions(int[] noGroupDimensions) {
    this.noGroupDimensions = noGroupDimensions;
  }

  /**
   * Devuelve un array que contiene los indices de las metricas
   * @return
   */
  public int[] getMetrics() {
    return metrics;
  }

  /**
   * Devuelve un array que contiene los indices de las metricas acumulables
   * @return
   */
  public int[] getAccumulableMetrics() {
    return accumulableMetrics;
  }

  /**
   * Asigna un array que contiene los indices de las metricas
   * @param metrics
   */
  public void setMetrics(int[] metrics) {
    this.metrics = metrics;
  }

  /**
   * Asigna un array que contiene los indices de las metricas acumulables
   * @param accumulableMetrics
   */
  public void setAccumulableMetrics(int [] accumulableMetrics) {
    this.accumulableMetrics = accumulableMetrics;
  }

  /**
   * Devuelve un array que indica el criterio de orden
   * de las dimensiones
   * @return
   */
  public boolean[] getAscending() {
    if (ascending == null) {
      ascending = new boolean[dimensions.length];
      Arrays.fill(ascending, true);
    }
    return ascending;
  }

  /**
   * Asigna un array que contiene el criterio de orden
   * para las dimensiones
   * @param ascending
   */
  public void setAscending(boolean[] ascending) {
    this.ascending = ascending;
  }

  /**
   * Devuelve un array que contiene los indices
   * de las dimensiones que agrupan y que no agrupan
   * @return
   */
  public int[] getDimensions() {
    if (dimensions == null) {
      fillDimensions();
    }
    return dimensions;
  }

  /**
   * Llena un array que contiene los indices de las dimensiones
   * que agrupan y aquellas que no agrupan.
   */
  private void fillDimensions() {
    int groupLenght;
    int noGroupLenght;
    int dimensionsLenght;
    int index;

    groupLenght = groupDimensions.length;
    noGroupLenght = noGroupDimensions.length;
    dimensionsLenght = groupLenght + noGroupLenght;
    dimensions = new int[dimensionsLenght];
    for (index = 0; index < groupLenght; ++index) {
      dimensions[index] = groupDimensions[index];
    }
    for (index = 0; index < noGroupLenght; ++index) {
      dimensions[index + groupLenght] = noGroupDimensions[index];
    }
  }

  public ExpressionCubeFilter getFilter() {
    return filter;
  }

  public void setFilter(ExpressionCubeFilter filter) {
    this.filter = filter;
  }

  /**
   * Aplica el filtro a una row y devuelve verdadero si cumple con la condición
   * @param row
   * @return
   */
  public boolean matches(Object[] row) {
    return ((filter == null) || filter.matches(row)) && ((rankingFilter==null) || rankingFilter.matches(row));
  }
}
