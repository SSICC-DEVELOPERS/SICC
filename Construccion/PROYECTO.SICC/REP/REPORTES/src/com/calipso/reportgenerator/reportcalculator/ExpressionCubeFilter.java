package com.calipso.reportgenerator.reportcalculator;

import com.calipso.reportgenerator.reportcalculator.expression.Expression;
import com.calipso.reportgenerator.reportcalculator.expression.Context;
import com.calipso.reportgenerator.reportcalculator.expression.RowContext;
import com.calipso.reportgenerator.reportcalculator.CubeFilter;

import java.util.Map;

/**
 * Filtro basado en una expresión booleana
 * @see com.calipso.reportgenerator.reportcalculator.expression.Expression
 */
public class ExpressionCubeFilter extends CubeFilter {
  Expression expresion;
  private Map paramValues;

  public Map getParamValues() {
    return paramValues;
  }

  /**
   * Crea un nuevo filtro a partir de una expresión
   * @param expresion
   */
  public ExpressionCubeFilter(Expression expresion, Map paramValues) {
    this.paramValues = paramValues;
    this.expresion = expresion;
  }

  /**
   * Crea un contexto de evaluación a partir de un row
   * @param row
   * @return
   */
  private Context getContext(Object[] row) {
    return new RowContext(row);
  }

  /**
   * Devuelve el texto de la condición Oql de la expresión
   * @return
   */
  public String getOqlText() {
    return expresion.toString();
  }

  /**
   * Evalúa el filtro para una row
   * @param row
   * @return
   */
  public boolean matches(Object[] row) {
    if(expresion!=null){
      return expresion.valueIn(getContext(row));
    }else{
      return true;
    }
  }

  /**
   * Devuelve la representación en texto del filtro
   * @return
   */
  public String toString() {
    if(expresion!=null){
      return expresion.toString();
    }else{
      return "";
    }
  }

  public boolean equals(Object obj){
    if (super.equals(obj))return true;
    if (obj instanceof ExpressionCubeFilter && ((ExpressionCubeFilter)obj).expresion!=null){
      return expresion.equals(((ExpressionCubeFilter)obj).expresion);
    }
    return false;
  }


}
