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
public class LPRecibirClientesECM extends LPSICCBase {
	
	public LPRecibirClientesECM() {
		super();
	}
	
	public void inicio() throws Exception {
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPRecibirClientesECM - ejecucion ***");
		
		try{
			//-> Llamar a la LPECM con accion = "" y opcion = "clientes"
			
			conectorAction("LPECM");
			conectorActionParametro("accion","");
			conectorActionParametro("opcion","clientes");

		}catch(Exception  e){
			traza("ERROR: " + e);
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPRecibirClientesECM - ejecucion ***");
	}
}