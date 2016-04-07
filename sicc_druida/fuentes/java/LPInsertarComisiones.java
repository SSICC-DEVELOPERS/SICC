public class LPInsertarComisiones extends LPSICCBase {
	public LPInsertarComisiones() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPInsertarComisiones");
			conectorAction("LPMantenimientoComisiones");
			conectorActionParametro("accion", "InsertarComisiones"); 
		}
		catch ( Exception e )  {
			traza("Exception en LPInsertarComisiones");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}