

public class LPBuscarEliminarMarcasTipo extends LPSICCBase {

	public LPBuscarEliminarMarcasTipo() {	super(); }
  
	public void inicio() throws Exception {	}
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      this.rastreo();
      traza("*********** Entre a LPBuscarEliminarMarcasTipo");      
      conectorAction("LPBuscarMarcasTipo");
      conectorActionParametro("casoDeUso", "eliminar");
    }
    catch ( Exception e )  {
      traza("Exception en LPBuscarEliminarMarcasTipo");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
