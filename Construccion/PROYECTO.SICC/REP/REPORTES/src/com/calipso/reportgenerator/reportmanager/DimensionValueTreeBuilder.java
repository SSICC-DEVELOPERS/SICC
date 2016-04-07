package com.calipso.reportgenerator.reportmanager;
import com.calipso.reportgenerator.reportmanager.ReportData;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.QueryDimension;
import com.calipso.reportgenerator.common.DimensionValueNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * Esta clase se encarga de generar la estructura de nodos para poder dibujar y cargar los datos en las tablas
 */

public class DimensionValueTreeBuilder {
  private ReportData reportData;

  /**
   * Crea un objeto DimensionValueTreeBuilder a partir fde un ReportResult
   * @param reportData
   */
  public DimensionValueTreeBuilder(ReportData reportData) {
    setReportData(reportData);
    initCubeProccess();
  }
  /**
   *
   */
  private void initCubeProccess() {
    List rows = getReportData().getQuery().getRowDimensions();
    List cols = getReportData().getQuery().getColumnDimensions();
    ArrayList prevDimensions;
    ArrayList values;
    prevDimensions = new ArrayList();
    values = new ArrayList();
    rowsRoot = new DimensionValueNode("ROWS");
    rowsRoot.setDimensionCount(rows.size());
    if (rows.size() > 0) {
      fillSubNodes(rowsRoot, rows, prevDimensions, values);
    }
    columnsRoot = new DimensionValueNode("COLUMNS");
    columnsRoot.setDimensionCount(cols.size());
    prevDimensions = new ArrayList();
    values = new ArrayList();
    if (cols.size() > 0) {
      fillSubNodes(columnsRoot, cols, prevDimensions, values);
    }
  }
  private DimensionValueNode rowsRoot;
  private DimensionValueNode columnsRoot;
  public DimensionValueNode getRowsRoot(){
    return rowsRoot;
  }

  public DimensionValueNode getColumnsRoot(){
    return  columnsRoot;
  }

  private void fillSubNodes(DimensionValueNode parentNode, List dimensions,  ArrayList prevDimensions, ArrayList prevDimensionValues){
    int currentDimension = ((QueryDimension)dimensions.get(prevDimensions.size())).getIndex();
    Iterator iterator = getReportData().valuesFor(currentDimension, arrayListToIntArray(prevDimensions), prevDimensionValues.toArray());
    boolean lastDimension = prevDimensions.size() == dimensions.size() -1;
    while (iterator.hasNext()){
      Map.Entry current = (Map.Entry) iterator.next();
      Object currentValue = current.getKey();
      DimensionValueNode currentNode = new DimensionValueNode(currentValue, parentNode);
      currentNode.setDimensionIndex(prevDimensions.size());
      currentNode.setDimensionCount(parentNode.getDimensionCount() -1);
      parentNode.addSubNode(currentNode);
      prevDimensions.add(new Integer(currentDimension));
//      prevDimensionValues.add(this.getReportData().getDefinition().getDimensionFromIndex(currentDimension).getVisualValue(currentValue));
      prevDimensionValues.add(currentValue);
      if (!lastDimension){
        fillSubNodes(currentNode, dimensions, prevDimensions, prevDimensionValues);
      }
      prevDimensions.remove(prevDimensions.size()-1);
      prevDimensionValues.remove(prevDimensionValues.size()-1);
    }
  }

  private int[] arrayListToIntArray(ArrayList list){
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++){
      result[i] = ((Integer)list.get(i)).intValue();
    }
    return result;
  }


  public ReportData getReportData() {
    return reportData;
  }

  public ReportQuery getQuery(){
    return getReportData().getQuery();
  }

  public void setReportData(ReportData reportData) {
    this.reportData = reportData;
  }
}