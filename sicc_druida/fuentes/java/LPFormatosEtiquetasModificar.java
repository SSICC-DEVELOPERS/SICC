public class LPFormatosEtiquetasModificar extends LPSICCBase {
	public LPFormatosEtiquetasModificar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPFormatosEtiquetasModificar");
			conectorAction("LPFormatosEtiquetas");
			conectorActionParametro("accion", "modificar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPFormatosEtiquetasModificar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}