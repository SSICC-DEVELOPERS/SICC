package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.RemoteReportManager;
import com.calipso.reportgenerator.enterprise.common.ReportManagerSLHome;
import com.calipso.reportgenerator.enterprise.common.ReportManagerSL;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportcalculator.Matrix;
import es.indra.mare.common.info.InfoException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import java.text.MessageFormat;
import javax.naming.Context;
import javax.naming.InitialContext;


/**
 * Se crea solo cuando el EJB es de tipo Stateless.
 * Representa la capa entre el cliente y la aplicacion,
 * y presenta los metodos que el cliente podra invocar correspondientes al ReportManager
 * agregandole el throws InfoException por el contexto en el que se ejecuta.
 * @see com.calipso.reportgenerator.reportmanager.ReportManager
 *
 */

public class RemoteReportManagerStateLess extends RemoteReportManager {

  private ReportManagerSL reportManagerRemote;

  /**
   * Obtiene un ReportManagerSF.
   * @return el ReportManagerRemote correspondiente a la instancia de RemoteReportManagerStateFul
   */
  public ReportManagerSL getReportManagerRemote() throws InfoException {
    if (reportManagerRemote == null) {
      reportManagerRemote = newReportManagerRemote();
    }
    return reportManagerRemote;
  }

  /**
   * Crea un nuevo ReportManagerRemote, dicha instancia
   * servira para invocar los metodos heredados
   * @return el ReportManagerSF correspondiente de la instancia RemoteReportManagerStateful
   * @throws es.indra.mare.common.info.InfoException
   */
  private ReportManagerSL newReportManagerRemote() throws InfoException {
//    Hashtable env = System.getProperties();
//    System.setProperty("org.omg.CORBA.ORBInitialHost",getReportGeneratorConfiguration().getDistributedHost());
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY, getReportGeneratorConfiguration().getINITIAL_CONTEXT_FACTORY());
    env.put(Context.PROVIDER_URL, getHostName());
    env.put("java.naming.factory.url.pkgs", getReportGeneratorConfiguration().getJavaNamingFactoryUrlPkgs());
    try {
      Context ctx = new InitialContext(env);
      Object obj = ctx.lookup(getReportGeneratorConfiguration().getReportManagerEJB_SLName());
      ReportManagerSLHome home = (ReportManagerSLHome) javax.rmi.PortableRemoteObject.narrow(obj, ReportManagerSLHome.class);

      ReportManagerSL reportManager = home.create();
      return reportManager;
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("88"), e);
    }
  }

  /**
   * Obtiene el hostname de la máquina contra la cual
   * se invocara el metodo determinado
   * @return String que representa el host
   */
  protected String getHostName() {
    String hostName = "";
    hostName = getReportGeneratorConfiguration().getDistributedHost();
    if (getReportGeneratorConfiguration().getDistributedPort() != "") {
      hostName = hostName + ":" + getReportGeneratorConfiguration().getDistributedPort();
    }
    return hostName;
  }

  public RemoteReportManagerStateLess(ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(reportGeneratorConfiguration);
  }

  public int PrepareReport(String reportDefId, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().PrepareReport(getReportGeneratorConfiguration(), reportDefId, paramValues);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-PrepareReport(String reportDefId, Map paramValues)"}), e);
    }
  }

  public int PrepareReport(String reportDefinitionID) throws InfoException {
    try {
      return getReportManagerRemote().PrepareReport(getReportGeneratorConfiguration(), reportDefinitionID);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-PrepareReport(String reportDefinitionID)"}), e);
    }
  };
  public void ReleaseReport(int handle) throws InfoException {
    try {
      getReportManagerRemote().ReleaseReport(getReportGeneratorConfiguration(), handle);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-ReleaseReport(int handle)"}), e);
    }
  }

  public void prepareReportSource(String reportSourceDefinitionId) throws InfoException {
    try {
      getReportManagerRemote().prepareReportSource(getReportGeneratorConfiguration(), reportSourceDefinitionId);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-prepareReportSource(String reportSourceDefinitionId) "}), e);
    }

  }

  public Map getReportDefinitions() throws InfoException {
    try {
      return getReportManagerRemote().getReportDefinitions(getReportGeneratorConfiguration());
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getReportDefinitions() "}), e);
    }
  }

  public Map getReportSourceDefinitions() throws InfoException {
    try {
      return getReportManagerRemote().getReportSourceDefinitions(getReportGeneratorConfiguration());
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getReportSourceDefinitions() "}), e);
    }
  }

  public Map getReportsForEntity(String entityID) throws InfoException {
    try {
      return getReportManagerRemote().getReportsForEntity(getReportGeneratorConfiguration(), entityID);
    }
     catch (RemoteException e) {
       throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getReportsForEntity(String entityID) "}), e);
    }
  }

  public void ExecuteAction(int handle, String actionName, Object params) throws InfoException {
    try {
      getReportManagerRemote().ExecuteAction(getReportGeneratorConfiguration(), handle, actionName, params);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-ExecuteAction(int handle, String actionName, Object params) "}), e);
    }
  }

  public void saveReportDefinition(ReportDefinition reportDefinition) throws InfoException {
    try {
      getReportManagerRemote().saveReportDefinition(getReportGeneratorConfiguration(), reportDefinition);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-saveReportDefinition(ReportDefinition reportDefinition) "}), e);
    }
  }


  public void saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition) throws InfoException {
    try {
      getReportManagerRemote().saveReportSourceDefinition(getReportGeneratorConfiguration(), reportSourceDefinition);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition) "}), e);
    }
  }

  public void invalidateReportSource(String reportSourceDefinitionId) throws InfoException {
    try {
      getReportManagerRemote().invalidateReportSource(getReportGeneratorConfiguration(), reportSourceDefinitionId);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-invalidateReportSource(String reportSourceDefinitionId) "}), e);
    }
  }

  public ReportQuery getReportQuery(int handle) throws InfoException {
    try {
      return getReportManagerRemote().getReportQuery(getReportGeneratorConfiguration(), handle);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getReportQuery(int handle) "}), e);
    }
  }

  public ReportQuery getDefaultReportQuery(int handle) throws InfoException {
    try {
      return getReportManagerRemote().getDefaultReportQuery(getReportGeneratorConfiguration(), handle);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getDefaultReportQuery(int handle) "}), e);
    }
  }

  public ReportQuery getReportQuery(String reportDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getReportQuery(getReportGeneratorConfiguration(), reportDefinitionId);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getReportQuery(String reportDefinitionId) "}), e);
    }
  }

  public ReportQuery getDefaultReportQuery(String reportDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getDefaultReportQuery(getReportGeneratorConfiguration(), reportDefinitionId);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getDefaultReportQuery(String reportDefinitionId) "}), e);
    }
  }

  public ReportResult ExecReportQuery(int handle, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(getReportGeneratorConfiguration(), handle, paramValues);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-ExecReportQuery(int handle, Map paramValues)"}), e);
    }
  }

  public ReportResult ExecReportQuery(int handle, ReportQuery query) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(getReportGeneratorConfiguration(), handle, query);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-ExecReportQuery(int handle, ReportQuery query)"}), e);
    }
  }

  public ReportResult ExecReportQuery(String reportDefinitionID, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(getReportGeneratorConfiguration(), reportDefinitionID, paramValues);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-ExecReportQuery(String reportDefinitionID, Map paramValues) "}), e);
    }
  }

  public ReportResult ExecReportQuery(String reportDefinitionID, ReportQuery query) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(getReportGeneratorConfiguration(), reportDefinitionID, query);
    }
     catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-ExecReportQuery(String reportDefinitionID, ReportQuery query)"}), e);
    }
  }

  public ReportQuery getDefaultReportQuery(int handle,String userID) throws InfoException{
    try {
      return getReportManagerRemote().getDefaultReportQuery(getReportGeneratorConfiguration(), handle, userID);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getDefaultReportQuery(int handle,String userID)"}), e);
    }
  };

  public Map getReportViews(String reportDefinitionID, String userID) throws InfoException{
    try {
      return getReportManagerRemote().getReportViews(getReportGeneratorConfiguration(), reportDefinitionID, userID);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getReportViews(String reportDefinitionID, String userID)"}), e);
    }
  };

  public Map getReportViews(String reportDefinitionID) throws InfoException{
    try {
      return getReportManagerRemote().getReportViews(getReportGeneratorConfiguration(), reportDefinitionID);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-getReportViews(String reportDefinitionID)"}), e);
    }
  };

  public ReportResult ExecReportQuery(int handle, String reportViewId) throws InfoException{
    try {
      return getReportManagerRemote().ExecReportQuery(getReportGeneratorConfiguration(), handle, reportViewId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateless-ExecReportQuery(int handle, String reportViewId)"}), e);
    }
  };

  public ReportSpec getReportSpec(String reportDefinitionId, String reportSourceDefId) throws InfoException {
    try {
      return getReportManagerRemote().getReportSpec(getReportGeneratorConfiguration(), reportDefinitionId, reportSourceDefId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getReportSpec(String reportDefinitionId, String reportSourceDefId)"}), e);
    }
  }

  public ReportSpec getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException {
    try {
      return getReportManagerRemote().getReportSpec(getReportGeneratorConfiguration(), reportDefinition, reportSourceDef);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef)"}), e);
    }
  }

  public ReportSpec getReportSpec(String reportDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getReportSpec(getReportGeneratorConfiguration(), reportDefinitionId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getReportSpec(String reportDefinitionId)"}), e);
    }
  }

  public ReportView getReportView(String reportViewId) throws InfoException {
    try {
      return getReportManagerRemote().getReportView(getReportGeneratorConfiguration(), reportViewId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getReportView(String reportViewId)"}), e);
    }
  }

  public void saveReportView(ReportView reportView) throws InfoException {
    try {
      getReportManagerRemote().saveReportView(getReportGeneratorConfiguration(), reportView);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-saveReportView(ReportView reportView)"}), e);
    }
  }

  public ReportView getReportViewFromID(String id, String reportDefinitionId, String userId) throws InfoException {
    try {
      return getReportManagerRemote().getReportViewFromID(getReportGeneratorConfiguration(), id, reportDefinitionId, userId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getReportViewFromID(String id, String reportDefinitionId, String userId)"}), e);
    }
  }

  public ReportResult ExecReportQuery(int handle, ReportView reportView) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(getReportGeneratorConfiguration(), handle, reportView);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-ExecReportQuery(int handle, ReportView reportView)"}), e);
    }
  }

  public void registerDefinitions() throws InfoException {
    try {
      getReportManagerRemote().registerDefinitions(getReportGeneratorConfiguration());
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-registerDefinitions()"}), e);
    }
  }

  public void deleteAllRepositories() throws InfoException {
    try {
      getReportManagerRemote().deleteAllRepositories(getReportGeneratorConfiguration());
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteAllRepositories()"}), e);
    }
  }

  public void deleteAllDefinitions() throws InfoException {
    try {
      getReportManagerRemote().deleteAllDefinitions(getReportGeneratorConfiguration());
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteAllDefinitions()"}), e);
    }
  }

  public void deleteReportSourceRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportSourceRepository(getReportGeneratorConfiguration());
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportSourceRepository()"}), e);
    }
  }

  public void deleteReportSourceDefinitionRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportSourceDefinitionRepository(getReportGeneratorConfiguration());
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportSourceDefinitionRepository()"}), e);
    }
  }

  public void deleteReportDefinitionRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportDefinitionRepository(getReportGeneratorConfiguration());
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportDefinitionRepository()"}), e);
    }
  }

  public void deleteReportViewRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportViewRepository(getReportGeneratorConfiguration());
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportViewRepository()"}), e);
    }
  }

  public void deleteReportView(String id, String reportDefinitionId, String userId) throws InfoException {
    try {
      getReportManagerRemote().deleteReportView(getReportGeneratorConfiguration(), id,reportDefinitionId,userId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportView(String id, String reportDefinitionId, String userId)"}), e);
    }
  }

  public void deleteReportSource(String reportSourceDefinitionId) throws InfoException {
    try {
      getReportManagerRemote().deleteReportSource(getReportGeneratorConfiguration(), reportSourceDefinitionId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportSource(String reportSourceDefinitionId)"}), e);
    }
  }

  public void deleteReportSourceDefinition(String reportSourceDefinitionID) throws InfoException {
    try {
      getReportManagerRemote().deleteReportSourceDefinition(getReportGeneratorConfiguration(), reportSourceDefinitionID);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportSourceDefinition(String reportSourceDefinitionID)"}), e);
    }
  }

  public void deleteReportDefinition(String reportDefinitionID) throws InfoException {
    try {
      getReportManagerRemote().deleteReportDefinition(getReportGeneratorConfiguration(), reportDefinitionID);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-deleteReportDefinition(String reportDefinitionID)"}), e);
    }
  }

  public void assingDefaultView(String id, String reportDefinitionId, String userId) throws InfoException {
    try {
      getReportManagerRemote().assingDefaultView(getReportGeneratorConfiguration(), id, reportDefinitionId, userId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-assingDefaultView(String id, String reportDefinitionId, String userId)"}), e);
    }
  }

  public ReportResult ExecReportQuery(MicroReport microReport) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(getReportGeneratorConfiguration(), microReport);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-ExecReportQuery(MicroReport microReport)"}), e);
    }
  }

  public int PrepareReport(MicroReport microReport) throws InfoException {
    try {
      return getReportManagerRemote().PrepareReport(getReportGeneratorConfiguration(), microReport);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-PrepareReport(MicroReport microReport)"}), e);
    }
  }

    public String getXML(int handle) throws InfoException {
    try {
      return getReportManagerRemote().getXML(getReportGeneratorConfiguration(), handle);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getXML(int handle)"}), e);
    }

  }

  public String getXML(String reportDefinitionID, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().getXML(getReportGeneratorConfiguration(), reportDefinitionID,paramValues);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getXML(String reportDefinitionID, Map paramValues)"}), e);
    }
  }

  public Set getDimensionValues(int handle, String name) throws InfoException {
    try {
      return getReportManagerRemote().getDimensionValues(getReportGeneratorConfiguration(), handle,name);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getDimensionValues(int handle, String name)"}), e);
    }

  }

  public Set getDimensionValues(String reportDefinitionID, Map paramValues, String name) throws InfoException {
    try {
      return getReportManagerRemote().getDimensionValues(getReportGeneratorConfiguration(), reportDefinitionID,paramValues,name);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getDimensionValues(String reportDefinitionID, Map paramValues, String name)"}), e);
    }
  }

  public Vector getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) throws InfoException {
    try {
      return getReportManagerRemote().getUpdatedDataModel(getReportGeneratorConfiguration(), handle, mode, row, col, isDistributed);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) "}), e);
    }
  }

  public Matrix getMatrix(int handle) throws InfoException {
    try {
      return getReportManagerRemote().getMatrix(getReportGeneratorConfiguration(), handle);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getMatrix(int handle) "}), e);
    }
  }

  public ReportDefinition getReportDefinitionFromID(String reportDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getReportDefinitionFromID(getReportGeneratorConfiguration(), reportDefinitionId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getReportDefinitionFromID(String reportDefinitionId) "}), e);
    }
  }

  public ReportSourceDefinition getReportSourceDefinitionFromID(String reportSourceDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getReportSourceDefinitionFromID(getReportGeneratorConfiguration(), reportSourceDefinitionId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getReportSourceDefinitionFromID(String reportSourceDefinitionId) "}), e);
    }
  }

  public void init(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
  }

  public boolean validateUser(String userName, String password, String userRepositoryPath) throws InfoException {
    try {
      return getReportManagerRemote().validateUser(getReportGeneratorConfiguration(), userName, password, userRepositoryPath);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-validateUser()) "}), e);
    }
  }

  public void exportReport(String userName, String password, String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException {
    try {
      getReportManagerRemote().exportReport(getReportGeneratorConfiguration(), userName, password, userRepositoryPath, reportDefinitionId, paramValues, isLandscape, type, destinationPath, name);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-exportReport()) "}), e);
    }

  }

  public boolean addNewUser(String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException {
    try {
      return getReportManagerRemote().addNewUser(getReportGeneratorConfiguration(), rootPasswd, userName, password, userRepositoryPath);
    } catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-addNewUser()) "}), e);
    }
  }

/*  public ZipOutputStream getMicroReport(int reportHandle, ReportView reportView, String userID, String fileName) throws InfoException {
    try {
      return getReportManagerRemote().getMicroReport(reportHandle,reportView,userID,fileName);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getMicroReport(int reportHandle, ReportView reportView, String userID, String fileName)"}), e);
    }
  }
  */
  public Vector registerReportSourceDefinitions(Vector vector) throws InfoException {
    try {
      return getReportManagerRemote().registerReportSourceDefinitions(getReportGeneratorConfiguration(), vector);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-registerReportSourceDefinitions()"}), e);
    }
  }

  public Vector registerReportDefinitions(Vector vector) throws InfoException {
    try {
      return getReportManagerRemote().registerReportDefinitions(getReportGeneratorConfiguration(), vector);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-registerReportDefinitions()"}), e);
    }
  }


  public Vector registerReportViews(Vector vector) throws InfoException {
    try {
      return getReportManagerRemote().registerReportViews(getReportGeneratorConfiguration(), vector);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-registerReportViews()"}), e);
    }
  }

  public String getDefaultReportViewId(String reportDefinitionId, String userId) throws InfoException {
    try {
      return getReportManagerRemote().getDefaultReportViewId(getReportGeneratorConfiguration(), reportDefinitionId,userId);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateLess-getDefaultReportViewId(String reportDefinitionId, String userId)"}), e);
    }
  }

  public byte[] exportReport(Map params) throws InfoException {
    try {
      return getReportManagerRemote().exportReport(getReportGeneratorConfiguration(), params);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateLess-exportReport()) "}, e);
    }
  }
  

}
