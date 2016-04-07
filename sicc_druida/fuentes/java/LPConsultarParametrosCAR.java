import LPSICCBase;

public class LPConsultarParametrosCAR extends LPSICCBase{
	public LPConsultarParametrosCAR() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = consulta");
			conectorAction("LPParametrosCAR");
			conectorActionParametro("accion", "consulta");
      conectorActionParametro("casoDeUso", "consultar");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
