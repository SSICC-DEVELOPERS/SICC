public class LPGeneracionMapaCentroDistribucion extends LPSICCBase {
	public LPGeneracionMapaCentroDistribucion() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPGeneracionMapaCentroDistribucion");
			conectorAction("LPMantenimientoMapaCentroDistribucion");
			conectorActionParametro("accion", ""); 
			conectorActionParametro("opcionMenu", "generar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPGeneracionMapaCentroDistribucion");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}