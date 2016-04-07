import LPSICCBase;

public class LPInsertaFlete extends LPSICCBase {

  public LPInsertaFlete() {	
		super();	
  }

  public void inicio() throws Exception {	
  }
  
  public void ejecucion() throws Exception {
	setTrazaFichero();
	String accion     = conectorParametroLimpia("accion", "", true);


	try {
		  rastreo();
		  traza("*********** Entre a LPInsertaFlete");

		  if (accion.equals("")){
		 	conectorAction("LPMantieneFlete");				
		    conectorActionParametro("accion", "muestraInsercion");
			conectorActionParametro("casoDeUso","insertar");	
		 }

    }
    catch ( Exception e )  {
      traza("Exception en LPInsertaFlete");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
