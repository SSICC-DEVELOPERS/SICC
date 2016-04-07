//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.men.DTOElementoMenu;
import es.indra.sicc.dtos.men.DTOFuncionMenu;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.lang.reflect.*;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LPElementoMenu extends LPSICCBase {
  String accion="";
	private String nombreLogica = "LPElementoMenu";
	protected boolean throwsException = true;
  protected boolean correctInvokation = false;
	private boolean getCfgMenu = true;

  public void inicio() throws Exception { setTrazaFichero(); }

  public void ejecucion() throws Exception {
    traza("************** Entre a LPElementoMenu");
    traza("************** Entre a ejecucion");
    try{	
      this.beforeActionExecute();
			if (this.accion.equals("")) { 
        rastreo();
				this.accion = "defaultAction";
			}
			this.correctInvokation = true;
			this.invokeAction();
      this.afterActionExecute();			
		}
    catch (Exception ex){
			traza(ex);
			if (this.accion.equals("defaultAction")) 
				this.accion = "";
			else	
				this.preservaHid();
		    if (this.throwsException)	{
          this.lanzarPaginaError(ex);
        }   
        else 
          throw ex;
    }
  }

  protected void beforeActionExecute() throws Exception {
    traza("************** Entre a beforeActionExecute");
    this.accion = conectorParametroLimpia("accion","",true); 
    traza("************** accion " + accion);
	}

  public String replaceBlanc(String s) throws Exception {
    traza("************** Entre a replaceBlanc");
    String result=s;
		StringTokenizer st = new  StringTokenizer(s);
		if (st.hasMoreTokens())
      result = st.nextToken();
		while (st.hasMoreTokens())
			result = result+"_" +st.nextToken();
    traza("************** result " + result);
		return result;	
	}

  protected void invokeAction() throws Exception{
    traza("************** Entre a invokeAction");
    try {			
			Method actionMethod =  this.getClass().getMethod(this.replaceBlanc(this.accion),null); //obtengo el metodo a ejecutar 
		  actionMethod.invoke(this,null); //invocamos al metodo!	
		}
		catch ( NoSuchMethodException nme) { 
			throw nme;
		} 
		catch ( IllegalAccessException iae) {			
			throw iae;
		} 
		catch ( IllegalArgumentException iaE) { 
			throw  iaE;
		}
		catch ( InvocationTargetException ite)	{ 
      throw  new MareException(ite.getTargetException());//pra evitar el cast
		}
    finally { 
		  this.correctInvokation = false;
		}		
	}

  public void defaultAction() throws Exception {
    traza("************** Entre a defaultAction");
		this.pagina("contenido_jerarquia_seleccionar");
		this.buildTree();		
	}

  private void  buildTree() throws Exception{
    traza("************** Entre a buildTree");
		//Creamos un DTOBoolean con el pais y el idioma del usuario
    //En el atributo resultado ponemos true 
    //(queremos que aparezcan las funciones finales). 
		DTOBoolean dtoBoolean = this.buildDTOBoolean(true);
		DruidaConector DConector = this.conectar("ConectorObjeto",buildParams(dtoBoolean,"MENCargaSeleccionMenu"));
		DTOElementoMenu dtoElemMenu = (DTOElementoMenu)DConector.objeto("DTOSalida");
		String usuario = (String)conectorParametroSesion("DruidaUsuario");
		String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		dtoElemMenu.setUsuario(usuario);
		dtoElemMenu.setPassword(contrasenia);
		this.buildTree(dtoElemMenu);
	}

  private DTOBoolean buildDTOBoolean(boolean bul) throws Exception {
    traza("************** Entre a buildDTOBoolean"); 
		DTOBoolean dtoBoolean = new DTOBoolean();		
		dtoBoolean.setOidPais(UtilidadesSession.getPais(this));
		dtoBoolean.setOidIdioma(UtilidadesSession.getIdioma(this));		 
		dtoBoolean.setValor(bul);
		return dtoBoolean;
	}

  protected Vector buildParams(IMareDTO dto,String strBsId) throws Exception {
    traza("************** Entre a buildParams - IMareDTO");
    traza("************** dto " + dto);
    Vector params = new Vector();
		params.add(dto);
		params.add(new MareBusinessID(strBsId));
		return params;
	}

  protected Vector buildParams(MareDTO dto,String strBsId) throws Exception {
    traza("************** Entre a buildParams - MareDTO");
		Vector params = new Vector();
		params.add(dto);
		params.add(new MareBusinessID(strBsId));
    return params;		
	}

  private void buildTree(DTOElementoMenu dtoElementoMenu) throws Exception {
    traza("************** Entre a buildTree");
    DruidaDOMObjeto miObj = new DruidaDOMObjeto();
		Document document = this.getXML();
		Element element = document.createElement("ARBOL");
		miObj.setXML(element);
		this.setAttr2ArbolTag(element,dtoElementoMenu.getOid().toString()); 
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

		element.setAttribute("padreSeleccionable", "S");
		element.setAttribute("dobleClickAbre", "S");


    elementAux.setAttribute("onclick", "miFuncionArbol(name1,p1,p2,p4,soypadre);");
		element.appendChild(elementAux);
		this.addBranches( dtoElementoMenu.getHijos(),elementAux);
		DruidaConector drd = new DruidaConector();
		drd.setXML(miObj.getXML());    
		asignar("REJILLA", "RArbol", drd);
	}

  private void setAttr2ArbolTag(Element element,String oid) throws Exception{
    traza("************** Entre a setAttr2ArbolTag");
    element.setAttribute("padreSeleccionable","S");
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
			if (hijo.getHijos().length==0)
        this.addElement(hijo,element,"HOJA", "2");
 			  else 	  {
          Element elementAux = this.addElement(hijo,element,"RAMA", "1");
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
		elementAux.setAttribute("codigo", hijo.getOid().toString());// el oid va al codigo
		elementAux.setAttribute("texto", hijo.getNombre());	

    if((hijo.getFuncionFinal().booleanValue()==false)) {       
      elementAux.setAttribute("onclick", "miFuncionArbol(name1,p1,p2,p4,soypadre);");
    }
    else {
      elementAux.setAttribute("onclick", "returnFalse();");
    }    
    
		element.appendChild(elementAux);
		return elementAux;
	}
  
	public void insertar() throws Exception{
    traza("************** Entre a insertar");
		//si accion = "insertar" La pantalla asociada es InsertarElementoMenu 
		this.pagina("contenido_elemento_menu_insertar");
		//Guardamos el parametro "seleccionada" en el campo oculto "padre" 
		String seleccionado = this.conectorParametroLimpia("seleccionado","",true);
		this.asignarAtributo("VAR","padre","valor",seleccionado);
		this.asignarAtributo("VAR","hidRastreo","valor","I");
		this.asignarAtributo("VAR","hidNivel","valor","I");
		this.anyadeHiddensI18N(true, "MEN_FUNCI", null, new Integer(1), "frmFormulario", "txtNombreElementoMenu", false);
	}
	
	public void guardar () throws Exception { 
    traza("************** Entre a guardar");
		this.pagina("salidaGenerica");
		//si accion = "guardar"  Creamos un DTOFuncionMenu 
		DTOFuncionMenu dtoFM = new DTOFuncionMenu();
		String usuario = (String)conectorParametroSesion("DruidaUsuario");
		String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		dtoFM.setUsuario(usuario);
		dtoFM.setPassword(contrasenia);
		//con los campos de la pantalla (INSERTAR ?) 
    Boolean	nivel =  new Boolean(this.conectorParametroLimpia("hidNivel","",true).equals("S"));


    //*********************************************************************
    String niv = conectorParametroLimpia("hidNivel","",true);
    traza("************** hidNivel " + niv);
    String eje = conectorParametroLimpia("hidEjecutable","",true);
    traza("************** hidEjecutable " + eje);
    String pad = conectorParametroLimpia("padre","",true);
    traza("************** padre " + pad);
    String ras = conectorParametroLimpia("hidRastreo","",true);
    traza("************** hidRastreo " + ras);
    String o = conectorParametroLimpia("oid","",true);
    traza("************** oid " + o);
    //*********************************************************************    

		dtoFM.setNivel(nivel);
		//con la siguiente consideracion especial: 
		//Si rellenamos el atributo nivel a false entonces programa va a null. 
		if (nivel.booleanValue())
			dtoFM.setProgramaEjecutable(this.conectorParametroLimpia("hidEjecutable","",true));
		else
 			dtoFM.setProgramaEjecutable(null);

		//Si no hemos recibido el oid dejamos el atributo a null. 		
		dtoFM.setPadre(new Long(this.conectorParametroLimpia("padre","",true)));

		dtoFM.setRastreo(new Boolean(this.conectorParametroLimpia("hidRastreo","",true).equals("S")));
	
		//Llamamos al ConectorGuardar pasandole el dto y el idbusiness "MENGuardarElementoMenu" 
		//this.anyadeHiddensI18N(false, "MEN_FUNCI", null, new Integer(1), "frmFormulario", "txtNombreElementoMenu", false);
		
		Vector victor = recuperaTraduccionesI18N(new Integer(1));
		if (victor == null) 
      victor = new Vector();
		
		dtoFM.setAttriTraducible(victor);
		
		if (!("".equals(this.conectorParametroLimpia("oid","",true))))
      dtoFM.setOid(new Long (this.conectorParametroLimpia("oid","",true)));
      
		this.conectar("ConectorGuardar",this.buildParams(dtoFM,"MENGuardarElementoMenu"));
	
		this.asignarAtributo("VAR","cerrarVentana"," valor","true");
		this.getCfgMenu = false;
		asignarAtributo("VAR","ejecutar","valor","retorna();");
	}
	
	private DTOOID buildDTOOID()throws MareException{
		DTOOID dtoOid = new DTOOID();
		//-Con el oid recibido creamos un DTOOID (además del pais y el idioma) 
		dtoOid.setOid(new Long(this.conectorParametroLimpia("oid","0",true)));
		dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
		dtoOid.setOidPais(UtilidadesSession.getPais(this));		
		return dtoOid;
	}

	public void consultar() throws Exception { 
    traza("************** Entre a consultar");
		//si accion = "consultar" La pantalla asociada es InsertarElementoMenu 
		this.pagina("contenido_elemento_menu_insertar");
		//-Todos los campos de la pantalla estará desabilitados 
		this.asignarAtributo("VAR","esConsulta","valor","true");
    //-Con el oid recibido creamos un DTOOID (además del pais y el idioma) 
		DTOOID dtoOid = this.buildDTOOID();
		//-Llamamos al ConectorObjeto con el dto creado y el idBusiness "MENConsultaElementoMenu". 
		DruidaConector dc = (DruidaConector)this.conectar("ConectorObjeto",this.buildParams(dtoOid,"MENConsultaElementoMenu"));
		DTOFuncionMenu dtofn = (DTOFuncionMenu)dc.objeto("DTOSalida");
		//-Con DTOFuncionMenu obtenido rellenamos los campos de la pantalla"); 
		this.fillPage(dtofn);
	}
	
	private void fillPage(DTOFuncionMenu dtofn) throws Exception{	
    traza("************** Entre a fillPage");
	 	this.asignarAtributo("VAR","seleccionado","valor",dtofn.getOid().toString());
	 	//this.asignarAtributo("VAR","nivel_padre","valor",conectorParametroLimpia("nivel_padre","",true));
		this.asignarAtributo("VAR","hidRastreo","valor",getBooleanAsString(dtofn.getRastreo()));
		this.asignarAtributo("VAR","hidNivel","valor",getBooleanAsString(dtofn.getNivel()));		
		this.anyadeHiddensI18N(true, "MEN_FUNCI", dtofn.getOid(), new Integer(1), "frmFormulario", "txtNombreElementoMenu", false);		
		this.asignar("CTEXTO","txtNombreElementoMenu",getTrad(dtofn));
		if (dtofn.getNivel().booleanValue())
      traza("************** Entro al primer if");
			if (dtofn.getProgramaEjecutable() != null){
        traza("************** Entro al segundo if");
				this.asignarAtributo("VAR","hidEjecutable","valor",dtofn.getProgramaEjecutable());
        traza("************** Despues de setear hidEjecutable");
			}	
	}
  
	private String getTrad(DTOFuncionMenu dto) throws Exception{
    traza("************** Entre a getTrad");
    Iterator iterator = dto.getAttriTraducible().iterator(); 
    Long idioma = UtilidadesSession.getIdioma(this);
	  BigDecimal idioma2;
	  //traza(idioma);
	  Vector v=null;
	  while (iterator.hasNext()){
      v = (Vector) iterator.next();
 			idioma2 =  (BigDecimal )v.get(0);
			if ( idioma.longValue()==idioma2.longValue()  )	{
        return  (String) v.get(1);
			}
		}
		return "";
	}
	
	private String getBooleanAsString(Boolean aBoolean){
		if ((aBoolean != null) && aBoolean.booleanValue())
			return "S";
		return "N";	
	}
	
	public void modificar () throws Exception { 
    traza("************** Entre a modificar");
		//si accion = "modificar" -La pantalla asociada es ModificarElementoMenu 
		this.pagina("contenido_elemento_menu_modificar");
		//-Con el oid recibido creamos un DTOOID (además del pais y el idioma) 
		DTOOID dtoOid = this.buildDTOOID();
    //	dtoOid.setOid(new Long(1482));
		//-Llamamos al ConectorObjeto con el dto creado y el idBusiness "MENConsultaElementoMenu". 
		DruidaConector dc =this.conectar("ConectorObjeto",this.buildParams(dtoOid,"MENConsultaElementoMenu"));
		DTOFuncionMenu dtoFuncionMenu = (DTOFuncionMenu) dc.objeto("DTOSalida");
		//-Con DTOFuncionMenu obtenido rellenamos los campos de la pantalla 

		this.fillPage(dtoFuncionMenu);
		//-El oid recibido lo guardamos en el campo oculto oid. 
	 	this.asignarAtributo("VAR","oid","valor",dtoFuncionMenu.getOid().toString());
	 	this.asignarAtributo("VAR","padre","valor",conectorParametroLimpia("padre","",true));
		this.asignarAtributo("VAR","tieneHijos","valor",conectorParametroLimpia("tieneHijos","",true));
		this.buildTree();
	}

	private void preservaHid()throws Exception {
    traza("************** Entre a preservaHid");
		try  {
			this.preservaHiddensI18n(new Integer(1), "MEN_FUNCI", "frmFormulario", "txtNombreElementoMenu", false);	
		}
    catch (Exception ex)  {
		} 
    finally  {
		}		
	}

  protected void afterActionExecute() throws Exception {
    traza("************** Entre a afterActionExecute");
    this.asignarAtributo("VAR", "conectorAction", "valor",this.nombreLogica);

		if (this.accion.equals("defaultAction")) {
      this.accion = "";
			this.asignarAtributoPagina("cod","048");
		}

		if (this.accion.equals("insertar"))
      this.asignarAtributoPagina("cod","048");
			else 
        if (this.accion.equals("consultar"))
          this.asignarAtributoPagina("cod","05");
				else
					if (this.accion.equals("modificar"))
            this.asignarAtributoPagina("cod","029");
	  if (this.getCfgMenu)
      this.getConfiguracionMenu(this.nombreLogica,this.accion);			   
	}
}
