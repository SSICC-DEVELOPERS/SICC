import LPSICCBase;

public class LPModificarEjecutivos extends LPSICCBase
{
	public LPModificarEjecutivos() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = modifica");
			conectorAction("LPEjecutivosCuenta");
			conectorActionParametro("accion", "modifica");
			conectorActionParametro("casoDeUso", "modificar");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
