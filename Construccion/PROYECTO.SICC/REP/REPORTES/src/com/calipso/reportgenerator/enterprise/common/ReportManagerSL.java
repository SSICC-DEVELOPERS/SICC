package com.calipso.reportgenerator.enterprise.common;


import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.MicroReport;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportcalculator.Matrix;

import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.rmi.RemoteException;
import es.indra.mare.common.info.InfoException;



/**
 * Esta clase representa los métodos sobre los cuales opera el cliente
 * cuando interactúa con EJB objetcs. El EJB container implementará
 * esta interface; el objeto implementado es el EJB object, que es
 * el responsable de delegar las invocaciones al Bean Stateless determinado.
 * Las métodos correspondientes están implementados en ReportManager.
 * @see com.calipso.reportgenerator.reportmanager.ReportManager
 */

public interface ReportManagerSL extends javax.ejb.EJBObject{

  public int PrepareReport(ReportGeneratorConfiguration configuration, String reportDefinitionID) throws InfoException, RemoteException;

  public int PrepareReport(ReportGeneratorConfiguration configuration, String reportDefinitionId , Map paramValues) throws InfoException, RemoteException;

  public void ReleaseReport(ReportGeneratorConfiguration configuration, int handle) throws InfoException, RemoteException;

  public void prepareReportSource(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException, RemoteException;

  public Map getReportDefinitions(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public Map getReportSourceDefinitions(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public Map getReportsForEntity(ReportGeneratorConfiguration configuration, String entityID) throws InfoException, RemoteException;

  public void ExecuteAction(ReportGeneratorConfiguration configuration, int handle, String actionName, Object params) throws InfoException, RemoteException;

  public void saveReportDefinition(ReportGeneratorConfiguration configuration, ReportDefinition reportDefinition) throws InfoException, RemoteException;

  public void saveReportSourceDefinition(ReportGeneratorConfiguration configuration, ReportSourceDefinition reportSourceDefinition) throws InfoException, RemoteException;

  public void invalidateReportSource(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException, RemoteException;

  public ReportQuery getReportQuery(ReportGeneratorConfiguration configuration, int handle) throws InfoException, RemoteException;

  public ReportQuery getDefaultReportQuery(ReportGeneratorConfiguration configuration, int handle) throws InfoException, RemoteException;

  public ReportQuery getReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException, RemoteException;

  public ReportQuery getDefaultReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, Map paramValues) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, ReportQuery query) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionID, Map paramValues) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, String reportDefinitionID, ReportQuery query) throws InfoException, RemoteException;

  public ReportQuery getDefaultReportQuery(ReportGeneratorConfiguration configuration, int handle,String userID) throws InfoException, RemoteException;

  public Map getReportViews(ReportGeneratorConfiguration configuration, String reportDefinitionID, String userID) throws InfoException, RemoteException;

  public Map getReportViews(ReportGeneratorConfiguration configuration, String reportDefinitionID) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, String reportViewId) throws InfoException, RemoteException;

  public String getDefaultReportViewId(ReportGeneratorConfiguration configuration, String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public ReportSpec getReportSpec(ReportGeneratorConfiguration configuration, String reportDefinitionId, String reportSourceDefId) throws InfoException, RemoteException;

  public ReportSpec getReportSpec(ReportGeneratorConfiguration configuration, ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException, RemoteException;

  public ReportSpec getReportSpec(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException, RemoteException;

  public void registerDefinitions(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public Vector registerReportSourceDefinitions(ReportGeneratorConfiguration configuration, Vector vector) throws InfoException, RemoteException;

  public Vector registerReportDefinitions(ReportGeneratorConfiguration configuration, Vector vector) throws InfoException, RemoteException;

  public Vector registerReportViews(ReportGeneratorConfiguration configuration, Vector vector) throws InfoException, RemoteException;

  public void deleteAllRepositories(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public void deleteAllDefinitions(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public void deleteReportSourceRepository(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public void deleteReportSourceDefinitionRepository(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public void deleteReportDefinitionRepository(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public void deleteReportViewRepository(ReportGeneratorConfiguration configuration) throws InfoException, RemoteException;

  public void deleteReportView(ReportGeneratorConfiguration configuration, String id, String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public void deleteReportSource(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException, RemoteException;

  public void deleteReportSourceDefinition(ReportGeneratorConfiguration configuration, String reportSourceDefinitionID) throws InfoException, RemoteException;

  public void deleteReportDefinition(ReportGeneratorConfiguration configuration, String reportDefinitionID) throws InfoException, RemoteException;

  public void assingDefaultView(ReportGeneratorConfiguration configuration, String id, String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, MicroReport microReport) throws InfoException, RemoteException;

  public int PrepareReport(ReportGeneratorConfiguration configuration, MicroReport microReport) throws InfoException, RemoteException;

//  public ZipOutputStream getMicroReport(ReportGeneratorConfiguration configuration, int reportHandle, ReportView reportView,String userID,String fileName) throws InfoException, RemoteException;

  public String getXML(ReportGeneratorConfiguration configuration, int handle) throws InfoException, RemoteException;

  public String getXML(ReportGeneratorConfiguration configuration, String reportDefinitionID, Map paramValues) throws InfoException, RemoteException;

  public Set getDimensionValues(ReportGeneratorConfiguration configuration, int handle, String name) throws InfoException, RemoteException;

  public Set getDimensionValues(ReportGeneratorConfiguration configuration, String reportDefinitionID, Map paramValues, String name) throws InfoException, RemoteException;

  public Vector getUpdatedDataModel(ReportGeneratorConfiguration configuration, int handle, int mode, int row, int col, boolean isDistributed) throws InfoException, RemoteException;

  public ReportView getReportView(ReportGeneratorConfiguration configuration, String reportViewId) throws InfoException, RemoteException;

  public void saveReportView(ReportGeneratorConfiguration configuration, ReportView reportView) throws InfoException, RemoteException;

  public ReportView getReportViewFromID(ReportGeneratorConfiguration configuration, String id, String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(ReportGeneratorConfiguration configuration, int handle, ReportView reportView) throws InfoException, RemoteException;

  public Matrix getMatrix(ReportGeneratorConfiguration configuration, int handle) throws InfoException, RemoteException;

  public ReportDefinition getReportDefinitionFromID(ReportGeneratorConfiguration configuration, String reportDefinitionId) throws InfoException, RemoteException;

  public ReportSourceDefinition getReportSourceDefinitionFromID(ReportGeneratorConfiguration configuration, String reportSourceDefinitionId) throws InfoException, RemoteException;

  public boolean validateUser(ReportGeneratorConfiguration configuration, String userName, String password, String userRepositoryPath) throws InfoException, RemoteException;

  public void exportReport(ReportGeneratorConfiguration configuration, String userName, String password,String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException, RemoteException;

  public boolean addNewUser(ReportGeneratorConfiguration configuration, String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException, RemoteException;
  
  public byte[] exportReport(ReportGeneratorConfiguration configuration, Map params) throws InfoException, RemoteException;
  
  
}


