package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Represemta una expresión binaria conformado por dos expresiones
 * a las que se le aplica un operador (and, or, <, etc)
 */

public class BinaryExp extends Expression implements Serializable {

  public BinaryExp() {
    initialize();
  }

  /**
   * Crea una expresión binaria cuyos argumentos son dos expresiones
   * @param left
   * @param right
   */
  public BinaryExp(Expression left, Expression right) {
    initialize();
    setLeft(left);
    setRight(right);
  }

  /**
   * Inicializa el Array de argumentos de tamaño 2, uno para cada sub expresión
   */
  protected void initialize() {
    arguments = new Expression[2];
  }

  /**
   * Devuelve la parte izquerda de la expresión binaria
   * @return
   */
  public Expression getLeft() {
    return arguments[0];
  }

  /**
   * Asigna la parte izquierda de la expresión binaria
   * @param left
   */
  public void setLeft(Expression left) {
    arguments[0] = left;
  }

  /**
   * Devuelve la parte derecha de la expresión binaria
   * @return
   */
  public Expression getRight() {
    return arguments[1];
  }


  /**
   * Asigna la parte derecha de la expresión binaria
   * @param right
   */
  public void setRight(Expression right) {
    arguments[1] = right;
  }

  /**
   * Resuelve las particularidades de la representación en texto con el operador AND
   * @return
   */
  protected String asStringUnderAnd() {
    return "(" + basicAsString() + ")";
  }

  /**
   * Resuelve las particularidades de la representación en texto con el operador OR
   * @return
   */
  protected String asStringUnderOr() {
    return "(" + basicAsString() + ")";
  }

  /**
   * Resuelve las particularidades de la representación en texto con el operador NOT
   * @return
   */
  protected String asStringUnderNot() {
    return "(" + basicAsString() + ")";
  }

}
