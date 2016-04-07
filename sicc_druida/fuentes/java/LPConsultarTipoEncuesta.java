import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class LPConsultarTipoEncuesta extends LPSICCBase {

        

          public LPConsultarTipoEncuesta() {
                    super();
          }


          public void inicio() throws Exception {


          }
          public void ejecucion() throws Exception {
                  try{
						setTrazaFichero();
						traza("LPConsultarTipoEncuesta:  Entrada");
						conectorAction("LPMantenimientoTipoEncuesta");
						conectorActionParametro("accion","");
                        conectorActionParametro("opcionMenu","consultar");
						traza("LPConsultarTipoEncuesta: Salida");
                  }catch(Exception e){
							  traza("Exception en LPConsultarTipoEncuesta");
                              e.printStackTrace();     
                              lanzarPaginaError(e);

                  }
        }
}
