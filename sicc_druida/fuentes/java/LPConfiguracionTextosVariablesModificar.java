public class LPConfiguracionTextosVariablesModificar extends LPSICCBase {
	public LPConfiguracionTextosVariablesModificar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPConfiguracionTextosVariablesModificar");
			conectorAction("LPConfiguracionTextosVariables");
			conectorActionParametro("accion", "modificar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPConfiguracionTextosVariablesModificar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}