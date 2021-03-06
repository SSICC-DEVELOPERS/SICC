/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
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

//import LPSICCBase;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.util.UtilidadesBelcorp;
import java.lang.String;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LPCrearMatrizDescuentos extends LPSICCBase {
      String casodeuso = new String();

      public void inicio() throws Exception{
      }

      public void ejecucion() throws Exception{
        this.rastreo();
        setTrazaFichero();
		  try{
            String accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            if (accion.equals("")){
                conectorAction("LPMantenimientoMatrizDescuentos");
                conectorActionParametro("casodeuso","crear");
                conectorActionParametro("accion", "crear");
            }
        }
        catch(Exception exception){
            logStackTrace(exception);
            lanzarPaginaError(exception);
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
