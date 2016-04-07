import LPSICCBase;

public class LPModificarGrupoSol extends LPSICCBase{
	public LPModificarGrupoSol() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = modifica");
			conectorAction("LPGrupoSolicitud");
			conectorActionParametro("casoDeUso", "modifica");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
