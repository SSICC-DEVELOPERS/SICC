package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportcalculator.CubeFilter;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.common.DateEx;

import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * Filtro que evalúa si el valor de las dimensiones se encuentra en una lista de valores asociada
 */
public class EnumerationCubeFilter extends CubeFilter {
  private boolean including;
  private HashMap valuesByDimension;

  /**
   * Crea un nuevo filtro de enumeración inicializando la lista de valores
   */
  public EnumerationCubeFilter() {
    valuesByDimension = new HashMap();
  }

  /**
   * Devuelve si el filtro debe devolver TRUE cuando el valor ESTÁ incluido o no
   * @return
   */
  public boolean getIncluding() {
    return including;
  }

  /**
   * Asigna si el filtro debe devolver TRUE cuando el valor ESTÁ incluido o no
   * @param including
   */

  public void setIncluding(boolean including) {
    this.including = including;
  }

  /**
   * Crea un nuevo filtro de enumeración que devuelve verdadero si un valor no está incluido en la lista de valores
   * @return
   */
  public static EnumerationCubeFilter excluding() {
    EnumerationCubeFilter newCube;

    newCube = new EnumerationCubeFilter();
    newCube.setIncluding(false);
    return newCube;
  }

  /**
   * Crea un nuevo filtro de enumeración que devuelve verdadero si un valor está incluido en la lista de valores
   * @return
   */
  public static EnumerationCubeFilter including() {
    EnumerationCubeFilter newCube;

    newCube = new EnumerationCubeFilter();
    newCube.setIncluding(true);
    return newCube;
  }


  /**
   * Resuelve la evaluación del filtro
   * @return
   */
  public boolean matches(Object[] row) {
    if (including) {
      return induclingMatches(row);
    }
    else {
      return excludingMatches(row);
    }
  }

  /**
   * Evalua el filtro sobre row excluyendo los valores
   * @param row
   * @return
   */
  private boolean excludingMatches(Object[] row) {
    Set entrySet;
    Map.Entry entry;
    Iterator iterator;
    Set values;
    Object value;

    entrySet = valuesByDimension.entrySet();
    iterator = entrySet.iterator();
    while (iterator.hasNext()) {
      entry = (Map.Entry) iterator.next();
      values = (Set) entry.getValue();
      int index = ((Integer) entry.getKey()).intValue();
      value = row[index];
      if(contains(values, value)){
        return false;
      }
    }
    return true;
  }

  /**
   * Evalua el filtro sobre row incluyendo los valores
   * @param row
   * @return
   */
  private boolean induclingMatches(Object[] row) {
    Set entrySet;
    Map.Entry entry;
    Iterator iterator;
    Set values;
    Object value;

    entrySet = valuesByDimension.entrySet();
    iterator = entrySet.iterator();
    while (iterator.hasNext()) {
      entry = (Map.Entry) iterator.next();
      values = (Set) entry.getValue();
      if(!values.isEmpty()){
        int index = ((Integer) entry.getKey()).intValue();
        value = row[index];
        if(!contains(values, value)){
          return false;
        }
      }
    }
    return true;
  }

  private boolean contains(Set values, Object value) {
    if (value instanceof SharedDate) {
      Iterator iter = values.iterator();
      while (iter.hasNext()) {
        Date date = null;
        Object o = (Object) iter.next();
        if (!(o instanceof Date)) {
          //DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
          DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT, LanguageTraslator.getLocale());
          try {
            date = dateFormat.parse(o.toString());
            //date = dateFormat.parse(o.toString());
          } catch (ParseException e) {
            e.printStackTrace();
          }
          SharedDate sharedDate = new SharedDate(new DateEx(date));
          if (((Comparable) sharedDate).compareTo(value) == 0) return true;
        }
        else {
          date = (Date) o;
          SharedDate sharedDate = new SharedDate(new DateEx(date));
          if (((Comparable) sharedDate).compareTo(value) == 0) return true;
        }
      }
    }
    else {
      return values.contains(value);
    }
    return false;
  }

  /**
   * Agrega los valores para una dimensión
   * @param measures
   * @param dimension
   */
  public void addTo(Set measures, int dimension) {
    valuesByDimension.put(new Integer(dimension), measures);
  }

  /**
   * Resuelve la representación en texto
   * @return
   */
  public String toString() {
    return "";
  }

  /**
   * Resuelve el texto de consulta Oql (inicialmente este tipo de filtro no se utiliza para consultas Oql)
   * @return
   */
  public String getOqlText() {
    return "";
  }

  public boolean equals(Object obj) {
    if (obj instanceof EnumerationCubeFilter) {
      EnumerationCubeFilter filter = (EnumerationCubeFilter) obj;
      return (including == filter.including) && sameFilter(valuesByDimension, filter.valuesByDimension);
    }
    return false;
  }

  private boolean sameFilter(HashMap valuesByDimension, HashMap valuesByDimension1) {
    if (valuesByDimension.size() != valuesByDimension1.size()) return false;
    Iterator iter = valuesByDimension.keySet().iterator();
    while (iter.hasNext()) {
      Integer key = (Integer) iter.next();
      Set values = (Set) valuesByDimension.get(key);
      Set values1 = (Set) valuesByDimension1.get(key);
      if (!sameValues(values, values1)) return false;
    }
    return true;
  }

  private boolean sameValues(Set values, Set values1) {
    if ((values == null) && (values1 == null)) {
      return true;
    }
    else
      if (values == null) {
        return false;
      }
      else
        if (values1 == null) {
          return false;
        }
        else
          if (values.size() != values1.size()) return false;
    if (values.size() == 0 && values1.size() == 0) return true;
    Iterator valuesIt = values.iterator();
    Iterator values1It = values1.iterator();
    while (valuesIt.hasNext()) {
      Object o1 = valuesIt.next();
      Object o2 = values1It.next();
      if (o1.equals(o2)) {
        return false;
      }
//      if((o1 instanceof SharedString && o2 instanceof SharedString) || o2 instanceof String) {
//        if(!(((SharedString)o1).value().equals(((SharedString)o2).value()))) {
//          return false;
//        }
//      }
    }
    return true;
  }
}
