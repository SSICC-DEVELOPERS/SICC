package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.IReportManager;

/**
 * Clase abstracta que implementa IReportManager. Se crea a partir
 * de una instancia de ReportManagerConfiguration.
 */
public abstract class RemoteReportManager implements IReportManager {
  private ReportGeneratorConfiguration reportGeneratorConfiguration;

  public RemoteReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration) {
    this.reportGeneratorConfiguration = reportGeneratorConfiguration;
  }

  /**
   * Crea un RemoteReportManagerStateful o RemoteReportManagerStateless dependiendo
   * de la configuracion establecida en la instancia reportGeneratorConfiguration
   * @param reportGeneratorConfiguration
   * @param isStateFul determina trata de un EJB Stateful o Stateless
   * @return los metodos que encapsulan aquellos del Bean correspondiente, y cuya invocacion
   * permite la ejecucion de los mismos en el ReportManager
   */
  public static IReportManager newRemoteReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration, boolean isStateFul) {
    if (isStateFul) {
      return new RemoteReportManagerStateFul(reportGeneratorConfiguration);
    }
    else {
      return new RemoteReportManagerStateLess(reportGeneratorConfiguration);
    }
  }

  /**
   * Obtiene un ReportManagerConfiguration
   * @return el ReportManagerConfiguration determinado de la instancia
   */
  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }


}
