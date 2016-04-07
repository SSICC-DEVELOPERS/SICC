import LPSICCBase;

public class LPEliminaFlete extends LPSICCBase {

  public LPEliminaFlete() {	
		super();	
  }

  public void inicio() throws Exception {	
  }
  
  public void ejecucion() throws Exception {

    setTrazaFichero();
	String accion     = conectorParametroLimpia("accion", "", true);

	try {
		  rastreo();
		  traza("*********** Entre a LPEliminaFlete");

		  if (accion.equals("")){
		 	conectorAction("LPMantieneFlete");				
		    conectorActionParametro("accion", "muestraBorrado");
			conectorActionParametro("casoDeUso","elimina");
		 }

    }
    catch ( Exception e )  {
      traza("Exception en LPEliminaFlete");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
