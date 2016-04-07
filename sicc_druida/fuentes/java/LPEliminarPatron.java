
public class LPEliminarPatron extends LPSICCBase {
	public LPEliminarPatron() {
		super();
	}	

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			conectorAction("LPMantenimientoPatrones");
			conectorActionParametro("opcionMenu", "Eliminar patron");
			conectorActionParametro("accion", "");
		}
		catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
