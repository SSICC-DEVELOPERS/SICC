package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.DefinitionInfo;
import com.calipso.reportgenerator.common.MultipleStringInfoException;

import java.util.Map;
import java.util.Hashtable;
import java.io.Serializable;

import es.indra.mare.common.info.InfoException;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;

/**
 * Repositorio de definiciones de orígenes de datos(DataSource)
 */
public class ReportSourceDefinitionRepository extends Repository implements Serializable{
  private static CacheRepository cache;

  /**
   * Recupera una definición desde un identificador
   * @param id Identificador de la definición
   * @return
   * @throws InfoException
   */
  public ReportSourceDefinition loadFromID(String id) throws InfoException {
    Object object;
    try {
      object = super.load(id);
      if (object != null) {
        return (ReportSourceDefinition) object;
      }
      else {
        return null;
      }
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("59"), e);
    }
  }

  /**
   * Graba un report source definition
   * @param reportSourceDefinition
   * @throws InfoException Si no se pudo grabar la definición
   */
  public void save(ReportSourceDefinition reportSourceDefinition) throws InfoException {
    try {
      super.save(reportSourceDefinition, reportSourceDefinition.getId());
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("60"), e);
    }
  }

  /**
   * Retorna una lista de todas las definiciones disponibles
   * @return
   */
  public Map getAllDfefinitions() throws InfoException {
    Map map= new Hashtable();
    String fileName;
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
        DefinitionInfo definitionInfo = new DefinitionInfo();
        definitionInfo.setId(fileName);
        try {
          definitionInfo.setDescription(new DefinitionTraslator((ReportSourceDefinition)load(fileName),reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry()).getDescription());
        }catch(Exception e){
          throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("177"),":",fileName},e);
        }
        map.put(fileName,definitionInfo);
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
      cache = new CacheRepository("ReportSourceDefinition");
    }
    return cache;
  }

  public void delete(String id) throws InfoException {
    String fileName = id;
    deleteFile(fileName);
    getCache().delete(fileName);
  }

  public Class getObjectClass() {
    return ReportSourceDefinition.class;
  }

  /**
   * Inicializa el repositorio
   * @param directoryName
   * @param reportGeneratorConfiguration
   */
  public ReportSourceDefinitionRepository(String directoryName, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(directoryName, reportGeneratorConfiguration);
  }

  /**
   * Borra el repositorio
   * @throws InfoException
   */
  public void deleteAll() throws InfoException {
    getCache().deleteAll();
    deleteAllFiles();
  }

}
