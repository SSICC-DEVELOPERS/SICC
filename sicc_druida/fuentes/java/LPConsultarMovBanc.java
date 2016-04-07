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
    $Id: LPConsultarMovBanc.java,v 1.1 2009/12/03 18:43:46 pecbazalar Exp $
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
import es.indra.sicc.dtos.ccc.DTOBuscarMovBancConsultar;

// Definicion de la clase
public class LPConsultarMovBanc extends LPSICCBase {
	     
	private String accion = null;
	
	public LPConsultarMovBanc() {
		super();
	}
	
	public void inicio() throws Exception {
		// Asignar nombre de la vista
		pagina("contenido_movimientos_bancarios_consultar");	
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("***Entrada -  LPConsultarMovBanc - ejecucion ***");

		this.accion = conectorParametroLimpia("accion","", true);
		traza("***accion recuperada ***"+ this.accion);

		try {

			// Se obtiene la sesión
			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);

			if (this.accion.equals("")) {
				getConfiguracionMenu("LPConsultarMovBanc", this.accion);
				accionVacia(pais, idioma);
			} else if (this.accion.equals("detalle")) {
				accionDetalle(pais, idioma);
			}
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e); 
		}

		traza("***Salida -  LPConsultarMovBanc - ejecucion ***");
	}
	
	private void accionVacia(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPConsultarMovBanc - accionVacia ***");
		
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_consultar", "cod", "0181");
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_consultar", "msgle", "0181");
        this.generarHiddenFormatoFecha();
 
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		//idBusiness="CCCObtieneBancos" , DTOBelcorp y cargamos el DTOSalida en el COMBO banco. 
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);

		// Se cargan los combos de la página
		this.cargaCombos(dtoBelcorp);
        String longitudCodCliente = this.obtenerLongitudCodigoCliente().toString(); 
        asignar("VAR", "longitudCodigoCliente", longitudCodCliente);

		traza("***Salida -  LPConsultarMovBanc - accionVacia ***");
	}
	

	private void accionDetalle(Long pais, Long idioma) throws Exception {
		traza("***Entrada -  LPConsultarMovBanc - accionDetalle ***");
 		
		pagina("contenido_movimientos_bancarios_mantenimiento");	
		//Caso de uso y titulo de la pantalla
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_mantenimiento", "cod", "0181");
		asignarAtributo("PAGINA", "contenido_movimientos_bancarios_mantenimiento", "msgle", "0181");
		getConfiguracionMenu("LPConsultarMovBanc", this.accion);

		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

		String oid = conectorParametroLimpia("oid","", true);
		asignar("VAR", "numeroLote", oid);
		asignar("VAR", "oid", oid);
		asignar("VAR", "casoDeUso", "consultar");
		asignar("VAR", "cu", "consultar");

		traza("***Salida -  LPConsultarMovBanc - accionDetalle ***");
	}



	
	private void cargaCombos(DTOBelcorp dtoBelcorp) throws Exception {
		traza("*** Entrada - LPConsultarMovBanc - cargaCombos ***");
	
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();
		elem.setIDBusiness("CCCObtieneBancos");
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);

		elem = new ComposerViewElement();
		elem.setIDBusiness("CCCObtenerTiposTransaccion");
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);



		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();

		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
		asignar("COMBO", "cbBanco", conConsultar, "CCCObtieneBancos"); 
		asignar("COMBO", "cbTipoTransaccion", conConsultar, "CCCObtenerTiposTransaccion"); 

		traza("*** Salida - LPConsultarMovBanc - cargaCombos ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());
	
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);
	      
	      traza("Stack Trace: " + baos.toString());
	}
     
}