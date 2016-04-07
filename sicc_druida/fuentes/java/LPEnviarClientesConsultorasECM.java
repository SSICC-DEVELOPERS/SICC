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
public class LPEnviarClientesConsultorasECM extends LPSICCBase {
	
	public LPEnviarClientesConsultorasECM() {
		super();
	}
	
	public void inicio() throws Exception {
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPEnviarClientesConsultorasECM - ejecucion ***");
		
		try{
			//Llamar a la LPECM con accion = "guardar" y opcion = "enviar clientes"	
			//Modificado por incidencia15221		
			conectorAction("LPECM");
			//conectorActionParametro("accion","guardar");
			conectorActionParametro("accion","");
			conectorActionParametro("opcion","enviar clientes");

		}catch(Exception  e){
			traza("ERROR: " + e);
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPEnviarClientesConsultorasECM - ejecucion ***");
	}
}