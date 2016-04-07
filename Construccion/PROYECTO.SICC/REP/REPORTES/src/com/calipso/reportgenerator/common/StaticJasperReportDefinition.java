package com.calipso.reportgenerator.common;

import javax.swing.table.TableModel;
import java.util.Map;
import java.util.Iterator;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.text.NumberFormat;
import java.text.DecimalFormat;

import dori.jasper.engine.design.JRDesignField;
import dori.jasper.engine.design.JRDesignTextField;
import dori.jasper.engine.design.JRDesignExpression;
import dori.jasper.engine.design.JRDesignVariable;
import dori.jasper.engine.design.JRDesignParameter;
import dori.jasper.engine.design.JRDesignReportFont;
import dori.jasper.engine.design.JasperDesign;
import dori.jasper.engine.design.JRDesignGroup;
import dori.jasper.engine.design.JRDesignBand;
import dori.jasper.engine.design.JRDesignStaticText;
import dori.jasper.engine.JRTextElement;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JRGroup;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.ReportMetricSpec;
import com.calipso.reportgenerator.common.IJasperDefinition;

/**
 * Construye una definición para los reportes estátícos (Jasper)
 */

public class StaticJasperReportDefinition implements IJasperDefinition {

  private Map fields;
  private Map variables;
  private TableModel data;
  private String tittle;
  private Vector dimensions;
  private Vector metrics;
  private Vector accuMetrics;
  private Vector nonGroupingDimensions;
  private Vector dimensionsSizes;
  private Vector metricsSizes;
  private Vector accuMetricsSizes;
  private Vector nonGroupingDimensionsSizes;
  private int printAt;
  private Vector metricsPosition = new Vector();
  private Vector nonGroupingDimensionPosition = new Vector();
  private Vector groupingDimensionPosition = new Vector();
  private ReportResult reportResult;
  private String numberFormatPattern;
  private Vector metricsWidth;
  private Vector accMetricsPosition;
  private Vector accMetricsWidht;
  private Map reportParams;
  public static final String emptyGroup = "EMPTY_GROUP";

  /**
   * Inicializa una instancia de <coe>eJasperReportDefinition</code>
   * @param reportResult
   * @param data
   * @param dimensionsCount
   * @param metricsCount
   * @param nonGroupingDimensionsCount
   * @param accuMetricsCount
   * @param tittle
   */
  public StaticJasperReportDefinition(ReportResult reportResult, TableModel data, int dimensionsCount, int metricsCount, int nonGroupingDimensionsCount, int accuMetricsCount, String tittle) {
    this.data = data;
    this.tittle = tittle;
    this.reportResult = reportResult;
    metricsWidth = new Vector();
    accMetricsPosition = new Vector();
    accMetricsWidht = new Vector();
    initializeVectors(dimensionsCount, metricsCount, nonGroupingDimensionsCount, accuMetricsCount);
    reportParams = reportResult.getParamValues();
    dimensionsSizes = calculateBestLenghts(dimensions);
    metricsSizes = calculateBestLenghts(metrics);
    accuMetricsSizes = calculateBestLenghts(this.accuMetrics);
    nonGroupingDimensionsSizes = calculateBestLenghts(nonGroupingDimensions);
    initializeNumberFormatPattern();
  }

  private void initializeNumberFormatPattern() {
    NumberFormat format = NumberFormat.getInstance(LanguageTraslator.getLocale());
    numberFormatPattern = ((DecimalFormat)format).toPattern();
  }

  /**
   * Retorna la definicion del reporte
   * @return
   * @throws dori.jasper.engine.JRException
   */
  public JasperDesign getJasperDefinition(boolean isLandscape) throws JRException {
    JasperDesign jasperDesign = new JasperDesign();
    if(isLandscape) {
      jasperDesign.setOrientation(JasperDesign.ORIENTATION_LANDSCAPE);
      jasperDesign.setPrintOrder(JasperDesign.PRINT_ORDER_VERTICAL);
      jasperDesign.setPageWidth(842);
      jasperDesign.setPageHeight(595);
    } else {
      jasperDesign.setOrientation(JasperDesign.ORIENTATION_PORTRAIT);
      jasperDesign.setPrintOrder(JasperDesign.PRINT_ORDER_HORIZONTAL);
      jasperDesign.setPageWidth(595);
      jasperDesign.setPageHeight(842);
    }
    jasperDesign.setName("BasicReport");
    addFields(jasperDesign);
    addDetails(jasperDesign);
    addGroups(jasperDesign);
    addVariables(jasperDesign);
    addTitle(jasperDesign);
    addParams(jasperDesign);
    //addPageHeader(jasperDesign);
    return jasperDesign;
  }

  /**
   * Agrega los parametros del reporte a la definicion del jasper para que puedan ser utilizados en la visualizacion.
   * @param jasperDesign
   * @throws JRException
   */
  private void addParams(JasperDesign jasperDesign) throws JRException {
    for (Iterator iterator = reportParams.entrySet().iterator(); iterator.hasNext();) {
      Map.Entry param = (Map.Entry) iterator.next();
      JRDesignParameter parameter = new JRDesignParameter();
      parameter.setName(param.getKey().toString());
      parameter.setDescription(param.getKey().toString());
      Class paramClass = getClassFor(param);
      parameter.setValueClass(paramClass);
      jasperDesign.addParameter(parameter);
    }
  }

  /**
   * Obtiene la clase a la que pertenece el valor de un parametro dado.
   * @param param
   * @return
   */
  private Class getClassFor(Map.Entry param) {
    Class result = java.lang.String.class;
    Map map = new HashMap();
    map.put(param.getKey(), param.getValue());
    ReportMap.setParametersToSimpleType(map);
    if(map.get(param.getKey())!=null){
      result = map.get(param.getKey()).getClass();
    }
    return result;
  }

  /**
   * Agrega los campos a la definicion
   * @param jasperDesign
   * @throws dori.jasper.engine.JRException
   */
  private void addFields(JasperDesign jasperDesign) throws JRException {
  //Fields
    String name;
    for(int i = 0 ; i < dimensions.size() ; i++) {
      JRDesignField field = new JRDesignField();
      name = dimensions.elementAt(i).toString();
      field.setName(name);
      ReportDimensionSpec dimSpec = reportResult.getDimensionFromName(name);
      if(dimSpec != null){
        field.setValueClass(dimSpec.getBaseJavaType());
      }else{
        field.setValueClass(java.lang.String.class);
      }
      jasperDesign.addField(field);
    }
    for(int i = 0 ; i < nonGroupingDimensions.size() ; i++) {
      JRDesignField field = new JRDesignField();
      name = nonGroupingDimensions.elementAt(i).toString();
      field.setName(name);
      ReportDimensionSpec dimSpec = reportResult.getDimensionFromName(name);
      if(dimSpec != null){
        field.setValueClass(dimSpec.getBaseJavaType());
      }else{
        field.setValueClass(java.lang.String.class);
      }
      jasperDesign.addField(field);
    }
    for(int i = 0 ; i < metrics.size() ; i++) {
      JRDesignField field = new JRDesignField();
      name = metrics.elementAt(i).toString();
      field.setName(name);
      field.setValueClass(java.lang.Float.class);
      jasperDesign.addField(field);
    }
    for(int i = 0 ; i < accuMetrics.size() ; i++) {
      JRDesignField field = new JRDesignField();
      name = accuMetrics.elementAt(i).toString();
      field.setName(name);
      field.setValueClass(java.lang.Float.class);
      jasperDesign.addField(field);
    }
  }

  /**
   * Agrega los grupos a la definicion
   * @param jasperDesign
   * @throws dori.jasper.engine.JRException
   */
  private void addGroups(JasperDesign jasperDesign) throws JRException {
    //groups
    JRDesignExpression expression;
    JRDesignBand band;
    JRDesignGroup group = null;
    printAt = 0;
    for(int j = 0 ; j < dimensions.size() ; j++) {
      group = new JRDesignGroup();
      group.setName(dimensions.elementAt(j).toString()+"_GROUP");
      group.setReprintHeaderOnEachPage(true);

      expression = new JRDesignExpression();
      if(jasperDesign.getFieldsMap().containsKey(dimensions.elementAt(j))){
        JRDesignField field = (JRDesignField)jasperDesign.getFieldsMap().get(dimensions.elementAt(j));
        expression.setValueClass(field.getValueClass());
      }else{
        expression.setValueClass(java.lang.String.class);
      }
      expression.setText("$F{"+dimensions.elementAt(j)+"}");
      group.setExpression(expression);

      if(j + 1 == dimensions.size()) {
        band = new JRDesignBand();
        band.setHeight(60);
      } else {
        band = new JRDesignBand();
        band.setHeight(20);
      }

      JRDesignStaticText text = new JRDesignStaticText();
      String caption = "";
      if(!dimensions.elementAt(j).toString().equalsIgnoreCase(emptyGroup)){
        caption = reportResult.getReportSpec().getDimensionFromName(dimensions.elementAt(j).toString()).getCaption() + ":";
      }
      text.setX(printAt);
      text.setY(0);
      text.setWidth(getLenghtForCaption((new Integer(caption.length())).intValue()));
      text.setHeight(20);
      text.setText(caption);
      band.addElement(text);

      JRDesignTextField textField = new JRDesignTextField();
      textField.setX(printAt + getLenghtForCaption((new Integer(caption.length())).intValue()) - 5);
      textField.setY(0);
      textField.setWidth(getLenghtForCaption(((Integer) dimensionsSizes.elementAt(j)).intValue()));
      textField.setHeight(20);
      expression = new JRDesignExpression();
      if(jasperDesign.getFieldsMap().containsKey(dimensions.elementAt(j))){
        JRDesignField field = (JRDesignField)jasperDesign.getFieldsMap().get(dimensions.elementAt(j));
        expression.setValueClass(field.getValueClass());
      }else{
        expression.setValueClass(java.lang.String.class);
      }
      expression.setText("$F{"+dimensions.elementAt(j)+"}");
      textField.setExpression(expression);
      textField.setBlankWhenNull(true);
      band.addElement(textField);
      if(dimensions.elementAt(j).toString().equalsIgnoreCase(emptyGroup)){
        band = new JRDesignBand();
        band.setHeight(0);
      }
      group.setGroupHeader(band);

      if(j + 1 == dimensions.size()) {
        for(int i = 0 ; i < nonGroupingDimensions.size() ; i++) {
          int x = ((Integer) nonGroupingDimensionPosition.elementAt(i)).intValue();
          text = new JRDesignStaticText();
          text.setX(x);
          text.setY(20);
          //text.setWidth(((Integer) metricsWidth.elementAt(i)).intValue());
          int first = getLenghtForCaption(((Integer) nonGroupingDimensionsSizes.elementAt(i)).intValue());
          int second = getLenghtForCaption(nonGroupingDimensions.elementAt(i).toString().length());
          if(first >= second) {
            text.setWidth(getLenghtForCaption(first));
          } else {
            text.setWidth(getLenghtForCaption(second));
          }
          text.setHeight(20);
          text.setText(reportResult.getReportSpec().getDimensionFromName(nonGroupingDimensions.elementAt(i).toString()).getCaption());
          if(band!=null){
            band.addElement(text);
          }
        }

        for(int i = 0 ; i < metrics.size() ; i++) {
          int x = ((Integer) metricsPosition.elementAt(i)).intValue();
          text = new JRDesignStaticText();
          text.setX(x);
          text.setY(20);
          text.setWidth(((Integer) metricsWidth.elementAt(i)).intValue());
          text.setHeight(20);
          text.setText(reportResult.getReportSpec().getMetricFromName(metrics.elementAt(i).toString()).getCaption());
          if(band!=null){
            band.addElement(text);
          }
        }

        for(int i = 0 ; i < accMetricsPosition.size() ; i++) {
          int x = ((Integer) accMetricsPosition.elementAt(i)).intValue();
          text = new JRDesignStaticText();
          text.setX(x);
          text.setY(20);
          text.setWidth(((Integer) accMetricsWidht.elementAt(i)).intValue());
          text.setHeight(20);
          String metricName = getMetricName(accuMetrics.elementAt(i).toString());
          String metricCaption = reportResult.getReportSpec().getMetricFromName(metricName).getCaption();
          text.setText(metricCaption + " " + LanguageTraslator.traslate("315"));
          if(band!=null){
            band.addElement(text);
          }
        }
        if(dimensions.elementAt(j).toString().equalsIgnoreCase(emptyGroup)){
          band = new JRDesignBand();
          band.setHeight(0);
        }
        group.setGroupHeader(band);
      }


      band = new JRDesignBand();
      band.setHeight(30);
      if(dimensions.elementAt(j).toString().equalsIgnoreCase(emptyGroup)){
        band.setHeight(0);
      }
      text = new JRDesignStaticText();
      text.setX(printAt);
      text.setY(0);
      text.setWidth(40);
      text.setHeight(20);
      text.setText(LanguageTraslator.traslate("358"));
      band.addElement(text);
      for(int i = 0 ; i < metrics.size() ; i++) {
        band.setHeight(20);
        textField = new JRDesignTextField();
        textField.setX(((Integer)metricsPosition.elementAt(i)).intValue());
        textField.setY(0);
        textField.setWidth(getLenghtForCaption(((Integer) dimensionsSizes.elementAt(j)).intValue()) + 20);
        textField.setHeight(20);
        textField.setBlankWhenNull(true);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.Float.class);
        expression.setText("$V{"+dimensions.elementAt(j).toString() + metrics.elementAt(i).toString()+"_SUM}");
        //textField.setPattern(numberFormatPattern);
        textField.setExpression(expression);
        band.addElement(textField);
        if(dimensions.elementAt(j).toString().equalsIgnoreCase(emptyGroup)){
          band = new JRDesignBand();
          band.setHeight(0);
        }
        group.setGroupFooter(band);
      }
      groupingDimensionPosition.add(new Integer(printAt));
      printAt += 10;//getLenghtForCaption(((Integer)dimensionsSizes.elementAt(j)).intValue());

      jasperDesign.addGroup(group);
    }
  }

  private String getMetricName(String s) {
    StringTokenizer tokenizer = new StringTokenizer(s, "_");
    String returnVal = tokenizer.nextToken();
    return returnVal;
  }

  /**
   * Agrega las variables a la definicion
   * @param jasperDesign
   * @throws dori.jasper.engine.JRException
   */
  private void addVariables(JasperDesign jasperDesign) throws JRException {
    //Variables
    JRDesignExpression expression;
    for(int j = 0 ; j < dimensions.size() ; j++) {
      for(int i = 0 ; i < metrics.size() ; i++) {
        JRDesignVariable jrVariable = new JRDesignVariable();
        jrVariable.setName(dimensions.elementAt(j).toString()+ metrics.elementAt(i).toString()+"_SUM");
        jrVariable.setValueClass(java.lang.Float.class);
        jrVariable.setResetType(JRDesignVariable.RESET_TYPE_GROUP);
        jrVariable.setCalculation(JRDesignVariable.CALCULATION_SUM);
        jrVariable.setResetGroup((JRGroup)jasperDesign.getGroupsList().get(j));
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.Float.class);
        expression.setText("$F{"+metrics.elementAt(i).toString()+"}");
        jrVariable.setExpression(expression);
        jasperDesign.addVariable(jrVariable);
      }
    }
  }

  /**
   * Agrega los detalles a la definicion
   * @param jasperDesign
   */
  private void addDetails(JasperDesign jasperDesign) {
    //Details
    int printAt = calculateStartForItem();
    JRDesignBand band = new JRDesignBand();
    band.setHeight(14);
    JRDesignExpression expression;
    for(int i = 0 ; i < nonGroupingDimensions.size() ; i++) {
      JRDesignTextField textField = new JRDesignTextField();
      textField.setX(printAt);
      textField.setY(0);
      textField.setWidth(getLenghtForCaption(((Integer) nonGroupingDimensionsSizes.elementAt(i)).intValue()));
      textField.setHeight(14);
      textField.setBlankWhenNull(true);
      textField.setStretchWithOverflow(true);
      expression = new JRDesignExpression();
      if(jasperDesign.getFieldsMap().containsKey(nonGroupingDimensions.elementAt(i))){
        JRDesignField field = (JRDesignField)jasperDesign.getFieldsMap().get(nonGroupingDimensions.elementAt(i));
        expression.setValueClass(field.getValueClass());
      }else{
        expression.setValueClass(java.lang.String.class);
      }
      expression.setText("$F{"+nonGroupingDimensions.elementAt(i)+"}");
      textField.setExpression(expression);
      band.addElement(textField);

      nonGroupingDimensionPosition.add(new Integer(printAt));

      int first = getLenghtForCaption(((Integer) nonGroupingDimensionsSizes.elementAt(i)).intValue());
      int second = getLenghtForCaption(nonGroupingDimensions.elementAt(i).toString().length());
      if(first >= second) {
        printAt += first;
      } else {
        printAt += second;
      }
      //printAt += getLenghtForCaption(((Integer) nonGroupingDimensionsSizes.elementAt(i)).intValue());

    }
    for(int i = 0 ; i < metrics.size() ; i++) {
      JRDesignTextField textField = new JRDesignTextField();
      textField.setX(printAt + 25);
      textField.setY(0);
      //textField.setWidth(getLenghtForCaption(((Integer) metricsSizes.elementAt(i)).intValue())+15);

      metricsWidth.add(new Integer(getLenghtForCaption((new Integer(metrics.elementAt(i).toString().length())).intValue())+25));
      textField.setWidth(getLenghtForCaption((new Integer(metrics.elementAt(i).toString().length())).intValue())+25);

      textField.setHeight(14);
      //textField.setPattern(numberFormatPattern);
      expression = new JRDesignExpression();
      expression.setValueClass(java.lang.Float.class);
      expression.setText("$F{"+metrics.elementAt(i)+"}");
      textField.setBlankWhenNull(true);
      textField.setStretchWithOverflow(true);
      textField.setExpression(expression);
      band.addElement(textField);
      metricsPosition.add(new Integer(printAt + 25));
      printAt += getLenghtForCaption(((Integer) metricsSizes.elementAt(i)).intValue()) + 25 ;
    }

    for(int i = 0 ; i < accuMetrics.size() ; i++) {
      JRDesignTextField textField = new JRDesignTextField();
      textField.setX(printAt + 25);
      textField.setY(0);

      //textField.setWidth(getLenghtForCaption(((Integer) accuMetricsSizes.elementAt(i)).intValue())+15);

      accMetricsWidht.add(new Integer(getLenghtForCaption((new Integer(accuMetrics.elementAt(i).toString().length())).intValue())+25));
      textField.setWidth(getLenghtForCaption((new Integer(accuMetrics.elementAt(i).toString().length())).intValue())+25);

      textField.setHeight(14);
      //textField.setPattern(numberFormatPattern);
      expression = new JRDesignExpression();
      expression.setValueClass(java.lang.Float.class);
      expression.setText("$F{"+accuMetrics.elementAt(i)+"}");
      textField.setBlankWhenNull(true);
      textField.setStretchWithOverflow(true);
      textField.setExpression(expression);
      band.addElement(textField);
      metricsPosition.add(new Integer(printAt + 25));
      accMetricsPosition.add(new Integer(printAt + 25));
      printAt += getLenghtForCaption(((Integer) accuMetricsSizes.elementAt(i)).intValue()) + 25 ;
    }

    jasperDesign.setDetail(band);
  }

  /**
   * Agrega la cabecera de pagina a la definicion
   * @param jasperDesign
   */
  /*private void addPageHeader(JasperDesign jasperDesign) {
    int printAt = 45;
    JRDesignBand band = new JRDesignBand();
    for(int i = 0 ; i < dimensions.size() ; i++) {
      String caption = reportResult.getReportSpec().getDimensionFromName(dimensions.elementAt(i).toString()).getCaption();
      JRDesignStaticText text = new JRDesignStaticText();
      text.setX(0);
      text.setY(0);
      text.setWidth(40);
      text.setHeight(15);
      text.setText(LanguageTraslator.traslate("308"));
      band.addElement(text);
      text = new JRDesignStaticText();
      text.setX(printAt);
      text.setY(0);
      text.setWidth(getLenghtForCaptionHeader(caption.length()));
      text.setHeight(15);
      if(i == dimensions.size() - 1) {
        text.setText(caption);
      } else {
        text.setText(caption + ",");
      }
      band.addElement(text);
      printAt += getLenghtForCaptionHeader(caption.length());
      JRDesignLine line = new JRDesignLine();
      line = new JRDesignLine();
      line.setX(0);
      line.setY(16);
      line.setWidth(515);
      line.setHeight(0);
      band.addElement(line);
    }
    printAt = 45;
    for(int i = 0 ; i < nonGroupingDimensions.size() ; i++) {
      String caption = reportResult.getReportSpec().getDimensionFromName(nonGroupingDimensions.elementAt(i).toString()).getCaption();
      JRDesignStaticText text = new JRDesignStaticText();
      text.setX(0);
      text.setY(15);
      text.setWidth(40);
      text.setHeight(15);
      text.setText(LanguageTraslator.traslate("309"));
      band.addElement(text);
      text = new JRDesignStaticText();
      text.setX(printAt);
      text.setY(15);
      text.setWidth(getLenghtForCaptionHeader(caption.length()));
      text.setHeight(15);
      if(i == nonGroupingDimensions.size() - 1) {
        text.setText(caption);
      } else {
        text.setText(caption + ",");
      }
      band.addElement(text);
      printAt += getLenghtForCaptionHeader(caption.length());
      JRDesignLine line = new JRDesignLine();
      line = new JRDesignLine();
      line.setX(0);
      line.setY(31);
      line.setWidth(515);
      line.setHeight(0);
      band.addElement(line);
    }
    printAt = 45;
    for(int i = 0 ; i < metrics.size() ; i++) {
      String caption = reportResult.getReportSpec().getMetricFromName(metrics.elementAt(i).toString()).getCaption();
      JRDesignStaticText text = new JRDesignStaticText();
      text.setX(0);
      text.setY(30);
      text.setWidth(40);
      text.setHeight(15);
      text.setText(LanguageTraslator.traslate("310"));
      band.addElement(text);
      text = new JRDesignStaticText();
      text.setX(printAt);
      text.setY(30);
      text.setWidth(getLenghtForCaptionHeader(caption.length()));
      text.setHeight(15);
      if(accuMetrics.size() == 0) {
        if(i == metrics.size() - 1) {
          text.setText(caption);
        } else {
          text.setText(caption + ",");
        }
      } else {
        text.setText(caption + ",");
      }
      band.addElement(text);
      printAt += getLenghtForCaptionHeader(caption.length());
      JRDesignLine line = new JRDesignLine();
      line = new JRDesignLine();
      line.setX(0);
      line.setY(46);
      line.setWidth(515);
      line.setHeight(0);
      band.addElement(line);
    }
    for(int i = 0 ; i < accuMetrics.size() ; i++) {
      String caption = getAccMetricCaption(accuMetrics.elementAt(i).toString());
      JRDesignStaticText text = new JRDesignStaticText();
      text.setX(0);
      text.setY(30);
      text.setWidth(40);
      text.setHeight(15);
      text.setText(LanguageTraslator.traslate("310"));
      band.addElement(text);
      text = new JRDesignStaticText();
      text.setX(printAt);
      text.setY(30);
      text.setWidth(getLenghtForCaptionHeader(caption.length()));
      text.setHeight(15);
      if(i == accuMetrics.size() - 1) {
        text.setText(caption);
      } else {
        text.setText(caption + ",");
      }
      band.addElement(text);
      printAt += getLenghtForCaptionHeader(caption.length());
      JRDesignLine line = new JRDesignLine();
      line = new JRDesignLine();
      line.setX(0);
      line.setY(46);
      line.setWidth(515);
      line.setHeight(0);
      band.addElement(line);
    }
    jasperDesign.setPageHeader(band);
  }*/

  private void addPageHeader(JasperDesign jasperDesign) {

      JRDesignBand band = new JRDesignBand();

      String caption = getCaption(LanguageTraslator.traslate("308"), dimensions, new StringBuffer());
      JRDesignStaticText text = new JRDesignStaticText();
      text = new JRDesignStaticText();
      text.setX(0);
      text.setY(0);
      text.setWidth(getLenghtForCaptionHeader(caption.length()));
      text.setHeight(15);
      text.setText(caption);
      band.addElement(text);

      caption = getCaption(LanguageTraslator.traslate("309"), nonGroupingDimensions, new StringBuffer());
      text = new JRDesignStaticText();
      text.setX(0);
      text.setY(15);
      text.setWidth(getLenghtForCaptionHeader(caption.length()));
      text.setHeight(15);
      text.setText(caption);
      band.addElement(text);

      StringBuffer sb = new StringBuffer();
      StringBuffer buffer = new StringBuffer();
      sb.append(getCaption(LanguageTraslator.traslate("310"), metrics, buffer));
      sb.append(getCaption("", accuMetrics, buffer));
      text = new JRDesignStaticText();
      text.setX(0);
      text.setY(30);
      text.setWidth(getLenghtForCaptionHeader(sb.toString().length()));
      text.setHeight(15);
      text.setText(sb.toString());
      band.addElement(text);

      jasperDesign.setPageHeader(band);
  }

  private String getCaption(String tittle, Vector vector, StringBuffer bufferString) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tittle);
    if(vector == dimensions || vector == nonGroupingDimensions) {
      for(int i = 0 ; i < vector.size() ; i++){
        String caption = reportResult.getReportSpec().getDimensionFromName(vector.elementAt(i).toString()).getCaption();
        if(i == vector.size() - 1) {
          buffer.append(caption);
        } else {
          buffer.append(caption + ", ");
        }
      }
    } else if(vector == metrics) {
      if(accuMetrics.size() == 0) {
        for(int i = 0 ; i < vector.size() ; i++) {
          String caption = reportResult.getReportSpec().getMetricFromName(metrics.elementAt(i).toString()).getCaption();
          if(i == vector.size() - 1) {
            buffer.append(caption);
          } else {
            buffer.append(caption + ", ");
          }
        }
      } else {
        for(int i = 0 ; i < vector.size() ; i++) {
          String caption = reportResult.getReportSpec().getMetricFromName(metrics.elementAt(i).toString()).getCaption();
          buffer.append(caption + ", ");
        }
      }
    } else {
      Object [] accMetrics = reportResult.getReportSpec().getAccumulableMetrics();
      for(int i = 0 ; i < accMetrics.length ; i++) {
        ReportMetricSpec metric = (ReportMetricSpec) accMetrics[i];
        if(i == accMetrics.length - 1) {
          buffer.append(metric.getCaption() + " " + LanguageTraslator.traslate("315"));
        } else {
          buffer.append(metric.getCaption() + " " + LanguageTraslator.traslate("315") + ", ") ;
        }

      }
    }
    return buffer.toString();
  }

  /**
   * Agrega el titulo al reporte.
   * @param jasperDesign
   */
  private void addTitle(JasperDesign jasperDesign) throws JRException{
    //Title
		JRDesignTextField textField = new JRDesignTextField();
    //JRDesignLine line = new JRDesignLine();
    JRDesignBand band = new JRDesignBand();
		band.setHeight(50);
		JRDesignStaticText staticText = new JRDesignStaticText();
		staticText.setX(0);
		staticText.setY(10);
		staticText.setWidth(515);
		staticText.setHeight(30);
		staticText.setTextAlignment(JRTextElement.TEXT_ALIGN_CENTER);
		JRDesignReportFont bigFont = new JRDesignReportFont();
		bigFont.setName("Courier_Normal");
		bigFont.setDefault(true);
		bigFont.setFontName("Courier New");
		bigFont.setSize(12);
		bigFont.setPdfFontName("Helvetica");
		bigFont.setPdfEncoding("Cp1252");
		bigFont.setPdfEmbedded(false);
    jasperDesign.addFont(bigFont);
  	staticText.setFont(bigFont);
    staticText.setText(tittle);
		band.addElement(staticText);
    /*line = new JRDesignLine();
		line.setX(0);
		line.setY(0);
		line.setWidth(515);
		line.setHeight(0);
		band.addElement(line);*/
		jasperDesign.setTitle(band);

    JRDesignBand emptyBand = new JRDesignBand();
    emptyBand.setHeight(1);
    jasperDesign.setPageHeader(emptyBand);
    emptyBand = new JRDesignBand();
    emptyBand.setHeight(1);
    jasperDesign.setColumnHeader(emptyBand);
    emptyBand = new JRDesignBand();
    emptyBand.setHeight(1);
    jasperDesign.setColumnFooter(emptyBand);

    band = new JRDesignBand();
    band.setHeight(15);
    staticText = new JRDesignStaticText();
    staticText.setX(0);
    staticText.setY(0);
    staticText.setWidth(40);
    staticText.setHeight(15);
    staticText.setText("Pagina: ");
    band.addElement(staticText);
    textField = new JRDesignTextField();
    textField.setX(40);
    textField.setY(0);
    textField.setWidth(100);
    textField.setHeight(15);
    textField.setBlankWhenNull(true);
    textField.setStretchWithOverflow(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.Integer.class);
    expression.setText("$V{PAGE_NUMBER}");
    textField.setExpression(expression);
    band.addElement(textField);
    jasperDesign.setPageFooter(band);

    band = new JRDesignBand();
    band.setHeight(20);
    jasperDesign.setSummary(band);
  }

/*  private void addColumnsHeader(JasperDesign jasperDesign) {
    //columnHeader
    JRDesignBand band = new JRDesignBand();
    for(int i = 0 ; i < metrics.size() ; i++) {
      band.setHeight(20);
      JRDesignStaticText text = new JRDesignStaticText();
      text.setX(((Integer)metricsPosition.elementAt(i)).intValue());
      text.setY(0);
      text.setWidth(40);
      text.setHeight(20);
      text.setText(reportResult.getReportSpec().getDimensionFromName(metrics.elementAt(i).toString()).getCaption());
      band.addElement(text);
    }
    jasperDesign.setColumnHeader(band);
  }

  private void addColumnsFooter(JasperDesign jasperDesign) {
    JRDesignBand band = new JRDesignBand();
    JRDesignTextField textField;
    String name;
    band.setHeight(20);
    JRDesignStaticText text = new JRDesignStaticText();
    text.setX(40);
    text.setY(0);
    text.setWidth(40);
    text.setHeight(20);
    text.setText("Total");
    band.addElement(text);

    for(int i = 0 ; i < metrics.size() ; i++) {
      textField = new JRDesignTextField();
      textField.setX(((Integer)metricsPosition.elementAt(i)).intValue());
      textField.setY(0);
      textField.setWidth(100);
      textField.setHeight(15);

      JRDesignExpression expression = new JRDesignExpression();
      expression.setValueClass(java.lang.Float.class);
      name = metrics.elementAt(i).toString()+"_SUM";
      expression.setText("$V{"+name+"}");
      textField.setExpression(expression);
      band.addElement(textField);

      band.addElement(text);
    }

    jasperDesign.setColumnFooter(band);
  }
  */

  /**
   * Inicializa los vectores con la descripcion de las dimensiones
   * que agrupan, las que no agrupan y las metricas.
   * @param dimensionsCount
   * @param metricsCount
   * @param nonGroupingDimensionsCount
   * @param accMetricsCount
   */
  private void initializeVectors(int dimensionsCount, int metricsCount, int nonGroupingDimensionsCount, int accMetricsCount) {
    dimensions = new Vector();
    nonGroupingDimensions = new Vector();
    metrics = new Vector();
    accuMetrics = new Vector();
    if(dimensionsSizes==null){
      dimensionsSizes = new Vector();
    }
    if(nonGroupingDimensionsSizes==null){
      nonGroupingDimensionsSizes = new Vector();
    }
    int i = 0;
    for (; i < dimensionsCount; i++) {
      dimensions.add(data.getColumnName(i));
    }
    for (int z = 0; z < nonGroupingDimensionsCount; i++, z++) {
      nonGroupingDimensions.add(data.getColumnName(i));
    }
    for (int j = 0; j < metricsCount; i++, j++) {
      metrics.add(data.getColumnName(i));
    }
    for (int j = 0; j < accMetricsCount; i++, j++) {
      accuMetrics.add(data.getColumnName(i));
    }

  }

  /**
   * Determina un Vector con los anchos mas precisos.
   * @param vector
   * @return
   */
  private Vector calculateBestLenghts(Vector vector) {
    Vector bestSizes = new Vector();
    Vector ColumnSizes;
    if(dimensions.size()==0){
      dimensions.add(emptyGroup);
      bestSizes.add(new Integer(4));
      return bestSizes;
    }
    if (data.getRowCount() != 0) {
      for (int i = 0; i < vector.size(); i++) {
        ColumnSizes = new Vector();
        Object value = data.getValueAt(0, getColumnIndexFromName(vector.elementAt(i).toString()));
        String current = "";
        if (value != null) {current = value.toString();}
        if (data.getRowCount() == 1) {
          ColumnSizes.add(new Integer(current.length()));
          //break;
        }
        else {
          ColumnSizes.add(new Integer(current.length()));
          for (int j = 0; j < data.getRowCount(); j++) {
            if ((data.getValueAt(j, i)!=null) && (!current.equals(data.getValueAt(j, i).toString()))) {
              if (( vector.elementAt(i)!=null)&&(data.getValueAt(j, getColumnIndexFromName(vector.elementAt(i).toString()))!=null)){
                ColumnSizes.add(new Integer(data.getValueAt(j, getColumnIndexFromName(vector.elementAt(i).toString())).toString().length()));
                current = data.getValueAt(j, i).toString();
              }
            }
          }
        }
        bestSizes.add(getBestSize(ColumnSizes));
      }
    }
    return bestSizes;
  }

  /**
   * Retorna un indice a partir de un nombre de columna.
   * @param columnName
   * @return
   */
  private int getColumnIndexFromName(String columnName) {
    int index = 0;
    for (int i = 0; i < data.getColumnCount(); i++) {
      if (data.getColumnName(i).equals(columnName)) {
        index = i;
        break;
      }
    }
    return index;
  }

  /**
   * Retorna el ancho mas eficiente comparando los elementos
   * del Vector
   * @param ColumnSizes
   * @return
   */
  private Integer getBestSize(Vector ColumnSizes) {
    int compareTo = 0;
    for (int i = 0; i < ColumnSizes.size(); i++) {
      if (((Integer) ColumnSizes.elementAt(i)).intValue() > compareTo) {
        compareTo = ((Integer) ColumnSizes.elementAt(i)).intValue();
      }
    }
    return new Integer(compareTo);
  }

  /**
   * Determina el ancho para las descripciones
   * de la cabecera
   * @param chars
   * @return
   */
  private int getLenghtForCaptionHeader(int chars){
    //return chars * 8 - chars;
    Integer integer = new Integer(chars);
    Double qsrt = new Double(Math.sqrt(integer.doubleValue()));
    return chars * 7 - ((chars / 2) - 3 * qsrt.intValue());
  }

  /**
   * Determina el comienzo donde se mostraran las
   * metricas o dimensiones que no agrupan.
   * @return
   */
  private int calculateStartForItem() {
    int width = 0 ;
    for(int i = 0 ; i < dimensionsSizes.size() ; i++){
      width += (((Integer)dimensionsSizes.elementAt(i)).intValue());
    }
    //return (width) + 100;
    return 1;
  }

  /**
   * Retorna un ancho preciso a partir de una
   * determinada cantidad de caracteres
   * @param chars
   * @return
   */
  private int getLenghtForCaption(int chars) {
    if(chars == 2 ) {
      return chars * 7;
    }
    Integer integer = new Integer(chars);
    Double qsrt = new Double(Math.sqrt(integer.doubleValue()));
    return chars * 8 - ((chars / 2) - 3 * qsrt.intValue());
  }

  /**
   * Retorna los fields.
   * @return
   */
  public Map getFields() {
    if (fields == null){
      fields = new HashMap();
    }
    return fields;
  }

  /**
   * Retorna las variables
   * @return
   */
  public Map getVariables() {
    if (variables == null ){
      variables = new HashMap();
    }
    return variables;
  }
}