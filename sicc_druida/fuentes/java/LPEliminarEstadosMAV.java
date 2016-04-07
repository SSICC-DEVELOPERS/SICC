import LPSICCBase;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;


public class LPEliminarEstadosMAV   extends LPSICCBase  {
    String accion=null;
    String casoDeUso = null;
    // Definicion del constructor
    public LPEliminarEstadosMAV () {
         super();    
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {

         try {

                  conectorAction("LPMantenimientoEstadosMAV");
                  conectorActionParametro("casoDeUso","eliminar");
                  conectorActionParametro("accion","consultar");
                           
         } catch (Throwable ex) {
             traza("exception: " + ex);
             java.io.StringWriter sw = new java.io.StringWriter();
             java.io.PrintWriter pw = new java.io.PrintWriter(sw);
             ex.printStackTrace(pw);
             pw.flush();
             traza("trace:"+sw);

             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(ex);

        }
    }
}

