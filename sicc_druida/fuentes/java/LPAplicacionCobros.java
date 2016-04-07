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
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasPendientes; 

//import es.indra.sicc.druida.formatos.Fecha;
//import es.indra.sicc.druida.formatos.FormateadorNumerico;

public class LPAplicacionCobros extends LPSICCBase 
{
	public LPAplicacionCobros() {
		super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_cobros_aplicacion");
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPAplicacionCobros - ejecucion ***");
		
		try {
			String accion = conectorParametroLimpia("accion","",true);
			if (accion.equals("")) {
				accionVacia();
			} 
		} catch (Exception e) {
			lanzarPaginaError(e);
			logStackTrace(e);
		}
		
		traza("*** Salida - LPAplicacionCobros - ejecucion ***");
	}

	private void accionVacia() throws Exception {
		traza("*** Entrada - LPAplicacionCobros - accionVacia ***");
		
		// Si el parametro codigoCliente no es nulo, se rellena la caja de texto de 
		// la página con su valor
		String codigoCliente = conectorParametroLimpia("codigoCliente","",true);
		if (!codigoCliente.equals("")) {
			asignarAtributo("TEXT","txtCodCliente","valor",codigoCliente);
			asignarAtributo("TEXT","txtCodCliente","disabled","S");
			asignarAtributo("IMG","busquedaCliente","onclick","");
			asignarAtributo("VAR","codCliente","valor",codigoCliente);

		}
		
		// Se obtiene el parametro empresa y se almacena en un campo oculto
		String empresa = conectorParametroLimpia("empresa","",true);
		Long oidEmpresa = null;
		if (!empresa.equals("")) {
			oidEmpresa = new Long(empresa);
		}
		asignarAtributo("VAR","empresa","valor",empresa);
	traza("*** Entrada - LPAplicacionCobros - Obtiene sesion ***");
		// Se obtiene la sesión
        UtilidadesSession session = new UtilidadesSession();
        Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
        
        asignarAtributo("VAR","idioma","valor",idioma.toString());
        asignarAtributo("VAR","pais","valor",pais.toString());
        traza("*** Entrada - LPAplicacionCobros - Obtiene Instancia DTOOID ***");
		// Se instancia un DTOOID y se rellena con el oid del país,
		// el idioma del usuario y el oid de empresa
		DTOOID dtoOID = new DTOOID();
		dtoOID.setOidPais(pais);
        dtoOID.setOidIdioma(idioma);
        dtoOID.setOid(oidEmpresa);
        traza("*** Entrada - LPAplicacionCobros - Se crea idNegocio***");
		// Se crea idNegocio = "CCCCargaInicialAplicacionCobros"
		MareBusinessID idBussiness = new MareBusinessID("CCCCargaInicialAplicacionCobros");
		traza("*** Entrada - LPAplicacionCobros - Almacena Parametros de entrada***");
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOID);
		paramEntrada.addElement(idBussiness);
		traza("*** Entrada - LPAplicacionCobros - Invocar al conector ConectorCargaIncialAplicaciónCobros ***");
		// Se invoca al conector ConectorCargaInicialAplicacionCobros
		DruidaConector conector = conectar("ConectorCargaInicialAplicacionCobros", paramEntrada);
     
		// Se recibe un DTOSalida devuelto por el conector
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		
		// Se obtiene el recordset
		RecordSet rs = dtoSalida.getResultado();
		   traza("*** Entrada - LPAplicacionCobros - Generar Conector a partir del recordset ***");
		// Se genera un conector a partir del recordset, y se carga el combo de
		// cuentas corrientes
		Vector cols = rs.getColumnIdentifiers();
        DruidaConector conectorCC = UtilidadesBelcorp.generarConector(
            "DTOSalida.resultado",rs,cols);
        asignar("COMBO","cbCCC",conectorCC, "DTOSalida.resultado");
        
        // Se llama a obtenerLongitudCodigoCliente y con el resultado se
        // rellena el campo oculto longitudCodigoCliente 
		Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
		asignar("VAR", "longitudCodigoCliente", longitudCodigoCliente.toString());
        
        // Muestra el menú secundario
		getConfiguracionMenu("LPAplicacionCobros","");
		
		// Asigna valores a campos hidden para realizar la validacion de 
		// números con formato de miles y decimales
		asignaHiddensValidacion();
		
        traza("*** Salida - LPAplicacionCobros - accionVacia ***");
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