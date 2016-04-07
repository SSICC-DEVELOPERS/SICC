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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class LPConsultarReclamosCliente extends LPSICCBase {
          
	public LPConsultarReclamosCliente() {
	        super();
	}
	
	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		traza("*** Entrada - LPConsultarReclamosCliente - ejecucion ***"); 
		setTrazaFichero();
		try {	             
			conectorAction("LPConsultarInforme");
			// DBLG700000144 - Parametro de CAL Contacto/"Ejecutar Proceso"
            String codCliente = conectorParametroLimpia("codCliente", "", true);
			String oidZona = conectorParametroLimpia("oidZona", "", true);
			traza("7777777777777 oidZona: " + oidZona);
            if(codCliente!=null && codCliente!=""){
                 conectorActionParametro("accion","consultar reclamo");		
			}else{
    			 conectorActionParametro("accion","");
			}
			traza("LPConsultarReclamosCliente - codCliente para pre-carga de CTEXTO_" + codCliente);
            conectorActionParametro("codCliente", codCliente);
			conectorActionParametro("oidZona", oidZona);
		}catch ( Exception e )  {
		      e.printStackTrace();
		      logStackTrace(e);
		      lanzarPaginaError(e);
		}
		traza("*** Salida - LPConsultarReclamosCliente - ejecucion ***"); 
	}

	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());		
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);		
	      traza("Stack Trace: " + baos.toString());
	}	
}