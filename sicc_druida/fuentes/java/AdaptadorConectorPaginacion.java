

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import es.indra.druida.DruidaConector;

/** 
 * <p>Title: SICC</p>
 * <p>Description: Esta clase de utilizad adapta los conectores existentes
 * para funcionar con el subsistema de paginado</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros Gonz�lez
 * @version 1.0
 */
class AdaptadorConectorPaginacion {	
	private static final String NOMBRE_ROWSET = "dtoSalida.resultado";
	private static final String CAMPO_INDICE = "OIDPAG"; //El nombre estandar del campo indice
	
	private DruidaConector conector; //El conector que vamos a manipular
	private int pageSize;		//El tama�o de la p�gina
	private Element element;   //El XML del conector, es lo que vamos a cambiar
	private short posicion;
	
	/**
	 * Es el �nico constructor y recibe todo lo que necesita: el conector a manipular,
	 *  el tama�o de la p�gina para calcular si es la �ltima y la posicion del campo 
	 *  que act�a de �ndice
	 * @param druidaConector
	 * @param pageSize
	 * @param posicion
	 */
	AdaptadorConectorPaginacion(DruidaConector druidaConector, int pageSize, short posicion) {
		conector = druidaConector;
		this.pageSize = pageSize;
		element = conector.getXML();
		this.posicion = posicion;
	}
	
	/**
	 * Devuelve el conector resultante de hacer las trasformaciones necesarias
	 * sobre el conector que se recibi� al construir el objeto.
	 * @return DruidaConector
	 */
	public DruidaConector obtenerConectorPaginacion() {		
        Node node = obtenerRowSet();
        if(node == null)
            return conector;
        if(!rowsetVacio(node))
            cambiarNombreIndice();
        agregarCampoFinal();
        cambiarNombreRowset(node);
        recubrirRowset(node);
        conector.setXML(element);
        return conector;
	}
	

    private boolean rowsetVacio(Node node)
    {
        Node node1 = node.getFirstChild();
        return node1 == null;
    }	
	
	/**
	 * Cambia el nombre del campo de indice para estandarizarlo
	 */
	private void cambiarNombreIndice() {
		  String nombreCampo = obtenerCampoIndice(posicion);
 		 //Cambiamos el nombre que tenga el primer campo a OID, si es necesario
		  if (!nombreCampo.equals(CAMPO_INDICE)) {
			  NodeList lista = element.getElementsByTagName("CAMPO");
			  Node atribute = null;
			  for (int i = 0; i < lista.getLength(); i++) {
				  atribute = lista.item(i).getAttributes().getNamedItem("NOMBRE");
				  //Si tienen el nombre de oid que hemos encontrado los cambiamos
				  if (atribute.getNodeValue().equals(nombreCampo)) {
					  atribute.setNodeValue(CAMPO_INDICE);
				  }			
			  }
		  }
	}

	/**
	 * Obtiene el nombre del campo que act�a como indice, obteniendo el que est� en la 
	 *  posicion indicada
	 * @param index
	 * @return String
	 */
	private String obtenerCampoIndice(short index) {
		  NodeList lista = element.getFirstChild().getFirstChild().getChildNodes();
		  NamedNodeMap atts = lista.item(index).getAttributes();
		  Node atributo = atts.getNamedItem("NOMBRE"); 
		  return atributo.getNodeValue();
	}

	/**
	 * A�ade el campo que le indica a Druida si hay m�s p�ginas. Para saber si
	 * hay m�s p�ginas miramos si se ha llenado la p�gina actual, si es as�
	 * suponemos que hay m�s.
	 */
	private void agregarCampoFinal() {		
		//Ahora creamos el campo que indica si hay m�s elementos
		Document documento = element.getOwnerDocument();
		Element campo = documento.createElement("CAMPO");
		campo.setAttribute("NOMBRE", "HAY_MAS");
		campo.setAttribute("TIPO", "STRING");
		campo.setAttribute("LONGITUD", "5");
		
		String paginaLlena = String.valueOf(estaLlena());
		Text text = documento.createTextNode(paginaLlena);
		campo.appendChild(text);
		
		//A�adimos el campo
		element.appendChild(campo);		
	}
	
	/**
	 * Indica si hemos recibido al menos tantas filas de resultados como el
	 * tama�o de p�gina que se indic� en el constructor
	 * @return boolean
	 */
	private boolean estaLlena() {
		//Comprobemos si la pagina est� llena, ya que est� indicar� que hay m�s p�ginas
		NodeList filas = element.getElementsByTagName("ROW");
		return(filas.getLength() >= pageSize);
	}
	
	/**
	 * Cambiamos el nombre del rowset indicado para que sea siempre igual.
	 * @param rowset
	 */
	private void cambiarNombreRowset(Node rowset){
				Node idRow = rowset.getAttributes().getNamedItem("ID");		
		idRow.setNodeValue(NOMBRE_ROWSET);		
	}
	
	/**
	 * Obtiene el nodo que contiene el Rowset, suponiendo que s�lo hay uno (es
	 * uno de los requisitos del subsistema
	 * @return Node
	 */
	private Node obtenerRowSet(){
		NodeList lista = element.getElementsByTagName("ROWSET");
		return lista.item(0);		
	}
	
	/**
	 * Envuelve el rowset indicado en otro rowset (es necesario para que
	 * concuerde con el tramado definido en el conector)
	 * @param rowset
	 */
	private void recubrirRowset(Node rowset) {		
		  Element wrapper = element.getOwnerDocument().createElement("ROWSET");
		  wrapper.setAttribute("NOMBRE", "WRAPPER");

		//El wrapper cuelga directamente del nodo raiz
		  element.appendChild(wrapper);
		
		  wrapper.appendChild(rowset);		
	}

}
