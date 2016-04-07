/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       13/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */
import LPSICCBase;

public class LPConsultaTiposSolicitud extends LPSICCBase{
	public LPConsultaTiposSolicitud(){
		super();
	}

	public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception{
		// Invoca a LPMantieneTiposSolicitud cambiando la accion = "muestraConsulta"		
		try{
			this.rastreo();
			setTrazaFichero();
			traza("> Entrando a LPConsultaTiposSolicitud.ejecucion");
			conectorAction("LPMantieneTiposSolicitud");
			conectorActionParametro("accion", "muestraConsulta");
		} catch(Exception e){
			lanzarPaginaError(e);
		}
	}
}
