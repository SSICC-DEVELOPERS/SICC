package es.indra.sicc.util.xml;

import es.indra.sicc.util.xml.IXMLDocument;
import es.indra.sicc.util.xml.IXSLTFactory;
import es.indra.sicc.util.xml.XSLTFactory;
import es.indra.sicc.util.xml.filters.Filters;
import es.indra.sicc.util.xml.filters.FiltersValues;
import es.indra.sicc.util.xml.templates.XSLGetter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


/**
 * <code>class XMLEngine</code>
 * <p>
 * Clase Principal del paquete, esta clase ofrece los métodos necesarios para
 * transformar xml, como ser, generar un unico documento a partir de 2,
 * ordenar, filtrar, elmininar del contenido del xml filas, según criterio.
 *
 * <p>
 * @author    Software Factory Argentina <strong>INDRA SI S.A</strong>
 * @version   1.0
 */
public class XMLEngine {
   /**
   * factorias por defecto, pueden ser sobreescritas con implementaciones
   * personalizadas, implementados las interfaces correspondientes.
   */
   private static final String defXMLFactory = "es.indra.sicc.util.xml.XMLDocument";
   private static final String defXSLFactory = "es.indra.sicc.util.xml.XSLTFactory";

   /**
   * Constantes a utilizar en las operaciones de Filtrado de los documentos
   */
   public static final int XMLENGINE_EXCLUDE_FROM = 0;
   public static final int XMLENGINE_FILTER_BY = 1;
   private IXSLTFactory privXSLFactory;
   private IXMLDocument privXMLFactory;

   /**
   * Este contructor permite definir las factorias a utilizar en la inicialización
   * tanto del <code>Transformer</code>, como del <code>Document</code> o <code>Element</code>
   * con factorias propias, que implementen las interfaces correspondientes.
   */
   public XMLEngine(String xslFactoryToUse, String xmlFactoryToUse)
      throws Exception {
      String xsl = xslFactoryToUse;

      if ((xsl == null) || xsl.trim().equals("")) {
         xsl = defXSLFactory;
      }

      String xml = xmlFactoryToUse;

      if ((xml == null) || xml.trim().equals("")) {
         xml = defXMLFactory;
      }

      initFactory(xsl, xml);
   }

   /**
   * Este contructor crea las factorias por defecto
   * de la clase, las que son:
   * <b><br><code>ar.com.indra.cdos.util.xml.XMLDocument</code>
   * <br><code>ar.com.indra.cdos.util.xml.XSLTFactory</code></b>
   */
   public XMLEngine() throws Exception {
      initFactory(defXSLFactory, defXMLFactory);
   }

   private void initFactory(String xsl, String xml) throws Exception {
      privXSLFactory = (XSLTFactory) Class.forName(xsl).newInstance();
      privXMLFactory = (IXMLDocument) Class.forName(xml).newInstance();
   }

   /**
   *Este metodo permite mezclar el contenido de 2 documentos xml de identica estructura
   * en un documento resultante que no repetira nodos
   * @param xmlFrom documento xml de origen
   * @param xmlTo documento xml destino
   * @return org.w3c.dom.Element
   * @throw java.lang.Exception
   */
   public Element getMergedXML(Element xmlFrom, Element xmlTo,
      String axisFields, String separator) throws Exception {
      Document docToAppend = privXMLFactory.makeDocument(getElementAsString(
               xmlTo));
      Transformer tranf = privXSLFactory.getTransformer(es.indra.sicc.util.xml.templates.XSLGetter.getXSLForMerge(
               es.indra.sicc.util.xml.templates.XSLGetter.XSLGETTER_GET_FROM_OTHER,
               "", axisFields, separator));

      tranf.setParameter("origen", docToAppend);

      return applyTemplate(tranf, xmlFrom);
   }

   /**
   *Este metodo permite <i><b>ordenar</b></i> el contenido del documento xml.
   * @param xmlFrom documento xml a procesar
   * @param fieldNames Lista de Nodos a utilizar en el proceso
   * @param separator separador de la lista de nodos
   *
   * @return org.w3c.dom.Element
   * @throw java.lang.Exception
   */
   public Element getSortedXML(Element xmlFrom, String fieldNames,
      String separator) throws Exception {
      Transformer tranf = privXSLFactory.getTransformer(es.indra.sicc.util.xml.templates.XSLGetter.getXSLForSort(
               es.indra.sicc.util.xml.templates.XSLGetter.XSLGETTER_GET_FROM_OTHER,
               "", fieldNames, separator));

      return applyTemplate(tranf, xmlFrom);
   }

   /**
   *Este metodo permite <i><b>filtrar</b></i> el contenido del documento xml.
   * @param xmlFrom documento xml a procesar
   * @param filters objeto con la lista de filtros a usar
   * @param operation indica el modo de filtrado(exclusion, inclusion).
   * Los valores a utilizar se indican en constantes en esta clase
   *
   * @return org.w3c.dom.Element
   * @throw java.lang.Exception
   */
   public Element getFilteredXML(Element xmlFrom, Filters filters, int operation)
      throws Exception {
      Transformer tranf = privXSLFactory.getTransformer(es.indra.sicc.util.xml.templates.XSLGetter.getXSLForFilter(
               es.indra.sicc.util.xml.templates.XSLGetter.XSLGETTER_GET_FROM_OTHER,
               "", filters, operation));

      return applyTemplate(tranf, xmlFrom);
   }

   /**
   *Este metodo permite <i><b>Reordenar</b></i> el contenido del documento xml.
   * @param xmlFrom documento xml a procesar
   * @param fieldNames Lista de Nodos a utilizar en el proceso
   * @param separator separador de la lista de nodos
   * @param includeAll indica si deben agregarse los nodos que no se mencionan en la lista de nodos a reordenar
   *
   * @return org.w3c.dom.Element
   * @throw java.lang.Exception
   */
   public Element getReorderedXML(Element xmlFrom, String axisFields,
      String separator, boolean includeAll) throws Exception {
      Transformer tranf = privXSLFactory.getTransformer(es.indra.sicc.util.xml.templates.XSLGetter.getXSLForReorder(
               es.indra.sicc.util.xml.templates.XSLGetter.XSLGETTER_GET_FROM_OTHER,
               "", axisFields, separator, includeAll));

      return applyTemplate(tranf, xmlFrom);
   }

   private Element applyTemplate(Transformer tranf, Element xmlFrom)
      throws Exception {
      //UtilidadesLog.debug(getElementAsString(xmlFrom));
      tranf.setOutputProperty("encoding", "ISO-8859-1");

      ByteArrayOutputStream streamSalida = new ByteArrayOutputStream();
      DOMSource entrada = new DOMSource(xmlFrom);
      StreamResult salida = new StreamResult(streamSalida);

      //DOMResult salida = new DOMResult();
      tranf.transform(entrada, salida);

      StringBuffer buf = new StringBuffer();
      buf.append(streamSalida.toString());

      //return ((Document)salida.getNode()).getDocumentElement(); 
      return privXMLFactory.makeElement(buf.toString());
   }

   public String getElementAsString(Element source) throws Exception {
      return privXMLFactory.getStringFromElement(source);
   }
}
