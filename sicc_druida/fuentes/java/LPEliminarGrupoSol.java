import LPSICCBase;

public class LPEliminarGrupoSol extends LPSICCBase{
	public LPEliminarGrupoSol() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = elimina");
			conectorAction("LPGrupoSolicitud");
			conectorActionParametro("casoDeUso", "elimina");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}