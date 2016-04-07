package com.calipso.reportgenerator.reportcalculator.expression;

import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportcalculator.SharedDate;

import java.util.Comparator;
import java.util.Collection;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

/**
 * Visitor para obtener una expresión simplificada en base
 * a un valuación dada en un Context
 * Una expresión simplificada se obtiene reemplazando las variables por los valores que se obtienen del contexto y
 * aplicando la operación correspondiente. Si el contexto contiene valores para todas las variables se puede llegar
 * a un resultado (true/false), sino, solo pueden reemplazarse por un valor constante algunas sub expresiones y la
 * expresión general se reduce, igualmente, evaluando una expresión con un contexto incompleto da como resultado false.
 */

public class ExpressionSimplifier extends ExpressionVisitor {
  private Context context;
  private static Map comparators;


  public static Map getComparators(){
    if (comparators == null){
      comparators = new HashMap();
      fillComparators(comparators);
    }
    return comparators;
  }

  private static void fillComparators(Map comparators){
    comparators.put(String.class, new StringComparator());
    comparators.put(SharedFloat.class, new FloatComparator());
//    comparators.put(CubeFloat.class, new CubeFloatComparator());
    comparators.put(Date.class, new DateComparator());
    comparators.put(SharedString.class, new SharedStringComparator());
    comparators.put(SharedDate.class, new SharedDateComparator());
    comparators.put(SharedInteger.class, new SharedIntegerComparator());
  }

  /**
   * Resuelve el operador AND simplificando las subexpresiones
   * @param expression
   * @return
   */
  public Object processAnd(AndExp expression) {
    return ((Expression) visit(expression.getLeft())).newAnd((Expression) visit(expression.getRight()));
  }


  /**
   * Las expresiones constantes no necesitan simplificarse
   * @param expression
   * @return
   */
  public Object processConstant(Expression expression) {
    return expression;
  }

  /**
   * Resuelve si los valores de las expresiones simplificadas son iguales
   * @param expression
   * @return
   */
  public Object processEqualTo(EqualTo expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      //value = ((ConstantExp) simpleLeft).value.equals(((ConstantExp) simpleRight).value);
      value = compare(((ConstantExp) simpleLeft).value, ((ConstantExp) simpleRight).value) == 0;
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newEqualTo(simpleRight);
    }
    return result;
  }

  private int compare(Object value1, Object value2){
    Comparator comparator = getComparator(value1.getClass());
    return comparator.compare(value1, value2);
  }

  private Comparator getComparator(Class aClass) {
    return (Comparator) getComparators().get(aClass);
  }


  /**
   * Resuelve si el valor de una expresión simplificada es Mayor o Igual que el valor simplificado de la otra
   * @param expression
   * @return
   */
  public Object processGreaterOrEqualTo(GreaterOrEqualTo expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      int comparisson = compare(((ConstantExp) simpleLeft).value, ((ConstantExp) simpleRight).value);
      //int comparisson = ((ConstantExp) simpleLeft).value.toString().compareTo(((ConstantExp) simpleRight).value.toString());
      value = comparisson >= 0;
      //value = true; //((ConstantExp) simpleLeft).value >= ((ConstantExp) simpleRight).value;
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newGreaterOrEqualTo(simpleRight);
    }
    return result;
  }

  /**
   * Resuelve si el valor de una expresión simplificada es Mayor que el valor simplificado de la otra
   * @param expression
   * @return
   */

  public Object processGreaterThan(GreaterThan expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      int comparisson = compare(((ConstantExp) simpleLeft).value, ((ConstantExp) simpleRight).value);
      //int comparisson = ((ConstantExp) simpleLeft).value.toString().compareTo(((ConstantExp) simpleRight).value.toString());
      value = comparisson > 0;

      //value = true; //((ConstantExp) simpleLeft).value > ((ConstantExp) simpleRight).value;
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newGreaterThan(simpleRight);
    }
    return result;
  }


  /**
   * Resuelve si el valor de una expresión simplificada es Menor o Igual que el valor simplificado de la otra
   * @param expression
   * @return
   */
  public Object processLessOrEqualTo(LessOrEqualTo expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      //int comparisson = ((ConstantExp) simpleLeft).value.toString().compareTo(((ConstantExp) simpleRight).value.toString());
      int comparisson = compare(((ConstantExp) simpleLeft).value, ((ConstantExp) simpleRight).value);
      value = comparisson <= 0;
      //value = true; //((ConstantExp) simpleLeft).value < ((ConstantExp) simpleRight).value;
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newLessOrEquealTo(simpleRight);
    }
    return result;
  }

  /**
   * Resuelve si el valor de una expresión simplificada es Menor que el valor simplificado de la otra
   * @param expression
   * @return
   */
  public Object processLessThan(LessThan expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      //int comparisson = ((ConstantExp) simpleLeft).value.toString().compareTo(((ConstantExp) simpleRight).value.toString());
      int comparisson = compare(((ConstantExp) simpleLeft).value, ((ConstantExp) simpleRight).value);
      value = comparisson < 0;
      //value = true; //((ConstantExp) simpleLeft).value <= ((ConstantExp) simpleRight).value;
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newLessThan(simpleRight);
    }
    return result;
  }


  /**
   * Resuelve el operador NOT sobre el valor resultante de simplificar la subexpresión
   * @param expression
   * @return
   */
  public Object processNot(NotExp expression) {
    return ((Expression) visit(expression.internalExp())).newNot();
  }


  /**
   * Resuelve el operador OR simplificando las subexpresiones
   * @param expression
   * @return
   */
  public Object processOr(OrExp expression) {
    return ((Expression) visit(expression.getLeft())).newOr((Expression) visit(expression.getRight()));
  }


  /**
   * Si el valor de referencia de la expresión variable se encuentra en el contexto, reemplaza esta expresión
   * por una expresión constante con el valor correspondiente
   * @param expression
   * @return
   */
  public Object processVariable(VariableExp expression) {
    Object value;

    value = context.valueFor(expression.reference);
    if (value == null) {
      return expression;
    }
    return ConstantExp.forValue(value);
  }


  /**
   * Resuelve el operador Includes simplificando las subexpresiones
   * @param expression
   * @return
   */
  public Object processIncludes(IncludesExp expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;
    String string;
    String regExp;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      regExp = (String) ((ConstantExp) simpleRight).value;
      string = (String) ((ConstantExp) simpleLeft).value;
      value = string.indexOf(regExp) != -1;
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newIncludes(simpleRight);
    }
    return result;
  }


  /**
   * Resuelve el operador beginsWith simplificando las subexpresiones
   * @param expression
   * @return
   */
  public Object processBeginsWith(BeginsWithExp expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;
    String string;
    String prefix;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      prefix = (String) ((ConstantExp) simpleRight).value;
      string = (String) ((ConstantExp) simpleLeft).value;
      value = string.startsWith(prefix);
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newBeginsWith(simpleRight);
    }
    return result;
  }

  /**
   * Resuelve el operador endsWith simplificando las subexpresiones*
   * @param expression
   * @return
   */
  public Object processEndsWith(EndsWithExp expression) {
    Expression simpleLeft;
    Expression simpleRight;
    boolean value;
    Expression result;
    String string;
    String suffix;

    simpleLeft = (Expression) visit(expression.getLeft());
    simpleRight = (Expression) visit(expression.getRight());

    if (simpleLeft.isConstant() && simpleRight.isConstant()) {
      suffix = (String) ((ConstantExp) simpleRight).value;
      string = (String) ((ConstantExp) simpleLeft).value;
      value = string.endsWith(suffix);
      result = ConstantExp.forValue(new Boolean(value));
    }
    else {
      result = simpleLeft.newEndsWith(simpleRight);
    }
    return result;
  }

  /**
   * Método por el que se inicia la simplificación de la "super" expresión en base a un contexto
   * @param expression
   * @param aContext
   * @return
   */
  public Object simplifyIn(Expression expression, Context aContext) {
    context = aContext;
    return visit(expression);
  }

  /**
   * Resuelve el operador In evaluando sus valores
   * @param inExp
   * @return
   */
  public Object processIn(InExp inExp){
    Collection values = inExp.getValues();
    if(values == null || values.isEmpty()){
      return new TrueExp();
    }
    Expression simple = (Expression) visit(inExp.getArgument());
    if(simple.isConstant()){
      return ConstantExp.forValue(new Boolean(inExp.getValues().contains(((ConstantExp)simple).getValue())));
    }
    return inExp;
  }

}