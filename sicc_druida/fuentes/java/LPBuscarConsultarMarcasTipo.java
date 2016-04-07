

public class LPBuscarConsultarMarcasTipo extends LPSICCBase {

	public LPBuscarConsultarMarcasTipo() { super(); }

  public void inicio() throws Exception {	}

  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      this.rastreo();
      traza("*********** Entre a LPBuscarConsultarMarcasTipo");      
      conectorAction("LPBuscarMarcasTipo");
      conectorActionParametro("casoDeUso", "consultar");
      conectorActionParametro("accion", "");
      //conectorActionParametro("casoDeUso", "casoUso");
      
      
    }
    catch ( Exception e )  {
      traza("Exception en LPBuscarConsultarMarcasTipo");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
