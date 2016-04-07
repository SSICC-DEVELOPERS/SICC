package com.calipso.reportgenerator.enterprise.common;

import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.MicroReport;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.rmi.RemoteException;
import es.indra.mare.common.info.InfoException;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportcalculator.Matrix;

/**
 * Esta clase presenta los métodos sobre los cuales opera el cliente
 * cuando interactúa con EJB objetcs. El EJB container implementará
 * esta interface; el objeto implementado es el EJB object, que es
 * el responsable de delegar las invocaciones al Bean Stateful determinado.
 * Los métodos implementados corresponden a la clase ReportManager
 * @see com.calipso.reportgenerator.reportmanager.ReportManager
 */

public interface ReportManagerSF extends javax.ejb.EJBObject {

  public int PrepareReport(String reportDefinitionID) throws InfoException, RemoteException;

  public int PrepareReport(String reportDefinitionId , Map paramValues) throws InfoException, RemoteException;

  public void ReleaseReport(int handle) throws InfoException, RemoteException;


  public void prepareReportSource(String reportSourceDefinitionId) throws InfoException, RemoteException;

  public Map getReportDefinitions() throws InfoException, RemoteException;

  public Map getReportSourceDefinitions() throws InfoException, RemoteException;

  public Map getReportsForEntity(String entityID) throws InfoException, RemoteException;

  public void ExecuteAction(int handle, String actionName, Object params) throws InfoException, RemoteException;

  public void invalidateReportSource(String reportSourceDefinitionId) throws InfoException, RemoteException;

  public ReportQuery getReportQuery(int handle) throws InfoException, RemoteException;

  public ReportQuery getDefaultReportQuery(int handle) throws InfoException, RemoteException;

  public ReportQuery getReportQuery(String reportDefinitionId) throws InfoException, RemoteException;

  public ReportQuery getDefaultReportQuery(String reportDefinitionId) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(int handle, Map paramValues) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(int handle, ReportQuery query) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(String reportDefinitionID, Map paramValues) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(String reportDefinitionID, ReportQuery query) throws InfoException, RemoteException;

  public ReportQuery getDefaultReportQuery(int handle,String userID) throws InfoException, RemoteException;

  public Map getReportViews(String reportDefinitionID, String userID) throws InfoException, RemoteException;

  public Map getReportViews(String reportDefinitionID) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(int handle, String reportViewId) throws InfoException, RemoteException;

  public String getDefaultReportViewId(String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public ReportSpec getReportSpec(String reportDefinitionId, String reportSourceDefId) throws InfoException, RemoteException;

  public ReportSpec getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException, RemoteException;

  public ReportSpec getReportSpec(String reportDefinitionId) throws InfoException, RemoteException;

  public void registerDefinitions() throws InfoException, RemoteException;

  public Vector registerReportSourceDefinitions(Vector vector) throws InfoException, RemoteException;

  public Vector registerReportDefinitions(Vector vector) throws InfoException, RemoteException;

  public Vector registerReportViews(Vector vector) throws InfoException, RemoteException;

  public void deleteAllRepositories() throws InfoException, RemoteException;

  public void deleteAllDefinitions() throws InfoException, RemoteException;

  public void deleteReportSourceRepository() throws InfoException, RemoteException;

  public void deleteReportSourceDefinitionRepository() throws InfoException, RemoteException;

  public void deleteReportDefinitionRepository() throws InfoException, RemoteException;

  public void deleteReportViewRepository() throws InfoException, RemoteException;

  public void deleteReportView(String id, String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public void deleteReportSource(String reportSourceDefinitionId) throws InfoException, RemoteException;

  public void deleteReportSourceDefinition(String reportSourceDefinitionID) throws InfoException, RemoteException;

  public void deleteReportDefinition(String reportDefinitionID) throws InfoException, RemoteException;

  public void assingDefaultView(String id, String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(MicroReport microReport) throws InfoException, RemoteException;

  public int PrepareReport(MicroReport microReport) throws InfoException, RemoteException;

//  public ZipOutputStream getMicroReport(int reportHandle, ReportView reportView,String userID,String fileName) throws InfoException, RemoteException;

  public String getXML(int handle) throws InfoException, RemoteException;

  public String getXML(String reportDefinitionID, Map paramValues) throws InfoException, RemoteException;

  public Set getDimensionValues(int handle, String name) throws InfoException, RemoteException;

  public Set getDimensionValues(String reportDefinitionID, Map paramValues, String name) throws InfoException, RemoteException;

  public Vector getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) throws InfoException, RemoteException;

  public ReportView getReportView(String reportViewId) throws InfoException, RemoteException;

  public void saveReportView(ReportView reportView) throws InfoException, RemoteException;

  public ReportView getReportViewFromID(String id, String reportDefinitionId, String userId) throws InfoException, RemoteException;

  public ReportResult ExecReportQuery(int handle, ReportView reportView) throws InfoException, RemoteException;

  public void saveReportDefinition(ReportDefinition reportDefinition) throws InfoException, RemoteException;

  public void saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition) throws InfoException, RemoteException;

  public Matrix getMatrix(int handle) throws InfoException, RemoteException;

  public ReportDefinition getReportDefinitionFromID(String reportDefinitionId) throws InfoException, RemoteException;

  public ReportSourceDefinition getReportSourceDefinitionFromID(String reportSourceDefinitionId) throws InfoException, RemoteException;

  public boolean validateUser(String userName, String password, String userRepositoryPath) throws InfoException, RemoteException;
  
  public void exportReport(String userName, String password,String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException, RemoteException;

  public boolean addNewUser(String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException, RemoteException;
  
  public byte[] exportReport(Map params) throws InfoException, RemoteException;
  
}


