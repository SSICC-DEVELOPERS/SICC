/**
* Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* Espa�a
*
* Privado y Confidencial.
* La informaci�n contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permiti�ndose
* la distribuci�n de este c�digo sin permiso expreso.
*/


import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPGestionReclamosBloqueados extends LPSICCBase {

	public LPGestionReclamosBloqueados() {
	        super();
	}
	
	public void inicio() throws Exception {       

	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {         
			traza("*** Entrada - LPGestionReclamosBloqueados - ejecucion ***");   
			
			//Llamar a LPGestionReclamos con accion = "gestionar reclamos bloqueados"			
			conectorAction("LPGestionReclamos");
			conectorActionParametro("accion","gestionar reclamos bloqueados");			
			
			traza("*** Salida - LPGestionReclamosBloqueados - ejecucion ***"); 
		}catch ( Exception e )  {
			e.printStackTrace();
			logStackTrace(e);
			lanzarPaginaError(e);
		}              
	}
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}	
}