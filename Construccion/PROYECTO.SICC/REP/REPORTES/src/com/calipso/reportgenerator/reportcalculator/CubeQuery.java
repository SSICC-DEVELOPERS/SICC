package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportcalculator.SharedFloat;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;

/**
 * Es una consulta que se realiza sobre el pivot, cuyo resultado es un Cube
 */
public class CubeQuery implements Serializable {
  private int[] rows;
  private int[] columns;
  private int[] pages;
  private int[] metrics;
  private int[] dimensions;
  private boolean[] ascending;
  private int[] dimensionRank;
  private ExpressionCubeFilter filter;
  private EnumerationCubeFilter enumFilter;
  private EnumerationCubeFilter rankingFilters;

  public void setRankingFilter(EnumerationCubeFilter rankingFilters) {
    this.rankingFilters = rankingFilters;
  }

  /**
   * Inicializa una nueva Query
   */
  public CubeQuery() {
    initialize();
  }

  /**
   * Inicializa las estructuras que contendrán la información acerca de las dimensiones y métricas involucradas
   */
  private void initialize() {
    setRows(new int[0]);
    setColumns(new int[0]);
    setPages(new int[0]);
    setMetrics(new int[0]);
  }

  /**
   * Devuelve un array cuyos elementos son los índices de las dimensiones que agrupan por fila
   * @return
   */
  public int[] getRows() {
    return rows;
  }

  /**
   * Asigna un array cuyos elementos son los índices de las dimensiones que agrupan por fila
   * @param rows
   */
  public void setRows(int[] rows) {
    this.rows = rows;
  }

  /**
   * Devuelve un array cuyos elementos son los índices de las dimensiones que agrupan por columna
   * @return
   */
  public int[] getColumns() {
    return columns;
  }

  /**
   * Devuelve un array cuyos elementos son los índices de las dimensiones que agrupan por página
   * @return
   */

  public int[] getPages() {
    return pages;
  }

  /**
   * Asigna un array cuyos elementos son los índices de las dimensiones que agrupan por columna
   * @param columns
   */

  public void setColumns(int[] columns) {
    this.columns = columns;
  }

  /**
   * Asigna un array cuyos elementos son los índices de las dimensiones que agrupan por página
   * @param pages
   */

  public void setPages(int[] pages) {
    this.pages = pages;
  }

  /**
   * Devuelve un array cuyos elementos son los índices de las métricas visibles
   * @return
   */
  public int[] getMetrics() {
    return metrics;
  }

  /**
   * Asigna un array cuyos elementos son los índices de las métricas visibles
   * @param metrics
   */
  public void setMetrics(int[] metrics) {
    this.metrics = metrics;
  }

  /**
   * Devuelve un array que contiene los criterios de ordenamiento para los valores de las dimensiones
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
   * Asigna un array que contiene los criterios de ordenamiento para los valores de las dimensiones
   * @param ascending
   */
  public void setAscending(boolean[] ascending) {
    this.ascending = ascending;
  }

  /**
   * Devuelve un array que contiene los indices de las métricas que se utilizaran para ranking (ordenamiento por valor
   * de métrica) para cada dimensión. Si no se utiliza ranking el valor es -1, ordenando por valor de dimensión.
   * @return
   */

  public int[] getDimensionRank() {
    if (dimensionRank == null) {
      dimensionRank = new int[dimensions.length];
      Arrays.fill(dimensionRank, -1);
    }
    return dimensionRank;
  }

  /**
   * Asigna un array que contiene los indices de las métricas para ranking
   */

  public void setDimensionRank(int[] dimensionRank) {
    this.dimensionRank = dimensionRank;
  }

  /**
   * Devuelve el filtro que se aplicará sobre las rows del pivot para llenar el Cube
   * @return
   */
  public ExpressionCubeFilter getFilter() {
    return filter;
  }

  /**
   * Asigna el filtro que se aplicará sobre las rows del pivot para llenar el Cube
   * @param filter
   */
  public void setFilter(ExpressionCubeFilter filter) {
    this.filter = filter;
  }

  /**
   * Devuelve el filtro que se aplicará sobre las rows del pivot para llenar el Cube conteniendo los valores deshabilitados
   * @return
   */

  public EnumerationCubeFilter getEnumFilter() {
    return enumFilter;
  }

  /**
   * Asigna el filtro que se aplicará sobre las rows del pivot para llenar el Cube conteniendo los valores deshabilidados
   * @param enumFilter
   */

  public void setEnumFilter(EnumerationCubeFilter enumFilter) {
    this.enumFilter = enumFilter;
  }

  /**
   * Determina si un array contiene un elemento
   * @param array1
   * @param element
   * @return
   */
  private boolean arrayIncludes(int[] array1, int element) {
    int index;
    int lenght;

    lenght = array1.length;
    for (index = 0; index < lenght; index++) {
      if (array1[index] == element) {
        return true;
      }
    }
    return false;
  }

  /**
   * Devuelve un array cuyos elementos son los índices de las dimensiones
   * @return
   */
  public int[] getDimensions() {
    if (dimensions == null) {
      fillDimensions();
    }
    return dimensions;
  }

  /**
   * Llena el array de dimensiones con las que agrupan por fila y por columna
   */
  private void fillDimensions() {
    int rowsLenght;
    int columnsLenght;
    int dimensionsLenght;
    int index;

    rowsLenght = rows.length;
    columnsLenght = columns.length;
    dimensionsLenght = rowsLenght + columnsLenght;
    dimensions = new int[dimensionsLenght];
    for (index = 0; index < rowsLenght; ++index) {
      dimensions[index] = rows[index];
    }
    for (index = 0; index < columnsLenght; ++index) {
      dimensions[index + rowsLenght] = columns[index];
    }
  }

  /**
   * Aplica el filtro a una row y devuelve verdadero si cumple con la condición
   * @param row
   * @return
   */
  public boolean matches(Object[] row) {
    return ((filter == null) || filter.matches(row)) && ((rankingFilters==null) || rankingFilters.matches(row));
  }

  public boolean valuesEnabled(Object[] row) {
    return (enumFilter == null) || enumFilter.matches(row);
  }

  /**
   * Determina las dimensiones que se deben agregar para resolver una consulta en forma incremental tomando como base
   * una query previamente procesada
   * @param otherQuery
   * @return
   */
  public LinkedList newDimensionsWithRespectTo(CubeQuery otherQuery) {
    LinkedList newDimension;

    newDimension = new LinkedList();
    for (int i = 0; i < dimensions.length; i++) {
      int dimension = dimensions[i];
      if (!arrayIncludes(otherQuery.dimensions, dimension)) {
        newDimension.add(new Integer(dimension));
      }
    }

    return newDimension;
  }

  /**
   * Devuelve el comparador apropiado para el criterio de ordenamiento de una dimensión
   * @param dimensionIndex
   * @return
   */
  public Comparator entryComparatorFor(int dimensionIndex) {
    // Debe fijarse en la query si esta dimensión se muestra en orden ascendente
    return new EntryComparator(getAscending()[dimensionIndex], getDimensionRank()[dimensionIndex]);
  }

  /**
   * Devuelve el comparador apropiado para el criterio de ordenamiento de una dimensión
   * @param dimensionIndex
   * @return
   */
  public Comparator valueComparatorFor(int dimensionIndex) {
    // Debe fijarse en la query si esta dimensión se muestra en orden ascendente
    return new ValueComparator(getAscending()[dimensionIndex]);
  }

  public boolean equivalentQuery(CubeQuery newQuery) {
    return newQuery != null &&
            sameRowDimensions(newQuery.getRows()) &&
            sameColumnDimensions(newQuery.getColumns()) &&
            sameMetrics(newQuery.getMetrics()) &&
            sameFilter(newQuery.getFilter()) &&
            sameEnumFilter(newQuery.getEnumFilter()) &&
            sameAscending(newQuery.getAscending()) &&
            sameDimensionRank(newQuery.getDimensionRank());
  }

  private boolean sameDimensionRank(int[] otherDimensionRank) {
    return Arrays.equals(getDimensionRank(), otherDimensionRank);
  }

  private boolean sameAscending(boolean[] otherAscending) {
    return Arrays.equals(getAscending(), otherAscending);
  }

  private boolean sameMetrics(int[] newMetrics) {
    return Arrays.equals(getMetrics(), newMetrics);
  }

  private boolean sameEnumFilter(EnumerationCubeFilter enumFilter) {
    return getEnumFilter().equals(enumFilter);
  }

  private boolean sameFilter(ExpressionCubeFilter filter) {
    if ((getFilter() == null) && (filter == null)) {
      return true;
    } else {
      if (getFilter() != null) {
        return getFilter().equals(filter);
      }
    }
    return false;
  }

  private boolean sameColumnDimensions(int[] newColumns) {
    return Arrays.equals(columns, newColumns);
  }


  private boolean sameRowDimensions(int[] newRows) {
    return Arrays.equals(rows, newRows);
  }

  /**
   * Implementación del comparador para ordenar valores de dimensiones (Entry)
   */
  private static class EntryComparator implements Comparator {
    boolean ascending;
    int dimensionRank;

    public EntryComparator(boolean ascending, int dimensionRank) {
      this.ascending = ascending;
      this.dimensionRank = dimensionRank;
    }

    public int compare(Object o1, Object o2) {
      int comparison;
      if (dimensionRank == -1) {
        Object ok1 = ((Map.Entry) o1).getKey();
        Object ok2 = ((Map.Entry) o2).getKey();
        comparison = ((Comparable)ok1).compareTo(ok2);
      } else {
        comparison = ((SharedFloat) ((Object[]) ((Map.Entry) o1).getValue())[dimensionRank]).compareTo(((Object[]) ((Map.Entry) o2).getValue())[dimensionRank]);
        if (comparison == 0){
          comparison = 1;
        }
      }
      if (ascending) {
        return comparison;
      } else {
        return 0 - comparison;
      }
    }
  }

  /**
   * Implementación del comparador para ordenar valores de dimensiones
   */
  private static class ValueComparator implements Comparator {
    boolean ascending;

    public ValueComparator(boolean ascending) {
      this.ascending = ascending;
    }

    public int compare(Object o1, Object o2) {
      int comparison;

      comparison = o1.toString().compareTo(o2.toString());
      if (ascending) {
        return comparison;
      } else {
        return 0 - comparison;
      }
    }
  }

}
