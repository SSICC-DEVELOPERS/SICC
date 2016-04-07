package com.calipso.reportgenerator.reportcalculator.expression;

/**
 * Clase base para todos los objetos que se utilicen para utilizar el pattern visitor sobre expresiones
 * Contiene los métodos para procesar todos los tipos de expresiones
 */

public class ExpressionVisitor {

  public Object processAnd(AndExp expression) {
    return null;
  }

  public Object processConstant(Expression expression) {
    return null;
  }

  public Object processEqualTo(EqualTo expression) {
    return null;
  }

  public Object processGreaterOrEqualTo(GreaterOrEqualTo expression) {
    return null;
  }

  public Object processGreaterThan(GreaterThan expression) {
    return null;
  }

  public Object processLessOrEqualTo(LessOrEqualTo expression) {
    return null;
  }

  public Object processLessThan(LessThan expression) {
    return null;
  }

  public Object processNot(NotExp expression) {
    return null;
  }

  public Object processOr(OrExp expression) {
    return null;
  }

  public Object processVariable(VariableExp expression) {
    return null;
  }

  public Object visit(Expression expression) {
    return expression.visitedBy(this);
  }

  public Object processIncludes(IncludesExp expression) {
    return null;
  }

  public Object processBeginsWith(BeginsWithExp expression) {
    return null;
  }

  public Object processEndsWith(EndsWithExp expression) {
    return null;
  }

  public Object processIn(InExp inExp) {
    return null;
  }
}
