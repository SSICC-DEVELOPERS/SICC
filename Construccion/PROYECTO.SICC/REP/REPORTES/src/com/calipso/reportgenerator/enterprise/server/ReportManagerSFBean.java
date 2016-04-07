package com.calipso.reportgenerator.enterprise.server;

import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.MicroReport;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.LanguageTraslator;
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
 */


/**
 * Esta clase corresponde a las ejecución de un ReportManager como un StateFul.
 * Publica los métodos del ReportManager a los cuales le reenvía la ejecución agregando throws InfoException por el contexto que se ejecuta.
 * @see com.calipso.reportgenerator.reportmanager.ReportManager
 */
public class ReportManagerSFBean implements javax.ejb.SessionBean {

  private SessionContext ctx;
  private IReportManager reportManager;

  /**
   * Metodo responsable de asociar al bean con un ambiente.
   */
  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  /**
   * Metodo requerido por el EJB Container
   * @param reportGeneratorConfiguration características de configuración como path del repositorio, host, port.
   * @throws es.indra.mare.common.info.InfoException
   */
  public void ejbCreate(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    LanguageTraslator.newLocaleFrom(reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry(),reportGeneratorConfiguration.getLanguagesPath());
    try{
      IReportManager reportManager = new ReportManager();
      reportManager.init(reportGeneratorConfiguration);
      this.reportManager = reportManager;
    }catch(Exception e){
      throw new InfoException(e);
    }
  }

  /**
   * Método requerido por el EJB Container
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

  public int PrepareReport(String reportDefID) throws InfoException{
    return reportManager.PrepareReport(reportDefID);
  }


  public int PrepareReport(String reportDefId, Map paramValues) throws InfoException {
    return reportManager.PrepareReport(reportDefId, paramValues);
  }

  public void ReleaseReport(int handle) throws InfoException {
    reportManager.ReleaseReport(handle);
  }


  public void prepareReportSource(String reportSourceDefinitionId) throws InfoException {
    reportManager.prepareReportSource(reportSourceDefinitionId);
  }

  public Map getReportDefinitions() throws InfoException {
    return reportManager.getReportDefinitions();
  }

  public Map getReportSourceDefinitions() throws InfoException {
    return reportManager.getReportSourceDefinitions();
  }

  public Map getReportsForEntity(String entityID) throws InfoException {
    return reportManager.getReportsForEntity(entityID);
  }

  public void ExecuteAction(int handle, String actionName, Object params) throws InfoException {
    reportManager.ExecuteAction(handle, actionName, params);
  }


  public void invalidateReportSource(String reportSourceDefinitionId) throws InfoException{
    reportManager.invalidateReportSource(reportSourceDefinitionId);
  }


  public ReportQuery getReportQuery(int handle) throws InfoException {
    return reportManager.getReportQuery(handle);
  }

  public ReportQuery getDefaultReportQuery(int handle) throws InfoException {
    return reportManager.getDefaultReportQuery(handle);
  }

  public ReportQuery getReportQuery(String reportDefinitionId) throws InfoException {
    return reportManager.getReportQuery(reportDefinitionId);
  }

  public ReportQuery getDefaultReportQuery(String reportDefinitionId) throws InfoException{
    return reportManager.getDefaultReportQuery(reportDefinitionId);
  }

  public ReportResult ExecReportQuery(int handle, Map paramValues) throws InfoException {
    return reportManager.ExecReportQuery(handle, paramValues);
  }

  public ReportResult ExecReportQuery(int handle, ReportQuery query) throws InfoException{
    return reportManager.ExecReportQuery(handle, query);
  }

  public ReportResult ExecReportQuery(String reportDefinitionID, Map paramValues) throws InfoException {
    return ExecReportQuery(reportDefinitionID, paramValues);
  }

  public ReportResult ExecReportQuery(String reportDefinitionID, ReportQuery query) throws InfoException{
    return reportManager.ExecReportQuery(reportDefinitionID, query);
  }

  public ReportQuery getDefaultReportQuery(int handle,String userID) throws InfoException{
    return reportManager.getDefaultReportQuery(handle,userID);
  }

  public ReportResult ExecReportQuery(int handle, ReportView reportView) throws InfoException{
    return reportManager.ExecReportQuery(handle,reportView);
  }

  public ReportView getReportViewFromID(String id,String reportDefinitionId,String userId) throws InfoException{
    return reportManager.getReportViewFromID(id,reportDefinitionId,userId);
  }

  public void saveReportView(ReportView reportView) throws InfoException{
    reportManager.saveReportView(reportView);
  }

  public ReportSpec getReportSpec(String reportDefinitionId, String reportSourceDefId) throws InfoException{
    return reportManager.getReportSpec(reportDefinitionId, reportSourceDefId);
  }

  public ReportSpec getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException{
    return reportManager.getReportSpec(reportDefinition, reportSourceDef);
  }
  public ReportSpec getReportSpec(String reportDefinitionId) throws InfoException{
    return reportManager.getReportSpec(reportDefinitionId);
  }

  public Map getReportViews(String reportDefinitionID, String userID) throws InfoException{
    return reportManager.getReportViews(reportDefinitionID,userID);
  }

  public Map getReportViews(String reportDefinitionID) throws InfoException{
    return reportManager.getReportViews(reportDefinitionID);
  }

  public void registerDefinitions() throws InfoException {
    reportManager.registerDefinitions();
  }

  public void deleteAllRepositories() throws InfoException {
    reportManager.deleteAllRepositories();
  }

  public void deleteAllDefinitions() throws InfoException {
    reportManager.deleteAllDefinitions();
  }

  public void deleteReportSourceRepository() throws InfoException {
    reportManager.deleteReportSourceRepository();
  }

  public void deleteReportSourceDefinitionRepository() throws InfoException {
    reportManager.deleteReportSourceDefinitionRepository();
  }

  public void deleteReportDefinitionRepository() throws InfoException {
    reportManager.deleteReportDefinitionRepository();
  }

  public void deleteReportViewRepository() throws InfoException {
    reportManager.deleteReportViewRepository();
  }

  public void deleteReportView(String id, String reportDefinitionId, String userId) throws InfoException {
    reportManager.deleteReportView(id,reportDefinitionId,userId);
  }

  public void deleteReportSource(String reportSourceDefinitionId) throws InfoException {
    reportManager.deleteReportSource(reportSourceDefinitionId);
  }

  public void deleteReportSourceDefinition(String reportSourceDefinitionID) throws InfoException {
    reportManager.deleteReportSourceDefinition(reportSourceDefinitionID);
  }

  public void deleteReportDefinition(String reportDefinitionID) throws InfoException {
    reportManager.deleteReportDefinition(reportDefinitionID);
  }

  public void assingDefaultView(String id, String reportDefinitionId, String userId) throws InfoException {
    reportManager.assingDefaultView(id,reportDefinitionId,userId);
  }

  public Vector registerReportSourceDefinitions(Vector vector) throws InfoException{
    return reportManager.registerReportSourceDefinitions(vector);
  }

  public Vector registerReportDefinitions(Vector vector) throws InfoException{
    return reportManager.registerReportDefinitions(vector);
  }

  public Vector registerReportViews(Vector vector) throws InfoException{
    return reportManager.registerReportViews(vector);
  }

  public String getDefaultReportViewId(String reportDefinitionId, String userId) throws InfoException{
    return reportManager.getDefaultReportViewId(reportDefinitionId,userId);
  }

  public ReportResult ExecReportQuery(MicroReport microReport) throws InfoException {
    return reportManager.ExecReportQuery(microReport);
  };

  public int PrepareReport(MicroReport microReport) throws InfoException {
    return reportManager.PrepareReport(microReport);
  };

  public Matrix getMatrix(int handle) throws InfoException{
    return reportManager.getMatrix(handle);
  }

  public String getXML(int handle) throws InfoException{
    return reportManager.getXML(handle);
  };

  public String getXML(String reportDefinitionID, Map paramValues) throws InfoException{
    return reportManager.getXML(reportDefinitionID,paramValues);
  };

  public Set getDimensionValues(int handle, String name) throws InfoException{
    return reportManager.getDimensionValues(handle,name);
  };

  public Set getDimensionValues(String reportDefinitionID, Map paramValues, String name) throws InfoException{
    return reportManager.getDimensionValues(reportDefinitionID,paramValues,name);
  };

  public Vector getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) throws InfoException{
    return reportManager.getUpdatedDataModel(handle, mode, row, col, isDistributed);
  };

  public ReportView getReportView(String reportViewId) throws InfoException{
    return reportManager.getReportView(reportViewId);
  };

  public ReportResult ExecReportQuery(int handle, String reportViewId) throws InfoException{
    return reportManager.ExecReportQuery(handle, reportViewId);
  }

  public void saveReportDefinition(ReportDefinition reportDefinition) throws InfoException{
    reportManager.saveReportDefinition(reportDefinition);
  };

  public void saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition) throws InfoException{
    reportManager.saveReportSourceDefinition(reportSourceDefinition);
  };

  public ReportDefinition getReportDefinitionFromID(String reportDefinitionId) throws InfoException{
    return reportManager.getReportDefinitionFromID(reportDefinitionId);
  };

  public ReportSourceDefinition getReportSourceDefinitionFromID(String reportSourceDefinitionId) throws InfoException{
   return reportManager.getReportSourceDefinitionFromID(reportSourceDefinitionId);
  };

  public boolean validateUser(String userName, String password, String userRepositoryPath) throws InfoException {
    return reportManager.validateUser(userName, password, userRepositoryPath);
  }

  public void exportReport(String userName, String password,String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException{
    reportManager.exportReport(userName, password,userRepositoryPath, reportDefinitionId, paramValues, isLandscape, type, destinationPath, name);
  };

  public boolean addNewUser(String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException{
    return reportManager.addNewUser(rootPasswd, userName, password, userRepositoryPath);
  }
}



