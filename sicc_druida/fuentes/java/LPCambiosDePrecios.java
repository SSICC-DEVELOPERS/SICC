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

/*
    INDRA/CAR/PROY
    $Id: LPCambiosDePrecios.java,v 1.1 2009/12/03 18:41:50 pecbazalar Exp $
    DESC
*/

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.presentacion.cache.Cache;
import es.indra.sicc.dtos.rec.DTOBuscarGeneracion;
import es.indra.sicc.dtos.rec.DTODatosPreRec;
import es.indra.sicc.dtos.rec.DTOGuardarGeneracion;
import es.indra.sicc.dtos.rec.DTONumDocFecha;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPCambiosDePrecios extends LPSICCBase {
    
	private String accion = null;
	private String casoUso = null;
	private Long idioma = null;
	private Long pais = null;
	private String separadorMiles = null;
	private String separadorDecimales = null;
	

	public LPCambiosDePrecios() {
		super();
	}
	

	public void inicio() throws Exception {
	}
	
	
	public void ejecucion() throws Exception {
	 
      // rastreo(); // no se accede a ella desde el menu principal
     
      try {
         setTrazaFichero(); 
         traza("***Entrada - LPCambiosDePrecios - ejecucion***");
         
         this.accion = conectorParametroLimpia("accion", "", true);
         traza("***accion : " + accion);                   
         
         this.idioma = UtilidadesSession.getIdioma(this); 
         this.pais = UtilidadesSession.getPais(this);

	      // se obtienen el separador de miles y de decimales
	      this.separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
	      this.separadorMiles = ",";
	      if (this.separadorDecimales.equals(",")) {
	         this.separadorMiles = ".";
	      }
	   	traza("separador miles(al darle valor): " + this.separadorMiles);
	   	traza("separador decimales(al darle valor): " + this.separadorDecimales);
         
         if (accion.equals("generarCambios")) {
				this.generarCambios();
         
         } else if (accion.equals("buscar")) {
            this.buscar();
         
         } else if (accion.equals("guardar")) {
				this.guardar();

         } else if (accion.equals("cargarPaginaDetalle")) {
				this.cargarPaginaDetalle();
         }
         
         traza("***Salida - LPCambiosDePrecios - ejecucion***");
                    
      } catch(Exception e) {
         logStackTrace(e);
         lanzarPaginaError(e);
      }
	}
	
	private void generarCambios() throws Exception {
		
		traza("***Entrada - LPCambiosDePrecios - generarCambios***");
		
		pagina("contenido_cambios_precios_masivos_generar");
		asignarAtributo("PAGINA", "contenido_cambios_precios_masivos_generar", "cod", "0148");
		asignarAtributo("PAGINA", "contenido_cambios_precios_masivos_generar", "msgle", "Generar Cambios de Precios Masivos");
		getConfiguracionMenu("LPCambiosDePrecios", "generarCambios");
		// entrada en el menu secundario: 
		// LPCambiosDePrecios/generarCambios = 0148,0,0,1,0,1,1,1,1,1,1

		// en la pagina hay un campo de fecha que habra que validar
      generarHiddenFormatoFecha();		
      
      // se asignan pais e idioma a los campos ocultos de la pantalla
      asignar("VAR", "idioma", this.idioma.toString());
      asignar("VAR", "pais", this.pais.toString());
				
		// Llama al metodo mostrarPantallaGenerar()
		this.mostrarPantallaGenerar();

		// - Crear un DTOE del tipo DTOBelcorp con el pais y el idioma 
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);
		
		traza("antes de conectar");
		
		// - Invocar al conector ConectorObtenerNumeroDocumento con el DTOE 
		// - Crear IDBusiness="RECObtenerNumeroDocumento" 
		Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoe);
      paramsEntrada.add(new MareBusinessID("RECObtenerNumeroDocumento"));
      DruidaConector conector = conectar("ConectorObtenerNumeroDocumento", paramsEntrada);
		
		traza("despues de conectar");
		
		DTONumDocFecha dtoNumDocFecha = (DTONumDocFecha)conector.objeto("DTONumDocFecha");
		
		traza("********** DTONumDocFecha: " + dtoNumDocFecha);
		
		// - numGeneracion = DTONumDocFecha.numDocumento 
		String numDocumento = dtoNumDocFecha.getNumDocumento();
		asignar("LABELC", "lblNumeroGeneracionXX", numDocumento);
		// asigno el valor del numero de generacion a una variable oculta
		asignar("VAR", "valorNumeroGeneracion", numDocumento);

		// - fechaGeneracion = DTONumDocFecha.fecha
		String fecha = UtilidadesBelcorp.fechaFormateada(dtoNumDocFecha.getFechaGenerar(), UtilidadesSession.getFormatoFecha(this));
		traza("fecha formateada: " + fecha);
		asignar("CTEXTO", "txtFechaGeneracion", fecha);
				
		// se asigna el valor de la fecha a un campo oculto de la pagina, para que cuando se de a limpiar
		// se cargue en la caja de texto el valor recuperado en la LP
		asignar("VAR", "valorFechaGeneracion", fecha);
		
		traza("***Salida - LPCambiosDePrecios - generarCambios***");
	}
	
	private void buscar() throws Exception {
		
		traza("***Entrada - LPCambiosDePrecios - buscar***");

      pagina("salidaGenerica");
      asignar("VAR", "cerrarVentana", "true"); // antes estaba a false y dejaba una ventana abierta
		// indicamos que funcion del contenido_cambios_precios_masivos_generar.js se ejecuta al haber ido todo bien
		//asignar("VAR", "ejecutar", "cargarPaginaDetalleJS()");
				
		// - Crear un DTOE del tipo DTOBuscarGeneracion con (ademas del pais y el idioma) : 
		// - oidMarca = oid del valor seleccionado en la cbMarca 
		// - oidCanal = oid del valor seleccionado en la cbCanal 
		// - oidAcceso = oid del valor seleccionado en la cbAcceso 
		// - oidSubAcceso = oid del valor seleccionado en la cbSubAcceso 
		// - arrayTiposSolicitud = arrayList de oids de los valores seleccionados en la cbTipoSolicitud 
		// - oidPeriodo = oid del valor seleccionado en la cbPeriodo 
		// - codVenta = codVenta 
		// - codVentaGenerar = codVentaGenerar 
		// - numGeneracion = numGeneracion 
		// - oidOperacion = oid del valor seleccionado en la cbOperacion 
		// - oidTipoOperacion = oid del valor seleccionado en la 
		// - fechaGeneracion = fechaGeneracion 
		// - observaciones = observaciones 
		DTOBuscarGeneracion dtoe = new DTOBuscarGeneracion();
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);
		dtoe.setOidMarca(new Long(conectorParametroLimpia("cbMarca", "", true)));               
		dtoe.setOidCanal(new Long(conectorParametroLimpia("cbCanal", "", true)));               
		if (! conectorParametroLimpia("cbAcceso", "", true).equals("")) {
			dtoe.setOidAcceso(new Long(conectorParametroLimpia("cbAcceso", "", true)));              
		}
		if (! conectorParametroLimpia("cbSubAcceso", "", true).equals("")) {
			dtoe.setOidSubAcceso(new Long(conectorParametroLimpia("cbSubAcceso", "", true)));           
		}

		// se tratan los tipos de solicitud, que se recogen de un combo multiple
	   String listaTiposSolicitud = conectorParametroLimpia("listaTiposSolicitud", "", true);
	   traza("-------------- listaTiposSolicitud: " + listaTiposSolicitud);
	   StringTokenizer st = new StringTokenizer(listaTiposSolicitud, ",");
	   ArrayList oids = new ArrayList();
	   Long oid = null;
	   while (st.hasMoreTokens()) {
			oid = new Long(st.nextToken());
			oids.add(oid);      
	   }
		dtoe.setArrayTipoSolicitud(oids);

		if (! conectorParametroLimpia("cbPeriodoReferencia", "", true).equals("")) {
			dtoe.setOidPeriodo(new Long(conectorParametroLimpia("cbPeriodoReferencia", "", true)));             
		}
		dtoe.setCodVenta(conectorParametroLimpia("txtCodigoVenta", "", true));             
		dtoe.setCodVentaGenerar(conectorParametroLimpia("txtCodigoVentaGenerar", "", true));      
		dtoe.setNumGeneracion(conectorParametroLimpia("valorNumeroGeneracion", "", true));        
		if (! conectorParametroLimpia("cbCodigoOperacionReclamos", "", true).equals("")) {		
			dtoe.setOidOperacion(new Long(conectorParametroLimpia("cbCodigoOperacionReclamos", "", true)));           
		}
		if (! conectorParametroLimpia("cbTipoOperacion", "", true).equals("")) {		
			dtoe.setOidTipoOperacion(new Long(conectorParametroLimpia("cbTipoOperacion", "", true)));       
		}

		traza("*********  FORMATO FECHA ----> " + UtilidadesSession.getFormatoFecha(this));
		traza("--- valor de la fecha generacion en buscar: " + conectorParametroLimpia("txtFechaGeneracion", "", true));
		traza("*********  FECHA a formatear ----> " + conectorParametroLimpia("txtFechaGeneracion", "", true));
		if (! conectorParametroLimpia("valorFechaGeneracion", "", true).equals("")) {
			dtoe.setFechaGeneracion(
				UtilidadesFecha.convertirAFecha(
					conectorParametroLimpia("valorFechaGeneracion", "", true),
					UtilidadesSession.getFormatoFecha(this)										
				)
			);
		}

		dtoe.setObservaciones(conectorParametroLimpia("areatxtObservaciones", "", true));   		
		

		traza("************* dtoe (DTOBuscarGeneracion): " + dtoe);

		// - Invocar al conector ConectorBuscarGeneracion con el DTOE 
		// - Crear IDBusiness="RECBuscarGeneracion"
		Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoe);
      paramsEntrada.add(new MareBusinessID("RECBuscarGeneracion"));
      DruidaConector conector = conectar("ConectorBuscarGeneracion", paramsEntrada);
		
		DTODatosPreRec dtoDatosPreRec = (DTODatosPreRec)conector.objeto("DTODatosPreRec");		
		
		traza("************* dtoDatosPreRec (DTODatosPreRec) que se introduce en sesión: " + dtoDatosPreRec);
		
		////////////////////////////////////////////////////////////////////
		// se guarda en sesión este DTODatosPreRec obtenido

		//obtenemos la cache de la LP
		Cache cache = this.getSessionCache();
		
		cache.put("dtoDatosPreRec", dtoDatosPreRec);
		
		// indicamos que funcion del contenido_cambios_precios_masivos_generar.js se ejecuta al haber ido todo bien
		asignar("VAR", "ejecutar", "cargarPaginaDetalleJS()");		
		
		traza("***Salida - LPCambiosDePrecios - buscar***");
	}
	
	
	private void cargarPaginaDetalle() throws Exception {
		
		traza("*** Entrada - LPCambiosDePrecios - cargarPaginaDetalle ***");

		// Con el DTODatosPreRec obtenido mostramos la PantallaDetalleGenerarCambios, con los siguientes 
		// campos: Algunos campos los setearemos de los procedentes de la pantalla anterior (con los que 
		// hemos creado el DTOBuscarGeneracion) 
		
		pagina("contenido_cambios_precios_masivos_detalle");
		asignarAtributo("PAGINA", "contenido_cambios_precios_masivos_detalle", "cod", "0148");
		asignarAtributo("PAGINA", "contenido_cambios_precios_masivos_detalle", "msgle", "Generar Cambios de Precios Masivos");
		getConfiguracionMenu("LPCambiosDePrecios", "buscar");
		// entrada en el menu secundario: 
		// LPCambiosDePrecios/buscar = 0148,1,1,0,0,0,1,0,0,0,1
		
		// recuperar de sesión el DTODatosPreRec
		//obtenemos la cache de la lp
		Cache cache = this.getSessionCache();
		
		DTODatosPreRec dtoDatosPreRec = (DTODatosPreRec)cache.get("dtoDatosPreRec");
		
		traza("************* dtoDatosPreRec (DTODatosPreRec) recuperado de sesion: " + dtoDatosPreRec);
		
		// lo eliminamos de sesión
		cache.remove("dtoDatosPreRec");
		
		// codVentaOrigen = DTODatosPreRec. codVentaOrigen 
		// descripcionOrigen = DTODatosPreRec.descripcionOrigen 
		// precioCatalogoOrigen = DTODatosPreRec.precioCatalogoOrigen 
		// tambien asigno los valores de los label a campos ocultos para poder recuperarlos al guardar
		if (dtoDatosPreRec.getCodVentaOrigen() != null) {
			asignar("LABELC", "lbldtCodigoVentaOrigen", dtoDatosPreRec.getCodVentaOrigen());
			asignar("VAR", "codVentaOrigen", dtoDatosPreRec.getCodVentaOrigen());
		}
		if (dtoDatosPreRec.getDescripcionOrigen() != null) {
			asignar("LABELC", "lbldtDescripcionOrigen", dtoDatosPreRec.getDescripcionOrigen());
			asignar("VAR", "descripcionOrigen", dtoDatosPreRec.getDescripcionOrigen());
		}
		if (dtoDatosPreRec.getPrecioCatalogoOrigen() != null) {
			asignar("LABELC", "lbldtPrecioCatalogoOrigen", dtoDatosPreRec.getPrecioCatalogoOrigen().toString());
			asignar("VAR", "precioCatalogoOrigen", dtoDatosPreRec.getPrecioCatalogoOrigen().toString());
		}
				
		// codVentaDestino = DTODatosPreRec.codVentaDestino 
		// descripcionDestino = DTODatosPreRec.descripcionDestino 
		// precioCatalogoDestino = DTODatosPreRec.precioCatalogoDestino
		if (dtoDatosPreRec.getCodVentaDestino() != null) {
			asignar("LABELC", "lbldtCodigoVentaDestino", dtoDatosPreRec.getCodVentaDestino());
			asignar("VAR", "codVentaDestino", dtoDatosPreRec.getCodVentaDestino());
		}
		if (dtoDatosPreRec.getDescripcionDestino() != null) {
			asignar("LABELC", "lbldtDescripcionDestino", dtoDatosPreRec.getDescripcionDestino());
			asignar("VAR", "descripcionDestino", dtoDatosPreRec.getDescripcionDestino());
		}
		// BELC300014874
		if (dtoDatosPreRec.getPrecioCatalogoDestino() != null) {
			asignar("LABELC", "lbldtPrecioCatalogoDestino", dtoDatosPreRec.getPrecioCatalogoDestino().toString());
			asignar("VAR", "precioCatalogoDestino", dtoDatosPreRec.getPrecioCatalogoDestino().toString());
		}		
		
		// numGeneracion = llega como parametro "numGeneracion"
		asignar("VAR", "numGeneracion", conectorParametroLimpia("numGeneracion", "", true));

		// oidAcceso = llega como parametro "oidAcceso"
		asignar("VAR", "oidAcceso", conectorParametroLimpia("oidAcceso", "", true));
		// oidSubAcceso = llega como parametro "oidSubAcceso" 
		asignar("VAR", "oidSubAcceso", conectorParametroLimpia("oidSubAcceso", "", true));
		// oidPeriodo = llega como parametro "oidPeriodo"
		asignar("VAR", "oidPeriodo", conectorParametroLimpia("oidPeriodo", "", true));
		// oidDetalleOfertaOrigen = DTODatosPreRec.oidDetalleOfertaOrigen 
		if (dtoDatosPreRec.getOidDetalleOfertaOrigen() != null) {
			asignar("VAR", "oidDetalleOfertaOrigen", dtoDatosPreRec.getOidDetalleOfertaOrigen().toString());	
		}
		// oidDetalleOfertaDestino = DTODatosPreRec.idDetalleOfertaDestino 
		if (dtoDatosPreRec.getOidDetalleOfertaDestino() != null) {
			asignar("VAR", "oidDetalleOfertaDestino", dtoDatosPreRec.getOidDetalleOfertaDestino().toString());
		}
		// BELC300014892
		// oidPrecioEnvia = DTODatosPreRec.oidPrecioEnvia
		if (dtoDatosPreRec.getOidPrecioEnvia() != null) {
			asignar("VAR", "oidPrecioEnvia", dtoDatosPreRec.getOidPrecioEnvia().toString());
		}
		// arrayTipoSolicitud = la lista que llega de pantalla, separada por ',', en el parametro "tiposSolicSeleccionados"
		asignar("VAR", "arrayTipoSolicitud", conectorParametroLimpia("tiposSolicSeleccionados", "", true)); 

		// observaciones = llega como parametro "observaciones"
		asignar("VAR", "observaciones", conectorParametroLimpia("observaciones", "", true)); 
		
		asignar("VAR", "pais", this.pais.toString());
		asignar("VAR", "idioma", this.idioma.toString());
		
		// aniadido por incidencia 16012
		// oidTipoOperacion = llega como parametro "oidTipoOperacion"
		asignar("VAR", "oidTipoOperacion", conectorParametroLimpia("oidTipoOperacion", "", true));
		
		// aniadido por incidencia BELC300019804 
		traza("---- fecha Generacion en metodo cargarPaginaDetalle(recuperada como parametro desde el JS): " + conectorParametroLimpia("fechaGeneracion", "", true));
		asignar("VAR", "fechaGeneracion", conectorParametroLimpia("fechaGeneracion", "", true));
		
		traza("*** Salida - LPCambiosDePrecios - cargarPaginaDetalle ***");
	}
	
	private void guardar() throws Exception {

		traza("***Entrada - LPCambiosDePrecios - guardar***");
		
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false"); // para que cuando termine de guardar no cierre la ventana
		asignar("VAR", "ejecutar", "ponerGuardadoTrue()");
		//asignar("VAR", "ejecutarError", "ejecutarNoCorrecta()");


		// - Crear un DTOGuardarGeneracion con los parámetros recibidos de la pantalla: 
		// - codVentaOrigen 
		// - descripcionOrigen 
		// - precioCatalogoOrigen 
		// - codVentaDestino 
		// - descripcionDestino 
		// - precioCatalogoDestino 
		// - lstNoGenerar 
		// - numGeneracion 
		// - oidAcceso 
		// - oidSubAcceso 
		// - oidPeriodo 
		// - arrayTipoSolicitud 
		// - oidPrecioEnvia 
		// - oidDetalleOfertaOrigen 
		// - oidDetalleOfertaDestino 
		// - observaciones 

		
		DTOGuardarGeneracion dtoe = new DTOGuardarGeneracion();
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);
		
		// asignamos valor al atributo "lstNoGenerar"
		// recogemos en un RecordSet los valores de la lista editable con los reclamos no generados
		RecordSet rs = new RecordSet();
      
		String lista = conectorParametroLimpia("reclamosNoGenerar", "", true);
		traza("********** lista de reclamos no generar: " + lista);

		StringTokenizer st = null;
		StringTokenizer stFila = null;
		String token = null;
		String fila = "";
		Vector vectorFila = null;
      
		String oidSoliCabe = "";

		// recuperamos los datos de la lista editable en una cadena con el formato:
		// las columnas vienen separadas por el caracter @
		// las filas vienen separadas por el caracter #
                           
		if (! lista.equals("")) {
          
			st = new StringTokenizer(lista, "#");
         
      		// campos de lista
			// oidCliente (columna oculta), cód. cliente, nombre 1, nombre 2, apellido 1, apellido 2, 
			// nº unidades, precio catálogo origen, importe neto origen, descuento origen, 
			// precio catálogo destino, importe neto destino, importe diferencia, oidTipoSolicitud (columna oculta)
			String []nombresColumnas = {"ROWNUM", "OIDCLIENTE", "CODCLIENTE", 
         									"NOMBRE1", "NOMBRE2", "APE1", "APE2",
         									"NUMUNIDADES", 
         									"PRECIOCATALORIG", "IMPORTNETOORIG", "DESCUENTOORIG",
         									"PRECIOCATALDEST", "IMPORTNETODEST", 
         									"IMPORTDIFER", 
         									"OIDTIPOSOLICITUD", "OIDSOLICABE"};
      		rs.setColumnIdentifiers(nombresColumnas);
                
			while (st.countTokens() > 0) {
        		fila = st.nextToken();
            
				if (!fila.equals("")) {
            		stFila = new StringTokenizer(fila, "@");
               
					traza("********** fila: " + fila);
					traza("********** numero de tokens: " + stFila.countTokens());
               
					vectorFila = new Vector();
               
					if (stFila.countTokens() > 0) {
                  
						// si en la lista editable el campo de la columna recuperada es vacio nos llega "-"
						// Si en los campos Long y BigDecimal llega "-" los inicializo a 0
						// Si en los campos String llega "-" los inicializo a ""
										
						// ROWNUM // es el campo del OID del registro
						token = stFila.nextToken();
						oidSoliCabe = String.valueOf(token);
						vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));

						//OIDTIPOSOLICITUD
						//token = stFila.nextToken(); // no se utiliza. Se parsea este campo que corresponde al agregado
													// a la query de DAOCambiosEnPrecios.recuperarRegistros().
                                                    
                        // Agregado SICC20070454 - Rafael Romero - 04/10/2007
                        // Se agrega el procesamiento de este campo
                        // Este campo no se usa para ningun calculo, pero existe en la lista editable como oculto
                        token = stFila.nextToken();
                        // Fin agregado SICC20070454

						// OIDCLIENTE
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
						// CODCLIENTE
						token = stFila.nextToken();
						vectorFila.add(new String(! token.equals("-") ? token : ""));
						// NOMBRE1 
						token = stFila.nextToken();
						vectorFila.add(new String(! token.equals("-") ? token : ""));
						// NOMBRE2 
						token = stFila.nextToken();
						vectorFila.add(new String(! token.equals("-") ? token : ""));
						// APE1 
						token = stFila.nextToken();
						vectorFila.add(new String(! token.equals("-") ? token : ""));
						// APE2 
						token = stFila.nextToken();
						vectorFila.add(new String(! token.equals("-") ? token : ""));
						// NUMUNIDADES 
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
						// PRECIOCATALORIG 
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
						// IMPORTNETOORIG 
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
						// DESCUENTOORIG
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
						// PRECIOCATALDEST 
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
						// IMPORTNETODEST 
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
						// IMPORTDIFER 
						token = stFila.nextToken();
						vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));

						// OIDTIPOSOLICITUD
						token = stFila.nextToken();
						token = this.desFormatearNumero(token, this.FORMATO_DEFAULT);
						vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
						traza("termino OIDTIPOSOLICITUD");

						// Modifcado SiCC20070454 - Rafael Romero - 04/10/2007
                        //ESP1 (viene vacio)
						//token = stFila.nextToken();

						//traza("termino ESP1");

						//ESP2 (viene vacio)
						//token = stFila.nextToken();

						//traza("termino ESP2");
                        // Fin modificado SICC20070454

						//28/07/2006 mmaidana - Comentado. El ultimo campo tiene el mismo valor que el primero.
						//						Se estaba accediendo a la posicion 18 cuando la lista tiene 17 
						//						columnas.
						//OIDSOLICABE 
						//token = stFila.nextToken();
						vectorFila.add(new BigDecimal(!oidSoliCabe.equals("-") ? oidSoliCabe : "0"));
						//28/07/2006 FIN modificado mmaidana.

						traza("termino OIDSOLICABE");

						traza("Vector para el recordSet: " + vectorFila);

						rs.addRow(vectorFila);
					}
				}
			}
		}

		dtoe.setLstNoGenerar(rs); // es un RecordSet con los campos de la lista de no generar (la segunda de la pagina)
		
		if (! conectorParametroLimpia("oidAcceso", "", true).equals("")) {
			dtoe.setOidAcceso(new Long(conectorParametroLimpia("oidAcceso", "", true)));
		}
		if (! conectorParametroLimpia("oidSubAcceso", "", true).equals("")) {
			dtoe.setOidSubAcceso(new Long(conectorParametroLimpia("oidSubAcceso", "", true)));
		}
		if (! conectorParametroLimpia("oidPeriodo", "", true).equals("")) {
			dtoe.setOidPeriodo(new Long(conectorParametroLimpia("oidPeriodo", "", true)));
		}
		
		traza("arrayTipoSolicitud: " + conectorParametroLimpia("arrayTipoSolicitud", "", true));
		st = new StringTokenizer(conectorParametroLimpia("arrayTipoSolicitud", "", true), ",");
		ArrayList oids = new ArrayList();
		Long oid = null;
		while (st.hasMoreTokens()) {
			oid = new Long(st.nextToken());
			oids.add(oid);      
		}

		dtoe.setArrayTipoSolicitud(oids);
		
		dtoe.setObservaciones(conectorParametroLimpia("observaciones", "", true));

		dtoe.setNumGeneracion(conectorParametroLimpia("numGeneracion", "", true));
		if (! conectorParametroLimpia("oidDetalleOfertaOrigen", "", true).equals("")) {
			dtoe.setOidDetalleOfertaOrigen(new Long(conectorParametroLimpia("oidDetalleOfertaOrigen", "", true)));
		}
		dtoe.setCodVentaOrigen(conectorParametroLimpia("codVentaOrigen", "", true));   
		dtoe.setDescripcionOrigen(conectorParametroLimpia("descripcionOrigen", "", true));
		if (! conectorParametroLimpia("precioCatalogoOrigen", "", true).equals("")) {
			dtoe.setPrecioCatalogoOrigen(new BigDecimal(conectorParametroLimpia("precioCatalogoOrigen", "", true)));   
		}
		if (! conectorParametroLimpia("oidDetalleOfertaDestino", "", true).equals("")) {
			dtoe.setOidDetalleOfertaDestino(new Long(conectorParametroLimpia("oidDetalleOfertaDestino", "", true)));
		}
		dtoe.setCodVentaDestino(conectorParametroLimpia("codVentaDestino", "", true));
		dtoe.setDescripcionDestino(conectorParametroLimpia("descripcionDestino", "", true));
		
		if (! conectorParametroLimpia("precioCatalogoDestino", "", true).equals("")) {
			dtoe.setPrecioCatalogoDestino(new BigDecimal(obtenerPrecioFormateado(conectorParametroLimpia("precioCatalogoDestino", "", true))));
		}
		// BELC300014892
		if (! conectorParametroLimpia("oidPrecioEnvia", "", true).equals("")) {
			dtoe.setOidPrecioEnvia(new Long(conectorParametroLimpia("oidPrecioEnvia", "", true)));
		}

		// Incidencia 16012 
		if (! conectorParametroLimpia("oidTipoOperacion", "", true).equals("")) {
			dtoe.setOidTipoOperacion(new Long(conectorParametroLimpia("oidTipoOperacion", "", true)));
		}
		
		// Incidencia BELC300019804  
		traza("*********  FORMATO FECHA en guardar ----> " + UtilidadesSession.getFormatoFecha(this));
		traza("--- valor de la fecha generacion en guardar: " + conectorParametroLimpia("fechaGeneracion", "", true));
		//UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))
		if (! conectorParametroLimpia("fechaGeneracion", "", true).equals("")) {
			dtoe.setFechaGeneracion(UtilidadesBelcorp.getDatefromSICCStringFormat(
													conectorParametroLimpia("fechaGeneracion", "", true),
													UtilidadesSession.getFormatoFecha(this)));
		}		
		
		traza("************** Antes de llamar a ConectorGuardarGeneracion. DTOGuardarGeneracion creado: " + dtoe);
		traza("numGeneracion: " + dtoe.getNumGeneracion());  
		traza("oidDetalleOfertaOrigen: " + dtoe.getOidDetalleOfertaOrigen());    
		traza("codVentaOrigen: " + dtoe.getCodVentaOrigen());  
		traza("descripcionOrigen: " + dtoe.getDescripcionOrigen());  
		traza("precioCatalogoOrigen: " + dtoe.getPrecioCatalogoOrigen());
		traza("oidDetalleOfertaDestino: " + dtoe.getOidDetalleOfertaDestino());    
		traza("codVentaDestino: " + dtoe.getCodVentaDestino());  
		traza("descripcionDestino: " + dtoe.getDescripcionDestino());  
		traza("precioCatalogoDestino: " + dtoe.getPrecioCatalogoDestino());
		traza("oidPrecioEnvia: " + dtoe.getOidPrecioEnvia());   
		traza("oidTipoOperacion: " + dtoe.getOidTipoOperacion());    
		traza("fechaGeneracion: " + dtoe.getFechaGeneracion());    
		traza("oidPais: " + dtoe.getOidPais());    
		traza("oidIdioma: " + dtoe.getOidIdioma());    
		
		
		// Invocar al conector ConectorGuardarGeneracion con el DTOE 
		// Crear IDBusiness="RECGuardarGeneracion" 
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoe);
		paramsEntrada.add(new MareBusinessID("RECGuardarGeneracion"));
		DruidaConector conector = conectar("ConectorGuardarGeneracion", paramsEntrada);
      
		// Se deja en la sesion el oidCabecera = DTOOid.oid recuperado
		// pues lo necesitaremos para generar un reclamo

		// Recuperar el DTOOID devuelto 
		DTOOID dtoOid = (DTOOID)conector.objeto("DTOOID");
		
		traza("************ DTOOID.oid recuperado: " + dtoOid.getOid());
		
		Cache cache = this.getSessionCache();
		cache.put("oidCabecera", dtoOid.getOid());

		traza("***Salida - LPCambiosDePrecios - guardar***");
	}
	
	private void mostrarPantallaGenerar() throws Exception {

		traza("***Entrada - LPCambiosDePrecios - mostrarPantallaGenerar***");

		// Crear un DTOBelcorp dtoe con: 
		// - pais = Pais activo 
		// - idioma = Idioma del usuario 
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);
		
		traza("-------------- DTOBelcorp en mostrarPantallaGenerar: " + dtoe);
		
		// Crear una lista ComposerViewElementList
		ComposerViewElementList listelem = new ComposerViewElementList();
	   ComposerViewElement elem = null;

		//Canales 
		// Crear un elemento de tipo ComposerViewElement() para cargar los canales
		// elem.IDBusiness="SEGConsultaCanales"; 
		// elem.DTOE=dtoe;
		// elem.posOID=1;
		// elem.posDesc=3;
		// Añadir el elemento a la lista
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaCanales");
		elem.setDTOE(dtoe);
		elem.setPosOID(new Byte("0").byteValue()); 
		elem.setPosDesc(new Byte("1").byteValue());
		listelem.addViewElement(elem);

		//Marcas 
		// Crear un elemento de tipo ComposerViewElement() para cargar las marcas 
		// elem.IDBusiness="SEGConsultaMarcas"; 
		// elem.DTOE=dtoe; 
		// elem.posOID=1; 
		// elem.posDesc=3; 
		// Añadir el elemento a la lista 
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaMarcas");
		elem.setDTOE(dtoe);
		elem.setPosOID(new Byte("0").byteValue()); 
		elem.setPosDesc(new Byte("1").byteValue());
		listelem.addViewElement(elem);
		
		//TipoSolicitud // De seleccion múltiple 
		// Crear un elemento de tipo ComposerViewElement() para cargar los TipoSolicitudGenera 
		// elem.IDBusiness="PEDobtieneTiposSolicitudPorPais"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("PEDconsultaTiposConsolidado");
		elem.setDTOE(dtoe);
		elem.setPosOID(new Byte("0").byteValue()); 
		elem.setPosDesc(new Byte("1").byteValue());
		listelem.addViewElement(elem);

		// BELC300014945
		//Codigos Operacion 
		// Crear un elemento de tipo ComposerViewElement() para cargar los TipoSolicitudGenera 
		// elem.IDBusiness="RECObtenerCodigosOperacion"; 
		// elem.DTOE=dtoe; 
		// Añadir el elemento a la lista 
		
		//Se ha cambiado la fachada por la incidencia 14945
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("RECObtenerCodigosOperacion");
		elem.setDTOE(dtoe);
		elem.setPosOID(new Byte("0").byteValue()); 
		elem.setPosDesc(new Byte("1").byteValue());
		listelem.addViewElement(elem);
		
        //inc. 23152
        this.obtenerOidCanalAccesoSubAcceso();
        
        
		traza("--------------- antes de conectar");
		// Invocar al subsistema GestorCargaPantalla 
        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
      
        conector.ejecucion();
      
      DruidaConector conConsultar = conector.getConector();
      
      traza("--------------- despues de conectar");
            
      // cada usuario tiene una marca y canal por defecto que deben seleccionarse
      Long marca = UtilidadesSession.getMarcaPorDefecto(this);
      Long canal = UtilidadesSession.getCanalPorDefecto(this);
      
      // se asignan estos valores a campos ocultos de la pagina
      asignar("VAR", "oidMarca", marca.toString());
      asignar("VAR", "oidCanal", canal.toString()); 
      
		traza("oidMarca: " + marca.toString());
		traza("oidCanal: " + canal.toString());

      // Asigna los combos: 
		
		// - cbCanal <- SEGConsultaCanales
		asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales", "VAL_OID", canal.toString()); 
		
		// - cbMarca <- SEGConsultaMarcas 
		asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas", "VAL_OID", marca.toString());
		
		// - cbTipoSolicitud <- PEDobtieneTiposSolicitudPorPais
		asignar("COMBO", "cbTipoSolicitud", conConsultar, "PEDconsultaTiposConsolidado");
		
		// - cbCodOperacion <- RECObtenerCodigosOperacion
		asignar("COMBO", "cbCodigoOperacionReclamos", conConsultar, "RECObtenerCodigosOperacion");
		
		traza("***Salida - LPCambiosDePrecios - mostrarPantallaGenerar***");	
	}

	protected void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		                    
		traza("Stack Trace: " + baos.toString());
	}
	
   // esta funcion se utiliza para tratar cantidades monetarias
   // Se obtiene una cadena de texto eliminando el separador de miles y haciendo
   // que el separador de decimales sea '.'
   private String obtenerPrecioFormateado(String cantidad) throws Exception {
   	
   	traza("*** Entrada - LPCambiosDePrecios - obtenerPrecioFormateado ***");
   	
   	traza("---- cantidad a formatear: " + cantidad);
  
      String resultado = new String("");
      Character separaMiles = new Character(this.separadorMiles.charAt(0));
      Character car = null;
      
      // primero eliminamos el separador de miles
      
      for (int i=0; i < cantidad.length(); i++) {
          car = new Character(cantidad.charAt(i));
          if (car.compareTo(separaMiles) != 0) {
             resultado += new String(car.toString());
          }
      }
     
      resultado = resultado.replace(this.separadorDecimales.charAt(0), '.');

      traza("---- cantidad formateada: " + resultado);
      
      traza("*** Salida - LPCambiosDePrecios - obtenerPrecioFormateado ***");
      
      return resultado;
 	}	

    /**
     * @author mmaidana
     * @date 21/09/2006
     * Creado por incidencia 23152
     */
    private void obtenerOidCanalAccesoSubAcceso() throws Exception {
        traza("LPCambiosDePrecios.obtenerOidCanalAccesoSubAcceso() - ENTRADA");
    
        DruidaConector con = null;
        DTOSalida dto = null;
        RecordSet rs = null;
        String canal = "";
        String acceso = "";
        String subAcceso = "";
    
        MareBusinessID id = new MareBusinessID("SEGObtenerOidCanalAccesoSubAcceso");
        Vector params = new Vector();
        params.add(new DTOBelcorp());
        params.add(id);
        con = this.conectar("ConectorObtenerOidCanalAccesoSubAcceso", params);
        
        if (con != null){
            dto = (DTOSalida)con.objeto("dtoSalida");
            
            if (dto != null){
                rs = dto.getResultado();

                if (rs != null && !rs.esVacio()){
                    if (rs.getValueAt(0, "CANAL") != null){
                        canal = rs.getValueAt(0, "CANAL").toString();
                    }
                    if (rs.getValueAt(0, "ACCESO") != null){
                        acceso = rs.getValueAt(0, "ACCESO").toString();
                    }
                    if (rs.getValueAt(0, "SUBACCESO") != null){
                        subAcceso = rs.getValueAt(0, "SUBACCESO").toString();
                    }
                }
            }
        }
        
        traza("canal: " + canal);
        traza("acceso: " + acceso);
        traza("subAcceso: " + subAcceso);
        
        //this.asignarAtributo("VAR", "valorDefectoCanal", "valor", canal);
        //this.asignarAtributo("VAR", "valorDefectoAcceso", "valor", acceso);
        //this.asignarAtributo("VAR", "valorDefectoSubAcceso", "valor", subAcceso);

	    this.asignar("VAR", "valorDefectoCanal", canal);
        this.asignar("VAR", "valorDefectoAcceso", acceso);
        this.asignar("VAR", "valorDefectoSubAcceso", subAcceso);


        traza("LPCambiosDePrecios.obtenerOidCanalAccesoSubAcceso() - SALIDA");
    }
}	
