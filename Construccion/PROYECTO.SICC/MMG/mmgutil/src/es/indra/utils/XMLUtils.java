/*
 * Created on 18-feb-2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class XMLUtils {
	/**
	 * El factory para los documentos builder
	 */
	protected static DocumentBuilderFactory builderFactory = null;
	
	/**
	 * EL builder para el parseo de documentos
	 */
	protected static DocumentBuilder builder = null;
	
	/**
	 * El factory para los transformer
	 */
	protected static TransformerFactory transformerFactory = null; 

	/**
	 * Nos permite obtener el factory para generar los builder;
	 * @return
	 */
	public static DocumentBuilderFactory getBuilderFactory() {
		if(builderFactory == null) builderFactory = builderFactory.newInstance();
		return builderFactory;
	}
	

	/**
	 * Nos perite obtener el builder para realizar el parseo de documentos
	 * @return El builder para el parseo de documentos
	 */
	public static DocumentBuilder getBuilder() throws ParserConfigurationException{
		if(builder == null) builder = getBuilderFactory().newDocumentBuilder();
		return builder;
	}
	
	/**
	 * Nos permite obtener el factory para los transformer
	 * @return
	 */
	public static TransformerFactory getTransformerFactory() {
		if(transformerFactory == null) transformerFactory = transformerFactory.newInstance();
		return transformerFactory;
	}
	
	/**
	 * Aplica las transformaciones indicadas al documento dom pasdo como parámetro
	 * @param document El documento DOM original a aplicacr
	 * @param xsls Las hojas de transformación  a aplicar
	 * @return El resultado de aplicar todas las hojas de transformación
	 * @throws ParserConfigurationException Si hay algún errore en la configuración del parser
	 * @throws TransformerConfigurationException Si hay algún  error en la configuración del transformador
	 * @throws TransformerException Si se produce algún error a la hora de aplicar las transformaciones
	 */
	public static Document applyTransformations(Document document, String[] xsls) 
		throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
		DocumentBuilder builder = getBuilderFactory().newDocumentBuilder();
		DOMSource source = new DOMSource(document);
		DOMResult result = null;
			
		//Nos vamos recorriendo todas las hojas de transformación y las vamos aplicacando
		for (int i = 0; i < xsls.length; i++) {
			result = new DOMResult(builder.newDocument());
			getTransformerFactory().newTransformer(new StreamSource(
			   new File(xsls[i]))).transform(source, result);
			
			//El resultado de la transformación se convierte en la fuente de la siguiente iteración
			source = new DOMSource(result.getNode());
		}
		
		//Finalmnete devolvemos el resultado
		return (Document)result.getNode();
	}
	
	/**
	 * Nso permite convertir un elmento dom a un string
	 * @param node El elemento dom que se desea convertir a String
	 * @return
	 */
	public static String serializeNode(Node node) throws TransformerConfigurationException, TransformerException{
		StringWriter writer = new StringWriter();
		DOMSource source = new DOMSource(node);
		StreamResult result = new StreamResult(writer);
 		getTransformerFactory().newTransformer().transform(source, result);
 		return writer.toString();
	}
	
	/**
	 * Parse un documento
	 * @return objeto Document con el fichero xml
	 * @exception IOException Si el fichero no existe
	 * @exception ParserConfigurationException Si hay alguna error en la configuración del parser
	 * @exception SAXException Si se produce algún error al realizar el parsse del fichero xml
	 */
	public static Document parseFile(String file) throws SAXException, IOException, ParserConfigurationException{
		return getBuilder().parse(new File(file));
	}
	
	/**
	 * Nos permite hacer el marshall de un objeto
	 * @param obj El objets el cual vamos a pasar a xml
	 * @return el documnet que representa el objeto
	 * @throws ParserConfigurationException
	 * @throws ValidationException
	 * @throws MarshalException
	 */
	public static Document marshal(Object obj) throws ParserConfigurationException, 
		ValidationException, MarshalException{
		//COnvertimos el INFORME a documento xml
		Document xml = getBuilderFactory().newDocumentBuilder().newDocument();
		Marshaller.marshal(obj, xml);
		return xml;
	}
	
	/**
	 * Permite realizar la operación de unmarshal (de fichero xml)
	 * @param file Ruta del fichero con la definición xml
	 * @param className La clase a la cual se va  a realizar el unmarshal
	 * @return El objeto tras realizar la operación de unmarshal
	 */
	public static Object unmarshal(String file, Class className) 
		throws MarshalException, ValidationException, ParserConfigurationException, 
		SAXException, IOException{
		return Unmarshaller.unmarshal(className, parseFile(file));
	}


}
