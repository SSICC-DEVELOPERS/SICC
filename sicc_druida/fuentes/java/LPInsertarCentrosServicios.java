public class LPInsertarCentrosServicios extends LPSICCBase
{
	public LPInsertarCentrosServicios() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception  {   
		setTrazaFichero();
	    traza("*** Entrada - LPInsertarCentrosServicios() - ejecucion ***");
		
		try {
			rastreo();
			traza("caso de uso = insertar");

			traza("*** llamando a 'LPCentrosServicios'");
			conectorAction("LPCentrosServicios");

			conectorActionParametro("accion","insertar");		
			conectorActionParametro("casoDeUso", "insertar" );
		} catch ( Exception e ) {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
		traza("*** Salida - LPInsertarCentrosServicios() - ejecucion ***");
	}
}