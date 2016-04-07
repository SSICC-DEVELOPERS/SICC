package com.calipso.reportgenerator.common;

import dori.jasper.engine.design.JRDesignLine;
import dori.jasper.engine.design.JRDesignTextField;
import dori.jasper.engine.design.JRDesignRectangle;
import dori.jasper.engine.design.JRDesignBand;
import dori.jasper.engine.design.JRDesignExpression;
import dori.jasper.engine.design.JRDesignStaticText;
import dori.jasper.engine.design.JRDesignTextElement;
import dori.jasper.engine.design.JRDesignParameter;
import dori.jasper.engine.design.JRDesignFont;
import dori.jasper.engine.design.JRDesignElement;
import dori.jasper.engine.design.JasperDesign;
import dori.jasper.engine.JRElement;
import dori.jasper.engine.JRFont;
import dori.jasper.engine.JRTextElement;
import dori.jasper.engine.JRBand;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JRParameter;
import dori.jasper.engine.JRGraphicElement;
import dori.jasper.engine.JRGroup;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 18/10/2004
 * Time: 17:26:19
 * To change this template use Options | File Templates.
 */
public class BelcorpDecoratedReportLayout implements IJasperDefinition {
  private IJasperDefinition jasperDefinition;
  private static final int FIRSTCOLUMN_LABELS_X = 2;
  private static final int FIRST_ROW_LABELS_Y = 2;
  private static final int headerColumns = 3;
  private static final int headerRows = 3;
  private static HashMap params;
  public static final String descPaisParam = "DESCPAIS";
  public static final String countryParam = "countryparamVALUE";
  public static final String zoneuserParam = "zoneuserVALUE";
  public static final String moduleParam = "moduleVALUE";
  public static final String endOfReportString = "1026";
  public static final String datePattern = "datepatternVALUE";
  public static final String floatPattern = "floatpatternVALUE";
  public static final String integerPattern = "integerpatternVALUE";
  public static final String decimalSeparator = "decimalseparatorVALUE";  
  public static final String titleParam = "titleVALUE";
  public static final String emptyReport = "1104";
  public static final String emptyReportParamName = "EMPTYREPORT";
  public static final String reportDefinitionId = "ReportDefinitionId";
  //private int FIRSTCOLUMN_TITLE_LABELS_WIDTH = 70;

  private BelcorpDecoratedReportLayout(){
  }

  public BelcorpDecoratedReportLayout(IJasperDefinition design) {
    this.jasperDefinition = design;
  }

  public JasperDesign getJasperDefinition(boolean isLandscape) throws JRException {
    JasperDesign design = jasperDefinition.getJasperDefinition(isLandscape);
    design.setWhenNoDataType(JasperDesign.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
    design.setTitle(null);
    addBelcorpParams(design);
    addBelcorpHeader(design);
    changePatterns(design);
    addReportFooter(design);
    return design;
  }
  
  private void changePatterns(JasperDesign design){
    JRElement[] elements = getAllDesignElements(design);
    for(int i=0; i < elements.length; i++){
      if(elements[i] instanceof JRDesignTextField){
        JRDesignTextField field = (JRDesignTextField)elements[i];
        JRDesignExpression expression = (JRDesignExpression)field.getExpression();
        if(expression.getValueClass().equals(Date.class)){
          String text = "new SimpleDateFormat($P{datepatternVALUE}).format( "+ expression.getText() + " ) ";
          expression.setText(text);
          expression.setValueClass(String.class);
        }else if(expression.getValueClass().equals(Integer.class)){
          String text = "com.calipso.reportgenerator.reportcalculator.SharedFloat.newFrom("+ expression.getText() + ").format($P{integerpatternVALUE},$P{decimalseparatorVALUE},\"\")";
          expression.setText(text);
          expression.setValueClass(String.class);
          field.setTextAlignment(JRDesignTextElement.HORIZONTAL_ALIGN_RIGHT);
        }else if(expression.getValueClass().equals(Float.class)){
          String text = "com.calipso.reportgenerator.reportcalculator.SharedFloat.newFrom("+ expression.getText() + ").format($P{floatpatternVALUE},$P{decimalseparatorVALUE},\"\")";        
          expression.setText(text);
          expression.setValueClass(String.class);
          field.setTextAlignment(JRDesignTextElement.HORIZONTAL_ALIGN_RIGHT);
        }
      }
    }
  }
  
  /**
   * Obtiene todos los elementos que hay en el design
   * @param design
   * @return 
   */
  public JRElement[] getAllDesignElements(JasperDesign design){
    JRElement[] result = new JRElement[getAllElementSize(design)];
    int i = 0;
    JRElement[] detailElements = design.getDetail().getElements();
    System.arraycopy(detailElements, 0, result, i, detailElements.length);
    i += detailElements.length;
    JRGroup[] groups = design.getGroups();
    for(int j=0; j < groups.length; j++){
      JRElement[] elements = groups[j].getGroupHeader().getElements();
      System.arraycopy(elements, 0, result, i, elements.length);
      i += elements.length;
      elements = groups[j].getGroupFooter().getElements();
      System.arraycopy(elements, 0, result, i, elements.length);
      i += elements.length;
    }
    return result;
  }
  
  /**
   * Retorna la cantidad de JRElements que hay en todo el Design, sumando
   * los que hay en el detalle y en los grupos
   */
  private int getAllElementSize(JasperDesign design){
    int i = 0;
    JRElement[] detailElements = design.getDetail().getElements();
    i += detailElements.length;
    JRGroup[] groups = design.getGroups();
    for(int j=0; j < groups.length; j++){
      i += groups[j].getGroupHeader().getElements().length;
      i += groups[j].getGroupFooter().getElements().length;
    }
    return i;
  }

  private void addBelcorpParams(JasperDesign design) throws JRException{
    Collection paramNames = getParamsNames(design);
    Collection names = getParametersToAdd();
    Iterator namesIterator = names.iterator();
    //String[] names = new String[] {countryParam, zoneuserParam, moduleParam, datePattern, floatPattern, titleParam, endOfReportString, emptyReport, descPaisParam};
    while(namesIterator.hasNext()){
      String name = namesIterator.next().toString();
      if(!paramNames.contains(name)){
        JRParameter param = getParameterFor(name);
        design.addParameter(param);
      }
    }
    JRGroup[] groups = design.getGroups();
    for (int i = 0; i < groups.length; i++) {
      JRGroup group = groups[i];
      design.addParameter(getParameterFor("COLUMN_" + ReportLayoutBuilder.getGroupDefinitionName(group)));
    }
    Collection elements = selectStaticTextElements(design.getDetail().getElements());
    int i=0;
    for (Iterator iterator = elements.iterator(); iterator.hasNext();i++) {
      String name = (String) iterator.next();
      design.addParameter(getParameterFor("COLUMN_" + name));
    }
    if(!paramNames.contains(emptyReportParamName)){
      design.addParameter(getEmptyReportParameter());
    }
  }
  
  private Collection getParametersToAdd(){
    Collection result = new Vector();
    String[] names = new String[] {countryParam, zoneuserParam, moduleParam, datePattern, floatPattern, integerPattern, decimalSeparator, titleParam, endOfReportString, descPaisParam, emptyReport, reportDefinitionId};
    for(int i=0; i < names.length; i++){
      result.add(names[i]);
    }
    Map otherParams = BelcorpDecoratedReportLayout.getParams();
    Iterator it = otherParams.entrySet().iterator();
    while(it.hasNext()){
      String name = ((Map.Entry)it.next()).getKey().toString();
      if(!result.contains(name) && !name.equalsIgnoreCase(emptyReportParamName)){
        result.add(name);
      }
    }
    return result;
  }
  
  private JRParameter getEmptyReportParameter(){
    JRDesignParameter parameter = new JRDesignParameter();
    parameter.setValueClass(java.lang.Boolean.class);
    parameter.setName(emptyReportParamName);
    return parameter;
  }

  private JRParameter getParameterFor(String name) {
    JRDesignParameter parameter = new JRDesignParameter();
    parameter.setValueClass(java.lang.String.class);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setText("");
    expression.setValueClass(java.lang.String.class);
    parameter.setDefaultValueExpression(expression);
    parameter.setName(name);
    return parameter;
  }

  private Collection getParamsNames(JasperDesign design) {
    Collection result = new Vector();
    JRParameter[] params = design.getParameters();
    for (int i = 0; i < params.length; i++) {
      JRParameter param = params[i];
      result.add(param.getName());
    }
    return result;
  }

  private void addBelcorpHeader(JasperDesign design) {
    changeTitleBand(design);
    addPageHeader(design);
  }

  private void addPageHeader(JasperDesign design) {
  
 /*   JRBand oldTitleBand = design.getTitle();
    JRDesignBand titleBand = new JRDesignBand();
    titleBand.setHeight(oldTitleBand.getHeight());
    moveOldElements(design, oldTitleBand, titleBand);
    JRDesignRectangle rectangle = getBandRectangle(design, oldTitleBand);
    titleBand.addElement(rectangle);
    titleBand.addElement(getBelcorpLabel(design, titleBand));
    titleBand.addElement(getCountryZoneLabel(design, titleBand));
    titleBand.addElement(getZoneUserLabel(design, titleBand));
    titleBand.addElement(getModuleLabel(design, titleBand));
    addPageNumberLabel(design, titleBand);
    titleBand.addElement(getDateLabel(design, titleBand));
    titleBand.addElement(getTimeLabel(design, titleBand));
    design.setTitle(titleBand);*/

  
    JRDesignBand pageHeader = (JRDesignBand)design.getPageHeader();
    pageHeader.setHeight(65);
    pageHeader.addElement(getBandRectangle(design, pageHeader));
    pageHeader.addElement(getColumnLineBand(design, pageHeader));    
    pageHeader.addElement(getBelcorpLabel(design, pageHeader));
    pageHeader.addElement(getCountryZoneLabel(design, pageHeader));
    pageHeader.addElement(getZoneUserLabel(design, pageHeader));
    pageHeader.addElement(getModuleLabel(design, pageHeader));
    addPageNumberLabel(design, pageHeader);
    pageHeader.addElement(getDateLabel(design, pageHeader));
    pageHeader.addElement(getTimeLabel(design, pageHeader));
    //addColumnHeaders(design, pageHeader);
  }

  private void addColumnHeaders(JasperDesign design, JRDesignBand pageHeader) {
    int columnWidth = getColumnWidth(design);
    addGroupsHeader(design, pageHeader, columnWidth);
    addNonGroupsHeader(design, pageHeader, columnWidth);
  }

  private void addNonGroupsHeader(JasperDesign design, JRDesignBand pageHeader, int columnWidth) {
    int groupCount = design.getGroups().length;
    Collection elements = selectStaticTextElements(design.getDetail().getElements());
    int i=0;
    for (Iterator iterator = elements.iterator(); iterator.hasNext();i++) {
      String name = (String) iterator.next();
      pageHeader.addElement(getColumnHeader(pageHeader, name, columnWidth, i + groupCount));
    }
  }

  private JRDesignElement getColumnHeader(JRDesignBand pageHeader, String name, int columnWidth, int i) {
    JRDesignTextField field = new JRDesignTextField();
    field.setX(i * columnWidth + 1);
    field.setY(FIRST_ROW_LABELS_Y);
    field.setHeight(getLabelHeightFromBand(pageHeader, 1) - 2);
    field.setWidth(columnWidth - 1);
    field.setFont(getLabelFont(getLabelHeightFromBand(pageHeader, 1) - 2));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{COLUMN_"+ name +"}");
    field.setExpression(expression);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);
    return field;
    /*JRDesignStaticText text = new JRDesignStaticText();
    text.setFont(getLabelFont(getLabelHeightFromBand(pageHeader, 1) - 2));
    text.setText(name);
    text.setX(i * columnWidth + 1);
    text.setY(FIRST_ROW_LABELS_Y);
    text.setHeight(getLabelHeightFromBand(pageHeader, 1) - 2);
    text.setWidth(columnWidth - 1);
    text.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);
    return text;*/
  }

  private Collection selectStaticTextElements(JRElement[] elements) {
    Collection collection = new Vector();
    for (int i = 0; i < elements.length; i++) {
      JRElement element = elements[i];
      if(element instanceof JRDesignStaticText){
        collection.add(((JRDesignStaticText)element).getText());
      }else if(element instanceof JRDesignTextField){
        String text = ((JRDesignTextField)element).getExpression().getChunks()[0].getText();
        collection.add(text);
      }
    }
    return collection;
  }

  private int getColumnWidth(JasperDesign design) {
    int width = getPrintWidth(design);
    int columnCount = design.getGroups().length + selectStaticTextElements(design.getDetail().getElements()).size();
    return width / columnCount;
  }

  private void addGroupsHeader(JasperDesign design, JRDesignBand pageHeader, int columnWidth) {
    JRGroup[] groups = design.getGroups();
    for (int i = 0; i < groups.length; i++) {
      JRGroup group = groups[i];
      pageHeader.addElement(getColumnHeader(pageHeader, ReportLayoutBuilder.getGroupDefinitionName(group), columnWidth, i));
    }
  }

  /*private JRDesignElement getGroupColumnHeader(JRDesignBand pageHeader, JRGroup group, int columnWidth, int i) {
    String groupNameParam = getGroupDefinitionName(group);
    JRDesignTextField field = new JRDesignTextField();
    field.setX(i * columnWidth + 1);
    field.setY(FIRST_ROW_LABELS_Y);
    field.setHeight(getLabelHeightFromBand(pageHeader, 1) - 2);
    field.setWidth(columnWidth - 1);
    field.setFont(getLabelFont(getLabelHeightFromBand(pageHeader, 1) - 2));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{"+ groupNameParam +"}");
    field.setExpression(expression);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);

    /*String groupName = getGroupDefinitionName(group);
    JRDesignStaticText text = new JRDesignStaticText();
    text.setFont(getLabelFont(getLabelHeightFromBand(pageHeader, 1) - 2));
    text.setText(groupName);
    text.setX(i * columnWidth + 1);
    text.setY(FIRST_ROW_LABELS_Y);
    text.setHeight(getLabelHeightFromBand(pageHeader, 1) - 2);
    text.setWidth(columnWidth - 1);
    text.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);
    return text;
  }*/
  
  private void addReportFooter(JasperDesign design) {
    JRDesignBand endOfReport = (JRDesignBand)design.getSummary();
    endOfReport.setHeight(45);
    endOfReport.addElement(getEmptyReportLabel(endOfReport));
    endOfReport.addElement(getEndOfReportLabel(endOfReport));
  }
  
  private JRDesignElement getEmptyReportLabel(JRDesignBand band){
    JRDesignTextField field = new JRDesignTextField();
    field.setX(FIRSTCOLUMN_LABELS_X);
    field.setY(1);
    field.setHeight(18);
    field.setWidth(500);
    field.setFont(getLabelFont(Math.min(20, band.getHeight())));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{"+ emptyReport +"}");
    field.setExpression(expression);
    field.setEvaluationTime(JRDesignExpression.EVALUATION_TIME_REPORT);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_LEFT);
    return field;
  }

  private JRDesignElement getEndOfReportLabel(JRDesignBand band) {
    JRDesignTextField field = new JRDesignTextField();
    field.setX(FIRSTCOLUMN_LABELS_X);
    field.setY(24);
    field.setHeight(18);
    field.setWidth(500);
    field.setFont(getLabelFont(Math.min(20, band.getHeight())));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{"+ endOfReportString +"}");
    field.setExpression(expression);
    field.setEvaluationTime(JRDesignExpression.EVALUATION_TIME_REPORT);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_LEFT);
    return field;
  
/*    JRDesignStaticText text = new JRDesignStaticText();
    text.setFont(getLabelFont(Math.min(20, band.getHeight())));
    text.setText(endOfReportString);
    text.setX(FIRSTCOLUMN_LABELS_X);
    text.setY(FIRST_ROW_LABELS_Y);
    text.setHeight(getLabelHeightFromBand(band, 1) - 2);
    text.setWidth(getWidthForText(text));
    text.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_LEFT);
    return text;*/
  }

  /**
   * Retorna un ancho aproximado o probable que podria ocupar un texto con una fuente determinada.
   * No sirve para fuentes de mas de 18 puntos.
   * @param text
   * @return
   */
  private int getWidthForText(JRDesignStaticText text) {
    if(text.getFont().getSize() < 12){
      return text.getText().length() * 10;
    }else{
      return text.getText().length() * 20;
    }
  }

  private void changeTitleBand(JasperDesign design) {
  }

  private JRDesignElement getTimeLabel(JasperDesign design, JRDesignBand titleBand) {
    JRDesignTextField field = new JRDesignTextField();
    field.setX(getLabelPosX(design, 3, 3));
    field.setY(getLabelPosY(titleBand, headerRows, 3));
    field.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    field.setWidth(getTitleLabelsWidth(design, headerColumns));
    field.setFont(getLabelFont(field.getHeight()));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("new SimpleDateFormat($P{datepatternVALUE}).format(GregorianCalendar.getInstance().getTime())");
    field.setExpression(expression);
    field.setEvaluationTime(JRDesignExpression.EVALUATION_TIME_REPORT);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_RIGHT);
    return field;
  }

  private JRDesignElement getDateLabel(JasperDesign design, JRDesignBand titleBand) {
    JRDesignTextField field = new JRDesignTextField();
    field.setX(getLabelPosX(design, 3, 3));
    field.setY(getLabelPosY(titleBand, headerRows, 2));
    field.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    field.setWidth(getTitleLabelsWidth(design, headerColumns));
    field.setFont(getLabelFont(field.getHeight()));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("new SimpleDateFormat($P{datepatternVALUE}).format(GregorianCalendar.getInstance().getTime())");
    field.setExpression(expression);
    field.setEvaluationTime(JRDesignExpression.EVALUATION_TIME_REPORT);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_RIGHT);
    return field;
  }

  private void addPageNumberLabel(JasperDesign design, JRDesignBand titleBand) {
    JRDesignStaticText textElement = new JRDesignStaticText();
    textElement.setText("Pag. ");
    int posX = design.getPageWidth() - design.getRightMargin();
    textElement.setX(posX - 115);
    textElement.setY(FIRST_ROW_LABELS_Y);
    textElement.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    textElement.setWidth(30);
    textElement.setFont(getLabelFont(textElement.getHeight()));
    titleBand.addElement(textElement);

    JRDesignTextField field = new JRDesignTextField();
    field.setX(posX - 85);
    field.setY(FIRST_ROW_LABELS_Y);
    field.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    field.setWidth(22);
    field.setFont(getLabelFont(textElement.getHeight()));
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.Integer.class);
    expression.setText("$V{PAGE_NUMBER}");
    field.setExpression(expression);
    field.setEvaluationTime(JRDesignExpression.EVALUATION_TIME_NOW);
    field.setPattern("###");
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);
    titleBand.addElement(field);

    textElement = new JRDesignStaticText();
    textElement.setText(" de ");
    textElement.setX(posX - 63);
    textElement.setY(FIRST_ROW_LABELS_Y);
    textElement.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    textElement.setWidth(20);
    textElement.setFont(getLabelFont(textElement.getHeight()));
    titleBand.addElement(textElement);

    field = new JRDesignTextField();
    field.setX(posX - 43);
    field.setY(FIRST_ROW_LABELS_Y);
    field.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    field.setWidth(22);
    field.setFont(getLabelFont(textElement.getHeight()));
    expression = new JRDesignExpression();
    expression.setValueClass(java.lang.Integer.class);
    expression.setText("$V{PAGE_NUMBER}");
    field.setExpression(expression);
    field.setPattern("###");
    field.setEvaluationTime(JRDesignExpression.EVALUATION_TIME_REPORT);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);
    titleBand.addElement(field);
  }

  private JRDesignElement getModuleLabel(JasperDesign design, JRDesignBand titleBand) {
    JRDesignTextField field = new JRDesignTextField();
    field.setX(getLabelPosX(design, headerColumns, 2));
    field.setY(FIRST_ROW_LABELS_Y);
    field.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    field.setWidth(getTitleLabelsWidth(design, headerColumns));
    field.setFont(getLabelFont(field.getHeight()));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{"+ moduleParam +"}");
    field.setExpression(expression);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);
    return field;
  }

  private void moveOldElements(JasperDesign design, JRBand oldTitleBand, JRDesignBand titleBand) {
    JRElement[] elements = oldTitleBand.getElements();
    if(elements.length > 1){
      //System.out.println("Existia mas de un atributo titulo. Se tomo el primero");
    }
    JRDesignTextElement element = null;
    try{
      element = (JRDesignTextElement)elements[0];
    }catch (ClassCastException e){
    //  System.out.println("Error: el elemento no era un titulo compatible");
      e.printStackTrace();
    }
    element = new JRDesignTextField();
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{"+ titleParam +"}");
    ((JRDesignTextField)element).setExpression(expression);
    element.setX(getLabelPosX(design, headerColumns, 2));
    element.setY(getLabelPosY(titleBand, headerRows, 2));
    element.setFont(getLabelFont(getLabelHeightFromBand(titleBand, headerRows)));
    element.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    element.setWidth(getTitleLabelsWidth(design, headerColumns));
    element.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_CENTER);
    titleBand.addElement(element);
  }

  /**
   * Retorna la posicion X donde debera ubicarse el elemento segun cuantas columnas halla, y su numero de columna
   * @param design El design al que se agregara el elemento (tiene el width)
   * @param columns Cantidad de columnas (cantidad de elementos que se agregaran seguidos en la misma linea)
   * @param columnNumber
   * @return
   */
  private int getLabelPosX(JasperDesign design, int columns, int columnNumber) {
    int width = getTitleLabelsWidth(design, columns);
    return (columnNumber - 1)* width;
  }

  /**
   * Retorna el valor de la posicion Y donde se ubicara el elemento en el design.
   * @param band La banda donde estara el elemento
   * @param rows La cantidad de elementos que habrá uno sobre otro (como en filas)
   * @param pos La posicion o numero de fila. Para la primera es uno.
   * @return
   */
  private int getLabelPosY(JRDesignBand band, int rows, int pos){
    int height = getLabelHeightFromBand(band, rows);
    return ((pos - 1) * height) + ((pos - 1) * (height / rows));
  }

  private JRDesignElement getZoneUserLabel(JasperDesign design, JRDesignBand titleBand) {
    JRDesignTextField field = new JRDesignTextField();
    field.setX(FIRSTCOLUMN_LABELS_X);
    field.setY(getLabelPosY(titleBand, headerRows, 3));
    field.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    field.setWidth(getTitleLabelsWidth(design, headerColumns));
    field.setFont(getLabelFont(field.getHeight()));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{"+ zoneuserParam +"}");
    field.setExpression(expression);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_LEFT);
    return field;
  }

  private int getTitleLabelsWidth(JasperDesign design, int columns) {
    return getPrintWidth(design) / columns;
  }

  private JRDesignElement getCountryZoneLabel(JasperDesign design, JRDesignBand titleBand) {
    JRDesignTextField field = new JRDesignTextField();
    field.setX(FIRSTCOLUMN_LABELS_X);
    field.setY(getLabelPosY(titleBand, headerRows, 2));
    field.setHeight(getLabelHeightFromBand(titleBand, headerRows));
    field.setWidth(getTitleLabelsWidth(design, headerColumns));
    field.setFont(getLabelFont(field.getHeight()));
    field.setBlankWhenNull(true);
    JRDesignExpression expression = new JRDesignExpression();
    expression.setValueClass(java.lang.String.class);
    expression.setText("$P{"+ countryParam +"}");
    field.setExpression(expression);
    field.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_LEFT);
    return field;
  }

  private JRDesignElement getBelcorpLabel(JasperDesign design, JRDesignBand band) {
    JRDesignStaticText staticText = new JRDesignStaticText();
    staticText.setX(FIRSTCOLUMN_LABELS_X);
    staticText.setY(FIRST_ROW_LABELS_Y);
    staticText.setHeight(getLabelHeightFromBand(band, headerRows));
    staticText.setWidth(getTitleLabelsWidth(design, headerColumns));
    staticText.setFont(getLabelFont(staticText.getHeight()));
    staticText.setText("BELCORP");
    staticText.setTextAlignment(JRTextElement.HORIZONTAL_ALIGN_LEFT);
    return staticText;
  }

  private JRFont getLabelFont(int height) {
    JRDesignFont font = new JRDesignFont();
    font.setFontName("Courier New");
    font.setSize(getFontSize(height));
    return font;
  }

  private int getFontSize(int labalHeight) {
    if(labalHeight < 13){
      return labalHeight - 4;
    }else if(labalHeight < 18){
      return labalHeight - 5;
    }else{
      return 12;
    }
  }

  /*private int getBelcorpLabelWidth(JRDesignBand band) {
    return
  }*/

  private int getLabelHeightFromBand(JRDesignBand band, int labels) {
    return (band.getHeight() / labels + 1);
  }

  private void addElements(JRBand fromBand, JRDesignBand toBand) {
    JRElement[] elements = fromBand.getElements();
    for (int i = 0; i < elements.length; i++) {
      JRElement element = elements[i];
      toBand.addElement((JRDesignElement)element);
    }
  }

  private int getPrintWidth(JasperDesign design){
    return (design.getPageWidth() - design.getLeftMargin() - design.getRightMargin());
  }

  private JRDesignRectangle getBandRectangle(JasperDesign design, JRBand band) {
    JRDesignRectangle rectangle = new JRDesignRectangle();
    int width = getPrintWidth(design);
    rectangle.setX(0);
    rectangle.setY(0);
    rectangle.setHeight(band.getHeight());
    rectangle.setWidth(width);
    rectangle.setPen(JRGraphicElement.PEN_2_POINT);
    rectangle.setStretchType(JRGraphicElement.STRETCH_TYPE_RELATIVE_TO_BAND_HEIGHT);
    rectangle.setMode(JRGraphicElement.MODE_TRANSPARENT);
    return rectangle;
  }

  private JRDesignLine getColumnLineBand(JasperDesign design, JRBand band) {
    JRDesignLine line = new JRDesignLine();
    int width = getPrintWidth(design);
    line.setX(0);
    line.setY(50);
    line.setHeight(1);
    line.setWidth(width);
    line.setPen(JRGraphicElement.PEN_2_POINT);
    //line.setStretchType(JRGraphicElement.STRETCH_TYPE_RELATIVE_TO_BAND_HEIGHT);
    line.setMode(JRGraphicElement.MODE_TRANSPARENT);
    return line;
  }


  public static void setParams(HashMap parameters)
  {
    params = parameters;
  }


  public static HashMap getParams(){
    if(params==null)
    {
      params = new HashMap();
    }
    return params;
  }
  

}
