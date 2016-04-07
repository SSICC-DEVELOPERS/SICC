/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */


public class LPAnularEtiquetas extends LPSICCBase {

	public void inicio() throws Exception { }

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try	{
			rastreo();
			traza("*** Entro a LPAnularEtiquetas");
			conectorAction("LPAnulacionEtiquetas");
			conectorActionParametro("accion", "anulacion");
		} catch (Exception e) {
			traza("*** Exception en LPAnularEtiquetas");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}

}