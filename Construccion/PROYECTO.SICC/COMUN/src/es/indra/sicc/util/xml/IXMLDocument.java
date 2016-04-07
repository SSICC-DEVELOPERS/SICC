package es.indra.sicc.util.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.io.File;


/**
 * Interface <code>IXMLDocument</code>.
 * Interface a implementar para los motores de XML
 * @autor     Software Factory Argentina (INDRA SI S.A)
 * @version   1.0
 */
public interface IXMLDocument {
   public abstract Document makeDocument(String xmlFrom)
      throws Exception;

   public abstract Document makeDocument(File xmlFrom)
      throws Exception;

   public abstract Document makeDocument(ByteArrayInputStream xmlFrom)
      throws Exception;

   public abstract Element makeElement(String xmlFrom)
      throws Exception;

   public abstract Element makeElement(File xmlFrom) throws Exception;

   public abstract Element makeElement(ByteArrayInputStream xmlFrom)
      throws Exception;

   public abstract String getStringFromElement(Element source)
      throws Exception;
}
