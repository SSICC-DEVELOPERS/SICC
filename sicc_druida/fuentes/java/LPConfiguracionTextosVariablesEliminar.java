public class LPConfiguracionTextosVariablesEliminar extends LPSICCBase {
	public LPConfiguracionTextosVariablesEliminar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPConfiguracionTextosVariablesEliminar");
			conectorAction("LPConfiguracionTextosVariables");
			conectorActionParametro("accion", "eliminar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPConfiguracionTextosVariablesEliminar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}