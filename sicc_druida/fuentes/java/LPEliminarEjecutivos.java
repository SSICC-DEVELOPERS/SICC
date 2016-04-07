import LPSICCBase;

public class LPEliminarEjecutivos extends LPSICCBase
{
	public LPEliminarEjecutivos() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = elimina");
			conectorAction("LPEjecutivosCuenta");
			conectorActionParametro("accion", "elimina");
			conectorActionParametro("casoDeUso", "eliminar");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}

}
