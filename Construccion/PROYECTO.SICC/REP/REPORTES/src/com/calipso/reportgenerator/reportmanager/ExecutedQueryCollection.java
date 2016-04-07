package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.QueryMetric;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


/**
 * Cache de instancias <code>ReportQuery</code> ya ejecutadas
 */

public class ExecutedQueryCollection implements Serializable{

  private HashMap queries;

  public ExecutedQueryCollection() {
  }

  /*public void addExecutedQuery(ReportQuery query, ExecutedQuery executedQuery) {
    try {
      ByteArrayOutputStream value = new ByteArrayOutputStream();
      value.write(getBytes(executedQuery));
      ByteArrayOutputStream value1 = new ByteArrayOutputStream();
      value1.write(getBytes(query));
      getExecutedQueries().put(value1, value);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }*/

  /**
   * Guarda una excecutedQuery en un archivo temporal
   * @param query
   * @param executedQuery
   */
  /*public void addExecutedQueryToDisk(ReportQuery query, ExecutedQuery executedQuery) {
    try {
      String fileName = "Query " + getCollectionSize();
      File file = new File(fileName);
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream o = new ObjectOutputStream(fos);
      o.writeObject(executedQuery);
      getExecutedQueries().put(query, file);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }*/

  public void addExecutedQuery(ReportQuery query, ExecutedQuery executedQuery) {
    try {
      ByteArrayOutputStream value = new ByteArrayOutputStream();
      value.write(getBytes(executedQuery));
      getExecutedQueries().put(query, value);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public int getCollectionSize() {
    return getExecutedQueries().size();
  }

  /*public boolean alreadyExists(ReportQuery query, boolean queryCachedEnabled) {
    boolean returnVal = false;
    if(queryCachedEnabled) {
      try {
        if(getCollectionSize() == 0) {
          returnVal = false;
        } else {
          Iterator iterator = getExecutedQueries().keySet().iterator();
          while(iterator.hasNext()) {
            ByteArrayOutputStream currentKey = (ByteArrayOutputStream) iterator.next();
            ReportQuery currentQuery = (ReportQuery) getObject(currentKey);
            if(query.getCubeQuery().equivalentQuery(currentQuery.getCubeQuery())) {
              if(sameMetricsStates(query, currentQuery) && (query.isVisibleTotals() == currentQuery.isVisibleTotals())) {
                return true;
              }
            }
          }
        }
      } catch(Exception e) {
          e.printStackTrace();
      }
    }
    return returnVal;
  }*/

  public boolean alreadyExists(ReportQuery query, boolean queryCachedEnabled) {
    boolean returnVal = false;
    if(queryCachedEnabled) {
      try {
        if(getCollectionSize() == 0) {
          returnVal = false;
        } else {
          Iterator iterator = getExecutedQueries().keySet().iterator();
          while(iterator.hasNext()) {
            ReportQuery currentQuery = (ReportQuery) iterator.next();
            if(query.getCubeQuery().equivalentQuery(currentQuery.getCubeQuery())) {
              if(sameMetricsStates(query, currentQuery) && (query.isVisibleTotals() == currentQuery.isVisibleTotals())) {
                return true;
              }
            }
          }
        }
      } catch(Exception e) {
          e.printStackTrace();
      }
    }
    return returnVal;
  }

  private boolean sameMetricsStates(ReportQuery query, ReportQuery currentQuery) {
    List queryMetrics = query.getMetrics();
    List currentQueryMetrics = currentQuery.getMetrics();
    for(int i = 0 ; i < queryMetrics.size() ; i++) {
      QueryMetric queryMetric = (QueryMetric) queryMetrics.get(i);
      QueryMetric currentQueryMetric = (QueryMetric) currentQueryMetrics.get(i);
      if(queryMetric.getVisible() != currentQueryMetric.getVisible()) {
        return false;
      }
    }
    return true;
  }

  /*public ExecutedQuery getExecutedQuery(ReportQuery query) {
    ExecutedQuery returnExecQuery = null;
    try {
      Iterator iterator = getExecutedQueries().keySet().iterator();
      while(iterator.hasNext()) {
        ByteArrayOutputStream currentKey = (ByteArrayOutputStream) iterator.next();
        ReportQuery reportQuery = (ReportQuery) getObject(currentKey);
        if(query.getCubeQuery().equivalentQuery(reportQuery.getCubeQuery())) {
          if(sameMetricsStates(query, reportQuery) && (query.isVisibleTotals() == reportQuery.isVisibleTotals())) {
            ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) getExecutedQueries().get(currentKey);
            returnExecQuery = (ExecutedQuery) getObject(byteArrayOutputStream);
            break;
          }
        }
      }
    } catch(Exception e) {
     e.printStackTrace();
    }
    return returnExecQuery;
  }*/

  public ExecutedQuery getExecutedQuery(ReportQuery query) {
    ExecutedQuery returnExecQuery = null;
    try {
      Iterator iterator = getExecutedQueries().keySet().iterator();
      while(iterator.hasNext()) {
        ReportQuery reportQuery = (ReportQuery) iterator.next();
        if(query.getCubeQuery().equivalentQuery(reportQuery.getCubeQuery())) {
          if(sameMetricsStates(query, reportQuery) && (query.isVisibleTotals() == reportQuery.isVisibleTotals())) {
            ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) getExecutedQueries().get(reportQuery);
            returnExecQuery = (ExecutedQuery) getObject(byteArrayOutputStream);
            break;
          }
        }
      }
    } catch(Exception e) {
     e.printStackTrace();
    }
    return returnExecQuery;
  }

  /**
   * Obtiene una query guardada en disco
   * @param query
   * @return
   */
  /*public ExecutedQuery getExecutedQueryFromDisk(ReportQuery query) {
    ExecutedQuery returnExecQuery = null;
    try {
      Iterator iterator = getExecutedQueries().keySet().iterator();
      while(iterator.hasNext()) {
        ReportQuery reportQuery = (ReportQuery) iterator.next();
        if(query.getCubeQuery().equivalentQuery(reportQuery.getCubeQuery())) {
          if(sameMetricsStates(query, reportQuery) && (query.isVisibleTotals() == reportQuery.isVisibleTotals())) {
            FileInputStream fileIn = new FileInputStream((File)getExecutedQueries().get(reportQuery));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            returnExecQuery = (ExecutedQuery)in.readObject();
            break;
          }
        }
      }
    } catch(Exception e) {
     e.printStackTrace();
    }
    return returnExecQuery;
  }*/

  private byte[] getBytes(Object obj) throws java.io.IOException{
     ByteArrayOutputStream bos = new ByteArrayOutputStream();
     ObjectOutputStream oos = new ObjectOutputStream(bos);
     oos.writeObject(obj);
     oos.flush();
     oos.close();
     bos.close();
     byte [] data = bos.toByteArray();
     return data;
  }

  private Object getObject(ByteArrayOutputStream stream) throws IOException, ClassNotFoundException {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(stream.toByteArray());
    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
    return objectInputStream.readObject();
  }


  private HashMap getExecutedQueries() {
    if(queries == null) {
      queries = new HashMap();
    }
    return queries;
  }
}
