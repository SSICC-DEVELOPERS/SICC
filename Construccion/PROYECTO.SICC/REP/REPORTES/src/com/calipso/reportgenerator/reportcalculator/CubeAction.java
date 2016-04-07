package com.calipso.reportgenerator.reportcalculator;

import java.util.Collection;

/**
 * Representa una acci�n a evaluarse sobre una colecci�n de filas (rows) pertenecientes
 * a un cube.  La acci�n fue ejecutada en las coordenadas dadas por dimensions y values
 */
public abstract class CubeAction {

  CubeAction() {
  }

  abstract Object executeOn(Collection rows, Cube cube, int metric, int[] dimensions, Object[] values);
}
