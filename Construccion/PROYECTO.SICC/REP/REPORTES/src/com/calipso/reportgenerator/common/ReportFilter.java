package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import com.calipso.reportgenerator.reportcalculator.expression.VariableExp;
import com.calipso.reportgenerator.reportcalculator.expression.Expression;
import com.calipso.reportgenerator.reportcalculator.expression.GreaterThan;
import com.calipso.reportgenerator.reportcalculator.expression.LessThan;
import com.calipso.reportgenerator.reportcalculator.expression.BeginsWithExp;
import com.calipso.reportgenerator.reportcalculator.expression.IncludesExp;
import com.calipso.reportgenerator.reportcalculator.expression.EndsWithExp;
import com.calipso.reportgenerator.reportcalculator.expression.InExp;
import com.calipso.reportgenerator.reportcalculator.expression.ConstantExp;
import com.calipso.reportgenerator.reportcalculator.expression.EqualTo;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportFilterSpec;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.common.DateEx;

import java.util.Collection;
import java.util.Map;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.Serializable;
import es.indra.mare.common.info.InfoException;

/**
 *  Es el filtro de un reporte. Incluye todos los filtros como una sola expreción. Se utiliza para evaluar en linea u obtener los textos(SQL,OQL) para filtrar otros origenes de datos
 */

public class ReportFilter implements Serializable{

  private ReportFilterSpec filterSpec;

  /**
   * Crea e inicializa un report filter
   * @param filterSpec
   */
  public ReportFilter(ReportFilterSpec filterSpec) {
    this.filterSpec = filterSpec;
  }

  /**
   * Devuelve el filter definition
   * @return
   */
  public ReportFilterSpec getFilterSpec() {
    return filterSpec;
  }

  /**
   * Devuelve una expression dependiendo del tipo de filtro
   * @param paramValues Lista de parameters value para componer la exrescion
   * @param mode Modo nombre de variables
   * @return
   */
  public Expression getExpression(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) throws InfoException{

    switch (getFilterSpec().getFilterType().getType()) {
      case FilterDefinitionFilterTypeType.RANGE_TYPE:
        return getRangeExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      case FilterDefinitionFilterTypeType.GREATERTHAN_TYPE:
        return getGraterThanExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      case FilterDefinitionFilterTypeType.LESSTHAN_TYPE:
        return getLessThanExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      case FilterDefinitionFilterTypeType.EQUALTO_TYPE:
        return getEqualToExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      case FilterDefinitionFilterTypeType.BEGINWITH_TYPE:
        return getBeginWithExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      case FilterDefinitionFilterTypeType.ENDWITH_TYPE:
        return getEndWithExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      case FilterDefinitionFilterTypeType.INCLUDES_TYPE:
        return getIncludesExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      case FilterDefinitionFilterTypeType.IN_TYPE:
        return getInExp(paramValues, mode, reportSpec, dataSourceSpec, reportFilter);
      default:
        return null;
    }
  }

  private Expression getInExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) throws InfoException{
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    Collection values;
    Object param = paramValues.get(getParamKey("VALUES"));
    if(param==null){
      return null;
    }
    values = getValues(mode,dataSourceSpec, dimensionSpec , param.toString());
    return new InExp(new VariableExp(getVariableName(mode, reportSpec)), values);
  }

  public Collection getValues(int mode, ReportDataSourceSpec data, ReportDimensionSpec dimensionSpec, String s) throws InfoException{//TODO
    StringTokenizer tok;
    if (dimensionSpec.getDataType().getType()==ReportDataType.INTEGER_TYPE){
      tok = new StringTokenizer(s, ",");
    }else 
    {
      tok = new StringTokenizer(s, "'");      
    }
    Collection values = new HashSet();
    while(tok.hasMoreTokens()){
      String current = "";
      current = tok.nextToken().trim();
      if(current.indexOf(",")==0){
        current = tok.nextToken();
      }
      values.add(getInValue(mode, current, data, dimensionSpec));
    }
    return values;
  }

  private Object getInValue(int mode, String s, ReportDataSourceSpec dataSourceSpec, ReportDimensionSpec dimensionSpec) throws InfoException{
    Object result = s;
    switch(dimensionSpec.getDataType().getType()){
      case ReportDataType.DATETIME_TYPE:
      case ReportDataType.DATE_TYPE:
        if(dimensionSpec!=null){      //dataSourceSpec!=null){
          result = SharedDate.newFrom(new DateEx(s, dataSourceSpec.getPattern(dimensionSpec.getDataType().getType())));
        }/*else{
          result = SharedDate.newFrom(new DateEx(s, "", ""));
        } */
        break;
      case ReportDataType.STRING_TYPE:
        break;
      case ReportDataType.INTEGER_TYPE:
        result = SharedInteger.newFrom(Integer.valueOf(s));
        break;
      case ReportDataType.FLOAT_TYPE:
        result = SharedFloat.newFrom(Float.valueOf(s));
        break;
      case ReportDataType.BOOLEAN_TYPE:
        result = Boolean.valueOf(s);
        break;
    }
    if(mode == ReportFilterBuilder.VARMODE_EXTERNALDATA){
      try{
        return ReportFilterBuilder.getExternalData(result, dataSourceSpec, dimensionSpec.getDataType().getType());
      }catch (Exception e){
        throw new InfoException("85",e);
      }
    }else{
      return result;
    }
  }

  /**
   * Devuelve el nombre de la variable segun el modo que se la uitlizará
   * @param mode Modo de uso
   * @return
   */
  private Object getVariableName(int mode, ReportSpec reportSpec) {

    //ReportSourceDimension reportSourceDimension = reportSource.getDimensionfromName(getFilterDefinition().getDimensionName());

    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(getFilterSpec().getDimensionName());
    switch (mode) {
      case ReportFilterBuilder.VARMODE_INDEX:
        return new Integer(dimensionSpec.getReportSourceIndex());
      case ReportFilterBuilder.VARMODE_DATAINDEX:
        return new Integer(dimensionSpec.getDataSourceIndex());
      case ReportFilterBuilder.VARMODE_NAME:
        return dimensionSpec.getName();
      case ReportFilterBuilder.VARMODE_EXTERNALDATA:
        return dimensionSpec.getExternalData();
    }
    return null;
  }

  /**
   * Devuelve el nombre del parámetro compuesto
   * @param filterParam
   * @return
   */
  private String getParamKey(String filterParam) {
    return getFilterSpec().getName() + filterParam;
  }

  /**
   * Devuelve un IncludesExp a partir de los valores de los parámetros
   * @param paramValues
   * @param mode Modo de uso de parámetros
   * @return
   */
  private Expression getIncludesExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter ) {
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    return new IncludesExp(new VariableExp(getVariableName(mode, reportSpec)), new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(getParamKey("VALUE")), dataSourceSpec, dimensionSpec.getDataType().getType())));
  }

  /**
   * Devuelve un EndWithExp a partir de los valores de los parámetros
   * @param paramValues
   * @param mode Modo de uso de parámetros
   * @return
   */
  private Expression getEndWithExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) {
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    return new EndsWithExp(new VariableExp(getVariableName(mode, reportSpec)), new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(getParamKey("VALUE")), dataSourceSpec, dimensionSpec.getDataType().getType())));
  }

  /**
   * Devuelve un BeginWithExp a partir de los valores de los parámetros
   * @param paramValues
   * @param mode Modo de uso de parámetros
   * @return
   */

  private Expression getBeginWithExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) {
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    return new BeginsWithExp(new VariableExp(getVariableName(mode, reportSpec)), new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(getParamKey("VALUE")), dataSourceSpec, dimensionSpec.getDataType().getType())));
  }

  /**
   * Devuelve un EqualToExp a partir de los valores de los parámetros
   * @param paramValues
   * @param mode Modo de uso de parámetros
   * @return
   */
  private Expression getEqualToExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) {
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    return new EqualTo(new VariableExp(getVariableName(mode, reportSpec)), new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(getParamKey("VALUE")), dataSourceSpec, dimensionSpec.getDataType().getType())));
  }

  /**
   * Devuelve un LessThanExp a partir de los valores de los parámetros
   * @param paramValues
   * @param mode Modo de uso de parámetros
   * @return
   */
  private Expression getLessThanExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) {
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    return new LessThan(new VariableExp(getVariableName(mode, reportSpec)), new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(getParamKey("VALUE")), dataSourceSpec, dimensionSpec.getDataType().getType())));
  }

  /**
   * Devuelve un GraterThanExp a partir de los valores de los parámetros
   * @param paramValues
   * @param mode Modo de uso de parámetros
   * @return
   */
  private Expression getGraterThanExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) {
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    return new GreaterThan(new VariableExp(getVariableName(mode, reportSpec)), new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(getParamKey("VALUE")), dataSourceSpec, dimensionSpec.getDataType().getType())));
  }

  /**
   * Devuelve un RangeExp a partir de los valores de los parámetros
   * @param paramValues
   * @param mode Modo de uso de parámetros
   * @return
   */
  private Expression getRangeExp(Map paramValues, int mode, ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportFilter reportFilter) {
    ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromName(reportFilter.getFilterSpec().getDimensionName());
    String fromKey = getParamKey("FROM");
    Expression subexp1 = new VariableExp(getVariableName(mode, reportSpec)).newGreaterOrEqualTo(new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(fromKey), dataSourceSpec, dimensionSpec.getDataType().getType())));
    String toKey = getParamKey("TO");
    Expression subexp2 = new VariableExp(getVariableName(mode, reportSpec)).newLessOrEquealTo(new ConstantExp(ReportFilterBuilder.getConstatValue(mode,paramValues.get(toKey), dataSourceSpec, dimensionSpec.getDataType().getType())));
    return subexp1.newAnd(subexp2);
  }
}
