import LPSICCBase;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;


public class LPInsertarEstadosMAV  extends LPSICCBase  {
    String accion=null;
    String casoDeUso = null;
    // Definicion del constructor
    public LPInsertarEstadosMAV () {
         super();    
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {

         try {

                  conectorAction("LPMantenimientoEstadosMAV");
                  conectorActionParametro("casoDeUso","insertar");
                  conectorActionParametro("accion","insertar");
                           
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

