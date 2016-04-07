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

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.util.Vector;

public class LPValidarReclamos extends LPSICCBase {
         
	private String accion = null;
	private Long pais;
	private Long idioma;
	
	public LPValidarReclamos() {
	    super();
	}
	      
	public void inicio() throws Exception {
		pagina("salidaGenerica");
	}
    
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** HSH Entrada -  LPValidarReclamos - ejecucion ***");

		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);
		traza("HSH accion=: "+accion+"||pais="+this.pais+"||idioma="+idioma);
		
		try {	             
			accionVacia();
		} catch (Exception e) {
		logStackTrace(e);
		lanzarPaginaError(e);
		}
		
		traza("*** HSH Salida -  LPValidarReclamos- ejecucion ***");
	      
	}

	private void accionVacia () throws Exception {
		traza("*** Entrada -  LPValidarReclamos- accionVacia ***");		
		/*
		Crea idBusiness = "RECValidarReclamos" 
		Invoca a ConectorValidarReclamos */
		
		Vector  paramConector = new Vector();
		
		DTOBelcorp dtoBelcorp = new DTOBelcorp();	
		dtoBelcorp.setOidPais(this.pais);
		dtoBelcorp.setOidIdioma(this.idioma);
		
		paramConector.add(dtoBelcorp);
		paramConector.add(new MareBusinessID("RECValidarReclamos"));
              
              traza ("Antes de llamar al Conector  ConectorValidarReclamos");
		DruidaConector conector = conectar("ConectorValidarReclamos", paramConector);
		
		traza("*** Salida -  LPValidarReclamos- accionVacia ***");	
	}

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}
}                                                               