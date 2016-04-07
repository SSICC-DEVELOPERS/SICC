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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


public class LPMantenerTerritoriosRutas extends LPSICCBase {
          
          private String accion = null;
          private String opcionMenu = null;
          public LPMantenerTerritoriosRutas() {
                    super();
          }


          public void inicio() throws Exception {
                    
  
          }
          public void ejecucion() throws Exception {
                    setTrazaFichero();
                    try  {         
                              traza("LPMantenerTerritoriosRutas  Entrada");
                              conectorAction("LPMantenimientoTerritoriosRutas");
                              conectorActionParametro("accion","");
                              conectorActionParametro("opcionMenu","Mantener Territorios");
                              traza("LPMantenerTerritoriosRutas  Salida");                    
                    }catch ( Exception e ){
                              e.printStackTrace();
                              this.logStackTrace(e);
                              lanzarPaginaError(e);
                    }              
          }
         private void logStackTrace(Throwable e) throws Exception {
                  traza("Se produjo la excepcion: " + e.getMessage());		
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);		
                  traza("Stack Trace: " + baos.toString());
         }
}
