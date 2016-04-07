/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       13/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */
import LPSICCBase;

public class LPEliminaTiposSolicitud extends LPSICCBase{
	public LPEliminaTiposSolicitud(){
		super();
	}

	public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception{
		// Invoca a LPMantieneTiposSolicitud cambiando la accion = "muestraBorrado"		
		try{
			this.rastreo();
			setTrazaFichero();
			traza("> Entrando a LPEliminaTiposSolicitud.ejecucion");
			conectorAction("LPMantieneTiposSolicitud");
			conectorActionParametro("accion", "muestraBorrado");
		} catch(Exception e){
			lanzarPaginaError(e);
		}
	}
}
