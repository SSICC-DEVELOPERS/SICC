package com.calipso.reportgenerator.common;

import javax.swing.table.AbstractTableModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Modelo para las tablas de encabezados de filas y columnas
 */

public class HeaderTableModel extends AbstractTableModel {
  public static final int MODE_ROW = 0;
  public static final int MODE_COLUMN = 1;
  private DimensionValueNode dimensionValueNode;
  private boolean withTotals;
  private int dimensionCount;
  private int mode;
  private int rowCount;
  private List visibleMetrics;
  private ReportQuery reportQuery;
  private ReportSpec reportSpec;
  private int iterations = 0;

  /**
   * Crea un nuevo modelo inicializandolo para la tabla de encabezados de fila.
   * @param dimensionValueNode
   * @param withTotals
   * @param rowCount
   * @param reportQuery
   * @return
   */
  public static HeaderTableModel newRowHeaderTableModel(DimensionValueNode dimensionValueNode, boolean withTotals, int rowCount, ReportQuery reportQuery, ReportSpec reportSpec) {
    return new HeaderTableModel(dimensionValueNode, withTotals, MODE_ROW, rowCount, reportQuery, reportSpec);
  }

  /**
   * Crea un nuevo modelo inicializandolo para la tabla de encabezados de columna.
   * @param dimensionValueNode
   * @param withTotals
   * @param rowCount
   * @param reportQuery
   * @return
   */
  public static HeaderTableModel newColumnHeaderTableModel(DimensionValueNode dimensionValueNode, boolean withTotals, int rowCount, ReportQuery reportQuery, ReportSpec reportSpec) {
    return new HeaderTableModel(dimensionValueNode, withTotals, MODE_COLUMN, rowCount, reportQuery, reportSpec);
  }

  /**
   * Crea e inicializa una nueva instancia.
   * @param dimensionValueNode
   * @param withTotals
   * @param mode
   * @param rowCount
   * @param reportQuery
   */

  protected HeaderTableModel(DimensionValueNode dimensionValueNode, boolean withTotals, int mode, int rowCount, ReportQuery reportQuery, ReportSpec reportSpec) {
    this.dimensionValueNode = dimensionValueNode;
    this.withTotals = withTotals;
    this.dimensionCount = dimensionValueNode.getDimensionCount();
    this.mode = mode;
    this.rowCount = rowCount;
    this.reportQuery = reportQuery;
    this.reportSpec = reportSpec;
    initialize();
  }

  /**
   * Inicializa la lista de metricas visibles a partir de la ReportQuery
   */
  private void initialize() {
    visibleMetrics = reportQuery.getVisibleMetrics();
  }


  /**
   * Devuelve la lista de Métricas visibles
   * @return
   */
  public List getVisibleMetrics() {
    return visibleMetrics;
  }

  /**
   * Devuelve la cantidad de métricas visibles
   * @return
   */
  public int getVisibleMetricsCount() {
    return getVisibleMetrics().size();
  }

  /**
   * Devuelve el Nodo raíz del arbol de grupos
   * @see com.calipso.reportgenerator.common.DimensionValueNode
   * @see com.calipso.reportgenerator.reportmanager.DimensionValueTreeBuilder
   * @return
   */
  public DimensionValueNode getDimensionValueNode() {
    return dimensionValueNode;
  }

  /**
   * Devuelve verdadero si se deben mostrar los totales
   * @return
   */
  public boolean getWithTotals() {
    return withTotals;
  }

  /**
   * Especifica si se deben mostrar los totales
   * @param withTotals
   */

  public void setWithTotals(boolean withTotals) {
    this.withTotals = withTotals;
  }


  /**
   * Asigna el nodo raíz del arbol de grupos
   * @param dimensionValueNode
   */
  public void setDimensionValueNode(DimensionValueNode dimensionValueNode) {
    this.dimensionValueNode = dimensionValueNode;
  }

  /**
   * Devuelve la cantidad de dimensiones que agrupan
   * @return
   */
  public int getDimensionCount() {
    return dimensionCount;
  }

  /**
   * Asigna la cantidad de dimensiones que agrupan
   * @param dimensionCount
   */
  public void setDimensionCount(int dimensionCount) {
    this.dimensionCount = dimensionCount;
  }

  /**
   * Devuelve la cantidad de renglones que tendrá la tabla, su valor depennde del modo en que esté trabajando (fila o
   * columna)
   * @return
   */
  public int getRowCount() {
    int count = 0;
    switch (mode) {
      case MODE_ROW:
        return Math.max(doGetRowCount(), 1);
      case MODE_COLUMN:
        count = doGetColumnCount();
        if ((getVisibleMetricsCount() > 1) || (count == 0)) {
          count++;
        }
        return count;
    }
    return count;
  }

  /**
   * Devuelve la cantidad de columnas que tendrá la tabla, su valor depennde del modo en que esté trabajando (fila o
   * columna)
   */

  public int getColumnCount() {
    switch (mode) {
      case MODE_ROW:
        return Math.max(doGetColumnCount(), 1);
      case MODE_COLUMN:
        return doGetRowCount();
    }
    return 0;
  }

  /**
   * devuelve la cantidad de nodos del ultimo nivel del arbol dependiendo del modo se utiliza para obtener la cantidad de
   * filas o la cantidad de columnas del arbol
   * @return
   */
  public int doGetRowCount() {
    return rowCount;
  }

  /**
   * Asigna la cantidad de nodos del ultimo nivel, este valor se setea siempre que se redibuje la tabla porque si hay grupos
   * colapsados este valor puede variar.
   * @param value
   */
  public void setRowCount(int value) {
    rowCount = value;
  }

  /**
   * Devuelve la cantidad de dimensiones que agrupan, se utiliza para conocer la cantidad de filas o columnas de la tabla
   * dependiendo del modo
   * @return
   */
  public int doGetColumnCount() {
    int count = getDimensionCount();
    return count;
  }

  /**
   * Metodo no implemntado de <code>AbstractTableModel</code>.
   * @param rowIndex
   * @param columnIndex
   * @return
   */
  public Object getValueAt(int rowIndex, int columnIndex) {
    return null;
  }

  /**
   * Devuelve el indice de una columna correspondiente a un nodo
   * @param node
   * @return
   */
  public int getNodeColumn(DimensionValueNode node) {
    return node.getDimesionIndex();
  }

  /**
   * Devuelve un array de celdas que deben dibujarse para representar un nodo (si el nodo tiene subnodos, requerirá
   * más de una celda para su representación)
   * @param node
   * @return
   */
  public int[][] getNodeCells(DimensionValueNode node, int row, int size) {
    if (node.getCollapsed()) {
      return getCollapsedNodeCells(node, row);
    }
    else {
      return getExpandedNodeCells(node, row, size);
    }
  }

  /**
   * Devuelve un array de celdas que deben dibujarse para representar un nodo colapsado
   * @param node
   * @param row
   * @return
   */
  private int[][] getCollapsedNodeCells(DimensionValueNode node, int row) {
    int xSize = getDimensionCount() - (node.getDimesionIndex());
    int[][] cells = new int[xSize][2];
    for (int i = 0; i < xSize; i++) {
      cells[i] = newCell(row, node.getDimesionIndex() + i);
    }
    return cells;
  }

  /**
   * Devuelve un array de celdas que deben dibujarse para representar un nodo expandido
   * @param node
   * @param row
   * @param size
   * @return
   */
  private int[][] getExpandedNodeCells(DimensionValueNode node, int row, int size) {
    int xSize = size;
    int nodeDimIndex = node.getDimesionIndex();
    int[][] cells = new int[xSize][2];
    for (int i = 0; i < xSize; i++) {
      cells[i] = newCell(row + i, nodeDimIndex);
    }
    return cells;
  }


  /**
   * Devuelve un array de celdas que deben dibujarse para representar un nodo como total
   * @param node
   * @param lastRow
   * @return
   */
  public int[][] getTotalNodeCells(DimensionValueNode node, int lastRow) {
    int size = getDimensionCount() - (node.getDimesionIndex() + 1);
    int[][] cells = new int[size][2];
    for (int i = 0; i < size; i++) {
      cells[i] = newCell(lastRow, node.getDimesionIndex() + 1 + i);
    }
    return cells;
  }

  /**
   * Crea una array de dos posiciones donde la primera es el indice de fila y la segunda es el indice de columna
   * Dependiendo del modo, se decide a que posición del array se asigna cada parámetro (el resto de la clase trabaja
   * como si siempre el modo fuera MODE_ROW y con este método se invierten las coordenadas en el caso de modo MODE_COLUMN
   * @param row
   * @param col
   * @return
   */
  public int[] newCell(int row, int col) {
    int[] cell = new int[2];
    switch (mode) {
      case MODE_ROW:
        cell[0] = row;
        cell[1] = col;
        break;
      case MODE_COLUMN:
        cell[0] = col;
        cell[1] = row;
        break;
    }
    return cell;
  }

  /**
   * Devuelve el modo en que se dibuja la tabla
   * @return
   */
  public int getMode() {
    return mode;
  }

  /**
   * Asigna el modo en que se dibuja la tabla
   * @param mode
   */
  public void setMode(int mode) {
    this.mode = mode;
  }

  /**
   * Devuelve verdadero si el modo es colapsable (esto es si es un nodo que agrupa subnodos)
   * @param node
   * @return
   */
  public boolean getNodeIsCollapsable(DimensionValueNode node) {
    return node.getDimesionIndex() < getDimensionValueNode().getDimensionCount() - 1;
  }

  /**
   * @param row
   * @param col
   * @return Devuelve true si el nodo es colapsable y se logró colapsar o expandir
   */

  public boolean changeNodeState(int row, int col) {
    DimensionValueNode root = getDimensionValueNode();
    int internalRow;
    int internalCol;
    if (mode == HeaderTableModel.MODE_ROW) {
      internalRow = row;
      internalCol = col;
    }
    else {
      internalRow = col;
      internalCol = row;
    }
    DimensionValueNode node = findCollapsableNode(root, internalRow, internalCol, new RowIndexCarrier());
    if (node != null) {
      node.changeDimensionValueNodeState();
    }
    return node != null;
  }

  /**
   * Clase interna que se utiliza para acumular el valor del ultimo indice recorrido en metodos recursivos
   */
  private class RowIndexCarrier {
    private int index = 0;

    public int getIndex() {
      return index;
    }

    public void inc(int value) {
      index += value;
    }
  }

  /**
   * Devuelve el nodo colapsable correspondiente a las coordenadas de fila y columna que se reciben como parámetro
   * @param node
   * @param row
   * @param col
   * @param carrier
   * @return
   */
  private DimensionValueNode findCollapsableNode(DimensionValueNode node, int row, int col, RowIndexCarrier carrier) {
    DimensionValueNode resultNode = null;
    Iterator iterator = (node.getSubNodesList()).iterator();
    if (carrier.getIndex() == row && node.getDimesionIndex() == col) {
      resultNode = node;
    }
    else {
      if (!node.getCollapsed()) {
        while (resultNode == null && iterator.hasNext()) {
          DimensionValueNode subNode = (DimensionValueNode) iterator.next();
          if (carrier.getIndex() <= row && subNode.getDimesionIndex() < getDimensionCount() - 1) {
            resultNode = findCollapsableNode(subNode, row, col, carrier);
          }
          if (subNode.getDimesionIndex() == getDimensionCount() - 1) {
            carrier.inc(getCarrierIncrement());
          }
        }
      }
      if (node.getCollapsed() || getWithTotals()) {
        carrier.inc(getCarrierIncrement());
      }
    }
    return resultNode;
  }

  private int getCarrierIncrement() {
    if (getMode() == MODE_ROW) {
      return 1;
    }
    else {
      return getVisibleMetricsCount();
    }
  }

  /**
   * Devuelve los valores de las dimensiones para un indice de fila (o columna dependiendo del modo)
   * @param index
   * @return
   */
  public Object[] getValueFrom(int index) {
    if (mode == MODE_ROW || getVisibleMetricsCount() == 1) {
      DimensionValueNode node = (DimensionValueNode) getDimensionValueNode().getAllSubNodes().get(new Integer(index));
      return getNodeValues(node);
    }
    else {
      int metricIndex = index % getVisibleMetricsCount();
      int actualIndex = index - metricIndex;
      DimensionValueNode node = (DimensionValueNode) getDimensionValueNode().getAllSubNodes().get(new Integer(actualIndex));
      if (node == null && actualIndex == 0) {
        node = getDimensionValueNode();
      }
      return getNodeValues(node, metricIndex);
    }
  }

  public Object[] getValuesFrom(int index) {
    DimensionValueNode root = getDimensionValueNode();
    return getValuesFrom(root, index, new IntegerExt(0));
  }

  public Object[] getValuesFrom(DimensionValueNode node, int wantedIndex, IntegerExt integer) {
    boolean found = false;
    Object[] returnVal = null;
    if (node.getSubNodesList().size() == 0) {
      if (integer.getCurrentValue() == wantedIndex) {
        returnVal = getValuesFrom(node);
        return returnVal;
      }
      else {
        integer.sumValue(1);
      }
    }
    else {
      Collection nodes = node.getSubNodesList();
      Iterator iterator = nodes.iterator();
      while (iterator.hasNext() && !found) {
        DimensionValueNode currentNode = (DimensionValueNode) iterator.next();
        returnVal = getValuesFrom(currentNode, wantedIndex, integer);
        if (returnVal != null) {
          found = true;
        }
      }
    }
    return returnVal;
  }

  private Object[] getValuesFrom(DimensionValueNode leaf) {
    Object returnVal [];
    if (mode == MODE_ROW) {
      returnVal = new Object[getColumnCount()];
      fillArray(returnVal, leaf, returnVal.length - 1, "ROWS");
    }
    else {
      returnVal = new Object[getRowCount()];
      fillArray(returnVal, leaf, returnVal.length - 1, "COLUMNS");
    }
    return returnVal;
  }

  private void fillArray(Object[] returnVal, DimensionValueNode node, int i, String mode) {
    if (!node.getValue().toString().equalsIgnoreCase(mode)) {
      returnVal[i] = node.getValue().toString();
      fillArray(returnVal, node.getParentNode(), i - 1, mode);
    }
  }

  /**
   * Devuelve el título de una métrica segun el indice en que aparecen el la ReportQuery
   * @param index
   * @return
   */
  public String getMetricCaption(int index) {
    QueryMetric metric = (QueryMetric) reportQuery.getVisibleMetrics().get(index);
    return reportSpec.getMetricFromName(metric.getName()).getCaption();
  }

  /**
   * Devuelve los valores de las dimensiones para un indice de fila (o columna dependiendo del modo), para el caso en que
   * hay mas de una métrica, se debe especificar el nombre de la métrica además de los valores de dimensiones
   * @param node
   * @param metricIndex
   * @return
   */
  private Object[] getNodeValues(DimensionValueNode node, int metricIndex) {
    Object[] auxValues = getNodeValues(node);
    Object[] result = new Object[auxValues.length + 1];
    System.arraycopy(auxValues, 0, result, 0, auxValues.length);
    result[result.length - 1] = getMetricCaption(metricIndex);
    return result;
  }

  /**
   * Devuelve los valores de las dimensiones para un indice de fila (o columna dependiendo del modo)
   * @param node
   * @return
   */
  private Object[] getNodeValues(DimensionValueNode node) {
    Object[] values = new Object[getDimensionCount()];
    DimensionValueNode currentNode = node;
    while ((currentNode != null) && currentNode.getDimesionIndex() >= 0) {
      values[currentNode.getDimesionIndex()] = currentNode.getValue().toString();
      currentNode = currentNode.getParentNode();
    }
    return values;
  }

  /**
   * Obtiene el FooterCaption para la dimension.
   * @param dimesionIndex
   * @return
   */
  public String getGroupFooterCaption(int dimesionIndex) {
    if (dimesionIndex >= 0) {
      List dimensions;
      if (getMode() == MODE_COLUMN) {
        dimensions = reportQuery.getColumnDimensions();
      }
      else {
        dimensions = reportQuery.getRowDimensions();
      }
      QueryDimension dimension = (QueryDimension) dimensions.get(dimesionIndex);
      String result = reportSpec.getDimensionFromName(dimension.getName()).getGroupFooterCaption();
      if ((result!=null)&&(result != "")) return result;
    }
    return LanguageTraslator.traslate("358");
  }

  /**
   * Calcula si una row es total
   * @param row
   * @return
   */
  public boolean isTotalRow(int row) {
    if(!reportQuery.isVisibleTotals()){
      return false;
    }
    Vector totals = new Vector();
    fillTotalRows(totals, this.getDimensionValueNode());
    iterations = 0;
    return totals.contains(new Integer(row));
  }

  /**
   * Calcula si una columna es total
   * @param col
   * @return
   */
  public boolean isTotalCol(int col) {
    if(!reportQuery.isVisibleTotals()){
      return false;
    }
    Vector totals = new Vector();
    fillTotalCols(totals, this.getDimensionValueNode());
    iterations = 0;
    return totals.contains(new Integer(col));
  }

  /**
   * Llena un Vector con las columnas que son totales
   * @param totals
   * @param node
   */
  public void fillTotalCols(Vector totals, DimensionValueNode node) {
    if (node.getSubNodesList().isEmpty()) {
      iterations += getVisibleMetricsCount();
      return;
    }
    Iterator iterator = node.getSubNodesList().iterator();
    while (iterator.hasNext()) {
      DimensionValueNode current = (DimensionValueNode) iterator.next();
      fillTotalCols(totals, current);
    }
    for (int i = 0; i < getVisibleMetricsCount(); i++) {
      totals.add(new Integer(iterations));
      iterations++;
    }
  }

  /**
   * Calcula las filas totales en base al nodo ROW y llena un vector con los resultados
   * @param totals
   * @param node
   */
  public void fillTotalRows(Vector totals, DimensionValueNode node) {
    if (node.getSubNodesList().isEmpty()) {
      iterations++;
      return;
    }
    Iterator iterator = node.getSubNodesList().iterator();
    while (iterator.hasNext()) {
      DimensionValueNode current = (DimensionValueNode) iterator.next();
      fillTotalRows(totals, current);
    }
    totals.add(new Integer(iterations));
    iterations++;
  }

}