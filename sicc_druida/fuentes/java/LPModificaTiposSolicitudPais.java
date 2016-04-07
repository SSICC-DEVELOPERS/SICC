/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       23/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 * Descripcion: 
 */

public class LPModificaTiposSolicitudPais extends LPSICCBase{
         public LPModificaTiposSolicitudPais(){
                  super();
         }

         public void inicio() throws Exception {}
         
         public void ejecucion() throws Exception{
                  // Invoca a LPMantieneTiposSolicitudPais cambiando la accion = "muestraConsulta"		
                  try{
                           this.rastreo();
                           setTrazaFichero();
                           traza("> Entrando a LPModificaTiposSolicitudPais.ejecucion");
                           conectorAction("LPMantieneTiposSolicitudPais");
                           conectorActionParametro("accion", "muestraModificacion");
                  } catch(Exception e){
                           lanzarPaginaError(e);
                  }
         }
}
