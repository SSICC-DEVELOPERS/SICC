package com.calipso.reportgenerator.reportcalculator;

import java.io.Serializable;

/**
 * Filtro sobre Cube. Criterio que se utiliza para incluir las rows
 */
public abstract class CubeFilter implements Serializable {
  public CubeFilter() {
  }

  /**
   * Se utiliza para generar la condición de una consulta OQL en los pre-filtros
   * @return
   */
  public abstract String getOqlText();

  /**
   * Se utiliza para evaluar si una row cumple con los filtros
   * Estos pueden ser pre-filtros en el caso del XMLReportDataSource
   * O post-filtros cuando se procesan las rows que se reciben del pivot
   * @see com.calipso.reportgenerator.reportmanager.XmlReportDataSource
   * @see com.calipso.reportgenerator.reportcalculator.Pivot
   * @param row
   * @return
   */
  public abstract boolean matches(Object[] row);

}