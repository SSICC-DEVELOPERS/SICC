package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportcalculator.Matrix;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.Serializable;

/**
 */
public class CollectionMatrix implements Matrix, Serializable {

  private List rows;

  public CollectionMatrix() {
    rows = new LinkedList();
  }

  /**
   * Devuelve la lista de rows
   * @return
   */
  public List getRows() {
    return rows;
  }

  /**
   * Asigna la lista de rows
   * @param rows
   */
  public void setRows(List rows) {
    this.rows = rows;
  }

  public Iterator iterator() {
    return getRows().iterator();
  }

  public boolean isEmpty() {
    return rows.isEmpty();
  }
}
