public class LPSimulacionMensajes extends LPSICCBase {

	public LPSimulacionMensajes() {	
		super(); 
	}
  
	public void inicio() throws Exception {	
	}
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      traza("*********** Entre a LPSimulacionMensajes");      
     conectorAction("LPConsultarMensajes");	
	  conectorActionParametro("casoDeUso","Simulacion Mensajes");
	  conectorActionParametro("accion", "");   
	  conectorActionParametro("LP", "LPSimulacionMensajes");
    }
    catch ( Exception e )  {
      traza("Exception en LPSimulacionMensajes");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
