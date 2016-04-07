package com.calipso.reportgenerator.reportcalculator;

import java.util.Iterator;

/**
 * Estructura intermedia en la que se almacenan los datos provenientes del IRDataSource
 * En el futuro esta estructura puede ser directamente reemplazada por el IRDataSource
 */

public interface Matrix {

  public Iterator iterator();
  public boolean isEmpty();

}
