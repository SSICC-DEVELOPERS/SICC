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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.util.Vector;
import java.util.Date;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ccc.DTOCargaInicialSeleccion;
import es.indra.sicc.dtos.ccc.DTOBuscarSaldosMorosos;
import es.indra.sicc.dtos.ccc.DTOAplicarIncobrables;

import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOString;
 
 // Definicion de la clase
public class LPSeleccionarProvisionesDepuraciones extends LPSICCBase {
    // Definicion del constructor
    public LPSeleccionarProvisionesDepuraciones() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

             // Defino el nombre de la vista
             pagina("contenido_saldos_morosos_buscar");
    }

    // Definicion del metodo abstracto ejecucion
	// De acuerdo con la incidencia BELC300003807 se quita la acción buscar
	public void ejecucion() throws Exception {
		try  {	
		    setTrazaFichero();
        traza("LPSeleccionarProvisionesDepuraciones Entrada");
        String accion = conectorParametroLimpia("accion", "", true);
        if(accion.equals("")){
          this.accionVacia();							
        }else if(accion.equals("aplicarIncobrables")){
		    	this.accionAplicarIncobrables();
        }
	      getConfiguracionMenu("LPSeleccionarProvisionesDepuraciones",accion);

			traza("LPSeleccionarProvisionesDepuraciones Salida");
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}
	}

	private void accionVacia() throws Exception{
		traza("LPSeleccionarProvisionesDepuraciones.accionVacia Entrada");


		//Título de la pantalla
		asignarAtributo("PAGINA","contenido_saldos_morosos_buscar","cod","0200");
		asignarAtributo("PAGINA","contenido_saldos_morosos_buscar","msgle","Seleccionar provisiones depuraciones");

		this.generaHiddensFormato();

		// Rellenamos fechaImputación (textFechaImputacionProceso), fechaDocumentoDesde (textFechaDocD) y fechaDocumentoHasta (textFechaDocH)
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		String textFechaImputacionProceso =  UtilidadesBelcorp.fechaFormateada(new Date(), formatoFecha);
		asignar("CTEXTO", "textFechaImputacionProceso", textFechaImputacionProceso.toString());
		Date dtFechaDocD = UtilidadesFecha.convertirAFecha("2000-01-01");
		String fechaDocumentoDesde =  UtilidadesBelcorp.fechaFormateada(dtFechaDocD, formatoFecha);
		asignar("CTEXTO", "textFechaDocD", fechaDocumentoDesde.toString());

		Date dtFechaVenD = UtilidadesFecha.convertirAFecha("2000-01-01");
		String fechaVencimientoDesde =  UtilidadesBelcorp.fechaFormateada(dtFechaVenD, formatoFecha);
		asignar("CTEXTO", "textFechaVenD", fechaVencimientoDesde.toString());

		Date dtFechaVenH = UtilidadesFecha.minusDays(new Date(), 1);
		String fechaVencimientoHasta =  UtilidadesBelcorp.fechaFormateada(dtFechaVenH, formatoFecha);		
		asignar("CTEXTO", "textFechaVenH", fechaVencimientoHasta.toString());
		
		//- Se crea una instancia DTOBelcorp y se rellena con los datos de sesión. 
		//Obtenemos el pais y el idioma de la sesion
		UtilidadesSession sesion = new UtilidadesSession();
		Long pais = sesion.getPais(this); 
		Long idioma = sesion.getIdioma(this);
		
		//Se instancia un DTOBelcorp
		DTOBelcorp dtoEntrada = new DTOBelcorp();
		dtoEntrada.setOidPais(pais);
		dtoEntrada.setOidIdioma(idioma);
		
		//- Se crea idNegocio "CCCCargaInicialSeleccionProvisionesDepuraciones" 
		MareBusinessID idBusiness = new MareBusinessID("CCCCargaInicialSeleccionProvisionesDepuraciones");
		
		//Almacenamos los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoEntrada);
		paramEntrada.addElement(idBusiness);

		//- Se invoca al ConectorCargaInicialSeleccion 
		traza("Antes de conectar");
		DruidaConector conector = conectar("ConectorCargaInicialSeleccion", paramEntrada);
		traza("Despues de conectar");
		
		//- Se obtiene un DTOCargaInicialSeleccion relleno con los tiposCargo, los 
		//canales, los periodos, los accesos y los subaccesos. Todos ellos con oid y descripcion.
		// y se mostrarán los mismos en el cmbMarcas y cmbCanales de PaginaEliminarCurso 
		DTOCargaInicialSeleccion dtoCargaInicialSeleccion = (DTOCargaInicialSeleccion)conector.objeto("DTOCargaInicialSeleccion");

		// Rellenamos los campos ocultos proceso y subproceso.
		String proceso = "";
		if (dtoCargaInicialSeleccion.getProceso()!=null) proceso = dtoCargaInicialSeleccion.getProceso().toString();
		String subproceso = dtoCargaInicialSeleccion.getSubproceso();
		asignar("VAR", "proceso", proceso);
		asignar("VAR", "subproceso", subproceso);
		traza("Proceso: "+proceso);
		traza("Subproceso: "+subproceso);

		// textFechaDocH lo rellenamos con la fecha actual menos el número de días indicado en numeroDiasDeMora.
		int numDiasDeMora = dtoCargaInicialSeleccion.getNumDiasDeMora().intValue();
		Date dtFechaDocH = UtilidadesFecha.minusDays(new Date(), numDiasDeMora);
		String fechaDocumentoHasta =  UtilidadesBelcorp.fechaFormateada(dtFechaDocH, formatoFecha);		
		asignar("CTEXTO", "textFechaDocH", fechaDocumentoHasta.toString());
		traza("Rellena Etiquetas");
		// Relleno las etiquetas
		this.rellenaLabels(dtoCargaInicialSeleccion);
		
		traza("Rellena Combos");
		// Relleno los combos y las matrices de los combos.
		this.rellenaCombosMatrices(dtoCargaInicialSeleccion);

		traza("LPSeleccionarProvisionesDepuraciones.accionVacia Salida");
	}

	private void accionAplicarIncobrables() throws Exception{
		traza("LPSeleccionarProvisionesDepuraciones.accionAplicarIncobrables Entrada");
		
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		//asignar("VAR", "ejecutar", "fVolver()");
		
		
		//FALTA!!!!!!!
		//DESBLOQUEAR LAS FILAS NO SELECCIONADAS 
		//Creamos un DTOOIDs con los oids de Mov.CC. 
		//idBusiness = "CCCEliminarBloqueosMovCC" 
		//Llamamos al "ConectorEliminarBloqueosMovCC" con el dto y el idBusiness 
		

		
		//DTOBuscarSaldosMorosos criterioBusqueda = new DTOBuscarSaldosMorosos();
		DTOAplicarIncobrables criterioBusqueda = new DTOAplicarIncobrables();
		//- Se crea una instancia DTOBelcorp y se rellena con los datos de sesión. 
		//Obtenemos el pais y el idioma de la sesion
		UtilidadesSession sesion = new UtilidadesSession();
		Long pais = sesion.getPais(this); 
		Long idioma = sesion.getIdioma(this);

        criterioBusqueda.setOidPais(pais);
        criterioBusqueda.setOidIdioma(idioma);
		traza("Recuperando la informacion");

		String parametro = conectorParametroLimpia("cbEmpresa", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setEmpresa(Long.valueOf(parametro));
        	traza("Empresa: "+parametro);

		parametro = conectorParametroLimpia("hid_cbAcceso", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setAcceso(Long.valueOf(parametro));
		traza("Acceso: "+parametro);
		
		parametro = conectorParametroLimpia("hid_cbCanal", "", true);		
        if(!parametro.equals(""))
        	criterioBusqueda.setCanal(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("hid_cbSubacceso", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setSubacceso(Long.valueOf(parametro));		

		parametro = conectorParametroLimpia("hid_cbTipoAbono", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setTipoCargoAbono(Long.valueOf(parametro));
        	traza("CargoAbono: "+parametro);
		
        parametro = conectorParametroLimpia("hid_textFechaImputacionProceso", "", true);
		traza(parametro);
       	if(!parametro.equals(""))
        		criterioBusqueda.setFechaImputacion(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));
		
		parametro = conectorParametroLimpia("hid_textReferenciaExterna", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setReferenciaExterna(parametro);

		parametro = conectorParametroLimpia("hid_textCodClienteD", "", true);
		traza("setClienteDesde "+parametro);
        if(!parametro.equals(""))
        	criterioBusqueda.setClienteDesde(parametro);

		parametro = conectorParametroLimpia("hid_textCodClienteH", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setClienteHasta(parametro);

		parametro = conectorParametroLimpia("hid_textFechaDocD", "", true);
		traza(parametro);
    	if(!parametro.equals(""))
    		criterioBusqueda.setFechaDocumentoDesde(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));
		
		parametro = conectorParametroLimpia("hid_textFechaDocH", "", true);
		traza(parametro);
    	if(!parametro.equals(""))
    		criterioBusqueda.setFechaDocumentoHasta(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));
		
		parametro = conectorParametroLimpia("hid_textPeriodoD", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setPeriodoDesde(parametro);

		parametro = conectorParametroLimpia("hid_textPeriodoH", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setPeriodoHasta(parametro);

		parametro = conectorParametroNumero("hid_textImporteD", this.FORMATO_DEFAULT);
		traza("MAD - parametro " + parametro );
        if(!parametro.equals("")){
		   criterioBusqueda.setImporteDesde(Double.valueOf(parametro));
		}

		parametro = conectorParametroNumero("hid_textImporteH", this.FORMATO_DEFAULT);
		traza("MAD - parametro 2 " + parametro);
        if(!parametro.equals("")){
			criterioBusqueda.setImporteHasta(Double.valueOf(parametro));
		}

		parametro = conectorParametroLimpia("hid_textObservaciones", "", true);
        if(!parametro.equals(""))
        	criterioBusqueda.setObservaciones(parametro);

        parametro = conectorParametroLimpia("hid_textFechaVenD", "", true);
		traza(parametro);
    	if(!parametro.equals(""))
    		criterioBusqueda.setFechaVencimientoDesde(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));
		
        parametro = conectorParametroLimpia("hid_textFechaVenH", "", true);
		traza(parametro);
    	if(!parametro.equals(""))
    		criterioBusqueda.setFechaVencimientoHasta(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));

        parametro = conectorParametroLimpia("subproceso", "", true);
		traza("Subproceso: "+parametro);
    	if(!parametro.equals(""))
    		criterioBusqueda.setSubproceso(parametro);

        parametro = conectorParametroLimpia("proceso", "", true);
		traza("Proceso: "+parametro);
    	if(!parametro.equals(""))
    		criterioBusqueda.setProceso(new Long(parametro));

		
		/*
		parametro = conectorParametroLimpia("hid_cbMarca", "", true);
		traza("hid_cbMarca");
		traza(parametro);
        if(!parametro.equals(""))
        	criterioBusqueda.setMarca(Long.valueOf(parametro));
		*/
		traza("Recuperando movimientos");
		Long movimientos[] =null;
		parametro = conectorParametroLimpia("datos", "", true);
		traza("listado1: "+parametro);
		if(!parametro.equals("")) {
		       java.util.StringTokenizer st = new java.util.StringTokenizer(parametro, ",");
		       if (st.countTokens() > 0){
		                movimientos = new Long[st.countTokens()];
		                               
		                for (int i = 0; i < movimientos.length; i++) {
		                         movimientos[i] = Long.valueOf (st.nextToken());
		                }
		       }
		}
		
		//DTOAplicarIncobrables dtoAplicarIncobrables = new DTOAplicarIncobrables();
		//dtoAplicarIncobrables.setCriteriosBusqueda(criterioBusqueda);
		//dtoAplicarIncobrables.setMovimientos(movimientos);
        	//dtoAplicarIncobrables.setOidPais(pais);
        	//dtoAplicarIncobrables.setOidIdioma(idioma);
		
		parametro = conectorParametroLimpia("hid_textNumLote", "", true);
		traza("Numero Lote: " + parametro);
    	if(!parametro.equals("")) {
    		criterioBusqueda.setNumeroLote(new Integer(parametro));
		}

		criterioBusqueda.setMovimientos(movimientos);
        	criterioBusqueda.setOidPais(pais);
        	criterioBusqueda.setOidIdioma(idioma);



		traza("creando idbusines");
		//- Se crea idNegocio "CCCAplicarIncobrables" 
		MareBusinessID idBusiness = new MareBusinessID("CCCAplicarIncobrables");
		traza("metiendo parametros");
		//Almacenamos los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(criterioBusqueda);
		paramEntrada.addElement(idBusiness);

		traza("LPSeleccionarProvisionesDepuraciones.aplicarIncobrables Voy a invocar el conector");
		traza("Parametros: ");
		traza(paramEntrada);
		//- Se invoca al ConectorAplicarIncobrables 
		DruidaConector conector = conectar("ConectorAplicarIncobrables", paramEntrada);
    
    // Modificado por ssantana, 4/8/2005, inc. 19032
		asignar("VAR", "ejecutar", "retornaLPOK()");
    // Fin Modificado por ssantana, 4/8/2005, inc. 19032    
		traza("LPSeleccionarProvisionesDepuraciones.accionAplicarIncobrables Salida");
	}


	private void generaHiddensFormato() throws Exception{
		traza("LPSeleccionarProvisionesDepuraciones.generaHiddensFormato Entrada");

		//Codigo para guardar valores de validación de sesion en hiddens de la página donde se debe hacer la validacion
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		traza("Antes de Formato Fecha");
		generarHiddenFormatoFecha();
		traza("Despues de Formato Fecha");
		// Almacenamos el número de caractéres del código del cliente.
		Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
		asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
		String oidIdioma = UtilidadesSession.getIdioma(this).toString();
		asignar("VAR","hid_OidIdioma", oidIdioma);		
		String oidPais = UtilidadesSession.getPais(this).toString();
		asignar("VAR","hid_OidPais", oidPais);		
		traza("LPSeleccionarProvisionesDepuraciones.generaHiddensFormato Salida");
	}

	private void rellenaLabels(DTOCargaInicialSeleccion dtoCargaInicialSeleccion) throws Exception{
		traza("LPSeleccionarProvisionesDepuraciones.rellenaLabels Entrada");

		// Rellenamos país con el valor de sesión.
		//asignar("LABELC", "lblPaisActual", UtilidadesSession.getDescripcionPais(this));
		
		// Rellenamos el año y el mes con los valores del servidor.
		Date fechaActual = new Date(System.currentTimeMillis());
		String anyo = null;
		String mes = null;
		
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		String fechaDocumento =  UtilidadesBelcorp.fechaFormateada(new Date(), formatoFecha);
		asignar("LABELC", "lblFechaDocumento", fechaDocumento);
		
		anyo = UtilidadesFecha.convertirAString(fechaActual,"yy");
		mes = UtilidadesFecha.convertirAString(fechaActual,"MM");
		
		asignar("LABELC", "lblAnoActual", anyo.toString());
		asignar("LABELC", "lblMesActual", mes.toString());
		String numLote = "";
		if(dtoCargaInicialSeleccion.getNumeroLote()!=null){
			numLote = dtoCargaInicialSeleccion.getNumeroLote().toString();
		}
		asignar("LABELC", "lblNLoteActual", numLote);
		asignar("VAR","hid_textNumLote", numLote);
		
		traza("LPSeleccionarProvisionesDepuraciones.rellenaLabels Salida");
	}

	private void rellenaCombosMatrices(DTOCargaInicialSeleccion dtoCargaInicialSeleccion) throws Exception{

		traza("LPSeleccionarProvisionesDepuraciones.rellenaCombosMatrices Entrada");

		// Se cargan los combos de marca, canal y tipoCargoAbono 
		//RecordSet rsMarcas = dtoCargaInicialSeleccion.getMarcas();
		RecordSet rsCanales = dtoCargaInicialSeleccion.getCanales();
		RecordSet rsTiposCargo = dtoCargaInicialSeleccion.getTiposCargo();
		RecordSet rsEmpresas = dtoCargaInicialSeleccion.getEmpresas();

		//Vector cols = rsMarcas.getColumnIdentifiers();
		//DruidaConector conectorMarcas = UtilidadesBelcorp.generarConector(
		//  "DTOCargaInicialSeleccion.marcas",rsMarcas,cols);
		//asignar("COMBO","cbMarca",conectorMarcas ,"DTOCargaInicialSeleccion.marcas");
		
		traza ("COMBO EMPRESA");
		Vector cols = rsEmpresas.getColumnIdentifiers();
		DruidaConector conectorEmpresas = UtilidadesBelcorp.generarConector(
		   "DTOCargaInicialSeleccion.empresas",rsEmpresas,cols);
		asignar("COMBO","cbEmpresa",conectorEmpresas ,"DTOCargaInicialSeleccion.empresas");
		
		traza ("COMBO CANALES");
		cols = rsCanales.getColumnIdentifiers();
		DruidaConector conectorCanales = UtilidadesBelcorp.generarConector(
		  "DTOCargaInicialSeleccion.canales",rsCanales,cols);
		asignar("COMBO","cbCanal",conectorCanales,"DTOCargaInicialSeleccion.canales");
		
		traza ("COMBO TIPOCARGO");
		cols = rsTiposCargo.getColumnIdentifiers();
		DruidaConector conectorTiposCargo = UtilidadesBelcorp.generarConector(
		  "DTOCargaInicialSeleccion.tiposCargo",rsTiposCargo,cols);
		asignar("COMBO","cbTipoAbono",conectorTiposCargo,"DTOCargaInicialSeleccion.tiposCargo");

		// Se guardan los recordsets accesos y subaccesos en listas ocultas 
		RecordSet rsAccesos = dtoCargaInicialSeleccion.getAccesos();
		RecordSet rsSubaccesos = dtoCargaInicialSeleccion.getSubaccesos();
		
		// Si el recordset no es nulo rellenamos datosAccesos con sus datos.
		if (rsAccesos != null) {
			cols = rsAccesos.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector("datosAccesos", rsAccesos, cols);
    		asignar("MATRIZJS", "datosAccesos", conectorCargaCombo);
    	}
		
		// Si el recordset no es nulo rellenamos datosAccesos con sus datos.
		if (rsSubaccesos != null) {
			cols = rsSubaccesos.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector("datosSubaccesos", rsSubaccesos, cols);
    		asignar("MATRIZJS", "datosSubaccesos", conectorCargaCombo);
    	}

		traza("LPSeleccionarProvisionesDepuraciones.rellenaCombosMatrices Salida");
	}

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}

}