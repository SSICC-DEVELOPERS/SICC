import LPSICCBase;

public class LPConsultaFlete extends LPSICCBase {

  public LPConsultaFlete() {	
		super();	
  }

  public void inicio() throws Exception {	
  }
  
  public void ejecucion() throws Exception {
  setTrazaFichero();

   try  {
		  rastreo();
		  traza("*********** Entre a LPConsultaFlete");
    	  conectorAction("LPMantieneFlete");				
		  conectorActionParametro("accion", "muestraConsulta");
		  conectorActionParametro("casoDeUso","consulta");
		  	
    }
    catch ( Exception e )  {
      traza("Exception en LPConsultaFlete");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}
