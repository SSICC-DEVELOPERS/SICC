package com.calipso.reportgenerator.reportcalculator;

import java.util.Collection;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Itera un Cube.
 * A diferencia de un iterador tradicional de Java, la interface separa la
 * obtención del valor actual (current) del avance (advance).
 * Además, luego de cada advance, se recalculan los totales por los que pueda
 * haberse atravesado.  Es decir, se genera una lista de totales para cada corte
 * de control realizado por los últimos valores con respecto a los anteriores.
 * La forma de operar es obtener el iterador del Cube.
 * Hacer recursivamente advance y consultar por current y por currentTotals
 * Luego de obtener el último current hasNext va a devolver false.
 * En ese momento debe hacerse un nuevo advance para obtener los últimos totales.
 */
public class CubeIterator {
  LinkedList totals;
  Iterator[] iterators;
  Map.Entry[] entries;
  int[] dimensions;
  int[] metrics;
  Cube cube;
  int metricsSize;
  int dimensionsSize;


  /**
   * Crea un iterador para recorrer el Cube que se recibe como parámetro
   * @param cube
   * @return
   */
  public static CubeIterator on(Cube cube) {
    return new CubeIterator(cube);
  }

  /**
   * Crea un iterador para recorrer el Cube que se recibe como parámetro
   * @param cube
   */
  public CubeIterator(Cube cube) {
    this.cube = cube;
    initialize();
  }

  /**
   * Inicializa los valores que describen al cubo, cantidad de métricas, cantidad de dimensiones y prepara las
   * estructuras internas
   */
  private void initialize() {
    metrics = cube.getQuery().getMetrics();
    metricsSize = metrics.length;
    dimensions = cube.getQuery().getDimensions();
    dimensionsSize = dimensions.length;
    entries = new Map.Entry[dimensionsSize + 1];
    iterators = new Iterator[dimensionsSize];
    // Carga el primer nodo
    entryAtPut(-1, new Entry("root", cube.getRoot()));
  }

  /**
   * Devuelve una asociación que representa a un nodo del cube
   * @param index
   * @return
   */
  public Map.Entry entryAt(int index) {
    return entries[index + 1];
  }

  /**
   * Agrega una asociación que representa a un nodo del cube, reemplazando el valor de la dimensión por el valor real
   * @param index
   * @param value
   */
  public void entryAtPut(int index, Map.Entry value) {
    entries[index + 1] = value;
    fillEntryWithParentsValues(index);
  }

  /**
   * Asigna a un nodo tipo array indicado por index los
   * valores de las métricas bajo las cuales está, es decir,
   * de los nodos encontrados ascendentemente.  Esto se usa
   * para cuando se devuelven estos nodos a modo de totales
   * @param index
   */
  private void fillEntryWithParentsValues(int index) {
    int i;
    Map.Entry entry;
    for (i = 0; i <= index; i++) {
      entry = entries[i + 1];
      if (entry != null) {
        ((Object[]) entries[index + 1].getValue())[dimensions[i]] = entry.getKey();
      }
    }
  }

  /**
   * Inicializa un nuevo iterador para una dimensión
   * @param dimensionIndex
   */
  public void initializeIterator(int dimensionIndex) {
    iterators[dimensionIndex] = iteratorFor(dimensionIndex);
    if (iterators[dimensionIndex].hasNext()) {
      updateEntry(iterators[dimensionIndex], dimensionIndex);
    }
  }

  /**
   * Crea un iterador para una dimensión
   * @param dimensionIndex
   * @return
   */
  private Iterator iteratorFor(int dimensionIndex) {
    HashMap table;
    Object[] node;

    node = (Object[]) entryAt(dimensionIndex - 1).getValue();
    int cubeDimIndex = dimensions[dimensionIndex];
    table = (HashMap) node[cubeDimIndex];
    if (table != null) {
      return cube.sortedIteratorFor(table, cubeDimIndex);
    }
    else {
      return null;
    }
  }

  /**
   * Agrega una asociación que representa a un nodo para el valor de una dimensión
   * @param iterator
   * @param dimensionIndex
   */
  private void updateEntry(Iterator iterator, int dimensionIndex) {
    entryAtPut(dimensionIndex, (Map.Entry) iterator.next());
  }

  /**
   * El iterador avanza una posicion.
   */
  public void advance() {
    totals = new LinkedList();
    advanceAt(dimensionsSize - 1);
  }

  /**
   * Avance el iterador para la dimensión dimensionIndex, si es
   * que está asignado, si no, o si se terminó, hace avanzar el
   * iterador anterior y luego crea uno nuevo
   * @param dimensionIndex
   */
  private void advanceAt(int dimensionIndex) {

    if (dimensionIndex >= 0) {
      if (iterators[dimensionIndex] != null) {
        if (iterators[dimensionIndex].hasNext()) {
          updateEntry(iterators[dimensionIndex], dimensionIndex);
          return;
        }
        else {
          iterators[dimensionIndex] = null;
          totals.add(totalFrom(dimensionIndex - 1));
        }
      }
      advanceAt(dimensionIndex - 1);
      initializeIterator(dimensionIndex);
    }
  }

  /**
   * Crea un array con los totales para la dimensión dimensionIndex
   * Si el total a devolver es el raíz, puede tener hashmaps que hay
   * que sacar.  Si no fuese por esto devolveríamos directamente:
   * entryAt(dimensionIndex).getValue();
   * @param dimensionIndex
   * @return Object
   */
  private Object totalFrom(int dimensionIndex) {
    Object[] result;
    int i;
    Object[] node;

    node = (Object[]) entryAt(dimensionIndex).getValue();
    result = new Object[node.length];
    for (i = 0; i < dimensionsSize; i++) {
      if (node[i] instanceof HashMap) {
        result[i] = null;
      }
      else {
        result[i] = node[i];
      }
    }
    for (i = 0; i < metricsSize; i++) {
      result[dimensionsSize + i] = node[metrics[i]];
    }
    return result;
  }

  /**
   * A partir de la posición adonde apunta el CubeIterator
   * devuelve verdadero/falso dependiendo si hay o no mas datos en el cubo
   */
  public boolean hasNext() {
    Iterator iterator;
    if (iterators.length == 0){
      return false;
    }
    if (iterators[0] == null) {
      iterator = iteratorFor(0);
      if (iterator != null) {
        return iterator.hasNext();
      }
      else {
        return false;
      }
    }
    for (int i = 0; i < dimensionsSize; i++) {
      iterator = iterators[i];
      if (iterator.hasNext()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Crea un array con los valores actuales
   * @return [] Object
   */
  public Object[] current() {
    Object[] result;
    int i;
    Object[] node;

    result = new Object[dimensionsSize + metricsSize];
    for (i = 0; i < dimensionsSize; i++) {
      result[i] = entryAt(i).getKey();
    }
    node = (Object[]) entryAt(dimensionsSize - 1).getValue();
    for (i = 0; i < metricsSize; i++) {
      result[dimensionsSize + i] = node[metrics[i]];
    }
    return result;
  }

  /**
   * Retorna una lista enlazada con los totales actuales
   * @return LinkedList
   */
  public Collection currentTotals() {
    return totals;
  }
}