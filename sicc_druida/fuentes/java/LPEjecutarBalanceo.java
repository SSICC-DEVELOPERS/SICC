public class LPEjecutarBalanceo extends LPSICCBase {
	public LPEjecutarBalanceo() { super(); }
    public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
		setTrazaFichero();
        try  {
			this.rastreo();
            traza("Ingreso a LPEjecutarBalanceo");
            conectorAction("LPMantenerBalanceo");
            conectorActionParametro("accion", ""); 
            conectorActionParametro("opcionMenu", "ejecutar"); 
        }
        catch (Exception e)  {
			traza("Exception en LPEjecutarBalanceo");
            e.printStackTrace();     
            lanzarPaginaError(e);
        }
	}
}