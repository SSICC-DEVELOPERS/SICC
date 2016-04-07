

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import es.indra.mare.common.info.InfoException;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.client.ReportManagerService;
import es.indra.sicc.rep.dtos.DTOReporte;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MareTest {

  IReportManager reportManager;
  ReportGeneratorConfiguration configuration;
  
  public static void main(String args[]) throws InfoException {
    System.setProperty("MareConfigurationRoot", "C:/construccion/Belcorp/PROYECTO.V03.03/MARE-CONF/mare/mare-conf");
    MareTest mareTest  = new MareTest();
    try {
      mareTest.execute();
    }
    catch (Exception e) {
    }
  }
  
  private Map extractParams(DTOReporte dtoReporte){
    HashMap params = new HashMap();
    params.put("ReportDefinitionId",dtoReporte.getIdReporte());
    return params;   
  }
  
  private String getConfigurationPath() {
    return System.getProperty("MareConfigurationRoot")+"/reportes";
  }

  private ReportGeneratorConfiguration getConfiguration() throws InfoException {
    if (configuration == null) {
      configuration = new ReportGeneratorConfiguration(ReportGeneratorConfiguration.getConfiguration(""));    
    } 
    return configuration;
  }
  
  public void execute() throws Exception{
    //params.put("reportDefinitionID","RD_REP-026");
    DTOReporte dtoReporte = new DTOReporte();
//    dtoReporte.setIdReporte("RD_REP-027");
    HashMap param = new HashMap();
    param.put("ReportDefinitionId","RD_REP-027");
    param.put("countryparamVALUE","PERU");
    param.put("zoneuserVALUE","USUARIO1");      
    param.put("moduleVALUE","SEG");
    param.put("IDIOMAVALUE","2");    
    IReportManager service = getReportManager(getConfiguration());
    service.registerDefinitions();
    try{
      byte[] pdf = service.exportReport(param);
      FileOutputStream file = new FileOutputStream("archivopdf.pdf");
      file.write(pdf);      
    }catch(Exception e)
    {
    //  System.out.println(e.toString());
    }

  }
  
  /**
   * Obtiene un ReportManagera partir de la configuración especificada en ReportManagerConfiguration
   * @param reportGeneratorConfiguration la configuracion que especifica path de los repositorios
   * , si es distribuida, host, port.
   * @return interface que publica los métodos a invocar por parte del usuario
   */
  private IReportManager getReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    if (reportManager == null) {
      LanguageTraslator.newLocaleFrom(reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry(),reportGeneratorConfiguration.getLanguagesPath());
      reportManager = ReportManagerService.getReportManagerService(getConfigurationPath(), null);
    }  
    return reportManager;
  }  
  
  private void registerReports() throws InfoException {
    getReportManager(getConfiguration()).registerDefinitions();
  }
}