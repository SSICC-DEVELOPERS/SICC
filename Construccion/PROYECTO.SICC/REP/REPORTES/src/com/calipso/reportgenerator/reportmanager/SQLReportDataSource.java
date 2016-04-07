package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
//import es.indra.mare.common.info.CubesBDLQueryDescriptor;
import com.calipso.reportgenerator.common.ReportFieldSpec;
import com.calipso.reportgenerator.common.ReportFilterSpec;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportFilterBuilder;
import com.calipso.reportgenerator.services.ISQLDataSourceResolver;
import com.calipso.reportgenerator.services.SQLDataSourceResolver;
import com.calipso.reportgenerator.services.DataSourceDefinitionConnectionString;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import java.util.Collection;
import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;

/**
 * Resuelve la obtención de los datos ejecutando una consulta en lenguaje SQL.
 * La consulta se genera a partir de la información sobre los campos que contiene el <code>ReportSourceDefinition</code> y el expresion del datasourcedefinition.
 * Se encarga de generar los filtros correspondientes a partir de los <code>FilterDefinition</code> y devolver el resultado
 * en un objeto <code>IRDataSource</code>
 */
public class SQLReportDataSource extends ReportDataSource {
  private IRDataSource dataSource;
  public static final String AND_FILTER_TAG = "%and_prefilter%";
  public static final String WHERE_FILTER_TAG = "%where_prefilter%";
  private DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString;
  private static final String separators = " ()";
  private final static String datePattern = "FORMATOFECHAVALUE";
  //  private static final Collection separators = Arrays.asList({new Character(' '), new Character('('), new Character(')')});

  public SQLReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportGeneratorConfiguration reportGeneratorConfiguration, DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString) {
    super(reportSpec, dataSourceSpec);
    setGeneratorConfiguration(reportGeneratorConfiguration);
    this.dataSourceDefinitionConnectionString = dataSourceDefinitionConnectionString;
  }

  /**
   * Devuelve el DataSource
   * @return
   * @throws InfoException
   */
  public IRDataSource getDataSource() throws InfoException {
    if (dataSource == null) {
      dataSource = getQueryDataSource();
      //Ver si es necesario llenar los columnNames
      fillColumnsNames(dataSource);
    }
    return dataSource;
  }

  /**
   * Asigna los nombres de las columnas al data source
   * @param dataSource
   * @throws InfoException
   */
  private void fillColumnsNames(IRDataSource dataSource) throws InfoException {
    for (int i = 0; i < getColumnNames().size(); i++) {
      try {
        dataSource.setColumName(i, (String) getColumnNames().get(i));
      } catch (Exception e) {
        throw new InfoException(LanguageTraslator.traslate("98"), e);
      }
    }
  }

  /**
   * Obtiene y construye y retorna un DataSource desde MARE
   * @return
   */
  private IRDataSource getQueryDataSource() throws InfoException {
    ISQLDataSourceResolver resolver = getResolver();
    resolver.setSqlText(getQueryText());
    resolver.setReportDataSourceSpec(this.getReportDataSourceSpec());
    return resolver.execute();
  }

  private ISQLDataSourceResolver getResolver() throws InfoException {
    return SQLDataSourceResolver.getResolver(getReportGeneratorConfiguration(), this.dataSourceDefinitionConnectionString,getReportSpec());
  }
/*  private CubesBDLQueryDescriptor getQueryDescriptor() throws InfoException{
    CubesBDLQueryDescriptor descriptor = new CubesBDLQueryDescriptor();
    descriptor.setQueryType(CubesBDLQueryDescriptor.SQL_QUERY);
    descriptor.setQuery(getQueryText());
    return descriptor;
  }*/

  private void queryInfoToConsole() throws InfoException{
   // System.out.println("-----------------------------");
 //   System.out.println("SQL a ejecutar: " + getQueryText());
  //  System.out.println("-----------------------------");
  }

  /**
   * Devuelve el texto de la query
   * @return
   */
  private String getQueryText() throws InfoException {
    List attributes = new ArrayList();
    Set classes = new HashSet();
    parseExternalData(attributes, classes);
    StringBuffer buffer = new StringBuffer("");
    resolveQuery(buffer);
    return buffer.toString();
  }


  /**
   * Resuelve el texto de la Query
   * @param buffer
   */
  private void resolveQuery(StringBuffer buffer) throws InfoException {
    resolveCompleteFilter(buffer);
    resolveParamTags(buffer);
    cleanSQLText(buffer);
  }

  private void cleanSQLText(StringBuffer buffer){
    cleanUnusedTags(buffer);
    cleanEmptyBrackets(buffer);
    cleanDuplicatedLogicOperators(buffer);
    cleanNonLogicStrings(buffer, "WHERE", "OR");
    cleanNonLogicStrings(buffer, "WHERE", "AND");
    cleanNonLogicStrings(buffer, "AND", "AND");
    cleanNonLogicStrings(buffer, "OR", "OR");
    cleanNonLogicStrings(buffer, "FROM", ",");
    cleanNonLogicStrings(buffer, ",", ",");
    
   // System.out.println();
  //  System.out.println();
   // System.out.println();
   // System.out.println(buffer);
   // System.out.println();
  //  System.out.println();
   // System.out.println();
  }
  
  private void cleanNonLogicStrings(StringBuffer buffer, String firstString, String secondString){
    int pos = buffer.toString().toUpperCase().indexOf(firstString);
    int bufferLenght = buffer.length();
    while(pos < bufferLenght && pos > -1){
      //int firstPos = buffer.toString().toUpperCase().indexOf("AND", pos);
/*      int orPos = buffer.toString().toUpperCase().indexOf("OR", pos);
      if(andPos > -1 && andPos < orPos){*/
      int deletePos = getSecondStringPos(buffer, firstString, secondString, pos);//getDuplicatedPos(buffer, "AND", andPos + 3);
      int from, end;
      if(deletePos > pos){
        from = pos;
        end = deletePos;
      }else{
        from = deletePos;
        end = getEndDeletePos(buffer, firstString, secondString, from);
      }
      if(from > -1){
        buffer.delete(from, end);
        pos = buffer.toString().toUpperCase().indexOf(firstString);
      }else{
        pos = buffer.toString().toUpperCase().indexOf(firstString, pos + 1);
      }/*
      }else if(orPos > -1){
        pos = orPos + 2;
        int deletePos = getDuplicatedPos(buffer, "OR", orPos + 2);
        if(deletePos > -1){
          buffer.delete(deletePos, deletePos + 2);
        }
      }else{
        break;
      }*/
    }
  }
  
  private int getEndDeletePos(StringBuffer buffer, String firstString, String secondString, int from){
    return buffer.toString().indexOf(secondString, from) + secondString.length();
  }
  
  private int getSecondStringPos(StringBuffer buffer, String firstString, String secondString, int firstPos){
    int pos = firstPos + firstString.length();
    String separators = " ()";
    while((buffer.length()>pos)&&(separators.indexOf(buffer.charAt(pos)) >= 0)){
      pos++;
    }
    if(buffer.toString().indexOf(secondString, pos)==0){
      return pos + secondString.length();
    }
    pos = firstPos - 1;
    while(separators.indexOf(buffer.charAt(pos)) >= 0){
      pos--;
    }
    if(buffer.toString().indexOf(secondString, pos - secondString.length())==0){
      return pos;
    }
    return -1;
  }
  
  private void cleanEmptyBrackets(StringBuffer buffer){
    int pos = 0;
    int lenght = buffer.length();
    while(pos < lenght){
      pos = findEmptyBrackets(buffer, pos + 1);
      if(pos > -1){
        deleteEmptyBrackets(buffer, pos);
      }else{
        break;
      }
    }
  }
  
  private void deleteEmptyBrackets(StringBuffer buffer, int pos){
    int operatorPos = -1;
    int searchPos = pos - 1;
    while(buffer.charAt(searchPos)==' '){
      searchPos--;
    }
    int andPos = buffer.toString().toUpperCase().indexOf("AND", searchPos - 3);
    int orPos = buffer.toString().toUpperCase().indexOf("OR", searchPos - 2);
    if(andPos >= 0){
      buffer.delete(andPos, buffer.toString().indexOf(")", andPos + 3) + 1);
      return;
    }else if(orPos >= 0){
      buffer.delete(orPos, buffer.toString().indexOf(")", orPos + 2) + 1);
      return;
    }
    searchPos = pos + 1;
    while(buffer.charAt(searchPos)==' '){
      searchPos++;
    }
    andPos = buffer.toString().toUpperCase().indexOf("AND", searchPos);
    orPos = buffer.toString().toUpperCase().indexOf("OR", searchPos);
    if(andPos >= 0){
      buffer.delete(pos, andPos + 3);
      return;
    }else if(orPos >= 0){
      buffer.delete(pos, orPos + 2);
      return;
    }
  }
  
  private int findEmptyBrackets(StringBuffer buffer, int initialPos){
    int open = initialPos - 1;
    while(open > -1 && open < buffer.length()){
      open = buffer.toString().indexOf("(", open + 1);
      int close = open + 1;
      while(buffer.charAt(close)==' '){
        close++;
      }
      if(buffer.charAt(close) == ')'){
        if ((open+1)==(close) && buffer.charAt(open-1)!=' '){
            return -1;
        } else {
            return open;
        }
      
        //return open;
      }
    }
    return -1;
  }
  
  private void cleanUnusedTags(StringBuffer buffer){
    int pos = 0;
    int bufferLenght = buffer.length();
    while(pos < bufferLenght){
      int startTagPos = buffer.toString().indexOf("%start", pos);
      int endTagPos = buffer.toString().indexOf("%end", pos);
      if(startTagPos > -1 && startTagPos < endTagPos){
        pos = startTagPos + 1;
        buffer.delete(startTagPos, buffer.toString().indexOf("%", startTagPos + 1) + 1);
      }else if(endTagPos > -1){
        pos = endTagPos + 1;
        buffer.delete(endTagPos, buffer.toString().indexOf("%", endTagPos + 1) + 1);
      }else{
        break;
      }
    }
  }
  
  private void cleanDuplicatedLogicOperators(StringBuffer buffer){
    int pos = 0;
    int bufferLenght = buffer.length();
    while(pos < bufferLenght){
      int andPos = buffer.toString().toUpperCase().indexOf("AND", pos);
      int orPos = buffer.toString().toUpperCase().indexOf("OR", pos);
      if(andPos > -1 && andPos < orPos){
        pos = andPos + 2;
        int deletePos = getDuplicatedPos(buffer, "AND", andPos + 3);
        if(deletePos > -1){
          buffer.delete(deletePos, deletePos + 3);
        }
      }else if(orPos > -1){
        pos = orPos + 2;
        int deletePos = getDuplicatedPos(buffer, "OR", orPos + 2);
        if(deletePos > -1){
          buffer.delete(deletePos, deletePos + 2);
        }
      }else{
        break;
      }
    }
  }
  
  private int getDuplicatedPos(StringBuffer buffer, String s, int initialPos){
    boolean opened = false;
    boolean closed = true;
    int pos = initialPos;
    while((buffer.length()>pos)&&(separators.indexOf(buffer.charAt(pos)) > -1)){
      if(buffer.charAt(pos) == ')'){
        closed = true;
      }else if(buffer.charAt(pos) == '('){
        opened = true;
      }
      pos++;
    }
    if(buffer.toString().indexOf(s, pos) == pos){
      if(opened){
        return pos;
      }
      return initialPos;
    }
    return -1;
  }
  
  private void resolveParamTags(StringBuffer buffer) throws InfoException {
    Map filterTags = getTagsForFilters(getReportSpec().getPreFilterSpecs());
    for (Iterator iterator = filterTags.entrySet().iterator(); iterator.hasNext();) {
      Map.Entry entry = (Map.Entry) iterator.next();
      Collection tags = (Collection)entry.getValue();
      for (Iterator it = tags.iterator(); it.hasNext();) {
        String tag = ((String) it.next()).toUpperCase();
        if(buffer.toString().toUpperCase().indexOf(tag) >= 0){
          replaceTag(buffer, tag, (ReportFilterSpec)entry.getKey());
        }
      }
    }
  }

  /**
   * Reemplaza los tags de valores por las constantes especificas. Si no hay 
   * constante intentara borrar la parte del filtro involucrada en el sql.
   * @param buffer
   * @param tag
   * @param reportFilterSpec
   * @throws es.indra.mare.common.info.InfoException
   */
  private void replaceTag(StringBuffer buffer, String tag, ReportFilterSpec reportFilterSpec) throws InfoException {
    String resolvedExpression = getExpressionForTag(tag, reportFilterSpec);
    if(resolvedExpression != null){
      int tagSize = tag.length();
      int pos = buffer.toString().toUpperCase().indexOf(tag);
      for(; pos >= 0 ; pos = buffer.toString().toUpperCase().indexOf(tag, pos + 1)){
        buffer.replace(pos, pos + tagSize, resolvedExpression);
      }
    }else{
      deleteFilterFromSQL(tag, buffer);
    }
  }
  
  private void deleteFilterFromSQL(String tag, StringBuffer buffer){
    String startTag = getStartTag(tag);
    String endTag = getEndTag(tag);
    int startPos = buffer.toString().indexOf(startTag);
    int endPos = buffer.toString().indexOf(endTag);
    while(startPos > -1 && endPos > -1){
      deleteUnusedText(buffer, startPos, endPos, endTag.length());      
      startPos = buffer.toString().indexOf(startTag, startPos + 1);
      endPos = buffer.toString().indexOf(endTag, startPos + 1);
    }
  }
  
  private String getStartTag(String tag){
    return "%start_" + tag.substring("%value_".length(), tag.length());
  }
  
  private String getEndTag(String tag){
    return "%end_" + tag.substring("%value_".length(), tag.length());
  }
  
  /**
   * Verifica que no halla otros inicios o cierres de tags entre lo que se esta borrando,
   * y luego borra.
   * @param buffer
   * @param startPos
   * @param endPos
   */
  private void deleteUnusedText(StringBuffer buffer, int startPos, int endPos, int endTagLenght){
    int otherStart = buffer.toString().indexOf("%start", startPos + 1);
    if(otherStart > endPos){
      otherStart = -1;
    }
    int otherEnd = buffer.toString().indexOf("%end", startPos + 1);
    if(otherEnd >= endPos){
      otherEnd = -1;
    }
    if(otherStart < 0 && otherEnd < 0){
      buffer.delete(startPos, endPos + endTagLenght);
    }else{
      String otherTags = getConcatenatedTags(buffer, startPos, endPos);
      buffer.delete(startPos, endPos + endTagLenght);
      buffer.insert(startPos, otherTags);
    }
  }
  
  private String getConcatenatedTags(StringBuffer buffer, int startPos, int endPos){
    StringBuffer result = new StringBuffer();
    int pos = startPos;
    while(pos < endPos){
      int nextStartIndex = buffer.toString().indexOf("%start", pos + 1);
      int nextEndIndex = buffer.toString().indexOf("%end", pos + 1);
      if(nextStartIndex > -1 && nextStartIndex < endPos && nextStartIndex < nextEndIndex + 1){
        result.append(buffer.substring(nextStartIndex, buffer.toString().indexOf("%", nextStartIndex + 1) + 1));
        pos = buffer.toString().indexOf("%", nextStartIndex);
      }else if(nextEndIndex > -1 && nextEndIndex < endPos){
        result.append(buffer.substring(nextEndIndex, buffer.toString().indexOf("%", nextEndIndex + 1) + 1));
        pos = buffer.toString().indexOf("%", nextEndIndex + 1);
      }else{
        break;
      }
    }
    return result.toString();
  }

  private String getExpressionForTag(String tag, ReportFilterSpec reportFilterSpec) throws InfoException{
    return getConstantValueForTag(tag.substring("%value_".length(), tag.length()-1), reportFilterSpec);
  }

  private String getConstantValueForTag(String paramName, ReportFilterSpec reportFilterSpec) throws InfoException{
    String dimensionName = reportFilterSpec.getDimensionName();
    int dataType;
    if(dimensionName!=null && !dimensionName.equalsIgnoreCase("")){
      dataType = getReportSpec().getDimensionFromName(dimensionName).getDataType().getType();
    }else{
      dataType = reportFilterSpec.getDataType().getType();
    }
    Object value;
    if(dataType==0 || dataType==1){
      //Nuevo metodo que realiza lo mismo, pero ademas pasa por parametro el formato de fecha
      value = ReportFilterBuilder.getExternalDate(getFilter().getParamValues().get(paramName),getFilter().getParamValues().get(this.datePattern).toString(),getReportDataSourceSpec(), dataType);
      if(value == null){ 
        return null;
      }
      return value.toString();
    }else{
      value = ReportFilterBuilder.getExternalData(getFilter().getParamValues().get(paramName),getReportDataSourceSpec(), dataType);
    }
    if(value==null){
      return null;
    }
    return ReportFilterBuilder.getExternalData(getFilter().getParamValues().get(paramName),getReportDataSourceSpec(), dataType).toString();
  }

  private Map getTagsForFilters(Collection filterSpecs) {
    Map result = new HashMap();
    for (Iterator iterator = filterSpecs.iterator(); iterator.hasNext();) {
      ReportFilterSpec filterSpec = (ReportFilterSpec) iterator.next();
      result.put(filterSpec, getParamTags(filterSpec));
    }
    return result;
  }

  private Collection getParamTags(ReportFilterSpec filterSpec) {
    Collection result = new Vector();
    for (Iterator iterator = filterSpec.getParamNames().iterator(); iterator.hasNext();) {
      String paramName = (String) iterator.next();
      result.add("%value_" + paramName + "%");
    }
    return result;
  }

  private void resolveCompleteFilter(StringBuffer buffer) {
    String condition="";
    if (getFilter()!=null){
      condition = getFilter().toString();
    }
    String expression = getReportDataSourceSpec().getExpression();
    int andTagPos = expression.indexOf(AND_FILTER_TAG);
    int whereTagPos = expression.indexOf(WHERE_FILTER_TAG);
    boolean findTag = ((andTagPos > 0) || (whereTagPos > 0));
    if (findTag) {
      while (findTag) {
        if (andTagPos > 0) {
          buffer.delete(0,buffer.length());
          buffer.append(expression.substring(0, andTagPos));
          if (!condition.equalsIgnoreCase("")){
            buffer.append(" and ");
            buffer.append(condition);
          }
          buffer.append(expression.substring(andTagPos + AND_FILTER_TAG.length(), expression.length()));
          expression = buffer.toString();
//          expression = expression.substring(0, andTagPos)+expression.substring(andTagPos + AND_FILTER_TAG.length(), expression.length());
        }
        if (whereTagPos > 0) {
          buffer.append(expression.substring(0, whereTagPos));
          if (!condition.equalsIgnoreCase("")){
            buffer.append(" where ");
            buffer.append(condition);
          }
          buffer.append(expression.substring(whereTagPos + WHERE_FILTER_TAG.length(), expression.length()));
          expression = expression.substring(0, whereTagPos)+expression.substring(whereTagPos + WHERE_FILTER_TAG.length(), expression.length());
        }
        andTagPos = expression.indexOf(AND_FILTER_TAG);
        whereTagPos = expression.indexOf(WHERE_FILTER_TAG);
        findTag = ((andTagPos > 0) || (whereTagPos > 0));
        //revisar ej 61 porque no reemplaza bien el segundo y el primero le pone dos where
      }
    }
    else {
      if(expression!=null){
        buffer.append(expression);
      }
/*      if (!condition.equalsIgnoreCase("")){
        buffer.append(" where ");
        buffer.append(condition);
      }*/ //Comentario para que no agregue el filtro where por defecto aunque no halla WHERE_FILTER_TAG
    }
  }


  /**
   * Devuelve el modo de resolver el nombre de la variable
   * @see com.calipso.reportgenerator.common.ReportFilter
   * @return
   */
  public int getFilterVarMode() {
    return ReportFilterBuilder.VARMODE_EXTERNALDATA;
  }

  private void parseFromFieldSpecs(Collection fieldSpecs, List attributes, Set classes){
    Iterator iterator = fieldSpecs.iterator();
    while (iterator.hasNext()) {
      ReportFieldSpec fieldSpec = (ReportFieldSpec) iterator.next();
      String externalData = fieldSpec.getExternalData();
      if (!fieldSpec.getCalculated() && !externalData.equals("")) {
        classes.add(externalData);
        attributes.add(externalData);
      }
    }
  }

  /**
   * Llena la lista de clases y atributos a partir de los external data de las dimensiones y métricas
   * @param attributes Lista de atributos a llenar
   * @param classes Lista de classes a llenar
   */

  protected void parseExternalData(List attributes, Set classes) {
    parseFromFieldSpecs(getReportSpec().getDimensionSpecs().values(), attributes, classes);
    parseFromFieldSpecs(getReportSpec().getMetricSpecs().values(), attributes, classes);
  }

}
