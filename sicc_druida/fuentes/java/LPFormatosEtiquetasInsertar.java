public class LPFormatosEtiquetasInsertar extends LPSICCBase {
	public LPFormatosEtiquetasInsertar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPFormatosEtiquetasInsertar");
			conectorAction("LPFormatosEtiquetas");
			conectorActionParametro("accion", "insertar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPFormatosEtiquetasInsertar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}