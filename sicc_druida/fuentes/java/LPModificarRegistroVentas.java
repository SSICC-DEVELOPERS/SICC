/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
 
public class LPModificarRegistroVentas extends LPSICCBase {

          public LPModificarRegistroVentas() {
                    super();
          }
          
          public void inicio() throws Exception {
          
          }

          public void ejecucion() throws Exception {
          	rastreo();
          	setTrazaFichero();
          	traza("*** Entrada - LPModificarRegistroVentas - ejecucion ***");
                try  {
			conectorAction("LPMantenimientoRegistroVentas"); 
			conectorActionParametro("accion","modificar_menu_principal"); 
                }catch ( Exception e ) {
                        logStackTrace(e);
                        lanzarPaginaError(e);
                }
           traza("*** Salida - LPModificarRegistroVentas - ejecucion ***");
          }

    private void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                    
                    traza("Stack Trace: " + baos.toString());
     }

}