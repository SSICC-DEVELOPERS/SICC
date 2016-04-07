package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.text.MessageFormat;
import com.calipso.reportgenerator.common.ReportFieldSpec;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.common.ReportMetricSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.ReportFilterBuilder;


/**
 *  Resuelve el acceso via OQL a un Data Souce
 */
public abstract class BasicOQLReportDataSource extends ReportDataSource {
  private IRDataSource dataSource;

  public BasicOQLReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(reportSpec, dataSourceSpec);
    setGeneratorConfiguration(reportGeneratorConfiguration);
  }

  /**
   * Devuelve el DataSource
   * @return
   */
  public IRDataSource getDataSource() throws InfoException {
    if (dataSource == null) {
      dataSource = getQueryDataSource();
    }
    return dataSource;
  }

  /**
   * Obtiene y retorna un DataSource dado por MARE
   * @return
   */
  private IRDataSource getQueryDataSource() throws InfoException {
  /*  try {
      IBDLInfoWrapper wrapper = ServicesHelper.getBDLInfoWrapperService();
      CubesBDLQueryDescriptor descriptor = getQueryDescriptor();
      ReportManagerLogger.debug(descriptor.getQuery());
      return wrapper.getBDLInfo(descriptor);
    } catch (Exception e) {
      throw new InfoException(getQueryFailedMessage(), e);
    }*/ //TODO:BELCORP
    return null;
  }

  protected abstract String getQueryFailedMessage();


  /*protected CubesBDLQueryDescriptor getQueryDescriptor() {
    CubesBDLQueryDescriptor descriptor = new CubesBDLQueryDescriptor();
    descriptor.setQueryType(getQueryDescriptorType());
    descriptor.setQuery(getQueryText());
    descriptor.setObjectValues(collectFieldsExternalData());
    descriptor.setCalculatedMetricsValues(collectCalculatedMetricValues());
    return descriptor;
  }*/

  private Collection collectCalculatedMetricValues() {
    ArrayList calcMetrics = new ArrayList();
    Iterator iterator = getReportSpec().getMetricsByIndex().iterator();
    while (iterator.hasNext()) {
      ReportMetricSpec metricSpec = (ReportMetricSpec) iterator.next();
      if (metricSpec.getExternalCalculated()) {
        calcMetrics.add(metricSpec.getExternalData());
      }

    }
    return calcMetrics;
  }

  protected abstract int getQueryDescriptorType();

/*  private void queryInfoToConsole() {
    String oqlText = getQueryText();
    System.out.println("-----------------------------");
    System.out.println("OQL a ejecutar: " + oqlText);
    System.out.println("ExternalData:");
    Collection fieldsExternalData = collectFieldsExternalData();

    Iterator iterator = fieldsExternalData.iterator();
    while (iterator.hasNext()) {
      String str = (String) iterator.next();
      System.out.println(str);
    }
    System.out.println("Fin ExternalData:");
    System.out.println("-----------------------------");
  }
  */

  /**
   * Obtiene los valores de los atributos ExternalData de las DimensionSourceDefinition y MetricSourceDefinition
   * para pasar al servicio de MARE que resuelve la consulta
   * @return
   */
  protected Collection collectFieldsExternalData() {
    ArrayList data = new ArrayList();
    collectExternalDataFromFields(data, getReportSpec().getDimensionSpecs().values());
    collectExternalDataFromFields(data, getReportSpec().getMetricSpecs().values());
    return data;
  }

  private void collectExternalDataFromFields(Collection externalData, Collection fieldSpecs) {
    Iterator iterator = fieldSpecs.iterator();
    while (iterator.hasNext()) {
      ReportFieldSpec fieldSpec = (ReportFieldSpec) iterator.next();
      if (!fieldSpec.getCalculated() && isExternalCalculated(fieldSpec)) {
        externalData.add(fieldSpec.getExternalData());
      }
    }
  }

  private boolean isExternalCalculated(ReportFieldSpec fieldSpec) {
    if (fieldSpec instanceof ReportMetricSpec) {
      return ((ReportMetricSpec)fieldSpec).getExternalCalculated();
    }
    return false;
  }

  /**
   * Devuelve el texto de la query
   * @return
   */
  protected String getQueryText() {
    String queryText = getReportDataSourceSpec().getExpression();
    if (queryText == null || queryText.equals("")) {
      StringBuffer buffer = new StringBuffer("");
      resolveSelect(buffer);
      resolveFrom(buffer);
      resolveWhere(buffer);
      queryText = buffer.toString();
    }
    else {
      queryText = queryText + completeWhere(queryText);
    }
    return queryText;
  }

  /**
   * Agrega la condición de los prefiltros en el Where cuando la query viene expresada en el atributo Expression del
   * DataSourceDefinition
   * @param currentQueryText
   * @return
   */

  private String completeWhere(String currentQueryText) {
    String condition = getConditionText();
    if (condition != null) {
      int pos = currentQueryText.indexOf("where");
      String str;
      if (pos >= 0) {
        str = " and ";
      }
      else {
        str = " where ";
      }
      return str + condition;
    }
    return "";
  }

  /**
   * Devuelve el texto de la condición dada por los prefiltros
   * @return
   */
  private String getConditionText() {
    return getFilter().getOqlText();
  }

  /**
   * Devuelve el texto del select de la query OQL
   * @param buffer
   */
  protected abstract void resolveSelect(StringBuffer buffer);

  /**
   * Devuelve el alias de la clase para utilizar en el select, se obtiene del external data de una dimensión
   * @return
   */
  protected String getExternalClassAlias() {
    ReportDimensionSpec dimensionSpec = null;
    Iterator iterator = getReportSpec().getDimensionsByIndex().iterator();
    while (iterator.hasNext()) {
      dimensionSpec = (ReportDimensionSpec) iterator.next();
      if (!dimensionSpec.getCalculated()){
        break;
      }
    }
    String extData = dimensionSpec.getExternalData();
    int pos = extData.indexOf(".");
    return extData.substring(0, pos);
  }

  /**
   * Devuelve la clase de los objetos que da como resultado la consulta
   * @return
   */
  private String getExternalClassName() {
    return getReportDataSourceSpec().getExternalClassName();
  }

  private void resolveFrom(StringBuffer buffer) {
    buffer.append(" from ");
    buffer.append(MessageFormat.format("{0} {1}", new Object[]{getExternalClassName(), getExternalClassAlias()}));
  }

  /**
   * Resuelve el texto del where
   * @param buffer
   */
  private void resolveWhere(StringBuffer buffer) {
    String condition = getConditionText();
    if (condition != null) {
      buffer.append(" where ");
      buffer.append(condition);
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

}
