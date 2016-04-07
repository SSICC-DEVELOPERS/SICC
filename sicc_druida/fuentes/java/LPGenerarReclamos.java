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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;

import es.indra.sicc.cmn.presentacion.cache.Cache;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOID;

public class LPGenerarReclamos extends LPSICCBase {
          
	private String accion = null;
	private Long idioma = null;
	private Long pais = null;
	
	public LPGenerarReclamos() {
	        super();
	}
	
	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {         
			traza("*** Entrada - LPGenerarReclamos - ejecucion ***"); 
			
			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			this.accion = conectorParametroLimpia("accion","", true);
			traza("Accion: "+this.accion);
					
			
			if(this.accion.equals("generar")){
				traza("Antes de llamar a accionGenerar");
				accionGenerar();
			}
			
			traza("*** Entrada - LPGenerarReclamos - ejecucion ***"); 
		}catch ( Exception e )  {
		      e.printStackTrace();
		      logStackTrace(e);
		      lanzarPaginaError(e);
		}              
	}
	
	private void accionGenerar() throws Exception{
		traza("*** Entrada - LPGenerarReclamos - accionGenerar ***");
		/*
		- Se toma en oidCabecera recibido de la pantalla (En el caso de que estemos modificando). En el caso de no recibir ninguno (caso de nueva generacion) se obtiene de la sesion. 
		- Crear un DTOE del tipo DTOOid con este oidCabecera (además del pais y el idioma) 
		- Invocar al conector ConectorGenerarReclamo con el DTOE 
		- Crear IDBusiness="RECGenerarReclamo" 
		*/
		
		pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "false");
		
		String oidCab =  conectorParametroLimpia("oidCabecera","",true);
		Long oidCabecera = null;
		if (oidCab.equals("")){
			Cache cache = this.getSessionCache();
			oidCabecera = (Long)cache.get("oidCabecera");
		}else{
			oidCabecera = new Long(oidCab);
		}
		DTOOID dtoe = new DTOOID();
		dtoe.setOid(oidCabecera);
		dtoe.setOidIdioma(this.idioma);
		dtoe.setOidPais(this.pais);
		
		Vector paramConector = new Vector();
              paramConector.add(dtoe);
              paramConector.add(new MareBusinessID("RECGenerarReclamo"));             
              traza("Antes de Conectar ConectorGenerarReclamo");
              DruidaConector conector = conectar("ConectorGenerarReclamo", paramConector);							
              traza("Despues de Conectar ConectorGenerarReclamo");
		
		traza("*** Salida - LPGenerarReclamos - accionGenerar ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());		
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);		
	      traza("Stack Trace: " + baos.toString());
	}
		
}