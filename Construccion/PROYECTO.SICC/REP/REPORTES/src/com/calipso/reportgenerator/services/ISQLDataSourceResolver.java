package com.calipso.reportgenerator.services;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;

/**
 * Interfase para implementar los ditintops resolvedores de SQL
 */
public interface ISQLDataSourceResolver {

  public IRDataSource execute() throws InfoException;

  public IRDataSource execute(String sqlText) throws InfoException;

  public String getSqlText();

  public void setSqlText(String sqlText);

  public void setReportDataSourceSpec(ReportDataSourceSpec dataSourceSpec);

  public ReportDataSourceSpec getReportDataSourceSpec();

  public void init(ReportGeneratorConfiguration reportGeneratorConfiguration, DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString,ReportSpec reportSpec);

  public ReportGeneratorConfiguration getReportGeneratorConfiguration();
  
  public void close()throws Exception;

}
