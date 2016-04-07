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


public class LPModificarAutorizacion extends LPSICCBase {

	public void inicio() { }

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try	{
			rastreo();
			traza("*** Entro a LPModificarAutorizacion");
			conectorAction("LPMantenimientoAutorizacion");
			conectorActionParametro("accion", "");
			conectorActionParametro("opcionMenu", "ModificarAutorizacion");
		} catch (Exception e) {
			traza("*** Exception en LPModificarAutorizacion");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}