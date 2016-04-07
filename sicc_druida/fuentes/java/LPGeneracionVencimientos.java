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
    $Id: LPGeneracionVencimientos.java,v 1.1 2009/12/03 18:36:17 pecbazalar Exp $
    DESC
 */
//import LPSICCBase;

import es.indra.sicc.util.UtilidadesSession;
import java.util.Vector;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.druida.Contexto;

import es.indra.sicc.dtos.ccc.DTOCargaInicialGeneracionVencimientos;
import es.indra.sicc.dtos.ccc.DTOCargaMasiva;
import es.indra.sicc.dtos.ccc.DTOCargaInicialCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCasoUso;
import es.indra.sicc.dtos.ccc.DTOValidarNumeroDocumento;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.util.DTOOID;

// Definicion de la clase
public class LPGeneracionVencimientos extends LPSICCBase {
	     
	private String accion = null;
	
	public LPGeneracionVencimientos() {
		super();
	}
	
	public void inicio() throws Exception {
		// Asignar nombre de la vista
		pagina("contenido_vencimientos_generacion");	
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("***Entrada -  LPGeneracionVencimientos - ejecucion ***");

		this.accion = conectorParametroLimpia("accion","", true);
		traza("***accion recuperada ***"+ this.accion);

		try {
			// Se obtiene la sesión
			traza("*** paso1 ***");
			Long pais = UtilidadesSession.getPais(this);
			traza("*** paso2 ***");
			Long idioma = UtilidadesSession.getIdioma(this);
			traza("*** paso3 ***");

			if (this.accion.equals("")) {
				traza("***llamando accionVacia ***");
				accionVacia(pais, idioma);
			} else if (this.accion.equals("AceptarEnvioArchivo")) {
				accionAceptarEnvio(pais, idioma);
			} else if (this.accion.equals("validarNroDucumento")) {
				accionValidarNroDucumento();
			}

		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e); 
		}
	
		getConfiguracionMenu("LPGeneracionVencimientos",accion);

		traza("***Salida -  LPGeneracionVencimientos - ejecucion ***");
	}
	
	private void accionVacia(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPGeneracionVencimientos - accionVacia ***");
		
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA","contenido_vencimientos_generacion","cod","0391");
		asignarAtributo("PAGINA","contenido_vencimientos_generacion","msgle","Generación de vencimientos");

		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		this.generarHiddenFormatoFecha();
		// Buscamos el parámetro codigoCliente
		String codigoCliente = conectorParametroLimpia("codigoCliente","", true);
		traza("codigoCliente = " + codigoCliente);
		if (!codigoCliente.equals("")) {
			traza("*** dentro de if desabilitar ***");
			asignarAtributo("TEXT","txtCodCliente","valor",codigoCliente);
			asignarAtributo("TEXT","txtCodCliente","disabled","S");
			asignarAtributo("IMG","imgBuscarCliente","onclick","");
		}		
		
		
		// Se crea idNegocio = "CCCCargaInicialGeneracionVencimientos"
		MareBusinessID idBussiness = new MareBusinessID("CCCCargaInicialGeneracionVencimientos");
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);
		      
		
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoBelcorp);
		paramEntrada.addElement(idBussiness);

		// Se invoca al conector ConectorCargaInicialVencimientos
		traza("*** invocamos conector ***");
		DruidaConector conector = conectar("ConectorCargaInicialVencimientos", paramEntrada);
		traza("*** conector invocado ***");
	
		// Se recibe un DTOCargaInicialGeneracionVencimientos devuelto por el conector
		DTOCargaInicialGeneracionVencimientos dtoCargaInicial = null;
		dtoCargaInicial = (DTOCargaInicialGeneracionVencimientos)conector.objeto("DTOCargaInicialGeneracionVencimientos");
		traza("*** cargando DTOCargaInicial ***"+ dtoCargaInicial);
		// Cargamos el campo oculto tasaCambioMonedaAlternativa con el atributo de dtoCargaInicial.
		BigDecimal tasaCambioMoneda = dtoCargaInicial.getTasaCambioMonedaAlternativa();
		traza("*** tasaCambioMoneda ***"+ tasaCambioMoneda);

		if(tasaCambioMoneda!=null) {
			asignarAtributo("VAR", "tasaCambioMonedaAlternativa", "valor", tasaCambioMoneda.toString());
		}
		else {
			asignarAtributo("VAR", "tasaCambioMonedaAlternativa", "valor", "1");
		}
		

		//Codigo para guardar valores de sesion en hiddens de la página donde se debe hacer la validacion
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		traza("*** separadorDecimales ***"+ separadorDecimales);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		String fecha = UtilidadesBelcorp.fechaFormateada(new Date(), UtilidadesSession.getFormatoFecha(this));
		traza("*** fecha ***"+ fecha);
		String longitudCodCliente = obtenerLongitudCodigoCliente().toString(); 
		traza("*** longitudCodCliente ***"+ longitudCodCliente);
		asignar("VAR", "fechaSistema", fecha);
		asignar("VAR", "longitudCodigoCliente", longitudCodCliente);
		asignarAtributo("TEXT","txtCodCliente", "max", longitudCodCliente);
		traza("*** Recuperar datos ocultos ***");
		asignar("CTEXTO","txtFechaValor",fecha);
		asignar("CTEXTO","txtFechaVencimiento",fecha);

		//Cargar combos canal,acceso y subacceso
		String canal = conectorParametroLimpia("canal","", true);
		asignar("VAR", "canal", canal);

		String acceso = conectorParametroLimpia("acceso","", true);
		asignar("VAR", "acceso", acceso);

		String subacceso = conectorParametroLimpia("subacceso","", true);
		asignar("VAR", "subacceso", subacceso);


		// Se cargan los combos de la página
		this.cargaCombos(dtoBelcorp, canal, acceso, subacceso);


		traza("***Salida -  LPGeneracionVencimientos - accionVacia ***");
	}
	
	private void accionAceptarEnvio(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPGeneracionVencimientos - accionAceptarEnvio ***");
		
		//Debemos obtener la ruta del archivo.
		String nombreArchivo = Contexto.getPropiedad("TMP.UPLOAD2") + "/" + conectorParametroLimpia("nombreArchivo", "", true);
		
		String archivoProcesado[][] = this.procesarArchivo(nombreArchivo);

		if (archivoProcesado != null) {
			traza("archivoProcesado= "+ archivoProcesado[0][5]);
			traza("nombreArchivo= "+nombreArchivo);
			UtilidadesSession session = new UtilidadesSession();
			
			// Se instancia un DTOCargaMasiva
			DTOCargaMasiva dtoCargaMasiva = new DTOCargaMasiva();
			dtoCargaMasiva.setOidPais(pais);
			dtoCargaMasiva.setOidIdioma(idioma);
			dtoCargaMasiva.setElementos(archivoProcesado);
			
			traza("DTOCargaMasiva= "+ dtoCargaMasiva);
			// Se crea idNegocio = "CCCValidarCarteraMasiva"
			MareBusinessID idBusiness = new MareBusinessID("CCCValidarCarteraMasiva");
			
			// Se almacenan los parametros de entrada
			Vector paramEntrada = new Vector();
			paramEntrada.addElement(dtoCargaMasiva);
			paramEntrada.addElement(idBusiness);
			
			traza("***Llamamos al conector ***");
			// Se invoca al conector ConectorConsulta para validar los datos
			DruidaConector conector = conectar("ConectorConsulta", paramEntrada);
			
			traza("***Sacamos el DTOSalida ***");
			// Se recibe un DTOCargaInicialGeneracionVencimientos devuelto por el conector
			DTOCargaMasiva dtoCargaMasivaValidada = null;
			dtoCargaMasivaValidada = (DTOCargaMasiva)conector.objeto("DTOSalida");
			traza("***Metemos los datos en el array ***");
			String datosRetorno[][] = dtoCargaMasivaValidada.getElementos();
	
			
			
			// Con los datos de dtoCargaMasivaValidada vamos a crear un recordSet para poder rellenar el MATRIZJS
			//datosRetorno de la página.
			RecordSet rs = new RecordSet();
			if (datosRetorno.length!=0){
				traza("***Dentro del if ***");
				for (int i=0; i<datosRetorno[0].length; i++){
					traza("***insertamos las columnas ***");
					rs.addColumn("Columna"+String.valueOf(i));
				}
			}
			for (int i=0; i<datosRetorno.length; i++){
				traza("***Insertamos los datos en rs ***");
				rs.addRow(datosRetorno[i]);
			}
	
			// Si el recordset no es nulo rellenamos datosRetorno con sus datos.
			if (rs != null) {
				traza("***El recordset no esta vacío ***");
				Vector cols = rs.getColumnIdentifiers();
				traza("***Llamamos al conector ***");
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector("DTOSalida.matriz_ROWSET", rs, cols);
	    		traza("***asignamos a la MATRIZJS ***");
	    		asignar("MATRIZJS", "datosRetorno", conectorCargaCombo);
	    	}
		}
		// Añado la llamada a una nueva función en el evento onLoad de la página para que llame a la función 
		//JavaScript accionAceptarEnvio definida en el js que cerrará la página y devolverá los datos 
		//almacenados en arrConsulta.
		String strEventosPorDefecto = "onLoadPag();";
		//asignarAtributoPagina("onload", "accionAceptarEnvio();" + strEventosPorDefecto);
		asignarAtributo("PAGINA", "contenido_vencimientos_generacion", "onload", "accionAceptarEnvio();" + strEventosPorDefecto);
		
		//Codigo para guardar valores de sesion en hiddens de la página donde se debe hacer la validacion
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		traza("*** separadorDecimales ***"+ separadorDecimales);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);

		
		traza("***Salida -  LPGeneracionVencimientos - accionAceptarEnvio ***");
	}
	

	private void accionValidarNroDucumento() throws Exception {
		traza("Entrada - LPGenerarVencimientos - accionValidarNroDucumento");
		Long idioma = UtilidadesSession.getIdioma(this);
		Long pais = UtilidadesSession.getPais(this);
		traza("idioma " + idioma + "pais " + pais );
		String numeroDocumento = conectorParametroLimpia("hNroDucumento","", true);
		String codigoCliente = conectorParametroLimpia("hCodigoCliente","", true);
		traza("numeroDocumento " + numeroDocumento + "codigoCliente " + codigoCliente );

		DTOValidarNumeroDocumento dto = new DTOValidarNumeroDocumento();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		dto.setNumeroDocumento(new Long(numeroDocumento));
		dto.setCodigoCliente(codigoCliente);
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("CCCValidarNroDocumento"));
		DruidaConector conector = conectar("ConectorValidarNroDocumento", paramEntrada);
		DTOString dtoString = (DTOString)conector.objeto("dtoString");
		String estadoValidacionNroDocumento = dtoString.getCadena();
		traza("estadoValidacionNroDocumento: " + estadoValidacionNroDocumento);
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignarAtributo("VAR", "ejecutar", "valor", "postValidarNroDucumento('"+ estadoValidacionNroDocumento.toString() + "')");
	}


	private void cargaCombos(DTOBelcorp dtoBelcorp, String canal, String acceso, String subacceso) throws Exception {
		traza("*** Entrada - LPGeneracionVencimientos - cargaCombos ***");
	
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem=new ComposerViewElement();
		elem.setIDBusiness("SEGConsultaMarcas");
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);

		elem=new ComposerViewElement(); 
		elem.setIDBusiness("BELObtenerMediosPagoCombo"); 
		elem.setDTOE(dtoBelcorp); 
		listelem.addViewElement(elem); 

		elem=new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaCanales"); 
		elem.setDTOE(dtoBelcorp); 
		listelem.addViewElement(elem); 
		
		if (!canal.equals("")) {
			DTOAccesosPorCanal dtoAPC = new DTOAccesosPorCanal();
			dtoAPC.setOidPais(dtoBelcorp.getOidPais());
			dtoAPC.setOidIdioma(dtoBelcorp.getOidIdioma());
			dtoAPC.setOidCanal(new Long(canal));
			elem=new ComposerViewElement(); 
			elem.setIDBusiness("SEGObtenerAccesosPorCanal"); 
			elem.setDTOE(dtoAPC); 
			listelem.addViewElement(elem);
		}

		if (!acceso.equals("")) {
			DTOOID dtoSPA = new DTOOID();
			dtoSPA.setOidPais(dtoBelcorp.getOidPais());
			dtoSPA.setOidIdioma(dtoBelcorp.getOidIdioma());
			dtoSPA.setOid(new Long(acceso));
			elem=new ComposerViewElement(); 
			elem.setIDBusiness("SegObtenerSubaccesosPorAcceso"); 
			elem.setDTOE(dtoSPA); 
			listelem.addViewElement(elem);
		}

		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();

		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
		asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 

		asignar("COMBO", "cbMedioPago", conConsultar, "BELObtenerMediosPagoCombo");

		if (canal.equals(""))
			asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales");
		else
			asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales", "VAL_OID", canal);
			
		if (!canal.equals("")) {
			if (acceso.equals(""))
				asignar("COMBO", "cbAcceso", conConsultar, "SEGObtenerAccesosPorCanal");
			else
				asignar("COMBO", "cbAcceso", conConsultar, "SEGObtenerAccesosPorCanal", "VAL_OID", acceso);
		}

		if (!acceso.equals("")) {
			if (subacceso.equals(""))
				asignar("COMBO", "cbSubacceso", conConsultar, "SegObtenerSubaccesosPorAcceso");
			else
				asignar("COMBO", "cbSubacceso", conConsultar, "SegObtenerSubaccesosPorAcceso", "OID_SBAC", subacceso);
		}

		traza("*** Salida - LPGeneracionVencimientos - cargaCombos ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());
	
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);
	      
	      traza("Stack Trace: " + baos.toString());
	}
     
	private String[][] procesarArchivo (String file) throws Exception {
		traza("*** Entrada - LPGeneracionVencimientos - procesarArchivo ***");
		
		List lista = new ArrayList();
		String s;
		int numFila = 0;
		
		// Inserto el contenido de texto en el ArrayList lista.
		FileReader fr = new FileReader(file);
		BufferedReader entrada = new BufferedReader(fr);

		while ((s = entrada.readLine())!= null) {
			String[] fila = new String[14];
			StringTokenizer st = new StringTokenizer(s, ";", true); //cogemos también los separadores para no perder tokens vacíos

			for (int i = 0; i < 14; i++) {
				if (st.hasMoreElements()) {
					fila[i] = st.nextToken();
					if (fila[i].equals(";")) fila[i] = "";
					else if (st.hasMoreElements()) {
						st.nextToken();
					}
				} else fila[i] = "";

				//cada fila debe tener informados: cliente, marca, canal, acceso, subacceso, nº documento, medio_pago
				if ((i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7) && fila[i].equals("") ) {
					return null;
				}

				//cada fila debe tener informados: nº documento numericos
				if (i == 5) {
					try {
						new Long(fila[i]);
					} catch (NumberFormatException n) {
						return null;
					}
				}

				if ((i == 9 || i == 10) && !fila[i].equals("") ) {
					try {
						new BigDecimal(fila[i].replace(',', '.' ));
					} catch (NumberFormatException n) {
						return null;
					}
					fila[i] = this.formateaImporte(fila[i]);
				}					

				traza("fila["+i+"] = "+fila[i]);
			}
			
			lista.add(numFila, fila);
			numFila++;
		}
		
		// Cierro el fichero.
		fr.close();
		traza("cerrado fichero");
		// Si puedo borro el fichero.
		File fichero = new File(file);
		try {
			traza("borramos fichero");
			fichero.delete();
		}catch(Exception e){}
		
		traza("inserto contenido del ArrayList");
		// Inserto el contenido del ArrayList lista en un array bidimensional.
		String arrArchivo[][] = new String[lista.size()][14];
		
		for (int i = 0; i < lista.size(); i++) {
			String[] fila;
			traza("sacamos cada elemento");
			fila = (String[]) lista.get(i);
			traza("elemento introducido"+ fila);
			for (int j = 0; j<14; j++) {
				traza("dentro del for");
				arrArchivo[i][j] = fila[j];
			}
		}
		
		traza("*** Salida - LPGeneracionVencimientos - procesarArchivo ***");
		return arrArchivo;
	}	

	//método que (Añade los separadores de miles y decimales a un decimal
	//código para pasar un valor procedente de un archivo csv al formato numérico del usuario
	private String formateaImporte(String dineroEntrada){
		String separadorMiles = ",";
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String numeroDecimales = UtilidadesSession.getFormatoNumerico(this);
		if (separadorDecimales.equals(",")) separadorMiles=".";
        String signo = "";
		if (dineroEntrada.startsWith("-", 0)) {
			signo = "-";
			dineroEntrada = dineroEntrada.substring(1);
		}                
		
		StringTokenizer tokens = new StringTokenizer(dineroEntrada, ",");
		StringBuffer bufferEntero=new StringBuffer(tokens.nextToken());// almacena la parte entera.
		StringBuffer bufferDinero=new StringBuffer("");//almacena el resultado
		StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
		
		int miles=0;
		while (bufferEntero.length()>0) {
			miles++;
			bufferDinero.insert(0, bufferEntero.charAt(bufferEntero.length()-1));
			bufferEntero.deleteCharAt(bufferEntero.length()-1);
			if (miles==3 && bufferEntero.length()>0) {
				miles=0;
				bufferDinero.insert(0, separadorMiles);
			}
		}
		if (numeroDecimales != null && tokens.hasMoreTokens()) { 
			bufferDecimales.append(tokens.nextToken());
			if (!bufferDecimales.substring(0, bufferDecimales.length()).equals("00") && !bufferDecimales.substring(0, bufferDecimales.length()).equals("0")) {
				if (numeroDecimales.equals("1")) 
					bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,1));
				else if (numeroDecimales.equals("2")) {
					if (bufferDecimales.length() == 2) 
						bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 2));
					else if (bufferDecimales.length() == 1)
						bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 1) + "0");
				}
			}
		}

		String resultado = signo + bufferDinero.toString();
		return resultado;
	}
}