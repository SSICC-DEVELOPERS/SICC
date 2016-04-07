package com.calipso.reportgenerator.reportcalculator.arithmetic;

import com.calipso.reportgenerator.reportcalculator.arithmetic.ArithmeticExpression;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.io.Serializable;

/**
 * Genera las operaciones
 */

public class OperationArithmeticExp extends ArithmeticExpression implements Serializable {
   private ArithmeticExpression m1;
   private ArithmeticExpression m2;
   private String operator;
   private static Map operations;

  /**
   * Crea un Map y lo inicializa con todos los resultados
   * posibles en base a las operaciones soportadas.
   * @param operator
   * @return
   */
  private Operation fromOperator(String operator) {
      if (operations == null){
        operations = new HashMap();
        operations.put("+", new Addition());
        operations.put("-", new Substraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Divission());
      }
      return (Operation) operations.get(operator);
   }

    /**
     * Retorna el resultado a partir de un Map.
     * @param context
     * @return
     */
    public float value(Map context) {
        return fromOperator(operator).calculate(m1.value(context), m2.value(context));
    }

    /**
     * Metodo toString de la clase
     * @return
     */
    public String toString() {
      String str =  m1.toString() + " " + operator + " " + m2.toString();
      if (operator.equals("+") || operator.equals("-")) {
        return "(" + str + ")";
      }
      return str;
    }

    /**
     * Genera una nueva instancia de <code>OperationArithmeticExp</code>
     * en base a dos valores y su operador.
     * @param subExp1
     * @param operator
     * @param subExp2
     * @return
     */
    public static ArithmeticExpression newOperationFrom(ArithmeticExpression subExp1, String operator, ArithmeticExpression subExp2) {
        return new OperationArithmeticExp(subExp1, operator, subExp2);
    }

    /**
     * Inicializa una instancia de <code>OperationArithmeticExp</code>
     * @param subExp1
     * @param operator
     * @param subExp2
     */
    public OperationArithmeticExp(ArithmeticExpression subExp1, String operator, ArithmeticExpression subExp2) {
        this.m1 = subExp1;
        this.m2 = subExp2;
        this.operator = operator;
    }

    /**
     * Inner class que calcula para dos valores
     * todas las operaciones soportadas
     */
    private abstract class Operation {
      public abstract float calculate(float value1, float value2);
    }

    /**
     * Inner class que calcula la suma para dos valores
     */
    private class Addition extends Operation {
        public float calculate(float value1, float value2){
            return value1 + value2;
        }
    }

    /**
     * Inner class que calcula la resta para dos valores
     */
    private class Substraction extends Operation {
        public float calculate(float value1, float value2){
            return value1 - value2;
        }
    }

    /**
     * Inner class que calcula la multiplicacion para dos valores
     */
    private class Multiplication extends Operation {
        public float calculate(float value1, float value2){
            return value1 * value2;
        }
    }

    /**
     * Inner class que calcula la division para dos valores
     */
    private class Divission extends Operation {
        public float calculate(float value1, float value2){
            return value1 / value2;
        }
    }

  public void getVariables(Collection variables) {
    m1.getVariables(variables);
    m2.getVariables(variables);
  }

}