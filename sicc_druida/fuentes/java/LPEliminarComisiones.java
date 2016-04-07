public class LPEliminarComisiones extends LPSICCBase {
	public LPEliminarComisiones() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPEliminarComisiones");
			conectorAction("LPMantenimientoComisiones");
			conectorActionParametro("accion", "EliminarComisiones"); 
		}
		catch ( Exception e )  {
			traza("Exception en LPEliminarComisiones");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}