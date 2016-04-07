import LPSICCBase;

public class LPConsultarMenu extends LPSICCBase {
  String accion="";
  protected boolean throwsException = true;
  private  String nombreLogica="LPConsultarMenu";

  public void inicio() throws Exception {
    this.setTrazaFichero();    
  }
    
  public void ejecucion() throws Exception {
    traza("*** Entre a LPConsultarMenu");
    rastreo();
      try{	        
        if (this.accion.equals("")) 
          this.accion = "defaultAction";
   
        this.afterActionExecute();			
      }
      catch (Exception ex){
        if (this.accion.equals("defaultAction")) 
          this.accion = "";
        if (this.throwsException)	
          this.lanzarPaginaError(ex);
        else 
          throw ex;
      }
    }  
  
  protected void afterActionExecute() throws Exception {
	  if (this.accion.equals("defaultAction")) {
      this.accion = "";	  	
      traza("*** Llamando a LPSeleccionarElementoMenu");  
      conectorAction("LPSeleccionarElementoMenu");
      conectorActionParametro("CasoUso", "Consultar");
		}
	}
}
