package com.calipso.reportgenerator.reportcalculator.expression;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.io.Serializable;

/**
 * Representa una expresión booleana.
 * Cachea las variables que integra y tiene constructores
 * especiales para cada una de sus subclases
 */

public class Expression implements Serializable {
  Expression[] arguments;
  Set referencesCache;

  protected void initialize() {
  }

  /**
   * Resuelve la igualdad entre expresiones
   * @param o
   * @return
   */
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Expression)) return false;

    final Expression expression = (Expression) o;

    if (referencesCache != null ? !referencesCache.equals(expression.referencesCache) : expression.referencesCache != null) return false;

    return true;
  }

  /**
   * Genera un código hash para la expresión
   * @return
   */
  public int hashCode() {
    return (referencesCache != null ? referencesCache.hashCode() : 0);
  }

  /**
   * Devuelve los argumentos de la expresión
   * @return
   */
  public Expression[] getArguments() {
    return arguments;
  }

  /**
   * Especifica los argumentos de la expresión e invalida el cache de referencias
   * @param arguments
   */
  public void setArguments(Expression[] arguments) {
    invalidateCache();
    this.arguments = arguments;
  }

  /**
   * Invalida el cache de referencias
   */
  private void invalidateCache() {
    referencesCache = null;
  }

  /**
   * Llena el cache de referencias con las variables de todas las subexpresiones
   * Devuelve un Set con Expresiones de tipo Variable para todas las variables de las
   * sub expresiones
   * @see VariableExp
   * @return
   */
  public Set references() {
    Iterator iterator;

    if (referencesCache == null) {
      referencesCache = new HashSet();
      iterator = variables().iterator();
      while (iterator.hasNext()) {
        referencesCache.add(((VariableExp) iterator.next()).getReference());
      }
    }
    return referencesCache;
  }

  /**
   * Devuelve las expresiones tipo Variable de todas las subexpresiones
   * @return
   */
  protected Set variables() {
    Set variablesCache;

    variablesCache = new HashSet();
    for (int i = 0; i < arguments.length; i++) {
      variablesCache.addAll(arguments[i].variables());
    }
    return variablesCache;
  }

  /**
   * Asigna un Set que contiene las referencias
   * @param referencesCache
   */
  public void setReferencesCache(Set referencesCache) {
    this.referencesCache = referencesCache;
  }

  /**
   * Crea una nueva expresión con la siguiente forma: this AND expresion
   * @param expression
   * @return
   */

  public Expression newAnd(Expression expression) {
    return expression.basicAnd(this);
  }

  /**
   * Crea una nueva expresión con la siguiente forma: this OR expression
   * @param expression
   * @return
   */
  public Expression newOr(Expression expression) {
    return expression.basicOr(this);
  }


  /**
   * * Crea una expresión con la siguiente forma: this < expression
   * @param expression
   * @return
   */

  public Expression newLessThan(Expression expression) {
    return new LessThan(this, expression);
  }


  /**
   * Crea una expresión con la siguiente forma: this <= expression
   * @param expression
   * @return
   */
  public Expression newLessOrEquealTo(Expression expression) {
    return new LessOrEqualTo(this, expression);
  }


  /**
   * Crea una expresión con la siguiente forma: this = expression
   * @param expression
   * @return
   */
  public Expression newEqualTo(Expression expression) {
    return new EqualTo(this, expression);
  }

  /**
   * Crea una expresión con la siguiente forma: this > expression
   * @param expression
   * @return
   */

  public Expression newGreaterThan(Expression expression) {
    return new GreaterThan(this, expression);
  }

  /**
   * Crea una expresión con la siguiente forma: this >= expression
   * @param expression
   * @return
   */

  public Expression newGreaterOrEqualTo(Expression expression) {
    return new GreaterOrEqualTo(this, expression);
  }


  /**
   * Crea una nueva expresión negando la que se recibe como parámetro: NOT expresion
   * @return
   */
  public Expression newNot() {
    return new NotExp(this);
  }

  /**
   * Crea una nueva expresión con la siguiente forma: this COMIENZA_CON expression
   * se utiliza para valores String
   * @param expression
   * @return
   */
  public Expression newBeginsWith(Expression expression) {
    return new BeginsWithExp(this, expression);
  }

  /**
   * Crea una expresión con la siguiente forma: this TERMINA_CON expression
   * se utiliza para valores String
   * @param expression
   * @return
   */
  public Expression newEndsWith(Expression expression) {
    return new EndsWithExp(this, expression);
  }

  /**
   * Crea una expresión con la siguiente forma: this INCLUYE expression
   * se utiliza para valores String
   * @param expression
   * @return
   */
  public Expression newIncludes(Expression expression) {
    return new IncludesExp(this, expression);
  }

  /**
   * Resuelve la creación de la expresión AND
   * @param expression
   * @return
   */
  protected Expression basicAnd(Expression expression) {
    return new AndExp(expression, this);
  }


  /**
   * Resuelve la creación de la expresión OR
   * @param expression
   * @return
   */
  protected Expression basicOr(Expression expression) {
    return new OrExp(expression, this);
  }


  /**
   * Devuelve un texto que representa a la expresión (y todas sus subexpresiones)
   * @return
   */
  public String toString() {
    return basicAsString();
  }

  /**
   * Se utiliza para resolver las particularidades de la expresión AND en la representación de texto
   * como ser, agregar paréntesis, etc
   * @return
   */
  protected String asStringUnderAnd() {
    return basicAsString();
  }

  /**
   * Se utiliza para resolver las particularidades de la expresión OR en la representación de texto
   * como ser, agregar parentesis, etc
   */
  protected String asStringUnderOr() {
    return basicAsString();
  }

  /**
   * Se utiliza para resolver las particularidades de la expresión NOT en la representación de texto
   * como ser, agregar paréntesis, etc
   */
  protected String asStringUnderNot() {
    return basicAsString();
  }

  /**
   * Método que sobreescriben las subclases para resolver la representación en texto
   * @return
   */

  protected String basicAsString() {
    return "";
  }


  /**
   * Método necesario para la implementación del pattern Visitor que se utiliza para la simplificación de las expresiones
   * @see ExpressionSimplifier
   * @param visitor
   * @return
   */
  public Object visitedBy(ExpressionVisitor visitor) {
    return null;
  }


  /**
   * Determina si la expresión es una constante (la expresión fue simplificada y se obtuvo un valor concreto)
   * @return
   */
  public boolean isConstant() {
    return false;
  }

  /**
   * Determina si la expresión es una constante con valor FALSE
   * @return
   */
  public boolean isFalse() {
    return false;
  }

  /**
   * Determina si la expresión es una Magnitud que puede utilizarse en expresiones del tipo LessThan, GreaterThan, etc
   * @return
   */
  public boolean isMagnitude() {
    return false;
  }

  /**
   * Determina si la expresión es una constante con valor TRUE
   * @return
   */
  public boolean isTrue() {
    return false;
  }

  /**
   * Determina si la expresión representa una variable (que será reemplazada por un valor cuando se evalue en un contexto)
   * @return
   */
  public boolean isVariable() {
    return false;
  }

  /**
   * Devuelve una expresión simplificada reemplazando las Variables con los valores correspondientes que se reciben
   * del contexto
   * @param context
   * @return
   */
  public Expression simplifiedIn(Context context) {
    return (Expression) ((new ExpressionSimplifier()).simplifyIn(this, context));
  }

  /**
   * Devuelve un valor boolean como resultado de la evaluación de la expresión con los valores del contexto
   * Si el contexto no contiene valores para todas las variables y no se puede completar la simplificación
   * el resultado es FALSE
   * @param context
   * @return
   */
  public boolean valueIn(Context context) {
    return simplifiedIn(context).isTrue();
  }
}