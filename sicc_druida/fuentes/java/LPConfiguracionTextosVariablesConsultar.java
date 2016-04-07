public class LPConfiguracionTextosVariablesConsultar extends LPSICCBase {
	public LPConfiguracionTextosVariablesConsultar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPConfiguracionTextosVariablesConsultar");
			conectorAction("LPConfiguracionTextosVariables");
			conectorActionParametro("accion", "consultar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPConfiguracionTextosVariablesConsultar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}