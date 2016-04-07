package com.calipso.reportgenerator.reportmanager;

//import es.indra.mare.common.info.CubesBDLQueryDescriptor;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;

/**
 * Resuelve la obtención de los datos ejecutando una consulta en lenguaje OQL.
 * La consulta se genera a partir de la información sobre los campos que contiene el <code>ReportSourceDefinition</code>.
 * Se encarga de generar los filtros correspondientes a partir de los <code>FilterDefinition</code> y devolver el resultado
 * en un objeto <code>IRDataSource</code>
 */

public class BDLQLReportDataSource extends BasicOQLReportDataSource {

  public BDLQLReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(reportSpec, dataSourceSpec, reportGeneratorConfiguration);
  }

  protected String getQueryFailedMessage() {
    return LanguageTraslator.traslate("208");
  }

  protected int getQueryDescriptorType() {
    return 0;
//    return CubesBDLQueryDescriptor.BDLQL_QUERY;
  }

  protected void resolveSelect(StringBuffer buffer) {
    buffer.append("select ");
    buffer.append(getExternalClassAlias());
  }

}
