
public class LPModificaFlete extends LPSICCBase {

  public LPModificaFlete() {	
	super();	
   }

  public void inicio() throws Exception {	
  }
  
  public void ejecucion() throws Exception {

    setTrazaFichero();

	String accion     = conectorParametroLimpia("accion", "", true);

	try {
		  this.rastreo();
		  traza("*********** Entre a LPModificaFlete");

		  if (accion.equals("")){
		 	conectorAction("LPMantieneFlete");				
		    conectorActionParametro("accion", "muestraModificacion");
			conectorActionParametro("casoDeUso","modifica");
		 }

    }
    catch ( Exception e )  {
      traza("Exception en LPModificaFlete");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
