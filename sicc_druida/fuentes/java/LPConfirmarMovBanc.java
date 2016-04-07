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
    $Id: LPConfirmarMovBanc.java,v 1.1 2009/12/03 18:40:59 pecbazalar Exp $
    DESC
 */
import LPSICCBase;

import es.indra.sicc.util.UtilidadesSession;
import java.util.Vector;
import java.util.StringTokenizer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.druida.Contexto;

import es.indra.sicc.dtos.ccc.DTONumerosLote;

// Definicion de la clase
public class LPConfirmarMovBanc extends LPSICCBase {
	     
	private String accion = null;
	
	public LPConfirmarMovBanc() {
		super();
	}
	
	public void inicio() throws Exception {
		// Asignar nombre de la vista
		pagina("contenido_movimientos_bancarios_confirmar");	
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("***Entrada -  LPConfirmarMovBanc - ejecucion ***");

		this.accion = conectorParametroLimpia("accion","", true);
		traza("***accion recuperada ***"+ this.accion);

		try {
			// Se obtiene la sesión
			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);

			if (this.accion.equals("")) {
				getConfiguracionMenu("LPConfirmarMovBanc", accion);
				accionVacia(pais, idioma);
			} else if (this.accion.equals("detalle")) {
				accionDetalle(pais, idioma);
			} else if (this.accion.equals("confirmar")) {
				accionConfirmar(pais, idioma);
			} else if (this.accion.equals("simular")) {
				accionSimular(pais, idioma);
			}
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e); 
		}

		traza("***Salida -  LPConfirmarMovBanc - ejecucion ***");
	}
	
	private void accionVacia(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPConfirmarMovBanc - accionVacia ***");
		
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_confirmar", "cod", "0171");
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_confirmar", "msgle", "0171");
        this.generarHiddenFormatoFecha();
 
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		//idBusiness="CCCObtieneBancos" , DTOBelcorp y cargamos el DTOSalida en el COMBO banco. 
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);

		// Se cargan los combos de la página
		this.cargaCombos(dtoBelcorp);

		traza("***Salida -  LPConfirmarMovBanc - accionVacia ***");
	}
	

	private void accionDetalle(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPConfirmarMovBanc - accionDetalle ***");
 		
		pagina("contenido_movimientos_bancarios_mantenimiento");	
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_mantenimiento", "cod", "0171");
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_mantenimiento", "msgle", "0171");
		getConfiguracionMenu("LPConfirmarMovBanc", accion);

		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		String numeroLote = conectorParametroLimpia("numeroLote","", true);
		asignar("VAR", "numeroLote", numeroLote);
		asignar("VAR", "oid", numeroLote);
		asignar("VAR", "casoDeUso", "confirmar");
		asignar("VAR", "cu", "confirmar");

		traza("***Salida -  LPConfirmarMovBanc - accionDetalle ***");
	}

	private void accionConfirmar(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPConfirmarMovBanc - accionConfirmar ***");

		//Caso de uso y titulo de la pantalla
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "confirmacionCorrecta()");
		//asignar("VAR", "ejecutarError", "confirmacionIncorrecta()");
 
		DTONumerosLote dtoNumerosLote = new DTONumerosLote();
		String parametro = conectorParametroLimpia("numerosLote", "", true);
		traza("**********parametro: " + parametro);
                  
		if(!parametro.equals("")) {
			StringTokenizer st = new StringTokenizer(parametro, "#");;
			Vector vNumerosLote = new Vector();
			while (st.countTokens() > 0) {
				vNumerosLote.add(new Long(st.nextToken())); 
			}
			Long[] numerosLote = new Long[vNumerosLote.size()];
			for (int i = 0; i < numerosLote.length; i++) {
				numerosLote[i] = (Long)vNumerosLote.get(i);
				traza("**********parametro separado(cogido del array de Long): " + numerosLote[i]);
			}
			dtoNumerosLote.setNumerosLote(numerosLote);
		}

		dtoNumerosLote.setOidPais(pais);
		dtoNumerosLote.setOidIdioma(idioma);

		MareBusinessID idBusiness = new MareBusinessID("CCCConfirmarMovBanc");

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoNumerosLote);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		DruidaConector conector = conectar("ConectorConfirmarMovBanc", paramEntrada);
		traza("***Salida -  LPConfirmarMovBanc - accionConfirmar ***", conector);

		traza("***Salida -  LPConfirmarMovBanc - accionConfirmar ***");
	}

	private void accionSimular(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPConfirmarMovBanc - accionSimular ***");

		//Caso de uso y titulo de la pantalla
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "simulacionCorrecta()");
		//asignar("VAR", "ejecutarError", "confirmacionIncorrecta()");
 
		DTONumerosLote dtoNumerosLote = new DTONumerosLote();
		String parametro = conectorParametroLimpia("numerosLote", "", true);
		traza("**********parametro: " + parametro);
                  
		if(!parametro.equals("")) {
			StringTokenizer st = new StringTokenizer(parametro, "#");;
			Vector vNumerosLote = new Vector();
			while (st.countTokens() > 0) {
				vNumerosLote.add(new Long(st.nextToken())); 
			}
			Long[] numerosLote = new Long[vNumerosLote.size()];
			for (int i = 0; i < numerosLote.length; i++)
				numerosLote[i] = (Long)vNumerosLote.get(i);
			dtoNumerosLote.setNumerosLote(numerosLote);
		}

		dtoNumerosLote.setOidPais(pais);
		dtoNumerosLote.setOidIdioma(idioma);

		MareBusinessID idBusiness = new MareBusinessID("CCCSimularMovBanc");

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoNumerosLote);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		DruidaConector conector = conectar("ConectorSimularMovBanc", paramEntrada);

		traza("***Salida -  LPConfirmarMovBanc - accionSimular ***");
	}

	
	private void cargaCombos(DTOBelcorp dtoBelcorp) throws Exception {
		traza("*** Entrada - LPConfirmarMovBanc - cargaCombos ***");
	
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();
		elem.setIDBusiness("CCCObtieneBancos");
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);



		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();

		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
		asignar("COMBO", "cbBanco", conConsultar, "CCCObtieneBancos"); 

		traza("*** Salida - LPConfirmarMovBanc - cargaCombos ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());
	
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);
	      
	      traza("Stack Trace: " + baos.toString());
	}
     
}