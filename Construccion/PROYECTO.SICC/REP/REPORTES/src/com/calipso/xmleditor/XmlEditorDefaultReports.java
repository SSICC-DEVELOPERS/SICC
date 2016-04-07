package com.calipso.xmleditor;

import com.calipso.reportgenerator.reportcalculator.Entry;
import com.calipso.reportgenerator.reportdefinitions.Rol;
import com.calipso.reportgenerator.reportdefinitions.DimensionProperties;
import com.calipso.reportgenerator.reportdefinitions.MetricProperty;
import com.calipso.reportgenerator.reportdefinitions.Localizations;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ActionDefinitions;
import com.calipso.reportgenerator.reportdefinitions.MetricProperties;
import com.calipso.reportgenerator.reportdefinitions.DimensionDefinition;
import com.calipso.reportgenerator.reportdefinitions.Roles;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.MetricDefinition;
import com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions;
import com.calipso.reportgenerator.reportdefinitions.ParameterValue;
import com.calipso.reportgenerator.reportdefinitions.ParameterValues;
import com.calipso.reportgenerator.reportdefinitions.MetricDefinitions;
import com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions;
import com.calipso.reportgenerator.reportdefinitions.ParameterBind;
import com.calipso.reportgenerator.reportdefinitions.Literals;
import com.calipso.reportgenerator.reportdefinitions.DimensionBind;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions;
import com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions;
import com.calipso.reportgenerator.reportdefinitions.LightBoxer;
import com.calipso.reportgenerator.reportdefinitions.FilterDefinitions;
import com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions;
import com.calipso.reportgenerator.reportdefinitions.DimensionProperty;
import com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType;
import com.calipso.reportgenerator.reportdefinitions.types.ParameterValueFilterParameterType;
import com.calipso.reportgenerator.reportdefinitions.types.CalculationType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType;
import com.calipso.reportgenerator.reportmanager.SQLReportDataSource;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 22/06/2004
 * Time: 16:55:43
 * To change this template use Options | File Templates.
 */
public class XmlEditorDefaultReports {
  public static final String defaultEntity = "ANY", defaultRol = "ANY";
  public static final String defaultDefinitionTag = "RD";
  public static final String defaultSourceTag = "RSD";
  public static final String defaultLayoutTag = "RL";
  public static final String defaultViewTag = "RV";
  public static final int DEFAULT_COLUMN_WIDTH = 75;

  /**
   * Genera un report definition seteando los valores segun los parametros recibidos
   * @param reportName
   * @param dimensionMap
   * @param metricMap
   * @return
   */
  public static ReportDefinition getReportDefinition(ReportGeneratorConfiguration configuration, String reportName, Vector dimensionMap, Vector metricMap){
    ReportDefinition report = new ReportDefinition();
    setHeader(report, reportName);
    setRoles(report);
    setDimensionsDefinitions(report, dimensionMap);
    setMetricsDefinitions(report, metricMap);
    setActionsDefinitions(report);
    setDrillDownDefinitions(report, reportName);
    setLocalizations(report);
    setFilterDefinitions(report);
    setParameterValues(configuration, report);
    return report;
  }

  private static void setLocalizations(Object report) {
    Localizations localizations = new Localizations();
/*    Localization localization = new Localization();
    localization.setLocale("");
    localization.addLiterals(getLiterals());
    localizations.addLocalization(localization);*/
    if(report instanceof ReportDefinition){
      ((ReportDefinition)report).setLocalizations(localizations);
    }else if (report instanceof ReportSourceDefinition){
      ((ReportSourceDefinition)report).setLocalizations(localizations);
    }
  }

  private static Literals getLiterals() {
    Literals literals = new Literals();
    literals.setCode("");
    literals.setValue("");
    return literals;
  }

  private static void setDrillDownDefinitions(ReportDefinition report, String reportName) {
    DrillDownDefinitions drills = new DrillDownDefinitions();
/*    DrillDownDefinition drill = new DrillDownDefinition();
    drill.setDescription("");
    drill.setName("");
    drill.setTargetReportDefinitionID(getReportId(reportName));
    drill.addDimensionBind(getDimensionBind());
    drill.addParameterBind(getParameterBind());
    drills.addDrillDownDefinition(drill);*/
    report.setDrillDownDefinitions(drills);
  }

  private static ParameterBind getParameterBind() {
    ParameterBind param = new ParameterBind();
    param.setSourceFilterName("");
    param.setSourceParameterName("");
    param.setTargetFilterName("");
    param.setTargetParameterName("");
    return param;
  }

  private static DimensionBind getDimensionBind() {
    DimensionBind bind = new DimensionBind();
    bind.setSourceDimensionName("");
    bind.setTargetFilterName("");
    bind.setTargetParameterName("");
    return bind;
  }

  private static void setParameterValues(ReportGeneratorConfiguration config, ReportDefinition report) {
    ParameterValues params = new ParameterValues();
    addStyleParams(config, params);
    report.setParameterValues(params);
  }

  private static void addStyleParams(ReportGeneratorConfiguration config, ParameterValues params) {
    String style = config.getReportLayoutStyle();
    if(style != null && style.equalsIgnoreCase("BELCORP")){
      addBelcorpParams(params);
    }
  }

  private static void addBelcorpParams(ParameterValues params) {
    Collection belcorpParams = Arrays.asList(new String[] {"countryparam", "zoneuser", "module"});
    for (Iterator iterator = belcorpParams.iterator(); iterator.hasNext();) {
      String paramName = (String) iterator.next();
      ParameterValue param = new ParameterValue();
      param.setDefaultValue("");
      param.setFilterDefinitionName(paramName);
      param.setFilterParameter(ParameterValueFilterParameterType.VALUE);
      params.addParameterValue(param);
    }
  }

  private static void setFilterDefinitions(Object report) {
    FilterDefinitions filters = new FilterDefinitions();
/*    FilterDefinition filter = new FilterDefinition();
    filter.setDimensionName("");
    filter.setFilterType(FilterDefinitionFilterTypeType.EQUALTO);
    filter.setName("");
    filter.setVisual(false);
    filters.addFilterDefinition(filter);*/
    if(report instanceof ReportDefinition){
      ((ReportDefinition)report).setFilterDefinitions(filters);
    }else if(report instanceof ReportSourceDefinition){
      ((ReportSourceDefinition)report).setFilterDefinitions(filters);
    }
  }

  private static void setActionsDefinitions(ReportDefinition report) {
    ActionDefinitions actions = new ActionDefinitions();
/*    ActionDefinition action = new ActionDefinition();
    action.setDescription("");
    action.setExpression("");
    action.setMetric("");
    action.setName("");
    actions.addActionDefinition(action);*/
    report.setActionDefinitions(actions);
  }

  private static void setMetricsDefinitions(ReportDefinition report, Vector metricMap) {
    MetricDefinitions metrics = new MetricDefinitions();
    for (Iterator iterator = metricMap.iterator(); iterator.hasNext();) {
      Entry metric = (Entry) iterator.next();
     // System.out.println(metric.toString());
      metrics.addMetricDefinition(getMetricDefinition(metric));
    }
    report.setMetricDefinitions(metrics);
  }

  private static MetricDefinition getMetricDefinition(Entry metric) {
    MetricDefinition metricDefinition = new MetricDefinition();
    metricDefinition.setAccumulable(false);
    metricDefinition.setDescription("");
    metricDefinition.setName(getId(metric.getKey().toString()));
    metricDefinition.setVisible(true);
    return metricDefinition;
  }

  private static void setDimensionsDefinitions(ReportDefinition report, Vector dimensionMap) {
    DimensionDefinitions dimensions = new DimensionDefinitions();
    for (Iterator iterator = dimensionMap.iterator() ; iterator.hasNext();) {
      Entry dimension = (Entry) iterator.next();
    //  System.out.println(dimension.toString());
      dimensions.addDimensionDefinition(getDimensionDefinition(dimension));
    }
    report.setDimensionDefinitions(dimensions);
  }

  private static DimensionDefinition getDimensionDefinition(Entry dimension) {
    DimensionDefinition dimensionDefinition = new DimensionDefinition();
    dimensionDefinition.setDescription("");
    dimensionDefinition.setGroupFooterCaption("");
    dimensionDefinition.setGroups(false);
    dimensionDefinition.setLocation(DimensionDefinitionLocationType.PAGE);
    dimensionDefinition.setName(getId(dimension.getKey().toString()));
    dimensionDefinition.setOrder(DimensionDefinitionOrderType.A);
    dimensionDefinition.setRankMetricName("");
    return dimensionDefinition;
  }

  private static String getId(String name) {
    StringTokenizer stringTokenizer = new StringTokenizer(name, " ");
    String id = stringTokenizer.nextToken().toUpperCase();
    for (; stringTokenizer.hasMoreTokens();) {
      id += ("_" + stringTokenizer.nextToken().toUpperCase());
    }
    return id;
  }

  private static void setRoles(ReportDefinition report) {
    Roles roles = new Roles();
    Rol rol = new Rol();
    rol.setName(defaultRol);
    roles.addRol(rol);
    report.setRoles(roles);
  }

  private static void setHeader(ReportDefinition report, String reportName) {
    report.setId(getReportId(reportName));
    report.setReportSource(getSourceId(reportName));
    report.setTitle(reportName);
    report.setDescription(reportName);
    report.setLayoutDesign("");
    report.setEntity(defaultEntity);
    report.setIsTransient(false);
    report.setReportType(ReportDefinitionReportTypeType.ACCUM);
    report.setPageFooter("");
    report.setPageHeding("");
    report.setVisibleTotals(true);
    report.setMultilanguage(false);
    report.setMaxRowCount(Integer.MAX_VALUE);
    report.setMaxRowsDimensionReference("");
  }

  public static String getViewId(String reportName){
    return (defaultViewTag + "_" + getId(reportName));
  }

  /**
   * Obtiene un id para un layout del estilo RL_NOMBRE_NOMBRE
   * @param reportName
   * @return
   */
  public static String getLayoutId(String reportName) {
    reportName = removeTag(reportName);
    return (defaultLayoutTag + "_" + getId(reportName));
  }

  private static String removeTag(String reportName) {
    String[] tags = new String[] {defaultDefinitionTag, defaultSourceTag, defaultViewTag};
    for (int i = 0; i < tags.length; i++) {
      String tag = tags[i];
      if(reportName.startsWith(tag + "_")){
        return reportName.substring(tag.length() + 1);
      }
    }
    return reportName;
  }

  /**
   * Obtiene un id para un ReportSourceDefinition del estilo RSD_NOMBRE_NOMBRE
   * @param reportName
   * @return
   */
  public static String getSourceId(String reportName) {
    return (defaultSourceTag + "_" + getId(reportName));
  }

  /**
   * Obtiene un id para un ReportDefinition del estilo RD_NOMBRE_NOMBRE
   * @param reportName
   * @return
   */
  public static String getReportId(String reportName) {
    return (defaultDefinitionTag + "_" + getId(reportName));
  }

  /**
   * Obtiene un ReportSourceDefinition seteando los valores segun los parametros recibidos
   * @param reportName
   * @param dimensionMap
   * @param metricMap
   * @param query
   * @param className
   * @param localUrl
   * @param user
   * @param password
   * @return
   */
  public static ReportSourceDefinition getReportSourceDefinition(String reportName, Vector dimensionMap, Vector metricMap, String query, String className, String localUrl, String user, String password) {
    ReportSourceDefinition report = new ReportSourceDefinition();
    setSourceHeader(report, reportName);
    setDimensionsSourceDefinitions(report, dimensionMap);
    setMetricsSourceDefinitions(report, metricMap);
    setLocalizations(report);
    setFilterDefinitions(report);
    setSourceParameterValues(report);
    setDataSourceDefinitions(report, reportName, query, className, localUrl, user, password);
    return report;
  }

  private static void setSourceParameterValues(ReportSourceDefinition report) {
    ParameterValues params = new ParameterValues();
    report.setParameterValues(params);
  }

  private static void setDataSourceDefinitions(ReportSourceDefinition report, String reportName, String query, String className, String localUrl, String user, String password) {
    DataSourceDefinitions datas = new DataSourceDefinitions();
    datas.addDataSourceDefinition(getDataSourceDefinition(reportName, query, className, localUrl, user, password));
    report.setDataSourceDefinitions(datas);
  }

  private static DataSourceDefinition getDataSourceDefinition(String reportName, String query, String className, String localUrl, String user, String password) {
    DataSourceDefinition data = new DataSourceDefinition();
    data.setDatePattern("");
    data.setDateTimePattern("");
    data.setExpression(addSqlTags(query));
    data.setExternalClassName(className);
    data.setExternalConnectionClassName(className);
    data.setExternalConnectionDistributedUrl("");
    data.setExternalConnectionLocalUrl(localUrl);
    data.setExternalConnectionPassword(password);
    data.setExternalConnectionString("");
    data.setExternalConnectionUser(user);
    data.setExternalSourceData("");
    data.setName(getId(reportName));
    data.setSourceType(DataSourceDefinitionSourceTypeType.SQL);
    return data;
  }

  private static String addSqlTags(String query) {
    String result = query;
    if(query.toUpperCase().indexOf("WHERE")>0){
      result = query.substring(0, getIndexForTag(query)) + " " + SQLReportDataSource.AND_FILTER_TAG   + " " + query.substring(getIndexForTag(query));
    }else{
      result = query.substring(0, getIndexForTag(query)) + " " + SQLReportDataSource.WHERE_FILTER_TAG + " " + query.substring(getIndexForTag(query));
    }
    return result;
  }

  /**
   * Obtiene el indice donde se debe agregar el tag de prefiltros en la query
   * @param query
   * @return
   */
  private static int getIndexForTag(String query) {
    int firstIndex = query.toUpperCase().indexOf("GROUP BY");
    int secondIndex = query.toUpperCase().indexOf("ORDER BY");
    int result = Math.max(firstIndex, secondIndex);
    if(result > 0){
      return result;
    }else{
      return query.length();
    }
  }

  private static void setMetricsSourceDefinitions(ReportSourceDefinition report, Vector metricMap) {
    MetricSourceDefinitions metrics = new MetricSourceDefinitions();
    for (Iterator iterator = metricMap.iterator(); iterator.hasNext();) {
      Entry metric = (Entry) iterator.next();
      metrics.addMetricSourceDefinition(getMetricSourceDefinition(metric));
    }
    report.setMetricSourceDefinitions(metrics);
  }

  private static MetricSourceDefinition getMetricSourceDefinition(Entry metric) {
    MetricSourceDefinition definition = new MetricSourceDefinition();
    definition.setAggregateFunction("");
    definition.setAggregateType(CalculationType.SUM);
    definition.setCalculated(false);
    definition.setDescription(metric.getKey().toString());
    definition.setExternalCalculated(false);
    definition.setExternalData(metric.getKey().toString());
    definition.setGroupFooterFunction("");
    definition.setGroupFooterType(CalculationType.NONE);
    definition.setName(metric.getKey().toString());
    return definition;
  }

  private static void setDimensionsSourceDefinitions(ReportSourceDefinition report, Vector dimensionMap) {
    DimensionSourceDefinitions dimensions = new DimensionSourceDefinitions();
    for (Iterator iterator = dimensionMap.iterator(); iterator.hasNext();) {
      Entry dimension = (Entry) iterator.next();
      dimensions.addDimensionSourceDefinition(getDimensionSourceDefinition(dimension));
    }
    report.setDimensionSourceDefinitions(dimensions);
  }

  private static DimensionSourceDefinition getDimensionSourceDefinition(Entry dimension) {
    DimensionSourceDefinition definition = new DimensionSourceDefinition();
    definition.setCalculated(false);
    definition.setDataType(getType(((Integer)dimension.getValue()).intValue()));
    definition.setDescription(dimension.getKey().toString());
    definition.setExpression("");
    definition.setExternalData(dimension.getKey().toString());
    definition.setName(dimension.getKey().toString());
    //definition.setQueryConvertToStringPattern("");
    return definition;
  }

  private static ReportDataType getType(int type) {
    switch(type){
      case 4 : return ReportDataType.INTEGER;
      case 6 : return ReportDataType.FLOAT;
      case 12: return ReportDataType.STRING;
      case 16: return ReportDataType.BOOLEAN;
      case 91: return ReportDataType.DATETIME;
      default: return ReportDataType.STRING;
    }
  }

  private static void setSourceHeader(ReportSourceDefinition report, String reportName) {
    report.setCached(false);
    report.setExpiration(new BigDecimal(0));
    report.setId(getSourceId(reportName));
    report.setIncrementalDimension("");
    report.setMaxRowCount(Integer.MAX_VALUE);
    report.setMaxRowsDimensionReference("");
    report.setMultilanguage(false);
  }

  public static ReportView getReportView(XmlEditorTreeModelNode dimensions, XmlEditorTreeModelNode metrics, String reportDefinitionId) {
    ReportView reportView = new ReportView();
    setViewHeader(reportView, reportDefinitionId);
    reportView.setLightBoxer(getViewLightBoxer());
    reportView.setDimensionProperties(getViewDimensionProperties(dimensions));
    reportView.setMetricProperties(getViewMetricProperties(metrics));
    return reportView;
  }

  private static MetricProperties getViewMetricProperties(XmlEditorTreeModelNode metrics) {
    MetricProperties properties = new MetricProperties();
    Enumeration enumeration = metrics.children();
    while (enumeration.hasMoreElements()) {
      XmlEditorTreeModelNode metricNode = (XmlEditorTreeModelNode) enumeration.nextElement();
      properties.addMetricProperty(getMetricPropertyFromDefinitionNode(metricNode));
    }
    return properties;
  }

  private static MetricProperty getMetricPropertyFromDefinitionNode(XmlEditorTreeModelNode metricNode) {
    MetricProperty property = new MetricProperty();
    property.setMetricName(metricNode.getAttribute("Name").toString());
    property.setVisible(Boolean.valueOf(metricNode.getAttribute("Visible")).booleanValue()); //Boolean.getBoolean falla
    return property;
  }

  private static DimensionProperties getViewDimensionProperties(XmlEditorTreeModelNode dimensions) {
    DimensionProperties properties = new DimensionProperties();
    Enumeration enumeration = dimensions.children();
    while (enumeration.hasMoreElements()) {
      XmlEditorTreeModelNode dimensionNode = (XmlEditorTreeModelNode) enumeration.nextElement();
      properties.addDimensionProperty(getDimensionPropertyFromDefinitionNode(dimensionNode));
    }
    return properties;
  }

  private static DimensionProperty getDimensionPropertyFromDefinitionNode(XmlEditorTreeModelNode dimensionNode) {
    DimensionProperty property = new DimensionProperty();
    property.setDimensionName(dimensionNode.getUserObject().toString());
    //property.setExcludeValue(null);
    property.setLocation(DimensionPropertyLocationType.valueOf(dimensionNode.getAttribute("Location")));
    property.setOrder(DimensionPropertyOrderType.valueOf(dimensionNode.getAttribute("Order")));
    property.setRankMetricName(dimensionNode.getAttribute("RankMetricName"));
    property.setUbication(0);
    property.setWidth(getDefaultColumnSize(dimensionNode));
    return property;
  }

  private static int getDefaultColumnSize(XmlEditorTreeModelNode dimensionNode) {
    return DEFAULT_COLUMN_WIDTH;
  }

  private static LightBoxer getViewLightBoxer() {
    LightBoxer boxer = new LightBoxer();
    return boxer;
  }

  private static void setViewHeader(ReportView reportView, String reportDefinitionId) {
    reportView.setDefault(false);
    reportDefinitionId = JOptionPane.showInputDialog(null, "Confirme el nombre del reporte", reportDefinitionId);
    reportView.setReportDefinitionId(reportDefinitionId);
    String reportViewName = JOptionPane.showInputDialog(null, "Ingrese el nombre de la vista", reportDefinitionId);
    reportView.setDescription(reportViewName);
    reportView.setId(getViewId(reportViewName));
    String userName = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario", "Report View", JOptionPane.INFORMATION_MESSAGE);
    reportView.setUserID(userName);
    reportView.setUserName(userName);
    reportView.setVisibleTotals(true);
  }

}
