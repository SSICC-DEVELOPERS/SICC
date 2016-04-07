import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class LPInsertarTipoEncuesta extends LPSICCBase {

        

          public LPInsertarTipoEncuesta() {
                    super();
          }


          public void inicio() throws Exception {


          }
          public void ejecucion() throws Exception {
                  try{
						setTrazaFichero();
						traza("LPInsertarTipoEncuesta:  Entrada");
						conectorAction("LPMantenimientoTipoEncuesta");
						conectorActionParametro("accion","");
                        conectorActionParametro("opcionMenu","insertar");
						traza("LPInsertarTipoEncuesta: Salida");
                  }catch(Exception e){
							  traza("Exception en LPInsertarTipoEncuesta");
                              e.printStackTrace();     
                              lanzarPaginaError(e);

                  }
        }
}
