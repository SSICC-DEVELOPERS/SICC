
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.men.DTOElementoMenu;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LPSeleccionarElementoMenu extends LPSICCBase {
  String accion="";
  String casoDeUso;
  private String nombreLogica="LPSeleccionarElementoMenu";  
    
  public void inicio() throws Exception {
    pagina("contenido_jerarquia_seleccionar");
    this.setTrazaFichero();
  }

  public void ejecucion() throws Exception {
    traza("************** Entre a LPSeleccionarElementoMenu");
    traza("************** Entre a ejecucion");
    try{	
      //Mostramos únicamente el botón correspondiente, los otros están dehabilitados.
      rastreo();			
      this.beforeActionExecute();

      //Creamos un DTOBoolean con el pais y el idioma del usuario,
      //en el atributo resultado ponemos true (queremos que aparezcan las funciones finales). 
      DTOBoolean dtoBoolean = this.buildDTOBoolean(true);
      //Llamamos al ConectorObjeto con el dto y el idBusiness "MENCargaSeleccionMenu", obtenemos un DTOElementoMenu 
      DruidaConector DConector = this.conectar("ConectorObjeto",buildParams(dtoBoolean,"MENCargaSeleccionMenu"));
      //Ahora rellenamos el arbol de funciones Con DTOElementoMenu 	//	
      DTOElementoMenu dtoElemMenu = (DTOElementoMenu)DConector.objeto("DTOSalida");
      this.buildTree(dtoElemMenu);
      this.accion = this.casoDeUso;
      this.getConfiguracionMenu(this.nombreLogica,this.accion);		
    }
    catch (Exception ex){
      this.lanzarPaginaError(ex);
    }
  }

  protected void beforeActionExecute() throws Exception {
    traza("************** Entre a beforeActionExecute");
    this.accion = conectorParametroLimpia("accion","",true);
    asignarAtributo("VAR", "conectorAction", "valor",this.nombreLogica);
  	this.setButtons();
    traza("************** accion " + accion);
  }

  private void setButtons()throws Exception { 
    casoDeUso = conectorParametro("CasoUso");
    asignarAtributo("CAPA", "capaInsertar", "visibilidad", "");
    asignarAtributo("VAR", "CasoUso", "valor", casoDeUso);
    if (this.casoDeUso.equals("Modificar")){
      asignarAtributo("CAPA", "capaModificar", "visibilidad", "visible");
      this.asignarAtributoPagina("cod","029");
    }
    else		
      if (this.casoDeUso.equals("eliminar")){
        //asignarAtributo("CAPA", "capaEliminar", "visibilidad", "visible");
        asignarAtributo("CAPA", "capaInsertar", "visibilidad", "hidden");
        this.asignarAtributoPagina("cod","09");
			}
			else		
        if (this.casoDeUso.equals("Consultar")){
          asignarAtributo("CAPA", "capaConsultar", "visibilidad", "visible");
        this.asignarAtributoPagina("cod","05");
        }
  }

  protected Vector buildParams(MareDTO dto,String strBsId) throws Exception {
    Vector params = new Vector();
		params.add(dto);
		params.add(new MareBusinessID(strBsId));
		return params;
	}

  private DTOBoolean buildDTOBoolean(boolean value) throws Exception { 
		DTOBoolean dtoBoolean = new DTOBoolean();		
		dtoBoolean.setOidPais(UtilidadesSession.getPais(this));
		dtoBoolean.setOidIdioma(UtilidadesSession.getIdioma(this)); 
		dtoBoolean.setValor(value);
		return dtoBoolean;
	}

  private void buildTree(DTOElementoMenu dtoElementoMenu) throws Exception{
    traza("************** Entre a buildTree");
    DruidaDOMObjeto miObj = new DruidaDOMObjeto();
		Document document = this.getXML();
		Element element = document.createElement("ARBOL");
		miObj.setXML(element);
		this.setAttr2MenuTag(element,dtoElementoMenu.getOid().toString());
		Element elementAux = this.getXML().createElement("RAMA");
		elementAux.setAttribute("nombre", "Menu");
    elementAux.setAttribute("codigo", "1");
    elementAux.setAttribute("texto", "/");
		elementAux.setAttribute("icono", "1");
    elementAux.setAttribute("x","1" ) ;
		elementAux.setAttribute("y", "1");
		elementAux.setAttribute("id", "menu");
		elementAux.setAttribute("ancho", "400"); 
		elementAux.setAttribute("alto", "210");
		elementAux.setAttribute("multisel", "S");
		elementAux.setAttribute("incx", "5");
		elementAux.setAttribute("incy", "5");
		elementAux.setAttribute("visibilidad", "");   
    elementAux.setAttribute("onclick", "miFuncionArbol(name1,p1,p2,p4,soypadre);");
		element.appendChild(elementAux);
		this.addBranches( dtoElementoMenu.getHijos(),elementAux);
		DruidaConector drd = new DruidaConector();
		drd.setXML(miObj.getXML());
		asignar("REJILLA", "RArbol", drd);
	}

	private void setAttr2MenuTag(Element element,String oid) throws Exception{
		traza("************** Entre a setAttr2ArbolTag");
		element.setAttribute("padreSeleccionable","S");
		element.setAttribute("dobleClickAbre","S");			//si padre es seleccionable permito abrir con doble click
		element.setAttribute("x","1" ) ;
		element.setAttribute("y", "1");
		element.setAttribute("nombre", "name"+oid);
		this.asignarAtributo("VAR","nombreArbol","valor","name"+oid);
		element.setAttribute("ancho", "400"); 
		element.setAttribute("alto", "210");
		element.setAttribute("codigo", oid);
		element.setAttribute("id", "menu");
		element.setAttribute("multisel", "S");
		element.setAttribute("visibilidad", "");
		element.setAttribute("incx", "5");
		element.setAttribute("incy", "5");				 
		element.setAttribute("oncolor", "#D0D9E8");
		element.setAttribute("overcolor", "#D0D9E8");				
		this.addIconos(element);
	}


  private void addIconos(Element element) throws Exception {
    traza("************** Entre a addIconos");
    //<ICONOS>
		Element elementAux = this.getXML().createElement("ICONOS");
		element.appendChild(elementAux);

    //<ICONO src="b.gif"/>
		element = this.getXML().createElement("ICONO");
		element.setAttribute("src", "b.gif");
		elementAux.appendChild(element);

    //<ICONO src="flechaMenuVert.gif"/>
		element = this.getXML().createElement("ICONO");
		element.setAttribute("src", "flechaMenuVert.gif");
    element.setAttribute("ancho", "5");
    element.setAttribute("alto", "3");
		elementAux.appendChild(element);

    //<ICONO src="flechaMenuHorz.gif"/>
		element = this.getXML().createElement("ICONO");
		element.setAttribute("src", "flechaMenuHorz.gif");
    element.setAttribute("ancho", "3");
    element.setAttribute("alto", "5");
		elementAux.appendChild(element);
	}

  private void addBranches(DTOElementoMenu [] hijos,Element element) throws Exception{
		DTOElementoMenu hijo;
		for (int i =0;i<hijos.length;i++){
      //Por cada uno de ellos añadimos un rama que depende del raiz, de la misma manera. 
			hijo =  hijos [i];
			if (hijo.getHijos().length<=0)
        this.addElement(hijo,element, "HOJA", "2");
        else    {
          Element elementAux = this.addElement(hijo, element, "RAMA", "1");
          this.addBranches(hijo.getHijos(),elementAux);
        }
    //Continuamos con cada rama recursivamente hasta que llegamos a un
    //elemento que no tiene hijos (nos devuelve un array con 0 elementos.
		}
	}

  private Element addElement(DTOElementoMenu hijo,Element element,String tag, String icono) throws Exception{
		Element elementAux; 
		elementAux = this.getXML().createElement(tag);
		elementAux.setAttribute("nombre", "name"+hijo.getOid().toString());
		elementAux.setAttribute("icono", icono);
		elementAux.setAttribute("codigo", hijo.getOid().toString());
		elementAux.setAttribute("texto", hijo.getNombre());
    elementAux.setAttribute("onclick", "miFuncionArbol(name1,p1,p2,p4,soypadre);");    
		element.appendChild(elementAux);
		return elementAux;
	}
}  
