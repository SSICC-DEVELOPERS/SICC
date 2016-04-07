/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
/*
    INDRA/CAR/PROY
    $Id: LPMantenerI18n.java,v 1.1 2009/12/03 18:33:39 pecbazalar Exp $
    DESC
*/

//import LPSICCBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Collection;
import java.util.Iterator;
import es.indra.sicc.util.DTOSalida;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;

import es.indra.mare.common.mgu.manager.Property;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.presentacion.i18n.I18n;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;

// Definicion de la clase
public class LPMantenerI18n extends LPSICCBase {

	private String accion		= null;
	private String codigoAcceso	= null;
	private String strCasoDeUso = null;

	private String entidad		= null;
	private String oid			= null;
	private String cargado		= null;
	private String recarga		= null;

	private Vector paramEntrada = null; 
	private String mensajeLog	= null;

	private Long idiomaActual	= null;

	MareBusinessID id = null;

    // Definicion del constructor
    public LPMantenerI18n() {
		super();
	}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
		// Defino el nombre de la vista
		pagina("contenido_multiidioma_mantenimiento");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {

		/*
		 * Recibe como argumento (pej: ?entidad='SEG_MONED'&pk=1023&cargar='true') 
		 * - entidad: La entidad de la que se quieren mantener las traducciones (coincide 
		 * 	 con el nombre de la tabla en BD en mayúsculas) 
		 * - oid: El OID de la entidad a mantener. 
		 * - cargar: Si se deben cargar las traducciones o dejar en blanco. 
		 * Además establece en la página ModificarI18N el hidden cargar. 
		 * ejecuta debe además adaptar la página ModificarI18N para que tenga tantos CT como idiomas 
		 * tenga la aplicación la información de cuantos idiomas y sus descripciones las recupera de la clase i18N.
		 */

		accion		 = conectorParametro("accion");
		strCasoDeUso = conectorParametro("hCasoDeUso");
        /*
		entidad  = conectorParametro("hEntidad");
		oid = conectorParametro("hOid");
		cargar = conectorParametro("hCargado");
		*/

		setTrazaFichero();

		accion = (accion==null )?"":accion;
		strCasoDeUso = (strCasoDeUso == null) ? "" : strCasoDeUso;

		try{

			//this.pais   = (UtilidadesSession.getPais(this).toString() == null) ? "" : UtilidadesSession.getPais(this).toString();
/*
			asignarAtributo("VAR","hCasoDeUso","valor",strCasoDeUso);
			asignarAtributo("VAR","hi18NEntidad_","valor",(entidad==null || entidad.length()==0?"":entidad));
			asignarAtributo("VAR","hi18NOID_","valor",(oid==null || oid.length()==0?"":oid));
			asignarAtributo("VAR","hi18NCargar_","valor",(cargar==null || cargar.length()==0?"":cargar));
*/
			if (accion.equals("")){

				//I18n instI18n = I18n.getInstance();
				//conectorAviso(conectorParametro("prueba"));
				//traza(" Entró en accion vacia ... ");
	            idiomaActual = UtilidadesSession.getIdioma(this); 
				Collection idiomas = getIdiomas();
/*
				//Datos para prueba harcodeados
				Idioma idioma = new Idioma();
				idioma.setOid(new Long(1));
				idioma.setDescripcion("Ingles");
				idiomas.add(idioma);
				Idioma idioma2 = new Idioma();
				idioma2.setOid(new Long(2));
				idioma2.setDescripcion("Castellano");
				idiomas.add(idioma2);
				//-----------------------------
*/
				//Collection idiomas = instI18n.getIdiomas();
				//ahora hay que agregarle al pop up que se muestra para mantener los idiomas tantas filas para ingreso de
				//idioma como haya en la tabla (o sea el resultado de idiomas.size())
				crearTabla(idiomas);
				//traza("->->->"+conectorParametroSesion("hEntidad"));
				recuperarTraducciones();

			}
			else if (accion.equals("recupera")){

				recuperarTraducciones();

			}
				//traza("PAGINA");
				//traza(getXML().getDocumentElement());

		}

		catch(Exception e) {
			
            this.logStackTrace(e);
 
            BelcorpError belcorpError = new BelcorpError();

			DTOError dtoError = belcorpError.obtenerError(e);
            
            String strCodigo = "";
            String strDescrip = "";

            asignarAtributo("VAR","hidErrCodigo", "valor", "" + dtoError.getCodigoError());
            asignarAtributo("VAR","hidErrDescripcion", "valor", dtoError.getDescripcionError());
 
            asignarAtributo("VAR","accion", "valor", accion );        
		}
	}

  private void  crearTabla(Collection idiomas) throws Exception{

        DruidaDOMObjeto tr = null;
		DruidaDOMObjeto td = null;
		DruidaDOMObjeto tag = null;
		DruidaDOMObjeto label = null;
		DruidaDOMObjeto caja = null;
		String allOids = new String();

		Iterator itIdiomas = idiomas.iterator();			

		//adapta la página contenido_multiidioma_mantenimiento (ModificarI18N) para que tenga tantos CT como idiomas 
		//tenga la aplicación la información de cuantos idiomas y sus descripciones las recupera de la clase i18N (idiomas.size())

		int cantIdiomas = idiomas.size();

 	 	for(int i=0; i < cantIdiomas; i++) {

			Idioma idioma = (Idioma)itIdiomas.next();

			/* BELC300023337 - DBLG500000805
			 * cdos gPineda 22/06/2006
			 * "Sólo mostrar los idiomas que tengan el ind traducible = true"
			 */
			if( ! idioma.getIndicadorTraducible().booleanValue() ) {
				continue;
			}

			Long oid = idioma.getOid();
			String j = idioma.getDescripcion();

			tr = crearTR("TRTitulo"+ oid, "", "", "");
			//tr.setAtributo( "bgcolor", "#CCCCCC");
			asignar("TABLE","nombre","traducciones",tr);
			tr = null;

				td = crearTD("Tda"+oid,"","12","","","center","");
				asignar("TR","nombre","TRTitulo"+oid,td);
		
					tag = crearTAG("IMG");
					tag.setAtributo( "src", "b.gif");	
					tag.setAtributo( "width", "12");	
					tag.setAtributo( "height", "12");	
					tag.setAtributo( "color", "#CCCCCC");	
					asignar("TD","nombre","Tda"+oid,tag);

				td = crearTD("TdTituloNombre"+oid,"datosCamposLeft","200","","","middle","");
				asignar("TR","nombre","TRTitulo"+oid,td);
				td=null;

					label = crearLABELC("labelCTitulo"+oid, "200", "15","1", "", "datosTitle");
					asignar("TD","nombre","TdTituloNombre"+oid,label);
					asignarAtributo("LABELC","labelCTitulo"+oid,"valor",j);
					label=null;

				tr = crearTR("TRTitulo2"+ oid, "", "", "");
				asignar("TABLE","nombre","traducciones",tr);
				tr=null;
		
					td = crearTD("Td"+oid,"","12","","","center","");
					asignar("TR","nombre","TRTitulo2"+oid,td);
		
						tag = crearTAG("IMG");
						tag.setAtributo( "src", "b.gif");	
						tag.setAtributo( "width", "12");	
						tag.setAtributo( "height", "12");	
						asignar("TD","nombre","Td"+oid,tag);

					td = crearTD("TdTituloAsignada"+oid,"","400","","","middle","");
					asignar("TR","nombre","TRTitulo2"+oid,td);
					td=null;
						
						//Si el idioma es el actual de sesion se pone un label en lugar de text
						caja = crearTEXTAREA("txtTraduccion"+ oid, "", "3", "50", "", "", "", "", "", "");
						caja.getXML().setAttribute("max","400");
						//caja = crearCaja("txtTraduccion" + oid ,"", "3", "2", "", "", "", "", "", "");
						//if(i == 0) //caja.setAtributo("onshtab","focaliza('frmPagosFraccionadosInsertar.txtNroCuotas');");			
						//caja.setAtributo("ontab","focaliza('frmMantenimientoMultiidioma.txtTraduccion" + siguiente + "');");
						//traza("Oid "+oid+" Actual "+idiomaActual);
						if (oid.equals(idiomaActual))
						{
							traza("paso");

							//caja = crearLABELC("txtTraduccion"+ oid, "200", "25", "2", "", "");
						}						
						asignar("TD","nombre","TdTituloAsignada"+oid,caja);
						caja=null;

					td = crearTD("TdTituloAsig"+oid,"datosCamposCenterPar","400","","","middle","");
					asignar("TR","nombre","TRTitulo"+oid,td);
					td=null;
				td = crearTD("Tdb"+oid,"","12","","","center","");
				asignar("TR","nombre","TRTitulo"+oid,td);
		
					tag = crearTAG("IMG");
					tag.setAtributo( "src", "b.gif");	
					tag.setAtributo( "width", "12");	
					tag.setAtributo( "height", "12");	
					asignar("TD","nombre","Tdb"+oid,tag);
			allOids = allOids + oid + "|";
		}
		td = crearTD("Tdc"+oid,"","12","","","center","");
		asignar("TABLE","nombre","traducciones",td);
		
					tag = crearTAG("IMG");
					tag.setAtributo( "src", "b.gif");	
					tag.setAtributo( "width", "12");	
					tag.setAtributo( "height", "12");	
					asignar("TD","nombre","Tdc"+oid,tag);

         asignarAtributo("VAR","hAllOidsIdiomas", "valor", "" + allOids);


		/*
		for(int i=0;i<cantIdiomas;i++){
			Idioma idioma = itIdiomas.next();
			String j = idioma.getDescripcion;
			asignarAtributo("LABELC","labelCTitulo"+i,
				"valor",j);
		}*/ 
  }

 private void recuperarTraducciones() throws Exception{

	String nroatrib = null;
	/*
	traza("a--1-->"+conectorParametro("nroAtrib"));
	traza("--2---->"+conectorParametroSesion("hEntidad_"+conectorParametroSesion("hNroAtrib")));
	traza("--3---->"+conectorParametroSesion("hOid_"+conectorParametroSesion("hNroAtrib")));
	traza("--4---->"+conectorParametroSesion("hCargado_"+conectorParametroSesion("hNroAtrib")));*/
	//traza("Entro en recuperarTraducciones()");

	nroatrib = conectorParametro("nroAtrib");
	recarga = conectorParametro("hi18NCargado");
	entidad = (String)conectorParametroSesion("hEntidad_"+nroatrib);
	oid = conectorParametroSesion("hOid_"+nroatrib).toString();
	cargado = (String)conectorParametroSesion("hCargado_"+nroatrib);

	Long idiomaActual = UtilidadesSession.getIdioma(this); 

	//traza("b--1-->"+nroatrib);
	//traza("--2---->"+entidad);
	//traza("--3---->"+oid);
	//traza("--4---->"+cargado);

/*	//si limpio los valores luego cuando se vuelve a abrir el pop up no trae nada
	conectorParametroSesion("hEntidad_"+nroatrib,"");
	conectorParametroSesion("hOid_"+nroatrib,"");
	conectorParametroSesion("hCargado_"+nroatrib,"");
	conectorParametroSesion("hNroAtrib","");

	traza("c--1-->"+conectorParametroSesion("hNroAtrib"));
	traza("--2---->"+conectorParametroSesion("hEntidad_1"));
	traza("--3---->"+conectorParametroSesion("hOid_1"));
	traza("--4---->"+conectorParametroSesion("hCargado_1"));
*/	 
	MareBusinessID id = new MareBusinessID("CMNRecuperarTraducciones");
	Vector paramEntrada = new Vector();
	//traza("Cargo:"+conectorParametroSesion("cargo_"+nroatrib));
	conectorParametroSesion("cargo_"+nroatrib, "true");
		if (oid!="")
		{
				IMareDTO dtoE = new MareDTO();
				dtoE.addProperty("entidad",entidad);
				dtoE.addProperty("pk",new Long(oid));//oid deberia ser Long
				paramEntrada.add(dtoE);
				paramEntrada.add(id);
				DruidaConector conectorObjeto = conectar("ConectorObjeto", paramEntrada);

				DTOSalida dto = (DTOSalida)conectorObjeto.objeto("DTOSalida");
				RecordSet traducciones = (RecordSet)dto.getResultado();

				//traza("aaaaaaaa 2 cant trad:"+traducciones.getRowCount());
				String strOids = new String();
				for (int i=0; i<traducciones.getRowCount();i++){
					Long oidIdioma = new Long(((BigDecimal)traducciones.getValueAt(i,0)).longValue());
					String traduccion = (String)traducciones.getValueAt(i,1);
					//traza("-cargado:"+cargado);
					//traza("-recarga:"+recarga);
					
					if(((cargado.equals("true"))||(recarga.equals("true")))&&(!(idiomaActual.equals(oidIdioma)))&&(!traduccion.equals(" "))){
							asignarAtributo("AREATEXTO","txtTraduccion"+oidIdioma, "valor", "" +traduccion);
							//traza("valor "+i+":"+traduccion);
					}



					strOids = strOids + oidIdioma + "|";
				}
				asignarAtributo("VAR","hOidsIdiomas", "valor", "" + strOids);
		 }
		if(cargado.equals("true")){
			//traza("aaaaaaaa 3");
			conectorParametroSesion("hCargado_"+nroatrib, ""+new Boolean(false));// para que no recargue si vuelve a llamar 
			// porque pisaria los cambios hechos por el usuario
			//asignarAtributo("VAR","hCargado", "valor", "" + new Boolean(true));
			asignarAtributo("VAR","hRecupera", "valor", "" + new Boolean(false));
		} else {
			//traza("aaaaaaaa 4");
			asignarAtributo("VAR","hRecupera", "valor", "" + new Boolean(true));
		}
		if (recarga.equals("true"))
		{
			asignarAtributo("VAR","hRecupera", "valor", "" + new Boolean(false));
		}
 }

 private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
 
		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
      
		if (e instanceof MareException) {
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
 }
}
