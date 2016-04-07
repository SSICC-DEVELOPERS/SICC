package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.IReportManagerFactory;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import es.indra.mare.common.info.InfoException;

/**
 * Created by IntelliJ IDEA.
 * User: Breto
 * Date: 06/05/2004
 * Time: 10:44:32
 * To change this template use File | Settings | File Templates.
 */
public class LocalReportManagerFactory implements IReportManagerFactory {

  public IReportManager newReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration, boolean isStateFul) throws InfoException {
    IReportManager reportManager = new ReportManager();
    reportManager.init(reportGeneratorConfiguration);
    return reportManager;
  }
}
