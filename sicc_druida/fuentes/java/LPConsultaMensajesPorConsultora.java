
public class LPConsultaMensajesPorConsultora extends LPSICCBase {

	public LPConsultaMensajesPorConsultora() {	
		super(); 
	}
  
	public void inicio() throws Exception {	
	}
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      traza("*********** Entre a LPConsultaMensajesPorConsultora");      
      conectorAction("LPConsultarMensajes");	
	  conectorActionParametro("casoDeUso","Consulta Mensajes por Consultora");
	   conectorActionParametro("LP", "LPConsultaMensajesPorConsultora");
	  conectorActionParametro("accion", "");	
    }
    catch ( Exception e )  {
      traza("Exception en LPConsultaMensajesPorConsultora");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
