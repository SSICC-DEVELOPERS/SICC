package com.calipso.reportgenerator.enterprise.server;

import com.calipso.reportgenerator.common.MicroReport;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportcalculator.Matrix;
import com.calipso.reportgenerator.reportmanager.ReportManager;
import es.indra.mare.common.info.InfoException;
import javax.ejb.SessionContext;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *  Enterprise Java Bean que crea y guarda una instancia de ReportManager.
 *  Implementa SessionBean, es decir, debe definir todos los métodos
 *  de la interface que serán los que harán posible la comunicaciones entre
 *  el Bean y el Container debido a la ocurrencia de eventos determinados.
 *  Publica los métodos del ReportManager a los cuales le reenvía la ejecución agregando throws InfoException por el contexto que se ejecuta.
 *  @see com.calipso.reportgenerator.reportmanager.ReportManager
 */

public class ReportManagerSLBean implements javax.ejb.SessionBean {

  private SessionContext ctx;

  /**
   * Metodo responsable de asociar al bean con un ambiente.
   */
  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  /**
   * Obtiene un ReportManagera partir de la configuración especificada en ReportManagerConfiguration
   * @param reportGeneratorConfiguration la configuracion que especifica path de los repositorios
   * , si es distribuida, host, port.
   * @return interface que publica los métodos a invocar por parte del usuario
   */
  private IReportManager getReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    LanguageTraslator.newLocaleFrom(reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry(),reportGeneratorConfiguration.getLanguagesPath());
    try{
      IReportManager reportManager = new ReportManager();
      reportManager.init(reportGeneratorConfiguration);
      return reportManager;
    }catch(Exception e){
      throw new InfoException(e);
    }
  }

  /**
   * Método requerido por el EJB Container
   */
  public void ejbCreate() {
  }

  /**
   *  Método requerido por el EJB Container
   */
  public void ejbRemove() {
  }

  /**
   * Método requerido por el EJB Container
   */
  public void ejbActivate() {
  }

  /**
   * Método requerido por el EJB Container
   */
  public void ejbPassivate() {
  }


  public int PrepareReport(ReportGeneratorConfiguration configuration, String reportDefID) throws InfoException{
    return getReportManager(configuration).PrepareReport(reportDefID);
  }

  public int PrepareReport(ReportGeneratorConfiguration configuration, String reportDefId, Map paramValues) throws InfoException {
    return getReportManager(configuration).PrepareReport(reportDefId, paramValues);
  }

  public void ReleaseReport(ReportGeneratorConfiguration configuration, int handle) throws InfoException {
    getReportManager(configuration).ReleaseReport(handle);
  }

  public void prepareReportSource(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException {
    getReportManager(configuration).prepareReportSource(reportSourceDefinitionId);
  }

  public Map getReportDefinitions(ReportGeneratorConfiguration configuration) throws InfoException {
    return getReportManager(configuration).getReportDefinitions();
  }

  public Map getReportSourceDefinitions(ReportGeneratorConfiguration configuration) throws InfoException {
    return getReportManager(configuration).getReportSourceDefinitions();
  }

  public Map getReportsForEntity(ReportGeneratorConfiguration configuration, String entityID) throws InfoException {
    return getReportManager(configuration).getReportsForEntity(entityID);
  }

  public void ExecuteAction(ReportGeneratorConfiguration configuration, int handle, String actionName, Object params) throws InfoException {
    getReportManager(configuration).ExecuteAction(handle, actionName, params);
  }

  public void invalidateReportSource(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException{
    getReportManager(configuration).invalidateReportSource(reportSourceDefinitionId);
  }

  public ReportQuery getReportQuery(ReportGeneratorConfiguration configuration, int handle) throws InfoException{
    return getReportManager(configuration).getReportQuery(handle);
  }

  public ReportQuery getDefaultReportQuery(ReportGeneratorConfiguration configuration, int handle) throws InfoException {
    return getReportManager(configuration).getDefaultReportQuery(handle);
  }

  public ReportQuery getReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException {
    return getReportManager(configuration).getReportQuery(reportDefinitionId);
  }

  public ReportQuery getDefaultReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException {
    return getReportManager(configuration).getDefaultReportQuery(reportDefinitionId);
  }

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, Map paramValues) throws InfoException {
    return getReportManager(configuration).ExecReportQuery(handle, paramValues);
  }

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, ReportQuery query) throws InfoException {
    return getReportManager(configuration).ExecReportQuery(handle, query);
  }

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionID, Map paramValues) throws InfoException {
    return getReportManager(configuration).ExecReportQuery(reportDefinitionID, paramValues);
  }

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionID, ReportQuery query) throws InfoException {
    return getReportManager(configuration).ExecReportQuery(reportDefinitionID, query);
  }

  public ReportQuery getDefaultReportQuery(ReportGeneratorConfiguration configuration, int handle,String userID) throws InfoException {
    return getReportManager(configuration).getDefaultReportQuery(handle,userID);
  }

  public Map getReportViews(ReportGeneratorConfiguration configuration, String reportDefinitionID, String userID) throws InfoException{
    return getReportManager(configuration).getReportViews(reportDefinitionID);
  }

  public Map getReportViews(ReportGeneratorConfiguration configuration, String reportDefinitionID) throws InfoException{
    return getReportManager(configuration).getReportViews(reportDefinitionID);
  }

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, String reportViewId) throws InfoException{
    return getReportManager(configuration).ExecReportQuery(handle,reportViewId);
  }

  public ReportSpec getReportSpec(ReportGeneratorConfiguration configuration, String reportDefinitionId, String reportSourceDef) throws InfoException{
    return getReportManager(configuration).getReportSpec(reportDefinitionId, reportSourceDef);
  }

  public ReportSpec getReportSpec(ReportGeneratorConfiguration configuration, ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException{
    return getReportManager(configuration).getReportSpec(reportDefinition, reportSourceDef);
  }
  public ReportSpec getReportSpec(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException{
    return getReportManager(configuration).getReportSpec(reportDefinitionId);
  }

  public void registerDefinitions(ReportGeneratorConfiguration configuration) throws InfoException {
    getReportManager(configuration).registerDefinitions();
  }

  public void deleteAllRepositories(ReportGeneratorConfiguration configuration) throws InfoException {
    getReportManager(configuration).deleteAllRepositories();
  }

  public void deleteAllDefinitions(ReportGeneratorConfiguration configuration) throws InfoException {
    getReportManager(configuration).deleteAllDefinitions();
  }

  public void deleteReportSourceRepository(ReportGeneratorConfiguration configuration) throws InfoException {
    getReportManager(configuration).deleteReportSourceRepository();
  }

  public void deleteReportSourceDefinitionRepository(ReportGeneratorConfiguration configuration) throws InfoException {
    getReportManager(configuration).deleteReportSourceDefinitionRepository();
  }

  public void deleteReportDefinitionRepository(ReportGeneratorConfiguration configuration) throws InfoException {
    getReportManager(configuration).deleteReportDefinitionRepository();
  }

  public void deleteReportViewRepository(ReportGeneratorConfiguration configuration) throws InfoException {
    getReportManager(configuration).deleteReportViewRepository();
  }

  public void deleteReportView(ReportGeneratorConfiguration configuration, String id, String reportDefinitionId, String userId) throws InfoException {
    getReportManager(configuration).deleteReportView(id,reportDefinitionId,userId);
  }

  public void deleteReportSource(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException {
    getReportManager(configuration).deleteReportSource(reportSourceDefinitionId);
  }

  public void deleteReportSourceDefinition(ReportGeneratorConfiguration configuration, String reportSourceDefinitionID) throws InfoException {
    getReportManager(configuration).deleteReportSourceDefinition(reportSourceDefinitionID);
  }

  public void deleteReportDefinition(ReportGeneratorConfiguration configuration, String reportDefinitionID) throws InfoException {
    getReportManager(configuration).deleteReportDefinition(reportDefinitionID);
  }

  public void assingDefaultView(ReportGeneratorConfiguration configuration, String id, String reportDefinitionId, String userId) throws InfoException {
    getReportManager(configuration).assingDefaultView(id,reportDefinitionId,userId);
  }

  public Vector registerReportSourceDefinitions(ReportGeneratorConfiguration configuration, Vector vector) throws InfoException{
    return getReportManager(configuration).registerReportSourceDefinitions(vector);
  }

  public Vector registerReportDefinitions(ReportGeneratorConfiguration configuration, Vector vector) throws InfoException{
    return getReportManager(configuration).registerReportDefinitions(vector);
  }

  public Vector registerReportViews(ReportGeneratorConfiguration configuration, Vector vector) throws InfoException{
    return getReportManager(configuration).registerReportViews(vector);
  }

  public String getDefaultReportViewId(ReportGeneratorConfiguration configuration, String reportDefinitionId, String userId) throws InfoException{
    return getReportManager(configuration).getDefaultReportViewId(reportDefinitionId,userId);
  }

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, MicroReport microReport) throws InfoException {
    return getReportManager(configuration).ExecReportQuery(microReport);
  };

  public int PrepareReport(ReportGeneratorConfiguration configuration, MicroReport microReport) throws InfoException {
    return getReportManager(configuration).PrepareReport(microReport);
  };

  public String getXML(ReportGeneratorConfiguration configuration, int handle) throws InfoException{
    return getReportManager(configuration).getXML(handle);
  };

  public String getXML(ReportGeneratorConfiguration configuration, String reportDefinitionID, Map paramValues) throws InfoException{
    return getReportManager(configuration).getXML(reportDefinitionID,paramValues);
  };

  public Set getDimensionValues(ReportGeneratorConfiguration configuration, int handle, String name) throws InfoException{
    return getReportManager(configuration).getDimensionValues(handle,name);
  };

  public Set getDimensionValues(ReportGeneratorConfiguration configuration, String reportDefinitionID, Map paramValues, String name) throws InfoException{
    return getReportManager(configuration).getDimensionValues(reportDefinitionID,paramValues,name);
  };

  public Vector getUpdatedDataModel(ReportGeneratorConfiguration configuration, int handle, int mode, int row, int col, boolean isDistributed) throws InfoException{
    return getReportManager(configuration).getUpdatedDataModel(handle, mode, row, col, isDistributed);
  };

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, ReportView reportView) throws InfoException {
    return getReportManager(configuration).ExecReportQuery(handle,reportView);
  };


  public ReportView getReportView(ReportGeneratorConfiguration configuration, String reportViewId) throws InfoException{
    return getReportManager(configuration).getReportView(reportViewId);
  };

  public void saveReportView(ReportGeneratorConfiguration configuration, ReportView reportView) throws InfoException{
    getReportManager(configuration).saveReportView(reportView);
  };

  public ReportView getReportViewFromID(ReportGeneratorConfiguration configuration, String id, String reportDefinitionId, String userId) throws InfoException{
    return getReportManager(configuration).getReportViewFromID(id, reportDefinitionId, userId);
  };

  public void saveReportDefinition(ReportGeneratorConfiguration configuration, ReportDefinition reportDefinition) throws InfoException{
    getReportManager(configuration).saveReportDefinition(reportDefinition);
  };

  public void saveReportSourceDefinition(ReportGeneratorConfiguration configuration, ReportSourceDefinition reportSourceDefinition) throws InfoException{
    getReportManager(configuration).saveReportSourceDefinition(reportSourceDefinition);
  };

  public Matrix getMatrix(ReportGeneratorConfiguration configuration, int handle) throws InfoException{
    return getReportManager(configuration).getMatrix(handle);
  }

  public ReportDefinition getReportDefinitionFromID(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException{
    return getReportManager(configuration).getReportDefinitionFromID(reportDefinitionId);
  };

  public ReportSourceDefinition getReportSourceDefinitionFromID(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException{
    return getReportManager(configuration).getReportSourceDefinitionFromID(reportSourceDefinitionId);
  };

  public boolean validateUser(ReportGeneratorConfiguration configuration, String userName, String password, String userRepositoryPath) throws InfoException {
    return getReportManager(configuration).validateUser(userName, password, userRepositoryPath);
  };

  public void exportReport(ReportGeneratorConfiguration configuration, String userName, String password,String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException{
    getReportManager(configuration).exportReport(userName, password, userRepositoryPath, reportDefinitionId, paramValues, isLandscape, type, destinationPath, name);
  };

  public boolean addNewUser(ReportGeneratorConfiguration configuration, String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException{
    return getReportManager(configuration).addNewUser(rootPasswd, userName, password, userRepositoryPath);
  }
}



