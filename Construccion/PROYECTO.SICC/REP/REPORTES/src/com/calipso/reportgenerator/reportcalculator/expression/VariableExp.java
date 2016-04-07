package com.calipso.reportgenerator.reportcalculator.expression;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

/**
 * Representa una expresi�n variable cuyo valor se obtiene del contexto durante la evaluaci�n
 */
public class VariableExp extends Expression implements Serializable {
  Object reference;


  /**
   * Inicializa una Expresi�n variable con una referencia
   * La referencia se utiliza para buscar un valor asociado en el contexto
   * durante la evaluaci�n
   * @param aReference
   */
  public VariableExp(Object aReference) {
    reference = aReference;
  }

  /**
   * Resuelve la igualdad entre expresiones variables
   * @param o
   * @return
   */
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VariableExp)) return false;

    final VariableExp variableExp = (VariableExp) o;

    if (!reference.equals(variableExp.reference)) return false;

    return true;
  }

  /**
   * Genera el c�digo hash para la expresi�n
   * @return
   */
  public int hashCode() {
    return reference.hashCode();
  }

  /**
   * Devuelve la referencia
   * @return
   */
  public Object getReference() {
    return reference;
  }

  /**
   * Asigna la referencia
   * @param reference
   */
  public void setReference(Object reference) {
    this.reference = reference;
  }

  /**
   * Retorna la lista de variables de la expresi�n, en este caso la lista contiene solo a la expresi�n variable
   * @return
   */

  protected Set variables() {
    Set variables;

    variables = new HashSet();
    variables.add(this);
    return variables;
  }

  /**
   * Resuelve la representaci�n en texto
   * @return
   */

  protected String basicAsString() {
    return reference.toString();
  }

  /**
   * Devuelve TRUE porque es una expresi�n variable
   * @return
   */
  public boolean isVariable() {
    return true;
  }

  /**
   * Resoluci�n del pattern visitor
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return visitor.processVariable(this);
  }

}
