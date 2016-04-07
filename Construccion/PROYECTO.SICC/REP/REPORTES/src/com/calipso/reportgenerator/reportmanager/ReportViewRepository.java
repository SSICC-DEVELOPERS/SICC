package com.calipso.reportgenerator.reportmanager;


import com.calipso.reportgenerator.common.DefinitionInfo;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.MultipleStringInfoException;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.VersionProperties;
import com.calipso.reportgenerator.reportdefinitions.ReportView;

import es.indra.mare.common.info.InfoException;

import java.io.IOException;
import java.io.Serializable;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;

/**
 * Repositorio de vistas de reportes
 */
public class ReportViewRepository extends Repository implements Serializable{
  private static CacheRepository cache;

  public static final String NAME_FINALIZATION = "--";
  public static final String REP_FINALIZATION = "__";

  public Class getObjectClass() {
    return ReportView.class;
  }

  /**
 * Inicializa el repositorio
 * @param directoryName
 * @param reportGeneratorConfiguration
 */
  public ReportViewRepository(String directoryName, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(directoryName, reportGeneratorConfiguration);
  }

  /**
   * Carga una definición a partir de un identificador del report view
   * @param id Identificador
   * @return Objeto instanciado
   * @throws es.indra.mare.common.info.InfoException Si no pudo obtener el report view
   */
  public ReportView loadFromID(String id, String reportDefinitionId, String userId) throws InfoException {
    Object object;
    try {
      object = super.load(getFileName(id, reportDefinitionId,userId));
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("91"), e);
    }
    if (object != null) {
      return (ReportView) object;
    }
    else {
      return null;
    }
  }

  /**
   * Devuelve el nombre real del archivo correspondiente al objeto
   * @param id Identificador del report view
   * @return
   */
  private String getFileName(String id, String reportDefinitionId, String userId) throws InfoException {
    String fileName,returnedFileName,sourceName;
    String reportFileName;
    String userName;

    returnedFileName = "";
    FileObject fileObject;
    try {
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
    }
    catch (FileSystemException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("212"),":",getDirectoryName()},e);
    }
    try {
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
        sourceName = fileName.substring(0, id.length()).toUpperCase();
        reportFileName = fileName.substring(fileName.indexOf(NAME_FINALIZATION)+2, fileName.indexOf(REP_FINALIZATION));
        userName = fileName.substring(fileName.indexOf(REP_FINALIZATION)+2 , fileName.length());
        if (sourceName.equalsIgnoreCase(id.toUpperCase()) && reportFileName.equalsIgnoreCase(reportDefinitionId)) {
          if (!userName.equalsIgnoreCase("")){
            if (userName.equalsIgnoreCase(userName)){
              returnedFileName = fileName;
            }
          } else {
            returnedFileName = fileName;
          }
        }
      }
    }catch (Exception e){
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("213"),":",getDirectoryName()},e);
    }
    if (returnedFileName.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("92"));
    }
    else {
      return returnedFileName;
    }
  }

  /**
   * Graba una definición
   * @param reportView
   */

  public void save(ReportView reportView) throws InfoException {
    try {
      validSizeRepository();
      super.save(reportView, reportView.getId()+ NAME_FINALIZATION + reportView.getReportDefinitionId()+ REP_FINALIZATION +reportView.getUserID());
    } catch (IOException e) {
      throw new InfoException(LanguageTraslator.traslate("93"), e);
    }
  }

  /**
   * Valida si la varsión está habilitada para poder registrar
   * @throws InfoException
   */
  private void validSizeRepository() throws InfoException {
    try{
      FileObject fileObject;
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
      if (fileObject.getChildren().length >VersionProperties.getMaxNumberDefinition()){
        throw new InfoException(LanguageTraslator.traslate("250"));
      }
    }
    catch(Exception e){
     throw new InfoException(LanguageTraslator.traslate("250"));
    }
  }

  /**
   * Retorna una lista de todas las vistas disponibles para la definicion
   * @param reportDefinitionID Nombre del report definition para el cual se definió la vista
   * @param reportManager El report manager para obener datos de las otras definiciones
   * @return
   */
  public Map getAllViewForDefinition(String reportDefinitionID, IReportManager reportManager) throws InfoException {
    Map map= new Hashtable();
    String fileName, reportFileName, id;
    FileObject fileObject;

    try {
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
    }
    catch (FileSystemException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("212"),":",getDirectoryName()},e);
    }
    try {
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
       // System.out.println("ReportView:"+fileName);
        reportFileName = fileName.substring(fileName.indexOf(NAME_FINALIZATION)+2, fileName.indexOf(REP_FINALIZATION));
        if (reportDefinitionID.equalsIgnoreCase(reportFileName)) {
          id = fileName.substring(0,fileName.indexOf(NAME_FINALIZATION));
          DefinitionInfo definitionInfo = new DefinitionInfo();
          definitionInfo.setId(id);
          try {
            definitionInfo.setDescription(new DefinitionTraslator((ReportView)load(fileName),((ReportManager)reportManager).getReportDefinitionFromID(reportFileName),reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry()).getDescription());
          }catch(Exception e){
            throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("178"),":",reportFileName},e);
          }
          map.put(id,definitionInfo);
        }
      }
    }catch (Exception e){
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("213"),":",getDirectoryName()},e);
    }
    return map;
  }


  /**
   * Devuelve el objeto cache del repositorio
   * @return
   */
  public CacheRepository getCache() {
    if (cache == null) {
      cache = new CacheRepository("ReportDefinition");
    }
    return cache;
  }

  public Map getAllViewForReportUser(String reportDefinitionID, String userID) throws InfoException {
    Map map = new Hashtable();
    String fileName, userName, reportFileName, id;
    FileObject fileObject;

    try {
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
    }
    catch (FileSystemException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("212"),":",getDirectoryName()},e);
    }
    try {
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
        userName = fileName.substring(fileName.indexOf(REP_FINALIZATION)+2 , fileName.length());
        reportFileName = fileName.substring(fileName.indexOf(NAME_FINALIZATION)+2, fileName.indexOf(REP_FINALIZATION));
        if (reportDefinitionID.equalsIgnoreCase(reportFileName)&& userName.equalsIgnoreCase(userID)) {
          id = fileName.substring(0,fileName.indexOf(NAME_FINALIZATION));
          DefinitionInfo definitionInfo = new DefinitionInfo();
          definitionInfo.setId(id);
          try {
            definitionInfo.setDescription(((ReportView)load(fileName)).getDescription());
          }catch(Exception e){
            throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("178"),":",id},e);
          }
          map.put(id,definitionInfo);
        }
      }
    }catch (Exception e){
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("213"),":",getDirectoryName()},e);
    }
    return map;
  }

  public ReportView getDefaultViewForReportUser(String reportDefinitionID, String userID) throws InfoException{
    Map map =  getAllViewForReportUser(reportDefinitionID,userID);
    ReportView reportView=null;
    ReportView returnReportView=null;
    try {
      for (int i= 0;i<map.size();i++){
        reportView = (ReportView) load(getFileName(((DefinitionInfo)map.values().toArray()[i]).getId(),reportDefinitionID,userID));
        if (reportView.getDefault()) {
          returnReportView = reportView;
          break;
        }
      }
    }catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("94"),e);
    }
    return returnReportView;

  }

  public void delete(String id, String reportDefinitionId, String userId) throws InfoException {
    String fileName = getFileName(id,reportDefinitionId,userId);
    deleteFile(fileName);
    getCache().delete(fileName);
  }

  public void assingDefaultView(String id, String reportDefinitionId, String userId) throws InfoException {
    try {
      String fileName = getFileName(id,reportDefinitionId,userId);
      unassignDefault(reportDefinitionId,userId);
      ReportView reportView = (ReportView)load(fileName);
      reportView.setDefault(true);
      save(reportView);
    }
    catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("254"),e);
    }
  }

  /**
   * Quita el default anterior
   * @param reportDefinitionId
   * @param userId
   * @throws InfoException
   */
  protected void unassignDefault(String reportDefinitionId, String userId) throws InfoException {
    Map views = getAllViewForReportUser(reportDefinitionId,userId);
    ReportView reportView=null;
    String reportViewName="";
    try {
      for (int i= 0;i<views.size();i++){
        reportView = (ReportView) load(getFileName(((DefinitionInfo)views.values().toArray()[i]).getId(),reportDefinitionId,userId));
        reportViewName = reportView.getDescription();
        if (reportView.getDefault()){
          reportView.setDefault(false);
          save(reportView);
        }
      }
    }catch(Exception e){
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("255"),":",reportViewName},e);
    }
  }

  public void deleteAll() throws InfoException {
    getCache().deleteAll();
    deleteAllFiles();
  }

}
