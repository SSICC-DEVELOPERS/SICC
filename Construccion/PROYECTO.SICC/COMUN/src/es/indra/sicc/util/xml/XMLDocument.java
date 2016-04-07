package es.indra.sicc.util.xml;

import es.indra.sicc.util.xml.IXMLDocument;
import es.indra.sicc.util.xml.XSLTFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 * <code>class XMLDocument</code>.
 * Provee la funcionalidad basica
 * para la obtencion de un <code>Document</code>
 * o un <code>Element</code> a partir de distintos
 * objetos. Posibles extensiones: agregar objetos
 * de los cuales obtener <code>Document</code> o <code>Element</code>.
 * <p>
 * @author    Software Factory Argentina <strong>INDRA SI S.A</strong>
 * @version   1.0
 */
public class XMLDocument implements IXMLDocument {
   private DocumentBuilder docBuild;

   public XMLDocument() throws Exception {
      DocumentBuilderFactory docFact = DocumentBuilderFactory.newInstance();
      docFact.setNamespaceAware(true);
      docBuild = docFact.newDocumentBuilder();
   }

   /**
    * Devuelve un <code>Document</code> a partir de un <code>java.lang.String</code>
    * que debe ser un <strong>xml bien formado</strong>.
    *
    * @param xmlFrom <code>java.lang.String</code> representando un <strong>xml bien formado</strong>.
    * @return org.w3c.dom.Document conteniendo el xml del parametro
    * @throw java.lang.Exception
    */
   public Document makeDocument(String xmlFrom) throws Exception {
      StringBuffer buf = new StringBuffer();
      buf.append(xmlFrom);

      String preDoc = buf.toString();
      ByteArrayInputStream entrada = new ByteArrayInputStream(preDoc.getBytes());

      //ByteArrayInputStream entrada = new ByteArrayInputStream(xmlFrom.getBytes());
      Document docSalida = docBuild.parse(entrada);
      entrada = null;

      return docSalida;
   }

   /**
    * Devuelve un <code>Document</code> a partir de un <code>java.io.File</code>
    * que debe ser un <strong>xml bien formado</strong>.
    *
    * @param xmlFrom <code>java.io.File</code> representando un <strong>xml bien formado</strong>.
    * @return org.w3c.dom.Document conteniendo el xml del parametro
    * @throw java.lang.Exception
    */
   public Document makeDocument(File xmlFrom) throws Exception {
      Document docSalida = docBuild.parse(xmlFrom);

      return docSalida;
   }

   /**
    * Devuelve un <code>Document</code> a partir de un <code>java.io.ByteArrayInputStream</code>
    * que debe ser un <strong>xml bien formado</strong>.
    *
    * @param xmlFrom <code>java.io.ByteArrayInputStream</code> representando un <strong>xml bien formado</strong>.
    * @return org.w3c.dom.Document conteniendo el xml del parametro
    * @throw java.lang.Exception
    */
   public Document makeDocument(ByteArrayInputStream xmlFrom)
      throws Exception {
      Document docSalida = docBuild.parse(xmlFrom);

      return docSalida;
   }

   /**
    * Devuelve un <code>Element</code> a partir de un <code>java.lang.String</code>
    * que debe ser un <strong>xml bien formado</strong>.
    *
    * @param xmlFrom <code>java.lang.String</code> representando un <strong>xml bien formado</strong>.
    * @return <code>org.w3c.dom.Element</code> conteniendo el xml del parametro
    * @throw java.lang.Exception
    */
   public Element makeElement(String xmlFrom) throws Exception {
      return this.makeDocument(xmlFrom).getDocumentElement();
   }

   /**
    * Devuelve un <code>Element</code> a partir de un <code>java.io.File</code>
    * que debe ser un <strong>xml bien formado</strong>.
    *
    * @param xmlFrom <code>java.io.File</code> representando un <strong>xml bien formado</strong>.
    * @return <code>org.w3c.dom.Element</code> conteniendo el xml del parametro
    * @throw java.lang.Exception
    */
   public Element makeElement(File xmlFrom) throws Exception {
      return this.makeDocument(xmlFrom).getDocumentElement();
   }

   /**
    * Devuelve un <code>Element</code> a partir de un <code>java.io.ByteArrayInputStream</code>
    * que debe ser un <strong>xml bien formado</strong>.
    *
    * @param xmlFrom <code>java.io.ByteArrayInputStream</code> representando un <strong>xml bien formado</strong>.
    * @return <code>org.w3c.dom.Element</code> conteniendo el xml del parametro
    * @throw java.lang.Exception
    */
   public Element makeElement(ByteArrayInputStream xmlFrom)
      throws Exception {
      return this.makeDocument(xmlFrom).getDocumentElement();
   }

   public String getStringFromElement(Element source) throws Exception {
      ByteArrayOutputStream streamSalida = new ByteArrayOutputStream();
      XSLTFactory xslFact = new XSLTFactory();
      Transformer transformer = xslFact.getTransformer();
      transformer.setOutputProperty("encoding", "ISO-8859-1");

      DOMSource entrada = new DOMSource(source);
      StreamResult salida = new StreamResult(streamSalida);
      transformer.transform(entrada, salida);

      StringBuffer buf = new StringBuffer();
      buf.append(streamSalida.toString("UTF-8"));

      return buf.toString();
   }
}
