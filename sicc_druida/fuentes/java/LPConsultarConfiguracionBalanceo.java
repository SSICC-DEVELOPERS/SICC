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
 *
 */

public class LPConsultarConfiguracionBalanceo extends LPSICCBase {

	public void inicio() { }

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try	{
			rastreo();
			traza("*** Entro a LPConsultarConfiguracionBalanceo");
			conectorAction("LPMantenerConfiguracionBalanceo");
			conectorActionParametro("opcionMenu", "consultar");
		} catch (Exception e) {
			traza("*** Exception en LPConsultarConfiguracionBalanceo");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}

}