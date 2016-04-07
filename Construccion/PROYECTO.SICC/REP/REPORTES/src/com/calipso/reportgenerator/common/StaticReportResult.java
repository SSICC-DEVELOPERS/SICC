package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.DataTree;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.DataTreeNode;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Dec 16, 2003
 * Time: 2:13:10 PM
 * To change this template use Options | File Templates.
 */

public class StaticReportResult extends ReportResult {

  private DataTree dataTree;
  private ReportTableModel reportTable = null;

  public StaticReportResult(ReportSpec reportSpec, ReportQuery reportQuery, DataTree dataTree) {
    super(reportSpec, reportQuery);
    this.dataTree = dataTree;
  }

  public DataTree getDataTree() {
    return dataTree;
  }

  public ReportTableModel getReportTableModel() {
    if(reportTable==null){
        reportTable = new StaticReportTableModel(this);
    }
    return reportTable;
  }

  public void resetReportTableModel(){
      reportTable = null;
  }

  public Collection getValuesCollection(boolean ascending) {
    TreeMap set = new TreeMap(getComparator(ascending));
    Iterator iterator = getDataTree().getRoot().getSubNodes().entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      DataTreeNode node = (DataTreeNode)entry.getValue();
      set.put(node.getMetrics()[0], entry);
    }
    return set.entrySet();
  }

  private Comparator getComparator(boolean ascending) {
    if(ascending){
      return new Comparator(){
                  public int compare(Object o1, Object o2){
                    return ((SharedFloat)o1).compareTo(o2);
                  }
                };
    }else{
      return new Comparator(){
                  public int compare(Object o1, Object o2){
                    return -((SharedFloat)o1).compareTo(o2);
                  }
                };
    }
  }

  public ReportSpec getReportSpec() {
    return super.getReportSpec();
  }

  public ReportQuery getReportQuery() {
    return super.getReportQuery();
  }

}
