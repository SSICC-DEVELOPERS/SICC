//import LPSICCBase;
//Druida
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

//MGU
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.exception.*;
import es.indra.sicc.mgu.UserIDSICC;
import es.indra.mare.common.mgu.manager.UserIDImpl ;

//Logica NEgocio
import es.indra.mare.common.mln.MareBusinessID;

//Varios
import java.util.Vector;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.StringTokenizer;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

/* By Jalem - 26/01/2004
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream ;
import java.util.Stack;
import es.indra.mare.common.dto.MareDTO;

//MEN
//import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;
//import es.indra.sicc.dtos.men.DTOEntradaSeleccionarFuncionesFavoritas;
//import es.indra.sicc.dtos.men.DTOSalidaSeleccionarFuncionesFavoritas;
//import es.indra.sicc.dtos.men.DTOSalidaFunciones;
import es.indra.sicc.dtos.men.DTOCargaFavoritos;
import es.indra.sicc.dtos.men.DTOElementoMenu;
import es.indra.sicc.dtos.men.DTOFavoritos;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
//import es.indra.sicc.dtos.men.DTOString;

//import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.math.BigDecimal;
import java.util.Vector;
import es.indra.sicc.util.DTOSalida;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.DOMException;

public class LPSeleccionarFuncionesFavoritas extends LPSICCBase {

  private int nextRow = 1;
  private RecordSet favo = new RecordSet(); 
  
	private static String ACTION_GUARDAR = "Guardar";
	private static String ACTION_SINACCION = "";
	private static String ACCION = "accion";
	private static String FUNCIONES_SELECCIONADAS= "hidSeleccionados";
	private static String FUNCIONES_DESMARCADAS= "funciones_desmarcadas";
	private static String CADENA_NULA = "";
  private static String ARRAYLISTA = "elemPrimColumn";

  private  String nombreLogica="LPSeleccionarFuncionesFavoritas";   
  
	public void inicio() throws Exception { 
		pagina("contenido_favoritos_seleccionar"); 
		asignarAtributoPagina("cod", "043");
		
	}
/*
si accion =" 
Si se produce un error se devuelve una excepción indicando el error que se ha producido.
*/
	public void ejecucion() throws Exception {
		try{
			setTrazaFichero();
			rastreo();			 		
			asignarAtributoPagina("cod", "043");


			String sAccion = conectorParametroLimpia( ACCION, CADENA_NULA, true);	
	        getConfiguracionMenu(this.nombreLogica, sAccion);

			if ( sAccion.equals( ACTION_SINACCION ) ){
                func_no_action();         //cargo arbol y favoritos de usuario
			}
			else if ( sAccion.equals( ACTION_GUARDAR ) ){
				f_accion_guardar( conectorParametroLimpia( ARRAYLISTA, CADENA_NULA, true));
			}
		}
		catch(Exception th){
			traza(th);
            this.lanzarPaginaError(th);  
		}
	}
  
  private void func_no_action() throws Exception {
      Vector params = new Vector();
      DTOBelcorp dtoe = new DTOBelcorp();
      
      dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoe.setOidPais(UtilidadesSession.getPais(this));
      
      params.add(dtoe);
      params.add(new MareBusinessID("MENCargaInicialFavoritos"));
      DruidaConector conectorFunciones = conectar("ConectorCargaInicialFavoritos", params);
      
      DTOCargaFavoritos dto = (DTOCargaFavoritos)conectorFunciones.objeto("DTOCargaFavoritos");

      favo = (RecordSet)dto.getFavoritos();
      DTOElementoMenu albol = (DTOElementoMenu)dto.getArbol();
      
      this.crearArbol(albol);
   
  }

  private void crearArbol(DTOElementoMenu dtoElementoMenu) throws Exception{
    	DruidaDOMObjeto miObj = new DruidaDOMObjeto();
		  Document document = this.getXML();
      
		  Element element = document.createElement("ARBOL");
		  miObj.setXML(element);
      
  		this.setAttr2MenuTag(element,dtoElementoMenu.getOid().toString());
      	
		  Element elementAux = this.getXML().createElement("RAMA");

		  elementAux.setAttribute("nombre", "Menu");
		  elementAux.setAttribute("icono", "");
 		  elementAux.setAttribute("codigo", "root");
		  elementAux.setAttribute("texto", "/");
		  element.appendChild(elementAux);
		  this.addBranches( dtoElementoMenu.getHijos(),elementAux);
  		DruidaConector drd = new DruidaConector();
      
	  	drd.setXML(miObj.getXML());

   		asignar("REJILLA", "RArbol", drd);

      // Se conecta y asignar a la lista de Favoritos del ñato que se loggeo. 
      DruidaConector conFavo = this.generarConectorLista("rowsetFavo", favo, favo.getColumnIdentifiers());
      asignar("LISTADOA", "listado1", conFavo, "rowsetFavo");
  }

  private Element addElement(DTOElementoMenu hijo,Element element,String tag, String icono) throws Exception{
		Element elementAux;
		elementAux = this.getXML().createElement(tag);
		elementAux.setAttribute("nombre", "name"+hijo.getOid().toString());
		elementAux.setAttribute("icono", icono);
		elementAux.setAttribute("codigo", hijo.getOid().toString());
		elementAux.setAttribute("texto", hijo.getNombre());
    
    if (hijo.getFuncionFinal().booleanValue())
     elementAux.setAttribute("onclick", "funcionOnClick(\\'" + hijo.getOid() + "\\', \\'" + hijo.getNombre() + "\\');");
     
		element.appendChild(elementAux);
		return elementAux;
	}

	private void addBranches(DTOElementoMenu [] hijos,Element element) throws Exception{
		DTOElementoMenu hijo;
		for (int i =0;i<hijos.length;i++){
			 //	Por cada uno de ellos añadimos un rama que depende del raiz, de la misma manera. 
			  hijo =  hijos [i];
			  if (hijo.getHijos().length<=0) {
  				  this.addElement(hijo, element, "HOJA", "2");
        } else {
				  Element elementAux = this.addElement(hijo, element, "RAMA", "1");
				  this.addBranches(hijo.getHijos(),elementAux);
			  }
		}
	}

	private void setAttr2MenuTag(Element element,String oid) throws Exception{
		element.setAttribute("x","1" ) ;
		element.setAttribute("y", "1");
		element.setAttribute("nombre", "name"+oid);
		element.setAttribute("id", "menu");
		element.setAttribute("ancho", "400"); 
		element.setAttribute("alto", "210");
		element.setAttribute("multisel", "S");
		element.setAttribute("incx", "5");
		element.setAttribute("incy", "5");
		element.setAttribute("visibilidad", "");
		//element.setAttribute("oncolor", "#D0D9E8");
		element.setAttribute("overcolor", "#D0D9E8");      

	 	this.addIconos(element);
	}
  
	private void addIconos(Element element) throws Exception{
			Element elementAux = this.getXML().createElement("ICONOS");
			element.appendChild(elementAux);
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "b.gif");
      elementAux.appendChild(element);
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "flechaMenuVert.gif");
	    elementAux.appendChild(element);
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "flechaMenuHorz.gif");
      elementAux.appendChild(element);
	}

  private void f_accion_guardar( String arrayFinal) throws Exception {

    try {

      //String logicaDeInicio; 
      StringTokenizer stkFavoUsua = new StringTokenizer( arrayFinal, "," );
      Long[] vecFavoAPersistir = new Long[stkFavoUsua.countTokens()];
      DTOFavoritos favo = new DTOFavoritos(); 
      int i = 0;
      while (  stkFavoUsua.hasMoreTokens() ) {
        String s = stkFavoUsua.nextToken().toString();

        vecFavoAPersistir[i]=new Long(s);
        i++;
      }
    
      favo.setFavoritos(vecFavoAPersistir);

      Vector params = new Vector();

	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  favo.setUsuario(usuario);
	  favo.setPassword(contrasenia);	
      favo.setOidIdioma(UtilidadesSession.getIdioma(this));
      favo.setOidPais(UtilidadesSession.getPais(this));
      favo.setIpCliente(UtilidadesBelcorp.getIPCliente( this) );
      favo.setPrograma(UtilidadesSession.getFuncion( this ) );
      params.add(favo);
     
      params.add(new MareBusinessID("MENSeleccionarFuncionesFavoritas"));
      DruidaConector conectorFunciones = conectar("ConectorObjeto", params);

      pagina("contenido_favoritos_seleccionar");
      asignarAtributo("VAR", "grabo", "valor", "a");
      
    }
		catch(Exception th){
      this.lanzarPaginaError(th);
    }
    
  }
  
private DruidaConector generarConectorLista(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception
	{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
    
		if ( columns == null ){
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();		
		
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++)
		{
    
			Element e_row = docDestino.createElement("ROW");
      e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(  columsDesc.elementAt(j)) ){
				
				//------------------------------------------------------------
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt0);
					e_row.appendChild(e_campo2);
				}
			}
		}	

    conectorValoresPosibles.setXML(docDestino.getDocumentElement());
    return conectorValoresPosibles;

	}

}
