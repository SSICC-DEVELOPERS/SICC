/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
//import LPSICCBase;

import es.indra.druida.DruidaBase;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPModificarMatrizDescuentos extends LPSICCBase {
	
	public LPModificarMatrizDescuentos(){super();}

	public void inicio() throws Exception{}

	public void ejecucion() throws Exception{
		this.rastreo();
        setTrazaFichero();
        try{
				String accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            if (accion.equals("")){
                conectorAction("LPMantenimientoMatrizDescuentos");
                conectorActionParametro("accion","buscar");
                conectorActionParametro("casodeuso","modificar");
            }
        }
        catch (Exception ex){
             logStackTrace(ex);
             this.lanzarPaginaError(ex);
        }	 
	 }	 
	 
	 private void logStackTrace(Throwable e) throws Exception {
       traza("Se produjo la excepcion: " + e.getMessage());
       ByteArrayOutputStream pila = new ByteArrayOutputStream();
       PrintStream out = new PrintStream(pila);
       if (e instanceof MareException) {
         MareException e2=(MareException)e;
         traza("Es una mare Exception con codigo de error: "+e2.getCode());
       }
       e.printStackTrace(out);
       traza("stack Trace : " +  pila.toString());
    }
    
}
