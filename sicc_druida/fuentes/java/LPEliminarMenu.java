//import LPSICCBase;

public class LPEliminarMenu extends LPSICCBase {

    private  String nombreLogica="LPEliminarMenu";
    
	  // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
		try{	

		rastreo();
		//Pasa el control a la LPSeleccionarElementoMenu 
	      conectorAction("LPSeleccionarElementoMenu");
		  //indicandole que el caso de uso es eliminar  
		  conectorActionParametro("CasoUso", "eliminar");
		  this.traza(this.nombreLogica+" ok------------------");	
		}catch (Exception ex){
			   this.lanzarPaginaError(ex);

		}
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
		this.setTrazaFichero();
    
    }
  
 
}
