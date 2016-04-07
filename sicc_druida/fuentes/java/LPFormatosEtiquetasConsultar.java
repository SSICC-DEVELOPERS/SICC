public class LPFormatosEtiquetasConsultar extends LPSICCBase {
	public LPFormatosEtiquetasConsultar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPFormatosEtiquetasConsultar");
			conectorAction("LPFormatosEtiquetas");
			conectorActionParametro("accion", "consultar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPFormatosEtiquetasConsultar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}