
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.men.DTOCargaPerfil;
import es.indra.sicc.dtos.men.DTOElementoMenu;
import es.indra.sicc.dtos.men.DTOPerfil;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.*;

import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LPPerfiles extends LPSICCBase {
	private static final String PARAMETRO_PERFIL = "perfil";
	private static final String CREAR = "insertar";
	private static final String MODIFICAR = "modificar";  
	private String casoUso = null;
  private String accion = null;
  private MareBusinessID businessID = null;
  private Long oidPais = null;
  private Long oidIdioma = null;
  private boolean evenArbol;

  public LPPerfiles() { super(); }

  public void inicio() throws Exception {	}

  public void ejecucion() throws Exception {      
    try {
      setTrazaFichero();

      casoUso = conectorParametro("casoUso");
      accion = conectorParametro("accion");
 	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  
      if(casoUso==null) casoUso = "";
      if(accion==null) accion = "";
      

      cargarVariablesDeSesion();
              
      if(accion.equals("")) {
	    rastreo();
        pagina("contenido_perfil_usuario_insertar");
        cargarMenuSecundario();
        carga(null); 
        asignarAtributo("VAR","casoUso","valor",CREAR);
        casoUso = CREAR;        
      }

      if(accion.equals("buscar")) {
        pagina("contenido_perfil_usuario_modificar");
        cargarMenuSecundario();
        asignarAtributo("VAR","casoUso","valor",casoUso);
        asignarAtributo("VAR","usuario","valor",usuario);
        asignarAtributo("VAR","contrasenia","valor",contrasenia);
      }     

      if(accion.equals("copiar")) {
        pagina("contenido_perfil_usuario_insertar");
        cargarMenuSecundario();

        String copia = conectorParametro("varCopiar");
        if(copia==null) copia = "";
        asignarAtributo("VAR","varCopiar","valor",copia);
        
        String copPerfil = conectorParametro("varPerfil");
        if(copPerfil==null) copPerfil = "";    
        carga(copPerfil);      
        
        asignarAtributo("VAR","casoUso","valor",CREAR);
        asignarAtributo("VAR","varNombre","valor",copPerfil);        
        casoUso = CREAR;
      }      

      if(accion.equals("modificar")) {
        pagina("contenido_perfil_usuario_insertar");
        cargarMenuSecundario();
        String modPerfil = conectorParametro("varPerfil");
        if(modPerfil==null) modPerfil = "";       
        carga(modPerfil);
        asignarAtributo("VAR","casoUso","valor",MODIFICAR);            
        asignarAtributo("VAR","varNombre","valor",modPerfil);        
      }      

      if(accion.equals("consultar")) {
        pagina("contenido_perfil_usuario_insertar");
        cargarMenuSecundario();
        String conPerfil = conectorParametro("varPerfil");  //PRUEBA
        if(conPerfil==null) conPerfil = "";       
        carga(conPerfil,false);   
        asignarAtributo("VAR","casoUso","valor",casoUso);
        asignarAtributo("VAR","varNombre","valor",conPerfil);
        asignarAtributo("LISTAEDITABLE","listado1","y","95");
        asignarAtributo("BOTON","prim1","y","375");
        asignarAtributo("BOTON","separa1","y","371");
        asignarAtributo("CAPA","capaEspacio","y","394");
        asignarAtributo("PAGINADO","mipgndo","y","371");
        asignarAtributo("BOTON","ret1","y","375");
        asignarAtributo("BOTON","ava1","y","375");
      }

      if(accion.equals("guardar")) {



		pagina("salidaGenerica");
		//pagina("contenido_perfil_usuario_insertar");		
		
		if(casoUso.equals("insertar")) {
		  //pagina("salidaGenerica");
		  businessID = new MareBusinessID("MENCrearPerfil");
        } 

        if(casoUso.equals("modificar")) {
          //pagina("contenido_perfil_usuario_insertar");
		  businessID = new MareBusinessID("MENModificarPerfil");
        }

        String valorCopia = conectorParametro("varCopiar");
        DTOPerfil dtoPerfil = new DTOPerfil();
      
        String nombre = conectorParametro("varNombre");        
        String strFunciones = conectorParametro("funciones");
        String strInicio = conectorParametro("inicio");
        
        if(!strInicio.equals("null")) {
          Long inicio = new Long(strInicio);    
          dtoPerfil.setInicio(inicio);
        }

       
        StringTokenizer st1 = new StringTokenizer(strFunciones,",");
        int longitud = st1.countTokens();
        Long[] funciones = new Long[longitud];
        
        int i=0;
        while(st1.hasMoreTokens()) {
          Long elementoI = new Long(st1.nextToken());
          funciones[i] = elementoI;
          i++;
        }        

		dtoPerfil.setUsuario(usuario);
		dtoPerfil.setPassword(contrasenia);

        dtoPerfil.setNombre(nombre);
        dtoPerfil.setFunciones(funciones);
        
        Vector parametros = new Vector();
        parametros.add(dtoPerfil);
      	parametros.add(businessID);

        DruidaConector con = conectar("ConectorGuardar", parametros);
/*        asignarAtributo("VAR","casoUso","valor",casoUso);
        asignarAtributo("VAR","varExitoInserta","valor","Exito");
        asignarAtributo("VAR","varExitoModifica","valor","Exito");  
        asignarAtributo("VAR","varCopiar","valor",valorCopia);*/
        //Despues de insertar volvemos a recargar el arbol si estamos insertando
        if(casoUso.equals("insertar")) {
		  asignarAtributo("VAR","ejecutar","valor","reInicio()");
        } else {
		  asignarAtributo("VAR","ejecutar","valor","window.close();");
      } 
	  
    }
	//traza(this.getXML().getDocumentElement());
    } catch(Exception ex) {
/*      asignarAtributo("VAR","casoUso","valor",casoUso);
      carga(null);      */
	  traza(ex);
      lanzarPaginaError(ex);
    }
  }

    //Este metodo setea variables de sesion
    private void cargarVariablesDeSesion() throws Exception {
      oidIdioma = UtilidadesSession.getIdioma(this);
      oidPais = UtilidadesSession.getPais(this);    
    }

    //Este metodo setea el titulo y los iconos del menu secundario dependiendo la accion y el caso de uso
    private void cargarMenuSecundario() throws Exception {    
      if (accion.equals("")) {      
        getConfiguracionMenu("LPPerfiles","");            
      }
    
      else if (accion.equals("buscar")) {      
        if(casoUso.equals("modificar")) {       
          getConfiguracionMenu("LPPerfiles","modificar");  
        }
        else if(casoUso.equals("eliminar")) {       
          getConfiguracionMenu("LPPerfiles","eliminar");
          asignarAtributoPagina("cod","054");
        }
        else if(casoUso.equals("consultar")) {       
          getConfiguracionMenu("LPPerfiles","consultar");
          asignarAtributoPagina("cod","053");
        }
        else if(casoUso.equals("copiar")) {       
          getConfiguracionMenu("LPPerfiles","copiar");
          asignarAtributoPagina("cod","045");
        }      
      }

      else if(accion.equals("copiar")) {
        getConfiguracionMenu("LPPerfiles","copiarMostrar");
        asignarAtributoPagina("cod","045");      
      }    

      else if(accion.equals("consultar")) {
        getConfiguracionMenu("LPPerfiles","consultarMostrar");
        asignarAtributoPagina("cod","053");      
      }

      else if (accion.equals("modificar")) {       
          getConfiguracionMenu("LPPerfiles","mostrar");
          asignarAtributoPagina("cod","052");     
      }   
    }

    private void carga(String perfil) throws Exception {    		
      boolean eventos = true;
      carga(perfil,eventos);
    }

    private void carga(String perfil, boolean eventosArbol) throws Exception {          
      evenArbol = eventosArbol;
    
      MareBusinessID bussID = new MareBusinessID("MENCargaPerfil");
      DTOString dto = new DTOString();  

	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
	  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  dto.setUsuario(usuario);
	  dto.setPassword(contrasenia);

      dto.setValor(perfil);
      dto.setOidIdioma(oidIdioma);
      dto.setOidPais(oidPais);

      Vector parametros = new Vector();
      parametros.add(dto);
      parametros.add(bussID);

      DruidaConector con = conectar("ConectorRecuperaDatosPantallas", parametros);    
	  DTOCargaPerfil dtoCarga = (DTOCargaPerfil)con.objeto("dtoSalida");
      RecordSet rsFunciones = dtoCarga.getFunciones();   
      asignar("LISTADOA", "listado1", UtilidadesBelcorp.generarConector("dtoSalida.resultado_ROWSET",rsFunciones,rsFunciones.getColumnIdentifiers()),"dtoSalida.resultado_ROWSET");
      DTOElementoMenu dtoElemen = dtoCarga.getArbol();

      buildTree(dtoElemen);    
    }

    private String getPerfil() throws Exception {
      return PARAMETRO_PERFIL;
    }

    private void buildTree(DTOElementoMenu dtoElementoMenu) throws Exception {
	  DruidaDOMObjeto miObj = new DruidaDOMObjeto();
	  Document document = this.getXML();	
	  Element element = document.createElement("ARBOL");
	  miObj.setXML(element);
      //en el atributo menu creamos el nodo raiz, poniendo como código el oid y como nombre el atributo nombre    
	  this.setAttr2ArbolTag(element,dtoElementoMenu.getOid().toString());	
      //element.setAttribute("texto",+dtoElementoMenu.getNombre());
      //LLamamos a getHijos y obtenemos un array de DTOElementoMenu 
	  Element elementAux = this.getXML().createElement("RAMA");
	  elementAux.setAttribute("nombre", "root");
      //elementAux.setAttribute("icono", "");
	  elementAux.setAttribute("codigo", "root");
	  elementAux.setAttribute("texto", "/");      
      //elementAux.setAttribute("onClick", "seleccionadaToVar()");
	  element.appendChild(elementAux);
		  this.addBranches( dtoElementoMenu.getHijos(),elementAux);	
	  DruidaConector drd = new DruidaConector();
	  drd.setXML(miObj.getXML());      
      asignar("REJILLA", "RArbol", drd);
    }

    private void setAttr2ArbolTag(Element element,String oid) throws Exception {
		element.setAttribute("x","22" ) ;
		element.setAttribute("y", "37");      
		element.setAttribute("nombre", "name"+oid);
		asignarAtributo("VAR","nombreArbol","valor","name"+oid);
		element.setAttribute("codigo", oid);
		element.setAttribute("id", "menu");
		element.setAttribute("ancho", "400"); 
		element.setAttribute("alto", "210");
		element.setAttribute("multisel", "S");
		//element.setAttribute("oncolor", "#D0D9E8");
		element.setAttribute("overcolor", "#D0D9E8");      
		element.setAttribute("incx", "5");
		element.setAttribute("incy", "5");
		element.setAttribute("visibilidad", "");
		this.addIconos(element);       
    }

    private void addIconos(Element element) throws Exception {
			Element elementAux = this.getXML().createElement("ICONOS");
			element.appendChild(elementAux);
			element = this.getXML().createElement("ICONO");			
      element.setAttribute("src", "b.gif"); //<ICONO src="b.gif"/>
      elementAux.appendChild(element);			
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "flechaMenuVert.gif"); //<ICONO src="flechaMenuVert.gif"/>
		  elementAux.appendChild(element);			
			element = this.getXML().createElement("ICONO");
      element.setAttribute("src", "flechaMenuHorz.gif"); //<ICONO src="flechaMenuHorz.gif"/>
		  elementAux.appendChild(element);
    }

    private void addBranches(DTOElementoMenu [] hijos,Element element) throws Exception {
      DTOElementoMenu hijo;
      for (int i =0;i<hijos.length;i++){
        //	Por cada uno de ellos añadimos un rama que depende del raiz, de la misma manera. 
			  hijo =  hijos [i];
			  if (hijo.getHijos().length<=0)
  				  this.addElement(hijo,element,"HOJA",new Integer(2));
 			  else 	  {
				  Element elementAux = this.addElement(hijo,element,"RAMA",new Integer(1));
				  this.addBranches(hijo.getHijos(),elementAux);
			  }
        //Continuamos con cada rama recursivamente hasta que llegamos a un elemento 
        //que no tiene hijos (nos devuelve un array con 0 elementos. 
      }
    }    

    private Element addElement(DTOElementoMenu hijo,Element element,String tag, Integer icono) throws Exception {
      Element elementAux; 
      elementAux = this.getXML().createElement(tag);
      elementAux.setAttribute("nombre", "name"+hijo.getOid().toString());      
      elementAux.setAttribute("icono", icono.toString());      
      elementAux.setAttribute("codigo", hijo.getOid().toString());// el oid va al codigo
      elementAux.setAttribute("texto", hijo.getNombre());
      if((hijo.getFuncionFinal().booleanValue()==true) && (evenArbol==true)) {       
        elementAux.setAttribute("onclick", "seleccionarFuncion(\\'" + hijo.getOid() + "\\', \\'" + hijo.getNombre() + "\\');");
      }      		
      element.appendChild(elementAux);
      return elementAux;
    }



}
