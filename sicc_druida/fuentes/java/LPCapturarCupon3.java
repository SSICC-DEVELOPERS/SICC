/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    INDRA/CCC/PROY
    $Id: LPCapturarCupon3.java,v 1.1 2009/12/03 18:41:56 pecbazalar Exp $
    DESC
 */
//import LPSICCBase;

import java.util.Vector;
import java.util.StringTokenizer;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.druida.Contexto;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.ccc.DTOSigNroCupTram;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.mare.common.dto.*;
import java.util.ArrayList;

import es.indra.sicc.dtos.ccc.DTOCruzarCupon3conCupon1;
import es.indra.sicc.dtos.ccc.DTOSiguienteNumeroCupon;
import java.text.SimpleDateFormat;

// Definicion de la clase
public class LPCapturarCupon3 extends LPSICCBase {
	     
	private String accion = null;
	private Long idioma;
	private Long pais;    
    private String opcionMenu = "";

    private Long oidIdioma = null;
    private Long oidPais = null;
	private String ipCliente = "";
	
	public LPCapturarCupon3() {
		super();
	}
	
	public void inicio() throws Exception {
		// Asignar nombre de la vista
		pagina("contenido_cupon3_introducir");	
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("***Entrada -  LPCapturarCupon3 - ejecucion ***");

		this.accion = conectorParametroLimpia("accion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);      	
		this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);

        oidPais = UtilidadesSession.getPais(this);
        oidIdioma = UtilidadesSession.getIdioma(this);
        ipCliente = UtilidadesBelcorp.getIPCliente(this);                        

		traza("***accion recuperada ***"+ this.accion);

		try {
			// Se obtiene la sesión
			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);

			if (this.accion.equals("")) {
				getConfiguracionMenu("LPCapturarCupon3", this.accion);
				accionVacia(pais, idioma);
			} else if (this.accion.equals("introducir")) {
				accionIntroducir(pais, idioma);
			} else if (this.accion.equals("verificar")) {
				accionVerificar(pais, idioma);
			} else if (this.accion.equals("recargNroCupon")) {
				accionRecargNroCupon(pais);
			}else if (this.accion.equals("recargTodoSalvoNroCupon")) {
				recargTodoSalvoNroCupon(pais, idioma);
			}
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e); 
		}

		traza("***Salida -  LPCapturarCupon3 - ejecucion ***");
	}

	private void accionVacia(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPCapturarCupon3 - accionVacia ***");

		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_cupon3_introducir", "cod", "0168");
		asignarAtributo("PAGINA", "contenido_cupon3_introducir", "msgle", "0168");
        this.generarHiddenFormatoFecha();
 
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());
		java.util.Date hoy = new java.util.Date(new java.util.Date().getTime());
		//String hoyStr = hoy.toString();
		String hoyStr = hoyAString();

		traza("hoyStr..: " + hoyStr);

		asignar("LABELC", "lblAnoActual", hoyStr.substring(8,10));
		asignar("LABELC", "lblMesActual", hoyStr.substring(3,5));
		asignar("VAR", "anyo", hoyStr.substring(8,10));
		asignar("VAR", "mes", hoyStr.substring(3,5));
		asignarAtributo( "VAR", "hFechaDigitacion", "valor", hoyAString());

		DTOSigNroCupTram dtoBelcorp = new DTOSigNroCupTram();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setFechDigit(hoy);

		MareBusinessID idBusiness = new MareBusinessID("CCCSiguienteNumeroCuponTramiteNuevo");

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoBelcorp);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		traza("voy a: ConectorSiguienteNumeroCuponTramite.....");
		DruidaConector conector = conectar("ConectorSiguienteNumeroCuponTramite", paramEntrada);
		DTOSiguienteNumeroCupon num = (DTOSiguienteNumeroCupon)conector.objeto("DTOSiguienteNumeroCupon");
		asignar("LABELC", "lbldtNumero", num.getNumeroCupon().toString());
		asignar("VAR", "numero", num.getNumeroCupon().toString());

		asignar("VAR", "numeroDeCuponEnSesion", num.getNumeroCupon().toString());

		// Se cargan los combos de la página
		//this.cargaCombos(dtoBelcorp, "SEGConsultaCanales", "cbCanal");
		cargarMarcaCanal();

		Long oidMarcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
		Long oidCanalDefecto = UtilidadesSession.getCanalPorDefecto(this);

        asignarAtributo("VAR","hOidMarca","valor",oidMarcaDefecto.toString());
        asignarAtributo("VAR","hOidCanal","valor",oidCanalDefecto.toString());

		cargarPeriodo(oidPais, oidMarcaDefecto, oidCanalDefecto);

		traza("***Salida -  LPCapturarCupon3 - accionVacia ***");
	}

	private void recargTodoSalvoNroCupon(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPCapturarCupon3 - recargTodoSalvoNroCupon ***");
		String numeroDeCuponEnSesion = conectorParametroLimpia("numeroDeCuponEnSesion","",true);

		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_cupon3_introducir", "cod", "0168");
		asignarAtributo("PAGINA", "contenido_cupon3_introducir", "msgle", "0168");
        this.generarHiddenFormatoFecha();
 
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());
		java.util.Date hoy = new java.util.Date(new java.util.Date().getTime());
		//String hoyStr = hoy.toString();
		String hoyStr = hoyAString();

		traza("hoyStr..: " + hoyStr);

		asignar("LABELC", "lblAnoActual", hoyStr.substring(8,10));
		asignar("LABELC", "lblMesActual", hoyStr.substring(3,5));
		asignar("VAR", "anyo", hoyStr.substring(8,10));
		asignar("VAR", "mes", hoyStr.substring(3,5));
		asignarAtributo( "VAR", "hFechaDigitacion", "valor", hoyAString());
		
        traza("numeroDeCuponEnSesion: " + numeroDeCuponEnSesion);
		asignar("VAR", "numero", numeroDeCuponEnSesion);
		asignar("LABELC", "lbldtNumero", numeroDeCuponEnSesion);

		// Se cargan los combos de la página
		//this.cargaCombos(dtoBelcorp, "SEGConsultaCanales", "cbCanal");
		cargarMarcaCanal();

		Long oidMarcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
		Long oidCanalDefecto = UtilidadesSession.getCanalPorDefecto(this);

        asignarAtributo("VAR","hOidMarca","valor",oidMarcaDefecto.toString());
        asignarAtributo("VAR","hOidCanal","valor",oidCanalDefecto.toString());

		cargarPeriodo(oidPais, oidMarcaDefecto, oidCanalDefecto);

		traza("***Salida -  LPCapturarCupon3 - recargTodoSalvoNroCupon ***");
	}

	private void accionRecargNroCupon(Long pais) throws Exception {
		traza("***Entrada -  LPCapturarCupon3 - accionRecargNroCupon ***");
		
		String parametro = conectorParametroLimpia("textFechaDigit", "", true);

		pagina("salidaGenerica");
		DTOSigNroCupTram dtoBelcorp = new DTOSigNroCupTram();
		dtoBelcorp.setOidPais(pais);
		
		if (!parametro.equals(""))
    		dtoBelcorp.setFechDigit(UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this)));
		traza("DTOSigNroCupTram: " + dtoBelcorp.getOidPais());
		traza("DTOSigNroCupTram: " + dtoBelcorp.getFechDigit());
		MareBusinessID idBusiness = new MareBusinessID("CCCSiguienteNumeroCuponTramiteNuevo");

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoBelcorp);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		traza("voy a: ConectorSiguienteNumeroCuponTramite.....");
		DruidaConector conector = conectar("ConectorSiguienteNumeroCuponTramite", paramEntrada);
		DTOSiguienteNumeroCupon num = (DTOSiguienteNumeroCupon)conector.objeto("DTOSiguienteNumeroCupon");

		//asignar("LABELC", "lbldtNumero", num.getNumeroCupon().toString());
		//asignar("VAR", "numero", num.getNumeroCupon().toString());
		
		traza("num.getNumeroCupon().toString(): " + num.getNumeroCupon().toString());
		asignarAtributo("VAR","ejecutar","valor","cool('" + num.getNumeroCupon().toString() + "');");

		traza("***Salida  -  LPCapturarCupon3 - accionRecargNroCupon ***");
	}

    private String hoyAString() throws Exception {
       String formato = UtilidadesSession.getFormatoFecha(this);
       traza("Formato fecha: "+formato);
       int pos = formato.indexOf("mm");
       if ( pos > -1) 
           formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
       SimpleDateFormat sdf = new SimpleDateFormat(formato);
       String fecha = sdf.format(new java.util.Date());
       traza("Fecha: "+fecha);
	 
       return fecha;
    }

    /*, se comenta porq' el metodo de seg choca contra el esquema conceptual
	private void cargarMarcaCanal() throws Exception{
		traza("Entró de cargarMarcaCanal()");
		DTOFiltroPMC paisMarcaCanal = new DTOFiltroPMC();
		paisMarcaCanal.setOidIdioma(oidIdioma);
		paisMarcaCanal.setPaises(Boolean.TRUE);
		paisMarcaCanal.setMarcas(Boolean.TRUE);
		paisMarcaCanal.setCanales(Boolean.TRUE);

		Vector paramEntrada = new Vector();
		paramEntrada.add(paisMarcaCanal);

		paramEntrada.add(new MareBusinessID("CRAPaisMarcaCanal"));
		DruidaConector conectorCargarPaisMarcaCanal = conectar("ConectorCargarPaisMarcaCanal", paramEntrada);

		asignar("COMBO", "cbMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
		asignar("COMBO", "cbCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

		traza("Salio de cargarMarcaCanal()");
	}*/

	private void cargarMarcaCanal() throws Exception{
		traza("Entró de cargarMarcaCanal()");

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(this.pais);
		dtoBelcorp.setOidIdioma(this.idioma); 
       	String[] idBusiness = {"SEGConsultaMarcas", "SEGConsultaCanales"};
        	             
       	ArrayList dtos = new ArrayList();
       	dtos.add(dtoBelcorp);
       	dtos.add(dtoBelcorp);
        	                                                               
       	String[] combos = {"cbMarca", "cbCanal"};      
		cargaCombos(dtoBelcorp, idBusiness, dtos, combos, null, null);

		traza("Salio de cargarMarcaCanal()");
	}
	
	private void cargaCombos(DTOBelcorp dtoBelcorp, 
                             	String[] idBusiness, 
                                	ArrayList dtos,
                                    	String[] combos, 
                                      		String[] seleccionados, 
                                      			String[] columnas) throws Exception {
                    
		traza("*** Entrada - cargaCombos ***");
                    
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

	private void cargarPeriodo(Long oidPais, Long oidMarca, Long oidCanal) throws Exception{
		traza("Entró de cargarPeriodo(Long oidPais, Long oidMarca, Long oidCanal)");
		DTOPeriodo paisMarcaCanal = new DTOPeriodo();
		paisMarcaCanal.setOidIdioma(oidIdioma);
		paisMarcaCanal.setPais(oidPais);
		paisMarcaCanal.setMarca(oidMarca);
		paisMarcaCanal.setCanal(oidCanal);

		Vector paramEntrada = new Vector();
		paramEntrada.add(paisMarcaCanal);

		paramEntrada.add(new MareBusinessID("CRAObtienePeriodoActual"));
		DruidaConector conectorCargarPeriodo = conectar("ConectorObjeto", paramEntrada);

		IMareDTO dtoSalida = (IMareDTO)conectorCargarPeriodo.objeto("DTOSalida");
		DTOPeriodo dtoPeriodo = (DTOPeriodo)(dtoSalida.getProperty("periodoActual"));

		String periodoActual = dtoPeriodo.getOid().toString();
		asignarAtributo("VAR","hOidPeriodo","valor",periodoActual);
		traza("asigno periodo actual:"+periodoActual);

		traza("Salió de cargarPeriodo(Long oidPais, Long oidMarca, Long oidCanal)");
	}

	private void accionIntroducir(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPCapturarCupon3 - accionIntroducir ***");

		pagina("contenido_datos_cupones_introducir");	
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_datos_cupones_introducir", "cod", "0168");
		asignarAtributo("PAGINA", "contenido_datos_cupones_introducir", "msgle", "0168");
        this.generarHiddenFormatoFecha();
		getConfiguracionMenu("LPCapturarCupon3", this.accion);

		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		asignar("LABELC", "lblAnoActual", conectorParametroLimpia("anyo", "", true));
		asignar("LABELC", "lblMesActual", conectorParametroLimpia("mes", "", true));
		asignar("LABELC", "lbldtNumero", conectorParametroLimpia("numero", "", true));

		asignar("LABELC", "lblMarcaActual", conectorParametroLimpia("cbMarcaDesc", "", true));
		asignar("VAR", "marca", conectorParametroLimpia("cbMarca", "", true));

		asignar("LABELC", "lblCanalActual", conectorParametroLimpia("cbCanalDesc", "", true));
		asignar("VAR", "canal", conectorParametroLimpia("cbCanal", "", true));

		asignar("LABELC", "lblPeriodoActual", conectorParametroLimpia("cbPeriodoDesc", "", true));
		asignar("VAR", "periodo", conectorParametroLimpia("cbPeriodo", "", true));

		asignar("LABELC", "lblFechaDigitActual", conectorParametroLimpia("textFechaDigit", "", true));
		asignar("LABELC", "lblRefExtActual", conectorParametroLimpia("textRefExt", "", true));
		asignar("LABELC", "lblObservacionesActual", conectorParametroLimpia("areatxtObservaciones", "", true));

		asignar("VAR", "anyo", conectorParametroLimpia("anyo", "", true));
		asignar("VAR", "mes", conectorParametroLimpia("mes", "", true));
		asignar("VAR", "numero", conectorParametroLimpia("numero", "", true));
		asignar("VAR", "fechaDigit", conectorParametroLimpia("textFechaDigit", "", true));
		asignar("VAR", "refExterna", conectorParametroLimpia("textRefExt", "", true));
		asignar("VAR", "observaciones", conectorParametroLimpia("areatxtObservaciones", "", true));

		String longitudCodCliente = this.obtenerLongitudCodigoCliente().toString(); 
		asignar("VAR", "longitudCodigoCliente", longitudCodCliente);

        String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR", "hid_SeparadorMiles", separadorMiles);
		asignar("VAR", "hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR", "hid_SeparadorDecimales", separadorDecimales);

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);
		
		// Se cargan los combos de la página
		// jzd, 28/02/2008 this.cargaCombos(dtoBelcorp, "CCCObtieneBancos", "cbBanco");			  
		this.cargaCombos(dtoBelcorp, "CCCObtenerCuentasCorrientesBancarias", "cbBanco");			  

		traza("***Salida -  LPCapturarCupon3 - accionIntroducir ***");
	}


	private void accionVerificar(Long pais, Long idioma) throws Exception {
		pagina("salidaGenerica");
		traza("***Entrada -  LPCapturarCupon3 - accionVerificar ***");
		try {      

			//Caso de uso y titulo de la pantalla
			asignar("VAR", "cerrarVentana", "true");

			DTOCruzarCupon3conCupon1 dtoCruzarCupon3conCupon1 = new DTOCruzarCupon3conCupon1();
			dtoCruzarCupon3conCupon1.setOidPais(pais);
			dtoCruzarCupon3conCupon1.setOidIdioma(idioma);
			
			String parametro = conectorParametroLimpia("anyo", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setAnio(parametro);

			parametro = conectorParametroLimpia("mes", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setMes(parametro);

			parametro = conectorParametroLimpia("numero", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setNumero(new Integer(parametro));

			parametro = conectorParametroLimpia("subacceso", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setOidSubacceso(new Long(parametro));

			parametro = conectorParametroLimpia("fechaDigit", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setFechaDigitacion(UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this)));

			parametro = conectorParametroLimpia("refExterna", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setReferenciaExterna(parametro);

			parametro = conectorParametroLimpia("observaciones", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setObservaciones(parametro);

			parametro = conectorParametroLimpia("textCodCliente", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setCodigoCliente(parametro);

			parametro = conectorParametroLimpia("cbBanco", "", true);
			if (!parametro.equals(""))
				//dtoCruzarCupon3conCupon1.setOidBanco(new Long(parametro));		jzd, 28/02/2008
				dtoCruzarCupon3conCupon1.setOidCtaCteBria(new Long(parametro));

			parametro = conectorParametroLimpia("textImporte", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setImporte(new BigDecimal(this.quitaSeparadorMiles(parametro)));

			parametro = conectorParametroLimpia("textNCupon", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setNumeroCupon(new Integer(parametro));
				
				
			 //--Agregado Inc BELC300019692 
			 //-- Paola Cabrera 15/11/2005
			parametro = conectorParametroLimpia("canal", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setOidCanal(Long.valueOf(parametro));
			
			//cambio fac 03, modulo ccc (SCS-29/01/2008)
			parametro = conectorParametroLimpia("marca", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setOidMarca(Long.valueOf(parametro));
			parametro = conectorParametroLimpia("periodo", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setOidPeriodo(Long.valueOf(parametro));
			
			   
			parametro = conectorParametroLimpia("acceso", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setOidAcceso(Long.valueOf(parametro));
			   
			//-- Fin Agregado Inc BELC300019692  

			parametro = conectorParametroLimpia("textFechaDocumento", "", true);
			if (!parametro.equals(""))
				dtoCruzarCupon3conCupon1.setFechaDoc(UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this)));

			traza("contenido del dto: " + dtoCruzarCupon3conCupon1);

			MareBusinessID idBusiness = new MareBusinessID("CCCCruzarCupon3conCupon1");

			// Se almacenan los parametros de entrada
			Vector paramEntrada = new Vector();
			paramEntrada.addElement(dtoCruzarCupon3conCupon1);
			paramEntrada.addElement(idBusiness);
			traza("***LPCapturarCupon3 -1 ***");

			// Se invoca al conector ConectorConsulta para validar los datos
			DruidaConector conector = conectar("ConectorCruzarCupon3conCupon1", paramEntrada);

			asignar("VAR", "ejecutar", "verificacionCorrecta()");

		} catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", "verificacionIncorrecta();");
		 throw e;
        }

		traza("***Salida -  LPCapturarCupon3 - accionVerificar ***");
	}

	
	private void cargaCombos(DTOBelcorp dtoBelcorp, String idBusiness, String combo) throws Exception {
		traza("*** Entrada - LPCapturarCupon3 - cargaCombos ***");
	
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();
		elem.setIDBusiness(idBusiness);
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);



		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();

		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
		asignar("COMBO", combo, conConsultar, idBusiness); 

		traza("*** Salida - LPCapturarCupon3 - cargaCombos ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());
	
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);
	      
	      traza("Stack Trace: " + baos.toString());
	}
	
	private String quitaSeparadorMiles(String parametro) {
		String resultado = "";
		String separadorMiles = ",";
		if ((UtilidadesSession.getSeparadorDecimales(this)).equals(",")) separadorMiles = ".";

		if (parametro != null) {
			//quitar separador miles
			java.util.StringTokenizer st = new java.util.StringTokenizer(parametro, separadorMiles);
			while (st.countTokens() > 0){
				resultado += st.nextToken();
			}
			//Convertir separador decimal a '.' si es necesario
			if (UtilidadesSession.getSeparadorDecimales(this).equals(",")) {
				resultado = resultado.replace(',', '.' );
			}

			return resultado;
		}else return null;
	}
	
     
}