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
 * @author Wancho
 */

import es.indra.mare.common.exception.MareException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LPModificarDTO extends LPSICCBase {
    public LPModificarDTO(){
      super();
    } 
	
    public void inicio() throws Exception {
    }

    /**
    * @author  Wancho
    * @date    21/11/2005
    * @description Inc. 14763
    * @throws Exception
    */    
    public void ejecucion() throws Exception {
        this.rastreo();
        setTrazaFichero();
        try {
            String accion = conectorParametro("accion")==null?"":
                                              conectorParametro("accion");
        
            if (accion.equals("")) {
                conectorAction("LPMantenimientoDTO");
                conectorActionParametro("accion","modificar");
                conectorActionParametro("casoDeUso","modificar");			
            }
        } catch (Exception ex) {
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
