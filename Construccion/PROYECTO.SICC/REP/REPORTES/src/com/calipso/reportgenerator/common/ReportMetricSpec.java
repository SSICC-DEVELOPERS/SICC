package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.ExternalFunctionResolver;
import com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.MetricDefinition;
import com.calipso.reportgenerator.reportdefinitions.types.CalculationType;
import com.calipso.reportgenerator.reportcalculator.arithmetic.ArithmeticExpression;
import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportFieldSpec;
import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;

import java.util.Set;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.math.BigDecimal;

/**
 */
public class ReportMetricSpec extends ReportFieldSpec {

  private boolean visible;
  private CalculationType aggregateType;
  private String aggregateFunction;
  private String groupFooterFunction;
  private CalculationType groupFooterType;
  private ArithmeticExpression arithmeticExpression;
  private Map variableIndexes;
  private boolean accumulable;
  private boolean externalCalculated;

  /**
   * Constructor de la super clase
   * @param name
   */
  public ReportMetricSpec(String name) {
    super(name);
  }


  /**
   * Inicializa los valores de los atributos a partir de un MeticSourceDefinition
   * @param metricSourceDefinition
   * @param isMultilanguaje
   * @param localization
   */
  public void fillFrom(MetricSourceDefinition metricSourceDefinition, boolean isMultilanguaje, Map localization) {
    setCaption(resolveCaption(isMultilanguaje, localization, metricSourceDefinition.getDescription()));
    setCalculated(metricSourceDefinition.getCalculated());
    setExternalData(metricSourceDefinition.getExternalData());
    setAggregateFunction(metricSourceDefinition.getAggregateFunction());
    setAggregateType(metricSourceDefinition.getAggregateType());
    setGroupFooterFunction(metricSourceDefinition.getGroupFooterFunction());
    setGroupFooterType(metricSourceDefinition.getGroupFooterType());
    setExternalCalculated(metricSourceDefinition.getExternalCalculated());
    setInReportDefinition(true);
  }

  /**
   * Inicializa los valores de los atributos a partir de un MetricDefinition
   * @param metricDefinition
   * @param isMultilanguaje
   * @param localization
   */
  public void fillFrom(MetricDefinition metricDefinition, boolean isMultilanguaje, Map localization) {
    if (metricDefinition.getDescription() != null && !("").equals(metricDefinition.getDescription())) {
      setCaption(resolveCaption(isMultilanguaje, localization, metricDefinition.getDescription()));
    }
    setVisible(metricDefinition.getVisible());
    setAccumulable(metricDefinition.getAccumulable());
  }
  /**
   * Devuelve verdadero si debe existir una métrica de valores acumulados segun los valores de esta métrica
   * Se utiliza en los reportes del tipo acumulado.
   * @return
   */
  public boolean getAccumulable() {
    return accumulable;
  }

  /**
   * Especificaverdadero si debe existir una métrica de valores acumulados segun los valores de esta métrica
   * @param accumulable
   */
  public void setAccumulable(boolean accumulable) {
    this.accumulable = accumulable;
  }

  /**
   * Devuelve verdadero si esta métrica debe aparecer visible en la consulta por defecto
   * @return
   */
  public boolean getVisible() {
    return visible;
  }

  /**
   * Especifica si esta métrica debe aparecer visible en la consulta por defecto
   * @param visible
   */
  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  /**
   * Devuelve la función de agregación (por defecto sumatoria)
   * @return
   */
  public String getAggregateFunction() {
    return aggregateFunction;
  }

  /**
   * Asigna la función con la que se calculan los valores de las métricas calculadas
    * @param aggregateFunction
   */
  public void setAggregateFunction(String aggregateFunction) {
    this.aggregateFunction = aggregateFunction;
  }


  /**
   *
   * @return
   */
  public CalculationType getAggregateType() {
    return aggregateType;
  }

  public void setAggregateType(CalculationType aggregateType) {
    this.aggregateType = aggregateType;
  }

  public String getGroupFooterFunction() {
    return groupFooterFunction;
  }

  public void setGroupFooterFunction(String groupFooterFunction) {
    this.groupFooterFunction = groupFooterFunction;
  }

  public CalculationType getGroupFooterType() {
    return groupFooterType;
  }

  public void setGroupFooterType(CalculationType groupFooterType) {
    this.groupFooterType = groupFooterType;
  }

  /**
   * Devuelve verdadero si el valor de esta métrica debe ser calculado por proveedor externo del IRDataSource
   * @return
   */
  public boolean getExternalCalculated() {
    return externalCalculated;
  }

  /**
   * Especifica si el valor de esta métrica debe ser calculado por proveedor externo del IRDataSource
   * @param externalCalculated
   */
  private void setExternalCalculated(boolean externalCalculated) {
    this.externalCalculated = externalCalculated;
  }

  /**
   * Devuelve la expresión aritmética en base a la que se deben calcular los valores de la métrica calculada
   * @return
   */
  protected ArithmeticExpression getExpression() {
    if (arithmeticExpression == null) {
      arithmeticExpression = ArithmeticExpression.newFrom(getAggregateFunction());
      variableIndexes = variableIndexesFrom(arithmeticExpression);
    }
    return arithmeticExpression;
  }

  /**
   * Contiene los indices de la/las métricas que intercienen en la expresión de cálculo
   * @return
   */
  protected Map getVariableIndexes() {
    return variableIndexes;
  }

  /**
   * Resulve los indices de la/las métricas que intercienen en la expresión de cálculo
   * @param arithmeticExpression
   * @return
   */
  private Map variableIndexesFrom(ArithmeticExpression arithmeticExpression) {
    Collection variables = new ArrayList();
    arithmeticExpression.getVariables(variables);
    Iterator iterator = variables.iterator();
    Map indexes = new HashMap();
    while (iterator.hasNext()) {
      String variable = (String) iterator.next();
      indexes.put(variable, new Integer(getDataSourceIndexFromName(variable)));
    }
    return indexes;
  }

  /**
   * Resuelve el valor de la métrica directamente del IRDataSource en las métricas comunes y aplicando la expresion de cálculo
   * en las métricas calculadas
   * @param dataSource
   * @param index
   * @return
   */
  public Object getValue(Map paramValues, IRDataSource dataSource, int index) throws Exception {
    if (getCalculated()) {
      if(getAggregateFunction().startsWith(externalFunctionConstant)){
        return ExternalFunctionResolver.getInstance().resolveValue(paramValues, getAggregateFunction() ,dataSource.getRowValues(index));
      }else{
        return new Float(getExpression().value(getContext(dataSource.getRowValues(index))));
      }
    }
    else {
      return floatFrom(dataSource.getValueAt(index, getDataSourceIndex()));
    }
  }
  
  /**
   * Devuelve el contexto con el que se evalúa la expresión del cálculo con los valores de un Row del IRDataSource
   * @param rowValues
   * @return
   */
  private Map getContext(Collection rowValues) throws InfoException {
    Map context = new HashMap();
    fillContext(rowValues, context);
    return context;
  }

  /**
   * Llena el contexto con el que se evalúa la expresión del cálculo con los valores de un Row del IRDataSource
   * @param rowValues
   * @param context
   */
  private void fillContext(Collection rowValues, Map context) throws InfoException {
    Set entries = getVariableIndexes().entrySet();
    Iterator iterator = entries.iterator();
    Object[] values = rowValues.toArray();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      context.put(entry.getKey(), floatFrom(values[((Integer) entry.getValue()).intValue()]));
    }
  }

  /**
   * devuelve un valor Float a partir del objeto obtenido del IRDataSource
   * @param value
   * @return
   */
  private Object floatFrom(Object value) throws InfoException {
    if(value instanceof Float){
      return (Float) value;
    }else if (value instanceof SharedFloat){
      return new Float(((SharedFloat)value).floatValue());
    } else  if ((value instanceof String)||(value instanceof SharedString)){
      String strValue = value.toString();
      if (strValue.equalsIgnoreCase("")){
        strValue = "0";
      }
      return Float.valueOf(strValue.trim());
    } else  if(value instanceof Integer) {
      return new Float(value.toString());
    } else if(value instanceof Long) {
      return new Float(value.toString());
    } else if(value instanceof BigDecimal) {
      return new Float(((BigDecimal)value).floatValue());
    } else if(value instanceof Double) {
      return new Float(((Double)value).floatValue());
    }else if(value instanceof java.sql.Date) {
      return new Float((value).toString());
    }
    throw new InfoException(LanguageTraslator.traslate("279"));
  }
}
