package com.calipso.reportgenerator.reportcalculator.arithmetic;

import java.util.Map;
import java.util.Collection;
import java.io.Serializable;

/**
 * Resuelve expressiones aritmeticas
 */

public abstract class ArithmeticExpression implements Serializable{

  /**
   * Retorna el resultado para la expresion que recibe
   * por parametro.
   * @param expression
   * @return
   */
  public static ArithmeticExpression newFrom(String expression) {
    String exp = prepareExpression(expression);
    Object[] tokens = getTokens(exp);
    if (tokens.length == 1) {
      return ValueArithmeticExp.newValueExpFrom(tokens[0].toString());
    } else {
      ArithmeticExpression subExp1 = ArithmeticExpression.newFrom(tokens[0].toString());
      ArithmeticExpression subExp2 = ArithmeticExpression.newFrom(tokens[2].toString());
      return OperationArithmeticExp.newOperationFrom(subExp1, tokens[1].toString(), subExp2);
    }
  }

  /**
   * Prepara una expression previamente a ser resuelta.
   * @param expression
   * @return
   */
  private static String prepareExpression(String expression) {
    String exp = expression.trim();
    if (exp.charAt(0) == '(' && exp.charAt(exp.length() - 1) == ')') {
      return exp.substring(1, exp.length() - 1);
    }
    return exp;
  }

  /**
   * Devuelve el indice del operador primario de la expresion
   * @param expression
   * @return
   */
  private static int indexOfOperator(String expression) {
    int index = -1;
    int alternateIndex = -1;
    int parenthesis = 0;
    for (int i = 0; i < expression.length(); i++) {
      char current = expression.charAt(i);
      if (current == '(') {
        parenthesis++;
      } else {
        if (current == ')') {
          parenthesis--;
        } else {
          if (parenthesis == 0) {
            if (current == '+' || current == '-') {
              index = i;
              break;
            } else {
              if (current == '*' || current == '/') {
                alternateIndex = i;
              }
            }
          }
        }
      }
    }
    if (index == -1) {
      index = alternateIndex;
    }
    return index;
  }

  /**
   * En base al indice del operador primario parte en dos
   * la expresion, ubica cada porcion en un array de 3 posiciones
   * siendo la posicion del medio la que contiene el operador
   * primario y retorna dicho array.
   * @param expression
   * @return
   */
  private static Object[] getTokens(String expression) {
    int index = indexOfOperator(expression);
    if (index == -1) {
      return new Object[]{expression};
    } else {
      Object[] array = new Object[3];
      array[0] = expression.substring(0, index);
      array[1] = expression.substring(index, index +1);
      array[2] = expression.substring(index + 1);
      return array;
    }
  }

  public abstract float value(Map context);

  public void getVariables(Collection variables) {
    //Do nothing
  }
}