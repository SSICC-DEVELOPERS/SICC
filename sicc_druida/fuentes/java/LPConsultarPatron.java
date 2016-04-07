import LPSICCBase;

public class LPConsultarPatron extends LPSICCBase {
	public LPConsultarPatron() {
		super();
	}	

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			conectorAction("LPMantenimientoPatrones");
			conectorActionParametro("opcionMenu", "Consultar patron");
			conectorActionParametro("accion", "");
		}
		catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
