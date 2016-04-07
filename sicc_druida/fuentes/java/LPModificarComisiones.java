public class LPModificarComisiones extends LPSICCBase {
	public LPModificarComisiones() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPModificarComisiones");
			conectorAction("LPMantenimientoComisiones");
			conectorActionParametro("accion", "ModificarComisiones"); 
		}
		catch ( Exception e )  {
			traza("Exception en LPModificarComisiones");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}