import LPSICCBase;

public class LPConsultarEjecutivos extends LPSICCBase
{
	public LPConsultarEjecutivos() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = consulta");
			conectorAction("LPEjecutivosCuenta");
			conectorActionParametro("accion", "consulta");
			conectorActionParametro("casoDeUso", "consultar");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}

}
