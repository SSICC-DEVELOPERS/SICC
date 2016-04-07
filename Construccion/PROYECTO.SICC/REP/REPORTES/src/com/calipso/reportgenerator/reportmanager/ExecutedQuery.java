package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.HeaderTableModel;

import java.util.Vector;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Nov 28, 2003
 * Time: 12:42:25 PM
 * To change this template use Options | File Templates.
 */

public class ExecutedQuery implements Serializable {

  private ReportQuery query;
  private HeaderTableModel rowsModel;
  private HeaderTableModel columnsModel;
  private Vector dataVector;
  private boolean initialExecutedQuery;

  public ExecutedQuery(ReportQuery query, HeaderTableModel rowsModel, HeaderTableModel columnsModel,
                       Vector dataVector, boolean initialExecutedQuery) {
    this.query = query;
    this.rowsModel = rowsModel;
    this.columnsModel = columnsModel;
    this.dataVector = dataVector;
    this.initialExecutedQuery = initialExecutedQuery;
  }

  public ReportQuery getQuery() {
    return query;
  }

  public void setQuery(ReportQuery query) {
    this.query = query;
  }

  public HeaderTableModel getRowsModel() {
    return rowsModel;
  }

  public void setRowsModel(HeaderTableModel rowsModel) {
    this.rowsModel = rowsModel;
  }

  public HeaderTableModel getColumnsModel() {
    return columnsModel;
  }

  public void setColumnsModel(HeaderTableModel columnsModel) {
    this.columnsModel = columnsModel;
  }

  public Vector getDataVector() {
    return dataVector;
  }

  public void setDataVector(Vector dataVector) {
    this.dataVector = dataVector;
  }

  public boolean isInitialExecutedQuery() {
    return initialExecutedQuery;
  }

  public void setInitialExecutedQuery(boolean initialExecutedQuery) {
    this.initialExecutedQuery = initialExecutedQuery;
  }
}
