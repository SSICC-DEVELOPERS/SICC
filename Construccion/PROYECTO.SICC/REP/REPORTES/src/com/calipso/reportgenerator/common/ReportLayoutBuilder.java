package com.calipso.reportgenerator.common;

import dori.jasper.engine.JRGroup;
import dori.jasper.engine.JRVariable;
import dori.jasper.engine.JasperPrint;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JasperReport;
import dori.jasper.engine.JasperCompileManager;
import dori.jasper.engine.JasperFillManager;
import dori.jasper.engine.JRParameter;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;

import dori.jasper.engine.design.JRDesignBand;
import dori.jasper.engine.design.JasperDesign;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Iterator;
import java.io.File;

import es.indra.mare.common.info.InfoException;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 25/10/2004
 * Time: 17:18:24
 * To change this template use Options | File Templates.
 */
public class ReportLayoutBuilder {

  private ReportGeneratorConfiguration reportGeneratorConfiguration;
  private ReportTableModel reportTableModel;
  private ReportSpec reportSpec;
  private ReportResult result;
  private Map params;
  public static final String[] JasperParams = {"PAGE_NUMBER", "COLUMN_NUMBER", "REPORT_COUNT", "PAGE_COUNT", "COLUMN_COUNT"};
  public static final String COLUMN_PARAM = "COLUMN_";
  public static final int STARTINGPARAMCOUNT = 1000;

  public ReportLayoutBuilder(ReportSpec reportSpec, ReportResult result, Map params) throws InfoException {
    this.reportSpec = reportSpec;
    this.result = result;
    this.params = params;
    if(result==null){
      this.reportTableModel = new StaticReportTableModel(reportSpec);
    }else{
      this.reportTableModel = result.getReportTableModel();
    }
    checkReportTableModel();
  }


  public ReportLayoutBuilder(ReportGeneratorConfiguration reportGeneratorConfiguration, ReportSpec reportSpec, ReportResult result, Map params) throws InfoException {
    this.reportGeneratorConfiguration = reportGeneratorConfiguration;
    this.reportSpec = reportSpec;
    this.result = result;
    this.params = params;
    if(result==null){
      this.reportTableModel = new StaticReportTableModel(reportSpec);
    }else{
      this.reportTableModel = result.getReportTableModel();
    }
    checkReportTableModel();    
  }

  public ReportLayoutBuilder(ReportGeneratorConfiguration reportGeneratorConfiguration, ReportResult result, ReportSpec spec) throws InfoException {
    this.reportGeneratorConfiguration = reportGeneratorConfiguration;
    this.reportSpec = spec;
    this.result = result;
    if(result==null){
      this.reportTableModel = new StaticReportTableModel(spec);
    }else{
      this.reportTableModel = result.getReportTableModel();
    }
    checkReportTableModel();    
    this.params = getParams();
  }

  private Map getParams() {
    if(params==null){
      params = new HashMap();
      params.putAll(reportSpec.getPreParamValues());
      params.putAll(reportSpec.getPosParamValues());
      if(result!=null){
        params.putAll(result.getParamValues());
      }
    }
    return params;
  }


  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }

  public JasperPrint getJasperPrint(IJasperDefinition design, boolean isLandscape) throws JRException {
    JasperReport report = null;
    setCompiler(reportGeneratorConfiguration);
  //  System.out.println("Ejecutando Jasper");
    JasperDesign jasperDesign = design.getJasperDefinition(isLandscape);
    if(params.containsKey("EMPTYREPORT") && ((Boolean)params.get("EMPTYREPORT")).booleanValue()){
      setMinimunHeights(jasperDesign);
    }
    report = JasperCompileManager.compileReport(jasperDesign);
  //  System.out.println("Jasper Compilado");
    addColumnNamesParams(params);
    addTraslateParams(params, jasperDesign);
    ReportMap.setParametersToSimpleType(params);
    JasperPrint print = JasperFillManager.fillReport(report, params, reportTableModel);
    return print;
  }
  
  private void addTraslateParams(Map params, JasperDesign design){
    JRParameter[] parameters = design.getParameters();
    for(int i=0; i < parameters.length; i++){
      String name = parameters[i].getName();
      if(isTraslateParam(name) && !params.containsKey(name)){
        params.put(name, reportGeneratorConfiguration.getLanguageTraslator().getExceptionFromId(name));
      }
    }
  }
  
  private boolean isTraslateParam(String name){
    try{
      return (Integer.parseInt(name) >= STARTINGPARAMCOUNT);
    }catch(NumberFormatException e){
      return false;
    }
  }
  
  private void addColumnNamesParams(Map params){
    Iterator columns = reportSpec.getColumnByIndex().iterator();
    while(columns.hasNext()){
      ReportFieldSpec field = (ReportFieldSpec)columns.next();
      if(!params.containsKey(COLUMN_PARAM + field.getName())){
        params.put(COLUMN_PARAM + field.getName(), reportGeneratorConfiguration.getLanguageTraslator().getExceptionFromId(field.getName()));
      }
    }
  }
  
  public static String getGroupDefinitionName(JRGroup group) {
    if(group.getName()!=null && group.getName().endsWith("_GROUP")){
      int endIndex = group.getName().indexOf("_GROUP");
      return group.getName().substring(0, endIndex);
    }else{
      return "";
    }
  }

  private void setMinimunHeights(JasperDesign design){
    JRGroup[] groups = design.getGroups();
    for (int i = 0; i < groups.length; i++) {
      JRGroup group = groups[i];
//      JRDesignBand band = (JRDesignBand)group.getGroupHeader();
      Collection jasperVariables = getJasperVariables();
      JRVariable[] allVariables = design.getVariables();
      String groupName = getGroupDefinitionName(group);
      for(int j = 0; j < allVariables.length; j++){
        if(!jasperVariables.contains(allVariables[j].getName())){
          design.removeVariable(allVariables[j]);
        }
      }
      design.removeGroup(group);
//      band.setHeight(0);
//      band = (JRDesignBand)group.getGroupFooter();
//      band.setHeight(0);
    }
    ((JRDesignBand)design.getDetail()).setHeight(0);
  }

  private Collection getJasperVariables() {
    Collection result = new Vector();
    for(int i=0; i < this.JasperParams.length; i++){
      result.add(JasperParams[i]);
    }
    return result;
  }
  
  private void setCompiler(ReportGeneratorConfiguration reportGeneratorConfiguration) {
    if (!reportGeneratorConfiguration.getJasperCompilerClass().equals("")) {
      System.setProperty("jasper.reports.compiler.class", reportGeneratorConfiguration.getJasperCompilerClass());
    } else if (!reportGeneratorConfiguration.getJasperReportPath().equals("")) {
      System.setProperty("jasper.reports.compile.class.path", reportGeneratorConfiguration.getJasperReportPath());
    }
  }

  public IJasperDefinition getJasperDefinition(ReportView reportView) throws InfoException{
    IJasperDefinition definition = getJasperDesign(reportView);
    if(definition instanceof StaticSQLJasperReportDefinition){
      ReportDataSourceSpec dataSourceSpec = (ReportDataSourceSpec)reportSpec.getDataSourceSpecs().toArray()[0];
      ((StaticSQLJasperReportDefinition)definition).setSQLText(dataSourceSpec.getExpression());
    }
    if(!isExternal(definition)){
      definition = addStyle(definition);
    }
    return definition;
  }

  public IJasperDefinition addStyle(IJasperDefinition design) {
    String style = reportGeneratorConfiguration.getReportLayoutStyle();
    if(style==null || style.equalsIgnoreCase("")){
      return design;
    }else if(style.equalsIgnoreCase("Belcorp")){
      addDesignParams();
      BelcorpDecoratedReportLayout.setParams((HashMap)getParams());
      return new BelcorpDecoratedReportLayout(design);
    }
    return design;
  }
  
  private void addDesignParams(){
    //getParams().putAll(MAREInfoClient1.getStaticParams());
  }

  public static boolean isExternal(IJasperDefinition design) {
    return (design instanceof ExternalJasperDefinition);
  }

  private IJasperDefinition getJasperDesign(ReportView reportView) throws InfoException{
    String reportLayoutId = null;
    if(reportView!=null && reportView.getReportLayout()!=null && !reportView.getReportLayout().equalsIgnoreCase("")){
      reportLayoutId = reportView.getReportLayout();
    }else if ((reportSpec.getLayoutDesign()!=null) && !reportSpec.getLayoutDesign().equals("")) {
      reportLayoutId = reportSpec.getLayoutDesign();
    }else{
    //  System.out.println("LayoutDesign: AUTO");
      return buildDefaulJasperDefinition();
    }
   // System.out.println("LayoutDesign: OVERRIDE");
    reportLayoutId = reportLayoutId.endsWith(".xml") ? reportLayoutId : reportLayoutId + ".xml";
    IJasperDefinition jasperDefinition=null;
    try {
        if (this.params.containsKey("EMPTYREPORT")) {
          if (((Boolean)this.params.get("EMPTYREPORT")).booleanValue()){
            if  ((new File(reportGeneratorConfiguration.getSourceReportLayoutPath() + "/" + "Empty"+reportLayoutId)).exists()){
              jasperDefinition = new ExternalJasperDefinition(reportGeneratorConfiguration.getSourceReportLayoutPath() + "/" + "Empty"+reportLayoutId);
             // System.out.println("LayoutDesign: Empty");
            }
          }
        }
    } catch(Exception e){
   //   System.out.println("LayoutDesign: EmptyReport-Error:"+e.toString());
    }
    if (jasperDefinition==null){
      jasperDefinition = new ExternalJasperDefinition(reportGeneratorConfiguration.getSourceReportLayoutPath() + "/" + reportLayoutId);
    }
    return jasperDefinition;
  }

  public IJasperDefinition buildDefaulJasperDefinition() throws InfoException {
    if (reportSpec.getReportType().getType() == ReportDefinitionReportTypeType.CUBE_TYPE) {
      return new CubeJasperReportDefinition(result, reportTableModel.getModel(), reportTableModel.getGroupingDimCount(), reportTableModel.getCommonMetricsCount(),
              reportTableModel.getNonGroupingDimCount(), reportTableModel.getAccMetricsCount(), reportSpec.getTitle());
    } else if (reportSpec.getReportType().getType() == ReportDefinitionReportTypeType.ACCUM_TYPE){
      return new StaticJasperReportDefinition(result, reportTableModel.getModel(), reportTableModel.getGroupingDimCount(), reportTableModel.getCommonMetricsCount(),
              reportTableModel.getNonGroupingDimCount(), reportTableModel.getAccMetricsCount(), reportSpec.getTitle());
    } else if (reportSpec.getReportType().getType() == ReportDefinitionReportTypeType.STATICSQL_TYPE){
      reportTableModel = new StaticReportTableModel(reportSpec);
      StaticSQLJasperReportDefinition definition = new StaticSQLJasperReportDefinition(reportSpec, reportTableModel.getModel(), reportTableModel.getGroupingDimCount(), reportTableModel.getCommonMetricsCount(),
        reportTableModel.getNonGroupingDimCount(), reportTableModel.getAccMetricsCount(), reportSpec.getTitle(), params);
      ReportDataSourceSpec dataSourceSpec = (ReportDataSourceSpec)reportSpec.getDataSourceSpecs().toArray()[0];
      definition.setSQLText(dataSourceSpec.getExpression());
      return definition;
    }
    return null;
  }

  public JasperPrint getJasperPrint(ReportView reportView, boolean isLandscape) throws InfoException, JRException {
    IJasperDefinition definition = getJasperDefinition(reportView);
    return getJasperPrint(definition, isLandscape);
  }

  public JasperPrint getJasperPrint(boolean isLandscape) throws InfoException, JRException {
    IJasperDefinition definition = getJasperDefinition(null);
    return getJasperPrint(definition, isLandscape);
  }
  
  public void checkReportTableModel(){
    if (getParams().containsKey("EMPTYREPORT"))
    {
      getParams().remove("EMPTYREPORT");
    }
    getParams().put(new String("EMPTYREPORT"),reportTableModel.getEmptyReport());
  }
}