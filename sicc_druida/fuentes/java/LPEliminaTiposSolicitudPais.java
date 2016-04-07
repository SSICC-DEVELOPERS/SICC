/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       23/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 * Descripcion: 
 */
import LPSICCBase;

public class LPEliminaTiposSolicitudPais extends LPSICCBase{
         public LPEliminaTiposSolicitudPais(){
                  super();
         }

         public void inicio() throws Exception {}
         
         public void ejecucion() throws Exception{
                  // Invoca a LPMantieneTiposSolicitudPais cambiando la accion = "muestraConsulta"		
                  try{
                           this.rastreo();
                           setTrazaFichero();
                           traza("> Entrando a LPEliminaTiposSolicitudPais.ejecucion");
                           conectorAction("LPMantieneTiposSolicitudPais");
                           conectorActionParametro("accion", "muestraBorrado");
                  } catch(Exception e){
                           lanzarPaginaError(e);
                  }
         }
}
