package com.calipso.reportgenerator.reportcalculator.expression;

/**
 * Tipo especializado de Context que obtiene los valores del contexto
 * a partir de un Object[] que se obtiene de una row del IRDataSource
 * Para esto las expresiones están construidas de modo que las referencias sean los índices de la columna
 * correspondiente en la row.
 * @see com.calipso.reportgenerator.common.ReportFilter
 * @see com.calipso.reportgenerator.common.ReportFilterBuilder
 */
public class RowContext extends Context {
  private Object[] row;

  /**
   * Crea un contexto a partir de un Object[]
   * @param row
   */
  public RowContext(Object[] row) {
    this.row = row;
  }

  /**
   * Devuelve el valor para una referencia, asumiendo que la misma es un entero que representa al índice de columna
   * de la row
   * @param reference
   * @return
   */
  public Object valueFor(Object reference) {
    return row[((Integer) reference).intValue()];
  }

}
