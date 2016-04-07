package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Represemta una expresi�n binaria conformado por dos expresiones
 * a las que se le aplica un operador (and, or, <, etc)
 */

public class BinaryExp extends Expression implements Serializable {

  public BinaryExp() {
    initialize();
  }

  /**
   * Crea una expresi�n binaria cuyos argumentos son dos expresiones
   * @param left
   * @param right
   */
  public BinaryExp(Expression left, Expression right) {
    initialize();
    setLeft(left);
    setRight(right);
  }

  /**
   * Inicializa el Array de argumentos de tama�o 2, uno para cada sub expresi�n
   */
  protected void initialize() {
    arguments = new Expression[2];
  }

  /**
   * Devuelve la parte izquerda de la expresi�n binaria
   * @return
   */
  public Expression getLeft() {
    return arguments[0];
  }

  /**
   * Asigna la parte izquierda de la expresi�n binaria
   * @param left
   */
  public void setLeft(Expression left) {
    arguments[0] = left;
  }

  /**
   * Devuelve la parte derecha de la expresi�n binaria
   * @return
   */
  public Expression getRight() {
    return arguments[1];
  }


  /**
   * Asigna la parte derecha de la expresi�n binaria
   * @param right
   */
  public void setRight(Expression right) {
    arguments[1] = right;
  }

  /**
   * Resuelve las particularidades de la representaci�n en texto con el operador AND
   * @return
   */
  protected String asStringUnderAnd() {
    return "(" + basicAsString() + ")";
  }

  /**
   * Resuelve las particularidades de la representaci�n en texto con el operador OR
   * @return
   */
  protected String asStringUnderOr() {
    return "(" + basicAsString() + ")";
  }

  /**
   * Resuelve las particularidades de la representaci�n en texto con el operador NOT
   * @return
   */
  protected String asStringUnderNot() {
    return "(" + basicAsString() + ")";
  }

}
