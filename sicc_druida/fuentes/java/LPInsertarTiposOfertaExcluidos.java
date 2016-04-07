/**
 * Copyright 2006 � por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
 

public class LPInsertarTiposOfertaExcluidos  extends LPSICCBase {

        public LPInsertarTiposOfertaExcluidos() {
                 super();
        }

         public void inicio() throws Exception {}

         public void ejecucion() throws Exception {
/*
 * -> Llamar a la LPMantenimientoTipoOfertaExcluido con: 
 * -> accion ="" 
 * -> opcionMenu= "InsertarTipoOfertaExcluido" 
*/         
             rastreo();
             setTrazaFichero();
             traza("*** Entrada - LPInsertarTiposOfertaExcluidos - ejecucion ***");

             try  {
                   conectorAction("LPMantenimientoTipoOfertaExcluido");
                   conectorActionParametro("accion", "");  
                   conectorActionParametro("opcionMenu", "InsertarTipoOfertaExcluido");  
                   
                  } catch ( Exception e ) {
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }
             traza("*** Salida - LPInsertarTiposOfertaExcluidos - ejecucion ***");
    }

    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepci�n: " + e.getMessage());

         ByteArrayOutputStream out = new ByteArrayOutputStream();
         PrintStream print = new PrintStream(out);
         e.printStackTrace(print);

         traza("Stack Trace: " + out.toString());
    }
}
