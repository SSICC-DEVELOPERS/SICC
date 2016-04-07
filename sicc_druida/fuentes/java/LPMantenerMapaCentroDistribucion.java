public class LPMantenerMapaCentroDistribucion extends LPSICCBase {
	public LPMantenerMapaCentroDistribucion() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPMantenerMapaCentroDistribucion");
			conectorAction("LPMantenimientoMapaCentroDistribucion");
			conectorActionParametro("accion", ""); 
			conectorActionParametro("opcionMenu", "mantener"); 
		}
		catch (Exception e)  {
			traza("Exception en LPMantenerMapaCentroDistribucion");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}