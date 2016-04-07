//import LPSICCBase;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.exception.MareException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPModificarSolicitudPedidos extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;  
    private String soidCabeceraSolicitud = null;
    private Long oidCabeceraSolicitud = null;
    private String operacion = null;
    
    
    public void inicio() throws Exception{
    }

    public LPModificarSolicitudPedidos() 
    {
      super();
    }
  
    public void ejecucion() throws Exception {
        this.setTrazaFichero();
        try{
            traza("Entra a LPModificarSolicitudPedidos");
            this.rastreo();
            pais=UtilidadesSession.getPais(this);
            idioma=UtilidadesSession.getIdioma(this);
            accion = "";
            operacion = "modificar";
            traza("accion"+accion);
            traza("operacion"+operacion);
            if (accion.equalsIgnoreCase("")){
				conectorAction("LPConsultarModificarSolicitud");
				conectorActionParametro("operacion","modificar");
				conectorActionParametro("accion","");  
            }
            
        }catch(Exception e){
            logStackTrace(e);
            //e.printStackTrace();
            this.lanzarPaginaError(e);
        }
    }
	private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
   }

}

