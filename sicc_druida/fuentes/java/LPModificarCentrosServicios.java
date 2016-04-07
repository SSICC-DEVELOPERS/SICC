public class LPModificarCentrosServicios extends LPSICCBase
{
	public LPModificarCentrosServicios() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception  {   
		setTrazaFichero();
	    traza("*** Entrada - LPModificarCentrosServicios() - ejecucion ***");
		
		try {
			rastreo();
			traza("caso de uso = modificar");

			traza("*** llamando a 'LPCentrosServicios'");
			conectorAction("LPCentrosServicios");

            conectorActionParametro("accion","modificar");		
			conectorActionParametro("casoDeUso", "modificar");
		} catch ( Exception e ) {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
		traza("*** Salida - LPModificarCentrosServicios() - ejecucion ***");
	}
}