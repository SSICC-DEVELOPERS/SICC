package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportcalculator.Matrix;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.MultipleStringInfoException;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import es.indra.mare.common.info.InfoException;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;


/**
 * Repositorio de reportes cacheados
 */
public class ReportSourceRepository extends Repository implements Serializable{
  private static CacheRepository cache;

  private static int MAXEXPIRATION = 849600;
  public static final String NAME_FINALIZATION = "--";

  public Class getObjectClass() {
    return ReportSource.class;
  }

  /**
   * Inicializa el repositorio
   * @param directoryName
   * @param reportGeneratorConfiguration
   */
  public ReportSourceRepository(String directoryName, ReportGeneratorConfiguration reportGeneratorConfiguration) {
    super(directoryName, reportGeneratorConfiguration);
    serialize = true;
  }

  /**
   * Recupera un cache vigente para un report source definition
   * @param reportSpec
   * @return
   * @throws InfoException
   */
  public ReportSource load(ReportSpec reportSpec) throws InfoException {
    String fileName = "";
    if (reportSpec.getCached()) {
      try {
        fileName = searchFileName(reportSpec, false);
      } catch (Exception e) {
        throw new InfoException(LanguageTraslator.traslate("64"), e);
      }
      if (!fileName.equals("")) {
        try {
          return new ReportSource(reportSpec, (Matrix) super.load(fileName), getLastExecution(fileName, reportSpec.getSourceId()), reportGeneratorConfiguration);
        } catch (Exception e) {
          throw new InfoException(LanguageTraslator.traslate("65"), e);
        }
      }
      else {
        return null;
      }
    }
    else {
      return null;
    }
  }

  /**
   * Retorna la fecha de ejecución del reporte.
   * @param fileName  nombre del file origen
   * @param reportSourceDefId Id de la definición de reporte
   * @return
   * @throws InfoException Si no pudo parsear la fecha
   */
  private Date getLastExecution(String fileName, String reportSourceDefId) throws InfoException {
    DateFormat dateFormat;
    Date lastExecution = new Date();
    dateFormat = new SimpleDateFormat("yyyyMMdd");
    try {
      lastExecution = dateFormat.parse(fileName.substring(reportSourceDefId.length() + NAME_FINALIZATION.length() + 2, reportSourceDefId.length() + NAME_FINALIZATION.length() + 10));
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("66"));
    }
    return lastExecution;
  }

  /**
   * Retorna el nombre del cache vigente
   *
   * @param reportSpec
   * @param previusFiles Indica si se busca el nombre de los cacheados anteriores o el vigente
   * @return
   * @throws InfoException Si no se pudo obtener la fecha de expiración
   */
  private String searchFileName(ReportSpec reportSpec, boolean previusFiles) throws InfoException {
    String fileName, returnedfileName, sourceName, sourceExpirationString;
    Date sourceExpiration = new Date();
    Date maxExpiration = new Date();
    int starExpiration;
    DateFormat dateFormat;
    returnedfileName = "";
    FileObject fileObject;

    try {
      fileObject = getFileSystemManager().resolveFile(getDirectoryName());
    }
    catch (FileSystemException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("212"),":",getDirectoryName()},e);
    }
    dateFormat = new SimpleDateFormat("yyyyMMdd");
    try {
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
        int reportNameSize = reportSpec.getSourceId().length() + NAME_FINALIZATION.length();
        if (fileName.length() > reportNameSize) {
          sourceName = fileName.substring(0,reportNameSize).toUpperCase();
          if (sourceName.equalsIgnoreCase(reportSpec.getSourceId().toUpperCase() + NAME_FINALIZATION)) {
            starExpiration = sourceName.length() + 12;
            sourceExpirationString = fileName.substring(starExpiration, starExpiration + 8);
            if ((sourceExpirationString.compareTo("")) > 0) {
              try {
                sourceExpiration = dateFormat.parse(fileName.substring(starExpiration, starExpiration + 8));
                if (previusFiles) {
                  if (sourceExpiration.before(maxExpiration)) {
                    returnedfileName = fileName;
                    maxExpiration = sourceExpiration;
                  }
                }else{
                  if (sourceExpiration.after(maxExpiration)) {
                    returnedfileName = fileName;
                    maxExpiration = sourceExpiration;
                  } else if (sourceExpiration.before(maxExpiration)) {
                    returnedfileName = "";
                  }
                }

              } catch (ParseException e) {
                throw new InfoException(LanguageTraslator.traslate("67"), e);
              }
            }
            else {
              if (reportSpec.getIncrementalDimension().compareTo("") > 0) {
                returnedfileName = fileName;
                maxExpiration = sourceExpiration;
              }
            }
          }
        }
      }
    }catch (Exception e){
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("213"),":",getDirectoryName()},e);
    }
    return returnedfileName;
  }

  /**
   * Graba un cache nuevo asignándole la vigencia
   * @param reportSource
   * @throws InfoException
   */
  public void saveNewSource(ReportSource reportSource) throws InfoException {
    String fileName;
    if (reportSource.getReportSpec().getCached()) {
      fileName = getNewFileName(reportSource.getReportSpec(), null);
      try {
        super.save(reportSource.getMatrix(), fileName);
      } catch (Exception e) {
        throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("68"),fileName}, e);
      }
    }
  }

  /**
   * Graba un cache incremental invalidando el anterior cache vigente si existiese.
   * @param reportSource
   * @throws InfoException
   */
  public boolean saveIncrementalSource(ReportSource reportSource) throws InfoException {
    String fileName,searchName;
    if(!(searchFileName(reportSource.getReportSpec(), true).equalsIgnoreCase(""))) {
      if (reportSource.getReportSpec().getCached()) {
        try {
          searchName = searchFileName(reportSource.getReportSpec(), true);
          fileName = getNewFileName(reportSource.getReportSpec(),null);// getExecutionDateFromFileName(searchName, reportSource.getReportSpec().getSourceId()));
          deleteReportSource(reportSource.getReportSpec());
          super.save(reportSource.getMatrix(), fileName);
          return true;
        } catch (Exception e) {
          throw new InfoException(LanguageTraslator.traslate("69"), e);
        }
      }
    }
    return false;
  }


  /**
   * Retorna la fecha de creación del reportsource
   * @param fileName nombre del archivo
   * @param reportDefinitionID id de la definicion
   * @return
   * @throws InfoException
   */
  private Date getExecutionDateFromFileName(String fileName, String reportDefinitionID) throws InfoException {
    DateFormat dateFormat;
    int starExec;
    String sourceExecutionString;
    Date resultDate = new Date();

    if (!fileName.equals("")) {
      dateFormat = new SimpleDateFormat("yyyyMMdd");
      starExec = reportDefinitionID.length() + NAME_FINALIZATION.length() + 2;
      sourceExecutionString = fileName.substring(starExec , starExec + 8);
      if ((sourceExecutionString.compareTo("")) > 0) {
        try {
          resultDate = dateFormat.parse(sourceExecutionString);
        } catch (ParseException e) {
          throw new InfoException(LanguageTraslator.traslate("70"), e);
        }
      }
    }
    return resultDate;
  }

  /**
   * Formato de fecha por defecto
   * @return
   */
  public String getDatePattern() {
    return getReportGeneratorConfiguration().getDatePattern();
  }

  /**
   * Obtiene el nombre del archivo con el cual se debe guardar en el repositorio, teniendo en cuenta las fecha de ejecución y expiración
   * @param reportSpec
   * @param executionDate
   * @return
   */
  private String getNewFileName(ReportSpec reportSpec, Date executionDate) {
    Calendar expiration;
    Calendar execute;
    execute = new GregorianCalendar();

    expiration = new GregorianCalendar();
    if (executionDate != null) {
      execute.setTime(executionDate);
      expiration.setTime(executionDate);
    }
    int expirationValue = reportSpec.getExpiration().intValue();
    if (expirationValue == 0) {
      expirationValue = MAXEXPIRATION;
    }
    expiration.add(Calendar.HOUR, expirationValue);
    return getFileName(reportSpec.getSourceId(),execute.getTime(), expiration.getTime());
  }

  /**
   * Obtienen el nombre del archivo
   * @param sourceID
   * @param execution
   * @param expiration
   * @return
   */
  protected String getFileName(String sourceID,Date execution,Date expiration){
    DateFormat dateFormat;
    String executionText = "";
    String expirationText = "";

    dateFormat = new SimpleDateFormat("yyyyMMdd");
    executionText = "DD" + dateFormat.format(execution);
    expirationText = "EE" + dateFormat.format(expiration);
    return ( sourceID + NAME_FINALIZATION + executionText + expirationText + ".tmp").toUpperCase();

  }

  /**
   * Borra un cache de un report source definition y todos sus anteriores
   * @param reportSpec
   * @return
   * @throws InfoException Si no se pudo invalidar
   */
  public boolean deleteReportSource(ReportSpec reportSpec) throws InfoException {
    String fileName;
    try {
      fileName = searchFileName(reportSpec, false);
      if (!fileName.equals("")) {
        super.deleteFile(fileName);
        getCache().delete(fileName);
      }
      fileName = "";
      fileName = searchFileName(reportSpec,true);
      while (!fileName.equalsIgnoreCase("")){
        deleteFile(fileName);
        getCache().delete(fileName);
        fileName = "";
        fileName = searchFileName(reportSpec,true);
      }
      return true;
    } catch (InfoException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("278"),":",reportSpec.getSourceId()}, e);
    }
  }

  /**
   * Pisa la fecha de vencimiento de un cache a la actual
   * @param reportSpec
   * @return
   * @throws InfoException
   */
  public boolean invalidateReportSource(ReportSpec reportSpec) throws InfoException {
    try{
      String fileName = searchFileName(reportSpec,false);
      String newFileName = getFileName(reportSpec.getSourceId(),new Date(),new Date());
      renameFile(fileName,newFileName);
      return true;
    } catch (InfoException e) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("71"),":",reportSpec.getSourceId()}, e);
    }
  }

  /**
   * Devuelve el objeto cache del repositorio
   * @return
   */
  public CacheRepository getCache() {
    if (cache == null) {
      cache = new CacheRepository("ReportSource");
    }
    return cache;
  }

  public void deleteAll() throws InfoException {
    getCache().deleteAll();
    deleteAllFiles();
  }


}