package com.calipso.reportgenerator.reportmanager;

import es.indra.mare.common.info.InfoException;

import java.io.StringWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import com.calipso.reportgenerator.reportcalculator.DataTreeNode;
//import com.calipso.reportgenerator.reportcalculator.CubeFloat;
import com.calipso.reportgenerator.reportcalculator.DataTreeSubItem;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.ReportMetricSpec;

/**
 * Esta clase se encarga de generar el XML de salida
 * para un reporte de tipo estatico. Result.xml
 */

public class StaticReportXmlWriter implements ReportXmlWriter {
  private ReportData reportData;
  private ReportSpec reportSpec;
  private Map paramValues;
  private Document document;

  /**
   * Inicializa una instancia de <code>StaticReportXmlWriter</code>
   * @param reportData
   * @param reportSpec
   * @param paramValues
   */
  public StaticReportXmlWriter(ReportData reportData, ReportSpec reportSpec, Map paramValues) {
    this.reportData = reportData;
    this.reportSpec = reportSpec;
    this.paramValues = paramValues;
  }

  /**
   * Devuelve la instancia de  <code>ReportData</code> asociado a la
   * instancia de <code>StaticReportXmlWriter</code>
   * @return
   */
  public ReportData getReportData() {
    return reportData;
  }

  /**
   * Devuelve la instancia de <code>StaticReportData</code> asociado a la
   * instancia de <code>StaticReportXmlWriter</code>
   * @return
   */
  public StaticReportData getStaticReportData() {
    return (StaticReportData) getReportData();
  }

  /**
   * Devuelve la instancia de <code>ReportSpec</code> asociado a la
   * instancia de <code>StaticReportXmlWriter</code>
   * @return
   */
  public ReportSpec getReportSpec() {
    return reportSpec;
  }

  /**
   * Devuelve un conjunto de datos que representa
   * los valores de los parametros
   * @return
   */
  public Map getParamValues() {
    return paramValues;
  }

  /**
   * Crea un nuevo documento para comenzar la escritura a XML.
   */
  private void startDocument() {
    document = new DocumentImpl();
  }

  /*private Element createRoot() {
    Element root;
    root = createElement("Result");
    document.appendChild(root);
    String reportDefName = getReportSpec().getDescription();
    root.setAttribute("ReportRefinition", reportDefName);
    return root;
  } */

  /**
   * Genera el arbol que representa el XML de salida.
   * @return
   * @throws InfoException
   */
  public StringWriter getXml() throws InfoException {
    try {
      //Element repElem, root;
      startDocument();
      //root = createRoot();
      DataTreeNode dataTreeNode = getStaticReportData().getDataTree().getRoot();
      dataTreeNode.setValue(getReportSpec().getDescription());
      generateNode(dataTreeNode, document);
      return getStream();
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("99"));
    }
  }

  /**
   * Genera un nodo XML a partir de un <code>DataTreeNode</code>.
   * @param dataTreeNode
   * @param parent
   */
  private void generateNode(DataTreeNode dataTreeNode, Node parent) {
    Node element = createNodeElement(getTagName(dataTreeNode.getDimensionIndex()), dataTreeNode.getValue().toString());
    parent.appendChild(element);
    fillMetrics(dataTreeNode, element);
    fillSubItems(dataTreeNode, element);
    fillSubNodes(dataTreeNode, element);
  }

  /**
   * Obtiene la descripcion a mostrar para un nodo del XML a partir
   * de un indice.
   * @param dimensionIndex
   * @return
   */
  private String getTagName(int dimensionIndex) {
    if (dimensionIndex >= 0) {
      return ((ReportDimensionSpec) reportSpec.getDimensionsByIndex().get(dimensionIndex)).getName();
    }
    else {
      return "Report";
    }
  }

  /**
   * Genera nodos hijos en base a un nodo padre siempre que el diccionario
   * de hijos que tiene el padre tenga informacion.
   * @param dataTreeNode
   * @param parent
   */
  private void fillSubNodes(DataTreeNode dataTreeNode, Node parent) {
    Iterator iterator = dataTreeNode.getSubNodes().values().iterator();
    while (iterator.hasNext()) {
      DataTreeNode current = (DataTreeNode) iterator.next();
      generateNode(current, parent);
    }
  }

  /**
   * Genera los nodos para un nodo del XML siempre y cuando
   * la lista subItems del nodo contenga informacion.
   * @param dataTreeNode
   * @param element
   */
  private void fillSubItems(DataTreeNode dataTreeNode, Node element) {
    int[] dims = getStaticReportData().getDataTree().getQuery().getNoGroupDimensions();
    int[] mets = getStaticReportData().getDataTree().getQuery().getMetrics();
    int[] accmets = getStaticReportData().getDataTree().getQuery().getAccumulableMetrics();

    for (int i = 0; i < dataTreeNode.getSubItems().size(); i++) {
      DataTreeSubItem subItem = (DataTreeSubItem) dataTreeNode.getSubItems().get(i);
      Element item = createNodeElement("Item", String.valueOf(i));
      element.appendChild(item);
      for (int j = 0; j < dims.length; j++) {
        int dim = dims[j];
        String value = subItem.getNonGroupingDimensionValues()[j].toString();
        if (value != null && !value.equals("")) {
          item.setAttribute(getTagName(dim), value);
        }
      }
      for (int j = 0; j < mets.length; j++) {
        SharedFloat value = subItem.getMetricValues()[j];
        item.setAttribute(getMetricNameFromIndex(j), value.toString());
      }


      for (int j = 0; j < accmets.length; j++) {
        SharedFloat value = subItem.getAccumulableMetricValues()[j];
        item.setAttribute(getMetricNameFromIndex(subItem.getMetricIndex(j)) + "_ACC", value.toString());
      }

    }
  }
  /*private void fillNoGroupingValues(DataTreeNode dataTreeNode, Node element) {
    int[] dims = getStaticReportData().getDataTree().getQuery().getNoGroupDimensions();
    int[] mets = getStaticReportData().getDataTree().getQuery().getMetrics();
    for (int i = 0; i < dataTreeNode.getSubItems().size(); i++) {
      DataTreeSubItem subItem = (DataTreeSubItem) dataTreeNode.getSubItems().get(i);
      Element item = createNodeElement("Item", "");
      element.appendChild(item);
      for (int j = 0; j < dims.length; j++) {
        int dim = dims[j];
        String value = subItem.getNonGroupingDimensionValues()[j];
        if (value != null && !value.equals("")) {
          item.setAttribute(getTagName(dim), value);
        }
      }
      for (int j = 0; j < mets.length; j++) {
        int met = mets[j];
        CubeFloat value = subItem.getMetricValues()[j];
        item.setAttribute(getMetricNameFromIndex(met), value.toString());
      }
    }
  } */

  /**
   * Genera los atributos para un nodo del XML siempre y cuando
   * la lista subItems del nodo contenga informacion.
   * @param dataTreeNode
   * @param element
   */
  private void fillMetrics(DataTreeNode dataTreeNode, Node element) {
    //int[] mets = getStaticReportData().getDataTree().getQuery().getMetrics();
    Object[] metrics = dataTreeNode.getMetrics();
    for (int i = 0; i < metrics.length; i++) {
      SharedFloat metric = (SharedFloat) metrics[i];
      ((Element) element).setAttribute(getMetricNameFromIndex(i), metric.toString());
    }

    //int[] accmets = getStaticReportData().getDataTree().getQuery().getAccumulableMetrics();
    /*Object[] accmetrics = dataTreeNode.getAccumulableMetrics();
    for (int i = 0; i < accmetrics.length; i++) {
      CubeFloat accmetric = (CubeFloat) accmetrics[i];
      ((Element) element).setAttribute(getMetricNameFromIndex(i), accmetric.toString());
    } */

  }

  /**
   * Devuelve el nombre de una metrica a partir de un indice.
   * @param metricIndex
   * @return
   */
  private String getMetricNameFromIndex(int metricIndex) {

    return ((ReportMetricSpec) reportSpec.getMetricsByIndex().get(metricIndex)).getName();
  //  return ((QueryMetric) reportData.getQuery().getMetrics().get(metric)).getName();
  }


  /**
   * Serializa a disco el archivo XML de salida.
   * @return
   * @throws IOException
   */
  private StringWriter getStream() throws IOException {
    OutputFormat format = new OutputFormat(document, "ISO-8859-1", true);
    StringWriter stringOut = new StringWriter();
    XMLSerializer serial = new XMLSerializer(stringOut, format);
    serial.asDOMSerializer();
    Element elem = document.getDocumentElement();
    if (elem != null) {
      serial.serialize(elem);
    }
    return stringOut;
  }

  /**
   * Crea y retorna un nodo con las descripciones pasadas por parametro.
   * @param tagName
   * @param value
   * @return
   */
  private Element createNodeElement(String tagName, String value) {
    Element newElem;
    newElem = document.createElement(tagName);
    newElem.setAttribute("Value", value);
    return newElem;
  }

}
