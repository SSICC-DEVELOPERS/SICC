public class LPCopiarMapaCentroDistribucion extends LPSICCBase {
	public LPCopiarMapaCentroDistribucion() { super(); }
    public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
		setTrazaFichero();
        try  {
			this.rastreo();
            traza("Ingreso a LPCopiarMapaCentroDistribucion");
            conectorAction("LPMantenimientoMapaCentroDistribucion");
            conectorActionParametro("accion", ""); 
            conectorActionParametro("opcionMenu", "copiar"); 
         }
         catch (Exception e)  {
			traza("Exception en LPCopiarMapaCentroDistribucion");
            e.printStackTrace();     
            lanzarPaginaError(e);
         }
    }
}
