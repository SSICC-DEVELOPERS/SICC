public class LPConsultarFuncionDistribucion extends LPSICCBase {
	public LPConsultarFuncionDistribucion() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPConsultarFuncionDistribucion");
			conectorAction("LPMantenerFuncionDistribucion");
			conectorActionParametro("accion", ""); 
			conectorActionParametro("opcionMenu", "consultar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPConsultarFuncionDistribucion");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}