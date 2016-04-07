import LPSICCBase;

public class LPInsertarGrupoSol extends LPSICCBase{
	public LPInsertarGrupoSol() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = inserta");
			conectorAction("LPGrupoSolicitud");
			conectorActionParametro("casoDeUso", "inserta");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
