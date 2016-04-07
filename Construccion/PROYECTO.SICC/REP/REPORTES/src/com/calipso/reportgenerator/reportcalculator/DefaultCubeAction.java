package com.calipso.reportgenerator.reportcalculator;

import java.util.Collection;

/**
 * Acción default
 */
public class DefaultCubeAction extends CubeAction {
  Object executeOn(Collection rows, Cube cube, int metric, int[] dimensions, Object[] values) {
    return rows;
  }
}
