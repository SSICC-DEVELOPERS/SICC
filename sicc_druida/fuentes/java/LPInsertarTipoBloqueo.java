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
 *
 */

public class LPInsertarTipoBloqueo extends LPSICCBase {

	public void inicio() { }

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try	{
			rastreo();
			traza("*** Entro a LPInsertarTipoBloqueo");
			conectorAction("LPMantenimientoTipoBloqueo");
			conectorActionParametro("opcionMenu", "insertar");
		} catch (Exception e) {
			traza("*** Exception en LPInsertarTipoBloqueo");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}

}
