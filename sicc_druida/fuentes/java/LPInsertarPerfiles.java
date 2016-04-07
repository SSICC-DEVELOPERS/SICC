/*
    INDRA/CAR/sicc
    $Id: LPInsertarPerfiles.java,v 1.1 2009/12/03 18:34:58 pecbazalar Exp $
    Logica de Presentacion de insercion de Perfiles
*/

/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos 
 * reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de 
 * Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
//import LPSICCBase;
//import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;


import java.util.Vector;
import java.lang.reflect.InvocationTargetException;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.men.DTOEntradaInsertarPerfiles;
import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.util.StringTokenizer;


// Definicion de la clase
public class LPInsertarPerfiles extends LPSICCBase 
{

	private String accion="";
	private static final String LP_NAME="LPInsertarPerfiles";
	String nombreFunciones = null;
	String nombreInicio = null;
	String perfil = null;

    // Definicion del constructor
    public LPInsertarPerfiles() {super();}


    // Definicion del metodo abstracto inicio
        public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_perfil_usuario_insertar");
		asignarAtributoPagina("cod", "051");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception{

		try{
				this.rastreo();
				setTrazaFichero();
				accion = conectorParametroLimpia("accion","",true);				
				nombreFunciones = conectorParametroLimpia("pSelectedFunc","",true);
				nombreInicio = conectorParametroLimpia("pSelectedView","",true);
				perfil = conectorParametroLimpia("txtPerfil","",true);	


				if( accion.equals("") ){					
					cargarDatos("",nombreFunciones,nombreInicio);
				}
				
				if ( accion.equals("insertar")){
					insertarPerfil();
				}	

		}catch(Exception e){
			lanzarPaginaError(e);
			 asignarAtributo("VAR","conectorAction", "valor", LP_NAME);
 			 asignarAtributo("VAR","pSelectedView","valor",nombreInicio);
			 asignarAtributo("VAR","pSelectedFunc","valor",nombreFunciones);
			 asignarAtributo("CTEXTO","txtPerfil","valor",perfil);
		}

		getConfiguracionMenu();
    }
	
	private void insertarPerfil()
			throws MareException,Exception
	{
    traza("Método insertarPerfil");
		DTOEntradaInsertarPerfiles dtoe = null;
		String bussinessID = "MENInsertarPerfil";
		String conectorName = "ConectorMantenimientoPerfiles";

		MareBusinessID id = null;
		DruidaConector cBusqueda = null;
		Vector paramConsultarFunciones = new Vector();

		id = new MareBusinessID(bussinessID);	
		dtoe = new DTOEntradaInsertarPerfiles();
	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
	    String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		dtoe.setUsuario(usuario);
		dtoe.setPassword(contrasenia);
		

		cargarDTOE(dtoe);
    traza("dtoe: " + dtoe.toString() );
		paramConsultarFunciones.add(dtoe);
		paramConsultarFunciones.add(id);

    traza("Antes de conectar");
		cBusqueda = conectar(conectorName,paramConsultarFunciones);	
    traza("Despues de conectar");
		this.cargarDatos("","","");
		//this.cargarDatos("100","","");
	}

	private void cargarDTOE(DTOEntradaInsertarPerfiles dtoe)
			throws Exception
	{
		traza("Método cargarDTOE");
		Vector vLista = new Vector();

		if ( perfil !=null && perfil.length() > 0	 )
		{			
			 
			 StringTokenizer st = new StringTokenizer(nombreFunciones,"|");
       String sBuffer = null;
       traza("Cant. elementos: " + st.countTokens() );
			 while(st.hasMoreElements())
			 {
          // Quita el "_" (viene "_nn")
          sBuffer = (String) st.nextElement();
          sBuffer = sBuffer.substring(1, sBuffer.length());
          traza("sBuffer: " + sBuffer);
          vLista.add(sBuffer);
			 }
       traza("Valor de vLista: " + vLista.toString() );

       // Quita el "_" (viene "_nn")
       if (nombreInicio != null && !nombreInicio.equals("") )
         nombreInicio = nombreInicio.substring(1, nombreInicio.length() );  

			 dtoe.setListaDeFuncionesAcciones(vLista);
			 dtoe.setNombreDePerfil(perfil);
			 dtoe.setPantallaInicioDeAplicacionAsociada(nombreInicio);
       dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

			 return;
		}

		throw new Exception("ERR_98");
	}

	private void cargarDatos(String salida, String IdFuncsToLoad, String IdInicio) 
		throws MareException, Exception
	{
    traza("metodo cargarDatos");
		String conectorName = "ConectorConsultarFuncionesFinales";
		String mareBussinessId = "MENConsultaFunciones";
		String plantillaXsl = "XslOrdenaFuncionesFinales"; 
		Vector vIdFs = null;
		Vector vFunciones = null;		
		Vector paramConsultarFunciones = new Vector();
		Vector vFuncionesResult = new Vector();
		DTOEntradaPresentarMenu dtoe = null;
		DruidaConector cBusqueda = null;
		DruidaConector cResult   = null;
		MareBusinessID id = null;

		dtoe = new DTOEntradaPresentarMenu();
	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
	    String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		dtoe.setUsuario(usuario);
		dtoe.setPassword(contrasenia);
		
		id   = new MareBusinessID(mareBussinessId);		
		paramConsultarFunciones.addElement(dtoe);
		paramConsultarFunciones.addElement(id);
    dtoe.setOidIdioma( UtilidadesSession.getIdioma(this) );
    traza("Antes de conectar");
		cBusqueda = conectar(conectorName,paramConsultarFunciones);
    traza("Despues de conectar");

	asignar(	"REJILLA", "contenidoDinamico", transformar("XslMantenimientoPerfilesInsertar", cBusqueda) );
    //traza("cBusqueda: " + cBusqueda.getXML() );
/*
		if ( cBusqueda == null){		
			throw new Exception("ERR_93");
		}
		traza("Antes de transformar");
		cResult = transformar(plantillaXsl,cBusqueda);
		traza("Despues de transformar");
    //cResult = cBusqueda;
    //traza("cResult: " + cResult.getXML() );
    //cResult = cBusqueda;
		if ( cResult == null ){
			throw new Exception("ERR_94");
		}		
    traza("Antes de asignar Vectores");
    
		vFunciones = valorVector("nombrefuncion",cResult);
		vIdFs	   = valorVector("idfuncion",cResult);

		if ( vFunciones == null || vFunciones.size() == 0 
				|| vIdFs == null || vIdFs.size() == 0 ){
				throw new Exception("ERR_95");
		}
    //traza("vFunciones: " + vFunciones.toString() );    
    //traza("vIdFs: " + vIdFs.toString() );        
//		generarPagina(vFunciones,vIdFs,IdFuncsToLoad,IdInicio);
		
		if ( salida !=null && salida.length() > 0)
		{
			asignarAtributo("VAR","mensaje","valor",salida);
		}*/

	}


/*	private void generarPagina(Vector vFunciones,Vector vIdFs, String IdFunci, String IdInicio)
		throws Exception
	{


       traza("Método generarPagina");
		DruidaDOMObjeto tr=null;
		DruidaDOMObjeto td=null;
		DruidaDOMObjeto label=null;
		DruidaDOMObjeto check=null;
		String funtionName=null;
		//int size = vFunciones.size();
		int size=50;

    traza("Tamanio de vFunciones: " + vFunciones.size() );
		int i=0;
		String checkInicio="N";
		String checkFunc = "N";
	
		if ( IdFunci.length() > 0 ){
			 asignarAtributo("VAR","pSelectedView","valor",IdInicio);
			 asignarAtributo("VAR","pSelectedFunc","valor",IdFunci);
		}

		//Construye al tabla dinamica.
		for(i=0;i<size;i++){
          traza("Bucle " + i);
          //traza("IDF(" + i + "): " + (String) vIdFs.elementAt(i) );
          //traza("Funcion(" + i +"): " + (String) vFunciones.elementAt(i) );
          
					tr = crearTR("TRTitulo"+i, "", "", "");
          //traza(tr.getXML() );
					asignar("TABLA","nombre","tblFunciones",tr);
					tr = null;
          
					td = crearTD("TdTituloNombre"+i,"datosCamposLeftImpar","567","","","middle","");
          //traza(td.getXML() );
					asignar("TR","nombre","TRTitulo"+i,td);
					td=null;
          
					label = crearLABELC("labelCTitulo"+i, "567", "20", "1","Funcion "+i, "datosCamposCenterImpar");
          //traza(label.getXML() );
					asignar("TD","nombre","TdTituloNombre"+i,label);
					label=null;
          
					td = crearTD("TdTituloAsignada"+i,"datosCamposCenterPar","155","","","middle","");
          //traza( td.getXML() );
					asignar("TR","nombre","TRTitulo"+i,td);
					td=null;

					checkFunc=( (IdFunci.indexOf((String)vIdFs.elementAt(i)) >= 0) ? "S" : "N");
					check = crearCHECKBOX((String) "_" + vIdFs.elementAt(i),"",checkFunc,"","N","","mostrar(\'"+(String) "_" + vIdFs.elementAt(i)+"\');","");
					//check = crearCHECKBOX((String)vIdFs.elementAt(i),"",checkFunc,"","N","","mostrar("+(String)vIdFs.elementAt(i)+");","");
          //traza( check.getXML() );
					asignar("TD","nombre","TdTituloAsignada"+i,check);
					check=null;
          
					td = crearTD("TdTituloInicio"+i,"datosCamposCenterImpar","105","","","middle","");
          //traza(td.getXML() );
					asignar("TR","nombre","TRTitulo"+i,td);
					td=null;					

					checkInicio=(IdInicio.equals((String)vIdFs.elementAt(i)) ? "S" : "N");
					check = crearCHECKBOX((String) "_" + vIdFs.elementAt(i)+"_sel","",checkInicio,"","N","","inicio(\'"+(String) "_" + vIdFs.elementAt(i)+"\');","");
					//check = crearCHECKBOX((String)vIdFs.elementAt(i)+"_sel","",checkInicio,"","N","","inicio("+(String)vIdFs.elementAt(i)+");","");
          //traza( check.getXML() );          
					asignar("TD","nombre","TdTituloInicio"+i,check);
					check=null;
		}

		//carga datos.
		for(i=0;i<size;i++){
			asignarAtributo("LABELC","labelCTitulo"+i,
				"valor",(String)vFunciones.elementAt(i));  
		}
	
		// Focaliza el campo de ingreso de nombre de perfil.
		asignarAtributo("VAR","campoFocaliza","valor","txtPerfil");
	}*/

}


