package com.calipso.reportgenerator.reportmanager;


import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportFilterBuilder;
import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import com.calipso.common.DateEx;
import es.indra.mare.common.info.InfoException;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import com.calipso.reportgenerator.reportmanager.IRDataSource;


/**
 * Resuelve la obtención de los datos desde un Xml y los devuelve en un objeto <code>IRDataSource</code>
 * Se encarga de obtener el Xml según el Url del DataSourceDefinition, parsear el texto Xml utilizando la información
 * contenida en el ReportSourceDefinition, ejecutarle los pre-filtros y agregar los registros resultantes en el
 * objeto <code>DataSource</code>.
 */
public class XmlReportDataSource extends ReportDataSource {

  private String url;
  private IRDataSource dataSource;

  public XmlReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportGeneratorConfiguration managerConfiguration) {
    super(reportSpec, dataSourceSpec);
    super.setGeneratorConfiguration(managerConfiguration);
  }

  /**
   * Método que inicializa el objeto. Asigna la dirección URL
   */
  protected void initialize() {
    url = getReportDataSourceSpec().getExpression();
  }

  /**
   * Parsea el XML. Crea el Parser y lo instancia desde la dirección URL
   */
  private void loadFromXml() throws InfoException {
    org.apache.xerces.parsers.DOMParser parser = new org.apache.xerces.parsers.DOMParser();
    try {
      File file = new File(url);
      InputStream in = new FileInputStream(file);
      InputSource source = new InputSource(in);
      parser.parse(source);
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("100"), e);
    }
    Document document = parser.getDocument();
    loadXmlDocument(document);
  }

  /**
   * Busca el elemento raiz del XML y comienza a recorrer las filas
   * @param document
   */
  private void loadXmlDocument(Document document) throws InfoException {
    Node rootNode = FindElement(document, "DataSource");
    loadRowList(rootNode);
  }

  /**
   * Busca el nodo correspondiente a las filas y las recorre.
   * @param node
   */
  private void loadRowList(Node node) throws InfoException {
    Node rowsNode = FindElement(node, "Rows");
    if (rowsNode != null) {
      loadRows(rowsNode);
    }
  }

  /**
   * Recorre cada fila y llena una row y la agrega al datasource.
   * @param node
   */
  private void loadRows(Node node) throws InfoException {
    try {
      if (node != null) {
        Node childNode;
        NodeList children = node.getChildNodes();
        if (children != null) {
          for (int i = 0; i < children.getLength(); i++) {
            childNode = children.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
              NamedNodeMap attributes = childNode.getAttributes();
              int size = getReportSpec().getDataSourceIndexes().size();
              List row = new ArrayList(size);
              for (int j = 0; j < size; j++) {
                ReportDimensionSpec dimensionSpec = null;
                if(j < getReportSpec().getNotCalculatedDimensions().size()) {
                  String name = getReportSpec().getDataSourceIndexNameByIndex(j);
                  dimensionSpec = getReportSpec().getDimensionFromName(name);
                  if (!dimensionSpec.getCalculated()) {
                    addNonCalculatedRow(row, attributes.item(j).getNodeValue(), j, dimensionSpec.getDataType().getType());
                  }
                } else {
                  row.add(j, SharedFloat.newFrom(new Float(attributes.item(j).getNodeValue())));
                }
              }
              try {
                if ((getFilter()== null)||((getFilter()!= null) && (getFilter().matches(row.toArray())))) {
                  dataSource.addRow(row);
                }
              } catch (InfoException e) {
                throw new InfoException(LanguageTraslator.traslate("101"), e);
              }
            }
          }
        }
      }
    } catch(OutOfMemoryError e) {
      throw new InfoException(LanguageTraslator.traslate("326"), e);
    }
  }

  private void addNonCalculatedRow(List row, String nodeValue, int index, int dataType) throws InfoException{
    switch(dataType){
      case ReportDataType.DATETIME_TYPE:
        row.add(index, SharedDate.newFrom(new DateEx(nodeValue, getReportDataSourceSpec().getDateTimePattern())));
        break;
      case ReportDataType.DATE_TYPE:
        row.add(index, SharedDate.newFrom(new DateEx(nodeValue, getReportDataSourceSpec().getDatePattern())));
        break;
      case ReportDataType.STRING_TYPE:
        row.add(index, SharedString.newFrom(nodeValue));
        break;
      case ReportDataType.FLOAT_TYPE:
        row.add(index, SharedFloat.newFrom(new Float(nodeValue)));
        break;
      case ReportDataType.INTEGER_TYPE:
        row.add(index, SharedInteger.newFrom(new Integer(nodeValue)));
        break;
      case ReportDataType.BOOLEAN_TYPE:
        row.add(index, Boolean.valueOf(nodeValue));
    }
  }

  /**
   * Busca un elemento en el xml por nombre a partir de un nodo
   * @param node Nodo origen
   * @param rootName nodo a buscar
   * @return
   */
  private static Node FindElement(Node node, String rootName) {
    Node resNode = null;

    if (node.getNodeName().compareTo(rootName) == 0) {
      resNode = node;
    }

    if (resNode == null) {
      NodeList children = node.getChildNodes();
      if (children != null) {
        for (int i = 0; i < children.getLength(); i++) {
          if (resNode == null) {
            resNode = FindElement(children.item(i), rootName);
          }
        }
      }
    }
    return resNode;
  }


  /**
   * Crea el datasource y lo llena
   * @return
   * @throws InfoException
   */
  public IRDataSource getDataSource() throws InfoException {
    if (dataSource == null) {
      dataSource = newDataSource();
      loadFromXml();
    }
    return dataSource;
  }

  /**
   * Asigna el modo de uso de las variables
   * @return
   */
  public int getFilterVarMode() {
    return ReportFilterBuilder.VARMODE_DATAINDEX;
  }

}
