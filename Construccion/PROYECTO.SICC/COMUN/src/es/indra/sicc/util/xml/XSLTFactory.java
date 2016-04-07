package es.indra.sicc.util.xml;

import es.indra.sicc.util.xml.IXSLTFactory;

import java.io.ByteArrayInputStream;
import java.io.File;

import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;


/**
 * <code>class XSLTFactory</code>.
 * Provee la funcionalidad basica
 * para la obtencion de un <code>Transformer</code>
 * a partir de distintos objetos. Posibles extensiones: agregar objetos
 * de los cuales obtener el <code>Transformer</code>.
 * <p>
 * @author    Software Factory Argentina <strong>INDRA SI S.A</strong>
 * @version   1.0
 */
public class XSLTFactory implements IXSLTFactory {
   private TransformerFactory transFactory;

   /**
    * Unico constructor de la clase, aqui se instancia el
    * <code>TransformerFactory</code> a utilizar en los distintos métodos
    */
   public XSLTFactory() throws Exception {
      //se inicializa la instancia  del factory de xsl
      transFactory = TransformerFactory.newInstance();
   }

   ///////////////////////////////////////////////////////////////////////
   ///  método sobrecargado para obtener la instancia del Transformer  ///
   ///  a partir de los diferentes tipos de entrada.                   ///
   ///////////////////////////////////////////////////////////////////////

   /**
    * Devuelve un <code>Transformer</code> sin Template XSL asociado.
    *
    * @return javax.xml.transform.Transformer
    * @throw java.lang.Exception
    */
   public Transformer getTransformer() throws Exception {
      return transFactory.newTransformer();
   }

   /**
    * Devuelve un <code>Transformer</code> con un Template XSL asociado, que
    * viene indicado por el parámetro del método
    *
    * @return javax.xml.transform.Transformer
    * @throw java.lang.Exception
    */
   public Transformer getTransformer(String xslSource)
      throws Exception {
      StringBuffer buf = new StringBuffer();
      buf.append(xslSource);

      String preString = buf.toString();

      /*StreamSource xsltSource = new StreamSource(new ByteArrayInputStream(
                  xslSource.getBytes("UTF-8")));*/
      StreamSource xsltSource = new StreamSource(new ByteArrayInputStream(
               preString.getBytes()));

      Templates templates = transFactory.newTemplates(xsltSource);

      //transformerfactory.newTemplates(streamsource);
      return templates.newTransformer();
   }

   /**
    * Devuelve un <code>Transformer</code> con un Template XSL asociado, que
    * viene indicado por el parámetro del método
    *
    * @return javax.xml.transform.Transformer
    * @throw java.lang.Exception
    */
   public Transformer getTransformer(ByteArrayInputStream xslSource)
      throws Exception {
      StreamSource xsltSource = new StreamSource(xslSource);

      return transFactory.newTransformer(xsltSource);
   }

   /**
    * Devuelve un <code>Transformer</code> con un Template XSL asociado, que
    * viene indicado por el parámetro del método
    *
    * @return javax.xml.transform.Transformer
    * @throw java.lang.Exception
    */
   public Transformer getTransformer(File xslSource) throws Exception {
      StreamSource xsltSource = new StreamSource(xslSource);

      return transFactory.newTransformer(xsltSource);
   }

   ///////////////////////////////////////////////////////////////////////
   ///////////////////////////////////////////////////////////////////////
}
