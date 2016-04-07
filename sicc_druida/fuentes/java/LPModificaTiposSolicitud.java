/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       13/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */

public class LPModificaTiposSolicitud extends LPSICCBase{
	public LPModificaTiposSolicitud(){
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_tipo_solicitud_buscar");
	}
	
	public void ejecucion() throws Exception{
		// Invoca a LPMantieneTiposSolicitud cambiando la accion = "muestraModificacion"
		this.rastreo();
		setTrazaFichero();
		traza("> Entrando a LPModificaTiposSolicitud.ejecucion");
		try{
			conectorAction("LPMantieneTiposSolicitud");
			conectorActionParametro("accion", "muestraModificacion");
		} catch(Exception e){
			lanzarPaginaError(e);
		}
	}
}
