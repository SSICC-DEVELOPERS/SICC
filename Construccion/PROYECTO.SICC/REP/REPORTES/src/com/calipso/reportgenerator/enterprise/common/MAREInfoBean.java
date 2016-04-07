package com.calipso.reportgenerator.enterprise.common;
import com.calipso.reportgenerator.common.BelcorpDecoratedReportLayout;
import com.calipso.reportgenerator.common.ILanguageTraslator;
import com.calipso.reportgenerator.common.IReportManager;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.MultipleStringInfoException;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.reportmanager.ReportManager;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.info.InfoException;
import es.indra.sicc.rep.dtos.DTOReporte;

import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import java.util.Vector;

public class MAREInfoBean implements SessionBean 
{
  /**
   *  Enterprise Java Bean que crea y guarda una instancia de ReportManager.
   *  Implementa SessionBean, es decir, debe definir todos los métodos
   *  de la interface que serán los que harán posible la comunicaciones entre
   *  el Bean y el Container debido a la ocurrencia de eventos determinados.
   *  Publica los métodos del ReportManager a los cuales le reenvía la ejecución agregando throws InfoException por el contexto que se ejecuta.
   *  @see com.calipso.reportgenerator.reportmanager.ReportManager
   */
  SessionContext ctx;
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
      this.ctx=ctx;
  }

  public void ejecutarReporte(DTOReporte dtoReporte) throws MareException
  {
    ReportGeneratorConfiguration reportGeneratorConfigurator = null;
    byte[] file;
    try{
      System.out.println("SCS, dentro de ejecutarReporte, recibo: " + dtoReporte);
    
      if(dtoReporte.getParametros().containsKey(ConstantesREP.RESUMEN)){
        String reportId = dtoReporte.getIdReporte() + "-RESUMEN";
        dtoReporte.setIdReporte(reportId);
      }
      Map params = extractParams(dtoReporte);
      reportGeneratorConfigurator = getConfiguration(dtoReporte);
      file = getReportManager(reportGeneratorConfigurator).exportReport(params);   
    }catch (InfoException e){
      throw traslateException(e, reportGeneratorConfigurator);
    }
 //   System.out.println("file, es: " + file);
    try {
    //  System.out.println("file.length : "+ file.length);
      if ((file !=null) && (file.length > 0)) {
        
        this.actualizarInfoReporte(dtoReporte.getOidReporte(), file);
        
      //  System.out.println("despues de setearlo es: " + genreportesLocal.getValInfo());
        FileOutputStream fichero = new FileOutputStream("c:\\reporte.pdf");
        
        fichero.write(file);
  
        fichero.close();
        //System.out.println("---------FINALIZO LA GENERACION DEL REPORTE------------");
    
      }
      
    }  catch (Exception e) {
        e.printStackTrace();
        ctx.setRollbackOnly();
        throw new MareException(e,
            UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } 
    
    //dtoReporte.setResultados(file);
    //dtoReporte.setNombreResultados(getNombreResultados(params));
    //return dtoReporte;
  }
  
  /**
   * Creado por incidencia SiCC 20090889.
   * Actualiza el campo VAL_INFO de un registro de la tabla GEN_REPOR cuyo OID
   * recibe por parametro.
   * @author dmorello
   * @since 20-abr-2009
   */
  private void actualizarInfoReporte(Long oid, byte[] info) throws MareException {
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Vector params = new Vector();
      
      String update = "UPDATE GEN_REPOR SET VAL_INFO = ? WHERE OID_REPO = ?";
      params.add(info);
      params.add(oid);
      
      try {
          bs.dbService.executePreparedUpdate(update, params);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
  }

  private InfoException traslateException(InfoException e, ReportGeneratorConfiguration reportGeneratorConfiguration)
  {
    String message;
    Throwable cause = null;
    if(reportGeneratorConfiguration!=null)
    {
      ILanguageTraslator traslator = reportGeneratorConfiguration.getLanguageTraslator();
      if(e.getCause()!=null && e.getCause() instanceof InfoException){
        cause = traslateException((InfoException)e.getCause(), reportGeneratorConfiguration);
      }else if(e.getCause()!=null)
      {
        cause = e.getCause();
      }
      if(e instanceof MultipleStringInfoException)
      {
        message = traslateMessages(((MultipleStringInfoException)e).getMessages(), reportGeneratorConfiguration);
        e = ((MultipleStringInfoException)e).getInfoException(message, cause);
      }else{
        e = new InfoException(traslateMessages(new String[] {e.getMessage()}, reportGeneratorConfiguration), cause, e.getCode());
      }
    }
    return e;
  }
  
  private String traslateMessages(String[] messages, ReportGeneratorConfiguration reportGeneratorConfiguration)
  {
    String message = "";
    for(int i=0; i < messages.length; i++)
    {
      try{
        Integer.valueOf(messages[i]);
        String traslate = reportGeneratorConfiguration.getLanguageTraslator().getExceptionFromId(messages[i]);
        if(traslate!=null)
        {
          message += traslate;
        }else
        {
          message += messages[i];
        }
      }catch (Exception e)
      {
        //No era un codigo de excepcion.
        if(messages[i]!=null)
        message += messages[i];
      }
    }
    return message;
  }
  
  
  /**
   * Obtiene un ReportManagera partir de la configuración especificada en ReportManagerConfiguration
   * @param reportGeneratorConfiguration la configuracion que especifica path de los repositorios
   * , si es distribuida, host, port.
   * @return interface que publica los métodos a invocar por parte del usuario
   */
  private IReportManager getReportManager(ReportGeneratorConfiguration reportGeneratorConfiguration) throws MareException {
    LanguageTraslator.newLocaleFrom(reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry(),reportGeneratorConfiguration.getLanguagesPath());
    try{
      IReportManager reportManager = new ReportManager();
      reportManager.init(reportGeneratorConfiguration);
      return reportManager;
    }catch(Exception e){
      e.printStackTrace();
      ctx.setRollbackOnly();
      throw new MareException(e);
    }
  }
  
  
  private Map extractParams(DTOReporte dtoReporte){
    HashMap params = new HashMap();
    params.put("ReportDefinitionId",dtoReporte.getIdReporte());

    params.putAll(getStaticParams(dtoReporte));
   // System.out.println(params.get(BelcorpDecoratedReportLayout.floatPattern));
    return params;   
  }

  private ReportGeneratorConfiguration getConfiguration(DTOReporte dtoReporte)throws MareException {
    //String configurationPath = System.getProperty("MareConfigurationRoot")+"/reportes/ReportGeneratorConfiguration.properties";
    ReportGeneratorConfiguration configuration = new ReportGeneratorConfiguration(ReportGeneratorConfiguration.getConfiguration(""));
    if (dtoReporte.getParametros().containsKey(ConstantesREP.IDIOMA))
    {
      configuration.setLocaleLanguage(dtoReporte.getParametros().get(ConstantesREP.IDIOMA).toString());      
    }

    return configuration;    
  };
  
  private String getNombreResultados(Map params)
  {
    String nombre = "";
    if (params.containsKey("zoneuserVALUE"))
    {
      nombre = nombre + params.get("zoneuserVALUE");
    }
    if (params.containsKey("ReportDefinitionId"))
    {
      nombre = nombre + "_" + params.get("ReportDefinitionId");
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
    nombre = nombre + "_" + dateFormat.format(new Date()).toString();
 //   System.out.println("getNombreResultados:"+nombre);
    return nombre;
  }
  
  
  public Map getStaticParams(DTOReporte dtoReporte)
  {
    HashMap staticParams = new HashMap();
    Set set = dtoReporte.getParametros().entrySet();
    Iterator iter = set.iterator();
    while (iter.hasNext()) {
    
      Map.Entry obj = (Map.Entry)iter.next();
      String key  = obj.getKey().toString();
     if (key.equalsIgnoreCase(ConstantesREP.USUARIO))
      {
          staticParams.put(BelcorpDecoratedReportLayout.zoneuserParam,dtoReporte.getParametros().get(key));        
          staticParams.put(BelcorpDecoratedReportLayout.zoneuserParam.toUpperCase(),dtoReporte.getParametros().get(key));
      } else if( key.equalsIgnoreCase(ConstantesREP.MODULO ) )
      {
          staticParams.put(BelcorpDecoratedReportLayout.moduleParam,dtoReporte.getParametros().get(key));
      } else if (key.equalsIgnoreCase(ConstantesREP.FORMATOFECHA ) )
      {
          staticParams.put(BelcorpDecoratedReportLayout.datePattern,getMareDatePattern(dtoReporte.getParametros().get(key).toString()));        
          staticParams.put(ConstantesREP.FORMATOFECHA ,getMareDatePattern(dtoReporte.getParametros().get(key).toString()));
      } else if (key.equalsIgnoreCase(ConstantesREP.TITULO) )
      {
         staticParams.put(BelcorpDecoratedReportLayout.titleParam, dtoReporte.getParametros().get(key));
      } else if (key.equalsIgnoreCase(ConstantesREP.SEPARADORDECIMALES) )
      {
          String floatPattern;
          String integerPattern;
          floatPattern = "##,##0.00";
          integerPattern = "##,###.##";
          staticParams.put(BelcorpDecoratedReportLayout.decimalSeparator,dtoReporte.getParametros().get(key));          
          staticParams.put(BelcorpDecoratedReportLayout.floatPattern,floatPattern);
          staticParams.put(BelcorpDecoratedReportLayout.integerPattern, integerPattern);
      } else 
      {
          staticParams.put(key,dtoReporte.getParametros().get(key));
      }
    }
    if(!staticParams.containsKey(ConstantesREP.FORMATOFECHA) || staticParams.get(ConstantesREP.FORMATOFECHA).toString()=="")
    {
      staticParams.put(ConstantesREP.FORMATOFECHA, "dd/MM/yyyy");
    }
    return staticParams;      
  }
  
  private String getMareDatePattern(String datePattern)
  {
    int pos = datePattern.indexOf("mm");
    if(pos >= 0){
      datePattern = datePattern.replace('m', 'M');
    }
    return datePattern;
  }

    public DTOReporte ejecutarReporteOrig(DTOReporte dtoReporte) throws MareException
  {
    ReportGeneratorConfiguration reportGeneratorConfigurator = null;
    try{
      System.out.println("SCS, dentro de ejecutarReporte, recibo: " + dtoReporte);
    
      if(dtoReporte.getParametros().containsKey(ConstantesREP.RESUMEN)){
        String reportId = dtoReporte.getIdReporte() + "-RESUMEN";
        dtoReporte.setIdReporte(reportId);
      }
      Map params = extractParams(dtoReporte);
      reportGeneratorConfigurator = getConfiguration(dtoReporte);
      byte[] file = getReportManager(reportGeneratorConfigurator).exportReport(params);   
      
     // System.out.println("file, es: " + file);
      
      dtoReporte.setResultados(file);
      dtoReporte.setNombreResultados(getNombreResultados(params));
      return dtoReporte;
    }catch (InfoException e){
      throw traslateException(e, reportGeneratorConfigurator);
    }
  }
 
}