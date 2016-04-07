package com.calipso.reportgenerator.javabeans;

/**
 * Representa el Java Bean de la aplicacion
 */



//import com.calipso.reportgenerator.userinterface.ReportViewer;
//import com.calipso.reportgenerator.userinterface.UserLoginFrame;

import java.io.Serializable;

import es.indra.mare.common.info.InfoException;

public class ReportBean implements Serializable {

  private String configPath;
  private String userId;
  private String reportDefinitionId;
  private String reportViewId;
  private String propertiesPath;


  /**
   * Inicializa una instancia de <code>ReportBean</code>
   */
  public ReportBean() {
    initialize();
  }

  /**
   * Inicializa los atributos del Bean
   */
  private void initialize() {
    configPath = "";
    userId = "";
    reportDefinitionId = "";
    reportViewId = "";
    propertiesPath = "";
  }

  public String getConfigPath() {
    return configPath;
  }

  public void setConfigPath(String configPath) {
    this.configPath = configPath;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getReportDefinitionId() {
    return reportDefinitionId;
  }

  public void setReportDefinitionId(String reportDefinitionId) {
    this.reportDefinitionId = reportDefinitionId;
  }

  public String getReportViewId() {
    return reportViewId;
  }

  public void setReportViewId(String reportViewId) {
    this.reportViewId = reportViewId;
  }

  public String getPropertiesPath() {
    return propertiesPath;
  }

  public void setPropertiesPath(String propertiesPath) {
    this.propertiesPath = propertiesPath;
  }

  /**
   * Ejecuta la aplicacion
   */
   
  public void executeApp() throws InfoException {
   /* IReportManager service = null;
    service = ReportManagerService.getReportManagerService(configPath ,null);
    if(UserLoginFrame.login("root", "Login", service)) {
      if(configPath.equals("")) {
        ReportViewer reportViewer = new ReportViewer(UserLoginFrame.getUserName(), reportDefinitionId, reportViewId, propertiesPath,
                                                   service , true, new HashMap());
        reportViewer.show();
      }
    }*/
  }
}
