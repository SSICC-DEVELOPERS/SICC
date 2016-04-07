package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportmanager.IRDataSource;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

/**
 * User: Ezequiel
 * Date: Jun 2, 2003
 * Time: 10:56:12 AM
 */
public class DataSourceMatrix implements Matrix, Serializable{

  private Collection dataSources;

  public DataSourceMatrix() {
  }

  public Iterator iterator() {
    return null;
  }

  protected Collection getDataSources() {
    if (dataSources == null) {
      dataSources = new ArrayList();
    }
    return dataSources;
  }

  public boolean isEmpty() {
    return dataSources.isEmpty();
  }

  public void addDataSource(IRDataSource dataSource) {
    getDataSources().add(dataSource);
  }
}
