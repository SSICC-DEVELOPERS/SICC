//import LPSICCBase;

public class LPModificarMenu extends LPSICCBase {
    String accion="";
  	protected boolean throwsException = true;
    private  String nombreLogica="LPModificarMenu";
    
	  // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
		try{	
	        
			if (this.accion.equals("")) 
				this.accion = "defaultAction";
   
    	this.afterActionExecute();
			
		}catch (Exception ex){
			if (this.accion.equals("defaultAction")) 
				this.accion = "";
			if (this.throwsException)	
			   this.lanzarPaginaError(ex);
			else 
				 throw ex;
		}
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
		this.setTrazaFichero();
		rastreo();

    traza("inicio en LPModificarMenu");
    
    }
  
  	protected void afterActionExecute() throws Exception {
	  if (this.accion.equals("defaultAction")) {
  		this.accion = "";
	  	
      traza("voy a LPSeleccionarElementoMenu");
      
      conectorAction("LPSeleccionarElementoMenu");
      conectorActionParametro("CasoUso", "Modificar");
		  }
	  }
 
}
