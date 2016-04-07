 package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.MultipleStringInfoException;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;
import com.calipso.reportgenerator.services.FileSystemResolver;
import com.calipso.reportgenerator.reportcalculator.Matrix;
import com.calipso.reportgenerator.common.MicroReport;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.ReportManagerLogger;
import com.calipso.reportgenerator.common.ReportLayoutBuilder;
import com.calipso.reportgenerator.reportmanager.UsersRepository;

//import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.io.Serializable;
import java.io.FileReader;
import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.FileObject;
import org.exolab.castor.xml.Unmarshaller;
import es.indra.mare.common.info.InfoException;
import dori.jasper.engine.JasperExportManager;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JasperPrint;
import dori.jasper.engine.JRExporterParameter;
import dori.jasper.engine.export.JRXlsExporter;
import dori.jasper.engine.export.JRCsvExporter;

/**
 *  Esta clase es el único punto de ingreso al generador de reportes.
 *  Para ejecutar un reporte se instancia un ReportManager.
 *  Es el encargado de integrar el funcionamiento con el Pivot
 *  y de mantener los repositorios de las definiciones de reportes
 *  y reportes precalculados.
 *	Esta clase representa la API a la que llaman todos los módulos externos
 *  La parte del manejo de sesión de usuario no está incluida,
 *  será agregada cuando dispongamos de más información sobre
 *  las APIs de MARE.
 */

public class ReportManager implements IReportManager, Serializable {

  private HashMap activeReports;
  private int lastHandle;
  private ReportDefinitionRepository reportDefinitionRepository;
  private ReportSourceDefinitionRepository reportSourceDefinitionRepository;
  private ReportSourceRepository reportSourceRepository;
  private ReportViewRepository reportViewRepository;
  private ReportGeneratorConfiguration reportGeneratorConfiguration;



  /**
   * Inicializa una instancia de <code>ReportManager</code>
   * @param reportGeneratorConfiguration Configuración del report manager
   */
  public ReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("159"));
    if (reportGeneratorConfiguration == null) {
      throw new InfoException(LanguageTraslator.traslate("1"));
    }
    else {
      this.reportGeneratorConfiguration = reportGeneratorConfiguration;
    }
  }

  /**
   * Constructor utilizado para el caso que se crea el report manager distribuido y la clase por demanda. Se debe ejecutar luego de este el init de la interfase IReportManager.
   * @throws InfoException
   */
  public ReportManager() throws InfoException {

  }

  /**
   * Crea una instancia de <code>ReportSpec</code> que contiene toda la información de <code>ReportDefinition</code> y
   * <code>ReportSourceDefinition</code> necesaria para resolver el reporte
   * @param reportDefinition
   * @return
   * @throws InfoException
   */
  public ReportSpec getReportSpec(ReportDefinition reportDefinition) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("158")+":"+reportDefinition.getId());
    ReportSpec reportSpec = new ReportSpec(reportGeneratorConfiguration);
    ReportSourceDefinition reportSourceDefinitionTmp;
    reportSourceDefinitionTmp = getReportSourceDefinitionFromID(reportDefinition.getReportSource());
    reportSpec.fillFrom(reportSourceDefinitionTmp);
    reportSpec.fillFrom(reportDefinition);
    return reportSpec;
  }

  /**
   * Crea una instancia de <code>ReportSpec</code> que contiene toda la información de <code>ReportDefinition</code> y
   * <code>ReportSourceDefinition</code> necesaria para resolver el reporte
   * @param reportDefinition
   * @param reportSourceDef
   * @return
   * @throws InfoException
   */
  public ReportSpec getReportSpec(ReportDefinition reportDefinition, ReportSourceDefinition reportSourceDef) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("158")+":"+reportDefinition.getId());
    ReportSpec reportSpec = new ReportSpec(reportGeneratorConfiguration);
    reportSpec.fillFrom(reportSourceDef);
    reportSpec.fillFrom(reportDefinition);
    return reportSpec;
  }

  /**
   * Crea una instancia de <code>ReportSpec</code> que contiene toda la información de <code>ReportSourceDefinition</code> y
   * necesaria
   * @param reportSourceDefinition
   * @return
   * @throws InfoException
   */
  public ReportSpec getReportSpec(ReportSourceDefinition reportSourceDefinition) throws InfoException {
    ReportSpec reportSpec = new ReportSpec(reportGeneratorConfiguration);
    reportSpec.fillFrom(reportSourceDefinition);
    return reportSpec;
  }

  /**
   * Crea un <code>Report</code> a partir del identificador de su definición (<code>ReportDefinition</code>)
   * @param reportDefId
   * @return
   * @throws InfoException Si no se pudo crear el reporte
   */
  protected Report newReportFrom(String reportDefId) throws InfoException {
    if (reportDefId.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("2"));
    }
    else {
      return newReportFrom(getReportDefinitionFromID(reportDefId));
    }
  }


  /**
   * Crea un <code>Report</code> a partir de una definición de reporte (<code>ReportDefinition</code>)
   * @param reportDef
   * @return
   * @throws InfoException Si no se pudo crear el Reporte
   */
  protected Report newReportFrom(ReportDefinition reportDef) throws InfoException {
    ReportSource source;
    if (reportDef == null) {
      throw new InfoException(LanguageTraslator.traslate("3"));
    }
    else {
      ReportSpec reportSpec = null;
      try {
        reportSpec = getReportSpec(reportDef);
        source = getReportSource(reportSpec);
      } catch (InfoException e) {
        throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("4"),":",reportDef.getId()}, e);
      }
      Report report = null;
      if((reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CUBE.toString())) ||
        (reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CHARTCUBE.toString()))) {
        report = new CubeReport(reportSpec, source, reportGeneratorConfiguration);
      } else if(reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.ACCUM.toString())) {
        report = new StaticReport(reportSpec, source, reportGeneratorConfiguration);
      }
      return report;
    }
  }

  /**
   * Crea un <code>Report</code> a partir del id de una definición de reporte (<code>ReportDefinition</code>).
   * También recibe los valores de parámetros, que pueden contener valores para los pre-filtros (esto solo es
   * aplicable a Reportes no cacheados)
   * @param reportDefId
   * @param paramValues
   * @return
   * @throws InfoException Si no se pudo generar el reporte
   */
  protected Report newReportFrom(String reportDefId, Map paramValues) throws InfoException {
    if (reportDefId.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("5"));
    }
    else {
      return newReportFrom(getReportDefinitionFromID(reportDefId), paramValues);
    }
  }

  /**
   * Crea un <code>Report</code> a partir de una definición de reporte (<code>ReportDefinition</code>).
   * También recibe los valores de exparámetros, que pueden contener valores para los pre-filtros (esto solo es
   * aplicable a Reportes no cacheados)
   * @param reportDef
   * @param paramValues
   * @return
   * @throws InfoException Si no se pudo crear el reporte
   */

  protected Report newReportFrom(ReportDefinition reportDef, Map paramValues) throws InfoException {
    ReportSource source;
    if (reportDef == null) {
      throw new InfoException(LanguageTraslator.traslate("6"));
    }
    else {
      ReportSpec reportSpec = getReportSpec(reportDef);
      ReportSourceDefinition reportSourceDefinition = getReportSourceDefinitionFromID(reportDef.getReportSource());
      Report report = null;
      if (reportSourceDefinition.getCached()) {
        report = newReportFrom(reportDef);
      }
      else {
        source = getReportSource(reportSpec, reportSourceDefinition, paramValues);
        if((reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CUBE.toString())) ||
          (reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CHARTCUBE.toString()))) {
          report = new CubeReport(reportSpec, source, reportGeneratorConfiguration);
        } else if(reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.ACCUM.toString())) {
          report = new StaticReport(reportSpec, source, reportGeneratorConfiguration);
        }
      }
      if (report != null) {
        return report;
      }
      else {
        throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("7"),":",reportDef.getId()});
      }
    }
  }


  /**
   * Crea un Origen de Datos de Reporte (<code>ReportSource</code>) a partir de su definición (<code>ReportSourceDefinition</code>)
   * y aplicándole los valores de parámetros recibidos a los pre-filtros.
   * @param reportSourceDefinition
   * @param paramValues
   * @return
   * @throws InfoException Si no se pudo obtener el origen de dato
   */
  protected ReportSource getReportSource(ReportSpec reportSpec, ReportSourceDefinition reportSourceDefinition, Map paramValues) throws InfoException {
    ReportSource reportSource = null;
    if (reportSourceDefinition == null) {
      throw new InfoException(LanguageTraslator.traslate("8"));
    }
    else {
      reportSource = new ReportSource(reportSpec, paramValues, reportGeneratorConfiguration);
      return reportSource;
    }
  }

  /**
   * Crea un Origen de Datos de Reporte (<code>ReportSource</code>) a partir de su definición (<code>ReportSourceDefinition</code>)
   * resolviendo la obtención desde el cache, y el almacenamiento del mismo en caso de que un reporte cacheado se ejecute por
   * primera vez o en los reportes incrementales.
   * @param reportSpec
   * @return
   * @throws InfoException Si no se puede obtener el report source
   */
  protected ReportSource getReportSource(ReportSpec reportSpec) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("160")+":"+reportSpec.getDescription());
    ReportSource reportSource = null;
    if (reportSpec == null) {
      throw new InfoException(LanguageTraslator.traslate("9"));
    }
    else {
      boolean cached = reportSpec.getCached();
      boolean incremental = !reportSpec.getIncrementalDimension().equals("");
      if (cached) {
        try {
          reportSource = getReportSourceRepository().load(reportSpec);
        } catch (InfoException e) {
          throw new InfoException(LanguageTraslator.traslate("10"), e);
        }
        if (incremental) {
          if (reportSource == null) {
            try {
              reportSource = new ReportSource(reportSpec, reportGeneratorConfiguration);
            } catch (Exception e) {
              throw new InfoException(LanguageTraslator.traslate("11"), e);
            }
            boolean saved = getReportSourceRepository().saveIncrementalSource(reportSource);
            if (!saved) {
              getReportSourceRepository().saveNewSource(reportSource);
            }
          }
        }
      }
      if (reportSource == null) {
        reportSource = new ReportSource(reportSpec, reportGeneratorConfiguration);
        if (cached) {
          getReportSourceRepository().saveNewSource(reportSource);
        }
      }
      return reportSource;
    }
  }

  /** Inicializa la ejecución de reporte para una aplicación cliente, este método debe utilizarse para preparar reportes
   * cacheados, en este tipo de reporte los valores de los parámetros de los pre-filtros no pueden ser modificados por el
   * usuario y se utilizan los que figuran en la definición
   * @param reportDef definición de reporte
   * @return devuelve un identificador de la instancia del reporte en la sesión,
   * que se debe utilizar para sucesivas operaciones.
   * @throws InfoException Si no se pudo ejecutar el prepare
   */
  public int PrepareReport(ReportDefinition reportDef) throws InfoException {
    Report report = null;
    if (reportDef == null) {
      throw new InfoException(LanguageTraslator.traslate("12"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("196") + ":"+reportDef.getId());
      report = newReportFrom(reportDef);
      if (report != null) {
        int handle = registerReport(report);
        return handle;
      }
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("13"), ":",reportDef.getId()});
    }
  }


  /**
   * Inicializa la ejecución de reporte para una aplicación cliente, este método debe utilizarse para preparar reportes
   * no cacheados, en el parámetro <code>paramValues</code> se pueden incluir valores de parámetros para pre-filtros.
   * @param reportDef
   * @param paramValues
   * @return
   * @throws InfoException Si no se ejecutó el prepare
   */
  public int PrepareReport(ReportDefinition reportDef, Map paramValues) throws InfoException {
    Report report = null;
    if (reportDef == null) {
      throw new InfoException(LanguageTraslator.traslate("14"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("196") + ":"+reportDef.getId());
      report = newReportFrom(reportDef, paramValues);
      if (report != null) {
        int handle = registerReport(report);
        return handle;
      }
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("15"), ":", reportDef.getId()});
    }
  }


  /**
   * Da por terminada la ejecución de un reporte para una aplicación cliente
   * @param handle identificador de la instancia del reporte en la sesión
   */
  public void ReleaseReport(int handle) {
    try {
      ReportManagerLogger.debug(LanguageTraslator.traslate("197")+ ":"+getReportFrom(handle).getReportSpec().getDefinitionId());
    } catch (InfoException e) {
      ReportManagerLogger.error(LanguageTraslator.traslate("198"));
    }
    unRegisterReport(handle);
  }

  /**
   * Devuelve una Definición de Reporte a partir de un identificador
   * @param id identificador de Definición de Reporte
   * @return devuelve la Definición de Reporte correspondiente
   * @throws InfoException Si no se puede acceder a la definición
   */
  public ReportDefinition getReportDefinitionFromID(String id) throws InfoException {
    if (id.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("16"));
    }
    else {
      return getReportDefinitionRepository().loadFromID(id);
    }
  }

  /**
   * Devuelve una Definición de Origen de Datos a partir de un identificador
   * @param reportSourceDefinitionId identificador de Definición de Origen de Datos
   * @return devuelve la Definición de Origen de Datos correspondiente
   * @throws InfoException Si no se puede acceder a la definición
   */

  public ReportSourceDefinition getReportSourceDefinitionFromID(String reportSourceDefinitionId) throws InfoException {
    if (reportSourceDefinitionId.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("17"));
    }
    else {
      return getReportSourceDefinitionRepository().loadFromID(reportSourceDefinitionId);
    }
  }

  /**
   * Inicializa el report manager
   * @param reportGeneratorConfiguration
   * @throws InfoException
   */
  public void init(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    if(this.reportGeneratorConfiguration == null) {
      this.reportGeneratorConfiguration = reportGeneratorConfiguration;
    }
  }

  /**
   * Procesa una Definicion de Origen de datos de un reporte y lo graba en el repositorio correspondiente.
   * Se utiliza para preprocesar reportes marcados como <Code>Cached</Code>
   * @param reportSourceDefinitionId
   * @throws InfoException Si no se puede preparar el origen de dato
   */
  public void prepareReportSource(String reportSourceDefinitionId) throws InfoException {
    ReportSource source = null;
    if (reportSourceDefinitionId.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("18"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("161")+":"+reportSourceDefinitionId);
      ReportSourceDefinition reportSourceDefinition = getReportSourceDefinitionFromID(reportSourceDefinitionId);
      ReportSpec reportSpec = new ReportSpec(getReportGeneratorConfiguration());
      reportSpec.fillFrom(reportSourceDefinition);
      source = getReportSource(reportSpec);
    }
    if (source == null) {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("19"),":",reportSourceDefinitionId});
    }

  }


  /**
   * Devuelve todas las Definiciones de Reporte registradas en el Administrador de Reportes
   * @return devuelve todas las Definiciones de Reporte correspondientes
   * @throws InfoException
   */

  public Map getReportDefinitions() throws InfoException {
    try {
      return getReportDefinitionRepository().getAllDefinitions();
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("20"), e);
    }
  }

  /**
   * Devuelve todas las Definiciones de Origen de Datos registradas en el Administrador de Reportes
   * @return devuelve todas las Definiciones de Origen de Datos correspondientes
   * @throws InfoException
   */
  public Map getReportSourceDefinitions() throws InfoException {
    try {
      return getReportSourceDefinitionRepository().getAllDfefinitions();
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("21"), e);
    }

  }

  /**
   * Devuelve todas las Definiciones de Reporte asociadas a una entidad (a través del atributo <code>Entity</code> de
   * la definición de reporte
   * @param entityID identificador de la entidad externa asociada a Definiciones de Reporte
   * @return devuelve las Definicines de Reporte asociadas a la entidad especificada
   * @throws InfoException Si no se pudo obtener la lista
   */
  public Map getReportsForEntity(String entityID) throws InfoException {
    if (entityID.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("22"));
    }
    else {
      try {
        return getReportDefinitionRepository().getAllDfefinitionForEntity(entityID);
      } catch (Exception e) {
        throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("23"),":",entityID}, e);
      }
    }
  }

  /**
   * Ejecuta una acción sobre un reporte
   *
   * @param handle identificador del reporte preparado
   * @param actionName nombre de la acción que se desea ejecutar
   * @param params información obtenida de las dimensiones y métricas seleccionadas al solicitar
   * la ejecución de la acción. Por ahora figura como <code>Object</colde> porque no está definida la
   * estructura que será de proveer todos los datos necesarios
   */
  public void ExecuteAction(int handle, String actionName, Object params) {

  }

  public void saveReportDefinition(String reportDefinitionId) throws InfoException {
  }

  public void saveReportSourceDefinition(String reportSourceDefinitionId) throws InfoException {
  }

  /**
   * Devuelve la clave para el diccionario interno que almacena los reportes activos
   * @param handle
   * @return
   */
  private Object keyFromHandle(int handle) {
    Object key = new Integer(handle);
    return key;
  }


  /**
   * Genera claves numéricas para mantener un diccionario de reportes activos
   * @return
   */
  private int getNewHandle() {
    return lastHandle++;
  }


  /**
   * Diccionario de reportes activos
   * @return
   */
  protected HashMap getActiveReports() {
    if (activeReports == null) {
      activeReports = new HashMap();
    }
    return activeReports;
  }


  /**
   * Registra un reporte en el diccionario de reportes activos
   * @param report
   * @return
   */
  protected int registerReport(Report report) {
    int handle = getNewHandle();
    getActiveReports().put(keyFromHandle(handle), report);
    return handle;
  }

  /**
   * Elimina un reporte de la lista de reportes activos
   * @param handle
   */
  protected void unRegisterReport(int handle) {
    getActiveReports().remove(keyFromHandle(handle));
  }

  /**
   * Devuelve un reporte activo del diccionario a partir de su clave
   * @param handle
   * @return
   * @throws InfoException
   */
  protected Report getReportFrom(int handle) throws InfoException {
    Object key = keyFromHandle(handle);
    if (getActiveReports().containsKey(key)) {
      return (Report) getActiveReports().get(key);
    }
    throw new InfoException(LanguageTraslator.traslate("24"));
  }


  /**
   * Devuelve el Repositorio de Definitiones de Reporte (<code>ReportDefinition</code>)
   * @return
   */
  protected ReportDefinitionRepository getReportDefinitionRepository() {
    if (reportDefinitionRepository == null) {
      reportDefinitionRepository = new ReportDefinitionRepository(reportGeneratorConfiguration.getReportDefinitionRepositoryPath(), reportGeneratorConfiguration);
    }
    return reportDefinitionRepository;
  }


  /**
   * Devuelve el Repositorio de Definitiones de Origen de Reporte (<code>ReportSourceDefinition</code>)
   * @return
   */
  protected ReportSourceDefinitionRepository getReportSourceDefinitionRepository() {
    if (reportSourceDefinitionRepository == null) {
      reportSourceDefinitionRepository = new ReportSourceDefinitionRepository(reportGeneratorConfiguration.getReportSourceDefinitionRepositoryPath(), reportGeneratorConfiguration);
    }
    return reportSourceDefinitionRepository;
  }

  /**
   * Devuelve el Repositorio de Origenes de Reporte (<code>ReportSource</code>)
   * Estos son los reportes pre-procesaros (cacheados) y incrementales
   * @return
   */
  protected ReportSourceRepository getReportSourceRepository() {
    if (reportSourceRepository == null) {
      reportSourceRepository = new ReportSourceRepository(reportGeneratorConfiguration.getReportSourceRepositoryPath(), reportGeneratorConfiguration);
    }
    return reportSourceRepository;
  }

  /**
   * Devuelve el Repositorio de Vistas de Reportes
   * @return
   */
  protected ReportViewRepository getReportViewRepository() {
    if (reportViewRepository == null) {
      reportViewRepository = new ReportViewRepository(reportGeneratorConfiguration.getReportViewRepositoryPath(), reportGeneratorConfiguration);
    }
    return reportViewRepository;
  }

  /**
   * Almacena en el repositorio una definición de reporte
   * cumplido el plazo de vigencia
   * @param  reportDefinition Definición de reporte que se desea guardar
   * @throws InfoException Si no se pudo grabar la definición
   */
  public void saveReportDefinition(ReportDefinition reportDefinition) throws InfoException {
    if (reportDefinition == null) {
      throw new InfoException(LanguageTraslator.traslate("25"));
    }
    else {
      try {
        ReportManagerLogger.debug(LanguageTraslator.traslate("162")+":"+reportDefinition.getId());
        getReportDefinitionRepository().save(reportDefinition);
      } catch (InfoException e) {
        throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("26"),":",reportDefinition.getId()}, e);
      }
    }
  }

  /**
   * Almacena en el repositorio una definición de origen de datos
   * cumplido el plazo de vigencia
   * @param reportSourceDefinition Definición de Origen de Datos que se desea guardar
   * @throws InfoException Si no se pudo guardar le definición
   */

  public void saveReportSourceDefinition(ReportSourceDefinition reportSourceDefinition) throws InfoException {
    if (reportSourceDefinition == null) {
      throw new InfoException(LanguageTraslator.traslate("27"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("163")+":"+reportSourceDefinition.getId());
      getReportSourceDefinitionRepository().save(reportSourceDefinition);
    }
  }

  /**
   * Se utiliza para forzar la caducidad de un reporte cacheado o incrementeal aunque no se haya
   * cumplido el plazo de vigencia
   * @param reportSourceDefinitionId identificador de la Definición de Origen de Datos que se desea invalidar
   * @throws InfoException Si no se pudo invalidar un origen de dato cacheado
   */
  public void invalidateReportSource(String reportSourceDefinitionId) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("164")+":"+reportSourceDefinitionId);
    ReportSourceDefinition reportSourceDefinition = null;
    reportSourceDefinition = getReportSourceDefinitionRepository().loadFromID(reportSourceDefinitionId);
    if (reportSourceDefinition != null) {
      invalidateReportSource(reportSourceDefinition);
    }
    else {
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("28"),":",reportSourceDefinitionId});
    }
  }

  /**
   * Se utiliza para forzar la caducidad de un reporte cacheado o incremental aunque no se haya
   * cumplido el plazo de vigencia
   * @param reportSourceDefinition Definición de Origen de Datos que se desea invalidar
   * @throws InfoException Si no se pudo invalidar el origen de dato
   */
  public void invalidateReportSource(ReportSourceDefinition reportSourceDefinition) throws InfoException {
    if (reportSourceDefinition == null) {
      throw new InfoException(LanguageTraslator.traslate("29"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("164")+":"+reportSourceDefinition.getId());
      getReportSourceRepository().invalidateReportSource(getReportSpec(reportSourceDefinition));
    }
  }

  /** Se utiliza para obtener una <Code>ReportQuery</Code> para ser ejecutada al reporte cuyo identidicador que se
   * recibe como parámetro, utilizando este método se obtiene una query vacía, donde no hay métricas visibles ni dimensiones
   * que agrupan.
   * Si se desea ejecutar la query por defecto segun la Definition de Reporte se debe utilizar el método
   * <Code>getDefaultReportQuery</Code>
   * @param handle
   * @return
   */

  public ReportQuery getReportQuery(int handle) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("165"));
    Report report = getReportFrom(handle);
    return getReportQuery(report);
  }

  /**
   * Se utiliza para obtener la <Code>ReportQuery</Code> inicializada con los valores por defecto que figuran en la
   * Definición de Reporte
   * @param handle
   * @return
   */
  public ReportQuery getDefaultReportQuery(int handle) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("166"));
    Report report = getReportFrom(handle);
    return getDefaultReportQuery(report);
  }

  public ReportQuery getReportQuery(String reportDefinitionId) throws InfoException {
    return new ReportQuery(getReportSpec(reportDefinitionId));
  }

  public ReportQuery getDefaultReportQuery(String reportDefinitionId) throws InfoException {
    return new ReportQuery(getReportSpec(reportDefinitionId));
  }

  /**
   * Se utiliza para obtener la <Code>ReportQuery</Code> por defecto inicializada con los valores por defecto que figuran en la
   * Definición de Reporte y sobreescritos por el report view del usuario por defecto
   * @param handle
   * @return
   */
  public ReportQuery getDefaultReportQuery(int handle,String userID) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("166"));
    Report report = getReportFrom(handle);
    return getDefaultReportQuery(report,userID);
  }

  /**
   * Devuleve la lista de vistas para el usuario y reporte
   * @param reportDefinitionID
   * @param userID
   * @return
   * @throws InfoException
   */
  public Map getReportViews(String reportDefinitionID, String userID) throws InfoException {
    return getReportViewRepository().getAllViewForReportUser(reportDefinitionID,userID);
  }

  /**
   * Devuleve la lista de vistas para el reporte
   * @param reportDefinitionID
   * @return
   * @throws InfoException
   */
  public Map getReportViews(String reportDefinitionID) throws InfoException {
    return getReportViewRepository().getAllViewForDefinition(reportDefinitionID,this);
  }

  public ReportResult ExecReportQuery(int handle, String reportViewId) throws InfoException {
    return ExecReportQuery(handle,getReportView(reportViewId));
  }

  public String getDefaultReportViewId(String reportDefinitionId, String userId) throws InfoException {
    ReportView reportView = getDefaultView(reportDefinitionId, userId);
    if(reportView != null){
      return reportView.getId();
    }
    return null;
  }

  public void saveReportView(String reportViewId) throws InfoException {
    saveReportView(getReportView(reportViewId));
  }

  public ReportSpec getReportSpec(String reportDefinitionId, String reportSourceDefId) throws InfoException {
    ReportDefinition reportDefinition = getReportDefinitionFromID(reportDefinitionId);
    ReportSourceDefinition reportSourceDefinition = getReportSourceDefinitionFromID(reportSourceDefId);
    return getReportSpec(reportDefinition, reportSourceDefinition);
  }

  public ReportSpec getReportSpec(String reportDefinitionId) throws InfoException {
    ReportDefinition reportDefinition = getReportDefinitionFromID(reportDefinitionId);
    ReportSourceDefinition reportSourceDefinition = getReportSourceDefinitionFromID(reportDefinition.getReportSource());
    return getReportSpec(reportDefinition, reportSourceDefinition);
  }

  public ReportView getReportView(String reportViewId) throws InfoException {
    return null;
  }

  /**
   *
   * @param handle
   * @param reportView
   * @return
   * @throws InfoException
   */
  public ReportResult ExecReportQuery(int handle, ReportView reportView) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("167")+":"+reportView.getId());
    Report report = getReportFrom(handle);
    ReportQuery reportQuery = new ReportQuery(report.getReportSpec(),reportView);
    return ExecReportQuery(report, reportQuery);
  }


  public ReportView getReportViewFromID(String id,String reportDefinitionId,String userId) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("168")+":"+id);
    return getReportViewRepository().loadFromID(id,reportDefinitionId,userId);
  }

  /**
   * Graba un report view
   * @param reportView
   * @throws InfoException
   */
  public void saveReportView(ReportView reportView) throws InfoException {
    ReportManagerLogger.debug(LanguageTraslator.traslate("169")+":"+reportView.getId());
    getReportViewRepository().save(reportView);
  }


  /** Se utiliza para obtener una <Code>ReportQuery</Code> para ser ejecutada al reporte a pertir de una definición de
   * reporte, utilizando este método se obtiene una query vacía, donde no hay métricas visibles ni dimensiones que agrupan.
   * Si se desea ejecutar la query por defecto segun la Definition de Reporte se debe utilizar el método
   * <Code>getDefaultReportQuery</Code>
   * @param reportDefinition
   * @return
   * @throws InfoException Si no se pudo obtener el ReportQuery
   */

  public ReportQuery getReportQuery(ReportDefinition reportDefinition) throws InfoException {
    if (reportDefinition == null) {
      throw new InfoException(LanguageTraslator.traslate("30"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("165")+":"+reportDefinition.getId());
      ReportQuery query = new ReportQuery(getReportSpec(reportDefinition), false);
      return query;
    }
  }

  /**
   * Se utiliza para obtener la <Code>ReportQuery</Code> inicializada con los valores por defecto que figuran en la
   * Definición de Reporte
   * @param reportDefinition
   * @return
   * @throws InfoException Si no se puede obtener la query por defecto.
   */
  public ReportQuery getDefaultReportQuery(ReportDefinition reportDefinition) throws InfoException {
    if (reportDefinition == null) {
      throw new InfoException(LanguageTraslator.traslate("31"));
    }
    else {
      ReportQuery query = new ReportQuery(getReportSpec(reportDefinition));
      return query;
    }
  }


  /** Se utiliza para obtener una <Code>ReportQuery</Code> para ser ejecutada al reporte que se recibe como parámetro,
   * utilizando este método se obtiene una query vacía, donde no hay métricas visibles ni dimensiones que agrupan.
   * Si se desea ejecutar la query por defecto segun la Definition de Reporte se debe utilizar el método
   * <Code>getDefaultReportQuery</Code>
   * @param report
   * @return
   * @throws InfoException
   */
  protected ReportQuery getReportQuery(Report report) throws InfoException {
    if (report == null) {
      throw new InfoException(LanguageTraslator.traslate("32"));
    }
    else {
      return report.getQuery();
    }
  }

  /**
   * Se utiliza para obtener la <Code>ReportQuery</Code> inicializada con los valores por defecto que figuran en la
   * Definición de Reporte
   * @param report
   * @return
   * @throws InfoException
   */
  protected ReportQuery getDefaultReportQuery(Report report) throws InfoException {
    if (report == null) {
      throw new InfoException(LanguageTraslator.traslate("33"));
    }
    else {
      return report.getDefaultQuery();
    }
  }

  /**
   * Se utiliza para obtener la <Code>ReportQuery</Code> inicializada con los valores por defecto que figuran en la
   * Definición de Reporte y los del la vista por defecto del usuario
   * @param report
   * @return
   * @throws InfoException
   */
  protected ReportQuery getDefaultReportQuery(Report report, String userID) throws InfoException {
    if (report == null) {
      throw new InfoException(LanguageTraslator.traslate("34"));
    }
    else {
      return report.getDefaultQuery(getDefaultView(report.getReportSpec().getDefinitionId(),userID));
    }
  }

  /**
   *  Obtiene la vista por defecto para el usuario
   */
  protected ReportView getDefaultView(String reportDefinitionID, String userID) throws InfoException {
    return getReportViewRepository().getDefaultViewForReportUser(reportDefinitionID,userID);

  }

  /** Ejecuta la query, o vista, por Default de un reporte a partir del identificador
   * de la instancia de reporte obtenido del método <code>PrepareReport</code>
   * paramValues es un diccionario cuyas entradas contienen en la clave el nombre del parámetro y cuyos objetos asociados
   * contienen los valores de los parámetros
   * Nota: la clave de los parámetros se compone concatenando el nombre de la definición filtro y el nombre del
   * parámetro del filtro.
   * Ejemplo 1:
   *    Definición de filtro: RANGO_CLIENTE (tipo RANGE)-> determina dos parámetros(claves): RANGO_CLIENTEFROM y RANGO_CLIENTETO
   *    (el filtro de tipo RANGE tiene dos parámetros, FROM y TO)
   * Ejemplo 2:
   *    Definicion de filtro: DESDE_CLIENTE (tipo GREATERTHAN) -> determina un parámetro(clave): DESDE_CLIENTEVALUE
   *    (el filtro de tipo GREATERTHAN tiene un parámetro, VALUE)
   * @param handle identificador del reporte preparado
   * @param paramValues valores de parámetros
   * @return devuelve la información resultante de la ejecución de la query
   */

  public ReportResult ExecReportQuery(int handle, Map paramValues) throws InfoException {
    Report report = getReportFrom(handle);
    return ExecReportQuery(report, paramValues);
  }

  /** Ejecuta una query, o vista, de un reporte a partir del identificador
   * de la instancia de reporte obtenido del método <code>PrepareReport</code>
   * @param handle identificador del reporte preparado
   * @param query es una estructura de datos que especifica las dimensiones que se desea visualizar,
   * en que orden, su ubicación y las métricas deseadas.
   * @return devuelve la información resultante de la ejecución de la query
   */

  public ReportResult ExecReportQuery(int handle, ReportQuery query) throws InfoException {
    Report report = getReportFrom(handle);
    return ExecReportQuery(report, query);
  }

  /** Ejecuta la query, o vista, por Default de un reporte a partir de una instancia de Reporte
   * creada en base una definición
   * de la instancia de reporte obtenido del método <code>PrepareReport</code>
   * @param report
   * @param paramValues
   * @return
   * @throws InfoException
   */

  protected ReportResult ExecReportQuery(Report report, Map paramValues) throws InfoException {
    if (report == null) {
      throw new InfoException(LanguageTraslator.traslate("35"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("172"));
      return report.ExecQuery(paramValues);
    }
  }

  /**Ejecuta una query, o vista, de un reporte a partir del una instancia de Reporte
   * creada en base una definición
   * @param report
   * @param query
   * @return
   * @throws InfoException
   */
  protected ReportResult ExecReportQuery(Report report, ReportQuery query) throws InfoException {
    return report.ExecQuery(query);
  }

  /** Ejecuta la query, o vista, por Default de un reporte a partir un identificador de definición de reporte
   * Esta version del método se utiliza para ejecutar un reporte al que no se le ejecutarán nuevas
   * querys y acciones. Para esto no hace falta llamar a <code>PrepareReport</code>
   * @param reportDefinitionID definición de reporte
   * @param paramValues valores de parámetros
   * @return devuelve la información resultante de la ejecución de la query
   * @throws InfoException
   */

  public ReportResult ExecReportQuery(String reportDefinitionID, Map paramValues) throws InfoException {
    if (reportDefinitionID.equals("")) {
      throw new InfoException(LanguageTraslator.traslate("36"));
    }
    else {
      return ExecReportQuery(getReportDefinitionFromID(reportDefinitionID), paramValues);
    }
  }

  /** Ejecuta una query, o vista, de un reporte a partir un identificador de definición de reporte
   * Esta version del método se utiliza para ejecutar un reporte al que no se le ejecutarán nuevas
   * querys y acciones. Para esto no es necesario llamar a <code>PrepareReport</code>
   * @param reportDefinitionID definición de reporte
   * @param query es una estructura de datos que especifica las dimensiones que se desea visualizar,
   * en que orden, su ubicación y las métricas deseadas.
   * @return devuelve la información resultante de la ejecución de la query
   */

  public ReportResult ExecReportQuery(String reportDefinitionID, ReportQuery query) throws InfoException {
    return ExecReportQuery(getReportDefinitionFromID(reportDefinitionID), query);
  }

  /** Ejecuta la query, o vista, por Default de un reporte a partir una definición de reporte
   * Esta versión del método se utiliza para ejecutar un reporte al que no se le ejecutarán nuevas
   * querys y acciones. Para esto no hace falta llamar a <code>PrepareReport</code>
   * @param reportDef definición de reporte
   * @return devuelve la información resultante de la ejecución de la query
   * @throws InfoException
   */
  public ReportResult ExecReportQuery(ReportDefinition reportDef, Map paramValues) throws InfoException {
    Report report = null;
    if (reportDef == null) {
      throw new InfoException(LanguageTraslator.traslate("37"));
    }
    else {
      try {
        report = newReportFrom(reportDef, paramValues);
      } catch (InfoException e) {
        throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("38"),":",reportDef.getId()}, e);
      }
      if (report != null) {
        return ExecReportQuery(report, paramValues);
      }
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("39"),":",reportDef.getId()});
    }
  }

  /** Ejecuta una query, o vista, de un reporte a partir una definición de reporte
   * Esta versión del método se utiliza para ejecutar un reporte al que no se le ejecutarán nuevas
   * querys y acciones. Para esto no es necesario llamar a <code>PrepareReport</code>
   * @param reportDef definición de reporte
   * @param query es una estructura de datos que especifica las dimensiones que se desea visualizar,
   * en que orden, su ubicación y las métricas deseadas.
   * @return devuelve la información resultante de la ejecución de la query
   */

  public ReportResult ExecReportQuery(ReportDefinition reportDef, ReportQuery query) throws InfoException {
    Report report = null;
    if (reportDef == null) {
      throw new InfoException(LanguageTraslator.traslate("40"));
    }
    else {
      report = newReportFrom(reportDef);
      if (report != null) {
        return ExecReportQuery(report, query);
      }
      throw new MultipleStringInfoException(new String[]{LanguageTraslator.traslate("41"),":",reportDef.getId()});
    }
  }

  /** Inicializa la ejecución de reporte para una aplicación cliente, este método debe utilizarse para preparar reportes
   * cacheados, en este tipo de reporte los valores de los parámetros de los pre-filtros no pueden ser modificados por el
   * usuario y se utilizan los que figuran en la definición
   * @param reportDefinitionID identificador de definición de reporte
   * @return devuelve un identificador de la instancia del reporte en la sesión,
   * que se debe utilizar para sucesivas operaciones.
   * @throws InfoException Si no se pudo ejecutar el prepare
   */
  public int PrepareReport(String reportDefinitionID) throws InfoException {
    ReportDefinition reportDefinition = getReportDefinitionFromID(reportDefinitionID);
    return PrepareReport(reportDefinition);
  }

  public int PrepareReport(String reportDefinitionId, Map paramValues) throws InfoException {
    return PrepareReport(getReportDefinitionFromID(reportDefinitionId),paramValues);
  }

  /**
   * Devuelve el log
   * @return
   */
  public Log getLogger() {
    return ReportManagerLogger.getLog();
  }

  /**
   * Asigna el log
   * @param log
   */
  public void setLogger(Log log) {
    ReportManagerLogger.setLog(log);
  }

  /**
   * Registra las definiciones disponibles en el directorio de sources files
   * @throws InfoException
   */
  public void registerDefinitions() throws InfoException{
    registerReportDefinitions(new Vector());
    registerReportSourceDefinitions(new Vector());
    registerReportViews(new Vector());
  }

  /**
   * Borra todos los repositorios
   * @throws InfoException
   */
  public void deleteAllRepositories() throws InfoException{
    getReportDefinitionRepository().deleteAll();
    getReportSourceRepository().deleteAll();
    getReportSourceDefinitionRepository().deleteAll();
    //getReportViewRepository().deleteAll();
  };

  /**
   * Borra del repositorio todas las definiciones menos los cache
   * @throws InfoException
   */
  public void deleteAllDefinitions() throws InfoException{
    getReportDefinitionRepository().deleteAll();
    getReportSourceDefinitionRepository().deleteAll();
    //getReportViewRepository().deleteAll();
  };

  /**
   * Borra del depositorio todos los report source
   * @throws InfoException
   */
  public void deleteReportSourceRepository() throws InfoException{
    getReportSourceRepository().deleteAll();
  };

  /**
   * Borra del repositorio todas las report source definition
   * @throws InfoException
   */
  public void deleteReportSourceDefinitionRepository() throws InfoException{
    getReportSourceRepository().deleteAll();
  };

  /**
   * Borra del repositorio todas las report definition
   * @throws InfoException
   */
  public void deleteReportDefinitionRepository() throws InfoException{
    getReportDefinitionRepository().deleteAll();
  };

  /**
   * Borra del repositorio todas las report views
   * @throws InfoException
   */
  public void deleteReportViewRepository() throws InfoException{
    getReportViewRepository().deleteAll();
  };

  /**
   * Borra el report view
   * @param id
   * @param reportDefinitionId
   * @param userId
   * @throws InfoException
   */
  public void deleteReportView(String id, String reportDefinitionId, String userId) throws InfoException{
    getReportViewRepository().delete(id,reportDefinitionId,userId);
  }

  public void deleteReportSource(String reportSourceDefinitionId) throws InfoException {
  }
  ;

  /**
   * Borra el report source
   * @param reportSourceDefinition
   * @throws InfoException
   */
  public void deleteReportSource(ReportSourceDefinition reportSourceDefinition) throws InfoException{
    getReportSourceRepository().deleteReportSource(getReportSpec(reportSourceDefinition));
  };

  /**
   * Borra el report source definition
   * @param reportSourceDefinitionID
   * @throws InfoException
   */
  public void deleteReportSourceDefinition(String reportSourceDefinitionID) throws InfoException{
    getReportSourceDefinitionRepository().delete(reportSourceDefinitionID);
  };

  /**
   * Borra el report definition
   * @param reportDefinitionID
   * @throws InfoException
   */
  public void deleteReportDefinition(String reportDefinitionID) throws InfoException{
    getReportDefinitionRepository().delete(reportDefinitionID);
  };

  /**
   * Asigna el la vista por defecto para el usuario
   * @param id
   * @param reportDefinitionId
   * @param userId
   * @throws InfoException
   */
  public void assingDefaultView(String id, String reportDefinitionId, String userId) throws InfoException{
    getReportViewRepository().assingDefaultView(id,reportDefinitionId,userId);
  };

  /**
   * Registra los reportdefinitions que esten en el path
   */
  public Vector registerReportDefinitions(Vector exceptions) throws InfoException {
    try {
      FileSystemManager fileSystemManager = FileSystemResolver.getFileSystemManager(getReportGeneratorConfiguration());
      FileObject fileObject = fileSystemManager.resolveFile(getReportGeneratorConfiguration().getSourceReportDefinitionsPath());
      String fileName;
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
        if(!fileName.endsWith(".xml")) {
            continue;
        }
        ReportManagerLogger.debug(LanguageTraslator.traslate("276")+":"+fileName);
        try {
          saveReportDefinition((ReportDefinition) Unmarshaller.unmarshal(ReportDefinition.class, new FileReader(getReportGeneratorConfiguration().getSourceReportDefinitionsPath() + "/" + fileName)));
        }
        catch (Exception e) {
          exceptions.add(e);
        }
      }
    }
    catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("210"), e);
    }
    return exceptions;
  }


  /**
   * Registra los reportsourcedefinitions que esten en el path
   */
  public Vector registerReportSourceDefinitions(Vector exceptions) throws InfoException {
    try {
      FileSystemManager fileSystemManager = FileSystemResolver.getFileSystemManager(getReportGeneratorConfiguration());
      FileObject fileObject = fileSystemManager.resolveFile(getReportGeneratorConfiguration().getSourceReportSourceDefinitionsPath());
      String fileName;
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
        if(!fileName.endsWith(".xml")) {
            continue;
        }
        ReportManagerLogger.debug(LanguageTraslator.traslate("275")+":"+fileName);
        try {
          ReportSourceDefinitionVersion.validateVersion(fileObject.getChildren()[i]);
          saveReportSourceDefinition((ReportSourceDefinition) Unmarshaller.unmarshal(ReportSourceDefinition.class, new FileReader(getReportGeneratorConfiguration().getSourceReportSourceDefinitionsPath() + "/" + fileName)));
        }
        catch (Exception e) {
          exceptions.add(e);
        }
      }
    }
    catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("209"), e);
    }
    return exceptions;
  }

  /**
   * Registra los reportviews que esten en el path
   */
  public Vector registerReportViews(Vector exceptions) throws InfoException {
    try {
      FileSystemManager fileSystemManager = FileSystemResolver.getFileSystemManager(getReportGeneratorConfiguration());
      FileObject fileObject = fileSystemManager.resolveFile(getReportGeneratorConfiguration().getSourceReportViewsPath());
      String fileName;
      for (int i = 0; i < fileObject.getChildren().length; i++) {
        fileName = fileObject.getChildren()[i].getName().getBaseName();
        if(!fileName.endsWith(".xml")) {
            continue;
        }
        ReportManagerLogger.debug(LanguageTraslator.traslate("277")+":"+fileName);
        try {
          saveReportView((ReportView) Unmarshaller.unmarshal(ReportView.class, new FileReader(getReportGeneratorConfiguration().getSourceReportViewsPath() + "/" + fileName)));
        }
        catch (Exception e) {
          exceptions.add(e);
        }
      }
      return exceptions;
    }
    catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("252"), e);
    }
  }


  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }

  /**
   * Devuelve el reportview por defecto para el usuario
   * @param reportDefinitionId
   * @param userId
   * @return
   * @throws InfoException
   */
  public ReportView getDefaultReportView(String reportDefinitionId, String userId) throws InfoException{
    return getReportViewRepository().getDefaultViewForReportUser(reportDefinitionId,userId);
  };


  /**
   * Ejecuta un reporte Para un Micro report
   * @param microReport
   * @return
   * @throws InfoException
   */
  public ReportResult ExecReportQuery(MicroReport microReport) throws InfoException{
    Map map = new HashMap();
    return this.ExecReportQuery(microReport.getReportDefinition().getId(),map);
  }

  /**
   * Inicializa la ejecución de un reporte a partir de un Micro Report
   * @param microReport
   * @return
   * @throws InfoException
   */
  public int PrepareReport(MicroReport microReport) throws InfoException{
    Report report = null;
    if (microReport.getReportDefinition() == null) {
      throw new InfoException(LanguageTraslator.traslate("12"));
    }
    else {
      ReportManagerLogger.debug(LanguageTraslator.traslate("196") + ":"+microReport.getReportDefinition().getId());
      ReportSpec reportSpec = getReportSpec(microReport.getReportDefinition(),microReport.getReportSourceDefinition());
      ReportSource reportSource = new ReportSource(reportSpec, microReport.getMatrix(), reportGeneratorConfiguration) ;
      if((reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CUBE.toString())) ||
        (reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CHARTCUBE.toString()))) {
        report = new CubeReport(reportSpec, reportSource, reportGeneratorConfiguration);
      } else if(reportSpec.getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.ACCUM.toString())) {
        report = new StaticReport(reportSpec, reportSource, reportGeneratorConfiguration);
      }
      if (report != null) {
        int handle = registerReport(report);
        return handle;
      }
    }
    return 0;
  }

  /**
   * Retorna un MicroReport zip
   * @param reportHandle
   * @param reportView
   * @param userID
   * @param fileName
   * @return
   * @throws InfoException
   */
 /* public ZipOutputStream getMicroReport(int reportHandle, ReportView reportView,String userID,String fileName) throws InfoException {
    try {
      ReportDefinition reportDefinition = getReportDefinitionFromID(reportView.getReportDefinitionId());
      ReportSourceDefinition reportSourceDefinition = getReportSourceDefinitionFromID(reportDefinition.getReportSource());
      MicroReport microReport = new MicroReport(getReportFrom(reportHandle).getPivot().getMatrix(),reportSourceDefinition,reportDefinition,reportView,"",userID,getReportViews(reportDefinition.getId(),userID));
      return microReport.getZip(fileName);
    }catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("12"));
    }
  }
*/
  /**
   * Retorna la matris para un handle
   * @param handle
   * @return
   * @throws InfoException
   */
  public Matrix getMatrix(int handle) throws InfoException{
    return getReportFrom(handle).getPivot().getMatrix();
  }

  public String getXML(int handle) throws InfoException {
    return getReportFrom(handle).getXml();
  }

  public String getXML(String reportDefinitionID, Map paramValues) throws InfoException {
    int handle = PrepareReport(getReportDefinitionFromID(reportDefinitionID),paramValues);
    return getXML(handle);
  }

  public Set getDimensionValues(int handle, String name) throws InfoException {
    return getReportFrom(handle).getDimensionValues(name);
  }

  public Set getDimensionValues(String reportDefinitionID, Map paramValues, String name) throws InfoException {
    int handle = PrepareReport(getReportDefinitionFromID(reportDefinitionID),paramValues);
    return getDimensionValues(handle,name);
  }

  public Vector getUpdatedDataModel(int handle, int mode, int row, int col, boolean isDistributed) throws InfoException {
    return ((CubeReport)getReportFrom(handle)).getUpdatedDataModel(mode, row,col, isDistributed);
  }

  /**
   * Valida un usuario
   * @param userName Nombre del usuario
   * @param password Password del usuario
   * @param userRepositoryPath Localizacion del repositorio en el sistema
   * @return indica si la validacion ha sido satisfactoria
   * @throws InfoException
   */
  public boolean validateUser(String userName, String password, String userRepositoryPath) throws InfoException {
    boolean authenticated = false;
    UsersRepository repository = new UsersRepository(userRepositoryPath);
    File file = new File(userRepositoryPath);
    if(file.exists()) {
      authenticated = repository.validate(userName, password);
    } else {
      repository.addNewUser("root", password);
      authenticated = true;
    }
    return authenticated;
  }

  public void exportReport(String userName, String password,String userRepositoryPath, String reportDefinitionId, Map paramValues, boolean isLandscape, int type, String destinationPath, String name) throws InfoException {
    if (validateUser(userName,password,userRepositoryPath)){
      try {
        ReportDefinition reportDefinition = getReportDefinitionFromID(reportDefinitionId);
        ReportSourceDefinition reportSource = getReportSourceDefinitionFromID(reportDefinition.getReportSource());
        ReportSpec reportSpec = getReportSpec(reportDefinition, reportSource);
        ReportResult reportResult = null;
        if(!(reportDefinition.getReportType()==ReportDefinitionReportTypeType.STATICSQL)){
          reportResult = ExecReportQuery(reportDefinition,paramValues);
        }
        ReportLayoutBuilder builder = new ReportLayoutBuilder(getReportGeneratorConfiguration(), reportSpec, reportResult, paramValues);
        JasperPrint print = builder.getJasperPrint(isLandscape);
        exportReport(print, (destinationPath + name), type);
        System.out.println("Reporte Exportado");
      }catch(Exception e){
        throw new InfoException(LanguageTraslator.traslate("312"), e);
      }
    } else{
      throw new InfoException(LanguageTraslator.traslate("295"));
    }
  }

  public byte[] exportReport(Map params) throws InfoException {
    try{
      Object reportViewId = params.get("ReportViewId");
      Object reportDefinitionId = params.get("ReportDefinitionId");
      ReportDefinition definition = null;
      try {
        if ((params!=null)&&(params.containsKey("NOMBRE2VALUE"))&&(params.get("NOMBRE2VALUE").toString().equals("BORRAR_REPOSITORIO"))){
          getReportDefinitionRepository().getCache().deleteAll();
          getReportSourceDefinitionRepository().getCache().deleteAll();
          registerDefinitions();
        }
      }catch(Exception e){  }
      ReportView view = null;
      try{
        if(reportViewId!=null && !reportViewId.toString().equalsIgnoreCase("")){
          view = getReportView(reportViewId.toString());
          definition = getReportDefinitionFromID(view.getReportDefinitionId());
        }else if(reportDefinitionId!=null && !reportDefinitionId.toString().equalsIgnoreCase("")){
          definition = getReportDefinitionFromID(reportDefinitionId.toString());
        }else{
          throw new InfoException(LanguageTraslator.traslate("2"));
        }
      }catch(Exception e)
      {
        registerDefinitions();
        if(reportViewId!=null && !reportViewId.toString().equalsIgnoreCase("")){
          view = getReportView(reportViewId.toString());
          definition = getReportDefinitionFromID(view.getReportDefinitionId());
        }else if(reportDefinitionId!=null && !reportDefinitionId.toString().equalsIgnoreCase("")){
          definition = getReportDefinitionFromID(reportDefinitionId.toString());
        }
      }
      ReportSpec spec = getReportSpec(definition);
      ReportResult result = null;
      if(definition.getReportType()!=ReportDefinitionReportTypeType.STATICSQL){
        result = ExecReportQuery(definition, params);
      }
      ReportLayoutBuilder builder = new ReportLayoutBuilder(getReportGeneratorConfiguration(),spec, result, params);
      boolean isLandscape = true;
      if(params.get("IsLandscape")!=null){
        if(params.get("IsLandscape").toString().equalsIgnoreCase("false")){
          isLandscape = false;
        }
      }
      JasperPrint print = builder.getJasperPrint(isLandscape);
      if(params.containsKey("FORMATOSALIDA") && params.get("FORMATOSALIDA").toString().equals("EXCEL")){

          StaticReportExcelSerializer staticReportSerializer = new StaticReportExcelSerializer(result);
          return staticReportSerializer.serialize();

       /*
        JRXlsExporter xlsExporter = new JRXlsExporter();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        xlsExporter.exportReport();
        return stream.toByteArray();*/
      }
      return JasperExportManager.exportReportToPdf(print);
    }catch (Exception e){
      e.printStackTrace();
      throw new InfoException(LanguageTraslator.traslate( "311"), e);
    }
  }


/*  private JasperPrint getJasperPrint(ReportDefinition reportDefinition, Map paramValues, boolean isLandscape) throws InfoException{
    try{
      ReportResult reportResult = ExecReportQuery(reportDefinition,paramValues);
      com.calipso.reportgenerator.common.ReportTableModel reportTableModel = reportResult.getReportTableModel();
      IJasperDefinition jasperDefinition = getJasperDefinition(reportResult, reportTableModel, reportDefinition.getTitle());
      JasperReport report = JasperCompileManager.compileReport(jasperDefinition.getJasperDefinition(isLandscape));
      ReportMap.setParametersToSimpleType(paramValues);
      return JasperFillManager.fillReport(report, paramValues, reportTableModel);
    }catch (Exception e){
      throw new InfoException(LanguageTraslator.traslate("312"), e);
    }
  }

  public JasperPrint getJasperPrintFromSql(ReportDefinition reportDefinition, Map paramValues, boolean isLandscape) throws InfoException {
    try {
      if(!(paramValues instanceof HashMap)){
        paramValues = new HashMap();
      }
      ReportSourceDefinition reportSource = getReportSourceDefinitionFromID(reportDefinition.getReportSource());
      ReportSpec reportSpec = getReportSpec(reportDefinition, reportSource);
      ReportQuery query = new ReportQuery(reportSpec);
      com.calipso.reportgenerator.common.ReportTableModel reportTableModel = getStaticNonDataTableModel(reportSpec, query);
      ReportDataSourceSpec dataSourceSpec = (ReportDataSourceSpec)reportSpec.getDataSourceSpecs().toArray()[0];
      Connection con = getConnection(dataSourceSpec, reportSpec);
      IJasperDefinition jasperDefinition = getSQLJasperDefinition(reportSpec, reportTableModel, reportDefinition.getTitle(), isLandscape);
      ((StaticSQLJasperReportDefinition)jasperDefinition).setSQLText(dataSourceSpec.getExpression());
      JasperReport report = JasperCompileManager.compileReport(jasperDefinition.getJasperDefinition(isLandscape));
      return JasperFillManager.fillReport(report, paramValues, con);
    }catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("312"), e);
    }
  }

  private Connection getConnection(ReportDataSourceSpec dataSourceSpec, ReportSpec reportSpec) throws InfoException{
    DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString = new DataSourceDefinitionConnectionString(dataSourceSpec.getExternalConnectionValues());
    try {
      Class.forName(dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationClassName"));
      return DriverManager.getConnection(dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationLocalUrl"), dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationUser"), dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationPassword"));
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("97"), e);
    }
  }

  private com.calipso.reportgenerator.common.ReportTableModel getStaticNonDataTableModel(ReportSpec reportSpec, ReportQuery query) {
    return new StaticReportTableModel(reportSpec, query);
  }

  private IJasperDefinition getSQLJasperDefinition(ReportSpec reportSpec, com.calipso.reportgenerator.common.ReportTableModel reportTableModel, String tittle, boolean isLandscape) throws InfoException{
    if ((reportSpec.getLayoutDesign()==null) || reportSpec.getLayoutDesign().equals("")) {
      return new StaticSQLJasperReportDefinition(reportSpec, reportTableModel.getModel(), reportTableModel.getGroupingDimCount(), reportTableModel.getCommonMetricsCount(),
        reportTableModel.getNonGroupingDimCount(), reportTableModel.getAccMetricsCount(), tittle, params);
    }else{
      String layoutName = reportSpec.getLayoutDesign().endsWith(".xml") ? reportSpec.getLayoutDesign() : reportSpec.getLayoutDesign() + ".xml";
      IJasperDefinition jasper = new ExternalJasperDefinition(getReportGeneratorConfiguration().getSourceReportLayoutPath() + "/" + layoutName);
      return setSQLJasperDefinition(jasper, isLandscape);
    }
  }

  private IJasperDefinition setSQLJasperDefinition(IJasperDefinition jasper, boolean isLandscape) throws InfoException{
    return new StaticSQLJasperReportDefinition(jasper, isLandscape);
  }*/


  private void exportReport(JasperPrint print, String destFile, int type) throws JRException, InfoException {
    switch(type){
          case ReportExportFormatType.PDF_TYPE:
            JasperExportManager.exportReportToPdfFile(print,destFile);
            break;
          case ReportExportFormatType.XML_TYPE:
            JasperExportManager.exportReportToXmlFile(print,destFile, false);
            break;
          case ReportExportFormatType.HTML_TYPE:
            JasperExportManager.exportReportToHtmlFile(print,destFile);
            break;
          case ReportExportFormatType.EXCEL_TYPE:
            JRXlsExporter xlsExporter = new JRXlsExporter();
            xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
            xlsExporter.exportReport();
            break;
          case ReportExportFormatType.COMMA_TYPE:
            JRCsvExporter CsvExporter = new JRCsvExporter();
            CsvExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            CsvExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
            CsvExporter.exportReport();
            break;
          default: throw new InfoException("312");
        }
  }

  /*private IJasperDefinition getJasperDefinition(ReportResult reportResult, com.calipso.reportgenerator.common.ReportTableModel reportTableModel, String tittle) throws InfoException {
    IJasperDefinition design = null;
    if ((reportResult.getReportSpec().getLayoutDesign()==null) || reportResult.getReportSpec().getLayoutDesign().equals("")) {
      if (reportResult.getReportSpec().getReportType().getType() == ReportDefinitionReportTypeType.CUBE_TYPE) {
        design = new CubeJasperReportDefinition(reportResult, reportTableModel.getModel(), reportTableModel.getGroupingDimCount(), reportTableModel.getCommonMetricsCount(),
                reportTableModel.getNonGroupingDimCount(), reportTableModel.getAccMetricsCount(), tittle);
      } else {
        design = new StaticJasperReportDefinition(reportResult, reportTableModel.getModel(), reportTableModel.getGroupingDimCount(), reportTableModel.getCommonMetricsCount(),
                reportTableModel.getNonGroupingDimCount(), reportTableModel.getAccMetricsCount(), tittle);
      }
    } else {
      String layoutName = reportResult.getReportSpec().getLayoutDesign().endsWith(".xml") ? reportResult.getReportSpec().getLayoutDesign() : reportResult.getReportSpec().getLayoutDesign() + ".xml";
      design = new ExternalJasperDefinition(getReportGeneratorConfiguration().getSourceReportLayoutPath() + "/" + layoutName);
    }
    return design;
  }

  private void setJasperCompiler() {
    if (!reportGeneratorConfiguration.getJasperCompilerClass().equals("")) {
      System.setProperty("jasper.reports.compiler.class", reportGeneratorConfiguration.getJasperCompilerClass());
    } else if (!reportGeneratorConfiguration.getJasperReportPath().equals("")) {
      System.setProperty("jasper.reports.compile.class.path", reportGeneratorConfiguration.getJasperReportPath());
    }
  }*/

  public boolean addNewUser(String rootPasswd, String userName, String password, String userRepositoryPath) throws InfoException {
    UsersRepository repository = new UsersRepository(userRepositoryPath);
    if(repository.validate("root", rootPasswd)) {
      repository.addNewUser(userName, password);
      return true;
    }
    return false;
  }

  public boolean changePasswd(String userName, String oldPasswd, String newPasswd, String userRepositoryPath) throws InfoException {
    UsersRepository repository = new UsersRepository(userRepositoryPath);
    if(repository.validate(userName, oldPasswd)) {
      repository.changePasswd(userName, newPasswd);
      return true;
    }
    return false;
  }

  public boolean deleteUser(String userName, String password, String userRepositoryPath) {
    UsersRepository repository = new UsersRepository(userRepositoryPath);
    if(repository.validate(userName, password)) {
      repository.deleteUser(userName);
      return true;
    }
    return false;
  }

}

