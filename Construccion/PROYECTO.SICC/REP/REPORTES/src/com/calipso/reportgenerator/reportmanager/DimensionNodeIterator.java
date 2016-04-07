package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.DimensionValueNode;

import java.util.Iterator;
import java.util.ArrayList;

/**
 */
public class DimensionNodeIterator implements Iterator {

  private DimensionValueNode dimensionValueNode;
  private int dimensionCount;
  private Iterator[] iterators;
  private Object[] currentValues;
  private DimensionValueNode[] currentNodes;
  private boolean withTotals;
  private ArrayList currentTotals;

  public DimensionNodeIterator(DimensionValueNode dimensionValueNode, boolean withTotals) {
    this.dimensionValueNode = dimensionValueNode;
    this.withTotals = withTotals;
    this.totalsPending = withTotals;
    initialize();
  }

  public boolean withTotals() {
    return this.withTotals;
  }

  private void initialize() {
    dimensionCount = Math.max(1, getDimensionValueNode().getDimensionCount());
    iterators = new Iterator[dimensionCount];
    currentValues = new Object[dimensionCount];
    currentNodes = new DimensionValueNode[dimensionCount];
    iterators[0] = getDimensionValueNode().getSubNodesList().iterator();
  }

  public DimensionValueNode getDimensionValueNode() {
    return dimensionValueNode;
  }

  public int getDimensionCount() {
    return dimensionCount;
  }

  private ArrayList getCurrentTotals() {
    if (currentTotals == null) {
      currentTotals = new ArrayList();
    }
    return currentTotals;
  }

  private boolean totalsPending;

  public boolean hasNext() {
    Iterator iterator;
    for (int i = 0; i < dimensionCount; i++) {
      iterator = iterators[i];
      if (iterator != null && iterator.hasNext()) {
        return true;
      }
    }
    //boolean xhasNext = totalsPending || getCurrentTotals().size() > 0;//!itemPending;//
    if (withTotals) {
      boolean xhasNext = totalsPending || currentValues[0] != null || getCurrentTotals().size() > 0;//!itemPending;//
      if (totalsPending) totalsPending = false;
      return xhasNext;
    }
    else {
      return false;
    }
  }

  public Object next() {
    Object[] values = new Object[getDimensionCount()];
    advance();
    if (getCurrentTotals().size() > 0) {
      values = (Object[]) getCurrentTotals().get(0);
      getCurrentTotals().remove(0);
    }
    else {
      copyFromCurrent(values);
    }
    return values;
  }

  private void copyFromCurrent(Object[] values) {
    System.arraycopy(currentValues, 0, values, 0, currentValues.length);
  }


  private boolean itemPending = false;

  private void advance() {
    if (!itemPending) {
      if (getCurrentTotals().size() == 0) {
        advanceAt(getDimensionCount() - 1);
      }
    }
    if (itemPending && getCurrentTotals().size() == 0) {
      itemPending = false;
    }
  }

  private void advanceAt(int dimensionIndex) {
    if (dimensionIndex >= 0) {
      Iterator iterator = iterators[dimensionIndex];
      if (iterator != null) {
        if (iterator.hasNext()) {
          updateCurrentValue(dimensionIndex, (DimensionValueNode) iterator.next());
          return;
        }
        else {
          iterators[dimensionIndex] = null;
          updateCurrentValue(dimensionIndex, null);
          if (withTotals) {
            Object[] values = new Object[getDimensionCount()];
            copyFromCurrent(values);
            getCurrentTotals().add(values);
            itemPending = true;
          }
        }
      }
      advanceAt(dimensionIndex - 1);
      initializeIterator(dimensionIndex);
    }
  }

  private void initializeIterator(int dimensionIndex) {
    if (dimensionIndex > 0) {
      Iterator iterator = iteratorFor(dimensionIndex);
      if (iterator == null) {
        initializeIterator(dimensionIndex - 1);
        iterator = iteratorFor(dimensionIndex);
      }

      if (iterator != null && iterator.hasNext()) {
        iterators[dimensionIndex] = iterator;
        DimensionValueNode node = (DimensionValueNode) iterator.next();
        updateCurrentValue(dimensionIndex, node);
      }
      else {
        iterators[dimensionIndex] = null;
      }
    }
    else {
      iterators[0] = null;
    }
  }

  private Iterator iteratorFor(int dimensionIndex) {
    DimensionValueNode node = currentNodes[dimensionIndex - 1];
    if (node != null) {
      return node.iterator();
    }
    return null;
  }

  private void updateCurrentValue(int dimensionIndex, DimensionValueNode node) {
    Object value = null;
    if (node != null) {
      value = node.getValue();
    }
    else {
      value = null;
    }
    currentValues[dimensionIndex] = value;
    currentNodes[dimensionIndex] = node;
    if (dimensionIndex < currentValues.length - 1) {
      for (int i = dimensionIndex + 1; i < currentValues.length; i++) {
        currentValues[i] = null;
        currentNodes[i] = null;
      }
    }
  }

  public void remove() {
  }
}
