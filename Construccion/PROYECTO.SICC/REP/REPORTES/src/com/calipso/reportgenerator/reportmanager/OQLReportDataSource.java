package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;

import java.util.Iterator;


/**
 * Resuelve la obtención de los datos ejecutando una consulta en lenguaje OQL.
 * La consulta se genera a partir de la información sobre los campos que contiene el <code>ReportSourceDefinition</code>.
 * Se encarga de generar los filtros correspondientes a partir de los <code>FilterDefinition</code> y devolver el resultado
 * en un objeto <code>IRDataSource</code>
 */
public class OQLReportDataSource extends BasicOQLReportDataSource {

  public OQLReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(reportSpec, dataSourceSpec, reportGeneratorConfiguration);
  }


  protected String getQueryFailedMessage() {
    return LanguageTraslator.traslate("155");
  }


  protected int getQueryDescriptorType() {
    return 0;
//    return CubesBDLQueryDescriptor.OQL_QUERY;
  }

  /**
   * Devuelve el texto del select de la query OQL
   * @param buffer
   */
  protected void resolveSelect(StringBuffer buffer) {
    buffer.append("select ");
    Iterator iterator = collectFieldsExternalData().iterator();
    while (iterator.hasNext()) {
      String externalData = (String) iterator.next();
      buffer.append(externalData);
      if(iterator.hasNext()) {
        buffer.append(", ");
      }
    }
  }
}
