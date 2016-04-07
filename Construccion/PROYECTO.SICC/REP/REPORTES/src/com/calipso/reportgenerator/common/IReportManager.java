package com.calipso.reportgenerator.common;

import es.indra.mare.common.info.InfoException;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportcalculator.Matrix;



/**
 * Esta interfase es común para permitir el acceso uniforme encapsulando si el ReportManager es local o distribuido
 * @see com.calipso.reportgenerator.reportmanager.ReportManager
 */
public interface IReportManager {
  public int PrepareReport(String reportDefinitionID) throws InfoException;

  public int PrepareReport(String reportDefinitionId , Map paramValues) throws InfoException;

  public void ReleaseReport(int handle) throws InfoException;

  public void prepareReportSource(String reportSourceDefinitionId) throws InfoException;

  public Map getReportDefinitions() throws InfoException;

  public Map getReportSourceDefinitions() throws InfoException;

  public Map getReportsForEntity(String entityID) throws InfoException;

  public void ExecuteAction(int handle, String actionName, Object params) throws InfoException;

  public void saveReportDefinition(ReportDefinition reportDefinition) throws InfoException;

  public void saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition) throws InfoException;

  public void invalidateReportSource(String reportSourceDefinitionId) throws InfoException;

  public ReportQuery getReportQuery(int handle) throws InfoException;

  public ReportQuery getDefaultReportQuery(int handle) throws InfoException;

  public ReportQuery getReportQuery(String reportDefinitionId) throws InfoException;

  public ReportQuery getDefaultReportQuery(String reportDefinitionId) throws InfoException;

  public ReportResult ExecReportQuery(int handle, Map paramValues) throws InfoException;

  public ReportResult ExecReportQuery(int handle, ReportQuery query) throws InfoException;

  public ReportResult ExecReportQuery(String reportDefinitionID, Map paramValues) throws InfoException;

  public ReportResult ExecReportQuery(String reportDefinitionID, ReportQuery query) throws InfoException;

  public ReportQuery getDefaultReportQuery(int handle,String userID) throws InfoException;

  public Map getReportViews(String reportDefinitionID, String userID) throws InfoException;

  public Map getReportViews(String reportDefinitionID) throws InfoException;

  public ReportResult ExecReportQuery(int handle, String reportViewId) throws InfoException;

  public String getDefaultReportViewId(String reportDefinitionId, String userId) throws InfoException;

  public ReportSpec getReportSpec(String reportDefinitionId, String reportSourceDefId) throws InfoException;

  public ReportSpec getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException;

  public ReportSpec getReportSpec(String reportDefinitionId) throws InfoException;

  public ReportView getReportView(String reportViewId) throws InfoException;

  public void saveReportView(ReportView reportView) throws InfoException;

  public ReportView getReportViewFromID(String id,String reportDefinitionId,String userId) throws InfoException;

  public ReportResult ExecReportQuery(int handle, ReportView reportView) throws InfoException;

  public void registerDefinitions() throws InfoException;

  public Vector registerReportSourceDefinitions(Vector exceptions) throws InfoException;

  public Vector registerReportDefinitions(Vector exceptions) throws InfoException;

  public Vector registerReportViews(Vector exceptions) throws InfoException;

  public void deleteAllRepositories() throws InfoException;

  public void deleteAllDefinitions() throws InfoException;

  public void deleteReportSourceRepository() throws InfoException;

  public void deleteReportSourceDefinitionRepository() throws InfoException;

  public void deleteReportDefinitionRepository() throws InfoException;

  public void deleteReportViewRepository() throws InfoException;

  public void deleteReportView(String id, String reportDefinitionId, String userId) throws InfoException;

  public void deleteReportSource(String reportSourceDefinitionId) throws InfoException;

  public void deleteReportSourceDefinition(String reportSourceDefinitionID) throws InfoException;

  public void deleteReportDefinition(String reportDefinitionID) throws InfoException;

  public void assingDefaultView(String id, String reportDefinitionId, String userId) throws InfoException;

  public ReportResult ExecReportQuery(MicroReport microReport) throws InfoException;

  public int PrepareReport(MicroReport microReport) throws InfoException;

//  public ZipOutputStream getMicroReport(int reportHandle, ReportView reportView,String userID,String fileName) throws InfoException;

  public String getXML(int handle) throws InfoException;

  public String getXML(String reportDefinitionID, Map paramValues) throws InfoException;

  public Set getDimensionValues(int handle, String name) throws InfoException;

  public Set getDimensionValues(String reportDefinitionID, Map paramValues, String name) throws InfoException;

  public Vector getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) throws InfoException;

  public Matrix getMatrix(int handle) throws InfoException;

  public ReportDefinition getReportDefinitionFromID(String reportDefinitionId) throws InfoException;

  public ReportSourceDefinition getReportSourceDefinitionFromID(String reportSourceDefinitionId) throws InfoException;

  public void init(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException;

  public boolean validateUser(String userName, String password, String userRepositoryPath) throws InfoException;

  public void exportReport(String userName, String password,String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException;

  public boolean addNewUser(String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException;
  
  public byte[] exportReport(Map params) throws InfoException;  
  
}
