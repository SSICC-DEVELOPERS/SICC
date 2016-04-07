public class LPCopiarComisiones extends LPSICCBase {
	public LPCopiarComisiones() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPCopiarComisiones");
			conectorAction("LPMantenimientoComisiones");
			conectorActionParametro("accion", "CopiarComisiones"); 
		}
		catch ( Exception e )  {
			traza("Exception en LPCopiarComisiones");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}