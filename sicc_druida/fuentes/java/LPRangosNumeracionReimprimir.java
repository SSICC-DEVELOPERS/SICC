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
    $Id: LPRangosNumeracionReimprimir.java,v 1.1 2009/12/03 18:36:02 pecbazalar Exp $
    DESC
 */


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;

import java.util.Vector;
import java.util.StringTokenizer;


import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;

import es.indra.sicc.dtos.fac.DTOOIDsDocumentos;

// Definicion de la clase
public class LPRangosNumeracionReimprimir extends LPSICCBase  {

    // Añadido por la BELC300015675
    Long subacceso = null;    

	public LPRangosNumeracionReimprimir() {super();}

	private String accion		= null;
          
	public void inicio() throws Exception {
		pagina("contenido_rangos_numeracion_imprimir");
	}

	public void ejecucion() throws Exception {
		
		rastreo();

		this.accion = conectorParametroLimpia("accion", "", true);

		try {
			setTrazaFichero();
			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);
			
            // Añadido por la BELC300015675
            // Obtenemos el subacceso por defecto de la sesión.
            this.subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
            traza("subacceso = "+this.subacceso);

			if (accion.equals("")) {
				getConfiguracionMenu("LPRangosNumeracionReimprimir", "imprimir");
                this.inicializar(pais, idioma);     
			} else if (accion.equals("imprimirUltimasNoticias")) {
                this.imprimirUltimasNoticias(pais, idioma);     
				
			} else if (accion.equals("imprimirCartaConsultoras")) {
                this.imprimirCartaConsultoras(pais, idioma);     
				
			} else if (accion.equals("imprimirBoletaDespacho")) {
                this.imprimirBoletaDespacho(pais, idioma);     
				
			} else if (accion.equals("imprimirDocumentosContables")) {
                this.imprimirDocumentosContables(pais, idioma);     
			}
		} catch (Exception ex) {
			logStackTrace(ex);
			this.lanzarPaginaError(ex);   
		}
	}            	


	private void inicializar(Long pais, Long idioma) throws Exception {
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		String casoUso = conectorParametroLimpia("casoDeUso", "", true);
		asignar("VAR", "casoUso", casoUso);
		this.generarHiddenFormatoFecha();
		String longitudCodCliente = obtenerLongitudCodigoCliente().toString(); 
		asignar("VAR", "longitudCodigoCliente", longitudCodCliente);

		//idBusiness="SEGConsultaCanales" , DTOBelcorp y cargamos el DTOSalida en el COMBO cbCanal. 
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);
		DTOTipoSolicitudPais dtoTipos = new DTOTipoSolicitudPais();
		dtoTipos.setOidPais(pais);
		dtoTipos.setOidIdioma(idioma);

		// Se cargan los combos de la página
		this.cargaCombos(dtoBelcorp, dtoTipos);

		asignarAtributo("PAGINA", "contenido_rangos_numeracion_imprimir", "msgle", "reimprimir");
		if (casoUso.equals("casoUsoImprimirUltimasNoticias"))
			asignarAtributo("PAGINA", "contenido_rangos_numeracion_imprimir", "cod", "0551");
		else if(casoUso.equals("casoUsoImprimirCartaConsultoras"))
			asignarAtributo("PAGINA", "contenido_rangos_numeracion_imprimir", "cod", "0552");
	}

                  
	private void imprimirUltimasNoticias(Long pais, Long idioma) throws Exception {
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "impresionCorrecta()");
		//asignar("VAR", "ejecutarError", "impresionIncorrecta()");

		//- Se construye un objeto DTOOIDs con los oid de los registros marcados en la pantalla de detalle
		DTOOIDs dtoOids = new DTOOIDs();
		String parametro = conectorParametroLimpia("codigos", "", true);
		traza("**********parametro imprimirUltimasNoticias: " + parametro);
                  
		if(!parametro.equals("")) {
			StringTokenizer st = new StringTokenizer(parametro, ",");;
			Vector vOids = new Vector();
			while (st.countTokens() > 0) {
				vOids.add(new Long(st.nextToken())); 
			}
			Long[] oids = new Long[vOids.size()];
			for (int i = 0; i < oids.length; i++)
				oids[i] = (Long)vOids.get(i);
			dtoOids.setOids(oids);
		}

		dtoOids.setOidPais(pais);
		dtoOids.setOidIdioma(idioma);

		MareBusinessID idBusiness = new MareBusinessID("FACReimprimirUltimasNoticias");

        // Añadido por la BELC300015675
        // Obtenemos el subacceso por defecto de la sesión.
        DTOOIDsDocumentos dtoOidsDocumentos = new DTOOIDsDocumentos();
        dtoOidsDocumentos.setOidPais(pais);
        dtoOidsDocumentos.setOidIdioma(idioma);
        dtoOidsDocumentos.setSubacceso(this.subacceso);
        dtoOidsDocumentos.setLista(dtoOids);

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOidsDocumentos);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		DruidaConector conector = conectar("ConectorReimprimirUltimasNoticias", paramEntrada);

		//Se lanza una pantalla de confirmacion con un boton aceptar con el siguiente texto "Operación realizada correctamente"
	}

	private void imprimirCartaConsultoras(Long pais, Long idioma) throws Exception {
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "impresionCorrecta()");
		//asignar("VAR", "ejecutarError", "impresionIncorrecta()");

		//- Se construye un objeto DTOOIDs con los oid de los registros marcados en la pantalla de detalle
		DTOOIDs dtoOids = new DTOOIDs();
		String parametro = conectorParametroLimpia("codigos", "", true);
		traza("**********parametro imprimirCartaConsultoras: " + parametro);
                  
		if(!parametro.equals("")) {
			StringTokenizer st = new StringTokenizer(parametro, ",");;
			Vector vOids = new Vector();
			while (st.countTokens() > 0) {
				vOids.add(new Long(st.nextToken())); 
			}
			Long[] oids = new Long[vOids.size()];
			for (int i = 0; i < oids.length; i++)
				oids[i] = (Long)vOids.get(i);
			dtoOids.setOids(oids);
		}

		dtoOids.setOidPais(pais);
		dtoOids.setOidIdioma(idioma);

		MareBusinessID idBusiness = new MareBusinessID("FACReimprimirCartaConsultoras");

        // Añadido por la BELC300015675
        // Obtenemos el subacceso por defecto de la sesión.
        DTOOIDsDocumentos dtoOidsDocumentos = new DTOOIDsDocumentos();
        dtoOidsDocumentos.setOidPais(pais);
        dtoOidsDocumentos.setOidIdioma(idioma);
        dtoOidsDocumentos.setSubacceso(this.subacceso);
        dtoOidsDocumentos.setLista(dtoOids);

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOidsDocumentos);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		DruidaConector conector = conectar("ConectorReimprimirCartaConsultoras", paramEntrada);

		//Se lanza una pantalla de confirmacion con un boton aceptar con el siguiente texto "Operación realizada correctamente"
	}

	private void imprimirBoletaDespacho(Long pais, Long idioma) throws Exception {
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "impresionCorrecta()");
		//asignar("VAR", "ejecutarError", "impresionIncorrecta()");

		//- Se construye un objeto DTOOIDs con los oid de los registros marcados en la pantalla de detalle
		DTOOIDs dtoOids = new DTOOIDs();
		String parametro = conectorParametroLimpia("codigos", "", true);
		traza("**********parametro imprimirBoletaDespacho: " + parametro);
                  
		if(!parametro.equals("")) {
			StringTokenizer st = new StringTokenizer(parametro, ",");;
			Vector vOids = new Vector();
			while (st.countTokens() > 0) {
				vOids.add(new Long(st.nextToken())); 
			}
			Long[] oids = new Long[vOids.size()];
			for (int i = 0; i < oids.length; i++)
				oids[i] = (Long)vOids.get(i);
			dtoOids.setOids(oids);
		}

		dtoOids.setOidPais(pais);
		dtoOids.setOidIdioma(idioma);

		MareBusinessID idBusiness = new MareBusinessID("FACReimprimirBoletaDespacho");

        // Añadido por la BELC300015675
        // Obtenemos el subacceso por defecto de la sesión.
        DTOOIDsDocumentos dtoOidsDocumentos = new DTOOIDsDocumentos();
        dtoOidsDocumentos.setOidPais(pais);
        dtoOidsDocumentos.setOidIdioma(idioma);
        dtoOidsDocumentos.setSubacceso(this.subacceso);
        dtoOidsDocumentos.setLista(dtoOids);

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOidsDocumentos);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		DruidaConector conector = conectar("ConectorReimprimirBoletaDespacho", paramEntrada);

		//Se lanza una pantalla de confirmacion con un boton aceptar con el siguiente texto "Operación realizada correctamente"
	}

	private void imprimirDocumentosContables(Long pais, Long idioma) throws Exception {
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "impresionCorrecta()");
		//asignar("VAR", "ejecutarError", "impresionIncorrecta()");

		//- Se construye un objeto DTOOIDs con los oid de los registros marcados en la pantalla de detalle
		DTOOIDs dtoOids = new DTOOIDs();
		String parametro = conectorParametroLimpia("listado1", "", true);
		traza("**********parametro imprimirDocumentosContables: " + parametro);
                  
		if(!parametro.equals("")) {
			StringTokenizer st = new StringTokenizer(parametro, ",");;
			Vector vOids = new Vector();
			while (st.countTokens() > 0) {
				vOids.add(new Long(st.nextToken())); 
			}
			Long[] oids = new Long[vOids.size()];
			for (int i = 0; i < oids.length; i++)
				oids[i] = (Long)vOids.get(i);
			dtoOids.setOids(oids);
		}

		dtoOids.setOidPais(pais);
		dtoOids.setOidIdioma(idioma);

		MareBusinessID idBusiness = new MareBusinessID("FACReimprimirDocumento");

        // Añadido por la BELC300015675
        // Obtenemos el subacceso por defecto de la sesión.
        DTOOIDsDocumentos dtoOidsDocumentos = new DTOOIDsDocumentos();
        dtoOidsDocumentos.setOidPais(pais);
        dtoOidsDocumentos.setOidIdioma(idioma);
        dtoOidsDocumentos.setSubacceso(this.subacceso);
        dtoOidsDocumentos.setLista(dtoOids);

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOidsDocumentos);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		DruidaConector conector = conectar("ConectorReimprimirDocumentos", paramEntrada);

		//Se lanza una pantalla de confirmacion con un boton aceptar con el siguiente texto "Operación realizada correctamente"
	}


	private void cargaCombos(DTOBelcorp dtoBelcorp, DTOTipoSolicitudPais dtoTSP) throws Exception {
		traza("*** Entrada - LPRangosNumeracionReimprimir - cargaCombos ***");
	
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();
		elem.setIDBusiness("SEGConsultaCanales");
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);

		elem = new ComposerViewElement();
		elem.setIDBusiness("PEDTiposSolicitudPaisUnion");
		elem.setDTOE(dtoTSP);
		listelem.addViewElement(elem);



		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();

		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
		asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
		asignar("COMBO", "cbTipoConsolidado", conConsultar, "PEDTiposSolicitudPaisUnion"); 

		traza("*** Salida - LPRangosNumeracionReimprimir - cargaCombos ***");
	}

	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());
	
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);
	      
	      traza("Stack Trace: " + baos.toString());
	}
             	
}

