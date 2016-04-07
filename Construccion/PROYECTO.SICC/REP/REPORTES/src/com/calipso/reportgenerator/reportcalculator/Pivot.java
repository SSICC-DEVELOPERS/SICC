package com.calipso.reportgenerator.reportcalculator;

import es.indra.mare.common.info.InfoException;

import java.util.Iterator;
import java.util.LinkedList;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Contiene la matriz de datos, administra el llenado de un Cube a partir
 *  de una CubeQuery y evalúa las acciones
 * @see Matrix
 * @see Cube
 */
public class Pivot implements Serializable {
  private Matrix matrix;
  //private CubeQuery lastQuery;

  /**
   * Devuelve la matriz
   * @return
   */
  public Matrix getMatrix() {
    return matrix;
  }

  /**
   * Asigna una matriz
   * @param matrix
   */
  public void setMatrix(Matrix matrix) {
    this.matrix = matrix;
  }

  /**
   * Llena el Cube
   * @param pivotClient
   * @throws InfoException Si se produce un erro al llenar el pivotClient
   */
  public void fill(PivotClient pivotClient) throws InfoException {
    try {
      pivotClient.reset();
      Iterator iterator;
      iterator = matrix.iterator();
      try {
        while (iterator.hasNext()) {
          pivotClient.fillWith((Object[]) iterator.next());
        }
        pivotClient.afterFill();
      } catch (Exception e) {
        throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("105"), e);
      }
    } catch(OutOfMemoryError e) {
      throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("326"), e);
    }
  }

  /**
   * Resuelve la ejecución de una acción devolviendo todos los rows asociados
   * @param action
   * @param cube
   * @param metric
   * @param dimensions
   * @param values
   * @return
   */
  public Object executeAction(CubeAction action, Cube cube, int metric, int[] dimensions, Object[] values) {
    LinkedList involved;
    Object[] row;

    involved = new LinkedList();
    Iterator iterator;

    iterator = matrix.iterator();
    while (iterator.hasNext()) {
      row = (Object[]) iterator.next();
      if (matches(row, cube, dimensions, values)) {
        involved.add(row);
      }
    }
    return action.executeOn(involved, cube, metric, dimensions, values);
  }

  /**
   * Resuelve si una row cumple con los filtros de la query
   * @param row
   * @param cube
   * @param dimensions
   * @param values
   * @return
   */
  private boolean matches(Object[] row, Cube cube, int[] dimensions, Object[] values) {
    int index;
    int lenght;
    int dimension;
    Object value;

    if (cube.getQuery().matches(row) && cube.getQuery().valuesEnabled(row)) {
      lenght = dimensions.length;
      for (index = 0; index < lenght; ++index) {
        dimension = dimensions[index];
        value = values[index];
        if (row[dimension] != value) {
          return false;
        }
      }
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Resuelve la serialización
   * @param stream
   * @throws IOException
   */
  public void writeTo(ObjectOutputStream stream) throws IOException {

    stream.writeObject(matrix);
  }

  /**
   * Resuelve la des-serialización
   * @param stream
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void readFrom(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    matrix = (Matrix) stream.readObject();
  }
}