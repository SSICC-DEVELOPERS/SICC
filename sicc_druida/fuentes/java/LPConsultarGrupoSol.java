import LPSICCBase;

public class LPConsultarGrupoSol extends LPSICCBase{
	public LPConsultarGrupoSol() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = consulta");
			conectorAction("LPGrupoSolicitud");
			conectorActionParametro("casoDeUso", "consulta");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}