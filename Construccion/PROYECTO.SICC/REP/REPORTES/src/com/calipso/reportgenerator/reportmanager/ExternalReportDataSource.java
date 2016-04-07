package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
//import es.indra.mare.common.info.IBDLInfoWrapper;
//import es.indra.mare.common.info.CubesBDLQueryDescriptor;
//import es.indra.mare.common.mii.helper.ServicesHelper;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;

/**
 * Resuelve el acceso por medio de la BDL
 */
public class ExternalReportDataSource extends ReportDataSource {
  private IRDataSource dataSource;

  public ExternalReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(reportSpec, dataSourceSpec);
    setGeneratorConfiguration(reportGeneratorConfiguration);
  }

  /**
   * Devuelve el DataSource
   * @return
   * @throws InfoException
   */
  public IRDataSource getDataSource() throws InfoException {
    if (dataSource == null) {
      dataSource = getQueryDataSource();
    }
    return dataSource;
  }

  private IRDataSource getQueryDataSource() throws InfoException {
    /*IBDLInfoWrapper wrapper = null;
    try {
      wrapper = ServicesHelper.getBDLInfoWrapperService();
      return wrapper.getBDLInfo(getQueryDescriptor());
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("157"), e);
    }*///TODO:BELCORP
    return null;
  }

/*  private CubesBDLQueryDescriptor getQueryDescriptor() {
    CubesBDLQueryDescriptor descriptor = new CubesBDLQueryDescriptor();
    descriptor.setQueryType(CubesBDLQueryDescriptor.BDL_INTERNAL_QUERY);
    descriptor.setIdQuery(Integer.valueOf(getReportDataSourceSpec().getExpression()).intValue());
    descriptor.setQueryParameters(getReportSpec().getParamValues(false).entrySet());
    return descriptor;
  }
*/
  public int getFilterVarMode() {
    return 0;
  }
}
