package com.calipso.reportgenerator.reportcalculator.expression;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 06/07/2004
 * Time: 16:29:50
 * To change this template use Options | File Templates.
 */
public class InExp extends BinaryExp{
  private Collection values;

  public InExp(VariableExp expression, Collection values) {
    initialize();
    setVariable(expression);
    this.values = values;
  }

  private void setVariable(VariableExp expression) {
    this.arguments[0] = expression;
  }

  protected void initialize(){
    arguments = new Expression[1];
  }

  public String basicAsString(){
    String result = "";
    if(!values.isEmpty()){
      result += arguments[0].basicAsString() + " IN (";
      Iterator iterator = values.iterator();
      result += iterator.next().toString();
      while(iterator.hasNext()){
        result += ", " + iterator.next().toString();
      }
      result += ")";
    }
    return result;
  }

  public Object visitedBy(ExpressionVisitor visitor){
    return visitor.processIn(this);
  }

  public Expression getArgument(){
    return arguments[0];
  }

  public Collection getValues() {
    return values;
  }
}
