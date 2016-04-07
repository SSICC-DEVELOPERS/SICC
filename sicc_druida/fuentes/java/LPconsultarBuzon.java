//import LPSICCBase;

public class LPconsultarBuzon extends LPSICCBase {

	public LPconsultarBuzon() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
    
		setTrazaFichero();
	    try  {
		  this.rastreo();
	      traza("*********** Entre a LPconsultarBuzon");
		  conectorAction("LPBuzon");
	      conectorActionParametro("opcionMenu", "ConsultarBuzon"); 
  	      conectorActionParametro("accion", ""); 
		}
	    catch ( Exception e )  {
		  traza("Exception en LPconsultarBuzon");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
	    }
	}
}