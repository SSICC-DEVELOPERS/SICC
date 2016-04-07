package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

/**
 * Representa al report data source
 */
public class ReportDataSourceSpec implements Serializable {
  private String expression;
  private String externalClassName;
  private String name;
  private DataSourceDefinitionSourceTypeType sourceType;
  private String externalSourceData;
  private String externalConnectionString;
  private String externalConnectionClassName;
  private String externalConnectionDistributedUrl;
  private String externalConnectionLocalUrl;
  private String externalConnectionPassword;
  private String externalConnectionUser;
  private String datePattern;
  private String floatPattern;  
  private String dateTimePattern;
  private String sheetName;
  private String dataEndingCell;
  private String dataInitialCell;


  public void fillFrom(DataSourceDefinition dataSourceDefinition) {
    expression = dataSourceDefinition.getExpression();
    externalClassName = dataSourceDefinition.getExternalClassName();
    name = dataSourceDefinition.getName();
    sourceType = dataSourceDefinition.getSourceType();
    externalSourceData = dataSourceDefinition.getExternalSourceData();
    externalConnectionString = dataSourceDefinition.getExternalConnectionString();
    externalConnectionClassName = dataSourceDefinition.getExternalConnectionClassName();
    externalConnectionDistributedUrl = dataSourceDefinition.getExternalConnectionDistributedUrl();
    externalConnectionLocalUrl = dataSourceDefinition.getExternalConnectionLocalUrl();
    externalConnectionPassword = dataSourceDefinition.getExternalConnectionPassword();
    externalConnectionUser = dataSourceDefinition.getExternalConnectionUser();
    datePattern = dataSourceDefinition.getDatePattern();
    floatPattern = dataSourceDefinition.getFloatPattern();    
    dateTimePattern = dataSourceDefinition.getDateTimePattern();
    sheetName = dataSourceDefinition.getSheetName();
    dataEndingCell = dataSourceDefinition.getDataEndingCell();
    dataInitialCell = dataSourceDefinition.getDataInitialCell();
  }

  public String getExpression() {
    return expression;
  }

  public String getExternalClassName() {
    return externalClassName;
  }

  public String getName() {
    return name;
  }

  public DataSourceDefinitionSourceTypeType getSourceType() {
    return sourceType;
  }

  public String getExternalSourceData() {
    return externalSourceData;
  }

  public String getExternalConnectionString() {
    return externalConnectionString;
  }

  public Map getExternalConnectionValues(){
    Map map = new HashMap();
    map.put("ExternalConnectionString",getExternalConnectionString());
    map.put("DatabaseConfigurationClassName",getExternalConnectionClassName());
    map.put("DatabaseConfigurationLocalUrl",getExternalConnectionLocalUrl());
    map.put("DatabaseConfigurationDistributedUrl",getExternalConnectionDistributedUrl());
    map.put("DatabaseConfigurationUser",getExternalConnectionUser());
    map.put("DatabaseConfigurationPassword",getExternalConnectionPassword());
    return map;
  }

  public String getExternalConnectionClassName() {
    return externalConnectionClassName;
  }

  public String getExternalConnectionDistributedUrl() {
    return externalConnectionDistributedUrl;
  }

  public String getExternalConnectionLocalUrl() {
    return externalConnectionLocalUrl;
  }

  public String getExternalConnectionPassword() {
    return externalConnectionPassword;
  }

  public String getExternalConnectionUser() {
    return externalConnectionUser;
  }

  public String getDatePattern() {
    return datePattern;
  }
  
  public String getFloatPattern() {
    return floatPattern;
  }
  

  public String getDateTimePattern() {
    return dateTimePattern;
  }

  public String getPattern(int dataType) {
    switch(dataType){
      case ReportDataType.DATETIME_TYPE:
        return this.getDateTimePattern();
      case ReportDataType.DATE_TYPE:
        return this.getDatePattern();
      default:
        return "";
    }
  }

  public String getSheetName() {
    return sheetName;
  }

  public String getDataEndingCell() {
    return dataEndingCell;
  }

  public String getDataInitialCell() {
    return dataInitialCell;
  }

}
