import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPInsertarRangoTipos extends LPSICCBase {  
    
    public LPInsertarRangoTipos() { super(); }

    public void inicio() throws Exception { }
    
    public void ejecucion() throws Exception {      
      setTrazaFichero();
      traza(" * * * Entre a LPInsertarRangoTipos * * *");
      String accion  = conectorParametro("accion");
      
      if(accion==null) accion = "";
      traza(" * * * accion = " + accion);
      
      try {
        if (accion.equals("")) {        
          traza(" * * * Llamando a LPMantenimientoRangoTipos * * *");
          conectorAction("LPMantenimientoRangoTipos");
          conectorActionParametro("casoDeUso", "Insertar");
          conectorActionParametro("accion","");                
        }
      }
      catch (Exception ex) {
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stack);
        ex.printStackTrace(out);
        traza("* * * EXCEPCION:" + stack.toString());
        
        this.lanzarPaginaError(ex);
      }    
    }  
  }
