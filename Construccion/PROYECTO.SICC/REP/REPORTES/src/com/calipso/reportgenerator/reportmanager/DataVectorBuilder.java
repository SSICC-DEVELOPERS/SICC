package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportmanager.ReportData;
import com.calipso.reportgenerator.common.QueryDimension;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.DimensionValueNode;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;

import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import java.io.Serializable;

public class DataVectorBuilder implements Serializable {

  private DimensionValueNode rowsRoot;
  private DimensionValueNode colsRoot;
  private ReportData reportData;
  private Vector dataVector;
  private boolean withTotals;
  private int rowCount;
  private int colCount;
  private int[] metrics;
  private int[] groupingDimensions;
  private Float tempFloat = new Float(0);


  public DataVectorBuilder(DimensionValueNode rowsRoot, DimensionValueNode colsRoot, ReportQuery reportQuery, ReportData reportData, boolean withTotals) {
    this.rowsRoot = rowsRoot;
    this.colsRoot = colsRoot;
    this.reportData = reportData;
    this.withTotals = withTotals;
    this.metrics = reportQuery.getCubeVisibleMetricFields();
    getDataVector();
  }

  public Vector getDataVector() {
    if (dataVector == null) {
      dataVector = new Vector();
      fill();
    }
    return dataVector;
  }

  private void fill() {
    DimensionNodeIterator rowsIterator = new DimensionNodeIterator(rowsRoot, withTotals);
    if (rowsRoot.getDimensionCount() == 0) {
      Object[] rowHeaders = new Object[0];
      DimensionNodeIterator colsIterator = new DimensionNodeIterator(colsRoot, withTotals);
      Vector dataValues = new Vector();
      if (colsRoot.getDimensionCount() == 0) {
        fillValue(dataValues, rowHeaders, new Object[0]);
      }
      else {
        while (colsIterator.hasNext()) {
          Object[] colHeaders = (Object[]) colsIterator.next();
          fillValue(dataValues, rowHeaders, colHeaders);
        }
      }
      dataVector.add(dataValues);
      rowCount++;
    }
    else {
      while (rowsIterator.hasNext()) {
        Object[] rowHeaders = (Object[]) rowsIterator.next();
        DimensionNodeIterator colsIterator = new DimensionNodeIterator(colsRoot, withTotals);
        Vector dataValues = new Vector();
        if (colsRoot.getDimensionCount() == 0) {
          fillValue(dataValues, rowHeaders, new Object[0]);
        }
        else {
          while (colsIterator.hasNext()) {
            Object[] colHeaders = (Object[]) colsIterator.next();
            fillValue(dataValues, rowHeaders, colHeaders);
          }
        }
        dataVector.add(dataValues);
        rowCount++;
      }
    }
  }

  private boolean isTotal(Object[] rowHeaders, Object[] colHeaders) {
    return (rowHeaders.length > 0 && rowHeaders[rowHeaders.length - 1] == null) ||
      (colHeaders.length > 0 && colHeaders[colHeaders.length - 1] == null);
  }

  private int[] getMetrics() {
    return metrics;
  }

  private void fillValue(Vector dataValues, Object[] rowHeaders, Object[] colHeaders) {
    Object[] values = new Object[rowHeaders.length + colHeaders.length];
    System.arraycopy(rowHeaders, 0, values, 0, rowHeaders.length);
    System.arraycopy(colHeaders, 0, values, rowHeaders.length, colHeaders.length);
    Object[] metricValues;
    if (isTotal(rowHeaders, colHeaders)) {
      //llenar con dimensiones y valores que no son null
      Object[] params = getNotNullParams(values);
      int[] dimensions = (int[]) params[0];
      Object[] dimValues = (Object[]) params[1];
      //metricValues = reportData.measuresAtDimensionsValues(dimensions, dimValues);
      metricValues = reportData.getMetricValues(dimensions, dimValues);
    }
    else {
      //metricValues = reportData.measuresAtDimensionsValues(getGroupingDimensionsIndexArray(), values);
      metricValues = reportData.getMetricValues(getGroupingDimensionsIndexArray(), values);
    }
    if(metricValues == null){
      for (int i = 0; i < getMetrics().length; i++) {
        Object value = SharedFloat.newFrom(tempFloat);
        dataValues.add(value);
        if (rowCount == 0) colCount++;
      }
    }else{
      for (int i = 0; i < getMetrics().length; i++) {
        int metricIndex = getMetrics()[i];
        Object value = metricValues[metricIndex];
        dataValues.add(value);
        if (rowCount == 0) colCount++;
      }
    }
  }

  private int[] getGroupingDimensionsIndexArray() {
    if (groupingDimensions == null){
      groupingDimensions = reportData.getQuery().getGroupingDimensionsIndexArray();
    }
    return groupingDimensions;
  }

  private Object[] getNotNullParams(Object[] values) {
    Object[] result = new Object[2];
    Vector notNullDims = new Vector();
    Vector notNullValues = new Vector();
    for (int i = 0; i < values.length; i++) {
      Object value = values[i];
      if (value != null) {
        notNullValues.add(value);
        notNullDims.add(dimensionFromValuesIndex(i));
      }
    }
    result[0] = toIntArray(notNullDims);
    result[1] = notNullValues.toArray();
    return result;
  }

  private int[] toIntArray(Collection selectedDimensions) {
    int[] result;
    int index;
    Iterator iterator;
    int selectedDimensionsSize = selectedDimensions.size();
    result = new int[selectedDimensionsSize];
    iterator = selectedDimensions.iterator();
    for (index = 0; index < selectedDimensionsSize; index++) {
      result[index] = ((Integer) iterator.next()).intValue();
    }
    return result;
  }

  private Integer dimensionFromValuesIndex(int index) {
    int rowsCount = rowsRoot.getDimensionCount();
    if (rowsCount == 0) {
      //return new Integer(cube.getQuery().getColumns()[index]);
      return new Integer(((QueryDimension)reportData.getQuery().getColumnDimensions().get(index)).getIndex());
    }
    else {
    if (index >= rowsCount) {
      //return new Integer(cube.getQuery().getColumns()[index - Math.max(rowsCount, 1)]);
      return new Integer(((QueryDimension)reportData.getQuery().getColumnDimensions().get(index - Math.max(rowsCount, 1))).getIndex());
    }
    else {
      //return new Integer(cube.getQuery().getRows()[index]);
      return new Integer(((QueryDimension)reportData.getQuery().getRowDimensions().get(index)).getIndex());
    }
    }
  }

  public void invalidate() {
    dataVector = null;
    colCount = 0;
    rowCount = 0;
  }

  public Vector getNames() {
    Vector names = new Vector(getColCount());
    for (int i = 0; i < getColCount(); i++) {
      names.add(String.valueOf(i));
    }
    return names;
  }

  public int getRowCount() {
    return Math.max(rowCount, 1);
  }

  public int getColCount() {
    return Math.max(colCount, 1);
  }

  public TableModel getDataModel() {
    return new DefaultTableModel(getDataVector(), getNames());
  }

}
