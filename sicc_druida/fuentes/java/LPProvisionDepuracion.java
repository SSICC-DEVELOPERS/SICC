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
 
import java.util.Vector;
import java.util.Date;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.dtos.ccc.DTOConsultarDepuracion;
import es.indra.sicc.dtos.ccc.DTOAprobar;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
 
public class LPProvisionDepuracion extends LPSICCBase 
{
	public LPProvisionDepuracion() {
		super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_datos_provisiones_depuraciones");
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPProvisionDepuracion - ejecucion ***");
		
		try {
			String accion = conectorParametroLimpia("accion","",true);
			if (accion.equals("")) {
				accionVacia(null);
			} else if (accion.equalsIgnoreCase("Aprobar")) {
				accionAprobarRechazar(true);
			} else if (accion.equalsIgnoreCase("Rechazar")) {
				accionAprobarRechazar(false);
			} else if (accion.equalsIgnoreCase("Eliminar")) {
				accionEliminar();
			}
			/*}eliminado por incidencia 8813 
			else if (accion.equalsIgnoreCase("EliminarCuotas")) {
				accionEliminarCuotas();
			*/
			String casoUso = conectorParametroLimpia("casoUso", "", true);
	        if (casoUso.indexOf("eliminarDepuracion") != -1) {
	        	asignarAtributo("PAGINA","contenido_datos_provisiones_depuraciones", "cod", "0349"); 
	        	asignarAtributo("PAGINA", "contenido_datos_provisiones_depuraciones", "msgle", "Eliminar provisiones/depuraciones");
				getConfiguracionMenu("LPProvisionDepuracion", "Eliminar");
			} else if (casoUso.indexOf("modificarDepuracion") != -1){
	        	asignarAtributo("PAGINA","contenido_datos_provisiones_depuraciones", "cod", "0350"); 
	        	asignarAtributo("PAGINA", "contenido_datos_provisiones_depuraciones", "msgle", "Modificar provisiones/depuraciones");
				getConfiguracionMenu("LPProvisionDepuracion", "Modificar");
			} else if (casoUso.indexOf("aprobarRechazar") != -1){
	        	asignarAtributo("PAGINA","contenido_datos_provisiones_depuraciones", "cod", "0162"); 
	        	asignarAtributo("PAGINA", "contenido_datos_provisiones_depuraciones", "msgle", "Aprobar/Rechazar provisiones/depuraciones");
				getConfiguracionMenu("LPProvisionDepuracion", "Aprobar");
			} else {
	        	asignarAtributo("PAGINA","contenido_datos_provisiones_depuraciones", "cod", "0348"); 
	        	asignarAtributo("PAGINA", "contenido_datos_provisiones_depuraciones", "msgle", "Consultar provisiones/depuraciones");			
				getConfiguracionMenu("LPProvisionDepuracion", "Consultar");
			}					
		} catch (Exception e) {
			lanzarPaginaError(e);
			logStackTrace(e);
		}
		
		traza("*** Salida - LPProvisionDepuracion - ejecucion ***");
	}
	
	private void accionVacia(String oid) throws Exception {
		traza("*** Entrada - LPProvisionDepuracion - accionVacia ***");
		
		String casoUso = conectorParametroLimpia("casoUso", "", true);			
		asignarAtributo("VAR","casoUso","valor",casoUso );
		traza("casoUso: "+casoUso);
		String oidCabecera=null;
		// Se almacena el oid en el campo oculto oidCabecera. 
		if(oid==null){
			oidCabecera= conectorParametroLimpia("oidSeleccionado", "", true);
		}else{
			oidCabecera=oid;
		}
		 
		asignar("VAR","oidCabecera",oidCabecera);
		traza("oid: "+oidCabecera);
		
		// - IdBusiness = "CCCObtenerDetalleDepuracion" 
		// - Con el oid recibido creamos un DTOOID (además del pais y el idioma) 
		// - Llamamos al ConectorObtenerDetalleDepuracion 
		// - Con el DTOConsultarDepuracion rellenamos los campos correspondientes 
		// con el siguiente detalle: al cargar la lista Lineas con el recordset del 
		// mismo nombre, la primera columna (la del oid) la debemos guardar un campo oculto para cada fila. 
		
		// Se obtiene el pais, idioma y formato de fecha de sesion
		UtilidadesSession sesion = new UtilidadesSession(); 
		Long oidPais = sesion.getPais(this);
		Long oidIdioma = sesion.getIdioma(this);
		asignar("VAR","pais",oidPais.toString());
		asignar("VAR","idioma",oidIdioma.toString());
		
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		
		DTOOID dtoOID = new DTOOID();
		dtoOID.setOidIdioma(oidIdioma);
		dtoOID.setOidPais(oidPais);
		dtoOID.setOid(new Long(oidCabecera));
		
		//traza("Antes de la incidencia BELC300008813");
		
		//*********************************** Cambio por incidencia BELC300008813 ***********************************
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOID);
		MareBusinessID idBussiness = new MareBusinessID("CCCObtenerCabeceraDepuracion");
		paramEntrada.addElement(idBussiness);
		
		 
		
		// Se llama al ConectorObtenerCabeceraDepuracion
		traza("Antes de llamar al conector ConectorObtenerCabeceraDepuracion");
		DruidaConector conector = conectar("ConectorObtenerCabeceraDepuracion", paramEntrada);
        traza("Despues de llamar al conector ConectorObtenerCabeceraDepuracion");
        
        // Se recibe un DTOConsultarDepuracion devuelto por el conector
		traza("Obteniendo DTO de salida, DTOConsultarDepuracion");
		DTOConsultarDepuracion dtoConsultar = (DTOConsultarDepuracion)conector.objeto("DTOConsultarDepuracion");
		traza("Obtenido DTO de salida, dtoConsultar");
		traza("DTO de salida Contenido:\n");
		traza(""+dtoConsultar);
						
		//Numero
		String txtNumero="";
		Integer numero = dtoConsultar.getNumero();
		if (numero != null) {
			txtNumero = numero.toString();	
		}
		asignarAtributo("LABELC","lblNumeroActual","valor",txtNumero);
			
		// anho
		String anho = dtoConsultar.getAnio();
		asignarAtributo("LABELC","lblAnoActual","valor",(anho != null) ? anho: "");
		
		// mes
		String mes = dtoConsultar.getMes();
		asignarAtributo("LABELC","lblMesActual","valor",(mes != null) ? mes: "");
		
		//Fecha documento- lbldtFechaDoc
		Date fechaImputacion = dtoConsultar.getFechaImputacion();
		String txtFechaImputacion = "";
		if (fechaImputacion != null) {
			txtFechaImputacion = UtilidadesBelcorp.fechaFormateada(fechaImputacion,formatoFecha);
		}
		asignarAtributo("LABELC","lbldtFechaDoc","valor",txtFechaImputacion);
		
		//situacion 
		String situacion = dtoConsultar.getSituacion();
		asignarAtributo("LABELC","lblSituacionActual","valor",(situacion !=null) ? situacion: "");
		
		//empresa 
		
		String empresa = dtoConsultar.getEmpresa();
		
		asignarAtributo("LABELC","lblEmpresaActual","valor",(empresa !=null) ? empresa: "");
		
		// canal
		String canal = dtoConsultar.getCanal();
		asignarAtributo("LABELC","lblvalorCanal","valor",(canal != null) ? canal : "");
		
		//acceso 
		String acceso = dtoConsultar.getAcceso();
		asignarAtributo("LABELC","lblvalorAcceso","valor",(acceso != null) ? acceso : "");
		
		//subacceso 
		String subAcceso = dtoConsultar.getSubAcceso();
		asignarAtributo("LABELC","lblvalorSubacceso","valor",(subAcceso != null) ? subAcceso : "");
		
		// numeroRegistrosLote
		String txtNumeroRegistrosLote = "";
		Integer numeroRegistrosLote = dtoConsultar.getNumeroRegistrosDelNumero();
		if (numeroRegistrosLote != null) {
			txtNumeroRegistrosLote = numeroRegistrosLote.toString();
		}
		asignarAtributo("LABELC","lblvalorNRegLote","valor",txtNumeroRegistrosLote);
		
		// importeRegistrosLote (importeTotal)
		String txtImporteTotal = "";
		BigDecimal importeTotal = dtoConsultar.getImporteRegistrosDelNumero();
		if (importeTotal !=null) {
			txtImporteTotal = importeTotal.toString();	
		}
		asignarAtributo("LABELC","lblvalorImporteTotal","valor",txtImporteTotal);
		
		// referencia 
		String referencia = dtoConsultar.getReferencia();
		asignarAtributo("LABELC","lblvalorReferencia","valor",(referencia != null) ? referencia : "");
		
		// clienteDesde
		String clienteDesde = dtoConsultar.getClienteDesde();
		asignarAtributo("LABELC","lblClienteDActual","valor",(clienteDesde != null) ? clienteDesde : "");
		
		// clienteHasta
		String clienteHasta = dtoConsultar.getClienteHasta();
		asignarAtributo("LABELC","lblClienteHActual","valor",(clienteHasta != null) ? clienteHasta : "");
		
		// fechaVencimientoDesde
		Date fechaVencimientoDesde = dtoConsultar.getFechaVencimientoDesde();
		String txtFechaVencimientoDesde = "";
		if (fechaVencimientoDesde != null) {
			txtFechaVencimientoDesde = UtilidadesBelcorp.fechaFormateada(fechaVencimientoDesde,formatoFecha);
		}
		asignarAtributo("LABELC","lblFechaVenActualD","valor",txtFechaVencimientoDesde);
		
		// fechaVencimientoHasta
		Date fechaVencimientoHasta = dtoConsultar.getFechaVencimientoHasta();
		String txtFechaVencimientoHasta = "";
		if (fechaVencimientoHasta != null) {
			txtFechaVencimientoHasta = UtilidadesBelcorp.fechaFormateada(fechaVencimientoHasta,formatoFecha);
		}
		asignarAtributo("LABELC","lblFechaVenActualH","valor",txtFechaVencimientoHasta);
		
		// periodoDesde 
		String periodoDesde = dtoConsultar.getPeriodoDesde();
		asignarAtributo("LABELC","lblPeriodoActualDesde","valor",(periodoDesde != null) ? periodoDesde : "");
		
		// periodoHast 
		String periodoHasta = dtoConsultar.getPeriodoHasta();
		asignarAtributo("LABELC","lblPeriodoActualHasta","valor",(periodoHasta != null) ? periodoHasta : "");
		
		
		// observaciones	 
		String observaciones = dtoConsultar.getObservaciones();	
		asignarAtributo("LABELC","lblObservacionesActual","valor",(observaciones != null) ? observaciones : "");
		
        if (casoUso.indexOf("eliminarDepuracion") != -1) {
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0349"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Eliminar provisiones/depuraciones");
        	asignarAtributo("FORMULARIO","frmCapturarCupon","oculto","S");
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Eliminar");
		} else if (casoUso.indexOf("modificarDepuracion") != -1){
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0350"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Modificar provisiones/depuraciones");
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Modificar");
		} else if (casoUso.indexOf("aprobarRechazar") != -1){
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0162"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Aprobar/Rechazar provisiones/depuraciones");
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Aprobar");
		} else {
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0348"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Consultar provisiones/depuraciones");			
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Consultar");
		}		
		traza("*** Salida - LPProvisionDepuracion - accionVacia ***");
	}
	
	private void accionAprobarRechazar(boolean aprobar) throws Exception {
		traza("*** Entrada - LPProvisionDepuracion - accionAprobarRechazar ***");
		String oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
		try{
			// Se obtiene el pais e idioma de sesión
			UtilidadesSession sesion = new UtilidadesSession(); 
			Long oidPais = sesion.getPais(this);
			Long oidIdioma = sesion.getIdioma(this);
			
			// Se obtiene el parametro oidCabecera			
			traza("oid: "+oidCabecera);
			DTOAprobar dtoAprobar = new DTOAprobar();
			dtoAprobar.setOidIdioma(oidIdioma);
			dtoAprobar.setOidPais(oidPais);
			dtoAprobar.setDepuracion(new Long(oidCabecera));
			dtoAprobar.setAprobar(new Boolean(aprobar));
			
			// Se almacenan los parametros de entrada
			Vector paramEntrada = new Vector();
			paramEntrada.addElement(dtoAprobar);
			MareBusinessID idBussiness = new MareBusinessID("CCCAprobarRechazarDepuracion");
			paramEntrada.addElement(idBussiness);
			
			// Llamamos al ConectorAprobarRechazarDepuracion
			traza("Antes de llamar al conector ConectorAprobarRechazarDepuracion");
			DruidaConector conector = conectar("ConectorAprobarRechazarDepuracion", paramEntrada);
	        traza("Despues de llamar al conector ConectorAprobarRechazarDepuracion");
	        accionVacia(oidCabecera);
        } catch (Exception e) {
        	accionVacia(oidCabecera);
			lanzarPaginaError(e);
			logStackTrace(e);
		}
        
		
		traza("*** Salida - LPProvisionDepuracion - accionAprobarRechazar ***");
	}
	
	/*private void accionEliminarCuotas() throws Exception {
		traza("*** Entrada - LPProvisionDepuracion - accionEliminarCuotas ***");
		
		// Se obtiene el pais e idioma de sesión
		String oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
		UtilidadesSession sesion = new UtilidadesSession(); 
		Long oidPais = sesion.getPais(this);
		Long oidIdioma = sesion.getIdioma(this);
		
		// Se obtienen los oids de las filas seleccionadas 
		String txtOids = conectorParametroLimpia("oids", "", true);
		StringTokenizer st = new StringTokenizer(txtOids, ",");
		Long oids[] = new Long[st.countTokens()];
		
		int i = 0;
		while (st.hasMoreTokens()) {
			oids[i] = new Long(st.nextToken());
			i++;
		}
	
		DTOOIDs dto = new DTOOIDs();
		dto.setOidIdioma(oidIdioma);
		dto.setOidPais(oidPais);
		dto.setOids(oids);
		
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dto);
		MareBusinessID idBussiness = new MareBusinessID("CCCDepuracionEliminarCuotas");
		paramEntrada.addElement(idBussiness);
		
		// Llamamos al ConectorEliminar		
		try{
			traza("Antes de llamar al conector ConectorEliminar ");
			DruidaConector conector = conectar("ConectorEliminar", paramEntrada);
			traza("Despues de llamar al conector ConectorEliminar");	
			accionVacia(oidCabecera);
		}catch(Exception e){
			accionVacia(oidCabecera);
			lanzarPaginaError(e);
			logStackTrace(e);			
		}
		traza("*** Salida - LPProvisionDepuracion - accionEliminarCuotas ***");
	}*/
	
	private void accionEliminar() throws Exception {
		traza("*** Entrada - LPProvisionDepuracion - accionEliminar ***");
		
		pagina("salidaGenerica");
		
		// Se obtiene el pais e idioma de sesión
		UtilidadesSession sesion = new UtilidadesSession(); 
		Long oidPais = sesion.getPais(this);
		Long oidIdioma = sesion.getIdioma(this);
		
		// Se obtiene el oid de cabecera
		//String oidCabecera = conectorParametroLimpia("oidSeleccionado", "", true);
		String oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
		DTOOID dto = new DTOOID();
		dto.setOidIdioma(oidIdioma);
		dto.setOidPais(oidPais);
		dto.setOid(new Long(oidCabecera));
		
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dto);
		MareBusinessID idBussiness = new MareBusinessID("CCCEliminarDepuracion");
		paramEntrada.addElement(idBussiness);
		
		
		
		try{		
			// Llamamos al ConectorObjeto
			traza("Antes de llamar al conector ConectorObjeto");
			DruidaConector conector = conectar("ConectorEliminarDepuracion", paramEntrada);
			traza("Despues de llamar al conector ConectorObjeto");

			// Se recibe un DTOBoolean devuelto por el conector	
			//traza("Antes de obtener DTOBoolean");
			//DTOBoolean dtoBoolean = (DTOBoolean)conector.objeto("DTOSalida");
			//traza("Despues de obtener DTOBoolean");
			asignar("VAR", "ejecutar", "mensajeError()");
							
			/*if (dtoBoolean.getValor()) {
				asignar("VAR", "ejecutar", "mensajeError()");
			} else {
				// Se asigna al campo oculto mensaje el código de error que se
				// debe mostrar (CCC-0016)	
				traza("Mensaje de ERROR CCC0016");
                asignarAtributo("VAR","mensajeError","valor","CCC0016");
                accionVacia(oidCabecera);
				
	
			}*/
		}catch(Exception e){
			lanzarPaginaError(e);
			logStackTrace(e);			
		}				
		
		
		traza("*** Salida - LPProvisionDepuracion - accionEliminar ***");
	}
		
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
}