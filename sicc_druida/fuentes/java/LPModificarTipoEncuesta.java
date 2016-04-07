import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class LPModificarTipoEncuesta extends LPSICCBase {

        

          public LPModificarTipoEncuesta() {
                    super();
          }


          public void inicio() throws Exception {


          }
          public void ejecucion() throws Exception {
                  try{
						setTrazaFichero();
						traza("LPModificarTipoEncuesta:  Entrada");
						conectorAction("LPMantenimientoTipoEncuesta");
						conectorActionParametro("accion","");
                        conectorActionParametro("opcionMenu","modificar");
						traza("LPModificarTipoEncuesta: Salida");
                  }catch(Exception e){
							  traza("Exception en LPModificarTipoEncuesta");
                              e.printStackTrace();     
                              lanzarPaginaError(e);

                  }
        }
}
