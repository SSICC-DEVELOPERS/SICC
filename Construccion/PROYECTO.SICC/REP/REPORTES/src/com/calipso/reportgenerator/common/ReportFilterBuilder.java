package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.ExpressionCubeFilter;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.expression.Expression;
import com.calipso.reportgenerator.reportdefinitions.ParameterValues;
import com.calipso.reportgenerator.reportdefinitions.ParameterValue;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportFilter;
import com.calipso.common.DateEx;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import es.indra.mare.common.info.InfoException;

/**
 * Esta clase se utiliza para construir todos los filtros que se utilizan en la ejecución de un reporte, tanto los
 * pre-filtros, como los post-filtros, resolver los valores de parámetros.
 * Se encarga de procesar todos los objetos <code>ReportFilter</code> creados a partir de los <code>FilterDefinition</code>
 * del <code>ReportDefinition</code> y el <code>ReportSourceDefinition</code> y generar un objeto <code>CubeFilter</code>
 * que sirve para determinar si un registro del <code>DataSource</code> o de la <code>Matrix</code> del <code>ReportSource<code>
 * cumplen con todas las condiciones.
 * El objeto CubeFilter también es capaz de generar una condición para ser utilizada en una consulta OQL.
 * Provee mecanismos para consolidar los valores de los parámetros ingresados por el usuario y completarlos con los valores
 * de los parámetros que figuran el las definiciones correspondientes.
 */
public class ReportFilterBuilder {

  private List reportFilters;
  private Map paramValues;
  private int mode;
  public static final int VARMODE_INDEX = 0;
  public static final int VARMODE_DATAINDEX = 1;
  public static final int VARMODE_NAME = 2;
  public static final int VARMODE_EXTERNALDATA = 3;
  public static final String NULL_PARAM_VALUE = "NULL_VALUE";

  /**
   * Constructor que inicializa el ReportFilterBuilder
   * @param reportFilters
   * @param paramValues
   * @param mode
   */
  public ReportFilterBuilder(List reportFilters, Map paramValues, int mode) {
    this.paramValues = paramValues;
    this.reportFilters = reportFilters;
    this.mode = mode;
  }

  /**
   * Devuelve un filtro para el cubo
   * @return
   */
  public ExpressionCubeFilter getCubeFilter(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec) throws InfoException{
    Expression exp = null;
    ExpressionCubeFilter cubeFilter = null;
    for (Iterator iterator = reportFilters.iterator(); iterator.hasNext();) {
      ReportFilter reportFilter = (ReportFilter) iterator.next();
      String dimensionName = reportFilter.getFilterSpec().getDimensionName();
      if(dimensionName!=null && !dimensionName.equalsIgnoreCase("")){
        Expression currentExp = reportFilter.getExpression(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
        if (currentExp != null) {
          if (exp == null) {
            exp = currentExp;
          }
          else {
            exp = exp.newAnd(currentExp);
          }
        }
      }
    }
    if (exp==null){ //!= null) {
      //exp = new Expression();
    }
    cubeFilter = new ExpressionCubeFilter(exp, paramValues);
    //}
    return cubeFilter;
  }

  /**
   * Sobrecarga los parameters values default con los valores del diccionario
   * @param values
   * @param defaultparameterValues
   * @return
   */
  public static Map mergeParamValues(Map values, Map defaultparameterValues) {
    Map defParams;
    if (defaultparameterValues != null) {
      defParams = defaultparameterValues;
    }
    else {
      defParams = new HashMap();
    }
    Map returnValues = new HashMap();
    Iterator keys;
    if (values != null) {
      keys = values.keySet().iterator();
      while (keys.hasNext()) {
        String key = (String) keys.next();
        returnValues.put(key, values.get(key));
      }
    }
    keys = defParams.keySet().iterator();
    while (keys.hasNext()) {
      String key = (String) keys.next();
      returnValues.put(key, defParams.get(key));
    }
    return returnValues;
  }

  /**
   * Sobrecarga los parameters values default con los valores del diccionario
   * @param values
   * @param defaultParameterValues
   * @return
   */
  public static Map mergeParamValues(Map values, ParameterValues defaultParameterValues) {
    return mergeParamValues(values, paramValuesDictFromParameterValues(defaultParameterValues));
  }

  /**
   * Retorna un diccionario a partir de un ParameterValues
   * @param parameterValues
   * @return
   */
  private static Map paramValuesDictFromParameterValues(ParameterValues parameterValues) {
    Map returnValues = new HashMap();
    if (parameterValues != null){
      for (int i = 0; i < parameterValues.getParameterValueCount(); i++) {
        ParameterValue parameterValue = parameterValues.getParameterValue(i);
        String parameterValueKey = parameterValue.getFilterDefinitionName() + parameterValue.getFilterParameter().toString();
        String defaultValue = parameterValue.getDefaultValue();
        if(!defaultValue.equalsIgnoreCase(NULL_PARAM_VALUE)){
          returnValues.put(parameterValueKey, parameterValue.getDefaultValue());
        }else{
          returnValues.put(parameterValueKey, null);
        }
        
      }
    }
    return returnValues;
  }

  public static Object getConstatValue(int mode, Object o, ReportDataSourceSpec dataSourceSpec, int dataType) {
    switch (mode) {
      case VARMODE_INDEX:
        return o;
      case VARMODE_DATAINDEX:
        return o;
      case VARMODE_NAME:
        return o;
      case VARMODE_EXTERNALDATA:
        try {
          return getExternalData(o, dataSourceSpec, dataType);
        }catch(Exception e){
          e.printStackTrace();
          return o;
        }
    }
    return null;
  }

  public static Object getExternalDate(Object o, String externalDatePattern,ReportDataSourceSpec dataSourceSpec, int dataType) throws InfoException{
    if(o == null){
      return null;
    }
    if (o == "" && dataSourceSpec != null){
      return new String("' '");
    }else if(dataSourceSpec != null) {
      String formatedDate;
      DateFormat dateFormat;
      Date date;
      /*String pattern = dataSourceSpec.getPattern(dataType);
      if(pattern != null && !pattern.equalsIgnoreCase("")){
        dateFormat = new SimpleDateFormat(pattern);
      }else{
        dateFormat = new SimpleDateFormat("yyyyMMdd");
      }*/
      if(o instanceof SharedDate ){
        date = ((SharedDate)o).getDateEx().getDate();
      }else if(o instanceof Date){
        date = (Date)o;
      }else{
        date = new DateEx(o.toString(), externalDatePattern).getDate();
        if(date==null){
          date = new DateEx(o.toString(), dataSourceSpec.getPattern(dataType)).getDate();
        }
      }
      if(date==null){
        throw new InfoException(LanguageTraslator.traslate("77"));
      }
      try{
      //Se intenta con el formato pasado por parametro
        dateFormat = new SimpleDateFormat(externalDatePattern);
        dateFormat.setLenient(false);
        formatedDate = dateFormat.format(date);
      }catch(Exception e){
        try{
        //Se intenta con el formato del datePattern del dataSourceDefinition
          dateFormat = new SimpleDateFormat(dataSourceSpec.getPattern(dataType));
          dateFormat.setLenient(false);
          formatedDate = dateFormat.format(date);
        }catch(Exception e1){
          //Se intenta con el default
          dateFormat = new SimpleDateFormat("yyyyMMdd");
          dateFormat.setLenient(false);
          formatedDate = dateFormat.format(date);
        }
      }
      return new String("'"+formatedDate+"'");
    } else {
      DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
      /*Date date = dateFormat.parse(o.toString());*/
      Date date = (new DateEx(o.toString())).getDate();
      return dateFormat.format(date);
    }
  }
  
  public static Object getExternalData(Object o, ReportDataSourceSpec dataSourceSpec, int dataType) throws InfoException{
    if(o == null){
      return null;
    }
    switch(dataType){
      case ReportDataType.DATETIME_TYPE:
      case ReportDataType.DATE_TYPE:
        if (o == "" && dataSourceSpec != null){
          return new String("' '");
        }else if(dataSourceSpec != null) {
          String formatedDate;
          DateFormat dateFormat;
          String pattern = dataSourceSpec.getPattern(dataType);
          if(pattern != null && !pattern.equalsIgnoreCase("")){
            dateFormat = new SimpleDateFormat(pattern);
          }else{
            dateFormat = new SimpleDateFormat("yyyyMMdd");
          }
          if(o instanceof SharedDate ){
            formatedDate = dateFormat.format(((SharedDate)o).getDateEx().getDate());
          }else if(o instanceof Date){
            formatedDate = dateFormat.format((Date)o);
          }else{
            formatedDate = dateFormat.format(new DateEx(o.toString()).getDate());
          }
          return new String("'"+formatedDate+"'");
        } else {
          DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
          /*Date date = dateFormat.parse(o.toString());*/
          Date date = (new DateEx(o.toString())).getDate();
          return dateFormat.format(date);
        }
      case ReportDataType.STRING_TYPE:
        String str = new String("'"+o.toString()+"'");
        if (str.indexOf("''")>=0)
        {
          char c1 = '\'';
          char c2= ' ';
          str = str.replace(c1,c2);          
        }

        return str;
      case ReportDataType.INTEGER_TYPE:
        try {
          return ((SharedInteger)o).getValue();
        }catch(Exception e)
        {
          return new String(o.toString());
        }
      case ReportDataType.FLOAT_TYPE:
        String floatPattern="";
        if ( dataSourceSpec.getFloatPattern()!= null)
        {
          floatPattern = dataSourceSpec.getFloatPattern();
        }
        if(o instanceof SharedFloat ){     
          if (!floatPattern.equals("")){
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            dfs.setGroupingSeparator(',');
            return new DecimalFormat(floatPattern, dfs).format(((SharedFloat)o).getValue());
          }else
          {
            return ((SharedFloat)o).getValue();
          }
        } else if(o instanceof Float ){     
          
          if (!floatPattern.equals("")){
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("ES"));
            dfs.setDecimalSeparator('.');
            dfs.setGroupingSeparator(',');
          
            return new DecimalFormat(floatPattern, dfs).format(o);
          }else
          {
            return o;
          }
        } else
        {
          return o;          
        }
      case ReportDataType.BOOLEAN_TYPE:
        return ((Boolean)o).toString();
    }
    return null;
  }

}
