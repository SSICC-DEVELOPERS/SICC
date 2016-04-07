

public class LPBuscarModificarMarcasTipo extends LPSICCBase {

	public LPBuscarModificarMarcasTipo() { super();	}

	public void inicio() throws Exception {	}
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      this.rastreo();
      traza("*********** Entre a LPBuscarModificarMarcasTipo");      
      conectorAction("LPBuscarMarcasTipo");
      conectorActionParametro("casoDeUso", "modificar");
      conectorActionParametro("accion", "");
    }
    catch ( Exception e )  {
      traza("Exception en LPBuscarModificarMarcasTipo");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
