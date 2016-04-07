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
    INDRA/FAC/PROY
    $Id: LPCapturaProcesoReclamos.java,v 1.1 2009/12/03 18:40:01 pecbazalar Exp $
    DESC
 */

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.dom.DruidaDOMObjeto;


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBoolean;

import es.indra.sicc.dtos.rec.DTOOperacion;
import es.indra.sicc.dtos.rec.DTOBuscarProductosREC;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;

import es.indra.sicc.logicanegocio.rec.ConstantesREC;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collection;
import java.util.Iterator;

import java.math.BigDecimal;
import org.w3c.dom.Element;
import org.jaxen.dom.DOMXPath;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import es.indra.mare.common.exception.MareException;

public class LPCapturaProcesoReclamos extends LPSICCBase {
	private Long idioma = null; 
	private Long pais = null;
	private String accion = null;
	private String opcionMenu = null;
	private String idiomas = "";
	
	
	public LPCapturaProcesoReclamos() {
	 	super();
	}
	
	public void inicio() throws Exception {
       
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try{
			traza("*** LPCapturaProcesoReclamos.ejecucion: Entrada **");
    		this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion","",true);
            traza("Accion definida : "+this.accion);
            this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);
			traza("opcionMenu definida : "+this.opcionMenu);
			Collection cIdiomas = getIdiomas(); //obtenemos los idiomas.
			Iterator itIdiomas = cIdiomas.iterator();
			while(itIdiomas.hasNext()){
            	Idioma idiomai18n = (Idioma)itIdiomas.next();
				this.idiomas += idiomai18n.getOid() +",";
			}
			
			
			if (this.accion.equals("buscar") || this.accion.equals("")){
				mostrarPgIntroducirDatosPerdida();
			} else if (this.accion.equals("buscarProducto")){
				mostrarPgSeleccionProductos();
			} else if (this.accion.equals("comprobarProducto")){
				comprobarProducto();
			} /*else if (this.accion.equals("modificarProducto")){
				comprobarProducto();
			} else if (this.accion.equals("comprobarCliente")){
				comprobarCliente();
			}*/
			
			
		} catch (Exception ex){
			ex.printStackTrace();
        	this.logStackTrace(ex);
        	lanzarPaginaError(ex);
		}
		traza("*** LPCapturaProcesoReclamos.ejecucion: Salida **");
	}
	
	private void mostrarPgIntroducirDatosPerdida() throws Exception{
		traza("*** LPCapturaProcesoReclamos.mostrarPgIntroducirDatosPerdida: Entrada **");
		pagina("contenido_datos_perdida_introducir");
		traza("Asigno la pagina");
		asignar("VAR", "pais", pais.toString());
		traza("asigno el pais");
		asignar("VAR", "idioma", idioma.toString());
		traza("asigno el idioma");
		asignar("VAR", "asumeBelcorp", ConstantesREC.ASUME_BELCORP.toString());
		traza("asigno el primera constante");
		asignar("VAR", "asumeCliente", ConstantesREC.ASUME_CLIENTE.toString());
		traza("asigno el segunda constante");
		asignar("VAR", "asumeSeguro", ConstantesREC.ASUME_SEGURO.toString()); 
		asignarAtributo("PAGINA","contenido_datos_perdida_introducir", "cod", "0149");
		traza("asigno atributos de la pagina");
        asignarAtributo("PAGINA","contenido_datos_perdida_introducir", "msgle", "buscar");
        getConfiguracionMenu("LPCapturaProcesoReclamos", "buscar");
        //getFormatosValidaciones();
        String formatoNumerico = UtilidadesSession.getFormatoNumerico(this);
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		traza("Trasteo con la pagina");
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}
		
		//hay que declararlos en la página
		asignarAtributo("VAR","hid_SeparadorMiles","valor",separadorMiles);
		asignarAtributo("VAR","hid_NumeroDecimales","valor",formatoNumerico); 
		asignarAtributo("VAR","hid_SeparadorDecimales","valor",separadorDecimales);

        Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
        asignar("VAR","longitudCodigoCliente", longitudCodigoCliente.toString());

		cargarCombos();
		traza("*** LPCapturaProcesoReclamos.mostrarPgIntroducirDatosPerdida: Salida **");
	}
	
	private void mostrarPgSeleccionProductos() throws Exception{
		traza("*** LPCapturaProcesoReclamos.mostrarPgIntroducirDatosPerdida: Entrada **");
		pagina("contenido_producto_seleccion");
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());
		asignarAtributo("PAGINA","contenido_producto_seleccion", "cod", "0149");
        asignarAtributo("PAGINA","contenido_producto_seleccion", "msgle", "Buscar Productos");
        getConfiguracionMenu("LPCapturaProcesoReclamos", "buscarProducto");
		traza("*** LPCapturaProcesoReclamos.mostrarPgSeleccionProductos: Salida **");
	}
	
	private void cargarCombos() throws Exception{
		traza("*** LPCapturaProcesoReclamos.cargarCombos: Entrada **");
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);
		
		
		//Crear una lista ComposerViewElementList 
		ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = new ComposerViewElement();
        
        //tipo de cliente 
		/*Crear un elemento de tipo ComposerViewElement() para cargar los tipos de clientes 
		elem.IDBusiness=""MAEObtenerTipos""; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista */
		
		elem.setIDBusiness("MAEObtenerTipos");
        elem.setDTOE(dtoe);
		listelem.addViewElement(elem);

		//asume perdida 
		/*Crear un elemento de tipo ComposerViewElement() para cargar quien asume la perdida 
		elem.IDBusiness="RECObtenerAsumePerdida"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista */
		
		elem = new ComposerViewElement();
		elem.setIDBusiness("RECObtenerAsumePerdida");
        elem.setDTOE(dtoe);
		listelem.addViewElement(elem);
		
		//precio calculo 
		/*Crear un elemento de tipo ComposerViewElement() para cargar el tipo de Precio de Cálculo 
		elem.IDBusiness="RECObtenerPrecioCalculo"; 
		elem.DTOE=dtoe; */
		
		elem = new ComposerViewElement();
		elem.setIDBusiness("RECObtenerPrecioCalculo");
        elem.setDTOE(dtoe);
		listelem.addViewElement(elem);
		
		/*Asigna los combos: 
		- cbTipoCliente <- "MAEObtenerTipos" 
		- cbAsumePerdida <- "RECObtenerAsumePerdida" 
		- cbPrecioCalculo <- "RECObtenerPrecioCalculo"*/
		
		ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
    	traza("conector creado");
    	conector.ejecucion();
    	traza("ejecutado");
    	DruidaConector conConsultar = conector.getConector();
    	traza("Obtener conConsultar");

		asignar("COMBO","cbTipoCliente", conConsultar,"MAEObtenerTipos");
		asignar("COMBO","cbAsumePerdida", conConsultar,"RECObtenerAsumePerdida");
		asignar("COMBO","cbPrecioCalculo", conConsultar,"RECObtenerPrecioCalculo");

		traza("*** LPCapturaProcesoReclamos.cargarCombos: Salida **");
	}
	
	private void comprobarProducto() throws Exception{
		traza("*** LPCapturaProcesoReclamos.mostrarPgIntroducirDatosPerdida [MODIFICADO]: Entrada **");
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		
		String producto = conectorParametroLimpia("txtProducto","",true);
		DTOBuscarProductosREC dto = new DTOBuscarProductosREC();
		dto.setCodigoProducto(producto);
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("RECComprobarProducto"));           
		traza("Antes de Conectar ConectorComprobarProductoREC");
		DruidaConector conector = conectar("ConectorComprobarProductoREC", paramConector);							
		traza("Despues de Conectar ConectorComprobarProductoREC");
		
		DTOOID dtoOid = (DTOOID)conector.objeto("Existe");
		String oidProducto = null;
		if (dtoOid.getOid() != null){
			oidProducto = dtoOid.getOid().toString();
		}
		
		/*traza("[MSN] accion:" + this.accion.toString());
		if (this.accion.equals("modificarProducto")){
			traza("[MSN] - modificar producto");
			asignar("VAR", "ejecutar", "asignarDatosProducto('" + valor + "')");
		}else{
			traza("[MSN] - ejecucion correcta");*/
		
		
		//Comprobamos ahora el cliente
		String codCliente = conectorParametroLimpia("txtCodClienteSeguro","",true);
		DTOBusquedaRapidaCliente dtoCliente = new DTOBusquedaRapidaCliente();
		dtoCliente.setCodigoCliente(codCliente);
		dtoCliente.setOidPais(this.pais);
		dtoCliente.setOidIdioma(this.idioma);
		dtoCliente.setIndicadorSituacion(new Long(0));
		dtoCliente.setTamanioPagina(new Integer(1));
		Vector paramConectorCliente = new Vector();
		paramConectorCliente.add(dtoCliente);
		paramConectorCliente.add(new MareBusinessID("MAEBusquedaRapidaCliente"));
		traza("Antes de Conectar ConectorBusquedaRapidaCliente");
		DruidaConector conectorCliente = null;
		String oidCliente = null;
		try{
			conectorCliente = conectar("ConectorBusquedaRapidaCliente", paramConectorCliente);							
			traza("Despues de Conectar ConectorBusquedaRápidaCliente");
			DTOSalida dtoSalida = (DTOSalida)conectorCliente.objeto("DTOSalida");
			
			if (dtoSalida.getResultado().getRowCount() > 0){
				oidCliente = dtoSalida.getResultado().getValueAt(0,0).toString();
			}
		} catch (Exception ex){
		}
		//}
		
		asignar("VAR", "ejecutar", "ejecutarCorrecta('" + oidProducto + "', '" + oidCliente + "')");
		
		traza("*** LPCapturaProcesoReclamos.comprobarProducto: Salida **");
	}
	
	private void comprobarCliente() throws Exception{
		traza("*** LPCapturaProcesoReclamos.comprobarCliente(: Entrada **");
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		
		String codCliente = conectorParametroLimpia("txtCodClienteSeguro","",true);
		DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
		dto.setCodigoCliente(codCliente);
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		dto.setIndicadorSituacion(new Long(0));
		dto.setTamanioPagina(new Integer(1));
		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("MAEBusquedaRapidaCliente"));
		traza("Antes de Conectar ConectorBusquedaRapidaCliente");
		DruidaConector conector = null;
		String valor = null;
		try{
			conector = conectar("ConectorBusquedaRapidaCliente", paramConector);							
			traza("Despues de Conectar ConectorBusquedaRápidaCliente");
			DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
			
			if (dtoSalida.getResultado().getRowCount() > 0){
				valor = dtoSalida.getResultado().getValueAt(0,0).toString();
			}
		} catch (Exception ex){
		}
		
		
		asignar("VAR", "ejecutar", "asignarDatosCliente('" + valor + "')");
		
		traza("*** LPCapturaProcesoReclamos.comprobarCliente(: salida **");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
    	traza("Se produjo la excepcion: " + e.getMessage());           
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	e.printStackTrace(ps);                  
    	traza("Stack Trace: " + baos.toString());
    }   
}
