//import LPSICCBase;

public class LPcrearBuzon extends LPSICCBase {

	public LPcrearBuzon() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
    
		setTrazaFichero();
	    try  {
		  this.rastreo();
	      traza("*********** Entre a LPcrearBuzon");
		  conectorAction("LPBuzon");
	      conectorActionParametro("opcionMenu", "Crear Buzon"); 
  	      conectorActionParametro("accion", ""); 
		}
	    catch ( Exception e )  {
		  traza("Exception en LPcrearBuzon");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
	    }
	}
}