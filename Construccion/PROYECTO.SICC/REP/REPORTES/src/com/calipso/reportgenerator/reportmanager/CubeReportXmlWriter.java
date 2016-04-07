package com.calipso.reportgenerator.reportmanager;

//import com.calipso.reportgenerator.reportcalculator.CubeFloat;
import com.calipso.reportgenerator.reportcalculator.CubeQuery;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.common.QueryDimension;
import com.calipso.reportgenerator.common.ReportMetricSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.QueryMetric;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.LanguageTraslator;
import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;

import java.io.StringWriter;
import java.io.IOException;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

import es.indra.mare.common.info.InfoException;

/**
 * Esta clase se encarga de generar el XML de salida
 * para un reporte de tipo Cube. Result.xml
 */
public class CubeReportXmlWriter implements ReportXmlWriter {
  private ReportData reportData;
  private ReportDataIterator reportDataIterator;
  private ReportSpec reportSpec;
  private Document document;
  private Map paramValues;
  private CubeQuery cubeQuery;
  private Element root;

  public CubeReportXmlWriter(ReportData reportData, ReportSpec reportSpec, Map paramValues, ReportQuery query) throws InfoException {
    this.reportData = reportData;
    this.reportDataIterator = reportData.iterator();
    this.reportSpec = reportSpec;
    this.paramValues = paramValues;
    cubeQuery = query.getCubeQuery();
  }

  /**
   * Retorna el xml generado
   * @return
   */
  public StringWriter getXml() throws InfoException {
    try {
      /*Element node;
      startDocument();
      if (reportDataIterator.hasNext()) {
        reportDataIterator.advance();
        node = createDocument();
        root = createElement("Report");
        node.appendChild(root);
        iterateCube(0, root, false);
        addParameters();
      }*/
      startDocument();
      Element node = createDocument();
      root = createElement("Report");
      node.appendChild(root);
      iterateRows(root);
      return getStream();
    } catch (Exception e) {
      e.printStackTrace();
      throw new InfoException(LanguageTraslator.traslate("76"));
    }
  }

  public ReportSpec getReportSpec() {
    return reportSpec;
  }

  public Map getParamValues() {
    return paramValues;
  }

  /**
   * Agrega los parámetros(Parameters values) al xml
   */
  private void addParameters() {
    // COMPLETAR
  }

  /**
   * Devuelve un StringWriter con el xml
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

  private void iterateRows(Element node) {
    int i;
    int [] rows = cubeQuery.getRows();
    if(rows.length > 0) {
      while(reportDataIterator.hasNext()) {
        reportDataIterator.advance();
        Object [] values = reportDataIterator.current();
        for(i = 0 ; i < rows.length ; i++) {
          ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromIndex(rows [i]);
          node = getNodeFrom(dimensionSpec.getName(), getNodeValue(dimensionSpec,values [i]), node, values);
        }

        iterateColumns(node, values, i);
        node = root;
      }
    }
  }



  private void iterateColumns(Element node, Object [] values, int i) {
    int [] cols = cubeQuery.getColumns();
    if(cols.length > 0) {
      for(int j = 0 ; j < cols.length ; j++, i++) {
        ReportDimensionSpec dimensionSpec = reportSpec.getDimensionFromIndex(cols [j]);
        node = getNodeFrom(dimensionSpec.getName(), getNodeValue(dimensionSpec,values [i]), node, values);
      }
    }
  }

  /**
   * Retorna el valor para el nodo
   * @param dimensionSpec
   * @param value
   * @return
   */
  private String getNodeValue(ReportDimensionSpec dimensionSpec, Object value){
    if (value instanceof SharedDate) {
      DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
      return dateFormat.format(((SharedDate) value).getDateEx().getDate());
    } else if (value instanceof SharedFloat) {
      DecimalFormat df = new DecimalFormat();
      return df.format(((SharedFloat) value).floatValue());
    } else {
      return value.toString();
    }
  }

  private Element getNodeFrom(String name, String value, Element node, Object [] values) {
    Element returnVal = null;

    NodeList childs = node.getChildNodes();
    for(int i = 0 ; i < childs.getLength() ; i++) {
      Element child = (Element) childs.item(i);
      Attr attr = child.getAttributeNode("Value");
      if(attr.getValue().equalsIgnoreCase(value)) {
        returnVal = child;
        break;
      }
    }

    if(returnVal == null) {
      returnVal = document.createElement(name);
      returnVal.setAttribute("Value", value);
      node.appendChild(returnVal);
    }

    addMetrics(returnVal, values, cubeQuery.getRows().length + cubeQuery.getColumns().length);
    return returnVal;
  }

  private void addMetrics(Element returnVal, Object [] values, int j) {
    int [] metrics = cubeQuery.getMetrics();
    for(int i = 0 ; i < metrics.length ; i++, j++) {
      ReportMetricSpec metric = reportSpec.getMetricFromIndex(i);
      if(returnVal.hasAttribute(metric.getName())) {
        Attr attr = returnVal.getAttributeNode(metric.getName());
        float metricValue = Float.valueOf(attr.getValue()).floatValue();
        float result = ((SharedFloat)values [j]).floatValue() + metricValue;
        attr.setValue(String.valueOf(result));
      } else {
        returnVal.setAttribute(metric.getName(), values [j].toString());
      }
    }
  }

  /**
   * Recorre el iterador del cube
   * @param dimension nivel del iterador
   * @param ownerNode nodeo padre
   * @param eoc fin del cube
   */

  private void iterateCube(int dimension, Element ownerNode, boolean eoc) {
    Element elemTo;
    Element child;
    Object[] totalObj = null;
    int dimTo;
    int dimSize;
    boolean lEoc = false;
    //dimSize = reportData.getQuery().getDimensions().size();
    //Todo: no optimo
      dimSize = getCubeQuery().getDimensions().length;

    if (!eoc) {
      child = createNodeElement(getDimensionNameFromIndex(dimension), reportDataIterator.current()[dimension].toString());
      ownerNode.appendChild(child);
      if (dimension < (dimSize - 1)) {
        iterateCube((dimension + 1), child, eoc);
      }
      else {
        FillValue(child);
        if (reportDataIterator.hasNext()) {
          reportDataIterator.advance();
        }
        else {
          lEoc = true;
          reportDataIterator.advance();
        }
        elemTo = child;
        dimTo = dimension;
        for (int i = 0; i < (reportDataIterator.currentTotals().size()); i++) {
          dimTo = dimTo - 1;
          elemTo = (Element) elemTo.getParentNode();
          if (i < (reportDataIterator.currentTotals().size())) {
            totalObj = (Object[]) reportDataIterator.currentTotals().toArray()[i];
            fillTotals(elemTo, totalObj);
          }
        }
        iterateCube(dimTo, (Element) elemTo.getParentNode(), lEoc);
      }
    }
  }

  private CubeQuery getCubeQuery() {
    if (cubeQuery == null) {
      try {
        cubeQuery = reportData.getQuery().getCubeQuery();
      } catch (InfoException e) {
        return null;
      }
    }
    return cubeQuery;
  }

  /**
   * Obtiene el nombre de una dimensión
   * @param dimension indice
   * @return
   */
  private String getDimensionNameFromIndex(int dimension) {
    return ((QueryDimension)reportData.getQuery().getDimensions().get(dimension)).getName();
    /*int index = reportData.getQuery().getDimensions().get[dimension];
    return ((DataDefinition) cube.getDefinition().getDimensions()[index]).getName();*/
  }

  /**
   * Obtienen el nombre de la métrica
   * @param metric indice
   * @return
   */
  private String getMetricNameFromIndex(int metric) {
    return ((QueryMetric)reportData.getQuery().getMetrics().get(metric)).getName();
    //return ((DataDefinition) cube.getDefinition().getMetrics()[metric]).getName();
  }


  /**
   * Completa los totales para el grupo
   * @param elem
   * @param total lista de totales
   */

  private void fillTotals(Element elem, Object[] total) {
    int index = 0;
    int currentMetric = 0;
    int metricsFound = 0;
    int metricsCount = reportData.getQuery().getMetrics().size();

    while (metricsFound < metricsCount) {
      if (total[index] instanceof SharedFloat) {
        String metricName = getMetricNameFromIndex(currentMetric);
        elem.setAttribute(metricName, total[index].toString());
        currentMetric++;
        metricsFound++;
      }
      index++;
    }
  }

  /**
   * Completa el valor de las dimensiones
   * @param elem nodo
   * @param metricValues valores de las métricas
   */
  private void fillMetricValues(Element elem, Object[] metricValues) {
    int index = 0;
    int currentMetric = 0;
    int metricsFound = 0;
    int metricsCount = reportData.getQuery().getMetrics().size();

    while (metricsFound < metricsCount) {
      if (metricValues[index] instanceof SharedFloat) {
        String metricName = getMetricNameFromIndex(currentMetric);
        elem.setAttribute(metricName, metricValues[index].toString());
        currentMetric++;
        metricsFound++;
      }
      index++;
    }
  }

  /**
   * Completa el valor de la métrica
   * @param elem
   */
  private void FillValue(Element elem) {
    Object[] row;
    row = reportDataIterator.current();
    fillMetricValues(elem, row);
  }

  /**
   * Crea el documento xml y el root
   * @return
   */
  private Element createDocument() {
    Element root;
    root = createElement("Result");
    document.appendChild(root);
    String reportDefName = getReportSpec().getDescription();
    root.setAttribute("ReportRefinition", reportDefName);
    return root;
  }

  /**
   * Crea un document
   */
  private void startDocument() {
    document = new DocumentImpl();
  }

  /**
   * Crea un nodo dentro del documento
   * @param tagName Nombre del tag
   * @param value valor del tag
   * @return el elemento creado
   */
  private Element createNodeElement(String tagName, String value) {
    Element newElem;
    newElem = document.createElement(tagName);
    newElem.setAttribute("Value", value);
    return newElem;
  }

  /**
   * Crea un element
   * @param tagName
   * @return
   */
  private Element createElement(String tagName) {
    return document.createElement(tagName);
  }
}
