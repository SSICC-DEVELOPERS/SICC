

public class LPInsertarMarcasTipo extends LPSICCBase {

	public LPInsertarMarcasTipo() {	super();	}

	public void inicio() throws Exception {	}
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      this.rastreo();
      traza("*********** Entre a LPInsertarMarcasTipo");
      conectorAction("LPMarcasTipo");
      conectorActionParametro("casoDeUso", "insertar"); 
    }
    catch ( Exception e )  {
      traza("Exception en LPInsertarMarcasTipo");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
