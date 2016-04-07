//import LPSICCBase;

public class LPredirigirBuzon extends LPSICCBase {

	public LPredirigirBuzon() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
    
		setTrazaFichero();
	    try  {
		  this.rastreo();
	      traza("*********** Entre a LPredirigirBuzon");
		  conectorAction("LPBuzon");
	      conectorActionParametro("opcionMenu", "Redirigir Buzon"); 
  	      conectorActionParametro("accion", ""); 
		}
	    catch ( Exception e )  {
		  traza("Exception en LPredirigirBuzon");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
	    }
	}
}