import LPSICCBase;

public class LPModificarParametrosCAR extends LPSICCBase{
	public LPModificarParametrosCAR() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = modifica");
			conectorAction("LPParametrosCAR");
			conectorActionParametro("accion", "modifica");
      conectorActionParametro("casoDeUso", "modificar");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
