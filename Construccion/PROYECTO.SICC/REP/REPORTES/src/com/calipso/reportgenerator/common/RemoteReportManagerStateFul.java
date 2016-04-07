package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.RemoteReportManager;
import com.calipso.reportgenerator.enterprise.common.ReportManagerSFHome;
import com.calipso.reportgenerator.enterprise.common.ReportManagerSF;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportcalculator.Matrix;
import es.indra.mare.common.info.InfoException;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import java.io.Serializable;

/**
 * Se crea solo cuando el EJB es de tipo Stateful.
 * Representa la capa entre el cliente y la aplicación,
 * y presenta los métodos que el cliente podra invocar correspondientes al ReportManager
 * agregándole el throws InfoException por el contexto en el que se ejecuta.
 * @see com.calipso.reportgenerator.reportmanager.ReportManager
 *
 */

public class RemoteReportManagerStateFul extends RemoteReportManager implements Serializable{
  private ReportManagerSF reportManagerRemote;

  /**
   * Inicializa el RemoteReportManager con la configuración correspondiente
   * @param reportGeneratorConfiguration
   */
  public RemoteReportManagerStateFul(ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(reportGeneratorConfiguration);
  }

  /**
   * Obtiene un ReportManagerSF creándolo si es necesario.
   * @return el ReportManagerRemote correspondiente a la instancia de RemoteReportManagerStateFul
   */
  public ReportManagerSF getReportManagerRemote() throws InfoException {
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
  private ReportManagerSF newReportManagerRemote() throws InfoException {
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY, getReportGeneratorConfiguration().getINITIAL_CONTEXT_FACTORY());
    env.put(Context.PROVIDER_URL, getHostName());
    env.put("java.naming.factory.url.pkgs", getReportGeneratorConfiguration().getJavaNamingFactoryUrlPkgs());
    try {
      Context ctx = new InitialContext(env);
      Object obj = ctx.lookup(getReportGeneratorConfiguration().getReportManagerEJB_SFName());
      ReportManagerSFHome home = (ReportManagerSFHome) javax.rmi.PortableRemoteObject.narrow(obj, ReportManagerSFHome.class);

      ReportManagerSF reportManager = home.create(getReportGeneratorConfiguration());
      return reportManager;
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("78"), e);
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

  public int PrepareReport(String reportDefId) throws InfoException {
    try {
      return getReportManagerRemote().PrepareReport(reportDefId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-PrepareReport(String reportDefId)"}, e);
    }
  }

  public int PrepareReport(String reportDefId, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().PrepareReport(reportDefId, paramValues);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-PrepareReport(String reportDefId, Map paramValues)"}, e);
    }
  }

  public void ReleaseReport(int handle) throws InfoException {
    try {
      getReportManagerRemote().ReleaseReport(handle);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ReleaseReport(int handle)"}, e);
    }
  }

  public void prepareReportSource(String reportSourceDefinitionId) throws InfoException {
    try {
      getReportManagerRemote().prepareReportSource(reportSourceDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-prepareReportSource(String reportSourceDefinitionId)"}, e);
    }
  }

  public Map getReportDefinitions() throws InfoException {
    try {
      return getReportManagerRemote().getReportDefinitions();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportDefinitions()"}, e);
    }
  }

  public Map getReportSourceDefinitions() throws InfoException {
    try {
      return getReportManagerRemote().getReportSourceDefinitions();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportSourceDefinitions()"}, e);
    }
  }

  public Map getReportsForEntity(String entityID) throws InfoException {
    try {
      return getReportManagerRemote().getReportsForEntity(entityID);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportsForEntity(String entityID)"}, e);
    }
  }

  public void ExecuteAction(int handle, String actionName, Object params) throws InfoException {
    try {
      getReportManagerRemote().ExecuteAction(handle, actionName, params);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ExecuteAction(int handle, String actionName, Object params)"}, e);
    }
  }

  public void saveReportDefinition(ReportDefinition reportDefinition) throws InfoException {
    try {
      getReportManagerRemote().saveReportDefinition(reportDefinition);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"),"RemoteReportManagerStateful-saveReportDefinition(ReportDefinition reportDefinition)"}, e);
    }
  }

  public void saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition) throws InfoException {
    try {
      getReportManagerRemote().saveReportSourceDefinition(reportSourceDefinition);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition)"}, e);
    }
  }

  public void invalidateReportSource(String reportSourceDefinitionId) throws InfoException {
    try {
      getReportManagerRemote().invalidateReportSource(reportSourceDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"),"RemoteReportManagerStateful-invalidateReportSource(String reportSourceDefinitionId)"}, e);
    }
  }

  public ReportQuery getReportQuery(int handle) throws InfoException{
    try {
      return getReportManagerRemote().getReportQuery(handle);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportQuery(int handle)"}, e);
    }
  }

  public ReportQuery getDefaultReportQuery(int handle) throws InfoException {
    try {
      return getReportManagerRemote().getDefaultReportQuery(handle);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getDefaultReportQuery(int handle)"}, e);
    }
  }

  public ReportQuery getReportQuery(String reportDefinitionId) throws InfoException{
    try {
      return getReportManagerRemote().getReportQuery(reportDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportQuery(String reportDefinitionId)"}, e);
    }
  }

  public ReportQuery getDefaultReportQuery(String reportDefinitionId) throws InfoException{
    try {
      return getReportManagerRemote().getDefaultReportQuery(reportDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getDefaultReportQuery(String reportDefinitionId)"}, e);
    }
  }

  public ReportResult ExecReportQuery(int handle, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(handle, paramValues);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"),"RemoteReportManagerStateful-ExecReportQuery(int handle, Map paramValues)"}, e);
    }
  }

  public ReportResult ExecReportQuery(int handle, ReportQuery query) throws InfoException{
    try {
      return getReportManagerRemote().ExecReportQuery(handle, query);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ExecReportQuery(int handle, ReportQuery query)"}, e);
    }
  }

  public ReportResult ExecReportQuery(String reportDefinitionID, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(reportDefinitionID, paramValues);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ExecReportQuery(String reportDefinitionID, Map paramValues)"}, e);
    }
  }


  public ReportResult ExecReportQuery(String reportDefId, ReportQuery query) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(reportDefId, query);
    }
    catch (RemoteException e) {
     throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ExecReportQuery(String reportDefId, ReportQuery query)"}, e);
    }
  }

  public ReportQuery getDefaultReportQuery(int handle,String userID) throws InfoException{
    try {
      return getReportManagerRemote().getDefaultReportQuery(handle, userID);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getDefaultReportQuery(int handle,String userID)"}, e);
    }
  };

  public Map getReportViews(String reportDefinitionID, String userID) throws InfoException{
    try {
      return getReportManagerRemote().getReportViews(reportDefinitionID, userID);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportViews(String reportDefinitionID, String userID)"}, e);
    }
  };

  public Map getReportViews(String reportDefinitionID) throws InfoException{
    try {
      return getReportManagerRemote().getReportViews(reportDefinitionID);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportViews(String reportDefinitionID)"}, e);
    }
  };

  public ReportResult ExecReportQuery(int handle, String reportViewId) throws InfoException{
    try {
      return getReportManagerRemote().ExecReportQuery(handle, reportViewId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ExecReportQuery(int handle, String reportViewId)"}, e);
    }
  };

  public ReportSpec getReportSpec(String reportDefinitionId, String reportSourceDefId) throws InfoException {
    try {
      return getReportManagerRemote().getReportSpec(reportDefinitionId, reportSourceDefId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportSpec(String reportDefinitionId, String reportSourceDefId)"}, e);
    }
  }

  public ReportSpec getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException {
    try {
      return getReportManagerRemote().getReportSpec(reportDefinition, reportSourceDef);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef)"}, e);
    }
  }

  public ReportSpec getReportSpec(String reportDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getReportSpec(reportDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportSpec(String reportDefinitionId)"}, e);
    }
  }

  public ReportView getReportView(String reportViewId) throws InfoException {
    try {
      return getReportManagerRemote().getReportView(reportViewId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportView(String reportViewId)"}, e);
    }
  }

  public void saveReportView(ReportView reportView) throws InfoException {
    try {
      getReportManagerRemote().saveReportView(reportView);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-saveReportView(ReportView reportView)"}, e);
    }
  }

  public ReportView getReportViewFromID(String id, String reportDefinitionId, String userId) throws InfoException {
    try {
      return getReportManagerRemote().getReportViewFromID(id, reportDefinitionId, userId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportViewFromID(String id, String reportDefinitionId, String userId)"}, e);
    }
  }

  public ReportResult ExecReportQuery(int handle, ReportView reportView) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(handle, reportView);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ExecReportQuery(int handle, ReportView reportView)"}, e);
    }
  }

  public void registerDefinitions() throws InfoException {
    try {
      getReportManagerRemote().registerDefinitions();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-registerDefinitions()"}, e);
    }
  }

  public void deleteAllRepositories() throws InfoException {
    try {
      getReportManagerRemote().deleteAllRepositories();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteAllRepositories()"}, e);
    }
  }

  public void deleteAllDefinitions() throws InfoException {
    try {
      getReportManagerRemote().deleteAllDefinitions();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteAllDefinitions()"}, e);
    }
  }

  public void deleteReportSourceRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportSourceRepository();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportSourceRepository()"}, e);
    }
  }

  public void deleteReportSourceDefinitionRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportSourceDefinitionRepository();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportSourceDefinitionRepository()"}, e);
    }
  }

  public void deleteReportDefinitionRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportDefinitionRepository();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportDefinitionRepository()"}, e);
    }
  }

  public void deleteReportViewRepository() throws InfoException {
    try {
      getReportManagerRemote().deleteReportViewRepository();
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportViewRepository()"}, e);
    }
  }

  public void deleteReportView(String id, String reportDefinitionId, String userId) throws InfoException {
    try {
      getReportManagerRemote().deleteReportView(id,reportDefinitionId,userId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportView(String id, String reportDefinitionId, String userId)"}, e);
    }
  }

  public void deleteReportSource(String reportSourceDefinitionId) throws InfoException {
    try {
      getReportManagerRemote().deleteReportSource(reportSourceDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportSource(String reportSourceDefinitionId)"}, e);
    }
  }

  public void deleteReportSourceDefinition(String reportSourceDefinitionID) throws InfoException {
    try {
      getReportManagerRemote().deleteReportSourceDefinition(reportSourceDefinitionID);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportSourceDefinition(String reportSourceDefinitionID)"}, e);
    }
  }

  public void deleteReportDefinition(String reportDefinitionID) throws InfoException {
    try {
      getReportManagerRemote().deleteReportDefinition(reportDefinitionID);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-deleteReportDefinition(String reportDefinitionID)"}, e);
    }
  }

  public void assingDefaultView(String id, String reportDefinitionId, String userId) throws InfoException {
    try {
      getReportManagerRemote().assingDefaultView(id, reportDefinitionId, userId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-assingDefaultView(String id, String reportDefinitionId, String userId)"}, e);
    }
  }

  public ReportResult ExecReportQuery(MicroReport microReport) throws InfoException {
    try {
      return getReportManagerRemote().ExecReportQuery(microReport);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-ExecReportQuery(MicroReport microReport)"}, e);
    }
  }

  public int PrepareReport(MicroReport microReport) throws InfoException {
    try {
      return getReportManagerRemote().PrepareReport(microReport);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-PrepareReport(MicroReport microReport)"}, e);
    }

  }

    public String getXML(int handle) throws InfoException {
    try {
      return getReportManagerRemote().getXML(handle);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getXML(int handle)"}, e);
    }

  }

  public String getXML(String reportDefinitionID, Map paramValues) throws InfoException {
    try {
      return getReportManagerRemote().getXML(reportDefinitionID,paramValues);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getXML(String reportDefinitionID, Map paramValues)"}, e);
    }
  }

  public Set getDimensionValues(int handle, String name) throws InfoException {
    try {
      return getReportManagerRemote().getDimensionValues(handle,name);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getDimensionValues(int handle, String name)"}, e);
    }

  }

  public Set getDimensionValues(String reportDefinitionID, Map paramValues, String name) throws InfoException {
    try {
      return getReportManagerRemote().getDimensionValues(reportDefinitionID,paramValues,name);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getDimensionValues(String reportDefinitionID, Map paramValues, String name)"}, e);
    }
 }

  public Vector getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) throws InfoException {
    try {
      return getReportManagerRemote().getUpdatedDataModel(handle,mode,row,col, isDistributed);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) "}, e);
    }
  }

  public Matrix getMatrix(int handle) throws InfoException {
    try {
      return getReportManagerRemote().getMatrix(handle);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getMatrix(int handle) "}, e);
    }

  }

  public ReportDefinition getReportDefinitionFromID(String reportDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getReportDefinitionFromID(reportDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportDefinitionFromID(String reportDefinitionId) "}, e);
    }
  }

  public ReportSourceDefinition getReportSourceDefinitionFromID(String reportSourceDefinitionId) throws InfoException {
    try {
      return getReportManagerRemote().getReportSourceDefinitionFromID(reportSourceDefinitionId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getReportSourceDefinitionFromID(String reportSourceDefinitionId) "}, e);
    }
  }

  public void init(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
  }

  public boolean validateUser(String userName, String password, String userRepositoryPath) throws InfoException {
    try {
      return getReportManagerRemote().validateUser(userName, password, userRepositoryPath);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-validateUser()) "}, e);
    }
  }

  public void exportReport(String userName, String password, String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException {
    try {
      getReportManagerRemote().exportReport(userName, password, userRepositoryPath, reportDefinitionId, paramValues, isLandscape, type, destinationPath, name);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-exportReport()) "}, e);
    }

  }

  public boolean addNewUser(String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException {
    try {
      return getReportManagerRemote().addNewUser(rootPasswd, userName, password, userRepositoryPath);
    } catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-addNewUser()) "}, e);
    }
  }

/*  public ZipOutputStream getMicroReport(int reportHandle, ReportView reportView, String userID, String fileName) throws InfoException {
    try {
      return getReportManagerRemote().getMicroReport(reportHandle,reportView,userID,fileName);
    }
    catch (RemoteException e) {
      throw new InfoException(MessageFormat.format((LanguageTraslator.traslate("87")), new Object[]{"RemoteReportManagerStateful-getMicroReport(int reportHandle, ReportView reportView, String userID, String fileName)"}), e);
    }
  }
  */
  public Vector registerReportSourceDefinitions(Vector vector) throws InfoException {
    try {
      return getReportManagerRemote().registerReportSourceDefinitions(vector);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-registerReportSourceDefinitions()"}, e);
    }

  }

  public Vector registerReportDefinitions(Vector vector) throws InfoException {
    try {
      return getReportManagerRemote().registerReportDefinitions(vector);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-registerReportDefinitions()"}, e);
    }
  }


  public Vector registerReportViews(Vector vector) throws InfoException {
    try {
      return getReportManagerRemote().registerReportViews(vector);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"),"RemoteReportManagerStateful-registerReportViews()"}, e);
    }

  }

  public String getDefaultReportViewId(String reportDefinitionId, String userId) throws InfoException {
    try {
      return getReportManagerRemote().getDefaultReportViewId(reportDefinitionId,userId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getDefaultReportViewId(String reportDefinitionId, String userId)"}, e);
    }
  }
  
  public String execute(String reportDefinitionId, String userId) throws InfoException {
    try {
      return getReportManagerRemote().getDefaultReportViewId(reportDefinitionId,userId);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-getDefaultReportViewId(String reportDefinitionId, String userId)"}, e);
    }
  }

  public byte[] exportReport(Map params) throws InfoException {
    try {
      return getReportManagerRemote().exportReport(params);
    }
    catch (RemoteException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("87"), "RemoteReportManagerStateful-exportReport()) "}, e);
    }
  }


}

