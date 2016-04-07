package com.calipso.reportgenerator.services;

import com.calipso.common.DateEx;
import com.calipso.reportgenerator.reportmanager.IRDataSource;
import com.calipso.reportgenerator.reportmanager.RDataSource;
import es.indra.mare.common.info.InfoException;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportMetricSpec;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import java.sql.ResultSet;
import es.indra.sicc.util.UtilidadesLog;

/**
 * Clase para implementar los distintos resolvedores de SQL
 */
public abstract class SQLDataSourceResolver implements ISQLDataSourceResolver {

  private static Map resolvers;
  private String sqlText;
  private ReportGeneratorConfiguration reportGeneratorConfiguration;
  private DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString;
  private ReportSpec reportSpec;
  private ReportDataSourceSpec dataSourceSpec;

  private static Map getResolvers() {
    if (resolvers == null) {
      resolvers = new HashMap();
      resolvers.put(FramewokPlatform.Mare, MareSQLDataSourceResolver.class);
      resolvers.put(FramewokPlatform.Calipso, DefaultSQLDataSourceResolver.class);
      resolvers.put(FramewokPlatform.StandAlone, DefaultSQLDataSourceResolver.class);
    }
    return resolvers;
  }

  public static ISQLDataSourceResolver getResolver(ReportGeneratorConfiguration reportGeneratorConfiguration, DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString,ReportSpec reportSpec) throws InfoException {
    Class resolverClass = (Class) getResolvers().get(reportGeneratorConfiguration.getFrameworkPlatform());
    try {
      ISQLDataSourceResolver resolver = (ISQLDataSourceResolver) resolverClass.newInstance();
      resolver.init(reportGeneratorConfiguration, dataSourceDefinitionConnectionString,reportSpec);
      return resolver;
    }
    catch (Exception e) {
      throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("206"), e);
    }
  }

  public IRDataSource execute(String sqlText) throws InfoException {
    setSqlText(sqlText);
    setReportDataSourceSpec(this.getReportDataSourceSpec());
    return execute();
  }

  public String getSqlText() {
    return sqlText;
  }

  public void setSqlText(String sqlText) {
    this.sqlText = sqlText;
  }

  public void setReportDataSourceSpec(ReportDataSourceSpec dataSourceSpec) {
    this.dataSourceSpec = dataSourceSpec;
  }

  public ReportDataSourceSpec getReportDataSourceSpec() {
    return dataSourceSpec;
  }

  public void init(ReportGeneratorConfiguration reportGeneratorConfiguration, DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString,ReportSpec reportSpec) {
    this.reportGeneratorConfiguration = reportGeneratorConfiguration;
    this.dataSourceDefinitionConnectionString = dataSourceDefinitionConnectionString;
    this.reportSpec = reportSpec;
  }

  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }

  public DataSourceDefinitionConnectionString getDataSourceDefinitionConnectionString() {
    return dataSourceDefinitionConnectionString;
  }

  public ReportSpec getReportSpec() {
    return reportSpec;
  }
  
  public IRDataSource execute() throws InfoException {
    return getDataSource(getSqlText());
  }
  
  protected abstract ResultSet getResultSet(String sqlText)  throws InfoException;
  
/**
   * Ejecuta la query, construye el datasource y lo devuelve
   * @throws InfoException
   */
  public IRDataSource getDataSource(String sqlText) throws InfoException {
    IRDataSource dataSource = null;
    ResultSet rs = null;
    int colNum;
    try {
      //ReportManagerLogger.debug(sqlText);      
      UtilidadesLog.debug(sqlText);
      rs = getResultSet(sqlText);
    //  System.out.println("Despues de ejecutar el SQL"+(new Date()).toString());      
      colNum = getReportSpec().getNotCalculatedDimensions().size()+getReportSpec().getNotCalculatedMetrics().size();//rs.getMetaData().getColumnCount();
      int[] columnTypes = getColumnTypes(colNum); 
      dataSource = new RDataSource(colNum);
      int type;     
      Object defaultValue;
      Map columnsNames = getReportSpec().getColumnTypesByName();
    //  System.out.println("Inicio carga de la matriz"+(new Date()).toString());
      while (rs.next()) {
        Collection collection = new Vector();
        for (int i = 0; i < (colNum); i++) {
          try{
            int index = i;
            type = columnTypes[i]; //type = getColumnType(i);
            try {
              defaultValue = rs.getObject(getColumnExternalData(i));// getString(i).trim();
              
            }catch(Exception e){
              try{
                defaultValue = rs.getObject(getColumnName(i)); // getString(i).trim();
                
              }catch(Exception e1){
                throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("393"), e1);
              }
            }
            try{
              switch(type){
                case ReportDataType.FLOAT_TYPE:
                  SharedFloat sharedFloat;
                  if (defaultValue == null)
                  {
                    sharedFloat = SharedFloat.newFrom(new Float(0));
                  } else {
                    sharedFloat = SharedFloat.newFrom(new Float(defaultValue.toString().trim()));
                  }
                  collection.add(sharedFloat);
                  break;
                case ReportDataType.INTEGER_TYPE:
                  SharedInteger sharedInteger = SharedInteger.newFrom(new Integer(defaultValue.toString().trim()));
                  collection.add(sharedInteger);
                  break;
                case ReportDataType.STRING_TYPE:
                  collection.add(SharedString.newFrom(defaultValue.toString().trim()));
                  break;
                case ReportDataType.DATETIME_TYPE:
                case ReportDataType.DATE_TYPE:
                  DateEx dateEx;
                  if(defaultValue instanceof Date){
                    dateEx = new DateEx((Date)defaultValue/*, getReportSpec().getDimensionFromIndex(i).getQueryConvertToStringPattern() /*getDatePattern()*/);
                  } else {
                    dateEx = new DateEx(defaultValue, getReportDataSourceSpec().getPattern(getReportSpec().getDimensionFromIndex(i).getDataType().getType()));
                  }
                  SharedDate sharedDate = SharedDate.newFrom(dateEx);
                  collection.add(sharedDate);
                  break;
                default:
                  collection.add(SharedString.newFrom(defaultValue.toString().trim()));
                  break;
              }
/*              if (type==0){
                SharedDate sharedDate = SharedDate.newFrom(new DateEx((Date)defaultValue,""));
                collection.add(sharedDate);
              } else if (type==2){
                SharedFloat sharedFloat = SharedFloat.newFrom(new Float(defaultValue.toString().trim()));
                collection.add(sharedFloat);
              } else if (type==3){
                SharedInteger sharedInteger = SharedInteger.newFrom(new Integer(defaultValue.toString().trim()));
                collection.add(sharedInteger);
              } else{
                collection.add(SharedString.newFrom(defaultValue.toString().trim()));
              }*/
            }catch(Exception e){
              collection.add(SharedString.newFrom(defaultValue.toString().trim()));
            }
          }catch(Exception e){
            collection.add(SharedString.newFrom(""));
          }
        }
        dataSource.addRow(collection);
      }
    } catch (Exception e) {
      throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("95"), e);
    } finally {
      try{
        if(rs != null){
          rs.close();
        }
        close();
      }catch (Exception e){
        throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("95"), e);
      }
    }
   // System.out.println("Fin carga de la matriz"+(new Date()).toString());
    return dataSource;
  }

  private String getColumnExternalData(int i) {
    if (getReportSpec().getNotCalculatedDimensions().size() > i){
      return ((ReportDimensionSpec)getReportSpec().getNotCalculatedDimensions().toArray()[i]).getExternalData();
    } else{
      return ((ReportMetricSpec)getReportSpec().getNotCalculatedMetrics().toArray()[i-(getReportSpec().getNotCalculatedDimensions().size())]).getExternalData();
    }
  }

  private String getColumnName(int i) {
    if (getReportSpec().getNotCalculatedDimensions().size() > i){
      return ((ReportDimensionSpec)getReportSpec().getNotCalculatedDimensions().toArray()[i]).getName();
    } else{
      return ((ReportMetricSpec)getReportSpec().getNotCalculatedMetrics().toArray()[i-(getReportSpec().getNotCalculatedDimensions().size())]).getName();
    }
  }

/** 
 * El siguiente metodo se modifico para evitar que la verificacion 
 * del tipo de columna se haga por columan en lugar de hacerlo por cada row. 
 */ 
/*  private int getColumnType(int i) { 
    if (getReportSpec().getNotCalculatedDimensions().size() > i){ 
      return ((ReportDimensionSpec)getReportSpec().getNotCalculatedDimensions().toArray()[i]).getDataType().getType(); 
    } else{ 
      return ReportDataType.FLOAT_TYPE; 
    } 
  }*/ 
  private int[] getColumnTypes(int colnum){ 
    int[] result = new int[colnum]; 
    int dim = getReportSpec().getNotCalculatedDimensions().size(); 
    Iterator it = getReportSpec().getNotCalculatedDimensions().iterator(); 
    int i = 0; 
    for (; it.hasNext(); i++) { 
      ReportDimensionSpec dimSpec = (ReportDimensionSpec)it.next(); 
      result[i] = dimSpec.getDataType().getType(); 
    } 
    for(; i < colnum; i++){ 
      result[i] = ReportDataType.FLOAT_TYPE; 
    } 
    return result; 
  } 

  
 
}
