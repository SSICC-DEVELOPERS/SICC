//import LPSICCBase;

public class LPBusquedaConsultarCliente extends LPSICCBase {

	public LPBusquedaConsultarCliente() {
		super();
	}


	public void inicio() throws Exception {

	}
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      rastreo();
      traza("Caso de Uso = Consultar");
      conectorAction("LPBusquedaCliente");
      conectorActionParametro("casoDeUso", "consultar");
    }
    catch ( Exception e )  {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}