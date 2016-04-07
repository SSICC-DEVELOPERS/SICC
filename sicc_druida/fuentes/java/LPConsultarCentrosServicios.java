public class LPConsultarCentrosServicios extends LPSICCBase
{
	public LPConsultarCentrosServicios() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception  {   
		setTrazaFichero();
	    traza("*** Entrada - LPConsultarCentrosServicios() - ejecucion ***");
		
		try {
			rastreo();
			traza("caso de uso = consultar");

			traza("*** llamando a 'LPCentrosServicios'");
			conectorAction("LPCentrosServicios");

            conectorActionParametro("accion","consultar");		
			conectorActionParametro("casoDeUso", "consultar");
		} catch ( Exception e ) {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
		traza("*** Salida - LPConsultarCentrosServicios() - ejecucion ***");
	}
}