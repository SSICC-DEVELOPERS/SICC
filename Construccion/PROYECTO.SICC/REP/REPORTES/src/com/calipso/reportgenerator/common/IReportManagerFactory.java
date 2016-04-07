package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import es.indra.mare.common.info.InfoException;

/**
 * Created by IntelliJ IDEA.
 * User: Breto
 * Date: 06/05/2004
 * Time: 10:43:37
 * To change this template use File | Settings | File Templates.
 */
public interface IReportManagerFactory {
  public IReportManager newReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration, boolean isStateFul) throws InfoException;
}
