package com.calipso.reportgenerator.reportcalculator;

import es.indra.mare.common.info.InfoException;

import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.Vector;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.calipso.reportgenerator.common.ReportMetricSpec;
import com.calipso.reportgenerator.reportdefinitions.types.CalculationType;

/**
 * La clase Cube representa la información de un reporte.
 * Podríamos verlo como el resultado de la aplicación de una
 * query a un Pivot. La estructura del Cube es un árbol.
 * En la raíz del mismo hay un array que contiene una serie de
 * dimensiones seguida de las métricas.
 * Mientras en las métricas está acumulado el total de cada una, en las
 * dimensiones y diccionarios.  Cada uno de estos diccionarios contiene, como
 * clave, los distintos valores para la dimension correspondiente (la posición
 * en el array).  Como valor, los diccionarios contienen un nuevo array similar
 * al de la raíz.
 * El resultado es una estructura arbórea que alterna nodos tipo array con
 * diccionarios.
 * Por cuestiones de performance se ha utilizado la clase SharedFloat en lugar
 * de los Float tradicionales
 * @see	    com.calipso.reportgenerator.reportcalculator.CubeQuery
 * @see	    Pivot
 * @see	    SharedFloat
 */

public class Cube implements Serializable, PivotClient {
  private CubeDefinition definition;
  private CubeQuery query;
  private Object[] root;
  private int arraySize;
  private int metricsSize;
  private LinkedList dimensionsCombinations;
  private Set[] dimensionValues;
  private MetricCalculationStrategy[] metricStrategies;
  private MetricCalculationStrategy[] groupFooterStrategies;
  private int dimensionsSize;
  private int[] queryMetrics;
  private static final int INVALID_DIMENSION = 999;
  private Object[] metrics;

  /**
   * Retorna un entero que determina la cantidad de dimensiones
   * @return
   */
  public int getDimensionsSize() {
    return dimensionsSize;
  }

  /**
   * Inicializa la cantidad de dimensiones y métricas del Cube
   * a partir de la cantidad de dimensiones y métricas de la definicion.
   * Inicializa la variable arraySize de acuerdo a la suma de metricas
   * y dimensiones, es decir, el total de columnas.
   * Tambien inicializa las formas de calculo de metricas y totales. Inicializa las
   * metricas auxiliares para el cálculo de promedios.
   */
  private void initialize() {
    metrics = definition.getMetrics();
    initAverageCountMetrics();
    metricsSize = getMetrics().length;
    dimensionsSize = definition.getDimensions().length;
    setArraySize(dimensionsSize + metricsSize);
    initMetricStrategies();
    initGroupFooterStrategies();
  }

  /**
   * Inicializa las metricas adicionales que se usaran para el calculo de los promedios. Por cada metrica crea
   * una adicional que contara las ocurrencias.
   */
  private void initAverageCountMetrics() {
    if(this.hasAverageMetrics()){
      ReportMetricSpec countMetric;
      Object[] resultMetrics = new Object[(metrics.length * 2)];
      for (int i = 0; i < metrics.length; i++) {
        resultMetrics[i] = metrics[i];
        countMetric = new ReportMetricSpec("Count" + i);
        countMetric.setAggregateType(CalculationType.COUNT);
        countMetric.setGroupFooterType(CalculationType.COUNT);
        resultMetrics[metrics.length + i] = countMetric;
      }
      metrics = resultMetrics;
    }
  }

  /**
   * Retorna verdadero si existen metricas que utilizan average.
   * @return
   */
  private boolean hasAverageMetrics() {
    return getAverageMetricsIndexes().length > 0;
  }

  /**
   * Busca las metricas que utilizan average como tipo de calculo. Arma un array con los indices de dichas metricas.
   * @return un array con los indices de las metricas que utilizan average
   */
  private int[] getAverageMetricsIndexes() {
    Object[] metrics = definition.getMetrics();
    LinkedList indexes = new LinkedList();
    for (int i = 0; i < metrics.length; i++) {
      Object metric = metrics[i];
      if(metric instanceof ReportMetricSpec){
        ReportMetricSpec metricSpec = (ReportMetricSpec)metric;
        if((metricSpec.getAggregateType().getType() == CalculationType.AVERAGE_TYPE ||
           metricSpec.getGroupFooterType().getType() == CalculationType.AVERAGE_TYPE) &&
           isMetricInQuery(i)){
          indexes.add(new Integer(i));
        }
      }
    }
    return toIntArray(indexes);
  }

  /**
   * Retorna true si la metrica pasada por parametro esta en la query
   * @param i indice de la metrica que se busca en la query
   * @return true si la metrica esta en la query
   */
  private boolean isMetricInQuery(int i) {
    for (int j = 0; j < queryMetrics.length; j++) {
      if(i + definition.getDimensions().length == queryMetrics[j]){
        return true;
      }
    }
    return false;
  }

  /**
   * Inicializa el array con las estrategias de calculo de los totales tomadas de los ReportMetricSpec de cada metrica.
   */
  private void initGroupFooterStrategies() {
    Object[] metrics = getMetrics();
    groupFooterStrategies = new MetricCalculationStrategy[metrics.length];
    for (int i = 0; i < metrics.length; i++) {
      Object metric = metrics[i];
      if(metric instanceof ReportMetricSpec){
        groupFooterStrategies[i] = getStrategyFor(((ReportMetricSpec)metric).getGroupFooterType());
      }else{
        groupFooterStrategies[i] = new SumStrategy();
      }
    }
  }

  /**
   * Obtiene una estrategia de calculo según corresponda al valor del tipo de calculo especificado en el
   * ReportSourceDefinition para cada metrica. Los tipos existentes pueden verse en CalculationType.
   * @param type
   * @return
   */
  private MetricCalculationStrategy getStrategyFor(CalculationType type) {
    if(type==null){
      return new SumStrategy();
    }
    switch(type.getType()){
      case CalculationType.AVERAGE_TYPE:
        return new AverageStrategy();
      case CalculationType.COUNT_TYPE:
        return new CountStrategy();
      case CalculationType.MAX_TYPE:
        return new MaxStrategy();
      case CalculationType.MIN_TYPE:
        return new MinStrategy();
      case CalculationType.SUM_TYPE:
        return new SumStrategy();
      default:
        return new SumStrategy();
    }
  }

  /**
   * Retorna las metricas del cubo. Normalmente seran las metricas que esten en el definition, pero si
   * existen metricas que calculen AVERAGE las metricas estaran duplicadas (dicha replica contara
   * realizara un COUNT para porder tener la cantidad sobre la cual dividir).
   * @return
   */
  private Object[] getMetrics() {
    return metrics;
  }

  /**
   * Inicializa las estrategias de calculo para cada metrica.
   */
  private void initMetricStrategies() {
    Object[] metrics = getMetrics();
    metricStrategies = new MetricCalculationStrategy[metrics.length];
    for (int i = 0; i < metrics.length; i++) {
      Object metric = metrics[i];
      if(metric instanceof ReportMetricSpec){
        metricStrategies[i] = getStrategyFor(((ReportMetricSpec)metric).getAggregateType());
      }else{
        metricStrategies[i] = new SumStrategy();
      }
    }
  }

  /**
   * Retorna la definicion del Cube
   * @return
   */
  public CubeDefinition getDefinition() {
    return definition;
  }

  /**
   * Asigna al Cube la definición de Cube correspondiente
   * @param definition
   */
  public void setDefinition(CubeDefinition definition) {
    this.definition = definition;
  }

  /**
   * Retorna la Query del Cube
   * @return
   */
  public CubeQuery getQuery() {
    return query;
  }

  /**
   * Asigna la nueva query a ejecutar
   * @param query
   * @throws InfoException Si se produjo un error en el cálculo del cubo.
   */
  public void setQuery(CubeQuery query) throws InfoException {
    try {
      this.query = query;
      queryMetrics = getQuery().getMetrics();
      setDimensionsCombinations();
    }
    catch(Exception e){
      throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("102"),e);
    }
  }

  /**
   * Retorna un array que representa la raíz del cube
   * y que contiene una serie de dimensiones seguidas de las métricas
   * @return
   */
  public Object[] getRoot() {
    return root;
  }

  /**
   * Asigna un array que representa la raíz del cube y que contiene
   * una serie de dimensiones seguidas de las métricas
   * @param root
   */
  public void setRoot(Object[] root) {
    this.root = root;
  }

  /**
   * Retorna arraySize que es un entero que
   * representa la suma de dimensiones y métricas, es decir el total de columnas del Cube.
   * @return
   */
  public int getArraySize() {
    return arraySize;
  }

  /**
   * Inicializa arraySize a partir de un entero que
   * representa la suma de dimensiones y métricas, es decir el total de columnas del Cube.
   * @param arraySize
   */
  public void setArraySize(int arraySize) {
    this.arraySize = arraySize;
  }

  /**
   * Retorna la cantidad total de métricas del Cube.
   * @return
   */
  public int getMetricsSize() {
    return metricsSize;
  }

  /**
   * Crea todas las combinaciones de dimensiones necesarias para cualquier tipo de totales
   * @throws InfoException
   */
 private void setDimensionsCombinations() throws InfoException {
    int[] dimensions;
    int factor;
    int[] list;
    int queryDimensionsSize;
    int combination;
    String bits;
    int bitsLenght;
    int pos;
    try{
      dimensions = getQuery().getDimensions();
      queryDimensionsSize = dimensions.length;
      dimensionsCombinations = new LinkedList();
/*      for (combination = 1; combination <= queryDimensionsSize;combination++){
        list = new int[combination];
        System.arraycopy(dimensions,0,list,0,combination);
        dimensionsCombinations.add(list);
      }
      for (combination = 1; combination <=query.getColumns().length;combination++){
        list = new int[combination];
        System.arraycopy(query.getColumns(),0,list,0,combination);
        dimensionsCombinations.add(list);
      }*/
      for (combination = 1; combination <= (Math.pow(2, queryDimensionsSize) - 1); combination++) {
        bits = Integer.toBinaryString(combination);
        bitsLenght = bits.length();
        list = new int[bitsLenght];
        for (int index = 0; index < bitsLenght; index++) {
          pos = bitsLenght - 1 - index;
          factor = Character.digit(bits.charAt(pos), 10);
          if (factor == 1) {
            list[index] = factor * dimensions[index];
          }
          else {
            list[index] = INVALID_DIMENSION;
          }
        }
        dimensionsCombinations.add(list);
      }
    }
    catch (Exception e){
      throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("103"),e);
    }
  }

  /**
   * Reinicializa el Cube. Como efecto se pierden todos los datos actuales.
   */
  public void reset() {
    initialize();
    root = newArray();
  }


  /**
   * Crea un array para un nodo con el tamaño correspondiente según la cantidad de dimensiones y métricas
   * inicializando los valores de las métricas con 0
   *
   * @return
   */
  private Object[] newArray() {
    Object[] result;
    int index;
    result = new Object[arraySize];
    for (index = dimensionsSize; index < arraySize; index++) {
      result[index] = SharedFloat.newFrom(Float.NaN);
    }

    return result;
  }

  /**
   * Agrega row si pasa por los filtros
   * @param row
   */
  public void fillWith(Object[] row) {
    if (query.matches(row)) {
      fillDimensionValues(row);
      if (query.valuesEnabled(row)) {
        basicFillWith(row);
      }
    }
  }

  /**
   * Resuelve la inclusión de un nuevo row actualizando los totales correspondientes
   * @param aRow
   */
  private void basicFillWith(Object[] aRow) {
    float[] measures;
    Iterator iterator;
    measures = valuesOfFrom(queryMetrics, aRow);
    iterator = dimensionsCombinations.iterator();
    while (iterator.hasNext()) {
      atFromAdd((int[]) iterator.next(), aRow, measures);
    }
    addTotal(measures, root);
  }

  private void fillDimensionValues(Object[] row) {
    int[] dims;
    dims = query.getRows();
    fillDimensionValuesFromArray(dims, row);
    dims = query.getColumns();
    fillDimensionValuesFromArray(dims, row);
    dims = query.getPages();
    fillDimensionValuesFromArray(dims, row);
  }

  private void fillDimensionValuesFromArray(int[] dimensions, Object[] row) {
    for (int i = 0; i < dimensions.length; i++) {
      int dim = dimensions[i];
      if (row[dim] != null){
        getDimensionValues()[dim].add(row[dim]);
      }
    }
  }


  /**
   * Resuelve la operación de sumarización
   * @param measures
   * @param node
   */
  private void addTo(float[] measures, Object[] node) {
    int index;
    for (index = 0; index < metricsSize; index++) {
      node[index + dimensionsSize] = (metricStrategies[index]).operate((SharedFloat) node[index + dimensionsSize], measures[index]);
              //((SharedFloat) node[index + dimensionsSize]).add(measures[index]);
    }
  }

  /**
   * Suma los measures en las coordenadas dadas por dimensions y el contenido de aRow
   * @param dimensions
   * @param aRow
   * @param measures
   */
  private void atFromAdd(int[] dimensions, Object[] aRow, float[] measures) {
    Object[] node;

    node = atFrom(dimensions, aRow);
    if (node != null) {
      if(isLastLevel(dimensions)){
        addTo(measures, node);
      }else{
        addTotal(measures, node);
      }
    }
  }

  /**
   * Agrega valores totales al cubo, realizando el calculo segun la estrategia de total que tenga la metrica.
   * @param measures los valores a agregar
   * @param node el nodo donde se opera
   */
  private void addTotal(float[] measures, Object[] node) {
    for (int index = 0; index < metricsSize; index++) {
      node[index + dimensionsSize] = (groupFooterStrategies[index]).operate((SharedFloat) node[index + dimensionsSize], measures[index]);
    }
  }

  /**
   * Comprueba si las dimensiones especificadas darian un nodo final (de ultimo nivel) o si es un nodo que agrupa.
   * @param dimensions
   * @return
   */
  private boolean isLastLevel(int[] dimensions) {
    if(dimensions.length < getQuery().getDimensions().length){
      return false;
    }
    for (int i = 0; i < dimensions.length; i++) {
      int dimension = dimensions[i];
      if(dimension == INVALID_DIMENSION){
        return false;
      }
    }
    return true;
  }

  /**
   * Retorna los valores para las coordenadas dadas por dimensions y el contenido de aRow
   * Va recorriendo recursivamente los nodos del tipo array hasta agotar las dimensions
   * @param dimensions
   * @param aRow
   * @return
   */
  private Object[] atFrom(int[] dimensions, Object[] aRow) {
    Object[] node;
    int index;
    int dimension;
    int dimensionsLenght;
    Object value;

    node = root;
    dimensionsLenght = dimensions.length;
    for (index = 0; index < dimensionsLenght; index++) {
      dimension = dimensions[index];
      if (dimension != INVALID_DIMENSION) {
        value = aRow[dimension];
        if (value != null) {
          node = atDimensionIn(value, dimension, node);
        }
        else {
          return null;
        }
      }
    }
    return node;
  }

  /**
   * Retorna en un array los valores contenidos en aRow para las métricas dadas por metrics
   * @param metrics
   * @param aRow
   * @return
   */
  private float[] valuesOfFrom(int[] metrics, Object[] aRow) {
    float[] array;

    array = new float[metricsSize];
    for (int index = 0; index < metrics.length; index++) {
      array[index] = ((Float) aRow[metrics[index]]).floatValue();
    }

    return array;
    /*  float[] array;

      array = new float[metricsSize];
        for ( int index = 0; index < metricsSize; index++ )
        {
            array[index] = ((Float) aRow[ metrics[index] ]).floatValue();
        }

        return array;*/
  }

  /**
   * Retorna el porcentaje, con respecto a la fila, de la métrica metric según las
   * coordenadas indicadas por dimensions y values
   * @param metric
   * @param dimensions
   * @param values
   * @return
   */
  public float rowPercentageOf(int metric, int[] dimensions, Object[] values) {
    float total;

    total = rowTotalOf(metric, dimensions, values);
    return percentageOf(metric, dimensions, values, total);
  }

  /**
   * Devuelve el total de una métrica en una fila para las dimensiones que se reciben como parámetro
   * @param metric
   * @param dimensions
   * @param values
   * @return
   */
  private float rowTotalOf(int metric, int[] dimensions, Object[] values) {
    return totalOf(metric, dimensions, values, getQuery().getRows());
  }

  /**
   * Retorna el porcentaje, con respecto a la columna, de la métrica metric según las
   * coordenadas indicadas por dimensions y values
   * @param metric
   * @param dimensions
   * @param values
   * @return
   */
  public float columnPercentageOf(int metric, int[] dimensions, Object[] values) {
    float total;

    total = columnTotalOf(metric, dimensions, values);
    return percentageOf(metric, dimensions, values, total);
  }


  /**
   * Devuelve el total de una columna para una métrica para las dimensiones que se reciben como parámetro
   * @param metric
   * @param dimensions
   * @param values
   * @return
   */
  private float columnTotalOf(int metric, int[] dimensions, Object[] values) {
    return totalOf(metric, dimensions, values, getQuery().getColumns());
  }


  /**
   * Devuelve el total de una métrica para las dimensiones que se reciben como parámetro
   * @param metric
   * @param dimensions
   * @param values
   * @param rows
   * @return
   */
  private float totalOf(int metric, int[] dimensions, Object[] values, int[] rows) {
    int dimension;
    LinkedList selectedDimensions;
    LinkedList selectedValues;
    boolean found;
    int row;
    int dimensionsLenght;
    int rowsLenght;

    selectedDimensions = new LinkedList();
    selectedValues = new LinkedList();
    dimensionsLenght = dimensions.length;
    for (int index = 0; index < dimensionsLenght; index++) {
      dimension = dimensions[index];
      rowsLenght = rows.length;
      found = false;
      for (row = 0; (row < rowsLenght) && !found; row++) {
        found = (rows[row] == dimension);
      }
      if (found) {
        selectedDimensions.add(new Integer(dimension));
        selectedValues.add(values[index]);
      }
    }

    return measureAtDimensionsValues(metric, toIntArray(selectedDimensions), selectedValues.toArray());
  }

  /**
   * Devuelve un array de enteros con los índices seleccionados
   * @param selectedIndexes
   * @return
   */
  private int[] toIntArray(LinkedList selectedIndexes) {
    int[] result;
    int index;
    Iterator iterator;
    int selectedDimensionsSize;

    result = new int[selectedIndexes.size()];
    iterator = selectedIndexes.iterator();
    selectedDimensionsSize = selectedIndexes.size();
    for (index = 0; index < selectedDimensionsSize; index++) {
      result[index] = ((Integer) iterator.next()).intValue();
    }
    return result;
  }

  /**
   * Devuelve el porcentaje de una métrica para las dimensiones especificadas
   * @param metric
   * @param dimensions
   * @param values
   * @param total
   * @return
   */
  private float percentageOf(int metric, int[] dimensions, Object[] values, float total) {
    float value;

    value = measureAtDimensionsValues(metric, dimensions, values);
    if (total == 0) {
      return 0;
    }
    else {
      return value * 100 / total;
    }
  }

  /**
   * Retorna el valor de la métrica metric según las coordenadas indicadas por
   *  dimensions y values
   * @param metric
   * @param dimensions
   * @param values
   * @return
   */
  public float measureAtDimensionsValues(int metric, int[] dimensions, Object[] values) {
    int metricIndex;
    Object[] measures;

    for (metricIndex = 0; metricIndex < getMetricsSize(); metricIndex++) {
      if (getQuery().getMetrics()[metricIndex] == metric) {
        break;
      }
    }
    measures = measuresAtDimensionsValues(dimensions, values);

    return ((SharedFloat) measures[metricIndex + dimensionsSize]).floatValue();
  }

  /**
   * Retorna los valores de las métricas según las coordenadas indicadas por
   *  dimensions y values
   * @param dimensions
   * @param values
   * @return
   */
  public Object[] measuresAtDimensionsValues(int[] dimensions, Object[] values) {
    Object[] node;
    int index;
    int dimensionsLenght;

    node = root;
    dimensionsLenght = dimensions.length;
    for (index = 0; index < dimensionsLenght; index++) {
      node = atDimensionIn(values[index], dimensions[index], node);
    }
    return node;
  }

  /**
   * Retorna el nodo tipo array a partir del node y el valor value para la
   * dimensión.  Si no existen el nodo tipo diccionario y el tipo
   * array, los crea
   * @param value
   * @param dimension
   * @param node
   * @return
   */
  private Object[] atDimensionIn(Object value, int dimension, Object[] node) {
    HashMap dict;
    Object[] array;
    Object o;

    if ((node[dimension] instanceof HashMap)) {
      dict = (HashMap) node[dimension];
    }
    else {
      node[dimension] = dict = new HashMap();
    }
    o = dict.get(value);
    if (o == null) {
      array = newArray();
      dict.put(value, array);
      return array;
    }
    else {
      return (Object[]) o;
    }
  }

  /**
   * Resolución de la serialización
   * @param stream
   * @throws IOException
   */
  public void writeTo(ObjectOutputStream stream) throws IOException {
    stream.writeObject(this);
  }

  /**
   * Resolución de la des-serialización
   * @param stream
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void readFrom(ObjectInputStream stream, Pivot pivot) throws IOException, ClassNotFoundException {
    Cube cube;

    pivot = null;
    cube = (Cube) stream.readObject();
    this.arraySize = cube.arraySize;
    this.definition = cube.definition;
    this.dimensionsCombinations = cube.dimensionsCombinations;
    this.dimensionsSize = cube.dimensionsSize;
    this.metricsSize = cube.metricsSize;
    this.query = cube.query;
    this.queryMetrics = cube.queryMetrics;
    this.root = cube.root;
  }

  /**
   * Incompleto.  Es para agregar incrementalmente una dimensión
   * @param dimension
   */
  public void addDimension(int dimension) {
    int[] dimensions;
    int factor;
    int[] list;
    int queryDimensionsSize;
    int combination;
    String bits;
    int bitsLenght;
    int pos;

    dimensions = getQuery().getDimensions();
    queryDimensionsSize = dimensions.length;
    dimensionsCombinations = new LinkedList();
    for (combination = 1; combination <= (Math.pow(2, queryDimensionsSize) - 1); combination++) {
      bits = Integer.toBinaryString(combination);
      bitsLenght = bits.length();
      list = new int[bitsLenght];
      for (int index = 0; index < bitsLenght; index++) {
        pos = bitsLenght - 1 - index;
        factor = Character.digit(bits.charAt(pos), 10);
        if (factor == 1) {
          list[index] = factor * dimensions[index];
        }
        else {
          list[index] = INVALID_DIMENSION;
        }
      }
      dimensionsCombinations.add(list);
    }
  }

  /**
   * Incompleto.  Es para agregar incrementalmente dimensiones
   * @param newDimensions
   */
  public void fillWithNewDimensions(LinkedList newDimensions) {
    /*    Iterator iterator;
        LinkedList newDimensionsCombinations;
        int dimension;

        iterator = newDimensions.iterator();
        while (iterator.hasNext()) {
            dimension = ((Integer) iterator.next()).intValue();


        }*/
    ///todo: Falta completar resolucón incremental de dimensiones
  }

  /**
   * Devuelve un iterador para recorrer los contenidos de la estructura Cube
   * @return
   */
  public CubeIterator iterator() {
    return CubeIterator.on(this);
  }

  /**
   * Devuelve un iterador para recorrer los valores de una dimensión aplicando el criterio de ordenamiento
   * @param table
   * @param dimensionIndex
   * @return
   */
public Iterator sortedIteratorFor(HashMap table, int dimensionIndex) {
    /*if ( getQuery().getDimensionRank()[dimensionIndex] > 0 ){
      TreeMap treeMap = new TreeMap(getQuery().entryComparatorFor(dimensionIndex));
      treeMap.entrySet().addAll(table.entrySet());
      return treeMap.entrySet().iterator();
    }
    else{*/
      TreeSet set;
      set = new TreeSet(getQuery().entryComparatorFor(dimensionIndex));
      if (table!= null){
        set.addAll(table.entrySet());
      }
      return set.iterator();
    //}
  }

  /**
   * Retorna un iterador ordenado sobre los valores para una dimensión a partir de las coordenadas indicadas por
   * previousDimensions y values
   * @param dimension
   * @param previousDimensions
   * @param values
   * @return
   */
  public Iterator valuesFor(int dimension, int[] previousDimensions, Object[] values) {
    Object[] node;
    HashMap table;

    node = measuresAtDimensionsValues(previousDimensions, values);
    table = (HashMap) node[dimension];

    return sortedIteratorFor(table, dimension);
  }

  public Set[] getDimensionValues() {
    if (dimensionValues == null) {
      dimensionValues = new TreeSet[getDimensionsSize()];
      for (int i = 0; i < dimensionValues.length; i++) {
        dimensionValues[i] = new TreeSet();
      }
    }
    return dimensionValues;
  }

  /**
   * Realiza las operaciones posteriores a la carga de datos del cubo. Se calculan los average y los maximos
   * y minimos para totales.
   */
  public void afterFill() {
    if(emptyCube()){
      root = newEmptyRoot();
    }else{
      int[] indexes = getAverageMetricsIndexes();
      if(indexes.length > 0){
        setAverageValues(root, indexes);
      }
      indexes = getMinMaxFootersIndexes();
      if(indexes.length > 0){
        int[] dimensionsOrder = getDimensionByGroupingOrder();
        for (int i = 0; i < dimensionsOrder.length; i++) {
          setMinMaxFooters(root, indexes, dimensionsOrder, 0);
        }
      }
    }
  }

  /**
   * Obtiene las dimensiones existentes en la query en el orden en el que agrupan. Es decir, desde el primer nivel
   * de row en el que se agrupan todas las dimensiones, hacia las columnas que despliegan las metricas.
   * @return
   */
  private int[] getDimensionByGroupingOrder() {
    int[] result = new int[query.getDimensions().length];
    int[] queryColumns = query.getColumns();
    int[] queryRows = query.getRows();
    System.arraycopy(queryRows, 0, result, 0, queryRows.length);
    System.arraycopy(queryColumns, 0, result, queryRows.length, queryColumns.length);
    return result;
  }

  /**
   * Retorna un nuevo nodo root vacío (solo con valores de metricas inicializados a 0).
   * @return
   */
  private Object[] newEmptyRoot() {
    Object[] result = new Object[arraySize];
    for (int i = dimensionsSize; i < result.length; i++) {
      result[i] = SharedFloat.newFrom(0);
    }
    return result;
  }

  /**
   * Retorna si el cubo que se lleno esta vacio o no.
   * @return true si el cubo esta vacio.
   */
  private boolean emptyCube() {
    int i = 0;
    for (; i < dimensionsSize; i++) {
      if(root[i] != null){
        return false;
      }
    }
    for (; i < arraySize; i++){
      if(!Float.isNaN(((SharedFloat)root[i]).floatValue())){
        return false;
      }
    }
    return true;
  }

  /**
   * Una vez que esta hecho el cubo, recorre los nodos para buscar los maximos y minimos para los footers de grupo
   * que tengan seleccionada alguna de estas funciones. Para ello recorre recursivamente el cubo desde el ultimo
   * nivel hacia el que mas agrupa, seteando en cada nivel los maximos y minimos correspondientes.
   * @param node el nodo que se esta recorriendo
   * @param indexes los indices de las metricas que tienen funciones max y min en sus footers
   * @param modelIndexes los indices del modelo, desde el que mas agrupa hasta el ultimo.
   * @param modelIndex indice dentro del que estoy ubicado dentro de modelIndexes (se referenciara el indice
   * de la dimension como modelIndexes[modelIndex])
   */
  private void setMinMaxFooters(Object[] node, int[] indexes, int[] modelIndexes, int modelIndex) {
    if(modelIndex + 1 < modelIndexes.length){
      Iterator iterator = ((Map)node[modelIndexes[modelIndex]]).entrySet().iterator();
      while (iterator.hasNext()) {
        Object[] childNode = (Object[])((Map.Entry) iterator.next()).getValue();
        for(int childIndex = modelIndex + 1; childIndex < modelIndexes.length; childIndex++){
          setMinMaxFooters(childNode, indexes, modelIndexes, childIndex);
        }
      }
    }
    int nodeIndex = getNodeIndex(node, modelIndexes);
    if(nodeIndex == modelIndexes[modelIndex]){
      for (int i = 0; i < indexes.length; i++) {
        int index = indexes[i];
        node[index] = obtainValue((Map)node[modelIndexes[modelIndex]], index);
      }
    }
    //Si el indice de la dimension esta en Rows y si hay columns, setea los valores maximos y minimos para columns
    if(isInRows(nodeIndex) && getQuery().getColumns()!=null && getQuery().getColumns().length > 0){
      setColumnValues(node, indexes, modelIndexes, nodeIndex);
    }
  }

  /**
   * Dado un indice, retorna si ese indice se encuentra dentro de las row de la query.
   * @param dimensionIndex indice de la dimension que se busca
   * @return true si la dimension esta dentro de rows de la query
   */
  private boolean isInRows(int dimensionIndex) {
    for (int i = 0; i < getQuery().getRows().length; i++) {
      int row = getQuery().getRows()[i];
      if(dimensionIndex==row){
        return true;
      }
    }
    return false;
  }

  /**
   * Setea los totales maximos y minimos para las columnas. Dentro del cube, un nodo que esta en row tiene el
   * despliegue de valores de las distintas combinaciones de column, para totales. Por ello, se deben recorrer
   * todos estos nodos, y buscar los valores maximos y minimos (se hace cuando se termino de cargar el cubo).
   * @param node nodo al que se le setean los maximos y minimos
   * @param indexes indices de las metricas que tienen maximos y minimos en footer.
   * @param modelIndexes indices de las dimensiones en el orden del modelo de la query
   * @param maxNodeIndex si el nodo agrupa en el nivel n, se pasara el indice de la dimension n+1 en orden de agrupacion
   */
  private void setColumnValues(Object[] node, int[] indexes, int[] modelIndexes, int maxNodeIndex) {
    for (int j = getQuery().getRows().length; j < modelIndexes.length; j++) {
      int modelIndex = modelIndexes[j];
      Iterator iterator = ((Map)node[modelIndex]).entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry)iterator.next();
        Vector dimensionsValues = new Vector();
        dimensionsValues.add(entry.getKey());
        Object[] childNode = (Object[])entry.getValue();
        for (int i = 0; i < indexes.length; i++) {
          int footerIndex = indexes[i];
          childNode[footerIndex] = getFooterValueFor(node, dimensionsValues, footerIndex, modelIndexes, j, maxNodeIndex);
        }
        setSubColumnValues(node, childNode, dimensionsValues, indexes, modelIndexes, j + 1, maxNodeIndex, j);
      }
    }
  }

  /**
   * Setea los valores de todos los nodos intermedios en column recorriendolos recursivamente desde el que mas agrupa
   * al que menos (el que despliega en las metricas).
   * @param node nodo de Row al que se le estan seteando los valores
   * @param childNode nodo superior del modelo de column
   * @param dimensionsValues valores agrupados de los nodos anteriores de column
   * @param indexes indices de las metricas que usan max y min en totales
   * @param modelIndexes indices de las dimensiones en el orden del modelo de la query
   * @param columnIndex indice de la columna dentro de los model indexes (se referenciara modelIndexes[columnIndex]).
   * @param maxNodeIndex si el nodo agrupa en el nivel n, se pasara el indice de la dimension n+1 en orden de agrupacion
   * @param startingColumnIndex primera dimension en column que se esta considerando en la agrupacion de dimensionsValues
   */
  private void setSubColumnValues(Object[] node, Object[] childNode, Vector dimensionsValues, int[] indexes, int[] modelIndexes, int columnIndex, int maxNodeIndex, int startingColumnIndex) {
    if(columnIndex < modelIndexes.length){
      Iterator iterator = ((Map)childNode[modelIndexes[columnIndex]]).entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry)iterator.next();
        Vector clonedValues = (Vector)dimensionsValues.clone();
        clonedValues.add(entry.getKey());
        Object[] subNode = (Object[])entry.getValue();
        for (int i = 0; i < indexes.length; i++) {
          int footerIndex = indexes[i];
          subNode[footerIndex] = getFooterValueFor(node, clonedValues, footerIndex, modelIndexes, startingColumnIndex, maxNodeIndex);
        }
        setSubColumnValues(node, subNode, clonedValues, indexes, modelIndexes, columnIndex + 1, maxNodeIndex, startingColumnIndex);
      }
    }
  }

  /**
   * Obtiene el valor maximo o minimo para una column segun los valores de su nodo row
   * @param node nodo row que se esta considerando
   * @param dimensionValues valores agrupados de las dimensiones en column. Se agrupan los valores desde el nivel inicial
   * @param index indice de la metrica
   * @param modelIndexes indices de las dimensiones en el orden del modelo de la query
   * @param columnIndex indice de la columna dentro de los model indexes (se referenciara modelIndexes[columnIndex]).
   * @param maxNodeIndex si el nodo agrupa en el nivel n, se pasara el indice de la dimension n+1 en orden de agrupacion
   * @return
   */
  private SharedFloat getFooterValueFor(Object[] node, Vector dimensionValues, int index, int[] modelIndexes, int columnIndex, int maxNodeIndex) {
    SharedFloat result = SharedFloat.newFrom(Float.NaN);
    Iterator iterator = ((Map)node[maxNodeIndex]).entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      Map subNodeValues = (Map)((Object[])entry.getValue())[modelIndexes[columnIndex]];
      Object[] columnNode = (Object[])subNodeValues.get(dimensionValues.elementAt(0));
      for (int i = 1; i < dimensionValues.size() && columnNode!=null && columnIndex + i < modelIndexes.length; i++) {
        Object dimensionValue = dimensionValues.elementAt(i);
        subNodeValues = (Map)columnNode[modelIndexes[columnIndex+i]];
        columnNode = (Object[])subNodeValues.get(dimensionValue);
      }
      if(columnNode!=null){
        result = groupFooterStrategies[index - dimensionsSize].operate(result, ((SharedFloat)columnNode[index]).floatValue());
      }else{
        result = groupFooterStrategies[index - dimensionsSize].operate(result, 0);
      }
    }
    return result;
  }

  /**
   * Obtiene el mayor indice de grupo de un nodo. Por ejemplo si un estamos considerando un nodo que tiene los valores
   * de la primer dimension en row, retornará el indice de la segunda dimension en row.
   * @param node
   * @param modelIndexes
   * @return
   */
  private int getNodeIndex(Object[] node, int[] modelIndexes) {
    for (int i = 0; i < modelIndexes.length; i++) {
      int modelIndex = modelIndexes[i];
      if(node[modelIndex]!=null){
        return modelIndex;
      }
    }
    return modelIndexes[0];
  }

  /**
   * Dado un conjunto de nodos y un indice de metrica, retorna el valor para el total de esa metrica, calculando,
   * segun corresponda a la metrica, maximo o minimo.
   * @param nodeValues subnodos
   * @param index indice de la metrica
   * @return
   */
  private SharedFloat obtainValue(Map nodeValues, int index) {
    SharedFloat result = SharedFloat.newFrom(Float.NaN);
    for (Iterator iterator = nodeValues.entrySet().iterator(); iterator.hasNext();) {
      Object[] node = (Object[])((Map.Entry) iterator.next()).getValue();
      result = groupFooterStrategies[index - dimensionsSize].operate(result, ((SharedFloat)node[index]).floatValue());
    }
    return result;
  }

  /**
   * Busca los indices de las metricas que utilizan maximos y minimos
   * @return
   */
  private int[] getMinMaxFootersIndexes() {
    Object[] metrics = definition.getMetrics();
    LinkedList indexes = new LinkedList();
    for (int i = 0; i < metrics.length; i++) {
      Object metric = metrics[i];
      if(metric instanceof ReportMetricSpec){
        ReportMetricSpec metricSpec = (ReportMetricSpec)metric;
        if((metricSpec.getGroupFooterType().getType() == CalculationType.MAX_TYPE ||
                metricSpec.getGroupFooterType().getType() == CalculationType.MIN_TYPE) &&
                isMetricInQuery(i)) {
          indexes.add(new Integer(i + dimensionsSize));
        }
      }
    }
    return toIntArray(indexes);
  }

  /**
   * Setea los valores promedio para un nodo
   * @param node nodo a setear
   * @param indexes indices de las metricas que utilizan average
   */
  private void setAverageValues(Object[] node, int[] indexes) {
    setAverageValueForNode(node, indexes);
    int[] dimensions = query.getDimensions();
    for (int i = 0; i < dimensions.length; i++) {
      int dimension = dimensions[i];
      if(node[dimension]!=null){
        setAverageValueForChild((Map)node[dimension], indexes);
      }
    }
  }

  /**
   * Recorre los subnodos de un nodo, seteando recursivamente los valores promedio
   * @param map subnodos
   * @param indexes
   */
  private void setAverageValueForChild(Map map, int[] indexes) {
    for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
      Map.Entry entry = (Map.Entry) iterator.next();
      setAverageValues((Object[])entry.getValue(), indexes);
    }
  }

  /**
   * Setea especificamente el valor del average de un nodo, diferenciando si este es o no total.
   * @param node
   * @param indexes
   */
  private void setAverageValueForNode(Object[] node, int[] indexes) {
    for (int i = 0; i < indexes.length; i++) {
      int index = indexes[i];
      if(isLastLevel(node) && metricStrategies[index] instanceof AverageStrategy){
        node[index + dimensionsSize] = ((SharedFloat)node[index + dimensionsSize]).div((SharedFloat)node[index + dimensionsSize + metricsSize/2]);
      }else if(groupFooterStrategies[index] instanceof AverageStrategy){
        node[index + dimensionsSize] = ((SharedFloat)node[index + dimensionsSize]).div((SharedFloat)node[index + dimensionsSize + metricsSize/2]);
      }
    }
  }

  /**
   * Retorna verdadero si el nodo corresponde al ultimo nivel de grupo, es decir, no agrupa a otras dimensiones.
   * @param node
   * @return
   */
  private boolean isLastLevel(Object[] node) {
    for (int i = 0; i < node.length && i < getDimensionsSize(); i++) {
      if(node[i]!=null){
        return false;
      }
    }
    return true;
  }

  public Object[] getMetricsValuesAt(int[] dimensions, Object[] values) {
    Object[] node;
    int index;
    int dimensionsLenght;

    node = root;
    dimensionsLenght = dimensions.length;
    for (index = 0; index < dimensionsLenght; index++) {
      node = atDimensionValueFor(values[index], dimensions[index], node);
    }
    return node;
  }

  private Object[] atDimensionValueFor(Object value, int dimension, Object[] node) {
    HashMap dict;
    Object o;
    if(node==null){
      return node;
    }
    if ((node[dimension] instanceof HashMap)) {
      dict = (HashMap) node[dimension];
    }
    else {
      return null;
    }
    o = dict.get(value);
    return (Object[]) o;
  }

}
