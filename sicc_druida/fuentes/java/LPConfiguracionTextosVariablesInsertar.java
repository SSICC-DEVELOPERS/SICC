public class LPConfiguracionTextosVariablesInsertar extends LPSICCBase {
	public LPConfiguracionTextosVariablesInsertar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPConfiguracionTextosVariablesInsertar");
			conectorAction("LPConfiguracionTextosVariables");
			conectorActionParametro("accion", "insertar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPConfiguracionTextosVariablesInsertar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}