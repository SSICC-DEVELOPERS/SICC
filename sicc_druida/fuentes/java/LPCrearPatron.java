import LPSICCBase;

public class LPCrearPatron extends LPSICCBase {
	public LPCrearPatron() {
		super();
	}	

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			conectorAction("LPMantenimientoPatrones");
			conectorActionParametro("opcionMenu", "Crear patron");
			conectorActionParametro("accion", "");
		}
		catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}

