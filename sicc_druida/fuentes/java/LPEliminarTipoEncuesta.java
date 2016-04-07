import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class LPEliminarTipoEncuesta extends LPSICCBase {

        

          public LPEliminarTipoEncuesta() {
                    super();
          }


          public void inicio() throws Exception {


          }
          public void ejecucion() throws Exception {
                  try{
						setTrazaFichero();
						traza("LPEliminarTipoEncuesta:  Entrada");
						conectorAction("LPMantenimientoTipoEncuesta");
						conectorActionParametro("accion","");
                        conectorActionParametro("opcionMenu","eliminar");
						traza("LPEliminarTipoEncuesta: Salida");
                  }catch(Exception e){
							  traza("Exception en LPInsertarTipoEncuesta");
                              e.printStackTrace();     
                              lanzarPaginaError(e);

                  }
        }
}
