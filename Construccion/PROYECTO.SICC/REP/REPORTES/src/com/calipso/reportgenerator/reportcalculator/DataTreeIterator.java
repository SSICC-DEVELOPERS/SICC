package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportcalculator.DataTree;
import java.util.Collection;

/**
 * Itera una instancia de <code>DataTree</code>.
 */

public class DataTreeIterator {
  private DataTree dataTree;

  /**
   * Crea una instancia de <code>DataTreeIterator</code>
   * a partir de una instancia de <code>DataTree</code>.
   * @param dataTree
   */
  public DataTreeIterator(DataTree dataTree) {
    this.dataTree = dataTree;
    initialize();
  }

  private void initialize() {
/*    metrics = cube.getQuery().getMetrics();
    metricsSize = metrics.length;
    dimensions = cube.getQuery().getDimensions();
    dimensionsSize = dimensions.length;
    entries = new Map.Entry[dimensionsSize + 1];
    iterators = new Iterator[dimensionsSize];
    // Carga el primer nodo
    entryAtPut(-1, new Entry("root", cube.getRoot()));
  */
  }

  public void advance() {

  }

  public boolean hasNext() {
    return false;
  }

  public Object[] current() {
    return new Object[0];
  }

  public Collection currentTotals() {
    return null;
  }

  public static DataTreeIterator on(DataTree dataTree) {
    return new DataTreeIterator(dataTree);
  }
}
