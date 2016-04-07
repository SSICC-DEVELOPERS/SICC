/** 
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Cochabamba 2552 8° Piso
 * Capital Federal, Buenos Aires
 * Argentina
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

import es.indra.sicc.logicanegocio.car.ConstantesCAR;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPReevaluarLineaCreditoEnMasa extends LPSICCBase {
   
    String accion = conectorParametroLimpia("accion", "", true);
         
    public LPReevaluarLineaCreditoEnMasa() {	 
        super();
    }

    public void inicio() throws Exception { 
    	
    }

    public void ejecucion() throws Exception {
      setTrazaFichero();
      if(accion == ""){
		this.rastreo();
        traza("LPImprimirMensajesEditorMensajes");
        conectorAction("LPReevaluarEnMasa");
        conectorActionParametro("accion","LineaCredito");
      }
    }

  private void logStackTrace(Throwable e) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);

    e.printStackTrace(ps);
    try {
      traza("Se produjo la excepcion: " 
        + e.getMessage() 
        + "\n" 
        + "stackTrace = " 
        + os.toString());
      } catch (Exception ex) {
        e.printStackTrace ();
      }
    }
    
    
}
