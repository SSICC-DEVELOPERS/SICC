import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.ped.ConstantesPedFaltantes;
import java.sql.Date;
import es.indra.sicc.dtos.ped.DTOEInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOInformeFaltantes;
import java.text.DateFormat;
import es.indra.mare.common.exception.MareException;

import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
//import java.text.DateFormat;

public class LPRegistroOnlineModalEjemplo extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;
    
   public void inicio() throws Exception{
      pagina("contenido_registro_online_modal_ejemplo");
    }

  public LPRegistroOnlineModalEjemplo() 
  {
    super();
  }
    public void ejecucion() throws Exception {
        this.setTrazaFichero();
        try{
            muestraPagina();
        }catch(Exception e){
            logStackTrace(e);
        }
    }

    private void muestraPagina() throws Exception{
        pagina("contenido_registro_online_modal_ejemplo");
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
