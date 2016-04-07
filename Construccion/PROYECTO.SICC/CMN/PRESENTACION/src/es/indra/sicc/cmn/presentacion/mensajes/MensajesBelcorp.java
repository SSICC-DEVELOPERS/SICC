package es.indra.sicc.cmn.presentacion.mensajes;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


/**
 * @author gacevedo
 */
public class MensajesBelcorp {
	// tabla hash que almacena los mensajes
	private static HashMap hashIdiomas = null;

	// Método que traduce los literales
	public static String sicc_mensaje(String idioma, String codigo) throws Exception {
		String salida = "";
		if ( hashIdiomas == null ) {
			MensajesBelcorp.sicc_CargaMensajes();
		}
		
		HashMap tmp = (HashMap)hashIdiomas.get( idioma );
		if (tmp != null){
			if( tmp.get(codigo) != null ){
				salida = (String) tmp.get(codigo);
			}
		}
		return salida;
   }

	   // Método que genera la tabla de mensajes
	public static synchronized void sicc_CargaMensajes() throws Exception {
		if ( hashIdiomas != null ) {
			return;
		}
		hashIdiomas = new HashMap();

		//Obtenemos el documento con los mensajes
		DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
		docBuildFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = docBuildFactory.newDocumentBuilder();

		InputStream inStream = docBuilder.getClass().getClassLoader().getResourceAsStream("mensajes.xml");
		
		Document docMensajes = (Document) docBuilder.parse(inStream);

		// Obtenemos todos los idiomas
		NodeList listIdiomas = docMensajes.getElementsByTagName( "IDIOMA" );
		int countIdiomas = listIdiomas.getLength();
		for ( int i = 0 ; i<countIdiomas ; i++ ) {
			String strIdiomaActual = ( (Element) listIdiomas.item(i)).getAttribute( "xml:lang" );
			// cada idioma sera un hash dentro del hash principal
			// identificado por el idioma
			HashMap hashIdioma = new HashMap();
			NodeList listMensajes = ( (Element) listIdiomas.item(i)).getElementsByTagName( "MENSAJE" );
			int countMensajes = listMensajes.getLength();
			for ( int j = 0 ; j<countMensajes ; j++ ) {
				String strCodigo=( (Element) listMensajes.item(j)).getAttribute( "codigo" );
				String strMensaje=(listMensajes.item(j).getFirstChild() != null) ? ((Text)( (Element) listMensajes.item(j)).getFirstChild()).getNodeValue() : "";
				if (strCodigo!=null) {
					hashIdioma.put( strCodigo , strMensaje );
				}
			}
			hashIdiomas.put( strIdiomaActual , hashIdioma );
			hashIdioma = null;
		}
	}
	
}
