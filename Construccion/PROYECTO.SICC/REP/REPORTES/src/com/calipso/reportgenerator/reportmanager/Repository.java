package com.calipso.reportgenerator.reportmanager;

import es.indra.mare.common.info.InfoException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.File;
import java.io.Writer;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.MultipleStringInfoException;
import com.calipso.reportgenerator.services.FileSystemResolver;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.FileObject;
import org.xml.sax.InputSource;

/**
 * Esta clase abstracta se encarga de la persistencia genérica de los datos dentro de repositorios.
 */
public abstract class Repository {

  private String directoryName;
  private FileSystemManager fileSystemaManager;
  public boolean serialize=false; // Indica si se serializa en el repositorio o se guarda como xml


  public ReportGeneratorConfiguration reportGeneratorConfiguration;

  public abstract Class getObjectClass();
  /** Crea el repositorio asignándole un directorio destino.
   * Esta implementación es temporaria hasta tener la conección con Mare para la persistencia
   * @param directoryName Nombre del directorio destino
   * @param reportGeneratorConfiguration
   */
  public Repository(String directoryName, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    this.directoryName = directoryName;
    this.reportGeneratorConfiguration = reportGeneratorConfiguration;
  }


  /** Retorna el nombre del directorio destino
   * @return directorio destino
   */
  public String getDirectoryName() {
    return directoryName;
  }

  /** Asigna el directorio destino
   * @param directoryName directorio destino
   */
  public void setDirectoryName(String directoryName) {
    this.directoryName = directoryName;
  }

  /**
   * Instancia un objeto del repositorio.
   * @param ID Nombre del archivo
   * @return Objeto instanciado
   * @throws InfoException Si no se pudo objeter el objeto
   */
  public Object getFromID(String ID) throws InfoException {
    try {
      return load(ID);
    } catch (Exception e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("51"),":",ID}, e);
    }
  };

  /**
   * Graba el objeto dentro del repositorio
   * @param object Objeto a grabar
   * @param name - nombre
   * @throws InfoException - Si el Object o el name vienen vacíos
   * @throws IOException - Si no pudo grabar el
   */
  protected void save(Object object, String name) throws InfoException, IOException {
    OutputStream os;
    ObjectOutputStream oos;
    String fileName;
    fileName = directoryName + "/" + name.toUpperCase();

    if ((object == null) || (name == "")) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("52"),":",name});
    }
    else {
      try {
          if (serialize){
            os = getFileSystemManager().resolveFile(fileName).getContent().getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(object);
            os = null;
            oos.flush();
            oos.close();
            oos.reset();
            oos = null;
            resetFileSystemManager();
          }else{
            try {
              Writer writer = new OutputStreamWriter(getFileSystemManager().resolveFile(fileName).getContent().getOutputStream());
              Marshaller marshaller = new Marshaller(writer);
              marshaller.setEncoding("ISO-8859-1");
              marshaller.marshal(object);
              writer.flush();
              writer.close();
              resetFileSystemManager();
            }catch (Exception e){
              throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("195"),":",fileName},e);
            }
          }
          getCache().addObject(name, object);
        } catch (IOException e) {
          throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("53"),":",name,"."},e);
        }
    }
  }

  private void resetFileSystemManager() {
    setFileSystemaManager(null);
    FileSystemResolver.resetFileSystemManager();
  }

  /**
   * Carga un objeto de un repositorio
   * @param id Identificador de objeto
   * @return Objeto instanciado
   * @throws IOException Si no se pudo obtener el archivo
   * @throws ClassNotFoundException
   * @throws InfoException Si no se indicó el nombre
   */
  protected Object load(String id) throws IOException, ClassNotFoundException, InfoException {
    InputStream is;
    ObjectInputStream ois;
    Object returnObject;

    if (id.equalsIgnoreCase("")) {
      throw new InfoException(LanguageTraslator.traslate("55"));
    }
    else {
      if (getCache().containsObject(id)) {
        return getCache().getObject(id);
      }
      else {
        try {
          if (serialize) {
            is = getFileSystemManager().resolveFile(getDirectoryName() + "/" + id).getContent().getInputStream();
            ois = new ObjectInputStream(is);
            returnObject = ois.readObject();
          }else {
            try {
              InputStream inputStream = getFileSystemManager().resolveFile(getDirectoryName() + "/" + id).getContent().getInputStream();
              InputSource inputSource = new InputSource(inputStream);
              returnObject = Unmarshaller.unmarshal(getObjectClass(), inputSource);
            }catch(Exception e){
              throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("194"),":",getDirectoryName() , "/" , id},e);
            }
          }
          getCache().addObject(id, returnObject);
          return returnObject;
        } catch (FileNotFoundException e) {
          throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("56"),":",id},e);
        }
      }
    }
  }

  /**
   * Renombra un objeto dentro del repositorio
   * @param sourceName Nombre origen
   * @param targetName Nombre destino
   * @return Indica si fué renombrado
   */
  protected boolean renameFile(String sourceName, String targetName) {
    File sourceFile, targetFile = null;
    try {
      sourceFile = new File(getDirectoryName() + "/" + sourceName);
      targetFile = new File(getDirectoryName() + "/" + targetName + ".tmp");
      sourceFile.renameTo(targetFile);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Borra un objeto del repositorio
   * @param fileName Nombre del objeto
   * @return Indica si el objeto fué borrado
   * @throws InfoException Si no se pudo borrar el archivo o no se indica el nombre
   */
  protected boolean deleteFile(String fileName) throws InfoException {
    FileObject fileObject;
    if (fileName.equalsIgnoreCase("")) {
      throw new InfoException(LanguageTraslator.traslate("57"));
    }
    else {
      try {
        fileObject = getFileSystemManager().resolveFile(new File(getDirectoryName()), fileName);
        if (getCache().containsObject(fileName)){
          getCache().removeObject(fileName);
        }
        if (fileObject.exists()){
          fileObject.close();
          fileObject.delete();
        };
        resetFileSystemManager();
        return true;
      } catch (Exception e) {
        throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("58"),":",fileName},e);
      }
    }
  }

  /**
   * Devuelve el objeto cache del repositorio
   * @return
   */
  public abstract CacheRepository getCache();

  /**
   * Deveulve la configuracion del report manager
   * @return
   */
  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }

  public FileSystemManager getFileSystemManager() throws InfoException {
    if (fileSystemaManager == null ) {
      try {
        fileSystemaManager =  FileSystemResolver.getFileSystemManager(getReportGeneratorConfiguration());
      }catch(Exception e){
        throw new InfoException(LanguageTraslator.traslate("211"),e);
      }
    }
    return fileSystemaManager;
  }

  public void setFileSystemaManager(FileSystemManager fileSystemaManager) {
    this.fileSystemaManager = fileSystemaManager;
  }

  public void deleteAllFiles() throws InfoException {
    FileObject fileObject;
    String fileName="";
    try {
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
      FileObject[] fileObjects = fileObject.getChildren();
      for (int i = 0; i < fileObjects.length; i++) {
        fileName = fileObjects[i].getName().getBaseName();
        deleteFile(fileName);
      }
      resetFileSystemManager();
    }
    catch (Exception e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("253"),":",fileName,":",getDirectoryName()},e);
    }
  };

}
