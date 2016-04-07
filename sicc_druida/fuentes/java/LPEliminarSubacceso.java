import LPSICCBase;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
 
public class LPEliminarSubacceso extends LPSICCBase  {
    String accion=null;
    String casoDeUso = null;
    // Definicion del constructor
    public LPEliminarSubacceso() {
        super();    
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {

        setTrazaFichero();

        accion = this.conectorParametroLimpia("accion", "", true);
        casoDeUso = this.conectorParametroLimpia("casoDeUso", "", true);

        try {
            // Rastreo
            rastreo();

            if (accion.equals("")) {
                casoDeUso = "eliminar";
                accion = "consultar";
                traza("Accion: "+accion+" - Caso de Uso: "+casoDeUso);
                conectorAction("LPMantenimientoSubacceso");
                conectorParametroSesion("casoDeUso",casoDeUso);
                conectorActionParametro("accion",accion);
			
            }
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
