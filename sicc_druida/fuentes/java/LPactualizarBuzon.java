//import LPSICCBase;

public class LPactualizarBuzon extends LPSICCBase {

	public LPactualizarBuzon() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
    
		setTrazaFichero();
	    try  {
		  this.rastreo();
	      traza("*********** Entre a LPactualizarBuzon");
		  conectorAction("LPBuzon");
	      conectorActionParametro("opcionMenu", "Actualizar Buzon"); 
  	      conectorActionParametro("accion", ""); 
		}
	    catch ( Exception e )  {
		  traza("Exception en LPactualizarBuzon");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
	    }
	}
}