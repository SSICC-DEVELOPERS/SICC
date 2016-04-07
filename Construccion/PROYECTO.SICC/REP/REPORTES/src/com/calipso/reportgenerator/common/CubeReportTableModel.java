package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.CubeQuery;
import com.calipso.reportgenerator.reportcalculator.CubeValue;
import es.indra.mare.common.info.InfoException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Dec 16, 2003
 * Time: 3:02:55 PM
 * To change this template use Options | File Templates.
 */

public class CubeReportTableModel extends ReportTableModel {

  private CubeReportResult reportResult;
  private HeaderTableModel rowsModel;
  private HeaderTableModel columnsModel;
  private int metricsCount;


  public CubeReportTableModel(CubeReportResult reportResult) {
    super();
    this.reportResult = reportResult;
    try {
      initialize();
    } catch (InfoException e) {
      e.printStackTrace();
    }
  }

  private void initialize() throws InfoException {
    Object [] groupingDimensions = getGroupingDimensions();
    Object [] nonGroupingDimensions = getNonGroupingDimensions();
    Object [] totalMetrics = getTotalMetrics();
    setGroupingDimCount(groupingDimensions.length);
    setNonGroupingDimCount(nonGroupingDimensions.length);
    setCommonMetricsCount(reportResult.getReportQuery().getVisibleMetrics().size());
    setAccMetricsCount(reportResult.getReportQuery().getVisibleAccumulableMetrics().size());
    setTableData(getTableModelData());
    setTableColumnNames(getTableModelColumns(groupingDimensions, nonGroupingDimensions, totalMetrics));
    newDefaultTableModel();
  }

  /**
   * Obtiene los valores de las Dimensiones que no agrupan, es decir, las Row Dimensions
   * a partir de un reporte tipo Cube.
   * @return array que contiene objetos de tipo QueryDimension
   * @throws es.indra.mare.common.info.InfoException
   */
  private Object[] getNonGroupingDimensions() throws InfoException {
    CubeQuery cubeQuery = reportResult.getReportQuery().getCubeQuery();
    int[] dimensionIndexes = cubeQuery.getColumns();
    return getQueryDimensionsArray(dimensionIndexes, reportResult);
  }

  /**
   * Obtiene los valores de las Dimensiones que agrupan, es decir, las Row Dimensions
   * a partir de un reporte tipo Cube.
   * @return array que contiene objetos de tipo QueryDimension
   * @throws es.indra.mare.common.info.InfoException
   */
  private Object[] getGroupingDimensions() throws InfoException {
    CubeQuery cubeQuery = reportResult.getReportQuery().getCubeQuery();
    int[] dimensionIndexes = cubeQuery.getRows();
    return getQueryDimensionsArray(dimensionIndexes, reportResult);
  }

  /**
   * Inicializa un array con objetos de tipo QueryDimension.
   * @param indexes array que contiene los valores de las dimensiones
   * @param reportResult necesario para obtener los valores de las dimensions
   * @return array que contiene objetos de tipo QueryDimension
   * @throws es.indra.mare.common.info.InfoException
   */
  private Object[] getQueryDimensionsArray(int[] indexes, ReportResult reportResult) throws InfoException {
    ReportQuery query = reportResult.getReportQuery();
    Object[] result = new Object[indexes.length];
    for (int i = 0; i < indexes.length; i++) {
      String name = reportResult.getReportSpec().getDimensionFromIndex(indexes[i]).getName();
      QueryDimension dimension = query.getQueryDimensionFromName(name);
      result[i] = dimension;
    }
    return result;
  }

  private Object[] getTotalMetrics() {
    Object [] metricsNames = reportResult.getReportQuery().getVisibleMetrics().toArray();
    Object [] accuMetricsNames = reportResult.getReportQuery().getAccumulableMetrics().toArray();
    Object [] allMetrics = new Object[metricsNames.length + accuMetricsNames.length];
    int i = 0;
    for( ; i < metricsNames.length ; i++) {
      allMetrics[i] = metricsNames[i];
    }
    for(int j = 0 ; j < accuMetricsNames.length ; j++, i++) {
      QueryMetric queryMetric = (QueryMetric) accuMetricsNames[j];
      queryMetric.setName(queryMetric.getName() + "_ACCUM");//LanguageTraslator.traslate("314")
      allMetrics[i] = queryMetric;
    }
    return allMetrics;
  }

  private Vector getTableModelData() {
    rowsModel = reportResult.getRowsModel();
    columnsModel = reportResult.getColumnsModel();
    //metricsCount = reportResult.getReportSpec().getMetrics().length;
    metricsCount = reportResult.getReportQuery().getVisibleMetrics().size();
    Vector dataVector = reportResult.getDataVector();
    Vector main = new Vector();
    if(super.getNonGroupingDimCount() == 0) {
      fillGroupingVectorFrom2(new Vector(), main, rowsModel.getDimensionValueNode().getSubNodesList(), dataVector, 0);
    } else {
      fillGroupingVectorFrom(new Vector(), main, rowsModel.getDimensionValueNode().getSubNodesList(), dataVector, 0);
    }
    return main;
  }

  private int fillGroupingVectorFrom(Vector first, Vector main, Collection subnodes, Vector dataVector, int row) {
    if(subnodes.size() > 0) {
      Iterator iterator = subnodes.iterator();
      while(iterator.hasNext()) {
        DimensionValueNode node = (DimensionValueNode) iterator.next();
        first.add(node.getValue().toString());
        if(node.getSubNodesList().size() == 0) {
          while(rowsModel.isTotalRow(row)){
            row++;
          }
          /*while(rowsModel.getValueFrom(row) [rowsModel.getColumnCount() - 1] == null) {
            row++;
          }*/
          fillNonGroupingVectorFrom(main, first, new Vector(), columnsModel.getDimensionValueNode().getSubNodesList(), dataVector, row, 0);
          row++;
        } else {
          row = fillGroupingVectorFrom(first, main, node.getSubNodesList(), dataVector, row);
        }
        first.removeElementAt(first.size() - 1);
      }
      return row;
    } else {
      fillNonGroupingVectorFrom(main, first, new Vector(), columnsModel.getDimensionValueNode().getSubNodesList(), dataVector, row, 0);
      return 0;
    }
  }

  private int fillNonGroupingVectorFrom(Vector main, Vector first, Vector second, Collection subNodes, Vector dataVector, int row, int col) {
    boolean leafReached = false;
    DimensionValueNode node = null;
    if(subNodes.size() > 0) {
      Iterator iterator = subNodes.iterator();
      while(iterator.hasNext() && !leafReached) {
        node = (DimensionValueNode) iterator.next();
        if(node.getSubNodesList().size() == 0) {
          leafReached = true;
          col = getItemVectorFrom(main, first, second, dataVector, row, col, false, node);
        } else {
          second.add(node.getValue().toString());
          col = fillNonGroupingVectorFrom(main, first, second, node.getSubNodesList(), dataVector, row, col);
          leafReached = false;
          second.removeElementAt(second.size() - 1);
        }
      }
      return col;
    } else {
      getItemVectorFrom(main, first, second, dataVector, row, col, true, node);
      return 0;
    }
  }

  private int getItemVectorFrom(Vector main, Vector first, Vector second, Vector dataVector, int row, int col, boolean isColModelEmpty, DimensionValueNode node) {
    Vector itemVector = new Vector();

    for(int i = 0 ; i < first.size() ; i++) {
      itemVector.add(first.elementAt(i));
    }

    for(int i = 0 ; i < second.size() ; i++) {
      itemVector.add(second.elementAt(i));
    }

    int analizedCols = getDatasFrom(dataVector, row, col, itemVector, isColModelEmpty, node);

    main.add(itemVector);
    return analizedCols;
  }

  private int getDatasFrom(Vector dataVector, int row, int col, Vector itemVector, boolean isColModelEmpty, DimensionValueNode node) {
    int i = 0, p = 0;
    Vector ocurrences = new Vector();
    fillOcurrences(ocurrences, columnsModel.getDimensionValueNode().getSubNodesList());

    //Determinar si hay algun valor de dimension previo que no se muestra en la tabla
    for(int x = 0 ; x < ocurrences.size() ; x++) {
      String currentOcurrence = (String) ocurrences.elementAt(x);
      if(currentOcurrence.equals(node.getValue().toString())) {
        break;
      } else {
        for(int z = 0 ; z < metricsCount ; z++) {
          SharedFloat sharedFloat = SharedFloat.newFrom(0);
          itemVector.add(new Float(sharedFloat.floatValue()));
          p++;
        }
      }
    }

    //Agregamos los datos que realmente estan en la tabla
    Vector vector = (Vector) dataVector.elementAt(row);
    for( ; i < (metricsCount * node.getParentNode().getSubNodesList().size()) ; i++) {
      if(!isColModelEmpty) {
        while(columnsModel.isTotalCol(col)){
          col++;
        }
        /*while((columnsModel.getValueFrom(col) [columnsModel.getRowCount() - 1] == null)) {
          col++;
        }*/
      }
      SharedFloat sharedFloat = (SharedFloat) vector.elementAt(col);
      itemVector.add(new Float(sharedFloat.floatValue()));
      col++;
    }

    //Determinar si hay algun valor de dimension posterior que no se muestra en la tabla
    while((i + p) < (ocurrences.size() * metricsCount)) {
      SharedFloat sharedFloat = SharedFloat.newFrom(0);
      itemVector.add(new Float(sharedFloat.floatValue()));
      i++;
    }
    //Agrega los totales para una fila
    if(reportResult.getReportQuery().isVisibleTotals()){
      int index = col;
      for(int j = 0 ; j < metricsCount ; j++) {
        SharedFloat sharedFloat = (SharedFloat) vector.elementAt(index);
        itemVector.add(new Float(sharedFloat.floatValue()));
        index++;
      }
    }

    return col;
  }


  protected Vector getTableModelColumns(Object[] groupingDimensions, Object[] nonGroupingDimensions, Object[] metricsArray) {
    Vector columnNames = new Vector();
    for (int i = 0; i < groupingDimensions.length; i++) {
      QueryDimension qd = (QueryDimension) groupingDimensions[i];
      columnNames.add(qd.getName());
    }

    occurrences = new Vector();
    fillOcurrences(occurrences, reportResult.getColumnsModel().getDimensionValueNode().getSubNodesList());

    if(nonGroupingDimensions.length > 0) {
      for (int i = 0; i < nonGroupingDimensions.length; i++) {
        QueryDimension qd = (QueryDimension) nonGroupingDimensions[i];
        if(i + 1 == nonGroupingDimensions.length) {
          for(int j = 0 ; j < occurrences.size() ; j++) {
            for (int z = 0; z < metricsArray.length; z++) {
              QueryMetric qm = (QueryMetric) metricsArray[z];
              columnNames.add(j + "_" + qm.getName());
            }
          }
          //Nombra las filas de totales
          if(reportResult.getReportQuery().isVisibleTotals()){
            for (int j = 0; j < metricsArray.length; j++) {
              QueryMetric qm = (QueryMetric) metricsArray[j];
              columnNames.add("TOTAL_" + qm.getName());
            }
          }
        } else {
          columnNames.add(qd.getName());
        }
      }
    } else {
      for (int i = 0; i < metricsArray.length; i++) {
        QueryMetric qm = (QueryMetric) metricsArray[i];
        columnNames.add(qm.getName());
      }

//      for (int i = 0; i < metricsArray.length; i++) {
//        QueryMetric qm = (QueryMetric) metricsArray[i];
//        columnNames.add("TOTAL" + qm.getName());
//      }
    }
    return columnNames;
  }

  private String getWellFormedString(String s) {
    StringBuffer buffer = null;
    String [] strings = null;

    if(s.split("-").length > 1) {
      buffer = new StringBuffer();
      strings = s.split("-");
    } else {
      if(s.split("/").length > 1) {
        buffer = new StringBuffer();
        strings = s.split("/");
      } else {
        int i = s.indexOf(46);
        if(i != -1) {
          buffer = new StringBuffer();
          for(int j = 0 ; j < s.length() ; j++) {
            if(j != i) {
              String tmp = String.valueOf(s.charAt(j));
              buffer.append(tmp);
            }
          }
          return buffer.toString();
        }
      }
    }

    if(strings != null) {
      for(int i = 0 ; i < strings.length ; i++) {
        buffer.append(strings [i]);
      }
      return buffer.toString();
    } else {
      return s;
    }
  }

  private void fillOcurrences(Vector occurrences, Collection subNodesList) {
    Iterator childs = subNodesList.iterator();
    while(childs.hasNext()) {
      DimensionValueNode currentNode = (DimensionValueNode) childs.next();
      if(currentNode.getSubNodesList().size() == 0) {
        if(!(occurrences.contains(currentNode.getValue().toString()))) {
          occurrences.add(currentNode.getValue().toString());
        }
      } else {
        fillOcurrences(occurrences, currentNode.getSubNodesList());
      }
    }
  }

  private int fillGroupingVectorFrom2(Vector first, Vector main, Collection subnodes, Vector dataVector, int row) {
    if(subnodes.size() > 0) {
      Iterator iterator = subnodes.iterator();
      while(iterator.hasNext()) {
        DimensionValueNode node = (DimensionValueNode) iterator.next();
        first.add(((CubeValue)node.getValue()).getValue());
        if(node.getSubNodesList().size() == 0) {
          while(rowsModel.isTotalRow(row)){
            row++;
          }
          fillNonGroupingVectorFrom2(main, first, new Vector(), columnsModel.getDimensionValueNode().getSubNodesList(), dataVector, row, 0);
          row++;
        } else {
          row = fillGroupingVectorFrom2(first, main, node.getSubNodesList(), dataVector, row);
        }
        first.removeElementAt(first.size() - 1);
      }
      return row;
    } else {
      fillNonGroupingVectorFrom2(main, first, new Vector(), columnsModel.getDimensionValueNode().getSubNodesList(), dataVector, row, 0);
      return 0;
    }
  }

  private int fillNonGroupingVectorFrom2(Vector main, Vector first, Vector second, Collection subNodes, Vector dataVector, int row, int col) {
    if(subNodes.size() > 0) {
      Iterator iterator = subNodes.iterator();
      while(iterator.hasNext()) {
        DimensionValueNode node = (DimensionValueNode) iterator.next();
        second.add(node.getValue().toString());
        if(node.getSubNodesList().size() == 0) {
          col = getItemVectorFrom2(main, first, second, dataVector, row, col, false);
        } else {
          col = fillNonGroupingVectorFrom2(main, first, second, node.getSubNodesList(), dataVector, row, col);
        }
        second.removeElementAt(second.size() - 1);
      }
      return col;
    } else {
      getItemVectorFrom2(main, first, second, dataVector, row, col, true);
      return 0;
    }
  }

  private int getItemVectorFrom2(Vector main, Vector first, Vector second, Vector dataVector, int row, int col, boolean isColModelEmpty) {
    Vector itemVector = new Vector();

    for(int i = 0 ; i < first.size() ; i++) {
      itemVector.add(first.elementAt(i));
    }

    for(int i = 0 ; i < second.size() ; i++) {
      itemVector.add(second.elementAt(i));
    }

    int analizedCols = getDatasFrom2(dataVector, row, col, itemVector, isColModelEmpty);

    main.add(itemVector);
    return analizedCols;
  }

  private int getDatasFrom2(Vector dataVector, int row, int col, Vector itemVector, boolean isColModelEmpty) {
    Vector vector = (Vector) dataVector.elementAt(row);
    for(int i = 0 ; i < metricsCount ; i++) {
      if(!isColModelEmpty) {
        while(columnsModel.isTotalCol(col)){
          col++;
        }
      }
      SharedFloat sharedFloat = (SharedFloat) vector.elementAt(col);
      itemVector.add(new Float(sharedFloat.floatValue()));
      col++;
    }
    return col;
  }

}
