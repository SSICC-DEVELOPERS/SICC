/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       13/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */


public class LPInsertaTiposSolicitud extends LPSICCBase{
	public LPInsertaTiposSolicitud(){
		super();
	}

	public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception{
		// Invoca a LPMantieneTiposSolicitud cambiando la accion = "muestraInsercion"
		try{
			this.rastreo();
			setTrazaFichero();
			traza("> Entrando a LPInsertaTiposSolicitud.ejecucion");
			conectorAction("LPMantieneTiposSolicitud");
			conectorActionParametro("accion", "muestraInsercion");
		} catch(Exception e){
			lanzarPaginaError(e);
		}
	}
}
