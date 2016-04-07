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
    $Id: LPDepurarMovBancHist.java,v 1.1 2009/12/03 18:32:21 pecbazalar Exp $
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

import es.indra.sicc.util.DTOOIDs;

// Definicion de la clase
public class LPDepurarMovBancHist extends LPSICCBase {
	     
	private String accion = null;
	
	public LPDepurarMovBancHist() {
		super();
	}
	
	public void inicio() throws Exception {
		// Asignar nombre de la vista
		pagina("contenido_movimientos_bancarios_historicos_depurar");	
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("***Entrada -  LPDepurarMovBancHist - ejecucion ***");

		this.accion = conectorParametroLimpia("accion","", true);
		traza("***accion recuperada ***"+ this.accion);

		try {

			// Se obtiene la sesión
			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);

			if (this.accion.equals("")) {
				getConfiguracionMenu("LPDepurarMovBancHist", accion);
				accionVacia(pais, idioma);
			} else if (this.accion.equals("detalle")) {
				accionDetalle(pais, idioma);
			} else if (this.accion.equals("traspasar")) {
				accionTraspasar(pais, idioma);
			}
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e); 
		}

		traza("***Salida -  LPDepurarMovBancHist - ejecucion ***");
	}
	
	private void accionVacia(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPDepurarMovBancHist - accionVacia ***");
		
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_historicos_depurar", "cod", "0190");
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_historicos_depurar", "msgle", "0190");
        this.generarHiddenFormatoFecha();
 
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		//idBusiness="CCCObtieneBancos" , DTOBelcorp y cargamos el DTOSalida en el COMBO banco. 
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);

		// Se cargan los combos de la página
		this.cargaCombos(dtoBelcorp);

		traza("***Salida -  LPDepurarMovBancHist - accionVacia ***");
	}
	

	private void accionDetalle(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPDepurarMovBancHist - accionDetalle ***");
 		
		pagina("contenido_movimientos_bancarios_mantenimiento");	
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_mantenimiento", "cod", "0190");
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_mantenimiento", "msgle", "0190");
		getConfiguracionMenu("LPDepurarMovBancHist", accion);

		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		String oid = conectorParametroLimpia("oid","", true);
		asignar("VAR", "numeroLote", oid);
		asignar("VAR", "oid", oid);
		asignar("VAR", "casoDeUso", "depurar");
		asignar("VAR", "cu", "depurar");

		traza("***Salida -  LPDepurarMovBancHist - accionDetalle ***");
	}

	private void accionTraspasar(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPDepurarMovBancHist - accionTraspasar ***");
		//Caso de uso y titulo de la pantalla
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "traspasoCorrecto()");
		asignar("VAR", "ejecutarError", "traspasoIncorrecto()");
 
		DTOOIDs dtoOids = new DTOOIDs();
		String parametro = conectorParametroLimpia("oidsMovimiento", "", true);
		traza("**********parametro: " + parametro);
                  
		if(!parametro.equals("")) {
			StringTokenizer st = new StringTokenizer(parametro, "#");;
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

		MareBusinessID idBusiness = new MareBusinessID("CCCTraspasarMovBanc");

		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOids);
		paramEntrada.addElement(idBusiness);

		// Se invoca al conector ConectorConsulta para validar los datos
		DruidaConector conector = conectar("ConectorTraspasarMovBanc", paramEntrada);

		traza("***Salida -  LPDepurarMovBancHist - accionTraspasar ***");
	}

	
	private void cargaCombos(DTOBelcorp dtoBelcorp) throws Exception {
		traza("*** Entrada - LPDepurarMovBancHist - cargaCombos ***");
	
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

		traza("*** Salida - LPDepurarMovBancHist - cargaCombos ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());
	
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);
	      
	      traza("Stack Trace: " + baos.toString());
	}
     
}