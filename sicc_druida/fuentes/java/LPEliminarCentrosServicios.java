public class LPEliminarCentrosServicios extends LPSICCBase
{
	public LPEliminarCentrosServicios() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception  {   
		setTrazaFichero();
	    traza("*** Entrada - LPEliminarCentrosServicios() - ejecucion ***");
		
		try {
			rastreo();
			traza("caso de uso = eliminar");

			traza("*** llamando a 'LPCentrosServicios'");
			conectorAction("LPCentrosServicios");

            conectorActionParametro("accion","eliminar");		
			conectorActionParametro("casoDeUso", "eliminar");
		} catch ( Exception e ) {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
		traza("*** Salida - LPEliminarCentrosServicios() - ejecucion ***");
	}
}