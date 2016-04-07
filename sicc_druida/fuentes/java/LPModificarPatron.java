import LPSICCBase;

public class LPModificarPatron extends LPSICCBase {
	public LPModificarPatron() {
		super();
	}	

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			conectorAction("LPMantenimientoPatrones");
			conectorActionParametro("opcionMenu", "Modificar patron");
			conectorActionParametro("accion", "");
		}
		catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
