import LPSICCBase;

public class LPBusquedaCambiarEstatus extends LPSICCBase {

	public LPBusquedaCambiarEstatus() {
		super();
	}


	public void inicio() throws Exception {

	}
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      rastreo();
      traza("Caso de Uso = Cambiar Estatus");
      conectorAction("LPBusquedaCliente");
      conectorActionParametro("casoDeUso", "cambiar");
    }
    catch ( Exception e )  {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}