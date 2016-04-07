public class LPConsultarComisiones extends LPSICCBase {
	public LPConsultarComisiones() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPConsultarComisiones");
			conectorAction("LPMantenimientoComisiones");
			conectorActionParametro("accion", "ConsultarComisiones"); 
		}
		catch ( Exception e )  {
			traza("Exception en LPConsultarComisiones");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}