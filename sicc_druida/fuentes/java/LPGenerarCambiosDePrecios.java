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
    INDRA/CAR/PROY
    $Id: LPGenerarCambiosDePrecios.java,v 1.1 2009/12/03 18:34:01 pecbazalar Exp $
    DESC
*/

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

public class LPGenerarCambiosDePrecios extends LPSICCBase {
    

	public LPGenerarCambiosDePrecios() {
		super();
	}
	
	public void inicio() throws Exception {
	}
	
	public void ejecucion() throws Exception {
	 
      rastreo();
     
      try {
         setTrazaFichero(); 
         traza("***Entrada - LPGenerarCambiosDePrecios - ejecucion***");
         
			// Llama a la LPCambiosDePrecios con: 
			// accion = "Generar Cambios"
			conectorAction("LPCambiosDePrecios");
			conectorActionParametro("accion", "generarCambios");
         
         traza("***Salida - LPGenerarCambiosDePrecios - ejecucion***");
                    
      } catch(Exception e) {
         logStackTrace(e);
         lanzarPaginaError(e);
      }
	}

	protected void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		                    
		traza("Stack Trace: " + baos.toString());
	}

}