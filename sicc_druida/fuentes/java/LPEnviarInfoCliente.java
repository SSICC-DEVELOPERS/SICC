public class LPEnviarInfoCliente extends LPSICCBase {

	public LPEnviarInfoCliente() {	
		super(); 
	}
  
	public void inicio() throws Exception {	
	}
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    
    try{
      traza("*********** Entre a LPEnviarInfoCliente");      
      conectorAction("LPGIS");	
     // conectorActionParametro("casoDeUso","Consulta Mensajes por Consultora");
      conectorActionParametro("accion", "");	
    }
    catch ( Exception e )  {
      traza("Exception en LPEnviarInfoCliente");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
  
  
}
