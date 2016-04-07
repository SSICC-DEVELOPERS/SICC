import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


public class LPInsertarRemplazoPremios extends LPSICCBase {

         public void inicio() { }

         public void ejecucion() throws Exception {
                  setTrazaFichero();
                  try	{
                           rastreo();
                           traza("*** Entro a LPInsertarRemplazoPremios ****");
                           conectorAction("LPMantenimientoRemplazoPremios");
                           conectorActionParametro("accion","");
                           conectorActionParametro("opcionMenu", "insertar");
                  } catch (Exception e) {
                           traza("*** Exception en LPInsertarRemplazoPremios");
                           e.printStackTrace();     
                           lanzarPaginaError(e);
                  }
         }

}
