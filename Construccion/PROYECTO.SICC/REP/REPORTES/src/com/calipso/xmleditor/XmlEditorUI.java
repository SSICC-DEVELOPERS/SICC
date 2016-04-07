package com.calipso.xmleditor;

import com.calipso.reportgenerator.reportcalculator.Entry;
import jasperdesign.XMLWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.tree.DefaultTreeModel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.ParameterValue;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import com.calipso.reportgenerator.common.*;
import com.calipso.reportgenerator.client.ReportManagerService;
import com.calipso.reportgenerator.userinterface.ExtensionFilter;
import com.calipso.reportgenerator.userinterface.ShowExceptionMessageDialog;
import com.calipso.reportgenerator.enterprise.common.MAREInfo;
import com.calipso.reportgenerator.enterprise.common.MAREInfoBean;
import es.indra.mare.common.info.InfoException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.rep.dtos.DTOReporte;
import dori.jasper.engine.design.JRDesignParameter;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 24-sep-2003
 * Time: 17:42:50
 * To change this template use Options | File Templates.
 */

public class XmlEditorUI extends JFrame implements ActionListener{

  private JButton btAddNode;
  private JButton btDeleteNode;
  private JButton btFinish;
  private XmlEditorPanel pnlXmlEditor;
  private XmlEditorLoader xmlLoader;
  private JPanel pnlCenter;
  private XmlEditorConnectionPane connectionPane;
  private IReportManager reportManager = null;
  private String configPath = null;
  private ReportGeneratorConfiguration reportGeneratorConfiguration;
  private String reportDefinitionXsdPath;
  private String reportSourceDefinitionXsdPath;
  private String reportViewXsdPath;
  private XmlEditorMenu menuBar;
  private XmlEditorCache xmlCache;
  private static final String defaultErrorMsgTitle = "Error";
  private File currentXmlFile;
  private File currentXsdFile;
  private static Log logger;
  private HashMap constant;
  private HashMap constantValues;
  private int index=0;
  private MAREInfoBean mareInfoBean;

  public File getCurrentXsdFile() {
    return currentXsdFile;
  }

  public void setCurrentXsdFile(File currentXsdFile) {
    setCurrentXmlFile(null);
    this.currentXsdFile = currentXsdFile;
  }

  /**
   * Inicializa la aplicacion y muestra el panel principal
   * @param path
   * @param args
   */
  public XmlEditorUI(String path, String args[]) {
    this.configPath = path;
    try{
     // System.out.println("Init");
      getLogger().info(new String("Init"));
      try{
        reportGeneratorConfiguration = new ReportGeneratorConfiguration(ReportGeneratorConfiguration.getConfiguration(path));;
      }catch (Exception e1){
        JOptionPane.showMessageDialog(null, e1, "Init error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
      Image icon = getReportGeneratorConfiguration().getImage("ICON");
      if(icon != null) {
        setIconImage(icon);
      }
      initializePaths();
      if (!VersionProperties.getDateValid()){
        XmlEditorException exception  = new XmlEditorException("Ha vencido la vigencia de ejecución la aplicación");
        showException(exception);
        System.exit(1);
      }
    }catch (InfoException e){
      showException(new XmlEditorException(e));
    }
    initialize();
    try {
      if ((args!= null) && (args.length>0) && (args[0] != null)&&(args[0] != "")) {
        loadFromXml(true,args[0].toString());
      }
    }catch (Exception ee){
       ee.printStackTrace();
    }
  }



  private ReportGeneratorConfiguration getConfiguration(String path)throws InfoException {
    if (path !="")
    {
      return new ReportGeneratorConfiguration(ReportGeneratorConfiguration.getConfiguration(path));    
    }else {
      String configurationPath = System.getProperty("MareConfigurationRoot")+"/reportes/ReportGeneratorConfiguration.properties";
      return new ReportGeneratorConfiguration(ReportGeneratorConfiguration.getConfiguration(configurationPath));          
    } 
    
  };
  
  /**
   * Inicializa los path de los Xsd de los reportes segun los datos del reportGeneratorConfiguration
   */
  private void initializePaths() {
    reportDefinitionXsdPath = reportGeneratorConfiguration.getSourceReportSchemasPath() + "/" + "ReportDefinition.xsd";
    reportSourceDefinitionXsdPath = reportGeneratorConfiguration.getSourceReportSchemasPath() + "/" + "ReportSourceDefinition.xsd";
    reportViewXsdPath = reportGeneratorConfiguration.getSourceReportSchemasPath() + "/" + "ReportView.xsd";
  }

  private JMenuBar getMnuBar() {
    if(menuBar==null){
      menuBar = new XmlEditorMenu(this);
    }
    return menuBar;
  }

  /**
   * Inicializa los paneles
   */
  private void initialize() {
    setTitle();
    LanguageTraslator.newLocaleFrom(reportGeneratorConfiguration.getLocaleLanguage(),reportGeneratorConfiguration.getCountry(),reportGeneratorConfiguration.getLanguagesPath());
    getContentPane().setLayout(new BorderLayout());
    setJMenuBar(getMnuBar());
    getContentPane().add(getCenterPanel(), BorderLayout.CENTER);
    getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
    addWindowListener(new Win());
  }

  private Component getSouthPanel() {
    JPanel panel = new JPanel();
    GridBagLayout bagLayout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    panel.setLayout(bagLayout);

    btAddNode = new JButton("Agregar Nodo");
    btAddNode.addActionListener(this);
    panel.add(btAddNode);
    constraints.weightx = 30;
    constraints.weighty = 1;
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.anchor = GridBagConstraints.EAST;
    constraints.fill = GridBagConstraints.PAGE_START;
    bagLayout.setConstraints(btAddNode, constraints);

    btDeleteNode = new JButton("Borrar Nodo");
    btDeleteNode.addActionListener(this);
    panel.add(btDeleteNode);
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.gridx = 1;
    constraints.gridy = 0;
    constraints.anchor = GridBagConstraints.EAST;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    bagLayout.setConstraints(btDeleteNode, constraints);

    btFinish = new JButton("Finalizar");
    btFinish.addActionListener(this);
    panel.add(btFinish);
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.gridx = 2;
    constraints.gridy = 0;
    constraints.anchor = GridBagConstraints.WEST;
    constraints.fill = GridBagConstraints.VERTICAL;
    bagLayout.setConstraints(btDeleteNode, constraints);

    return panel;
  }

  /**
   * Obtiene el panel central vacio
   * @return
   */
  private Component getCenterPanel() {
    pnlCenter = new JPanel(new GridLayout(1, 1));
    return pnlCenter;
  }

  /**
   * Resetea el panel principal con una cierta definicion
   * @param definition
   */
  protected void updateUIFrom(XmlEditorTreeDefinition definition) {
    try{
      pnlCenter.removeAll();
      pnlXmlEditor = new XmlEditorPanel(definition.getRootDefinition());
      pnlCenter.add(pnlXmlEditor);
      pnlCenter.validate();
    }catch (XmlEditorException e){
      showException(e);
    }
  }

  public void actionPerformed(ActionEvent e) {
    if(pnlXmlEditor!=null){
      if(e.getSource() == btAddNode) {
        if (currentXsdFile==null){
            JOptionPane.showMessageDialog(this, "No se puede agregar nodo si no está cargado el XSD");
        } else{
          pnlXmlEditor.addNode();
        }
      } else if(e.getSource() == btDeleteNode) {
        pnlXmlEditor.deleteNode();
      } else if(e.getSource() == btFinish) {
        int result = JOptionPane.showConfirmDialog(this, "Desea guardar el archivo?", "Salir",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result==JOptionPane.YES_OPTION){
          save(true);
        }
        System.exit(0);
      }
    }else{
      if(e.getSource() == btFinish){
        System.exit(0);
      }else{
        showException(new XmlEditorException("Aun no se ha cargado un Xml"));
      }
    }
  }

  public File getCurrentXmlFile() {
    return currentXmlFile;
  }

  public void setCurrentXmlFile(File currentXmlFile) {
    this.currentXmlFile = currentXmlFile;
  }

  /**
   * Abre un Xml o Xsd que estaba en la lista de los utilizados recientemente
   * @param name: nombre del archivo a abrir
   */
  protected void openRecent(String name) {
    try{
      File file = new File(name);
      if(name.substring(name.lastIndexOf(".")+1).equalsIgnoreCase("xsd")){
        loadTreeFromFile(name);
        setCurrentXsdFile(file);
      }else{
        if(currentXmlFile!=null){
          int result = JOptionPane.showConfirmDialog(this, "Desea guardar el archivo?", "Salir",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if(result==JOptionPane.YES_OPTION){
            save(true);
          }
        }
        if(file.getName().startsWith(XmlEditorDefaultReports.defaultDefinitionTag)){
          loadXmlFromSchema(reportDefinitionXsdPath, file);
        }else if(file.getName().startsWith(XmlEditorDefaultReports.defaultSourceTag)){
          loadXmlFromSchema(reportSourceDefinitionXsdPath, file);
        }else{
          loadXml(file);
        }
        setCurrentXmlFile(file);
      }
      setTitle();
    }catch (XmlEditorException e){
      showException(e);
    }
  }

  /**
   * Hace un ERROR_MESSAGE con la exception, para mostrar en pantalla con un cuadro generico
   * @param e
   */
  public void showException(XmlEditorException e) {
    //e.printStackTrace();
    ShowExceptionMessageDialog.initExceptionDialogMessage("Error: XmlEditorException", e);
  }

  /**
   * Busca un nodo particular del arbol, con el atributo UserObject (valor) correspondiente al parametro nodeName
   * @param children: enumeracion de children de un nodo
   * @param nodeName: nombre a buscar
   * @param found
   * @return
   */
  private XmlEditorTreeModelNode getModelNodeFrom(Enumeration children, String nodeName, boolean found) {
    XmlEditorTreeModelNode returnVal = null;
    while(children.hasMoreElements() && !found) {
      XmlEditorTreeModelNode current = (XmlEditorTreeModelNode) children.nextElement();
      if(current.getUserObject().equals(nodeName)) {
        return current;
      } else {
        returnVal = getModelNodeFrom(current.children(), nodeName, found);
        if(returnVal != null) {
          found = true;
        }
      }
    }
    return returnVal;
  }//Todo: metodo repetido en XmlEditorLoader. Reparar el error arquitectonico.

  /**
   * Genera un report layout a partir de un Report Definition cargado actualmente en el modelo
   */
  protected void generateReportLayout() {
    XmlEditorTreeModelNode node = (XmlEditorTreeModelNode)pnlXmlEditor.getTreeModel().getRoot();
    String reportType = node.getUserObject().toString();
    if(reportType.equalsIgnoreCase("ReportDefinition") || reportType.equalsIgnoreCase("ReportView")){
      XmlEditorTreeModelNode current = getModelNodeFrom(node.children(), reportType, false);
      if(current==null){
        current = (XmlEditorTreeModelNode)node.children().nextElement();
      }
      int result = JOptionPane.showConfirmDialog(this, "Es necesario guardar el archivo para continuar","Guardar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
      if(result == JOptionPane.YES_OPTION){
        try{
          Map attrs = getXmlLayoutProperties(current, reportType);
          //String title = current.getAttributes().elementAt(titlePos).toString();
          //String layoutName = XmlEditorDefaultReports.getLayoutId(title) + ".xml";
          String layoutName = XmlEditorDefaultReports.getLayoutId((String)attrs.get("ReportId"));
          if(((Integer)attrs.get("LayoutPos")).intValue() > 0){
            current.getAttributes().set(((Integer)attrs.get("LayoutPos")).intValue(), layoutName);
          }else{
            showException(new XmlEditorException("No existe tag para el Layout"));
          }
          XmlEditorXmlGenerator.generateFrom(pnlXmlEditor.getTreeModel(), getCurrentXmlFile().getAbsolutePath());
          getReportManager().registerDefinitions();
          ReportResult reportResult = getReportResultFromCurrent(reportType, attrs.get("ReportDefinitionId").toString(), getCurrentXmlFile().getAbsolutePath());
          writeReportLayout(reportResult, attrs.get("ReportId").toString(), attrs.get("ReportDefinitionId").toString());
          JOptionPane.showMessageDialog(this, "Se guardo el layout satisfactoriamente");
        }catch (Exception e){
          showException(new XmlEditorException("Error generando el ReportLayout",e));
        }
      }
    }else{
      showException(new XmlEditorException("No es ni ReporDefinition ni ReportView, no se puede crear ReportLayout"));
    }
  }

  private ReportResult getReportResultFromCurrent(String reportType, String reportDefinitionId, String viewFileName) throws XmlEditorException{
    ReportResult result = null;
    try{
      ReportDefinition definition = getReportManager().getReportDefinitionFromID(reportDefinitionId);
      if(reportType.equalsIgnoreCase("ReportDefinition")){
        if(definition.getReportType()!=ReportDefinitionReportTypeType.STATICSQL){
          Map params = null;
          if(params==null){
            params = new HashMap();
          }
          result = getReportManager().ExecReportQuery(reportDefinitionId, params);
        }
      }else{
        if(definition.getReportType()!=ReportDefinitionReportTypeType.STATICSQL){
          int reportHandle = getReportManager().PrepareReport(reportDefinitionId);
          ReportView view = ReportView.unmarshal(new FileReader(viewFileName));
          result = getReportManager().ExecReportQuery(reportHandle, view);
        }
      }
    }catch (Exception e){
      throw new XmlEditorException(e);
    }
    return result;
  }

  private Map getXmlLayoutProperties(XmlEditorTreeModelNode current, String reportType) throws XmlEditorException {
    Map result = new HashMap();
    int titlePos = -1;
    int layoutPos = -1;
    if(reportType.equalsIgnoreCase("ReportDefinition")){
      layoutPos = current.getAttributeNames().indexOf("LayoutDesign");
      result.put("LayoutPos", new Integer(layoutPos));
      titlePos = current.getAttributeNames().indexOf("Title");
      String reportId = current.getId();
      result.put("ReportId", reportId);
      result.put("ReportDefinitionId", reportId);
    }else if(reportType.equalsIgnoreCase("ReportView")){
      layoutPos = current.getAttributeNames().indexOf("ReportLayout");
      result.put("LayoutPos", new Integer(layoutPos));
      titlePos = current.getAttributeNames().indexOf("Description");
      result.put("ReportId", current.getId());
      int reportDefinitionIdPos = current.getAttributeNames().indexOf("ReportDefinitionId");
      result.put("ReportDefinitionId", current.getAttributes().elementAt(reportDefinitionIdPos));
    }
    try{
      result.put("LayoutName", current.getAttributes().elementAt(layoutPos));
    }catch (Exception e){
      throw new XmlEditorException("No existe tag para el layout");
    }
    result.put("Title", current.getAttributes().elementAt(titlePos));
    return result;
  }

  /**
   * Muestra el connectionPane donde deberan setearse los valores para armar el reporte generico desde SQL.
   * Este retornara el control via "createReportDefinitionsFromSql()" y ya tendra los datos necesarios para establecer la
   * conexion y generar los reportes.
   */
  public void getParametersFromPane() {
    XmlEditorConnectionPane connectionPane = getConnectionPane();
    connectionPane.show();
    if(!connectionPane.isCancelled()){
      createReportDefinitionsFromSql(connectionPane.getReportName(), connectionPane.getClassName(), connectionPane.getLocalUrl(),
              connectionPane.getUser(), String.valueOf(connectionPane.getPassword()), connectionPane.getSqlText(),
              connectionPane.getMetricStartPosition());
    }
  }

  private XmlEditorConnectionPane getConnectionPane() {
    if(connectionPane==null){
      connectionPane = new XmlEditorConnectionPane(this, true, reportGeneratorConfiguration.getValues());
    }
    return connectionPane;
  }

  /**
   * Carga el arbol de un schema dado y actualiza los paneles
   * @param schema: path del esquema a cargar
   * @throws XmlEditorException
   */
  private void loadTreeFromFile(String schema) throws XmlEditorException{
    XmlEditorTreeDefinition definition = new XmlEditorTreeDefinition(schema);
    updateUIFrom(definition);
  }

  /**
   * Carga un Xsd al modelo (vacio)
   */
  protected void loadFromXsd() {
    try{
      JFileChooser fileChooser = getFileChooser("xsd", "Schema");
      int result = fileChooser.showOpenDialog(this);
      if(result == JFileChooser.APPROVE_OPTION) {
        String schemaLocation = fileChooser.getSelectedFile().getPath();
        menuBar.addXsdRecentItem(schemaLocation);
        loadTreeFromFile(schemaLocation);
        pnlXmlEditor.setOnlyXsd(true);
        setCurrentXsdFile(fileChooser.getSelectedFile());
        setTitle();
      }
    }catch (XmlEditorException e){
      showException(e);
    }
  }

  /**
   * Obtiene un JFileChooser, especificandole un tipo de extension unico a filtrar en el dialogo
   * @param extension: extension unica que se mostrara (ej: ".xsd")
   * @param description: descripcion para esa extension (ej: "Schema")
   * @return
   */
  private JFileChooser getFileChooser(String extension, String description){
    JFileChooser fileChooser;
    if (extension == "xml"){
      fileChooser = new JFileChooser(getReportGeneratorConfiguration().getSourceReportDefinitionsPath());
    } else if (extension=="xsd"){
      fileChooser = new JFileChooser(getReportGeneratorConfiguration().getSourceReportSchemasPath());
    } else{
      fileChooser = new JFileChooser(".");
    }
    fileChooser.setMultiSelectionEnabled(false);
    fileChooser.setFileFilter(new ExtensionFilter(extension, description));
    return fileChooser;
  }

  /**
   * Carga a los paneles un Xml si previamente existia un Xsd. Corrobora los valores contra esa
   * definicion
   * @param schemaPath
   * @param file
   * @throws XmlEditorException
   */
  private void loadXmlFromSchema(String schemaPath, File file) throws XmlEditorException{
    loadTreeFromFile(schemaPath);
    xmlLoader = new XmlEditorLoader(pnlXmlEditor.getTreeModel(), pnlXmlEditor.getNodeDefinition());
    DefaultTreeModel newModel = xmlLoader.loadFrom(file, true);
    pnlXmlEditor.getTree().setModel(newModel);
    pnlXmlEditor.getTree().repaint();
    pnlXmlEditor.setOnlyXsd(false);
  }

  /**
   * Carga un Xml sin xsd
   * @param file
   */
  private void loadXml(File file){
    try{
      xmlLoader = new XmlEditorLoader();
      DefaultTreeModel newModel = xmlLoader.loadFrom(file, false);
      updateXmlPanelFrom(newModel, xmlLoader.getDomRoot());
      setCurrentXmlFile(file);
    }catch (XmlEditorException e){
      showException(e);
    }
  }

  /**
   * Carga un Xml. Puede tener o no xsd (debera estar cargado en el modelo antes de llegar aqui).
   * El usuario seleccionara el archivo
   * @param justXml
   */
  protected void loadFromXml(boolean justXml, String fileName) {
    File file = null;
    try{
      if (fileName.equals("")) {
        JFileChooser fileChooser = getFileChooser("xml", "Xml file");
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
          file = fileChooser.getSelectedFile();
        }
      } else {
        file = new File(fileName);
      }
      if (file != null) {
        menuBar.addXmlRecentItem(file.getAbsolutePath());
        if(!justXml) {
          unloadCurrentXmlFromXsd();
          if(pnlXmlEditor==null){
            throw new XmlEditorException("Aun no se cargo el Xsd");
          }
          xmlLoader = new XmlEditorLoader(pnlXmlEditor.getTreeModel(), pnlXmlEditor.getNodeDefinition());
          DefaultTreeModel newModel = xmlLoader.loadFrom(file, true);
          pnlXmlEditor.getTree().setModel(newModel);
          pnlXmlEditor.getTree().repaint();
          pnlXmlEditor.setOnlyXsd(false);
        } else {
          loadXml(file);
          setCurrentXsdFile(null);
        }
        setCurrentXmlFile(file);
        setTitle();
      }
    }catch (XmlEditorException e){
      showException(e);
    }
  }

  /**
   * Remueve un arbol de una definicion xml, dejando el arbol del xsd que lo produjo.
   * Para ello, remueve toda la estructura y vuelve a cargar solo el xsd.
   * @throws XmlEditorException
   */
  private void unloadCurrentXmlFromXsd() throws XmlEditorException{
    File currentXsdFile = getCurrentXsdFile();
    unLoadxsd();
    loadTreeFromFile(currentXsdFile.getAbsolutePath());
    setCurrentXsdFile(currentXsdFile);
  }

  /**
   * Colapsa todos los nodos del arbol actual.
   */
  private void collapseAllNodes() {
    pnlXmlEditor.collapseAllNodes();
  }

  /**
   * Actualiza el panel Xml
   * @param newModel
   * @param domRoot
   */
  private void updateXmlPanelFrom(DefaultTreeModel newModel, Node domRoot) {
    if(pnlXmlEditor != null) {
      pnlXmlEditor.removeAll();
    }
    pnlCenter.removeAll();
    pnlXmlEditor = new XmlEditorPanel(newModel, domRoot);
    pnlCenter.add(pnlXmlEditor);
    pnlCenter.validate();
  }

  /**
   * Setea desde el connectionPane los parametros para establecer la conexcion SQL. Ejecuta el texto SQL ingresado, y obtiene
   * nombres de columnas y tipos de datos para generar los reportes. LLama a writereports, que se encarga de escribir los
   * reportes a disco.
   * @param reportName
   * @param className
   * @param localUrl
   * @param user
   * @param password
   * @param sql
   * @param metricsStart
   */
  public void createReportDefinitionsFromSql(String reportName, String className, String localUrl, String user,
                                             String password, String sql, int metricsStart){
    try{
      connectionPane.hide();
      Class.forName(className);
      getLogger().info(new String("Obteniendo los datos de las columnas"));
    //  System.out.print("Obteniendo los datos de las columnas");
      Connection con = DriverManager.getConnection(localUrl, user, password);
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData meta = rs.getMetaData();
      getLogger().info(new String("Generando las definiciones por defecto"));
     // System.out.println("Generando las definiciones por defecto");
      writeReports(reportName, getColumnsMap(meta, metricsStart, false), getColumnsMap(meta, metricsStart, true), sql, className, localUrl, user, password);
      File xmlFile = new File(reportGeneratorConfiguration.getSourceReportDefinitionsPath() + "/" + XmlEditorDefaultReports.getReportId(reportName) + ".xml");
      setCurrentXmlFile(xmlFile);
      loadXmlFromSchema(reportDefinitionXsdPath, xmlFile);
      setTitle();
    }catch (Exception e){
      showException(new XmlEditorException(e));
    }
  }

  /**
   * Obtiene de los metadatos de un ResultSet un mapa con el nombre de las dimensiones o metricas
   * (segun lo especifique getMetrics). Para ello requiere la posicion de inicio de las metricas en
   * la query.
   * @param meta: meta datos del ResultSet de la query ejecutada.
   * @param metricsStart: posicion donde inician las metricas
   * @param getMetrics: si estamos obteniendo las metricas o las dimensiones
   * @return
   */
  private Vector getColumnsMap(ResultSetMetaData meta, int metricsStart, boolean getMetrics) {
    Vector result = new Vector();
    int cantidad = 0;
    try{
      cantidad = meta.getColumnCount();
      int hasta = getMetrics ? cantidad : metricsStart - 1;
      int desde = getMetrics ? metricsStart : 1;
      for (int i=desde; i <= hasta; i++) {
     //   System.out.println(meta.getColumnName(i));
        result.add(new Entry(meta.getColumnName(i),new Integer(meta.getColumnType(i))));
      }
    }catch (Exception e){
      showException(new XmlEditorException(e));
    }
    return result;
  }

  /**
   * Con los datos obtenidos de la query genera los archivos XML que seran la especificacion del reporte.
   * @param reportName
   * @param dimensionMap
   * @param metricMap
   * @param query
   * @param className
   * @param localUrl
   * @param user
   * @param password
   */
  private void writeReports(String reportName, Vector dimensionMap, Vector metricMap, String query, String className, String localUrl, String user, String password) {
    getLogger().info(new String("Obteniendo el report definition"));
  //  System.out.println("Obteniendo el report definition");
    String reportPath = writeReportDefinition(reportName, dimensionMap, metricMap);
    //System.out.println("reportName:"+reportName+"dimensionMap: "+dimensionMap.size()+ "tostring:"+dimensionMap.toString()+"metricMap:"+metricMap.toString());
    menuBar.addXmlRecentItem(reportPath);
    getLogger().info(new String("Obteniendo el report source definition"));
   // System.out.println("Obteniendo el report source definition");
    reportPath = writeReportSourceDefinition(reportName, dimensionMap, metricMap, query, className, localUrl, user, password);
    menuBar.addXmlRecentItem(reportPath);
  }

  /**
   * Escribe a disco un XML con una definicion de Layout para ver el Reporte (especificado por los parametros)
   * @param reportName
   * @param definitionId
   * @return
   * @throws XmlEditorException
   */
  private String writeReportLayout(ReportResult result,String reportName, String definitionId) throws XmlEditorException{
    String layoutName = "";
    try{
      ReportDefinition definition = getReportManager().getReportDefinitionFromID(definitionId);
      ReportSpec reportSpec = getReportManager().getReportSpec(definitionId);
      ReportLayoutBuilder builder = new ReportLayoutBuilder(getReportGeneratorConfiguration(), result, reportSpec);
      /*int reportHandle = getReportManager().PrepareReport(definitionId);
      ReportResult result = getReportManager().ExecReportQuery(reportHandle, reportView);*/
      //ReportLayoutBuilder builder = new ReportLayoutBuilder(getReportGeneratorConfiguration(), result, result.getReportSpec());
      //IJasperDefinition jasper = builder.getJasperDefinition();
      IJasperDefinition jasper = builder.buildDefaulJasperDefinition();
      jasper = addStyle(jasper);
      //IJasperDefinition jasper = getJasperDefinition(result);
      if(reportName.equalsIgnoreCase("")){
        reportName = definition.getTitle() != null ? definition.getTitle() : definitionId;
      }
      layoutName = XmlEditorDefaultReports.getLayoutId(reportName) + ".xml";
      new XMLWriter(jasper.getJasperDefinition(true)).saveDocument(reportGeneratorConfiguration.getSourceReportLayoutPath() + "/" + layoutName);
    }catch (Exception e){
      throw new XmlEditorException(e);
    }
    return layoutName;
  }

  private IJasperDefinition getJasperDefinition(ReportResult result) throws XmlEditorException {
    IJasperDefinition jasperDefinition = null;
    int groupingDimensionCount = result.getReportTableModel().getGroupingDimCount();
    int nonGroupingDimensionCount = result.getReportTableModel().getNonGroupingDimCount();
    int accumMetricCount = result.getReportTableModel().getAccMetricsCount();
    int metricCount = result.getReportTableModel().getCommonMetricsCount();
    if(result.getReportSpec().getReportType().getType() == ReportDefinitionReportTypeType.CUBE_TYPE){
      jasperDefinition = new CubeJasperReportDefinition(result, result.getReportTableModel().getModel(), groupingDimensionCount, metricCount, nonGroupingDimensionCount, accumMetricCount, result.getReportSpec().getTitle());
    }else if (result.getReportSpec().getReportType().getType() == ReportDefinitionReportTypeType.ACCUM_TYPE){
      jasperDefinition = new StaticJasperReportDefinition(result, result.getReportTableModel().getModel(), groupingDimensionCount, metricCount, nonGroupingDimensionCount, accumMetricCount, result.getReportSpec().getTitle());
    }else if (result.getReportSpec().getReportType().getType() == ReportDefinitionReportTypeType.STATICSQL_TYPE){
      throw new XmlEditorException("No esta soportada la generacion automatica de layout para STATICSQL");
      /*com.calipso.reportgenerator.common.ReportTableModel model = new StaticReportTableModel(result.getReportSpec(), result.getReportQuery());
      jasperDefinition = new StaticSQLJasperReportDefinition(result.getReportSpec(), model.getModel(), model.getGroupingDimCount(), model.getCommonMetricsCount(),
              model.getNonGroupingDimCount(), model.getAccMetricsCount(), result.getReportSpec().getTitle());*/
    }
    jasperDefinition = addStyle(jasperDefinition);
    return jasperDefinition;
  }

  private IJasperDefinition addStyle(IJasperDefinition design) {
    String style = reportGeneratorConfiguration.getReportLayoutStyle();
    if(style==null || style.equalsIgnoreCase("")){
      return design;
    }else if(style.equalsIgnoreCase("Belcorp")){
      return new BelcorpDecoratedReportLayout(design);
    }
    return design;
  }

  public IReportManager getReportManager() {
    if (reportManager == null) {
      try {
        reportManager = ReportManagerService.getReportManagerService("",null);
      }
      catch (Exception e) {
        showException(new XmlEditorException(e));
        System.exit(3);
      }
    }
    return reportManager;
  }

  /**
   * Genera en base a los datos obtenidos una ReportSourceDefinition estandar.
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
  private String writeReportSourceDefinition(String reportName, Vector dimensionMap, Vector metricMap, String query, String className, String localUrl, String user, String password) {
    ReportSourceDefinition report = XmlEditorDefaultReports.getReportSourceDefinition(reportName, dimensionMap, metricMap, query, className, localUrl, user, password);
    String fullPath = reportGeneratorConfiguration.getSourceReportSourceDefinitionsPath() + "/" + XmlEditorDefaultReports.getSourceId(reportName) + ".xml";
    try{
      getLogger().info(new String("Grabando el report source definition"));
     // System.out.println("Grabando el report source definition");
      Writer wr = new FileWriter(fullPath);
      report.marshal(wr);
      wr.flush();
      wr.close();
    }catch (Exception e){
      showException(new XmlEditorException(e));
//      e.printStackTrace();
    }
    return fullPath;
  }

  /**
   * Genera en base a los datos obtenidos una ReportDefinition estandar.
   * @param reportName
   * @param dimensionMap
   * @param metricMap
   * @return
   */
  private String writeReportDefinition(String reportName, Vector dimensionMap, Vector metricMap) {
    ReportDefinition report = XmlEditorDefaultReports.getReportDefinition(reportGeneratorConfiguration, reportName, dimensionMap, metricMap);
   // System.out.println("report.toString():"+report.toString());
   // System.out.println("report.toString():"+report.getDimensionDefinitions().getDimensionDefinition().length+":"+ report.getDimensionDefinitions().enumerateDimensionDefinition().toString());
    String fullPath = reportGeneratorConfiguration.getSourceReportDefinitionsPath() + "/" + XmlEditorDefaultReports.getReportId(reportName) + ".xml";
    try{
      getLogger().info(new String("Grabando el report definition"));
     // System.out.println("Grabando el report definition");
      Writer wr = new FileWriter(fullPath);
      report.marshal(wr);
      wr.flush();
      wr.close();
    }catch (Exception e){
      e.printStackTrace();
      showException(new XmlEditorException(e));
    }
    return fullPath;
  }

  /**
   * Guarda el arbol visualizado actualmente a disco. El usuario selecciona el archivo destino.
   */
  public void save(boolean overrideFile) {
    try{
      pnlXmlEditor.valueChanged();
      if(pnlXmlEditor!= null){
        if ((getCurrentXmlFile() == null)||((!overrideFile)&&(getCurrentXmlFile() != null))){
          JFileChooser fileChooser = getFileChooser("xml", "Xml file");
          int result = fileChooser.showSaveDialog(this);
          if(result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XmlEditorXmlGenerator.generateFrom(pnlXmlEditor.getTreeModel(), file.getAbsolutePath());
            menuBar.addXmlRecentItem(file.getAbsolutePath());
          }
        }else{
          XmlEditorXmlGenerator.generateFrom(pnlXmlEditor.getTreeModel(), currentXmlFile.getAbsolutePath());
          menuBar.addXmlRecentItem(currentXmlFile.getAbsolutePath());
        }
      }
    }catch (XmlEditorException e){
      showException(e);
    }
  }


   public void checkReport(String type, String RDid){
       try {
           getReportManager().registerDefinitions();
       } catch (InfoException e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       }
       ReportDefinition reportDefinition = null;

       try {
           reportDefinition = getReportManager().getReportDefinitionFromID(RDid);
           if ( type.equalsIgnoreCase("EMPTY")){
             checkEmptyReport(reportDefinition,  RDid);
//               checkReport(reportDefinition,  RDid, true);

           }else if(type.equalsIgnoreCase("OBLIGATORY_ONLY")){
             checkReport(reportDefinition, RDid, true);
           }else{
             checkReport(reportDefinition, RDid, false);
           }


       } catch (Exception e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       }

   }

    public void checkAllReports() {
        try {
            getReportManager().registerDefinitions();
            Map definitionsMap = null;
            //Map.Entry entry;
            definitionsMap = getReportManager().getReportDefinitions();
            ReportDefinition reportDefinition;
            byte[] report;
            TreeMap infos = new TreeMap();
            if (definitionsMap != null){
              /*Nuevo*/
              FileOutputStream out = null;
              try{
                out = createAppender("Errores de ejecucion");
              } catch (Exception e) {
                e.printStackTrace();
              }
              List definitionList = new LinkedList(definitionsMap.keySet());
              Collections.sort(definitionList);
              //Iterator iterator =  definitionsMap.entrySet().iterator();
              Iterator iterator =  definitionList.iterator();
              String RDid;
              while (iterator.hasNext()) {
                //entry = (Map.Entry) iterator.next();
                String entry = (String) iterator.next();
                //RDid =   "RD_"+entry.getValue().toString();
                RDid =   entry;
                try {
                  reportDefinition = getReportManager().getReportDefinitionFromID(RDid);
                    try{
                      checkReport(reportDefinition,  RDid, true);
                    } catch (Exception e) {
                      logException(out, RDid , "Parametros obligatorios", e);
                      //infos.put(RDid+ "_Parametros obligatorios", e.toString());
                    }

                    try {
                      checkReport(reportDefinition,  RDid, false);
                    } catch (Exception e) {
                      logException(out, RDid , "Parametros no obligatorios", e);
                      //infos.put(RDid+ "_Parametros no obligatorios", e.toString());
                    }
                      try{
                        checkEmptyReport(reportDefinition,  RDid);
                      } catch (Exception e) {
                        logException(out, RDid , "Reporte vacío", e);
                        //infos.put(RDid+ "_Reporte vacío", e.toString());
                      }
                    //saveMap(infos,RDid+"_"+"Errores de ejecucion.txt" );
                      System.gc();
                 //   System.out.println();
                }catch(Exception e) {
                  logException(out, RDid , "No Encontrado", e);
                  //infos.put(RDid+ "_No Encontrado", e.toString());
                }
              }
              out.close();
            //saveMap(infos,"Errores de ejecucion.txt" );
            }

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
    }
    
    public void logException(FileOutputStream out, String id, String runType, Exception e){
      try{
        String line = id + "," + runType + "," + e.toString();
        out.write(line.getBytes());
        out.write(System.getProperty("line.separator").getBytes());
        out.flush();
      }catch (Exception e1){
        e.printStackTrace();
      }
    }
    
    
    public FileOutputStream createAppender(String fileName) throws Exception{
        FileOutputStream file = null;
        Date time = GregorianCalendar.getInstance().getTime();
        File f = new File(fileName + "_" + (new SimpleDateFormat("yyyyMMdd").format(time)) + ".csv");
        if(f.exists()){
          f.delete();
        }
        //FileOutputStream out = null;
        f.createNewFile();
        return new FileOutputStream(f);
    }

    public void checkReport(ReportDefinition reportDefinition, String RDid, boolean obligatoryOnly) throws MareException {
        HashMap params = new HashMap();
        byte[] report;
        params.put("ReportDefinitionId", RDid);
        putDefaultParams(params);
        addParams(reportDefinition,params,obligatoryOnly, false);
        DTOReporte dto = new DTOReporte();
        dto.setIdReporte(RDid);
        dto.setParametros(params);
        dto =  getMareInfoBean().ejecutarReporteOrig(dto);
        //report = getReportManager().exportReport(params);
        saveReport(dto.getResultados(),reportDefinition.getId(), false);
    }

    private MAREInfoBean getMareInfoBean() {
        if (mareInfoBean==null){
          mareInfoBean = new MAREInfoBean();
        }
        return mareInfoBean;  //To change body of created methods use File | Settings | File Templates.
    }

    private void checkEmptyReport(ReportDefinition reportDefinition, String RDid) throws MareException {
        HashMap params = new HashMap();
        byte[] report;
        params.put("ReportDefinitionId", RDid);
        putDefaultParams(params);
        addParams(reportDefinition,params,false, true);
        DTOReporte dto = new DTOReporte();
        dto.setIdReporte(RDid);
        dto.setParametros(params);
        dto =  getMareInfoBean().ejecutarReporteOrig(dto);
        //report = getReportManager().exportReport(params);
        saveReport(dto.getResultados(),reportDefinition.getId(), false);
    }


    public void saveReport(byte[] report, String reportName, boolean excel){
      FileOutputStream file;
      try {

          DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
          String  name = reportName + "_" + dateFormat.format(new Date()).toString();
          if (!excel){
            file = new FileOutputStream(name+".pdf");
          }else{
            file = new FileOutputStream(name+".xls");
          }
          file.write(report);
          file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addParams(ReportDefinition reportDefinition, Map params, boolean obligatoryOnly, boolean emptyReport) {
        try {
            ReportSourceDefinition reportSourceDefinition = getReportManager().getReportSourceDefinitionFromID(reportDefinition.getReportSource());
            Enumeration enumeration=  reportSourceDefinition.getParameterValues().enumerateParameterValue();
            String expression;
            ParameterValue parameterValue;
            ReportSpec reportSpec;
            ReportFilterSpec reportFilterSpec;
            String paramameter;
            while (enumeration.hasMoreElements()) {
                parameterValue = (ParameterValue)enumeration.nextElement();
                paramameter = (parameterValue.getFilterDefinitionName()+parameterValue.getFilterParameter());
                if(paramameter.equalsIgnoreCase("FORMATOFECHAVALUE")){
                  continue;
                }
                if (emptyReport) {
                    reportSpec = getReportManager().getReportSpec(reportDefinition.getId());
                    reportFilterSpec = reportSpec.getFilterSpecFromName(parameterValue.getFilterDefinitionName());
                    if ((reportFilterSpec.getDataType()==ReportDataType.FLOAT)||(reportFilterSpec.getDataType()==ReportDataType.INTEGER)||(reportFilterSpec.getDataType()==ReportDataType.STRING)){
                      if ( (paramameter.equalsIgnoreCase("IDIOMAVALUE"))|| (paramameter.indexOf("OPER")>-1)||
                           (paramameter.indexOf("ORDENA")>-1)||(paramameter.indexOf("MODALIDADMUESTRAVENTAS")>-1) ||
                            (paramameter.indexOf("HORADESDEVALUE")>-1)|| (paramameter.indexOf("HORAHASTAVALUE")>-1)) {
                          if(parameterValue.getDefaultValue().equalsIgnoreCase("NULL_VALUE")) {
                            params.put(paramameter,null);
                          }else{
                            params.put(paramameter,parameterValue.getDefaultValue());
                          }
                      } else{
                        /*if (reportFilterSpec.getDataType()==ReportDataType.INTEGER){
                          params.put(paramameter,"-1");
                        }else{*/
                          params.put(paramameter,"-1");
                        //}
                      }
                    }else if ((reportFilterSpec.getDataType()==ReportDataType.DATETIME)||((reportFilterSpec.getDataType()==ReportDataType.DATE))){
                        params.put(paramameter,"01/01/2001");
                    } else {
                      params.put(paramameter, parameterValue.getDefaultValue());
                    }
                } else {
                   //reportSpec = getReportManager().getReportSpec(reportDefinition.getId());
                   //reportFilterSpec = reportSpec.getFilterSpecFromName(parameterValue.getFilterDefinitionName());
                   if (parameterValue.getDefaultValue().equalsIgnoreCase("NULL_VALUE")){
                      if (!obligatoryOnly){
                          reportSpec = getReportManager().getReportSpec(reportDefinition.getId());
                          reportFilterSpec = reportSpec.getFilterSpecFromName(parameterValue.getFilterDefinitionName());
                          params.put(paramameter,getDefaultValueForParam(reportFilterSpec));
                      }
                    } else{
                      params.put(paramameter,parameterValue.getDefaultValue());
                    }
                }
            }
        } catch (InfoException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private Object getDefaultValueForParam(ReportFilterSpec reportFilterSpec) {
      if ((reportFilterSpec.getDataType()==ReportDataType.DATE)||((reportFilterSpec.getDataType()==ReportDataType.DATETIME))){
        return "01/01/2001";
      } else{
        return "1";
      }
    }

    private void putDefaultParams(Map param) {
        param.put(ConstantesREP.MODULO,"MOD");
        param.put(ConstantesREP.USUARIO, "USUARIO2");
        param.put(ConstantesREP.PAIS, new Long(1));
        param.put(ConstantesREP.DESCPAIS,"PERU");
        param.put(ConstantesREP.FORMATOFECHA, "dd/MM/yyyy");
        param.put(ConstantesREP.SEPARADORDECIMALES, ".");
        param.put(ConstantesREP.TITULO, "Título");
        param.put(ConstantesREP.IDIOMA, "1");
        param.put(ConstantesREP.CRITERIOSDESC, "criterios de seleccion");
    }


    class Win extends WindowAdapter {
    public void windowClosing( WindowEvent event ) {
      System.exit(0);
    }
  }

  public void setTitle(){
    String title="Calipso XML Editor";
    if (currentXsdFile!=null){
      title = title + " - XSD : "+currentXsdFile.getName();
    }
    if (currentXmlFile!=null){
      title = title + " - XML : "+currentXmlFile.getName();
    }
    setTitle(title);
  }

  public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
    return reportGeneratorConfiguration;
  }

  public void unLoadxsd() {
    pnlCenter.removeAll();
    pnlXmlEditor.removeAll();
    repaint();
    setCurrentXsdFile(null);
    setTitle();
  }


  public static Log getLogger(){
    if (logger == null){
      Properties props = new Properties();
      props.setProperty("log4j.rootLogger", "DEBUG, A1");
      props.setProperty("log4j.appender.A1", "org.apache.log4j.ConsoleAppender");
      props.setProperty("log4j.appender.A1.layout", "org.apache.log4j.PatternLayout");
      props.setProperty("log4j.appender.A1.layout", "org.apache.log4j.PatternLayout");
      props.setProperty("log4j.logger.test.reportmanager", "ALL");
      logger = LogFactory.getLog("ReportManager");
      org.apache.log4j.PropertyConfigurator.configure(props);
      return logger;
    } else {
      return logger;
    }
  }

  public void generateReportView() {
    XmlEditorTreeModelNode node = (XmlEditorTreeModelNode)pnlXmlEditor.getTreeModel().getRoot();
    String reportType = node.getUserObject().toString();
    if(!reportType.equalsIgnoreCase("ReportDefinition")){
      showException(new XmlEditorException("Un ReportView solo puede ser generado a partir de un ReportDefinition"));
    }
    XmlEditorTreeModelNode dimensionsGroup = this.getModelNodeFrom(node.children(), "DimensionDefinitions", false);
    XmlEditorTreeModelNode dimensions = this.getModelNodeFrom(dimensionsGroup.children(), "DimensionDefinition", false);
    XmlEditorTreeModelNode metricsGroup = this.getModelNodeFrom(node.children(), "MetricDefinitions", false);
    XmlEditorTreeModelNode metrics = this.getModelNodeFrom(metricsGroup.children(), "MetricDefinition", false);
    String reportDefinitionId = "";
    XmlEditorTreeModelNode mainNode = this.getModelNodeFrom(node.children(), "ReportDefinition", false);
    if(mainNode != null){
      reportDefinitionId = mainNode.getId();
    }else{
      reportDefinitionId = getReportDefintionId(node);
    }
    String reportPath = writeReportView(dimensions, metrics, reportDefinitionId);
    menuBar.addXmlRecentItem(reportPath);
    File xmlFile = new File(reportPath);
    setCurrentXmlFile(xmlFile);
    try{
      loadXmlFromSchema(reportViewXsdPath, xmlFile);
    }catch (XmlEditorException e){
      showException(e);
    }
    setTitle();
  }

  private String writeReportView(XmlEditorTreeModelNode dimensions, XmlEditorTreeModelNode metrics, String reportDefinitionId) {
    ReportView reportView = XmlEditorDefaultReports.getReportView(dimensions, metrics, reportDefinitionId);
    //System.out.println("reportView.toString():"+reportView.toString());
    String fullPath = reportGeneratorConfiguration.getSourceReportViewsPath() + "/" + reportView.getId() + ".xml";
    try{
      getLogger().info(new String("Grabando el reportView definition"));
     // System.out.println("Grabando el reportView definition");
      Writer wr = new FileWriter(fullPath);
      reportView.marshal(wr);
      wr.flush();
      wr.close();
    }catch (Exception e){
      e.printStackTrace();
      showException(new XmlEditorException(e));
    }
    return fullPath;
  }

  private String getReportDefintionId(XmlEditorTreeModelNode node) {
    Collection reportDefinitionElementNames = Arrays.asList(new String[]{"ActionDefinitions", "DimensionDefinitions",
                      "DrillDownDefinitions", "MetricDefinitions", "FilterDefinitions", "ParameterValues",
                      "ReportDefinition", "Localizations", "Roles"});
    Enumeration enumeration = node.children();
    while (enumeration.hasMoreElements()) {
      XmlEditorTreeModelNode child = (XmlEditorTreeModelNode) enumeration.nextElement();
      if(!reportDefinitionElementNames.contains(child.getUserObject().toString())){
        return child.getId();
      }
    }
    return "";
  }

    public void checkParametersRSDs(boolean onlyErrors)  {
        try {
            getReportManager().registerDefinitions();
            Map.Entry entry;
            Map definitionsMap = null;
                definitionsMap = getReportManager().getReportSourceDefinitions();
            ReportSourceDefinition reporSourcetDefinition;
            if (definitionsMap != null){
              TreeMap infos = new TreeMap();
              Iterator iterator =  definitionsMap.entrySet().iterator();
              String name;
              while (iterator.hasNext()) {
                entry = (Map.Entry) iterator.next();
                reporSourcetDefinition = getReportManager().getReportSourceDefinitionFromID(entry.getValue().toString());
                checkFilterDefinitionsRSD(reporSourcetDefinition, onlyErrors, infos);
                checkParamsQuery(reporSourcetDefinition, onlyErrors, infos);
               // System.out.println("-------------REporte:"+entry.getKey().toString());
               // System.out.println();
              }
              if ( onlyErrors) {
                name = "ParametrosError.txt";
              }else{
                name = "Parametros.txt";
              }
              saveMap(infos, name);
            }
        } catch (InfoException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void saveMap(TreeMap infos,String fileName) {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(fileName);
            Iterator iterator = infos.entrySet().iterator();
            Map.Entry entry;
            String i = ",";
            String key;

            while (iterator.hasNext()) {
              entry  = ((Map.Entry) iterator.next());

                file.write(entry.getKey().toString().getBytes());

                file.write(i.toString().getBytes());
                file.write(entry.getValue().toString().getBytes());
                file.write(System.getProperty("line.separator").getBytes());

          }
          file.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void checkParamsQuery(ReportSourceDefinition reporSourcetDefinition, boolean onlyErrors, TreeMap infos) {
        ParameterValue parameterValue;
        boolean exist = false;
        Enumeration enumeration=  reporSourcetDefinition.getParameterValues().enumerateParameterValue();
        String expression;
        String parameter;
        while (enumeration.hasMoreElements()) {
            parameterValue = (ParameterValue)enumeration.nextElement();
            parameter =parameterValue.getFilterDefinitionName()+parameterValue.getFilterParameter().toString();
            expression = reporSourcetDefinition.getDataSourceDefinitions().getDataSourceDefinition(0).getExpression();
            if (expression.indexOf("%value_"+parameter+"%")<=0) {
                if (onlyErrors) {infos.put(reporSourcetDefinition.getId()+getIndex()+",ERROR"+parameter, "filtro no utilizado en la query "+parameter);}
            }
            if ((parameterValue.getDefaultValue()!=null)&&(parameterValue.getDefaultValue().equalsIgnoreCase("NULL_VALUE"))){
                if (expression.indexOf("%start_"+parameter+"%")<=0) {
                    if (onlyErrors) {infos.put(reporSourcetDefinition.getId()+getIndex()+",ERROR_"+parameter+"Start","parametro no obligatorio sin START en la query "+parameter);}
                }
                if (expression.indexOf("%end_"+parameter+"%")<=0) {
                    if (onlyErrors) {infos.put(reporSourcetDefinition.getId()+getIndex()+",ERROR_"+parameter+"End","parametro no obligatorio sin END an la query "+parameter);}
                }

            }

        }



    }

    public void checkFilterDefinitionsRSD(ReportSourceDefinition RSD, boolean onlyErrors, TreeMap infos) {
      //  System.out.println();
      //  System.out.println();
        infos.put(RSD.getId()+getIndex()+",AREPORT","Reporte,"+RSD.getId());
     //   System.out.println("Reporte:"+RSD.getId());
        String localConst;
        String filterName;
        String filterTypeName;
        for (int i = 0; i< RSD.getFilterDefinitions().getFilterDefinition().length;i++){
            getConstant();
            if (RSD.getFilterDefinitions().getFilterDefinition()[i].getFilterType()==FilterDefinitionFilterTypeType.IN){
              filterTypeName = "VALUES";
            } else{
              filterTypeName = "VALUE";
            }
            filterName = RSD.getFilterDefinitions().getFilterDefinition()[i].getName();
            localConst = filterName+ filterTypeName;
            checkFilterDefinition(RSD,filterName,filterTypeName, onlyErrors, infos);
            if (!(getConstantValues().containsKey(localConst))){
              if (onlyErrors) { infos.put(RSD.getId()+getIndex()+",ERROR","(constante inexistente):,"+localConst);}
            }else{
                if (!onlyErrors) { infos.put(RSD.getId()+getIndex()+",PARAMETRO,"+localConst,getConstantValues().get(localConst).toString());}
            }
        }
        checkParametersDesc(RSD, onlyErrors, infos);


//checkQuery(RSD.getDataSourceDefinitions().getDataSourceDefinition(1).getExpression(),localConst);
    }

    private void checkParametersDesc(ReportSourceDefinition rsd, boolean onlyErrors, TreeMap infos) {
        try {
            String RDName = rsd.getId().substring(3,rsd.getId().length());
            ReportDefinition reportDefinition = getReportManager().getReportDefinitionFromID("RD"+RDName);
            FileReader input;
            input = new FileReader(reportGeneratorConfiguration.getSourceReportLayoutPath() + "/" + reportDefinition.getLayoutDesign()+".xml");
            BufferedReader reader = new BufferedReader(input);
            StringBuffer buffer = createBuffer(reader);
            input.close();
            reader.close();
            int index = 0;
            String parameterName;
            ReportSpec reportSpec = getReportManager().getReportSpec(reportDefinition, rsd);
            while(index >= 0){
              index = nextTag(buffer);
              if(index > -1){
                buffer = addParameter(index, buffer, infos, onlyErrors, rsd, reportSpec);
              }
            }

/*            while (iReportfile.)
            for ( int i = 0;i<jasperDefinition.getJasperDefinition(true).getParametersList().size();i++){
              designParameter =  (JRDesignParameter)jasperDefinition.getJasperDefinition(true).getParametersList().get(i);
            }
            jasperDefinition = null;
            */
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    private StringBuffer addParameter(int index, StringBuffer buffer, TreeMap infos, boolean onlyErrors, ReportSourceDefinition rsd, ReportSpec reportSpec){
      int endOfTag = buffer.indexOf(">", index);
      String s = buffer.substring(index, endOfTag + 1);
      String text;
      String parameterName;
      if((s.endsWith(">")&&(!s.equalsIgnoreCase("</parameter>")))){
        text = s.substring(17,s.length()-17);
        buffer.delete(0,index+text.indexOf(" ")-1);

        parameterName =  text.substring(0,text.indexOf(" ")-1);

          if (parameterName.length()>9) {
              if (!parameterName.substring(0,7).equalsIgnoreCase("COLUMN_")){
                if (parameterName.length()>10) {
                  if (parameterName.substring(parameterName.length()-10).equalsIgnoreCase("DESCVALUES")){
                    if (!onlyErrors) { infos.put(rsd.getId()+getIndex()+",PARAMETRO,"+parameterName,getConstantValues().get(parameterName).toString());}
                  }
                }
                if (parameterName.length()>9){
                  if ((parameterName.substring(parameterName.length()-9).equalsIgnoreCase("DESCVALUE"))){
                      if (!onlyErrors) { infos.put(rsd.getId()+getIndex()+",PARAMETRO,"+parameterName,getConstantValues().get(parameterName).toString());}
                  }
                }
              }
          }
          if (s.indexOf("java.lang.Integer")>0 && (parameterName.indexOf("DESCVALUE")<0)){
         //   if (!((reportSpec.getFilterSpecFromName(parameterName.substring(0,parameterName.length()-5))!= null)||((reportSpec.getFilterSpecFromName(parameterName.substring(0,parameterName.length()-4))!=null)))){
                if (onlyErrors) {infos.put(rsd.getId()+getIndex()+",ERROR"+parameterName+"sin remover del Report Layout", "ERROR parámetro:"+parameterName + " está en el report layout y no debería estar");}
           // }
          }
        return buffer;
      }else{
          return new StringBuffer("");
      }
    }

    private StringBuffer createBuffer(BufferedReader reader) throws IOException{
      StringBuffer result = new StringBuffer();
      String s = reader.readLine();
      while(s != null){
        result.append(s);
        s = reader.readLine();
      }
      return result;
    }

    private int nextTag(StringBuffer buffer){
      return buffer.indexOf("<parameter ");
 //     int other = buffer.indexOf("</parameter>", index + 1);
      //return Math.min(first,other);
    }


    private void checkFilterDefinition(ReportSourceDefinition rsd, String filterName, String filterTypeName, boolean onlyErrors, TreeMap infos) {
       ParameterValue parameterValue;
       boolean exist = false;
       Enumeration enumeration=  rsd.getParameterValues().enumerateParameterValue();
       while (enumeration.hasMoreElements()) {
           parameterValue = (ParameterValue)enumeration.nextElement();
           if ((parameterValue.getFilterDefinitionName().equalsIgnoreCase(filterName))&&(parameterValue.getFilterParameter().toString().equalsIgnoreCase(filterTypeName))){
             exist = true;
           }
       }
       if (!exist){
           if (onlyErrors) {infos.put(rsd.getId()+getIndex()+",ERROR"+filterName+"sin parameter", "ERROR filtro:"+filterName + filterTypeName + " no está como parámetro");}
       }
    }

    private HashMap getConstant() {
        if (constant == null){
            constant = ConstantesREP.getFields();
        }
        return constant;  //To change body of created methods use File | Settings | File Templates.
    }
    private HashMap getConstantValues() {
        if (constantValues == null){
            constantValues = ConstantesREP.getValueFields();
        }
        return constantValues;  //To change body of created methods use File | Settings | File Templates.
    }

    private String getIndex(){
        index = index +1;
        return ","+index;
    }

}

