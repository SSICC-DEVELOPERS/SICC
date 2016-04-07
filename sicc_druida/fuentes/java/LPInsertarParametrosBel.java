/**
 * Copyright 2006 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
 
public class LPInsertarParametrosBel extends LPSICCBase {
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();
        traza("*** Entrada - LPInsertarParametrosBel - ejecucion ***");

		try  {
			conectorAction("LPMantenimientoParametrosBel");
            conectorActionParametro("accion", "insertar");  
		} catch ( Exception e )  {
			logStackTrace(e);
            lanzarPaginaError(e);
		}

		traza("*** Salida - LPInsertarParametrosBel - ejecucion ***");
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepción: " + e.getMessage());

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        e.printStackTrace(print);

        traza("Stack Trace: " + out.toString());
    }
}