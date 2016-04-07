package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.DefinitionInfo;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.MultipleStringInfoException;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.VersionProperties;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;

import es.indra.mare.common.info.InfoException;

import java.io.IOException;
import java.io.Serializable;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;

/**
 * Repositorio de definiciones de reportes
 */
public class ReportDefinitionRepository extends Repository implements Serializable{
  private static CacheRepository cache;

  public static final String NAME_FINALIZATION = "--";


  /**
   * Carga una definición a partir de un identificador
   * @param id Identificador
   * @return Objeto instanciado
   * @throws InfoException Si no pudo obtener la definición
   */
  public ReportDefinition loadFromID(String id) throws InfoException {
    Object object;
    try {
      object = super.load(getFileName(id));
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("61"), e);
    }
    if (object != null) {
      return (ReportDefinition) object;
    }
    else {
      return null;
    }
  }

  /**
   * Devuelve el nombre real del archivo correspondiente al objeto
   * @param id Identificador del report definition
   * @return
   */
  private String getFileName(String id) throws InfoException {
    String fileName,returnedFileName,sourceName;
    returnedFileName = "";
    FileObject fileObject;
    int index;

    try {
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
    }
    catch (FileSystemException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("212"),":",getDirectoryName()},e);
    }
    try {
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        try {
          fileName = fileObject.getChildren()[i].getName().getBaseName();
          index = id.length() + NAME_FINALIZATION.length();
          if ((id.length() + NAME_FINALIZATION.length())>fileName.length()){
            index = fileName.length();
          };
          sourceName = fileName.substring(0,index).toUpperCase();
          if (sourceName.equalsIgnoreCase((id.toUpperCase() + NAME_FINALIZATION).substring(0,index))) {
            returnedFileName = fileName;
          }
        }
        catch(Exception e){
        }
      }
    }catch (Exception e){
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("213"),":",getDirectoryName()},e);
    }
    if (returnedFileName.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("62"));
    }
    else {
      return returnedFileName;
    }
  }

  /**
   * Graba una definición
   * @param reportDefinition
   */

  public void save(ReportDefinition reportDefinition) throws InfoException {
    try {
      validSizeRepository();
      super.save(reportDefinition, reportDefinition.getId() + NAME_FINALIZATION + "EE" + reportDefinition.getEntity());
    } catch (IOException e) {
      throw new InfoException(LanguageTraslator.traslate("63"), e);
    }
  }

  private void validSizeRepository() throws InfoException {
    try{
      FileObject fileObject;
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
      if (fileObject.getChildren().length >VersionProperties.getMaxNumberDefinition()){
        throw new InfoException(LanguageTraslator.traslate("247"));
      }
    }
    catch(Exception e){
     throw new InfoException(LanguageTraslator.traslate("247"));
    }
  }

  /**
   * Retorna una lista de todas las definiciones de reportes registradas
   * @return
   */
  public Map getAllDefinitions() throws InfoException {
    Hashtable hashtable;
    hashtable = new Hashtable();
    String fileName;
    String id;
    FileObject fileObject;
    int index;

    try {
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
    }
    catch (FileSystemException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("212"),":",getDirectoryName()},e);
    }
    try {
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
        index = fileName.indexOf(NAME_FINALIZATION);
        if (index< 0){
          index =fileName.length();
        }
        id = (fileName.substring(0,index));
        DefinitionInfo definitionInfo = new DefinitionInfo();
        definitionInfo.setId(id);
        try {
          definitionInfo.setDescription(new DefinitionTraslator((ReportDefinition)load(fileName),reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry()).getDescription());
        }catch(Exception e){
          throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("176"),":",id},e);
        }
        hashtable.put(id,definitionInfo);
      }
    }catch (Exception e){
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("213"),":",getDirectoryName()},e);
    }
    return hashtable;
  }

  /**
   * Retorna una lista de todas las definiciones de reportes registradas para una entidad
   * @param entityName Nombre de la entidad
   * @return
   */
  public Map getAllDfefinitionForEntity(String entityName) throws InfoException {
    Map map = new Hashtable();
    String ee = "EE";
    String fileName, entityFileName, reportFileName;
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
        entityFileName = fileName.substring(fileName.indexOf(ee) + 2, fileName.length());
        reportFileName = fileName.substring(0, fileName.indexOf(NAME_FINALIZATION));
        if (entityName.equalsIgnoreCase(entityFileName)) {
          DefinitionInfo definitionInfo = new DefinitionInfo();
          definitionInfo.setId(reportFileName);
          try {
            definitionInfo.setDescription(new DefinitionTraslator((ReportDefinition)load(fileName),reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry()).getDescription());
          }catch(Exception e){
            throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("176"),":",reportFileName},e);
          }
          map.put(reportFileName,definitionInfo);
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

  public void deleteAll() throws InfoException {
    getCache().deleteAll();
    deleteAllFiles();
  }

  public void delete(String id) throws InfoException {
    String fileName = getFileName(id);
    deleteFile(fileName);
    getCache().delete(fileName);
  }


  public Class getObjectClass() {
    return ReportDefinition.class;
  }

  /**
   * Inicializa el repositorio
   * @param directoryName
   * @param reportGeneratorConfiguration
   */
  public ReportDefinitionRepository(String directoryName, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(directoryName, reportGeneratorConfiguration);
  }


}
