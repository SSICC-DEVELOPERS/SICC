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
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.dtos.ccc.DTOCargaInicialConceptos;
import es.indra.sicc.dtos.ccc.DTODatosCargaInicialConceptos;

 
public class LPConceptosGastosAbonos extends LPSICCBase 
{
	public LPConceptosGastosAbonos() {
		super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_gastos_abonos_conceptos");
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPConceptosGastosAbonos - ejecucion ***");
		
		try {
			String accion = conectorParametroLimpia("accion","",true);
			if (accion.equals("")) {
				accionVacia();
			}
		} catch (Exception e) {
			lanzarPaginaError(e);
			logStackTrace(e);
		}
		
		traza("*** Salida - LPConceptosGastosAbonos - ejecucion ***");
	}
	
	private void accionVacia() throws Exception {
		traza("*** Entrada - LPConceptosGastosAbonos - accionVacia ***");
		
		// Se obtienen los parámetros
		String strEmpresa = conectorParametroLimpia("empresa","",true);
		Long empresa = null;
		if (!strEmpresa.equals("")) {
			empresa = new Long(strEmpresa);
		}
		
		String strProceso = conectorParametroLimpia("proceso","",true);
		Long proceso = null;
		if (!strProceso.equals("")) {
			proceso = new Long(strProceso);
		}
		
		// Se obtiene el idioma y el pais de sesión
		Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);
        
        // Genera un campo oculto que contiene el formato de fecha
		//generarHiddenFormatoFecha();
		
		// Asigna valores a campos hidden para realizar la validacion de 
		// números con formato de miles y decimales
		asignaHiddensValidacion();
		
		// Se instancia un DTOCargaInicialConceptos
		DTOCargaInicialConceptos dtoCargaInicial = new DTOCargaInicialConceptos();
		dtoCargaInicial.setOidPais(pais);
		dtoCargaInicial.setOidIdioma(idioma);
		dtoCargaInicial.setEmpresa(empresa);
		dtoCargaInicial.setProceso(proceso);
		
		// Se crea idNegocio = "CCCCargaInicialConceptos"
		MareBusinessID idBussiness = new MareBusinessID("CCCCargaInicialConceptos");
		
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoCargaInicial);
		paramEntrada.addElement(idBussiness);
		traza("*** - LPConceptosGastosAbonos - ***: 00");
		
		// Se invoca al conector ConectorConsulta
		DruidaConector conector = conectar("ConectorCargaInicialConceptos", paramEntrada);
		
		// Se recibe un DTODatosCargaInicialConcepto devuelto por el conector
		DTODatosCargaInicialConceptos dtoDatos = null;
		dtoDatos = (DTODatosCargaInicialConceptos)conector.objeto("DTODatosCargaInicialConceptos");
		
		Vector cols = null;
		// Se obtiene los recordset
		RecordSet rsCC = dtoDatos.getCuentasCorrientes();
		RecordSet rsTiposAbono = dtoDatos.getTiposAbono();
		
		// Se carga el combo de divisas
		/*RecordSet rsDivisas = dtoDatos.getDivisas();
		if (rsDivisas != null && !rsDivisas.esVacio()) {
	        asignar("TEXT", "txtDivisa", ((BigDecimal)rsDivisas.getValueAt(0, 0)).toString());
        }*/
 		traza("***LPConceptosGastosAbonos - accionVacia ***: 1 ");
       
		// Se carga el combo de cuentas corrientes
		cols = rsCC.getColumnIdentifiers();
 		traza("***LPConceptosGastosAbonos - accionVacia ***: 1.1 ");
        DruidaConector conectorCC = UtilidadesBelcorp.generarConector("DTODatosCargaInicialConceptos.cuentasCorrientes", rsCC, cols);
		asignar("COMBO", "cbCCC", conectorCC, "DTODatosCargaInicialConceptos.cuentasCorrientes");

		// Se carga el combo de tiposAbono
		if (rsTiposAbono != null) {
			cols = rsTiposAbono.getColumnIdentifiers();
			DruidaConector conectorTiposAbono = UtilidadesBelcorp.generarConector("DTODatosCargaInicialConceptos.tiposAbono", rsTiposAbono, cols);
	        asignar("COMBO", "cbTipoAbono", conectorTiposAbono, "DTODatosCargaInicialConceptos.tiposAbono");
		}

		if (dtoDatos.getGlosaContable() != null)
	    	asignar("TEXT", "txtGlosaContable", dtoDatos.getGlosaContable());
			
        // Si recibimos un codigoCliente, ponemos dicho valor en el campo correspondiente 
        // de la pantalla y desabilitamos dicho campo y el botón de selección de cliente. 
		String codigoCliente = conectorParametroLimpia("codigoCliente","",true);
		if (!codigoCliente.equals("")) {
			asignarAtributo("TEXT", "txtCodCliente", "valor", codigoCliente);
			asignarAtributo("TEXT", "txtCodCliente", "disabled", "S");
			asignarAtributo("IMG", "busquedaCliente", "onclick", "");
		}
		
		// Se llama a obtenerLongitudCodigoCliente y con el resultado se
        // rellena el campo oculto longitudCodigoCliente 
        Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
        asignarAtributo("VAR", "longitudCodigoCliente", "valor", longitudCodigoCliente.toString());
 		traza("***LPConceptosGastosAbonos - accionVacia ***: 4 ");
               
        // Se obtiene el campo tasaCambioMonedaAlternativa y se almacena en un 
        // campo oculto
        BigDecimal tasaCambioMonedaAlternativa = dtoDatos.getTasaCambioMonedaAlternativa();
		traza("***tasaCambioMonedaAlternativa " + tasaCambioMonedaAlternativa);

		if(tasaCambioMonedaAlternativa!=null) {
			asignarAtributo("VAR", "tasaCambioMonedaAlternativa", "valor", tasaCambioMonedaAlternativa.toString());
		}
		else {
			asignarAtributo("VAR", "tasaCambioMonedaAlternativa", "valor", "1");
		}
        
 		traza("***LPConceptosGastosAbonos - accionVacia ***: 5 ");
                
        // Muestra el menú secundario
		getConfiguracionMenu("LPConceptosGastosAbonos","");
        
		traza("*** Salida - LPConceptosGastosAbonos - accionVacia ***");
	}
	
	private void asignaHiddensValidacion() throws Exception {
		// Campos hidden para realizar la validacion de números con formato de miles y decimales
		String formatoNumerico = UtilidadesSession.getFormatoNumerico(this);
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
		         separadorMiles = ".";
		}
		
		asignarAtributo("VAR","hid_SeparadorMiles","valor",separadorMiles);
		asignarAtributo("VAR","hid_NumeroDecimales","valor",formatoNumerico);
		asignarAtributo("VAR","hid_SeparadorDecimales","valor",separadorDecimales);
	}
	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
}