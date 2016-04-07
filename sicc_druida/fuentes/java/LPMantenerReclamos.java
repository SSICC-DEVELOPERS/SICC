/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
  
import es.indra.sicc.dtos.rec.DTOEliminaLineaOperacion;
import es.indra.sicc.dtos.rec.DTOTotalesReclamoREC;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOLineaOperacion; 

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream; 

import java.math.BigDecimal;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import es.indra.sicc.util.Cronometrador;




public class LPMantenerReclamos extends LPSICCBase {
    
	private String accion = null;
	private String casoUso = null;
	private String opcionMenu = null;
	private Long idioma = null;
	private Long pais = null;
	
	public LPMantenerReclamos() {
		super();
	}
	
	public void inicio() throws Exception {
		// Asignar página "contenido_reclamos_buscar"
		pagina("contenido_reclamo_buscar");
	}
	
	/**
	* 08/08/2006 - [1] - pperanzola : se modifica por cambios en performance.-
	*/
	public void ejecucion() throws Exception {
		Cronometrador.startTransaction("LPMantenerReclamos.ejecucion");
		rastreo();
		try {
			
			/*
			Si (accion == "") { 
			-> ejecutar el método privado "cargarPagina()" 
			} 

			Si (accion == "detalleReclamo") { 
			Si (opcion de menu = "consultar") { // El CU buscarReclamos ha sido llamado desde el CU consultarReclamos 
			-> ejecutar el método privado "detalleReclamo()"} 
			Si no { // (opcion de menu = "modificar") El CU buscarReclamos ha sido llamado desde el CU modificarReclamos 
			-> ejecutar el método privado "modificarReclamo()"} 
			} 

			Si accion == "actualizar reclamo" { 
			-> ejecutar metodo privado "actualizarReclamo" 
			}

			*/
			setTrazaFichero(); 
	    	traza("*** Entrada - LPMantenerReclamos - ejecucion ***");
	      		
            
	      	
         	this.pais = UtilidadesSession.getPais(this);
         	this.idioma = UtilidadesSession.getIdioma(this);
         	this.accion = conectorParametroLimpia("accion", "", true);
			// [1] this.casoUso = conectorParametroLimpia("casoUso", "", true); 
	        this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);
			//traza("*** opcionMenu : "+this.opcionMenu);
			//traza("*** accion : " + accion);
			//traza("*** casoUso : " + this.casoUso);
         
         	//String longitudCodCliente = obtenerLongitudCodigoCliente().toString();
		 	asignar("VAR", "longitudCodigoCliente", obtenerLongitudCodigoCliente().toString());          
		 
		 	// acciones
         	if (accion.equals("")) {
             		 
            	this.casoUso = new String("");
            	this.cargarPagina();

			
			} else if (accion.equals("detalleModificar")) {
				asignarAtributo("VAR","casoUso","valor","modificarReclamo"); //[1]
				this.casoUso = conectorParametroLimpia("casoUso", "", true); // [1] 
				// Si (opcion de menu = "consultar")   
				if (opcionMenu.equals("consultar")) {
					
					//	ejecutar el método privado "detalleReclamo()"
	            	this.detalleReclamo();
				
				// Si (opcion de menu = "modificar")
				} else if (opcionMenu.equals("modificar")){  
					
					//	ejecutar el método privado "modificarReclamo()"
	            	this.modificarReclamo();
				}
			
			} else if (accion.equals("actualizar reclamo")) {
				asignarAtributo("VAR","casoUso","valor","modificarReclamo"); //[1]
				// -> ejecutar metodo privado "actualizarReclamo" 
            	this.casoUso = new String("actualizar reclamo");
            	this.actualizarReclamo();
			
			} else if (accion.equals("eliminarOperaciones")) {
			
				this.eliminarOperaciones();
			}
                  
		} catch(Exception e) {
		   logStackTrace(e);
		   lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPMantenerReclamos - ejecucion ***");
		Cronometrador.endTransaction("LPMantenerReclamos.ejecucion");
	}
	
	/**
	* 08/08/2006 - [1] - pperanzola : se modifica por cambios en performance.-
	*/
	private void cargarPagina() throws Exception {
		
		traza("*** Entrada - LPMantenerReclamos - cargarPagina ***");
		
		try {
			
			if ( opcionMenu.equals("consultar")){
				asignarAtributo("PAGINA", "contenido_reclamo_buscar", "cod", "0217");
				asignarAtributo("PAGINA", "contenido_reclamo_buscar", "msgle", "Consultar reclamos");
				getConfiguracionMenu("LPMantenerReclamos", "buscarReclamo");
			}else if (opcionMenu.equals("modificar")){
				asignarAtributo("PAGINA", "contenido_reclamos_modificar", "cod", "0127");
				asignarAtributo("PAGINA", "contenido_reclamos_modificar", "msgle", "Modificar reclamos");
				getConfiguracionMenu("LPMantenerReclamos", "buscarReclamo");
				
			}
			
			asignar("VAR", "idioma", this.idioma.toString());
			asignar("VAR", "pais", this.pais.toString());
			asignar("VAR", "casoUso", this.casoUso);
			asignar("VAR", "opcionMenu", this.opcionMenu);
			asignar("VAR", "hMarcaDefec", UtilidadesSession.getMarcaPorDefecto(this).toString()); //[1]
			asignar("VAR", "hCanalDefec", UtilidadesSession.getCanalPorDefecto(this).toString());//[1]

			                   
        	// Crear un DTOBelcorp dtoe con: 
        	// - pais = Pais activo 
        	// - idioma = Idioma del usuario
        	DTOBelcorp dtoBelcorp = new DTOBelcorp();
        	// /* [1] se comenta porque ya obtuve el pais al principio de la ejecucion de la lp          
        	//Long pais = UtilidadesSession.getPais(this);
        	//Long idioma = UtilidadesSession.getIdioma(this);
			//dtoBelcorp.setOidPais(pais);
     		//dtoBelcorp.setOidIdioma(idioma);
			dtoBelcorp.setOidPais(this.pais);
			dtoBelcorp.setOidIdioma(this.idioma); 
			//*/ [1]
        	
        	String[] idBusiness = {"SEGConsultaMarcas", "SEGConsultaCanales"};
        	             
        	ArrayList dtos = new ArrayList();
        	dtos.add(dtoBelcorp);
        	dtos.add(dtoBelcorp);
        	                                                               
        	String[] combos = {"cbMarca", "cbCanal"};      
			
        	             
        	// cada usuario tiene una marca y canal por defecto que deben seleccionarse
        	//[1] Long marca = UtilidadesSession.getMarcaPorDefecto(this);
        	//[1]Long canal = UtilidadesSession.getCanalPorDefecto(this);
        	
        	//[1] String[] seleccionados = {marca.toString(), canal.toString()};
        	//[1] String[] columnas = {"VAL_OID", "VAL_OID"};
        	             
        	cargaCombos(dtoBelcorp, idBusiness, dtos, combos, null, null);//[1]cargaCombos(dtoBelcorp, idBusiness, dtos, combos, seleccionados, columnas);
        		
		} catch(Exception e) {
		   logStackTrace(e);
		   lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPMantenerReclamos - cargarPagina ***");
	}
	
	private void detalleReclamo() throws Exception {
		traza("*** Entrada - LPMantenerReclamos - detalleReclamo ***");
		
		try{
			// Enviamos a la ventana PgDetalleReclamo el oid recibido de PgBuscaReclamos.onClickDetalle() 
			pagina("contenido_reclamos_consultar");
			asignarAtributo("PAGINA", "contenido_reclamos_consultar", "cod", "0217");
			asignarAtributo("PAGINA", "contenido_reclamos_consultar", "msgle", "Detalle reclamo");
			getConfiguracionMenu("LPMantenerReclamos", "detalleReclamo");
			
			asignar("VAR", "idioma", this.idioma.toString());
			asignar("VAR", "pais", this.pais.toString()); 
        	
      		String oidSeleccionado = conectorParametroLimpia("oid", "", true);
      		traza("*** oidSeleccionado: " + oidSeleccionado);
        	
      		asignar("VAR", "oidReclamo", oidSeleccionado); 
      
	 	} catch(Exception e) {
		   logStackTrace(e);
		   lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPMantenerReclamos - detalleReclamo ***");
	}
	
	private void modificarReclamo() throws Exception {
		traza("*** Entrada - LPMantenerReclamos - modificarReclamo ***");
		
		try{
			// Enviamos a la ventana PgModificarReclamo el oid y valores recibidos 
			// de PgBuscaReclamos.onClickModificar()
			pagina("contenido_reclamos_modificar");
			asignarAtributo("PAGINA", "contenido_reclamos_modificar", "cod", "0127");
			asignarAtributo("PAGINA", "contenido_reclamos_modificar", "msgle", "Modificar reclamos");
			getConfiguracionMenu("LPMantenerReclamos", "modificarReclamo");
			
			//añadido por incidencia 21670
			asignarAtributoElemento("GenerarSolicitudes","disabled","N");
			
			String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
        	String separadorMiles = ",";
        	if (separadorDecimales.equals(",")){
        		separadorMiles = ".";
        	}
        	asignar("VAR","hid_SeparadorMiles", separadorMiles);
        	asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
        	asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
	    	
      		String oidSeleccionado = conectorParametroLimpia("oid", "", true);
      		traza("*** oidSeleccionado: " + oidSeleccionado);
      		
      		asignar("VAR", "oidSeleccionado", oidSeleccionado);
      		asignar("VAR", "idioma", this.idioma.toString());
			asignar("VAR", "pais", this.pais.toString());
      		
      		//Se reciben en una cadena los campos del registro seleccionado, separados por el caracter ";"
      		String fila = conectorParametroLimpia("fila", "", true);
      		traza("*** FILA = "+fila);
        	
      		StringTokenizer st = new StringTokenizer(fila, ",");
        	
      		String nombre = "";
      		String apellidos = "";
      		String codCliente = "";
      		String codAtencion = "";
      		String subgerencia = "";
      		String region = "";
      		String seccion = "";
      		String zona = "";
      		String territorio = "";
      		String periodoReferencia = "";
      		String totalEnvia = "";
      		String totalDevuelve = "";
      		String saldoAPagar = "";
      		String estadoCliente = "";
      		String codDocuReferencia = "";
      		String oidNumDocumento = "";
      		String oidCliente = "";
      		String oid = "";
      		String oidPeriodo = "";
        	
      		// recibimos solo 1 registro, con los siguientes campos de la lista
      		if (st.countTokens() > 0) {
      			oid = st.nextToken();
      			traza("*** FILA oid = "+oid);
      		}
      		if (st.countTokens() > 0) {
      			codAtencion = st.nextToken();
      			traza("*** FILA codAtencion = "+codAtencion);
      		}
      		if (st.countTokens() > 0) {
      			codCliente = st.nextToken();
      			traza("*** FILA codCliente = "+codCliente);
      		}
      		if (st.countTokens() > 0) {
      			oidCliente = st.nextToken();
      			traza("*** FILA oidCliente = "+oidCliente);
      		}
      		if (st.countTokens() > 0) {
        		nombre = st.nextToken();
      			traza("*** FILA nombre = "+nombre);
      		}
      		if (st.countTokens() > 0) {
        		apellidos = st.nextToken();
      			traza("*** FILA apellidos = "+apellidos);
      		}
      		if (st.countTokens() > 0) {
      			subgerencia = st.nextToken();
      			traza("*** FILA subgerencia= "+subgerencia);
      		}
      		if (st.countTokens() > 0) { 
      			region = st.nextToken();
      			traza("*** FILA region= "+region);
      		}
      		if (st.countTokens() > 0) {
      			seccion = st.nextToken();
      			traza("*** FILA seccion= "+seccion);
      		}
      		if (st.countTokens() > 0) {
      			zona = st.nextToken();
      			traza("*** FILA zona= "+zona);
      		}
      		if (st.countTokens() > 0) {
      			territorio = st.nextToken();
      			traza("*** FILA territorio = "+territorio);
      		}
      		if (st.countTokens() > 0) {
      			estadoCliente = st.nextToken();
      			traza("*** FILA estadoCliente = "+estadoCliente);
      		}
      		if (st.countTokens() > 0) {
      			codDocuReferencia = st.nextToken();
      			traza("*** FILA codDocuReferencia = "+codDocuReferencia);
      		}
      		if (st.countTokens() > 0) {
      			oidNumDocumento = st.nextToken();
      			traza("*** FILA oidNumDocumento = "+oidNumDocumento);
      		}
      		if (st.countTokens() > 0) {
      			periodoReferencia = st.nextToken();
      			traza("*** FILA periodoReferencia = "+periodoReferencia);
      		}
      		if (st.countTokens() > 0) {
      			totalEnvia = st.nextToken();
      			traza("*** FILA totalEnvia = "+totalEnvia);
      		}
      		if (st.countTokens() > 0) {
      			totalDevuelve = st.nextToken();
      			traza("*** FILA totalDevuelve = "+totalDevuelve);
      		}
      		if (st.countTokens() > 0) {
      			saldoAPagar = st.nextToken();
      			traza("*** FILA saldoAPagar = "+saldoAPagar);
      		}
      		if (st.countTokens() > 0) {
      			oidPeriodo = st.nextToken();
      			traza("*** FILA oidPeriodo = "+oidPeriodo);
      		}
      		   
      		// se recupera el resto de valores que se pasan de la pagina de busqueda a la de modificacion
      		String valorOrigen = null;
        	
      		// lbCodCliente = codCliente recibido
      		if (!codCliente.equals("-")){ 
      			asignarAtributo("LABELC","lblCodCliX","valor",codCliente);
			}
	  		// lbNombreApellidos = nombre && apellidos recibidos
	  		if (!nombre.equals("-") && !apellidos.equals("-")){
      			asignarAtributo("LABELC", "lblNomApeCliX","valor", nombre +" "+ apellidos);
			}
	  		// lbNumAtencion = numAtencion recibido 
	  		if (!codAtencion.equals("-")){ 
     			asignarAtributo("LABELC","lblNAtencionX","valor",codAtencion);
     		}
        	
	  		// lbSGV = SGV recibido 
	  		if (!subgerencia.equals("-")){
      			asignarAtributo("LABELC","lblSubCliX","valor",subgerencia);
      		}
	  		
	  		// lbRegion = region recibido 
      		if (!region.equals("-")){
      			asignarAtributo("LABELC","lblRegCliX","valor",region);
      		}
      		
	  		// lbSeccion = seccion recibido 
	  		if (!seccion.equals("-")){
      			asignarAtributo("LABELC","lblSecCliX","valor",seccion);
      		}
      		
	  		// lbZona = zona recibido 
	  		if (!zona.equals("-")){
      			asignarAtributo("LABELC","lblZonCliX","valor",zona);
      		}
      		
	  		// lbTerritorio = territorio recibido 
	  		if (!territorio.equals("-")){
      			asignarAtributo("LABELC","lblTerrCliX","valor",territorio);
      		}
      		 
	  		 // lbEstadoCliente = estadoCliente recibido 
	  		if (!estadoCliente.equals("-")){ 
      			asignarAtributo("LABELC","lblEstadoCliX","valor",estadoCliente);
	  		}
	  		
	  		// lbCodDocuReferencia = codDocuReferencia recibido 
	  		if (!estadoCliente.equals("-")){
      			asignarAtributo("LABELC","lblCodDocRefX","valor",codDocuReferencia);
      		}
	  			
	  		// lbPeriodoReferencia = periodoReferencia recibido 
	  		if (!periodoReferencia.equals("-")){
      			asignarAtributo("LABELC","lblPerRefX","valor",periodoReferencia);
	  		}
	  		
	  		// lbEnviaTotal = totalEnvia recibido
	  		if (!totalEnvia.equals("-")){ 
      			asignarAtributo("VAR","totalEnvia","valor",totalEnvia);
      		}
      		
	  		// lbDevuelveTotal = totalDevuelve recibido 
	  		if (!totalDevuelve.equals("-")){
      			asignarAtributo("VAR","totalDevuelve","valor",totalDevuelve);
      		}
      		
	  		// lbSaldoPagar = saldoAPagar recibido
	  		if (!saldoAPagar.equals("-")){ 
      			asignarAtributo("VAR","saldoAPagar","valor",saldoAPagar);
      		}
      		
      		// asignamos el oidNumDocumento al hidden oidNumDocumento
      		if (!oidNumDocumento.equals("-")){
      			asignarAtributo("VAR","oidNumDocumento","valor",oidNumDocumento);
      		}
      		
      		// asignamos el oidCliente al hidden oidCliente
      		if (!oidCliente.equals("-")){
      			asignarAtributo("VAR","oidCliente","valor",oidCliente);
      		}
      		
      		// asignamos el codAtencion al hidden numAtencion
      		if (!codAtencion.equals("-")){
      			asignarAtributo("VAR","numAtencion","valor",codAtencion);
      		}
      		
      		// asignamos el oidPeriodo al hidden oidPeriodo
      		if (!oidPeriodo.equals("-")){
      			asignarAtributo("VAR","oidPeriodo","valor",oidPeriodo);
      		}
      	
	  	} catch(Exception e) {
		   logStackTrace(e);
		   lanzarPaginaError(e);
	}
	traza("*** Salida - LPMantenerReclamos - modificarReclamo ***");
		
	}	
	
	private void eliminarOperaciones() throws Exception {
		traza("*** Entrada - LPMantenerReclamos - eliminarLineas ***");
		
		try{
			pagina("salidaGenerica"); 
			asignar("VAR", "cerrarVentana", "false");
			asignarAtributo("VAR", "ejecutarError", "valor", "error()");
            			
			// Crear un DTOOID con el oid recibido de pantalla
			String oidsOperaciones = conectorParametroLimpia("oidsOperaciones", "", true);
      		traza("***oidsOperaciones : " + oidsOperaciones);
      		
      		DTOEliminaLineaOperacion dto = new DTOEliminaLineaOperacion();
      		
      		ArrayList oids = new ArrayList();
			StringTokenizer st = new StringTokenizer(oidsOperaciones,",");
			while(st.hasMoreTokens()){
				String oid = st.nextToken();
				oids.add(new Long(oid));
			}
			traza("***oids : " + oids);
			dto.setOidLineas(oids);
			dto.setOidPais(this.pais);
			traza("***pais : " + this.pais);
			dto.setOidIdioma(this.idioma);
			traza("***idioma : " + this.idioma);
			
      		String totalEnvia = conectorParametroLimpia("totalEnvia", "", true);
      		traza("***totalEnvia : " + totalEnvia);
      			
      		String totalDevuelve = conectorParametroLimpia("totalDevuelve", "", true);
      		traza("***totalDevuelve : " + totalDevuelve);
      			
			if ( !totalEnvia.equals("") ){
				dto.setTotalEnvia(new BigDecimal(totalEnvia));
			}else{
				dto.setTotalEnvia(new BigDecimal("0"));
			}
			if ( !totalDevuelve.equals("") ){
				dto.setTotalDevuelve(new BigDecimal(totalDevuelve));
			}else{
				dto.setTotalDevuelve(new BigDecimal("0"));
			}
			traza("DTO = "+dto);
			
			// Cread idBusiness = "RECEliminarLineasOperacion" 
			MareBusinessID idNegocio = new MareBusinessID("RECEliminarLineaOperacion");
			
			// Asignar conector ConectorEliminarLineasOperacion con el idBusiness creado y el DTOOID construido		
			Vector paramsEntrada = new Vector();
      		paramsEntrada.add(dto);
      		paramsEntrada.add(idNegocio);
      		
      		traza("*** antes de coger el conector ");
      		DruidaConector conector = conectar("ConectorEliminarLineaOperacionREC", paramsEntrada);
      		traza("*** despues de coger el conector ");
      		
      		//mostramos datos recibidos DTOTotalesReclamoREC
            traza("recoge los datos recibidos del DTOTotalesReclamoREC");
            DTOTotalesReclamoREC dtoTotales = null;
            dtoTotales = (DTOTotalesReclamoREC)conector.objeto("DTOTotalesReclamoREC");	
      		
      		BigDecimal totalAbono = null;
            BigDecimal totalCargo = null;
            BigDecimal total = null;
            
            if(dtoTotales.getTotalAbono()!=null){ //Integer totalEnvia
        		totalAbono = (BigDecimal) dtoTotales.getTotalAbono();
            	traza("***totalEnvia : " + totalAbono);
        	}
        	if(dtoTotales.getTotalCargo()!=null){ //String  totalDevuelve
        		totalCargo = (BigDecimal) dtoTotales.getTotalCargo();
            	traza("***totalDevuelve : " + totalCargo);
        	}
        	if((dtoTotales.getTotalAbono()!=null)&&(dtoTotales.getTotalCargo()!=null)){	
           		total = totalAbono.subtract(totalCargo);
            	traza("***total : " + total);
        	}
      	
			asignarAtributo("VAR", "ejecutar", "valor", 
        	    	"borrado('"+totalAbono.toString()+
        	    		"','"+totalCargo.toString()+"','"+total.toString()+"')");	
      		
		}catch(Exception e) {
		   logStackTrace(e);
		   lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPMantenerReclamos - eliminarLineas ***");
	}
	
	// incidencia BELC300014390
	private void actualizarReclamo() throws Exception {
	
		traza("*** Entrada - LPMantenerReclamos - actualizarReclamo ***");		
		try{	
			pagina("salidaGenerica"); 
			asignar("VAR", "cerrarVentana", "false");
			asignarAtributo("VAR", "ejecutarError", "valor", "error()");
			
			DTOReclamo dtoReclamo = new DTOReclamo();
			
		//añadido por incidencia 21670
		asignarAtributoElemento("GenerarSolicitudes","disabled","N");
		
			String totalEnvia = conectorParametroLimpia("totalEnvia", "", true);
      		traza("***totalEnvia : " + totalEnvia);
      		dtoReclamo.setTotalEnvia(new BigDecimal(totalEnvia)); 

      		String totalDevuelve = conectorParametroLimpia("totalDevuelve", "", true);
      		traza("***totalDevuelve : " + totalDevuelve);
      		dtoReclamo.setTotalDevuelve(new BigDecimal(totalDevuelve)); 
      		
			String numAtencion = conectorParametroLimpia("numAtencion", "", true);
			traza("*** numAtencion = "+numAtencion);
			dtoReclamo.setNumAtencion(new Long(numAtencion)); //Long numAtencion
			
			String oidReclamo = conectorParametroLimpia("oidSeleccionado", "", true);
			traza("*** oidReclamo = "+oidReclamo);
			dtoReclamo.setOidReclamo(new Long(oidReclamo));
			
			String oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);
			traza("*** oidPeriodo = "+oidPeriodo);
			dtoReclamo.setPeriodoReclamo(new Long(oidPeriodo));
			
			String oidNumDocumento = conectorParametroLimpia("oidNumDocumento", "", true);  
			traza("*** oidNumDocumento = "+oidNumDocumento);    
			dtoReclamo.setOidDocumentoReferencia(new Long(oidNumDocumento));//Long 
			
			String oidCliente = conectorParametroLimpia("oidCliente", "", true);
			traza("*** oidCliente = "+oidCliente);
			dtoReclamo.setOidCliente(new Long(oidCliente)); //Long 
			                  
			String operacion = conectorParametroLimpia("hoperacion", "", true);
      		traza("***operacion: " + operacion);
      	
      		String lineas = conectorParametroLimpia("hlinea", "", true);
      		traza("***lineas : " + lineas);
      		
      		dtoReclamo.setOidIdioma(this.idioma);
      		dtoReclamo.setOidPais(this.pais);
      		
      		ArrayList arrayOperaciones = new ArrayList();
			DTOOperacionReclamo dtoOperacion = new DTOOperacionReclamo();
      		
      		StringTokenizer st = new StringTokenizer(operacion,"@");
			while(st.hasMoreTokens()){
				
				dtoOperacion.setOidIdioma(this.idioma);
				dtoOperacion.setOidPais(this.pais);
				
				String numeroAtencion = st.nextToken();
				traza("***numeroAtencion : " + numeroAtencion);
				if ( !numeroAtencion.equals("-") ){
					dtoOperacion.setNumAtencion(new Long(numeroAtencion));//Long 
				}
				
				String oidClient = st.nextToken();
				traza("***oidClient : " + oidClient);
				
				//OBLIGATORIO		
				String oidNumDocumentoRef = st.nextToken();
				traza("***oidNumDocumentoRef : " + oidNumDocumentoRef);
				if ( !oidNumDocumentoRef.equals("-") ){	
					dtoOperacion.setOidDocumentoReferencia(new Long(oidNumDocumentoRef));//Long
				}
				
				String oidTipoOperacion = st.nextToken();
				traza("***oidTipoOperacion : " + oidTipoOperacion);
				if ( !oidTipoOperacion.equals("-") ){	
					dtoOperacion.setTipoOperacion(new Long(oidTipoOperacion));//Long
				}
				
				//OBLIGATORIO
				String oidCodOperacion = st.nextToken();
				traza("***oidCodOperacion : " + oidCodOperacion);
				
				//No recoge el dto
				String uReclamadas = st.nextToken();
				traza("***uReclamadas : " + uReclamadas);
				
				//No recoge el dto
				String uDevueltas = st.nextToken();
				traza("***uDevueltas : " + uDevueltas);
				
				//No recoge el dto
				String totalCargo = st.nextToken();
				traza("***totalCargo : " + totalCargo);
				
				//No recoge el dto
				String totalAbono = st.nextToken();
				traza("***totalAbono : " + totalAbono);
				
				String oidMotivoBloqueo = st.nextToken();
				traza("***oidMotivoBloqueo : " + oidMotivoBloqueo);
				if ( !oidMotivoBloqueo.equals("-") ){	
					dtoOperacion.setMotivoBloqueo(new Long(oidMotivoBloqueo));//Long
				}
				
				String oidEstadoOperacion = st.nextToken();
				traza("***oidEstadoOperacion : " + oidEstadoOperacion);
				if ( !oidEstadoOperacion.equals("-") ){	
					dtoOperacion.setEstadoOperacion(new Long(oidEstadoOperacion));//Long
				}
				
				String tipoBloqueo = st.nextToken();
				traza("***tipoBloqueo : " + tipoBloqueo);
				if ( !tipoBloqueo.equals("-") ){	
					dtoOperacion.setTipoBloqueo(tipoBloqueo);//String
				}
				
				//OBLIGATORIO
				String numSecOper = st.nextToken();
				traza("***** numSecOper = "+ numSecOper);
				dtoOperacion.setNumSecuencial(new Integer(numSecOper));//Integer 
				
				String codOper = st.nextToken();
				traza("***codOper : " + codOper);
				if ( !codOper.equals("-") ){	
					dtoOperacion.setCodigoOperacion(codOper);//String
				}
				
				//No recoge el dto
				String codTipoOper = st.nextToken();
				traza("***codTipoOper : " + codTipoOper);
				
				String montoPerdida = st.nextToken();
				traza("***montoPerdida : " + montoPerdida);
				if ( !montoPerdida.equals("-") ){	
					dtoOperacion.setMontoPerdida(new BigDecimal(montoPerdida));//String
				}
				
				//No recoge el dto
				String monedaDoc = st.nextToken();
				traza("***monedaDoc : " + monedaDoc);
				
				//Descripcion
				String docReferencia = st.nextToken();
				traza("***docReferencia : " + docReferencia);
				
				//OBLIGATORIO
				dtoOperacion.setPeriodo(new Long(oidPeriodo));
				
				String producto = st.nextToken();
				traza("***producto : " + producto);
				if(!producto.equals("-")){
					dtoOperacion.setCodigoArticulo(new Long(producto));
				}
				
				String clienteSeguro = st.nextToken();
				traza("***clienteSeguro : " + clienteSeguro);
				if(!clienteSeguro.equals("-")){
					dtoOperacion.setClienteSeguro(new Long(clienteSeguro));
				}
				
				String importe = st.nextToken();
				traza("***importe : " + importe);
				if(!importe.equals("-")){
					dtoOperacion.setMontoPerdida(new BigDecimal(importe));
				}
				
				String asume = st.nextToken();
				traza("***asume : " + asume);
				if(!importe.equals("-")){
					dtoOperacion.setAsumePerdida(new Long(asume));
				}
				traza("[MSN]fin operacion");	
		}
		ArrayList arrayLineas = new ArrayList();
		DTOLineaOperacion dtoLineaOperacion = null;                                                                                                                                                                                                                                                                                                                                                    
		StringTokenizer stLineas = new StringTokenizer(lineas,"|");
		
		while(stLineas.hasMoreTokens()){
			traza("[MSN]Inicio linea");
			
			
			String linea = stLineas.nextToken();
			traza("***linea : " + linea);
			StringTokenizer stLinea = new StringTokenizer(linea,"@");
			dtoLineaOperacion = new DTOLineaOperacion();	
			
			dtoLineaOperacion.setOidIdioma(this.idioma);
			dtoLineaOperacion.setOidPais(this.pais);
			
			//OBLIGATORIO
			String numLinea = stLinea.nextToken();
			traza("***numLinea : " + numLinea);
			dtoLineaOperacion.setNumLinea(new Integer(numLinea));//Integer
			
			//No va en el dto
			String tipoMovimiento = stLinea.nextToken();
			traza("***tipoMovimiento : " + tipoMovimiento);
			
			//OBLIGATORIO
			String oidTipoMovimiento = stLinea.nextToken();
			traza("***oidTipoMovimiento : " + oidTipoMovimiento);
			dtoLineaOperacion.setOidTipoMovimiento(new Long(oidTipoMovimiento));//Long 
			
			String codVenta = stLinea.nextToken();
			traza("***codVenta : " + codVenta);
			if ( !codVenta.equals("-") ){
				dtoLineaOperacion.setCodigoVenta(codVenta);//String
			}
			
			String codProducto = stLinea.nextToken();
			traza("***codProducto : " + codProducto);
			
			//No va en el dto
			String descripcion = stLinea.nextToken();
			traza("***descripcion : " + descripcion);
			
			String unidadesReclamadas = stLinea.nextToken();
			traza("***unidadesReclamadas : " + unidadesReclamadas);
			if ( !unidadesReclamadas.equals("-") ){
				dtoLineaOperacion.setUnidadesReclamadas(new Integer(unidadesReclamadas));//Integer
			}
			
			//No va en el dto
			String motivoDevolucion = stLinea.nextToken();
			traza("***motivoDevolucion : " + motivoDevolucion);
			
			String oidMotivo = stLinea.nextToken();
			traza("***oidMotivo : " + oidMotivo);
			if ( !oidMotivo.equals("-") ){
				dtoLineaOperacion.setOidMotivoDevolucion(new Long(oidMotivo));//Long
			}
			
			String precio = stLinea.nextToken();
			traza("***precio : " + precio);
			if ( !precio.equals("-") ){
			dtoLineaOperacion.setPrecio(new BigDecimal(precio));//BigDecimal   
			}
			
			String importeCargo = stLinea.nextToken();
			traza("***importeCargo : " + importeCargo);
			if ( !importeCargo.equals("-") ){
				dtoLineaOperacion.setImporteCargo(new BigDecimal(importeCargo));//BigDecimal  
			}
			
			String importeAbono = stLinea.nextToken();
			traza("***importeAbono : " + importeAbono);
			if ( !importeAbono.equals("-") ){
			dtoLineaOperacion.setImporteAbono(new BigDecimal(importeAbono));//BigDecimal
			}
			
			String numeroUniDev = stLinea.nextToken();
			traza("***numeroUniDev : " + numeroUniDev);
			if ( !numeroUniDev.equals("-") ){
				dtoLineaOperacion.setUnidadesDevueltas(new Integer(numeroUniDev));//Integer 
			}
			
			//No va en el dto
			String descuento = stLinea.nextToken();
			traza("***descuento : " + descuento);
			
			//No va en el dto
			String oidMonedaDoc = stLinea.nextToken();
			traza("***oidMonedaDoc : " + oidMonedaDoc);
			
			//No va en el dto
			String monedaDoc = stLinea.nextToken();
			traza("***monedaDoc : " + monedaDoc);
			
			String oidCodProducto = stLinea.nextToken();
			traza("***oidCodProducto : " + oidCodProducto);
			if ( !oidCodProducto.equals("-") ){
				dtoLineaOperacion.setOidCodProducto(new Long(oidCodProducto));//Long
			}
			
			String oidCodVenta = stLinea.nextToken();
			traza("***oidProducto : " + oidCodVenta);
			if ( !oidCodVenta.equals("-") ){
				dtoLineaOperacion.setOidCodVenta(new Long(oidCodVenta));//Long
			}
			
			String oidTipoOferta = stLinea.nextToken();
			traza("***oidTipoOferta : " + oidTipoOferta);
			if ( !oidTipoOferta.equals("-")){
				dtoLineaOperacion.setOidTpoOferta(new Long(oidTipoOferta));//Long
			}
			
			arrayLineas.add(dtoLineaOperacion);				
		}
		dtoOperacion.setLineas(arrayLineas);//ArrayList
		arrayOperaciones.add(dtoOperacion);
		dtoReclamo.setOperaciones(arrayOperaciones);
		traza("***dtoReclamo : " + dtoReclamo);
		
		// Cread idBusiness = "RECActualizarReclamo" 
		MareBusinessID idNegocio = new MareBusinessID("RECActualizarReclamo");
			
		// Asignar conector ConectorEliminarLineasOperacion con el idBusiness creado 
		//y el DTOOID construido		
		Vector paramsEntrada = new Vector();
      	paramsEntrada.add(dtoReclamo);
      	paramsEntrada.add(idNegocio);
      			
      	traza("*** antes de coger el conector ");
      	DruidaConector conector = conectar("ConectorActualizarReclamo", paramsEntrada);
      	traza("*** despues de coger el conector ");
		
		//mostramos datos recibidos DTOTotalesReclamoREC      
        DTOTotalesReclamoREC dtoTotales = new DTOTotalesReclamoREC();
        traza("recoge los datos recibidos del DTOTotalesReclamoREC");
        dtoTotales = (DTOTotalesReclamoREC)conector.objeto("DTOTotalesReclamoREC");
        traza("*** dtoTotales: "+dtoTotales);	
      		
      	BigDecimal totalAbono = null;
        BigDecimal totalCargo = null;
        BigDecimal total = null;
            
        if(dtoTotales.getTotalAbono()!=null){ //Integer totalEnvia
  
        	totalAbono = (BigDecimal) dtoTotales.getTotalAbono();
            traza("***totalEnvia : " + totalAbono);
        }
        if(dtoTotales.getTotalCargo()!=null){ //String  totalDevuelve
            	
        	totalCargo = (BigDecimal) dtoTotales.getTotalCargo();
            traza("***totalDevuelve : " + totalCargo);
        }
        if((dtoTotales.getTotalAbono()!=null)&&(dtoTotales.getTotalCargo()!=null)){
            	
           	total = totalAbono.subtract(totalCargo);
            traza("***total : " + total);
        }
      
		asignarAtributo("VAR", "ejecutar", "valor", 
            	"agregado('"+totalAbono.toString()+
            		"','"+totalCargo.toString()+"','"+total.toString()+"')");	
		
		} catch(Exception e) {
		   logStackTrace(e);
		   lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPMantenerReclamos - actualizarReclamo ***");
	}	
	/**
	* 08/08/2006 - [1] - pperanzola : se modifica por cambios en performance.-
	*/
	private void cargaCombos(DTOBelcorp dtoBelcorp, 
                             	String[] idBusiness, 
                                	ArrayList dtos,
                                    	String[] combos, 
                                      		String[] seleccionados, 
                                      			String[] columnas) throws Exception {
                    
		//traza("*** Entrada - cargaCombos ***");
                    
        	try {
            	//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
            	ComposerViewElementList listelem = new ComposerViewElementList();
            	ComposerViewElement elem = null;
                
                // [1] DTOBelcorp unDto = null;
				int tamano = idBusiness.length;
                for (int i = 0; i < tamano; i++) {
                	
                	elem = new ComposerViewElement(); 
                	elem.setIDBusiness(idBusiness[i]);
                	//[1] unDto = (DTOBelcorp)dtos.get(i);
                	elem.setDTOE((DTOBelcorp)dtos.get(i));
                	listelem.addViewElement(elem);
                }

                //Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados. 
                ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());

                conector.ejecucion();
                              
               	//traza("*** antes de coger el conector ");	
               	DruidaConector conConsultar = conector.getConector();
               	//traza("*** despues de coger el conector ");
                              
                //Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
                //correspondiente utilizando el String que representa el BusinessID en cada caso. 
                                 
                asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 
                asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
                                    
        } catch (Exception e) {
              	
              	this.logStackTrace(e);
              	lanzarPaginaError(e);  
        }
	
		//traza("*** Salida - cargaCombos ***");
          
	}
	
	protected void logStackTrace(Throwable e) throws Exception {  
       traza("Se produjo la excepcion: " + e.getMessage());       
	                                                              
	   ByteArrayOutputStream baos = new ByteArrayOutputStream();  
       PrintStream ps = new PrintStream(baos);                    
       e.printStackTrace(ps);                                     
                                                                  
       traza("Stack Trace: " + baos.toString());                  
    } 
  
}                                                            