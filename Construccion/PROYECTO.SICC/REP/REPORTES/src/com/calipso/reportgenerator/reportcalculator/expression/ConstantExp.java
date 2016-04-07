package com.calipso.reportgenerator.reportcalculator.expression;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

/**
 * Representa una expresión con un valor constante
 */
public class ConstantExp extends Expression implements Serializable {


  public ConstantExp() {
  }

  Object value;

  /**
   * Crea una expresión constante a partir de un valor
   * @param value
   */
  public ConstantExp(Object value) {
    this.value = value;
  }

  /**
   * Crea una expresión constante correspondiente al valor que se recibe como parámetro
   * @param aValue
   * @return
   */
  public static ConstantExp forValue(Object aValue) {
    if (aValue instanceof Boolean) {
      if (((Boolean) aValue).booleanValue()) {
        return new TrueExp();
      }
      else {
        return new FalseExp();
      }
    }
    return new ConstantExp(aValue);
  }

  /**
   * Crea una expresión con la forma this AND expression
   * @param expression
   * @return
   */
  public Expression newAnd(Expression expression) {
    return basicAnd(expression);
  }

  /**
   * Crea una expresión con la forma this OR expression
   * @param expression
   * @return
   */
  public Expression newOr(Expression expression) {
    return basicOr(expression);
  }

  /**
   * Resuelve la representación en texto de la expresión
   * @return
   */
  protected String basicAsString() {
    if(value==null){
      return null;
    }
    return value.toString();
  }

  /**
   * Devuelve verdadero porque representa un valor constante
   * @return
   */
  public boolean isConstant() {
    return true;
  }

  /**
   * Devuelve el valor representado por la expresión
   * @return
   */
  public Object getValue() {
    return value;
  }

  /**
   * Devuelve un Set vacío porque una expresión constante no tiene subexpresiones ni variables
   * @return
   */
  protected Set variables() {
    return new HashSet();
  }


  /**
   * Resolución del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processConstant(this);
  }
}
