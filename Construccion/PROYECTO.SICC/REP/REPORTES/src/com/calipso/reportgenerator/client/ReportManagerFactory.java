package com.calipso.reportgenerator.client;

import com.calipso.reportgenerator.common.IReportManagerFactory;
import com.calipso.reportgenerator.common.RemoteReportManager;
import com.calipso.reportgenerator.common.VersionProperties;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.LanguageTraslator;
import es.indra.mare.common.info.InfoException;

/**
 * Esta clase se encarga de instanciar el RemortManager correspondiente dependiendo de la configuración y el uso que se le desee realizar
 */
public class ReportManagerFactory implements IReportManagerFactory {

  /**
   * Crea un ReportManager EJB si la configuración del ReportManagerConfiguracion es is Distributed, si no crea un RemportManaget.
   * Si adicionalmente el Distributed y es isStateFul el EJB es StateFul, de lo contratrio crea un StateLess
   * @param reportGeneratorConfiguration
   * @param isStateFul
   * @return
   */
  public IReportManager newReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration, boolean isStateFul) throws InfoException {
    IReportManager reportManager = null;
    if ((VersionProperties.keyProtected()&&(VersionProperties.checkKey()))||(!VersionProperties.keyProtected())){
      if (reportGeneratorConfiguration.getIsDistributed()) {
        reportManager = RemoteReportManager.newRemoteReportManager(reportGeneratorConfiguration, isStateFul);
      }
      else {
        try {
          Class reportManagerFactoryClass = Class.forName("com.calipso.reportgenerator.reportmanager.LocalReportManagerFactory");
          IReportManagerFactory factory = (IReportManagerFactory) reportManagerFactoryClass.newInstance();
          reportManager = factory.newReportManager(reportGeneratorConfiguration,false);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return reportManager;
    }else{
      throw new InfoException(LanguageTraslator.traslate("363"));
    }
  }


}
