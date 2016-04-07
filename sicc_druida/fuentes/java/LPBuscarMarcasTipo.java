

public class LPBuscarMarcasTipo extends LPSICCBase {

	public LPBuscarMarcasTipo() {	super(); }
  
	public void inicio() throws Exception {	}
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      
      traza("*********** Entre a LPBuscarMarcasTipo");
      String mCasoDeUso = conectorParametroLimpia("casoDeUso","",true);
      conectorAction("LPMarcasTipo");
      conectorActionParametro("casoDeUso", mCasoDeUso);
      
      
    }
    catch ( Exception e )  {
      traza("Exception en LPBuscarMarcasTipo");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
