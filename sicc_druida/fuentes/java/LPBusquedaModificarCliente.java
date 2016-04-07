import LPSICCBase;

public class LPBusquedaModificarCliente extends LPSICCBase {

	public LPBusquedaModificarCliente() {
		super();
	}


	public void inicio() throws Exception {

	}
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      rastreo();
      traza("Caso de Uso = Modificar");
      conectorAction("LPBusquedaCliente");
      conectorActionParametro("casoDeUso", "modificar");
    }
    catch ( Exception e )  {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}