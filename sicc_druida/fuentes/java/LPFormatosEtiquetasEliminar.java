public class LPFormatosEtiquetasEliminar extends LPSICCBase {
	public LPFormatosEtiquetasEliminar() { super(); }
	public void inicio() throws Exception { }  
    public void ejecucion() throws Exception {
	    setTrazaFichero();
		try  {
			this.rastreo();
			traza("Ingreso a LPFormatosEtiquetasEliminar");
			conectorAction("LPFormatosEtiquetas");
			conectorActionParametro("accion", "eliminar"); 
		}
		catch (Exception e)  {
			traza("Exception en LPFormatosEtiquetasEliminar");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}